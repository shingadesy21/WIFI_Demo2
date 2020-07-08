package com.example.wifidemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
WifiManager wifiManager;
WifiReceiver wifiReceiver;
ListAdapter listAdapter;
ListView wifilist;
List mywifiListView;
    @SuppressLint("WifiManagerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifilist=findViewById(R.id.myListView);
        wifiManager=(WifiManager)getSystemService(Context.WIFI_SERVICE);
        wifiReceiver=new WifiReceiver();
        registerReceiver(wifiReceiver,new IntentFilter(wifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
        }
        else{
            scanWifiList();
        }


    }

    private void scanWifiList() {
        wifiManager.startScan();
        mywifiListView=wifiManager.getScanResults();
        setAdapter();
    }

    private void setAdapter() {
        listAdapter=new ListAdapter(getApplicationContext(),mywifiListView);
       wifilist.setAdapter(listAdapter);
    }

    class WifiReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
}