package in.ishankhanna.notifshredder.ui.fragments;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import in.ishankhanna.notifshredder.R;
import in.ishankhanna.notifshredder.ui.adapters.AppListAdapter;
import in.ishankhanna.notifshredder.utils.SharedPreferenceHelper;

/**
 * Created by ishan on 01/02/16.
 */
public class AppChooserFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView lv_notifApp;
    AppListAdapter appListAdapter;
    private PackageManager packageManager = null;
    private List<ApplicationInfo> applist = null;
    SharedPreferenceHelper sharedPreferenceHelper;

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

        applist = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        appListAdapter = new AppListAdapter(getActivity(), R.layout.snippet_list_row, applist);

        lv_notifApp.setAdapter(appListAdapter);

        lv_notifApp.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        sharedPreferenceHelper.toggleBlockForAppName(applist.get(position).packageName);
        appListAdapter.notifyDataSetChanged();
    }
}
