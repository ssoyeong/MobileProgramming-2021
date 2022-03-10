package gachon.mpclass.a210413_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    CheckBox chkCream;
    CheckBox chkSugar;
    Button btnPay;
    RadioGroup radCoffeeType;
    RadioButton radDecaf;
    RadioButton radEspresso;
    RadioButton radColombian;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkCream = findViewById(R.id.chkCream);
        chkSugar = findViewById(R.id.chkSugar);
        btnPay = findViewById(R.id.btnPay);
        radCoffeeType = findViewById(R.id.radGroupCoffeeType);
        radDecaf = findViewById(R.id.radDecaf);
        radEspresso = findViewById(R.id. radExpresso);
        radColombian = findViewById (R.id.radColombian);

        btnPay.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String msg = "Coffee";
                if(chkCream.isChecked()){
                    msg += " & Cream";
                }
                if(chkSugar.isChecked()){
                    msg += " & Sugar";
                }

                int radioId = radCoffeeType.getCheckedRadioButtonId();
                if(radDecaf.getId() == radioId)
                    msg = "Decaf " + msg;
                if(radColombian.getId() == radioId)
                    msg = "Colombian " + msg;
                if(radEspresso.getId() == radioId)
                    msg = "Espresso " + msg;

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

    }
}