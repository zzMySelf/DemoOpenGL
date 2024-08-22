package fe.fe.vvv.ad.qw;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public class de implements Cursor {

    /* renamed from: ad  reason: collision with root package name */
    public Bundle f3161ad;

    public de(Bundle bundle) {
        this.f3161ad = bundle;
    }

    public void close() {
    }

    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
    }

    public void deactivate() {
    }

    public byte[] getBlob(int i2) {
        return new byte[0];
    }

    public int getColumnCount() {
        return 0;
    }

    public int getColumnIndex(String str) {
        return 0;
    }

    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        return 0;
    }

    public String getColumnName(int i2) {
        return null;
    }

    public String[] getColumnNames() {
        return new String[0];
    }

    public int getCount() {
        return 0;
    }

    public double getDouble(int i2) {
        return 0.0d;
    }

    public Bundle getExtras() {
        return this.f3161ad;
    }

    public float getFloat(int i2) {
        return 0.0f;
    }

    public int getInt(int i2) {
        return 0;
    }

    public long getLong(int i2) {
        return 0;
    }

    public Uri getNotificationUri() {
        return null;
    }

    public int getPosition() {
        return 0;
    }

    public short getShort(int i2) {
        return 0;
    }

    public String getString(int i2) {
        return null;
    }

    public int getType(int i2) {
        return 0;
    }

    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    public boolean isAfterLast() {
        return false;
    }

    public boolean isBeforeFirst() {
        return false;
    }

    public boolean isClosed() {
        return false;
    }

    public boolean isFirst() {
        return false;
    }

    public boolean isLast() {
        return false;
    }

    public boolean isNull(int i2) {
        return false;
    }

    public boolean move(int i2) {
        return false;
    }

    public boolean moveToFirst() {
        return false;
    }

    public boolean moveToLast() {
        return false;
    }

    public boolean moveToNext() {
        return false;
    }

    public boolean moveToPosition(int i2) {
        return false;
    }

    public boolean moveToPrevious() {
        return false;
    }

    public void registerContentObserver(ContentObserver contentObserver) {
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public boolean requery() {
        return false;
    }

    public Bundle respond(Bundle bundle) {
        return null;
    }

    public void setExtras(Bundle bundle) {
        this.f3161ad = bundle;
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
