package gachon.mpclass.a210429_graphicspaint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView vw = new MyView(this);
        setContentView(vw);
    }

    protected class MyView extends View {
        public MyView(Context context){

            super(context);
        }

        @Override
        public void onDraw(Canvas canvas){
//            Paint Pnt = new Paint(Paint.ANTI_ALIAS_FLAG);

//            Pnt.setStrokeWidth(8);
//            Pnt.setColor(Color.RED);
//
//            Pnt.setStyle(Paint.Style.FILL);
//            canvas.drawCircle(50, 50, 40, Pnt);
//
//            Pnt.setStyle(Paint.Style.STROKE);
//            canvas.drawCircle(150, 50, 40, Pnt);
//
//            Pnt.setStyle(Paint.Style.FILL_AND_STROKE);
//            canvas.drawCircle(250, 50, 40, Pnt);
//
//            Pnt.setColor(Color.BLUE);
//            Pnt.setStyle(Paint.Style.FILL);
//            canvas.drawCircle(50, 150, 40, Pnt);
//            Pnt.setColor(Color.RED);
//            Pnt.setStyle(Paint.Style.STROKE);
//            canvas.drawCircle(50, 150, 40, Pnt);
//
//            Pnt.setColor(Color.RED);
//            Pnt.setStyle(Paint.Style.STROKE);
//            canvas.drawCircle(150, 150, 40, Pnt);
//            Pnt.setColor(Color.BLUE);
//            Pnt.setStyle(Paint.Style.FILL);
//            canvas.drawCircle(150, 150, 40, Pnt);

            // 주석 처리하여 두 문제를 각각 실행하였습니다.

//            Pnt.setColor(Color.BLUE);
//            Pnt.setStrokeWidth(16);
//            canvas.drawLine(50, 30, 240, 30, Pnt);
//            Pnt.setStrokeCap(Paint.Cap.ROUND);
//            canvas.drawLine(50, 60, 240, 60, Pnt);
//            Pnt.setStrokeCap(Paint.Cap.SQUARE);
//            canvas.drawLine(50, 90, 240, 90, Pnt);
//
//            Pnt.setColor(Color.BLACK);
//            Pnt.setStrokeWidth(20);
//            Pnt.setStyle(Paint.Style.STROKE);
//
//            Pnt.setStrokeJoin(Paint.Join.MITER);
//            canvas.drawRect(50, 150, 90, 200, Pnt);
//            Pnt.setStrokeJoin(Paint.Join.BEVEL);
//            canvas.drawRect(120, 150, 160, 200, Pnt);  Pnt.setStrokeJoin(Paint.Join.ROUND);
//            canvas.drawRect(190, 150, 230, 200, Pnt);






            Path path = new Path();
            canvas.drawColor(Color.WHITE);

            Paint Pnt = new Paint();
            Pnt.setStrokeWidth(5);
            Pnt.setColor(Color.RED);
            Pnt.setStyle(Paint.Style.STROKE);

            path.addRect(100, 00, 150, 90, Path.Direction.CW);
            path.addCircle(50, 50, 40, Path.Direction.CW);
            canvas.drawPath(path, Pnt);

            path.reset();
            path.moveTo(10, 110);
            path.lineTo(50, 150);
            path.lineTo(400, 10);
            Pnt.setStrokeWidth(3);
            Pnt.setColor(Color.BLUE);
            canvas.drawPath(path, Pnt);

            Pnt.setTextSize(20);
            Pnt.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath("Text on Path.", path, 0, 0, Pnt);


        }

    }
}