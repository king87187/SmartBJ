package smartbj.base.impl;

import android.app.Activity;
import android.widget.TextView;

import smartbj.base.BasePager;

/**
 * Created by DALU on 2016/7/13.
 */
public class IndexPager extends BasePager {
    public IndexPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        TextView textView = new TextView(mActivity);
        textView.setText("首页");
        textView.setTextSize(22);
        flContent.addView(textView);
        tvTitle.setText("智慧北京");
    }

}
