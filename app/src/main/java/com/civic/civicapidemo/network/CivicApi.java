package com.civic.civicapidemo.network;

import com.civic.civicapidemo.PoliticianModel;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author Umang Chamaria
 */
public interface CivicApi {
    @GET("/civic-core/politicians")
    void getAllPoliticianInfo(Callback<List<PoliticianModel>> response);

    @GET("/civic-core/politicians/latlong")
    void getPoliticiansByLatLong(@Query("lat") double latitude, @Query("long") double
            longitude, Callback<PoliticianModel> response);

    @GET("/civic-core/politicians/geocode")
    void getPoliticianByAreaName(@Query(value = "address", encodeValue = true) String areaName,
                                 Callback<PoliticianModel> response);

}
