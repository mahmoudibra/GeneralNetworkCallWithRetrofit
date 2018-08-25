package com.sanedapps.generalnetworkcall;

import android.app.Application;
import java.lang.ref.WeakReference;


/**
 * Created by Mahmoud on 2/14/18.
 */
public class App extends Application {
    private static WeakReference<Application> instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = new WeakReference<Application>(this);
    }

    public static Application getInstance() {
        return instance != null ? instance.get() : null;
    }
}
