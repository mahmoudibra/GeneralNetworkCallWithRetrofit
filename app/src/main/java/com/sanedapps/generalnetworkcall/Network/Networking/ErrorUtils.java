package com.sanedapps.generalnetworkcall.Network.Networking;


import com.sanedapps.generalnetworkcall.Model.ErrorResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Mahmoud on 3/26/18.
 */

public class ErrorUtils {

    public static ErrorResponse parseError(Response<?> response) {
        Converter<ResponseBody, ErrorResponse> converter =
                RetrofitClient.getClient().responseBodyConverter(ErrorResponse.class, new Annotation[0]);

        ErrorResponse error;
        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ErrorResponse();
        }
        return error;
    }
}
