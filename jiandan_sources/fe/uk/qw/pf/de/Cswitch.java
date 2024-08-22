package fe.uk.qw.pf.de;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: fe.uk.qw.pf.de.switch  reason: invalid class name */
public class Cswitch extends o<InputStream> {

    /* renamed from: uk  reason: collision with root package name */
    public static final UriMatcher f5701uk;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f5701uk = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f5701uk.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f5701uk.addURI("com.android.contacts", "contacts/#/photo", 2);
        f5701uk.addURI("com.android.contacts", "contacts/#", 3);
        f5701uk.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f5701uk.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public Cswitch(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public final InputStream i(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f5701uk.match(uri);
        if (match != 1) {
            if (match == 3) {
                return o(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return o(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    public final InputStream o(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @NonNull
    public Class<InputStream> qw() {
        return InputStream.class;
    }

    /* renamed from: uk */
    public InputStream rg(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream i2 = i(uri, contentResolver);
        if (i2 != null) {
            return i2;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    /* renamed from: yj */
    public void de(InputStream inputStream) throws IOException {
        inputStream.close();
    }
}
