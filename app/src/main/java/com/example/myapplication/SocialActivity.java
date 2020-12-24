package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class SocialActivity extends AppCompatActivity {
    TextView ProximitySensor, data;
    SensorManager mySensorManager;
    Sensor myProximitySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        ProximitySensor = (TextView) findViewById(R.id.proximitySensor);
        data = (TextView) findViewById(R.id.data);
        mySensorManager = (SensorManager) getSystemService(
                Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null) {
            ProximitySensor.setText("No Proximity Sensor!");
        } else {
            mySensorManager.registerListener(proximitySensorEventListener, myProximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    SensorEventListener proximitySensorEventListener;

    {
        proximitySensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                    if (event.values[0] == 0) {
                        data.setText("Near");
                    } else {
                        data.setText("Away");
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // TODO Auto-generated method stub
            }


        };
    }
}

