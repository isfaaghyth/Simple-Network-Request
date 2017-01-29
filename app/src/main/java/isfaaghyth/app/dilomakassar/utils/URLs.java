package isfaaghyth.app.dilomakassar.utils;

import isfaaghyth.app.dilomakassar.BuildConfig;

/**
 * Created by isfaaghyth on 28/1/17.
 */

public class URLs {

    private final static String BASE_URL = BuildConfig.URI;

    private final static String DATA = "android/data.php";

    public static String getData() {
        return BASE_URL + DATA;
    }
}
