package com.sanedapps.generalnetworkcall.Model;

import java.io.Serializable;

/**
 * Created by Mahmoud on 2/14/18.
 */

public class ListModel implements Serializable {

    /**
     * id : 1
     * name : Afghanistan
     */

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
