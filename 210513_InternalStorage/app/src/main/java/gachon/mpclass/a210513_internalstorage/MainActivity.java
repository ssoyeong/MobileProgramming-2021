package gachon.mpclass.a210513_internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private final static String NOTES = "notes.txt";
    private EditText txtUIData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUIData = (EditText) findViewById(R.id.txtUIData);
        Button btn = (Button) findViewById(R.id.close);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(NOTES, 0));
            out.write(txtUIData.getText().toString());
            out.close();
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            InputStream in = openFileInput(NOTES);
            if (in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";
                StringBuffer buf = new StringBuffer();

                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
                }
                in.close();
                txtUIData.setText(buf.toString());
            }
        } catch (java.io.FileNotFoundException e) {
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();

        }


    }
}