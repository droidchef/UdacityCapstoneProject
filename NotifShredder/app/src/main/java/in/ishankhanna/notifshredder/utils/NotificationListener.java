package in.ishankhanna.notifshredder.utils;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

/**
 * Created by ishan on 01/02/16.
 */
public class NotificationListener extends NotificationListenerService {

    SharedPreferenceHelper sharedPreferenceHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferenceHelper = SharedPreferenceHelper.getInstance(getApplicationContext());
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);

        String packageName = sbn.getPackageName();
        Log.d("ShredderService", packageName);
        if (sharedPreferenceHelper.isBlocked(packageName)) {
            cancelNotification(sbn.getKey());
            sharedPreferenceHelper.incrementBlockedNotificationCount();
            Log.d("ShredderService", packageName + "will be canceled");
        }

    }
}
