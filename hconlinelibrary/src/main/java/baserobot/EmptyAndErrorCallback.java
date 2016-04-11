package baserobot;

import android.graphics.drawable.Drawable;

import model.ErrorModel;

/**
 * Created by 99165 on 2016/3/14.
 */
public interface EmptyAndErrorCallback {

    void setupErrorModel(ErrorModel errorModel);

    void setupError(String title, String subtitle);

    void setupError(Drawable drawable, String title, String subtitle);

    void setupEmpty(String title, String subtitle);

    void setupEmpty(Drawable drawable, String title, String subtitle);
}
