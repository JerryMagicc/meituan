package activitytest.example.com.mtapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import activitytest.example.com.mtapp.Adapter.ListViewAdapter;
import activitytest.example.com.mtapp.R;
import activitytest.example.com.mtapp.shiti.Shop;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2018/8/2.
 */

public class OrderFragment_Order extends BaseFragment{
    @Nullable
    private ListView listView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_order,null);
        listView = view.findViewById(R.id.list_view);
        loadData();
        onClick();
        return view;
}
    private void onClick(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getActivity(),"点击了",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void loadData(){

       BmobQuery<Shop>bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<Shop>() {
            @Override
            public void done(List<Shop> list, BmobException e) {
                if (e == null){
                    listView.setAdapter(new ListViewAdapter(getActivity(),list));


                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
    }

