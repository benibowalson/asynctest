package com.example.android.arraystest;

import android.app.Activity;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by 48101040 on 5/20/2017.
 */

public class ConnectivityChecker extends AsyncTask<Void, Void, Void> {

    boolean isOnline = false;
    public Activity myActivityRef;

    //constructor
    public ConnectivityChecker(Activity sourceActivity){
        this.myActivityRef = sourceActivity;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try{
            int timeOut_ms = 5000;
            Socket aSock = new Socket();
            SocketAddress aSockAdd = new InetSocketAddress("8.8.8.8", 53);
            aSock.connect(aSockAdd, timeOut_ms);
            aSock.close();
            isOnline = true;
        } catch (IOException ex){
            isOnline = false;
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        myActivityRef.checkConnectivity(isOnline);
    }
}
