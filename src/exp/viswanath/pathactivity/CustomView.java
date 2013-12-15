package exp.viswanath.pathactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/*
 * 
 * Author: Viswanath L
 * 
 * iamviswanathl@gmail.com
 * 
 * 09-Dec-2013
 *
 */

public class CustomView extends View
{
	private Paint paint;
	private Path path;

	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);

		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeWidth(4);
		paint.setAntiAlias(true);

		path = new Path();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		int width = canvas.getWidth();
		int height = canvas.getHeight();

		final int side = 40;

		// Moving to the left top point
		path.moveTo((width - side)/2 , (height - side)/2); 

		//Drawing the 4 sides of square in the order left-bottom-right-top 
		path.lineTo((width - side)/2, (height + side)/2);
		path.lineTo((width + side)/2, (height + side)/2);
		path.lineTo((width + side)/2, (height - side)/2);
		path.lineTo((width - side)/2 , (height - side)/2); 

		//Adding an arc to the left side
		path.addArc(new RectF(width/2 - side, (height - side)/2, width/2, (height + side)/2), 90, 180);
		
		path.close(); 

		canvas.drawPath(path, paint);
	}
}