package com.MahmoudIbrahim.generalnetworkcall.Network.NetworkEndpoint;
import com.MahmoudIbrahim.generalnetworkcall.Model.GeneralResponse;
import com.MahmoudIbrahim.generalnetworkcall.Model.ListModel;
import com.MahmoudIbrahim.generalnetworkcall.Model.SlideModel;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

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
