package in.ishankhanna.notifshredder.provider.installedapplication;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import in.ishankhanna.notifshredder.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code installedapplication} table.
 */
public class InstalledapplicationContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return InstalledapplicationColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable InstalledapplicationSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable InstalledapplicationSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Name of the app.
     */
    public InstalledapplicationContentValues putName(@Nullable String value) {
        mContentValues.put(InstalledapplicationColumns.NAME, value);
        return this;
    }

    public InstalledapplicationContentValues putNameNull() {
        mContentValues.putNull(InstalledapplicationColumns.NAME);
        return this;
    }

    /**
     * Package name of the app.
     */
    public InstalledapplicationContentValues putPackageName(@Nullable String value) {
        mContentValues.put(InstalledapplicationColumns.PACKAGE_NAME, value);
        return this;
    }

    public InstalledapplicationContentValues putPackageNameNull() {
        mContentValues.putNull(InstalledapplicationColumns.PACKAGE_NAME);
        return this;
    }
}
