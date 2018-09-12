package com.MahmoudIbrahim.generalnetworkcall.Network.Repository;

import com.MahmoudIbrahim.generalnetworkcall.Network.Networking.HandleNetworkResponse;
import com.MahmoudIbrahim.generalnetworkcall.Network.Networking.NetworkResponseListener;
import com.MahmoudIbrahim.generalnetworkcall.Model.ListModel;
import com.MahmoudIbrahim.generalnetworkcall.Model.GeneralResponse;
import com.MahmoudIbrahim.generalnetworkcall.Model.SlideModel;
import com.MahmoudIbrahim.generalnetworkcall.Network.NetworkEndpoint.GeneralEndPoint;
import com.MahmoudIbrahim.generalnetworkcall.Network.Networking.RetrofitClient;
import java.util.ArrayList;

/**
 * Created by Mahmoud on 2/14/18.
 */

public class GeneralRepository {

    public static void getCities(NetworkResponseListener<ArrayList<ListModel>> listener) {
       RetrofitClient.getClient().create(GeneralEndPoint.class).getCities().enqueue(new HandleNetworkResponse<GeneralResponse<ArrayList<ListModel>>>(listener));
    }
    public static void getContactType(NetworkResponseListener<ArrayList<ListModel>> listener) {
        RetrofitClient.getClient().create(GeneralEndPoint.class).getContactTypes().enqueue(new HandleNetworkResponse<GeneralResponse<ArrayList<ListModel>>>(listener));
    }

    public static void getTermsAndConditions(NetworkResponseListener<String> listener) {
        RetrofitClient.getClient().create(GeneralEndPoint.class).getTerms().enqueue(new HandleNetworkResponse<GeneralResponse<String>>(listener));
    }

    public static void getAboutApp(NetworkResponseListener<String> listener) {
        RetrofitClient.getClient().create(GeneralEndPoint.class).getِAbout().enqueue(new HandleNetworkResponse<GeneralResponse<String>>(listener));
    }

    public static void getSlideShow(NetworkResponseListener<ArrayList<SlideModel>> listener) {
        RetrofitClient.getClient().create(GeneralEndPoint.class).getAds().enqueue(new HandleNetworkResponse<GeneralResponse<ArrayList<SlideModel>>>(listener));
    }
}
