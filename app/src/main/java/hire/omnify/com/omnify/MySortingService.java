package hire.omnify.com.omnify;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class MySortingService extends Service {
    public MySortingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Bundle bn=intent.getExtras();
        int[] inputArrays=bn.getIntArray("array");
        Log.d("FirstData",inputArrays[0]+"");
        MyMergeSort myMergeSort=new MyMergeSort();
        myMergeSort.sort(inputArrays);

        MyQuickSort myQuickSort=new MyQuickSort();
        myQuickSort.sort(inputArrays);

        Intent in=new Intent();
        in.setAction("object");
        Bundle bn1=new Bundle();
        bn1.putIntArray("data",inputArrays);

        in.putExtra("array",bn1);
//        in.putExtra("DATAPASSED", 1);
        sendBroadcast(in);
        Log.d("sort","shorted");

        return START_REDELIVER_INTENT;
    }
}
