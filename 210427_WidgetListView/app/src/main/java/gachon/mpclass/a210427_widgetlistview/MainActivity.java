package gachon.mpclass.a210427_widgetlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names = {"LEE", "CHOI", "KIM", "JEONG", "RHO", "JEON", "LEE", "CHOI", "KIM", "JEONG", "RHO", "JEON", "LEE", "CHOI", "KIM", "JEONG", "RHO", "JEON", "LEE", "CHOI", "KIM", "JEONG", "RHO", "JEON"};
        ListView listView = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
    }
}