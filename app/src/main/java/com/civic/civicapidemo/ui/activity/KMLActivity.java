package com.civic.civicapidemo.ui.activity;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.widget.Toast;

import com.civic.civicapidemo.R;
import com.civic.civicapidemo.network.NetworkHandler;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KMLActivity extends BaseActivity {

    private static final String TAG = KMLActivity.class.getSimpleName();
    FloatingActionButton mAreaNameMic;
    @Bind(R.id.area_name_mic)
    FloatingActionButton areaNameMic;
    /*@Bind(R.id.map)
    android.widget.fragment map;*/
    private GoogleMap mMap;
    private LatLng mPlaceLatLong;
    private NetworkHandler mNetworkHandler;
    private ProgressDialog mProgressDialog;

    private final int REQ_CODE_SPEECH_INPUT = 100;

    protected int getLayoutId() {
        return R.layout.activity_kml;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mNetworkHandler = new NetworkHandler(getApplicationContext(), KMLActivity.this);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mNetworkHandler.getPoliticianByLatLong(latLng);
            }
        });
    }

    public void startOverlay() {
        try {
            mMap = getMap();
            mPlaceLatLong = new LatLng(28.62, 77.21);
            CameraUpdate center = CameraUpdateFactory.newLatLng(mPlaceLatLong);
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(10);

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            retrieveFileFromResource();

        } catch (Exception e) {
            Log.e("Exception caught", e.toString());
        }
    }

    private void retrieveFileFromResource() {
        try {
            KmlLayer kmlLayer = new KmlLayer(mMap, R.raw.delhi_coordinates, getApplicationContext
                    ());
            kmlLayer.addLayerToMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Log.d(TAG, result.get(0));
                    mNetworkHandler.getPoliticianByAreaName(result.get(0));
                }
                break;
            }

        }
    }

    @OnClick(R.id.area_name_mic)
    public void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "speak");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "no support",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
