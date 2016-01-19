package com.zinuzoid.squaretextview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class SquareTextView extends TextView {

	private int mOffsetTop;
	private int mOffsetLeft;

	public SquareTextView(Context context) {
		super(context);
		init();
	}

	public SquareTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public SquareTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		mOffsetTop = 0;
		mOffsetLeft = 0;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int width = getMeasuredWidth();
		int height = getMeasuredHeight();
		int maxSize = Math.max(width, height);
		if(width > height) {
			mOffsetTop = width - height;
			mOffsetLeft = 0;
		} else {
			mOffsetTop = 0;
			mOffsetLeft = height - width;
		}

		setMeasuredDimension(maxSize, maxSize);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.save();
		canvas.translate(mOffsetLeft / 2f, mOffsetTop / 2f);
		super.onDraw(canvas);
		canvas.restore();
	}

}
