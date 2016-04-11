package widget;

import android.net.Uri;

import java.io.File;

/**
 * Created by Jam on 2016/3/24.
 */
public class UriUtils {

    /**
     *
     * @param url
     * @return
     */
    public static Uri getUri(String url) {
        return Uri.parse(url);
    }

    public static Uri getUri(File file) {
        return Uri.fromFile(file);
    }
}
