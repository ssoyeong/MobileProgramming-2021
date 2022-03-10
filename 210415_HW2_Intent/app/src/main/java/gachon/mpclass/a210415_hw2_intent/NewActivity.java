package gachon.mpclass.a210415_hw2_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent getLoginIntent = getIntent();
        Bundle getLoginBundle = getLoginIntent.getExtras();

        String userName = getLoginBundle.getString("userName");
        String userDept = getLoginBundle.getString("userDept");
        String userNum = getLoginBundle.getString("userNum");

        String toastText = "Student Info : " + userName + ", " + userDept + ", " + userNum;
        Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                EditText url = findViewById(R.id.editURL);
                EditText phone = findViewById(R.id.editPhone);

                getLoginBundle.putString("inputURL", url.getText().toString());
                getLoginBundle.putString("inputPhone", phone.getText().toString());
                getLoginIntent.putExtras(getLoginBundle);
                setResult(MainActivity.RESULT_OK, getLoginIntent);
                finish();
            }
        });
    }
}