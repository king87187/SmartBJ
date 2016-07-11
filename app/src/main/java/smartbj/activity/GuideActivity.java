package smartbj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.iceblood.dalu.smartbj.R;

import java.util.ArrayList;

import smartbj.utils.PrefUtils;

/**
 * 新手引导页面
 * 
 * @author Kevin
 * @date 2015-10-17
 */
public class GuideActivity extends Activity {

	private ViewPager mViewPager;
	private LinearLayout llContainer;
	private ImageView ivRedPoint;// 小红点
	private Button btnStart;

	private ArrayList<ImageView> mImageViewList; // imageView集合

	// 引导页图片id数组
	private int[] mImageIds = new int[] { R.drawable.guide_1,
			R.drawable.guide_2, R.drawable.guide_3 };

	// 小红点移动距离
	private int mPointDis;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题,
														// 必须在setContentView之前调用
		setContentView(R.layout.activity_guide);

		mViewPager = (ViewPager) findViewById(R.id.vp_guide);
		btnStart = (Button) findViewById(R.id.btn_start);

		initData();// 先初始化数据
		mViewPager.setAdapter(new GuideAdapter());// 设置数据

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// 某个页面被选中
				if (position == mImageViewList.size() - 1) {// 最后一个页面显示开始体验的按钮
					btnStart.setVisibility(View.VISIBLE);
				} else {
					btnStart.setVisibility(View.INVISIBLE);
				}
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// 当页面滑动过程中的回调
				System.out.println("当前位置:" + position + ";移动偏移百分比:"
						+ positionOffset);

			}

			@Override
			public void onPageScrollStateChanged(int state) {
				// 页面状态发生变化的回调
			}
		});
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//更新sp, 已经不是第一次进入了
				PrefUtils.setBoolean(getApplicationContext(), "is_first_enter", false);
				//跳到主页面
				startActivity(new Intent(getApplicationContext(), MainActivity.class));
				finish();
			}
		});
	}

	// 初始化数据
	private void initData() {
		mImageViewList = new ArrayList<ImageView>();
		for (int i = 0; i < mImageIds.length; i++) {
			ImageView view = new ImageView(this);
			view.setBackgroundResource(mImageIds[i]);// 通过设置背景,可以让宽高填充布局
			// view.setImageResource(resId)
			mImageViewList.add(view);

		}
	}

	class GuideAdapter extends PagerAdapter {

		// item的个数
		@Override
		public int getCount() {
			return mImageViewList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		// 初始化item布局
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView view = mImageViewList.get(position);
			container.addView(view);
			return view;
		}

		// 销毁item
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

	}
}
