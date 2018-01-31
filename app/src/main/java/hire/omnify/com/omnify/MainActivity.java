package hire.omnify.com.omnify;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FrameLayout gFrameLayout;
    private IntentFilter mIntentFilter;
    int [] getArrayData;
    Fragment fragment;
//    MyReciver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getArrayData=new int[20];
//        mReceiver=new MyReciver();
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("object");
        registerReceiver(mReceiver, mIntentFilter);

        fragment=new FirstFragment();
        replaceFragment(fragment);

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

  public void startSecondActivity(int[] numbers){
//      registerReceiver(mReceiver, mIntentFilter);
//      mReceiver=new MyReciver();
      mIntentFilter = new IntentFilter();
      mIntentFilter.addAction("object");
      registerReceiver(mReceiver, mIntentFilter);
      Intent startMyServices=new Intent(MainActivity.this,MySortingService.class);
      startMyServices.putExtra("array",numbers);
      startService(startMyServices);

//      Log.d("firstdata",getArrayData[0]+"");

  }

    private BroadcastReceiver mReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("datarecive","recived");
            if (intent.getAction().equals("object")) {
                Bundle reciveBundle=intent.getBundleExtra("array");
                getArrayData=reciveBundle.getIntArray("data");
                Intent stopIntent = new Intent(MainActivity.this,
                        MySortingService.class);
                fragment=new SecondFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(fragment.toString());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                Bundle sendBundle=new Bundle();
                sendBundle.putIntArray("array",getArrayData);
                fragment.setArguments(sendBundle);
                fragmentTransaction.commit();
//                Toast.makeText(MainActivity.this,"datarecived",Toast.LENGTH_SHORT).show();
                stopService(stopIntent);
            }

        }
    };
}
