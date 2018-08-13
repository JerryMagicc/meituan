package activitytest.example.com.mtapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import activitytest.example.com.mtapp.shiti.MyUser;
import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


/**
 * Created by Jerry on 2018/7/18.
 */

public class RegisteredActivity extends Activity implements View.OnClickListener{

    private EditText et_user;
    private EditText et_phone_number;
    private EditText et_yzm;
    private Button btn_yzm;
    private EditText et_pass;
    private EditText et_password;
    private Button btnRegistered;
    private int requestCode =1;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_registered);
        initView();
    }

    public void btn_yzm(){//发送验证码事件
        //获取输入值
        String phone_number = et_phone_number.getText().toString().trim();
        //判断是否为空
        if(!TextUtils.isEmpty(phone_number)){
            if(phone_number.length()==11){
                btn_yzm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
                BmobSMS.requestSMSCode(RegisteredActivity.this, et_phone_number.getText().toString(), "外卖小哥", new RequestSMSCodeListener() {
                    @Override
                    public void done(Integer smsId, cn.bmob.sms.exception.BmobException ex) {
                        if(ex==null){
                            Toast.makeText(RegisteredActivity.this,"发送成功",Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(RegisteredActivity.this,"发送失败",Toast.LENGTH_LONG).show();
                        }}});
            }else{
                Toast.makeText(this,"请输入正确的手机号码",Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this,"手机号不能为空",Toast.LENGTH_LONG).show();
        }}

    public void requestPermission(){//申请权限

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},requestCode);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == this.requestCode){
            for(int i=0;i<permissions.length;i++){
                if(grantResults[i]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(RegisteredActivity.this,"成功",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(RegisteredActivity.this,"失败",Toast.LENGTH_LONG).show();
                }}}}

    public void btnRegistered(){//注册事件
        //获取输入值
        final MyUser user = new MyUser();
        final String name =et_user.getText().toString().trim();
        String pass =et_pass.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        String yzm = et_yzm.getText().toString().trim();
        final String phonenumber = et_phone_number.getText().toString().trim();

        //判断是否为空
        if(!TextUtils.isEmpty(name)){
            if(!TextUtils.isEmpty(pass)&!TextUtils.isEmpty(password)) {
                if(!TextUtils.isEmpty(yzm)) {
                    if (pass.equals(password)) {

                        BmobSMS.verifySmsCode(RegisteredActivity.this,et_phone_number.getText().toString(), et_yzm.getText().toString(), new VerifySMSCodeListener() {
                            @Override
                            public void done(cn.bmob.sms.exception.BmobException ex) {
                                // TODO Auto-generated method stub
                                if(ex==null){//短信验证码已验证成功
                                    Toast.makeText(RegisteredActivity.this,"验证通过",Toast.LENGTH_SHORT).show();
                                    user.setUsername(name);
                                    user.setPassword(password);
                                    user.setMobilePhoneNumber(phonenumber);
                                    user.signUp(new SaveListener<MyUser>() {
                                        @Override
                                        public void done(MyUser myUser, BmobException e) {
                                            if (e == null) {
                                                Toast.makeText(RegisteredActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                                                finish();
                                            } else {
                                                Toast.makeText(RegisteredActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }else{
                                    Toast.makeText(RegisteredActivity.this,"验证失败",Toast.LENGTH_LONG).show();

                                }}});


                    } else {
                        Toast.makeText(this, "两次密码不一致", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this,"验证码不能为空",Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this,"密码不能为空",Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_LONG).show();
        }
    }
    private void initView() {
        et_user= findViewById(R.id.et_user);
        et_phone_number=findViewById(R.id.et_phone_number);
        et_yzm=findViewById(R.id.et_yzm);
        btn_yzm= findViewById(R.id.btn_yzm);
        et_pass=findViewById(R.id.et_pass);
        et_password=findViewById(R.id.et_password);
        btnRegistered=findViewById(R.id.btnRegistered);
        btn_yzm.setOnClickListener(this);
        btnRegistered.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        BmobSMS.initialize(RegisteredActivity.this,"9fa2d3643cd24762f417759a18bf4c1c");
       switch (view.getId()){
           case R.id.btn_yzm:
               requestPermission();
               btn_yzm();
           break;
           case R.id.btnRegistered:
               btnRegistered();
               break;

       }
    }
}
