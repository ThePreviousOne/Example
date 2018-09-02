package com.example.playground;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

public class MainFragment extends DialogFragment {

    /** Whole slide down view. */
    private RelativeLayout slideDownView;
    private boolean down;

    @Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LayoutInflater inflater = getActivity().getLayoutInflater();
		View layout = inflater.inflate(R.layout.fragment, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
		builder.setView(layout);
		final AlertDialog dialog = builder.create();
		dialog.setCanceledOnTouchOutside(false);

		slideDownView = layout.findViewById(R.id.slide_down_view);
        /* View that accepts the touch events. */
        View handle = layout.findViewById(R.id.handle);
        handle.setOnClickListener( new View.OnClickListener() {
                float startHeight;

                @Override
                public void onClick(View v) {

                startHeight = slideDownView.getHeight();

                // Adjust the slide down height immediately with touch movements.
                    if (down) {
                    LayoutParams params = slideDownView.getLayoutParams();
                    params.height = (int) (startHeight - 300);
                    slideDownView.setLayoutParams(params);
                    down = false;
                } else {
                    LayoutParams params = slideDownView.getLayoutParams();
                    params.height = (int) (startHeight + 300);
                    slideDownView.setLayoutParams(params);
                    down = true;
                }
            }
        });

    /* Starting Y point (where touch started). */
        float yStart = 0;

        /* Default height when in the open state. */
        float closedHeight = 300;

        /* Default height when in the closed state. */
        float openHeight = 600;


        /* The last y touch that occurred. This is used to determine if the view should snap up or down on release.
         * Used in conjunction with directionDown boolean. */
        float lastY = 0;
        boolean directionDown = false;
        /*
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch(event.getAction()) {

                *//* User tapped down on screen. *//*
                case MotionEvent.ACTION_DOWN:
                    // User has tapped the screen
                    yStart = event.getRawY();
                    lastY = event.getRawY();
                    break;

                *//* User is dragging finger. *//*
                case MotionEvent.ACTION_MOVE:

                    // Calculate the total height change thus far.
                    float totalHeightDiff = event.getRawY() - yStart;

                    // Adjust the slide down height immediately with touch movements.
                    LayoutParams params = slideDownView.getLayoutParams();
                    params.height = (int)(currentHeight + totalHeightDiff);
                    slideDownView.setLayoutParams(params);

                    // Set which direction drag is moving.
                    directionDown = event.getRawY() > lastY;

                    // Set the lastY for comparison in the next ACTION_MOVE event.
                    lastY = event.getRawY();
                    break;

                *//* User lifted up finger. *//*
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:

                    *//*
                     * Need to snap either up or down. Using ValueAnimator to "finish" the action.
                     * HeightEvaluator is a custom class.
                     *//*
                    if (directionDown) {

                        // Open the sliding view.
                        int startHeight = slideDownView.getHeight() / 3;

                        ValueAnimator animation = ValueAnimator.ofObject(
                                new HeightEvaluator(slideDownView, getContext()),
                                startHeight,
                                (int) openHeight).setDuration(300);

                        // See Table 3 for other interpolator options
                        // - http://developer.android.com/guide/topics/graphics/prop-animation.html
                        animation.setInterpolator(new LinearInterpolator());
                        animation.start();

                    } else {

                        // Close the sliding view.
                        int startHeight = slideDownView.getHeight();
                        ValueAnimator animation = ValueAnimator.ofObject(
                                new HeightEvaluator(slideDownView, getContext()),
                                startHeight,
                                (int) closedHeight).setDuration(300);
                        animation.setInterpolator(new LinearInterpolator());
                        animation.start();
                    }
                    break;

            }
            return true;
        }
        });*/
        return dialog;
	}
}
