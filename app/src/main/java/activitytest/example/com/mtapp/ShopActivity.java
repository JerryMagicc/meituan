package activitytest.example.com.mtapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import activitytest.example.com.mtapp.Adapter.ShopAdapter;
import activitytest.example.com.mtapp.shiti.Order;
import activitytest.example.com.mtapp.shiti.Shop;

/**
 * Created by Administrator on 2018/8/13.
 */

public class ShopActivity  extends BaseActivity{
    Shop shop;
    Order order;
    ShopAdapter shopAdapter;
    TextView textView;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        textView = findViewById(R.id.shopname1);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShopActivity.this,"tab",Toast.LENGTH_LONG).show();
            }
        });

        Intent intent  = getIntent();
        Bundle bundle = intent.getExtras();
        Bundle bundle2 = intent.getExtras();
        if(bundle!=null){
        order = (Order) bundle.getSerializable("key");
        shop = (Shop)bundle2.getSerializable("key2");
        }
        textView.setText(order.getShopName());

    }
}
