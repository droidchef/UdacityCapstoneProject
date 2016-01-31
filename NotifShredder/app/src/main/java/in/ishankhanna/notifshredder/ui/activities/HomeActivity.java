package in.ishankhanna.notifshredder.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import in.ishankhanna.notifshredder.R;
import in.ishankhanna.notifshredder.ui.fragments.AppChooserFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AppChooserFragment appChooserFragment = new AppChooserFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, appChooserFragment, "APP_CHOOSER");
        fragmentTransaction.commit();

    }


}
