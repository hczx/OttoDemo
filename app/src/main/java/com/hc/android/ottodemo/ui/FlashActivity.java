package com.hc.android.ottodemo.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.hc.android.ottodemo.MainActivity;
import com.hc.android.ottodemo.R;
import com.nineoldandroids.animation.Animator;

import baserobot.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 99165 on 2016/3/31.
 */
public class FlashActivity extends BaseActivity {


    @Bind(R.id.flash_start)
    TextView mStart;
    @Bind(R.id.rootLayout)
    CoordinatorLayout rootLayout;
    @Bind(R.id.flash_title)
    CardView mTitle;

    private android.animation.Animator btnAnimator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.flash_start)
    public void onClick() {
        //这五个参数分别是： view 操作的视图 centerX 动画开始的中心点X centerY 动画开始的中心点Y startRadius 动画开始半径 startRadius 动画结束半径
        btnAnimator = ViewAnimationUtils.createCircularReveal(
                rootLayout,
                rootLayout.getWidth(),
                rootLayout.getHeight(),
                0, (float) Math.hypot(rootLayout.getWidth(), rootLayout.getHeight()));
        btnAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        btnAnimator.addListener(new android.animation.Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(android.animation.Animator animation) {
            }

            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                rootLayout.setBackgroundResource(R.color.windowBackground);
                mTitle.setVisibility(View.VISIBLE);
                showCenterAnim();
            }

            @Override
            public void onAnimationCancel(android.animation.Animator animation) {

            }

            @Override
            public void onAnimationRepeat(android.animation.Animator animation) {

            }
        });
        btnAnimator.setDuration(1000);
        btnAnimator.start();
        rootLayout.setBackgroundResource(R.color.colorAccent);
    }


    /**
     * 中间动画
     */
    private void showCenterAnim() {

        int[] loaction = new int[2];
        rootLayout.getLocationInWindow(loaction);

        android.animation.Animator centerAnimator = ViewAnimationUtils.createCircularReveal(
                mTitle,
                loaction[0],
                loaction[1],
                (float) mTitle.getWidth(),
                0);
        centerAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        centerAnimator.addListener(new android.animation.Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(android.animation.Animator animation) {

            }

            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                mTitle.setVisibility(View.GONE);
                MainActivity.startMainActivity(FlashActivity.this);
            }

            @Override
            public void onAnimationCancel(android.animation.Animator animation) {

            }

            @Override
            public void onAnimationRepeat(android.animation.Animator animation) {

            }
        });

        centerAnimator.setDuration(1000).start();
    }


}
