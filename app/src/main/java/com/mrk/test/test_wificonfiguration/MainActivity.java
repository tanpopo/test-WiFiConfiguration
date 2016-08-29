package com.mrk.test.test_wificonfiguration;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static String tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button updateButton = (Button)findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager manager = (WifiManager)getSystemService(WIFI_SERVICE);

                List<WifiConfiguration> config_list = manager.getConfiguredNetworks();
                String configString = "";
                String logString = "";
                String log = "";
                for(WifiConfiguration config : config_list) {
                    configString += config.SSID + "," + config.allowedProtocols + "\n";
                    log += "[" + config.SSID + "]\n" + config.toString() + "\n";
                    logString += log;
                    Log.d(tag, log);
                }
                TextView outView = (TextView)findViewById(R.id.outView);
                outView.setText(configString);

                TextView logView = (TextView)findViewById(R.id.logView);
                logView.setText(logString);
            }
        });
    }
}
