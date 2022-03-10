package gachon.mpclass.a210430_hw3;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        String[] items ={"Ice cream", "Chocolate", "Cake", "Waffle", "Macaron", "Cookie", "Tart"};

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        Button button1 = (Button) container.findViewById(R.id.menuBtn);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                MainActivity activity = (MainActivity)getActivity();
                activity.onFragmentChanged(0);
            }
        });

        Button button2 = (Button)container.findViewById(R.id.mainBtn);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                MainActivity activity = (MainActivity)getActivity();
                activity.onFragmentChanged(1);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String item = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}



