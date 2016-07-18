package smartbj.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

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
    RadioGroup rg;
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

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        vp.setCurrentItem(0,false);
                        break;
                    case R.id.rb_news:
                        vp.setCurrentItem(1,false);
                        break;
                    case R.id.rb_smart:
                        vp.setCurrentItem(2,false);
                        break;
                    case R.id.rb_gov:
                        vp.setCurrentItem(3,false);
                        break;
                    case R.id.rb_setting:
                        vp.setCurrentItem(4,false);
                        break;
                    default:
                        vp.setCurrentItem(0,false);
                        break;
                }
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                BasePager bp = allPager.get(position);
                bp.initData();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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

        rg = (RadioGroup) view.findViewById(R.id.rg_group);

        return view;

    }
}
