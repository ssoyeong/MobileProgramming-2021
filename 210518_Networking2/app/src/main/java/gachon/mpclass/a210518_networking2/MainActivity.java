package gachon.mpclass.a210518_networking2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button01;
    EditText ipView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button01 = (Button)findViewById(R.id.button01);
        ipView1 = (EditText)findViewById(R.id.editText01);

        button01.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                String addr = ipView1.getText().toString().trim();
                ConnectThread thread = new ConnectThread(addr);
                thread.start();
            }
        });
    }
}