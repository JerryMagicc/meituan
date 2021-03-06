/**
 * 考核项目-美团APP
 * by Jerry
 * 2018/7/18
 */
package activitytest.example.com.mtapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import activitytest.example.com.mtapp.shiti.MyUser;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //注册按钮
    private Button btn_registered;
    private Button btn_load;
    private EditText et_name;
    private EditText et_password;
    private CheckBox keep_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "9fa2d3643cd24762f417759a18bf4c1c");

        initView();
    }
    private void initView(){
        btn_registered = findViewById(R.id.btn_registered);
        btn_registered.setOnClickListener(this);
        btn_load = findViewById(R.id.btn_load);
        btn_load.setOnClickListener(this);
        et_name=findViewById(R.id.et_name);
        et_password=findViewById(R.id.et_password);
        keep_password = findViewById(R.id.keep_password);
        //设置选中状态
        boolean isCheck = ShareUtils.getBoolean(this,"keeppass",false);
        keep_password.setChecked(isCheck);
        if(isCheck){
            et_name.setText(ShareUtils.getString(this,"name",""));
            et_password.setText(ShareUtils.getString(this,"password",""));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_load:
                String name =et_name.getText().toString().trim();
                String password=et_password.getText().toString().trim();
                if(!TextUtils.isEmpty(name)){
                    if(!TextUtils.isEmpty(password)){
                        final MyUser user = new MyUser();
                        user.setUsername(name);
                        user.setPassword(password);
                        user.login(new SaveListener<MyUser>() {
                            @Override
                            public void done(MyUser myUser, BmobException e) {
                                if(e==null){
                                    Toast.makeText(LoginActivity.this,"欢迎回来    "+et_name.getText().toString(),Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(LoginActivity.this,MainActivity.class));

                                }else{
                                    Toast.makeText(LoginActivity.this,"登录失败"+e.toString(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                    }else{
                        Toast.makeText(this,"密码不能为空",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this,"用户名不能为空",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_registered:
                startActivity(new Intent(this,RegisteredActivity.class));
                break;
        }
    }
    @Override
        protected void onDestroy(){
        super.onDestroy();

        //保存状态
        ShareUtils.putBoolean(this,"keeppass",keep_password.isChecked());

        //是否记住密码
        if(keep_password.isChecked()){
            //记住用户名和密码
            ShareUtils.putString(this,"name",et_name.getText().toString().trim());
            ShareUtils.putString(this,"password",et_password.getText().toString().trim());
        }else{
            ShareUtils.deleShare(this,"name");
            ShareUtils.deleShare(this,"password");
        }

        }
    }

