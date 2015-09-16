package com.civic.civicapidemo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.civic.civicapidemo.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * @author Umang Chamaria
 */
public abstract class BaseActivity extends FragmentActivity {
    private GoogleMap mMap;

    protected int getLayoutId() {
        return R.layout.map;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap != null) {
            return;
        }
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (mMap != null) {
            startOverlay();
        }
    }

    /**
     * Run the demo-specific code.
     */
    protected abstract void startOverlay();

    protected GoogleMap getMap() {
        setUpMapIfNeeded();
        return mMap;
    }
}
