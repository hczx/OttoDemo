package instrument;

import android.app.Activity;
import android.graphics.RadialGradient;

import com.kaopiz.kprogresshud.KProgressHUD;

import static instrument.Preconditions.checkNotNull;

/**
 * Created by Jam on 2016/3/9.
 * Activity &Fragment 公共工具类
 */
public class StarterCommon {
    private KProgressHUD mHud;
    private Activity activity;

    public StarterCommon(Activity activity) {
        checkNotNull(activity, "activity == null");
        this.activity = activity;
    }

    public static StarterCommon create(Activity activity) {
        return new StarterCommon(activity);
    }

    public void onDestroy() {
        mHud = null;
        activity = null;
    }
    //hud加载框
    public void showHud(String text, boolean isCancellable) {
        if (!isFinishing()) {
            mHud = HudUtils.showHud(activity, text, isCancellable);
        }
    }

    public void showHud(String text) {
        if (!isFinishing()) {
            showHud(text, false);
        }
    }

    public void showHud(int resId) {
        if (!isFinishing()) {
            showHud(activity.getString(resId));
        }
    }


    public void dismissHud() {
        if (mHud != null && !isFinishing()) {
            mHud.dismiss();
        }
    }

    //keyboard键盘

    /**
     * 隐藏软键盘
     */
    public void hideSoftInputMethod() {
        try {
            if (activity.getCurrentFocus() != null) {
                KeyboardUtils.hide(activity, activity.getCurrentFocus().getWindowToken());
            }
        } catch (Exception e) {
            //Nothing
        }
    }

    /**
     * 显示软键盘
     */
    public void showSoftInputMethod() {
        try {
            KeyboardUtils.show(activity);
        } catch (Exception e) {
            //Nothing
        }
    }

    public boolean isImmActive() {
        return KeyboardUtils.isActive(activity);
    }

    private boolean isFinishing() {
        return activity == null || activity.isFinishing();
    }

}
