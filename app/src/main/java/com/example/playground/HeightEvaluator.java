package com.example.playground;

import android.animation.IntEvaluator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Custom Evaluator for changing a ViewGroup's height.
 */
public class HeightEvaluator extends IntEvaluator {
	private final View view;
	private final Context context;
	 
	public HeightEvaluator(View dashboard, Context context) {
		this.view = dashboard;
		this.context = context;
	}
 
	@Override
	public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
	  ViewGroup.LayoutParams params = view.getLayoutParams();
	  params.height = super.evaluate(fraction, startValue, endValue);
	  view.setLayoutParams(params);
	  return params.height;
	}
}
