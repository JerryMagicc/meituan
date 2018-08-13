package activitytest.example.com.mtapp.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import activitytest.example.com.mtapp.shiti.MyApplication;

/**
 * Created by Administrator on 2018/8/9.
 */

public class BaseFragment extends Fragment {
    private Activity activity;

    public Context getContext() {
        if (activity == null) {
            return MyApplication.getInstance();
        }
        return activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = getActivity();
    }
}
