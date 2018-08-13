package activitytest.example.com.mtapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import activitytest.example.com.mtapp.R;
import activitytest.example.com.mtapp.ShopActivity;
import activitytest.example.com.mtapp.shiti.Shop;

/**
 * Created by Administrator on 2018/8/6.
 */

public class ListViewAdapter extends BaseAdapter {
    private List<Shop> list;
    private Context context;

    public ListViewAdapter(Context context, List<Shop> list){
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView==null){
            String ShopName;
            String Food;
            double Money;
            ShopName = list.get(position).getshopName();
            Food = list.get(position).getFood();
            Money = list.get(position).getMoney();
            LayoutInflater inflater = LayoutInflater.from(context);

            convertView  = inflater.inflate(R.layout.myapadter,null);
            viewHolder = new ViewHolder();

            viewHolder.shopName = convertView.findViewById(R.id.textView2);
            viewHolder.money = convertView.findViewById(R.id.textView3);
            viewHolder.food = convertView.findViewById(R.id.textView4);
            viewHolder.again = convertView.findViewById(R.id.again);
            convertView.setTag(viewHolder);

            viewHolder.shopName.setText(ShopName);
            viewHolder.food.setText(Food);
            viewHolder.money.setText(String.valueOf(Money));

        }else{
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShopActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("key",list.get(position).getshopName());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return convertView;
    }


    private class ViewHolder {
        TextView shopName;
        TextView money;
        TextView food;
        Button again;
    }

}
