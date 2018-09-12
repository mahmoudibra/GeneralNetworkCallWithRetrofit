package com.MahmoudIbrahim.generalnetworkcall.Model;

import java.io.Serializable;

/**
 * Created by Mahmoud on 2/4/18.
 */

public class ErrorResponse implements Serializable {

    private int status;

    private String message;

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

}
