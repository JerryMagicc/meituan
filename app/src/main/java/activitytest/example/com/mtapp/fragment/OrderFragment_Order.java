package activitytest.example.com.mtapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import activitytest.example.com.mtapp.Adapter.ListViewAdapter;
import activitytest.example.com.mtapp.R;
import activitytest.example.com.mtapp.shiti.Order;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2018/8/2.
 */

public class OrderFragment_Order extends BaseFragment{
    @Nullable
    ListView listView;
    ListViewAdapter listViewAdapter;
    List<Order> list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_order,null);
        listView = view.findViewById(R.id.list_view);
        loadData();
        listViewAdapter  = new ListViewAdapter(getActivity(),list);

        return view;
}


    private void loadData(){

        BmobQuery<Order>bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<Order>() {
            @Override
            public void done(List<Order> list, BmobException e) {
                if (e == null){
                    listView.setAdapter(new ListViewAdapter(getActivity(),list));

                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
    }

