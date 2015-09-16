package com.civic.civicapidemo.network;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.civic.civicapidemo.Constants;
import com.civic.civicapidemo.PoliticianModel;
import com.civic.civicapidemo.ui.activity.PoliticianDetailActivity;
import com.google.android.gms.maps.model.LatLng;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * @author Umang Chamaria
 */
public class NetworkHandler {

    private final String TAG = NetworkHandler.class.getSimpleName();

    public NetworkHandler(Context context, Activity activity) {
        this.mContext = context;
        mActivity = activity;
    }
    private Activity mActivity;
    private Context mContext;
    private RestAdapter mRestAdapter;
    private CivicApi mCivicApi;
    private PoliticianModel mPolitician;
    private ProgressDialog mProgressDialog;


    public void init(){

        if (mCivicApi == null)
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.ENDPOINT).build();
        mCivicApi = mRestAdapter.create(CivicApi.class);
    }

    @Nullable
    public PoliticianModel getPoliticianByLatLong(LatLng latLng){
        init();
        final Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                hideProgressDialog();
                if (response.getStatus() == 200) {
                    mPolitician = (PoliticianModel) o;
                    if (mPolitician != null) {
                        Intent intent = new Intent(mContext, PoliticianDetailActivity.class);
                        intent.putExtra("politicianDetails", mPolitician);
                        mActivity.startActivity(intent);
                    }
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                hideProgressDialog();
                if (retrofitError.getResponse().getStatus() == 404){
                    Toast.makeText(mContext, "Could not find constituency. Please try again",
                            Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(mContext, "Something went wrong. Please try again", Toast
                            .LENGTH_LONG).show();
                }
                Log.d(TAG, "retro-fit error");
                Toast.makeText(mContext, "Something went wrong. Please try again", Toast
                        .LENGTH_LONG).show();
            }
        };
        mCivicApi.getPoliticiansByLatLong(latLng.latitude, latLng.longitude, callback);
        showProgressDialog();
        return mPolitician;
    }

    @Nullable
    public PoliticianModel getPoliticianByAreaName(String areaName) {
        init();
        final Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                hideProgressDialog();
                if (response.getStatus() == 200) {
                    mPolitician = (PoliticianModel) o;
                    if (mPolitician != null) {
                        Intent intent = new Intent(mContext, PoliticianDetailActivity.class);
                        intent.putExtra("politicianDetails", mPolitician);
                        mActivity.startActivity(intent);
                    }
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                hideProgressDialog();
                if (retrofitError.getResponse().getStatus() == 404){
                    Toast.makeText(mContext, "Could not find constituency. Please try again",
                            Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(mContext, "Could not find constituency. Please try again",
                            Toast.LENGTH_LONG).show();
                }
                Log.d(TAG, "retro-fit error");
                Toast.makeText(mContext, "Something went wrong. Please try again", Toast
                        .LENGTH_LONG).show();
            }
        };
        mCivicApi.getPoliticianByAreaName(areaName, callback);
        showProgressDialog();
        return mPolitician;
    }

 /*   public List<PoliticianModel> getAllPoliticianList(){
        init();
        mCivicApi.getAllPoliticianInfo(new Callback<List<PoliticianModel>>() {
            @Override
            public void success(List<PoliticianModel> politicianModels, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return mPolitician;
    }*/

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    private void showProgressDialog() {
        mProgressDialog = new ProgressDialog(mActivity);
        mProgressDialog.setMessage("Searching for your constituency politician");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }
}
