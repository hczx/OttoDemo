package baserobot;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

import instrument.AppInfo;
import instrument.FakeCrashLibrary;
import timber.log.Timber;
import widget.StarterKit;

/**
 * Created by Jam on 2016/3/14.
 */
public abstract class BaseApplication extends Application {


    private static volatile Context sAppContent;
    private static volatile BaseApplication mInstance;
    private static volatile Handler sAppHandler;
    private static volatile AppInfo mAppInfo;

    /**
     * 根据 account json 返回 account
     *
     * @param json json value
     * @return Account
     */
    public abstract Account accountFromJson(String json);


    @Override
    public void onCreate() {
        super.onCreate();
        if (StarterKit.isDebug()) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
        initialize();
        Fresco.initialize(appContext());
    }

    private void initialize() {
        mInstance = this;
        sAppContent = getApplicationContext();
        sAppHandler = new Handler(sAppContent.getMainLooper());
    }

    public static AppInfo appInfo() {
        if (mAppInfo == null) {
            mAppInfo = new AppInfo(appContext());
        }
        return mAppInfo;
    }

    public static Context appContext() {
        return sAppContent;
    }

    public static Resources appResources() {
        return appContext().getResources();
    }

    /**
     * application handler
     */
    public static Handler appHandler() {
        return sAppHandler;
    }

    /**
     * current application instance
     */
    /**
     * @return current application instance
     */
    public static BaseApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        sAppContent = null;
        mInstance = null;
        sAppHandler = null;
        mAppInfo = null;
    }

    /**
     * A tree which logs important information for crash reporting.
     */
    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }

            FakeCrashLibrary.log(priority, tag, message);

            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t);
                }
            }
        }
    }
}
