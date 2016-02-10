package in.ishankhanna.notifshredder.provider.installedapplication;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import in.ishankhanna.notifshredder.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code installedapplication} table.
 */
public class InstalledapplicationCursor extends AbstractCursor implements InstalledapplicationModel {
    public InstalledapplicationCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(InstalledapplicationColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Name of the app.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(InstalledapplicationColumns.NAME);
        return res;
    }

    /**
     * Package name of the app.
     * Can be {@code null}.
     */
    @Nullable
    public String getPackageName() {
        String res = getStringOrNull(InstalledapplicationColumns.PACKAGE_NAME);
        return res;
    }
}
