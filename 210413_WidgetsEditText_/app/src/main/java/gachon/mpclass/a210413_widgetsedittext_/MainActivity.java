package gachon.mpclass.a210413_widgetsedittext_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView labelUserName;
    EditText txtUserName;
    Button btnLogin;
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        labelUserName = findViewById(R.id.textView1);
        txtUserName = findViewById(R.id.txtUserName);
        btnLogin = findViewById(R.id.button1);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String userName = txtUserName.getText().toString();
                if(userName.compareTo("SSO")==0){
                    labelUserName.setText("Ok, Please wait..");
                    Toast.makeText(context, "Hi, " + userName, duration).show();
                }
                else{
                    Toast.makeText(context, userName + " is not a valid User", duration).show();
                }
            }
        });
    }
}