package gachon.mpclass.a210412_service_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnStart = findViewById(R.id.btnStartService);
        btnStart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                startService(new Intent(getApplicationContext(), MyService.class));
            }
        });

        Button btnStop = findViewById(R.id.btnStopService);
        btnStop.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                stopService(new Intent(getApplicationContext(), MyService.class));
            }
        });
    }
}