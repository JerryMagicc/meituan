package activitytest.example.com.mtapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import activitytest.example.com.mtapp.R;
import activitytest.example.com.mtapp.ShopActivity;
import activitytest.example.com.mtapp.shiti.Shop;

/**
 * Created by Administrator on 2018/8/23.
 */

public class ShopAdapter extends BaseAdapter {
    private List<Shop>list;
    private Context context;
    public ShopAdapter(Context context, List<Shop> list){
        this.context=context;
        this.list = list;
    }
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
    public View getView(final int i, View view, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (view ==null){
            String Shopname;
            Shopname = list.get(i).getshopName();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.shopadapter,null);
            viewHolder = new ViewHolder();
            viewHolder.shopname = view.findViewById(R.id.shopname2);
            viewHolder.ShopLayout = view.findViewById(R.id.ShopLayout);
            viewHolder.shopname.setText(Shopname);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.ShopLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShopActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("key2",list.get(i));
                intent.putExtras(bundle2);
                context.startActivity(intent);
            }});
        return view;
    }
    private class ViewHolder {
         TextView shopname;
         View ShopLayout;
    }
}
