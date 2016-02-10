package in.ishankhanna.notifshredder.provider.installedapplication;

import in.ishankhanna.notifshredder.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * An installed application on the phone.
 */
public interface InstalledapplicationModel extends BaseModel {

    /**
     * Name of the app.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Package name of the app.
     * Can be {@code null}.
     */
    @Nullable
    String getPackageName();
}
