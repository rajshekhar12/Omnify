package hire.omnify.com.omnify;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    Button gGenerateNumberButton,gShortNumber;
    TextView tvShowGenerated;

    int[] gRandomNumber;
    Random random;
    String s="";


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View lView= inflater.inflate(R.layout.fragment_first, container, false);
        gGenerateNumberButton=(Button)lView.findViewById(R.id.btn_create);
        gShortNumber=(Button)lView.findViewById(R.id.btn_short);
        tvShowGenerated=(TextView)lView.findViewById(R.id.generatedNo);
        gRandomNumber=new int[20];
        random=new Random();

        gGenerateNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s="";
                for(int i=0;i<20;i++){

                    gRandomNumber[i]=random.nextInt(90)+10;
                    s +=gRandomNumber[i]+" ";
                }
                Log.d("random",s);

                tvShowGenerated.setText(s);

            }
        });



        gShortNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity= (MainActivity) getActivity();
                activity.startSecondActivity(gRandomNumber);

            }
        });
        return lView;
    }

}
