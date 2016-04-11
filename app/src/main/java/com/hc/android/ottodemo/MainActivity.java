package com.hc.android.ottodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hc.android.ottodemo.funcation.comment.adapter.SimpleCommentAdapterActivity;
import com.nineoldandroids.animation.Animator;

import java.util.ArrayList;
import java.util.List;

import baserobot.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.rootLayout)
    CoordinatorLayout rootLayout;
    @Bind(R.id.main_list)
    ListView mListView;

    private static final List<String> mData = new ArrayList<>();
    private static final List<Class> mActviity = new ArrayList<>();


    public static void startMainActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
        activity.finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createItem(SimpleCommentAdapterActivity.class, "通用适配器");
        createItem(SimpleCommentAdapterActivity.class, "通用适配器");

        mListView.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_single_choice, mData));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                android.animation.Animator animator = ViewAnimationUtils.createCircularReveal(
                        mListView,
                        0,
                        0,
                        0.0f,
                        (float) Math.hypot(mListView.getWidth(), mListView.getHeight()));
                animator.setDuration(1000);
                animator.addListener(new android.animation.Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(android.animation.Animator animation) {
                        mListView.setBackgroundResource(R.color.colorPrimary);
                    }

                    @Override
                    public void onAnimationEnd(android.animation.Animator animation) {
                        Intent intent = new Intent(MainActivity.this, mActviity.get(position));
                        ActivityCompat.startActivity(MainActivity.this, intent, null);
                    }

                    @Override
                    public void onAnimationCancel(android.animation.Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(android.animation.Animator animation) {

                    }
                });

                animator.start();
            }
        });
    }

    private void createItem(Class<SimpleCommentAdapterActivity> zlass, String s) {
        mData.add(s);
        mActviity.add(zlass);
    }


}
