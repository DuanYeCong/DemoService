package com.sr.demoaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    private IBinder binder = new IMyAidlInterface.Stub() {
        @Override
        public void callstartaidl() throws RemoteException {
            System.out.printf("开启远程服务");
        }

        @Override
        public int add(int a, int b) {
            return a+b;
        }

        @Override
        public int minus(int a, int b) {
            return a%b;
        }
    };

}
