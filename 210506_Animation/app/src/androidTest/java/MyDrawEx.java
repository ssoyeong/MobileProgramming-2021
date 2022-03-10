import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyDrawEx extends View {
    private Paint mPaint;

    private Bitmap mAndroidGreen;
    private Bitmap mAndroidRed;
    private int nAngle = 0;
    public void init(){

        mPaint = new Paint();
        Resources res = getResources();
        mAndroidGreen = BitmapFactory.decodeResource(res, R.drawable.android_green);
        mAndroidRed = BitmapFactory.decodeResource(res, R.drawable.android_red);

    }

    public MyDrawEx(Context c){
        super(c);
        init();
    }

    public MyDrawEx(Context c, AttributeSet a){
        super(c,a)
                init();
    }

    public boolean onTouchEvent(MotionEvent event){

        if(event.getAction() == MotionEvent.ACTION_UP){
            nAngle = naAngle + 5;
            invalidate();
        }
        return true;
    }

    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(mAndroidGreen, 0, 0, mPaint);
        canvas.save();
        canvas.rotate(nAngle);
        canvas.drawBitmap(mAndroidRed, 0, 0. mPaint);
    }
}
