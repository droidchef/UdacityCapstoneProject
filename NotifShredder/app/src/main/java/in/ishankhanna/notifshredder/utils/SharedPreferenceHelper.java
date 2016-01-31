package in.ishankhanna.notifshredder.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ishan on 01/02/16.
 */
public class SharedPreferenceHelper {


    public static final String IS_FIRST_TIME = "IS_FIRST_TIME";
    public static final String BLOCKED_APP_NAMES = "BLOCKED_APP_NAMES";

    private static SharedPreferenceHelper instance;
    private SharedPreferences sharedPreferences;

    private SharedPreferenceHelper (Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferenceHelper getInstance(Context context){

        if (instance == null) {
            instance = new SharedPreferenceHelper(context);
        }
        return instance;
    }

    public boolean isAppStartingFirstTime() {
        return sharedPreferences.getBoolean(IS_FIRST_TIME, true);
    }

    public void setFirstTimePreferenceAsFalse() {
        writeBoolean(IS_FIRST_TIME, false);
    }

    private void writeString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    private void writeInteger(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();

    }

    private void writeLong(String key, long value) {
        sharedPreferences.edit().putLong(key, value).apply();
    }

    private void writeBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();

    }

    public void blockApp(String appName) {

        List<String> blockedAppNamesList = getBlockedApps();
        blockedAppNamesList.add(appName);
        updateBlockedAppNameCSV(blockedAppNamesList);
    }

    public void unBlockApp(String appName) {

        List<String> blockedAppNamesList = getBlockedApps();
        blockedAppNamesList.remove(appName);
        updateBlockedAppNameCSV(blockedAppNamesList);

    }

    public void updateBlockedAppNameCSV(List<String> blockedAppNameList) {

        StringBuilder blockedAppNamesCSBBuilder = new StringBuilder();

        for (int i=0;i<blockedAppNameList.size();i++) {
            blockedAppNamesCSBBuilder.append(blockedAppNameList.get(i));
            if (i != blockedAppNameList.size()-1) {
                blockedAppNamesCSBBuilder.append(",");
            }
        }

        writeString(BLOCKED_APP_NAMES, blockedAppNamesCSBBuilder.toString());
        Log.d("Block List Update", blockedAppNamesCSBBuilder.toString());
    }

    public List<String> getBlockedApps() {

        String blockedAppNamesCSV = sharedPreferences.getString(BLOCKED_APP_NAMES, null);

        if (blockedAppNamesCSV != null && !blockedAppNamesCSV.equals("")) {
            return new ArrayList<>(Arrays.asList(blockedAppNamesCSV.split(",")));
        } else {
            return new ArrayList<>();
        }

    }

    public boolean isBlocked(String appName) {

        String blockedAppNamesCSV = sharedPreferences.getString(BLOCKED_APP_NAMES, null);

        return blockedAppNamesCSV != null && blockedAppNamesCSV.contains(appName);

    }

    public void toggleBlockForAppName(String appName) {

        if (isBlocked(appName)) {
            unBlockApp(appName);
        } else {
            blockApp(appName);
        }

    }

}
