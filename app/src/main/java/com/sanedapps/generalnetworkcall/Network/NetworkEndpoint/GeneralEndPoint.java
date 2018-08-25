package com.sanedapps.generalnetworkcall.Network.NetworkEndpoint;
import com.sanedapps.generalnetworkcall.Model.ListModel;
import com.sanedapps.generalnetworkcall.Model.GeneralResponse;
import com.sanedapps.generalnetworkcall.Model.SlideModel;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Mahmoud on 2/14/18.
 */
public interface GeneralEndPoint {

    @GET("General/Cities")
    Call<GeneralResponse<ArrayList<ListModel>>> getCities(
    );

    @GET("General/GeneralData/Terms")
    Call<GeneralResponse<String>> getTerms(
    );

//
    @GET("General/GeneralData/About")
    Call<GeneralResponse<String>> getِAbout(
    );

    @GET("General/GeneralData/ContactUsTypes")
    Call<GeneralResponse<ArrayList<ListModel>>> getContactTypes(
    );

    @GET("General/Ads")
    Call<GeneralResponse<ArrayList<SlideModel>>> getAds(
    );
}
