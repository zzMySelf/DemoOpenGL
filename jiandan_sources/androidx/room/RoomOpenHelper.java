package androidx.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    @Nullable
    public DatabaseConfiguration mConfiguration;
    @NonNull
    public final Delegate mDelegate;
    @NonNull
    public final String mIdentityHash;
    @NonNull
    public final String mLegacyHash;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {
        public final int version;

        public Delegate(int i2) {
            this.version = i2;
        }

        public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @NonNull
        public ValidationResult onValidateSchema(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, (String) null);
        }

        @Deprecated
        public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {
        @Nullable
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z, @Nullable String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration, @NonNull Delegate delegate, @NonNull String str, @NonNull String str2) {
        super(delegate.version);
        this.mConfiguration = databaseConfiguration;
        this.mDelegate = delegate;
        this.mIdentityHash = str;
        this.mLegacyHash = str2;
    }

    /* JADX INFO: finally extract failed */
    private void checkIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (hasRoomMasterTable(supportSQLiteDatabase)) {
            String str = null;
            Cursor query = supportSQLiteDatabase.query((SupportSQLiteQuery) new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
            try {
                if (query.moveToFirst()) {
                    str = query.getString(0);
                }
                query.close();
                if (!this.mIdentityHash.equals(str) && !this.mLegacyHash.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
            } catch (Throwable th2) {
                query.close();
                throw th2;
            }
        } else {
            ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
            if (onValidateSchema.isValid) {
                this.mDelegate.onPostMigrate(supportSQLiteDatabase);
                updateIdentity(supportSQLiteDatabase);
                return;
            }
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
        }
    }

    private void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    public static boolean hasEmptySchema(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor query = supportSQLiteDatabase.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (query.moveToFirst() && query.getInt(0) == 0) {
                z = true;
            }
            return z;
        } finally {
            query.close();
        }
    }

    public static boolean hasRoomMasterTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor query = supportSQLiteDatabase.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (query.moveToFirst() && query.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            query.close();
        }
    }

    private void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.mIdentityHash));
    }

    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onConfigure(supportSQLiteDatabase);
    }

    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean hasEmptySchema = hasEmptySchema(supportSQLiteDatabase);
        this.mDelegate.createAllTables(supportSQLiteDatabase);
        if (!hasEmptySchema) {
            ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(supportSQLiteDatabase);
        this.mDelegate.onCreate(supportSQLiteDatabase);
    }

    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
        onUpgrade(supportSQLiteDatabase, i2, i3);
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onOpen(supportSQLiteDatabase);
        checkIdentity(supportSQLiteDatabase);
        this.mDelegate.onOpen(supportSQLiteDatabase);
        this.mConfiguration = null;
    }

    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
        boolean z;
        List<Migration> findMigrationPath;
        DatabaseConfiguration databaseConfiguration = this.mConfiguration;
        if (databaseConfiguration == null || (findMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i2, i3)) == null) {
            z = false;
        } else {
            this.mDelegate.onPreMigrate(supportSQLiteDatabase);
            for (Migration migrate : findMigrationPath) {
                migrate.migrate(supportSQLiteDatabase);
            }
            ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
            if (onValidateSchema.isValid) {
                this.mDelegate.onPostMigrate(supportSQLiteDatabase);
                updateIdentity(supportSQLiteDatabase);
                z = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg);
            }
        }
        if (!z) {
            DatabaseConfiguration databaseConfiguration2 = this.mConfiguration;
            if (databaseConfiguration2 == null || databaseConfiguration2.isMigrationRequired(i2, i3)) {
                throw new IllegalStateException("A migration from " + i2 + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.mDelegate.dropAllTables(supportSQLiteDatabase);
            this.mDelegate.createAllTables(supportSQLiteDatabase);
        }
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration, @NonNull Delegate delegate, @NonNull String str) {
        this(databaseConfiguration, delegate, "", str);
    }
}
