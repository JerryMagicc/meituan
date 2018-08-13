package activitytest.example.com.mtapp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

import java.lang.reflect.Field;

import activitytest.example.com.mtapp.R;
import activitytest.example.com.mtapp.shiti.PagerSlidingTabStrip;

/**
 * Created by Administrator on 2018/7/30.
 */

public class OrderFragment extends BaseFragment {
    private PagerSlidingTabStrip tabs;//PagerSlidingTabStrip的实例
    private DisplayMetrics dm;


    private OrderFragment_Order orderFragment_order;
    private OrderFragment_assess orderFragment_assess;
    private OrderFragment_Return orderFragment_return;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order,null);

        setOverflowShowingAlways();
        dm = getResources().getDisplayMetrics();

        ViewPager pager = (ViewPager)view. findViewById(R.id.viewpager);

        pager.setOffscreenPageLimit(0);
        //设置ViewPager的缓存界面数,默认缓存为2
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);


        pager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));

        tabs.setViewPager(pager);
        setTabsValue();
        return view;
    }

    private void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(getParentFragment().getActivity());
            Field menuKeyField = ViewConfiguration.class
                    .getDeclaredField("");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        tabs.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        tabs.setDividerColor(Color.TRANSPARENT);
        // 设置Tab底部线的高度
        tabs.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        tabs.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, dm));
        // 设置Tab标题文字的大小
        tabs.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab Indicator的颜色
        tabs.setIndicatorColor(Color.parseColor("#d83737"));//#d83737   #d83737(绿)
        // 取消点击Tab时的背景色
        tabs.setTabBackground(0);

    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private final String[] titles = { " 全部订单 ", "   未评价   ", "     退款     " };

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (orderFragment_order == null) {
                        orderFragment_order = new OrderFragment_Order();
                    }
                    return orderFragment_order;
                case 1:
                    if (orderFragment_assess == null) {
                        orderFragment_assess = new OrderFragment_assess();
                    }
                    return orderFragment_assess;
                case 2:
                    if (orderFragment_return == null) {
                        orderFragment_return = new OrderFragment_Return();
                    }
                    return orderFragment_return;
                default:
                    return null;
            }

        }
    }
}
