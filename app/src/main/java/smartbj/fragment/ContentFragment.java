package smartbj.fragment;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.iceblood.dalu.smartbj.R;

import java.util.ArrayList;

import smartbj.base.BasePager;
import smartbj.base.impl.GovAffairsPager;
import smartbj.base.impl.IndexPager;
import smartbj.base.impl.NewsCenterPager;
import smartbj.base.impl.SettingPager;
import smartbj.base.impl.SmartServicePager;
import smartbj.cview.NoScrollViewPager;

/**
 * Created by DALU on 2016/7/13.
 */
public class ContentFragment extends BaseFragment {
    @Override
    protected void initData() {
        allPager = new ArrayList<BasePager>();
        GovAffairsPager gap = new GovAffairsPager(mActivity);


        allPager.add(new IndexPager(mActivity));
        allPager.add(new NewsCenterPager(mActivity));
        allPager.add(new SettingPager(mActivity));
        allPager.add(new SmartServicePager(mActivity));
        allPager.add(gap);
        vp.setAdapter(new ContenFragVpadp());
    }

    class ContenFragVpadp extends PagerAdapter {

        @Override
        public int getCount() {
            return allPager.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = allPager.get(position);
            basePager.initData();
            View v = basePager.mRootView;
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
    private ArrayList<BasePager> allPager;
    NoScrollViewPager  vp;
    @Override
    protected View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);

        vp = (NoScrollViewPager) view.findViewById(R.id.vp_frag);

        return view;

    }
}
