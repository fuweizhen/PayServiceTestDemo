package pay.jl.com.testaidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.newland.aidl.deviceInfo.AidlDeviceInfo;
import com.newland.aidl.deviceService.AidlDeviceService;
import com.newland.aidl.led.AidlLED;
import com.newland.aidl.printer.AidlPrinter;
import com.newland.aidl.printer.AidlPrinterListener;


public class MainActivity extends AppCompatActivity {

    private AidlDeviceService serviceManager;
    private AidlDeviceInfo deviceInfo;
    private AidlLED aidlLED;
    private AidlPrinter aidlPrinter;
    private Button btonclick;
    private Button bttest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btonclick = findViewById(R.id.btonclick);
        btonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService();
            }
        });
        bttest = findViewById(R.id.bttest);
        bttest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    deviceInfo = AidlDeviceInfo.Stub.asInterface(serviceManager.getDeviceInfo());
                    if (deviceInfo != null){
                        Log.d("tag",deviceInfo.getCSN());
                    }else {
                        Log.d(getClass().getSimpleName(),"deviceInfo==null");
                    }
                    aidlLED = AidlLED.Stub.asInterface(serviceManager.getLed());
                    if (aidlLED != null){
                        aidlLED.ledOperation(4,3,-1);
                    }else {
                        Log.d(getClass().getSimpleName(),"aidlLED==null");
                    }
                    aidlPrinter = AidlPrinter.Stub.asInterface(serviceManager.getPrinter());
                    if (aidlPrinter != null){
                        //aidlPrinter.addText(null,"cccccccccccccccccccc我我我我");
                        //aidlPrinter.addQrCode(null,"ccccvvvbbb");
                        aidlPrinter.addBarCode(null,"123456");
                        aidlPrinter.startPrinter(new AidlPrinterListener.Stub() {
                            @Override
                            public void onError(int code, String detail) throws RemoteException {

                            }

                            @Override
                            public void onFinish() throws RemoteException {

                            }

                        });
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            serviceManager = AidlDeviceService.Stub.asInterface(iBinder);
            if (serviceManager != null){
                Log.d(getClass().getSimpleName(),"serviceManager绑定成功");
            }else {
                Log.d(getClass().getSimpleName(),"serviceManager绑定失败");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(getClass().getSimpleName(),"serviceManager绑定失败");
        }
    };

    public void bindService()
    {
        Log.d(getClass().getSimpleName(),"bindService绑定服务");
        Intent localIntent = new Intent();
        localIntent.setAction("com.newland.DeviceService");
        localIntent.setPackage("com.newland.aidl");
        boolean flag =  bindService(localIntent,connection, Context.BIND_AUTO_CREATE);
        if (flag){
            Log.d(getClass().getSimpleName(),"服务绑定成功");
        }else {
            Log.d(getClass().getSimpleName(),"服务断开了");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
