package com.qrtx.localservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.qrtx.remoteservice.IAidlInterface;

public class MainActivity extends AppCompatActivity {

    private IAidlInterface iAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Intent intent = new Intent();
        intent.setAction("qrtx.com");
        bindService(intent, new MyConn(), BIND_AUTO_CREATE);

    }

    class MyConn implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iAidlInterface = IAidlInterface.Stub.asInterface(service);
            try {
                iAidlInterface.callFuncation();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
