package dam2.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View{

	public CanvasView(Context context){
		super(context);
		
	}

	public CanvasView(Context context, AttributeSet attrs){
		super(context,attrs);
		
	}
	
	public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	
	
	
	private Paint p;
	private Path pa;
	private Bitmap bmp;
	
	private Canvas myCanvas;
	
	
	public void confCanvas(){
		
		this.p = new Paint();
		this.p.setStyle(Paint.Style.FILL);
		this.p.setColor(getResources().getColor(R.color.blue));
		
		
		
		//canvas.drawPaint(p);
		
	}
	
	
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		
		this.bmp = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
		this.myCanvas = new Canvas(this.bmp);
		
	}
	
	
	
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		this.confCanvas();
		canvas.drawBitmap(this.bmp, 0, 0, this.p);
		
		this.p.setColor(getResources().getColor(R.color.white));
		this.p.setStrokeWidth(10F);
		
		
	}
	
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		switch(event.getAction()){
		
			case MotionEvent.ACTION_UP:
				float x = event.getX();
				float y = event.getY();		
				myCanvas.drawCircle(x, y, 150, p);
			break;
				
		}
		
		invalidate();
		return true;
	}
	
}
