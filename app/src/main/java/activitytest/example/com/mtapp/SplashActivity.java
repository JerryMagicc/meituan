package activitytest.example.com.mtapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import activitytest.example.com.mtapp.shiti.StaticClass;

import static activitytest.example.com.mtapp.shiti.StaticClass.SHARE_IS_FIRST;

/**
 * Created by Administrator on 2018/7/26.
 */

public class SplashActivity extends AppCompatActivity {


    private TextView tv_splash;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case StaticClass.HANDLER_SPLASH:

                    if(isFirst()){
                        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    }
                    finish();

                    break;

            }

        }
    };


    /**
     * 判断是否第一次运行
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,2000);

        tv_splash = findViewById(R.id.tv_splash);


    }
    private boolean isFirst(){
        boolean isFirst =ShareUtils.getBoolean(this,SHARE_IS_FIRST,true);
        if(isFirst){
            ShareUtils.putBoolean(this,StaticClass.SHARE_IS_FIRST,false);
            //第一次运行
            return true;
        }else{
            return false;
        }
    }
    //禁止返回
    @Override
     public void  onBackPressed(){

     }
}
