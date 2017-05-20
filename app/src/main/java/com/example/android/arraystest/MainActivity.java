package com.example.android.arraystest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean DeviceIsOnline = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityChecker checker = new ConnectivityChecker(this);
        checker.execute();

        try {

            ConnectivityChecker check = new ConnectivityChecker(this);
            check.execute();
            Toast.makeText(this, DeviceIsOnline? "Yep": "Nay", Toast.LENGTH_LONG).show();

        } catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void checkConnectivity(boolean isOnline){
        DeviceIsOnline = isOnline;
    }

}


