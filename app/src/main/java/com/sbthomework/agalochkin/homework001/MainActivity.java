package com.sbthomework.agalochkin.homework001;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mFirstAnimatedView;
    private TextView mFourAnimatedView;
    private View mSecondAnimatedView;
    private View mThirdAnimatedView;
    private ValueAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstAnimatedView = (TextView) findViewById(R.id.anim_view_first);
        mSecondAnimatedView = findViewById(R.id.anim_view_second);
        mThirdAnimatedView = findViewById(R.id.anim_view_third);
        mFourAnimatedView = (TextView) findViewById(R.id.anim_view_four);

        mAnimator = ValueAnimator.ofInt(1, 10000);
        mAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setDuration(5000);
        mAnimator.setInterpolator(new DecelerateInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer value = (Integer) valueAnimator.getAnimatedValue();
                mFirstAnimatedView.getBackground().setLevel(value);
                mFirstAnimatedView.setText(value / 100 + " %");

                mFourAnimatedView.getBackground().setLevel(value);
                mFourAnimatedView.setText(value / 100 + " %");


                mSecondAnimatedView.getBackground().setLevel(value);
                mThirdAnimatedView.getBackground().setLevel(value);
            }
        });
        mAnimator.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mAnimator.cancel();
        mAnimator.removeAllUpdateListeners();
        mAnimator = null;
    }
}
