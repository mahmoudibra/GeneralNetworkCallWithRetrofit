package com.sanedapps.generalnetworkcall.Network.Networking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;
import com.sanedapps.generalnetworkcall.App;
import com.sanedapps.generalnetworkcall.Model.ErrorResponse;
import com.sanedapps.generalnetworkcall.Model.GeneralResponse;
import com.sanedapps.generalnetworkcall.R;
import es.dmoral.toasty.Toasty;
import java.lang.ref.WeakReference;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.security.interfaces.RSAKey;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud on 2/14/18.
 */

public class HandleNetworkResponse<ResponseType> implements Callback<ResponseType> {

    private WeakReference<NetworkResponseListener> listener;

    public HandleNetworkResponse(NetworkResponseListener listener) {
        this.listener = new WeakReference<>(listener);
    }


    @Override
    public void onResponse(@NonNull Call<ResponseType> call, @NonNull Response<ResponseType> response) {
        if (listener.get() != null && listener != null) {
            if (response.isSuccessful()) {
                GeneralResponse generalResponse = (GeneralResponse) response.body();
                if (generalResponse.getStatus() == 200) {
                    Toasty.success(App.getInstance(), "Recived Data succ", 3).show();
                    listener.get().onResponseReceived(generalResponse.getData());
                } else if (generalResponse.getStatus() == 401) {

                }
            } else {
                ErrorResponse baseResponse = ErrorUtils.parseError(response);
                Toasty.error(App.getInstance(), baseResponse.getMessage(), 3).show();
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<ResponseType> call, @NonNull Throwable t) {
        if (App.getInstance() != null) {
            Toasty.error(App.getInstance(), App.getInstance().getString(handleException(t)), 3).show();
        }
        if (listener.get() != null && listener != null) {
            listener.get().onError();
        }
    }

    int handleException(Throwable t) {
        if (t instanceof SocketTimeoutException) {
            return R.string.error_in_internet;
        } else if (t instanceof UnknownHostException) {
            return R.string.error_in_internet;
        } else if (t instanceof ConnectException) {
            return R.string.error_in_internet;
        } else if (t instanceof NoRouteToHostException) {
            return R.string.error_in_internet;
        } else if (t instanceof PortUnreachableException) {
            return R.string.error_in_internet;
        } else if (t instanceof UnknownServiceException) {
            return R.string.error_in_internet;
        } else if (t instanceof BindException) {
            return R.string.error_in_internet;
        } else {
            return R.string.error_in_internet;
        }
    }
}
