package in.ishankhanna.notifshredder.provider.installedapplication;

import android.net.Uri;
import android.provider.BaseColumns;

import in.ishankhanna.notifshredder.provider.InstalledApplicationProvider;
import in.ishankhanna.notifshredder.provider.installedapplication.InstalledapplicationColumns;

/**
 * An installed application on the phone.
 */
public class InstalledapplicationColumns implements BaseColumns {
    public static final String TABLE_NAME = "installedapplication";
    public static final Uri CONTENT_URI = Uri.parse(InstalledApplicationProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Name of the app.
     */
    public static final String NAME = "name";

    /**
     * Package name of the app.
     */
    public static final String PACKAGE_NAME = "package_name";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            PACKAGE_NAME
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(PACKAGE_NAME) || c.contains("." + PACKAGE_NAME)) return true;
        }
        return false;
    }

}
