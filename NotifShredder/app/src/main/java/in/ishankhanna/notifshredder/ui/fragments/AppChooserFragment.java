package in.ishankhanna.notifshredder.ui.fragments;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import in.ishankhanna.notifshredder.R;
import in.ishankhanna.notifshredder.provider.installedapplication.InstalledapplicationColumns;
import in.ishankhanna.notifshredder.provider.installedapplication.InstalledapplicationSelection;
import in.ishankhanna.notifshredder.ui.adapters.AppListCursorAdapter;
import in.ishankhanna.notifshredder.utils.SharedPreferenceHelper;

/**
 * Created by ishan on 01/02/16.
 */
public class AppChooserFragment extends Fragment implements
        AdapterView.OnItemClickListener, LoaderManager.LoaderCallbacks<Cursor> {

    ListView lv_notifApp;
    private PackageManager packageManager = null;
    private List<ApplicationInfo> applist = null;
    SharedPreferenceHelper sharedPreferenceHelper;
    AppListCursorAdapter appListCursorAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        packageManager = getActivity().getPackageManager();
        sharedPreferenceHelper = SharedPreferenceHelper.getInstance(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_app_chooser, container, false);

        lv_notifApp = (ListView) rootView.findViewById(R.id.lv_notifApp);

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        initList();

        return rootView;
    }

    private void initList() {

        getLoaderManager().initLoader(0, null, this);

        lv_notifApp.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        sharedPreferenceHelper.toggleBlockForAppName(applist.get(position).packageName);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        InstalledapplicationSelection installedapplicationSelection
                = new InstalledapplicationSelection();

        return new CursorLoader(getContext(), InstalledapplicationColumns.CONTENT_URI,InstalledapplicationColumns.ALL_COLUMNS, installedapplicationSelection.sel(), installedapplicationSelection.args(), null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        appListCursorAdapter = new AppListCursorAdapter(getContext(),
                data, false);
        lv_notifApp.setAdapter(appListCursorAdapter);
        appListCursorAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        appListCursorAdapter.swapCursor(null);

    }
}
