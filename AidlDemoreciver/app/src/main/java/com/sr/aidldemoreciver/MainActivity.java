package com.sr.aidldemoreciver;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sr.demoaidl.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    private MyCoon coon;
    private IMyAidlInterface aidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent();
        intent.setPackage("com.sr.demoaidl");
        intent.setAction("com.sr.remote");
        coon = new MyCoon();
        bindService(intent, coon,BIND_AUTO_CREATE);

    }
    public void click(View view){
        try {
            Log.d("DYC!", "add()=="+ aidlInterface.add(3, 4)+"  "+"minus()+=="+aidlInterface.minus(10, 3));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(coon);
        super.onDestroy();
    }

    private class MyCoon implements ServiceConnection{
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            aidlInterface = IMyAidlInterface.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
