package smartbj.fragment;

import android.view.View;

import com.iceblood.dalu.smartbj.R;

/**
 * Created by DALU on 2016/7/13.
 */
public class LeftFragment extends BaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_left, null);
        return view;
    }
}
