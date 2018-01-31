package hire.omnify.com.omnify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

/**
 * Created by Raj on 31-01-2018.
 */

public class MyReciver extends BroadcastReceiver {
    int [] getArrayData;
    Fragment fragment;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bn=intent.getBundleExtra("array");
        getArrayData=bn.getIntArray("data");

//        int datapassed = intent.getIntExtra("DATAPASSED", 0);
        Intent stopIntent = new Intent(context,
                MySortingService.class);
        Log.d("DATAPASSED",getArrayData[0]+"");

        Toast.makeText(context,
                "Triggered by Service!\n"
                        + "Data passed: " ,
                Toast.LENGTH_LONG).show();
        /*fragment=new SecondFragment();
        FragmentManager fragmentManager = ;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();*/
//                Toast.makeText(MainActivity.this,"datarecived",Toast.LENGTH_SHORT).show();
        context.stopService(stopIntent);
    }
}
