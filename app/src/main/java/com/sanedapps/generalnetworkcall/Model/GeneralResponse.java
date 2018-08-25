package com.sanedapps.generalnetworkcall.Model;

import java.util.ArrayList;

/**
 * Created by Mahmoud on 2/14/18.
 */

public class GeneralResponse<T> {

    private int status;

    private String message;

    // generic response data
    private T data;

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public boolean isRequestSuccess() {
        if (status == 200) {
            return true;
        } else {
            return false;
        }
    }


}
