package com.qrtx.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/26.
 */
public class TestService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void funcation() {
        Log.i("TestService", "远程调用成功");
    }

    class MyBinder extends IAidlInterface.Stub {
        @Override
        public void callFuncation() throws RemoteException {
            funcation();
        }
    }
}
