package com.sanedapps.generalnetworkcall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.sanedapps.generalnetworkcall.Model.ListModel;
import com.sanedapps.generalnetworkcall.Model.SlideModel;
import com.sanedapps.generalnetworkcall.Network.Repository.GeneralRepository;
import com.sanedapps.generalnetworkcall.Network.Networking.NetworkResponseListener;
import es.dmoral.toasty.Toasty;
import java.util.ArrayList;

/**
 * Created by Mahmoud on 2/14/18.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GeneralRepository.getCities(new NetworkResponseListener<ArrayList<ListModel>>() {
            @Override
            public void onResponseReceived(final ArrayList<ListModel> listModels) {
                Toasty.success(MainActivity.this, " First city is  : " + listModels.get(0).getName(), 2)
                        .show();
            }

            @Override
            public void onError() {

            }
        });

        GeneralRepository.getTermsAndConditions(new NetworkResponseListener<String>() {
            @Override
            public void onResponseReceived(final String s) {
                Log.e("TAG", "Terms and Conditions is : " + s);
            }

            @Override
            public void onError() {

            }
        });
        GeneralRepository.getAboutApp(new NetworkResponseListener<String>() {
            @Override
            public void onResponseReceived(final String s) {
                Log.e("TAG", "About app is : " + s);
            }

            @Override
            public void onError() {

            }
        });

        GeneralRepository.getContactType(new NetworkResponseListener<ArrayList<ListModel>>() {
            @Override
            public void onResponseReceived(final ArrayList<ListModel> listModels) {
                Toasty.success(MainActivity.this, " First Contact is  : " + listModels.get(0).getName(), 2)
                        .show();
            }

            @Override
            public void onError() {

            }
        });

        GeneralRepository.getSlideShow(new NetworkResponseListener<ArrayList<SlideModel>>() {
            @Override
            public void onResponseReceived(final ArrayList<SlideModel> slideModels) {
                Toasty.success(MainActivity.this, " First Slide Show is  : " + slideModels.get(0).getImage(), 2)
                        .show();
            }
            @Override
            public void onError() {

            }
        });
    }


}
