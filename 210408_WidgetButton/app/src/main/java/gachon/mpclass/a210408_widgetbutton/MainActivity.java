package gachon.mpclass.a210408_widgetbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.myButton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                updateTime();
            }
        });
    }

    void updateTime(){
        button.setText(new Date().toString());
    }
}