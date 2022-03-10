package gachon.mpclass.a210415_hw2_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnURL;
    Button btnPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                EditText name = findViewById(R.id.editName);
                EditText dept = findViewById(R.id.editDept);
                EditText num = findViewById(R.id.editNum);

                Intent loginIntent = new Intent(getApplicationContext(), NewActivity.class);
                Bundle loginBundle = new Bundle();
                loginBundle.putString("userName", name.getText().toString());
                loginBundle.putString("userDept", dept.getText().toString());
                loginBundle.putString("userNum", num.getText().toString());
                loginIntent.putExtras(loginBundle);
                startActivityForResult(loginIntent, 0);
            }
        });


        btnURL = findViewById(R.id.btnURL);
        btnURL.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                EditText editURL = findViewById(R.id.editURL);
                String url = editURL.getText().toString();
                Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(urlIntent);
            }
        });


        btnPhone = findViewById(R.id.btnPhone);
        btnPhone.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                EditText editPhone = findViewById(R.id.editPhone);
                String phone = editPhone.getText().toString();
                Intent phoneIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(phone));
                startActivity(phoneIntent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        String getURL = data.getStringExtra("inputURL");
        String getPhone = data.getStringExtra("inputPhone");

        EditText editURL = findViewById(R.id.editURL);
        EditText editPhone = findViewById(R.id.editPhone);
        editURL.setText(getURL);
        editPhone.setText(getPhone);
    }
}