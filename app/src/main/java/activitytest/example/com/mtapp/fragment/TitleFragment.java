package activitytest.example.com.mtapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import activitytest.example.com.mtapp.R;

/**
 * Created by Administrator on 2018/7/30.
 * 创建和使用fragment的步骤
 * 1.创建子类继承fragment
 * 2.重写onCreatView()方法 该方法主要定义fragment的布局 以view对象的形式返回fragment的视图
 * 3.将fragment引入到Activity
 */

public class TitleFragment extends Fragment {
    /**
     * fragment第一次绘制用户界面时系统回调的方法
     * 返回值view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title,null);
        RelativeLayout layout = view.findViewById(R.id.rl_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"标题栏",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
