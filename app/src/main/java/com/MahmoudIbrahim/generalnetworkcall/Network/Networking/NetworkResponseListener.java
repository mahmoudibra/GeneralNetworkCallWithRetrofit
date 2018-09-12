package com.MahmoudIbrahim.generalnetworkcall.Network.Networking;

/**
 * Created by Mahmoud on 2/14/18.
 */

public interface NetworkResponseListener<Response> {

    void onResponseReceived(Response response);

    void onError();
}
