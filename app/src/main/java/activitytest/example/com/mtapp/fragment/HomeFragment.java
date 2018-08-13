package activitytest.example.com.mtapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import activitytest.example.com.mtapp.R;
/**
 * Created by Administrator on 2018/7/30.
 */
public class HomeFragment extends Fragment {
    private RollPagerView mRollPagerView;
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_home,null);
        mRollPagerView =  mView.findViewById(R.id.roll_view_pager);
        //设置播放时间间隔
        mRollPagerView.setPlayDelay(3000);
        //设置透明度
        mRollPagerView.setAnimationDurtion(500);
        //设置适配器
        mRollPagerView.setAdapter(new TestNormalAdapter());
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        //mRollPagerView.setHintView(new ColorPointHintView(this,Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
        return mView;
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.mipmap.ic_home,
                R.mipmap.ic_order,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }}

