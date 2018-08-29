package activitytest.example.com.mtapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import activitytest.example.com.mtapp.Adapter.ShopAdapter;
import activitytest.example.com.mtapp.shiti.Shop;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2018/8/22.
 */

public class AddActivity extends BaseActivity{
    List<Shop> list;
    ListView listView;
    ShopAdapter shopAdapter;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        shopAdapter = new ShopAdapter(AddActivity.this,list);
        loadData();
        listView = findViewById(R.id.list_add);

    }
    private void loadData(){

        BmobQuery<Shop> bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<Shop>() {
            @Override
            public void done(final List<Shop> list, BmobException e) {
                if (e == null){
                    listView.setAdapter(new ShopAdapter(AddActivity.this,list));

                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
}
