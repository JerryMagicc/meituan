package activitytest.example.com.mtapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/7/25.
 */

public class SharePreference {
    Context context;
    public SharePreference(Context context)
    {
        this.context = context;
    }

    /****设置状态   false为安装后第一次登录，true为已经登录过****/
    public void setState()
    {
        SharedPreferences sp = context.getSharedPreferences("判断", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLogin", true);
        editor.commit();
    }

    /***获取状态***/
    public boolean getState()
    {
        SharedPreferences sp = context.getSharedPreferences("判断", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("isLogin", false);
        return b;
    }
    /**启动界面的activity用
     * isLogin = sp.getState();
     if(isLogin){
     intent = new Intent(this,Activity1.class);
     }
     else {
     sp.setState();	//将登陆状态设置为true;
     intent = new Intent(this,Activity2.class);
     }
     */

}
