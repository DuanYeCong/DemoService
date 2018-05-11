package com.sr.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void satartradio() {
        Toast.makeText(this, "开始播放", Toast.LENGTH_SHORT).show();
    }

    public void pauseradio() {
        Toast.makeText(this, "暂停播放", Toast.LENGTH_SHORT).show();
    }

    public void reradio() {
        Toast.makeText(this, "继续播放", Toast.LENGTH_SHORT).show();
    }

    private class MyBinder extends Binder implements Iservice {

        @Override
        public void callpauseradio() {
            satartradio();
        }

        @Override
        public void callreradio() {
            pauseradio();
        }

        @Override
        public void callsatartradio() {
            reradio();
        }
    }


}
