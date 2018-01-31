package hire.omnify.com.omnify;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    TextView tvQuickSortedArray,tvMergeSortedArray;
    String s="";


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View lView= inflater.inflate(R.layout.fragment_second, container, false);
        Bundle bn=getArguments();
        int[] sortedArray=bn.getIntArray("array");

        tvQuickSortedArray=(TextView)lView.findViewById(R.id.sorted_value);
        tvMergeSortedArray=(TextView)lView.findViewById(R.id.sorted_value1);

        for(int i:sortedArray){
            s+=i;
            s+=" \n";
        }
        tvQuickSortedArray.setText(s);
        tvMergeSortedArray.setText(s);
        return lView;
    }

}
