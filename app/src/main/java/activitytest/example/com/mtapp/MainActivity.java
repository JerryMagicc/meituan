package activitytest.example.com.mtapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.support.v7.widget.Toolbar;

import activitytest.example.com.mtapp.fragment.HomeFragment;
import activitytest.example.com.mtapp.fragment.MyselfFragment;
import activitytest.example.com.mtapp.fragment.OrderFragment;

/**
 * Created by Administrator on 2018/7/26.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Toolbar toolbar;
    private RadioButton rb_home;
    private RadioButton rb_order;
    private RadioButton rb_myself;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.content_layout, new HomeFragment());

        transaction.commit();
    }


    public void initView(){//初始化点击控件
        rb_home = findViewById(R.id.rb_main);
        rb_order = findViewById(R.id.rb_order);
        rb_myself = findViewById(R.id.rb_myself);
        toolbar = findViewById(R.id.toolbar);
        rb_home.setOnClickListener(this);
        rb_order.setOnClickListener(this);
        rb_myself.setOnClickListener(this);
        setSupportActionBar(toolbar);

    }



    @Override
    public void onClick(View view) {
        transaction = manager.beginTransaction();

        switch (view.getId()){
            case R.id.rb_main:
                transaction.replace(R.id.content_layout,new HomeFragment());
                break;
            case R.id.rb_order:
                transaction.replace(R.id.content_layout,new OrderFragment());
                break;
            case R.id.rb_myself:
                transaction.replace(R.id.content_layout,new MyselfFragment());
                break;

        }
        transaction.commit();
    }


}