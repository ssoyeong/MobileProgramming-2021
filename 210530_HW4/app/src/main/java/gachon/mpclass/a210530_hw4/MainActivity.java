package gachon.mpclass.a210530_hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startBtn;
    Button recBtn;
    Button pauseBtn;
    Button stopBtn;
    Button moreBtn;
    TextView time;
    Thread thread = null;
    Boolean flag = false;
    String record = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startBtn);
        pauseBtn = (Button) findViewById(R.id.pauseBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        moreBtn = (Button) findViewById(R.id.moreBtn);
        recBtn = (Button) findViewById(R.id.recordBtn);
        time = (TextView) findViewById(R.id.timeView);

        startBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                v.setVisibility(View.GONE);
                recBtn.setVisibility(View.VISIBLE);
                pauseBtn.setVisibility(View.VISIBLE);
                stopBtn.setVisibility(View.VISIBLE);
                moreBtn.setVisibility(View.VISIBLE);

                flag = true;
                thread = new Thread(new thread());
                thread.start();
            }
        });

        recBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                record += time.getText().toString() + "\n";
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                flag = !flag;
                if(flag){
                    pauseBtn.setText("일시정지");
                }
                else{
                    pauseBtn.setText("다시시작");
                }
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){


                v.setVisibility(View.GONE);
                recBtn.setVisibility(View.GONE);
                pauseBtn.setVisibility(View.GONE);
                moreBtn.setVisibility(View.GONE);
                startBtn.setVisibility(View.VISIBLE);

                if(!flag){

                    time.setText("00:00:00:00");
                    pauseBtn.setText("일시정지");
                }

                record = "";
                thread.interrupt();
            }
        });

        moreBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

               Intent intent = new Intent(MainActivity.this, NewActivity.class);
               intent.putExtra("record", record);

               startActivityForResult(intent, 0);
            }
        });
    }

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg){

            int msec = msg.arg1 % 100; //msec
            int sec = (msg.arg1 / 100) % 60; //sec
            int min = (msg.arg1 / 100) / 60; //min
            int hour = (msg.arg1 / 100) / 360; //hour
            String result = String.format("%02d:%02d:%02d:%02d", hour, min, sec, msec);

            time.setText(result);
        }
    };

    public class thread implements Runnable {

        @Override
        public void run(){

            int i = 0;
            while(true){

                while(flag){

                    Message msg = new Message();
                    msg.arg1 = i++;
                    handler.sendMessage(msg);
                    try{
                        Thread.sleep(10);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                        runOnUiThread(new Runnable(){

                            @Override
                            public void run(){

                                time.setText("");
                                time.setText("00:00:00:00");
                            }
                        });

                        return;
                    }
                }
            }
        }
    }
}