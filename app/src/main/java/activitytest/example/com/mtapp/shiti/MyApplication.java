package activitytest.example.com.mtapp.shiti;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2018/8/9.
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;
    /**
     * 获取context
     * @return
     */
    public static Context getInstance() {
        if (mInstance == null) {
            mInstance = new MyApplication();
        }
        return mInstance;
    }
}
