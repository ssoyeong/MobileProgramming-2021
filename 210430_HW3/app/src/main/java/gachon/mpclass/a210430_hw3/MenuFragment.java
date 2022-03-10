package gachon.mpclass.a210430_hw3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_menu, container, false);

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


        String[] items = {"데이터 과학", "모바일 프로그래밍", "소프트웨어공학", "경영학원론", "소프트웨어산업세미나", "졸업작품1"};

        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, items);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String item = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(getActivity(), item+"(이)가 선택되었습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });

        return rootView;
    }
}
