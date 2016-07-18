package smartbj.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.iceblood.dalu.smartbj.R;

/**
 * Created by DALU on 2016/7/13.
 */
public class BasePager {
    public Activity mActivity;
    public View mRootView;
    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flContent;

    public BasePager(Activity activity){
        mActivity = activity;
        mRootView = initView();

    }

    private View initView() {
        View view = View.inflate(mActivity, R.layout.base_pager, null);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        btnMenu = (ImageButton) view.findViewById(R.id.btn_menu);
        flContent = (FrameLayout) view.findViewById(R.id.fl_content);
        return view;
    }
    // 初始化数据
    public void initData() {

    }
}
