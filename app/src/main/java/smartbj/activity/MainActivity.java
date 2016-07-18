package smartbj.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.iceblood.dalu.smartbj.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import smartbj.fragment.ContentFragment;
import smartbj.fragment.LeftFragment;

/**
 * 主页面
 *
 * @author Kevin
 * @date 2015-10-17
 */
public class MainActivity extends SlidingFragmentActivity {

	private static final String LEFT_TAG = "100";
	private static final String CONTENT_TAG = "101";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activty_main);
		setBehindContentView(R.layout.slm_left);

		SlidingMenu slidingMenu = getSlidingMenu();
		slidingMenu.setBehindOffset(200);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		initFrament();
	}

	private void initFrament() {
		FragmentManager sfm = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = sfm.beginTransaction();
		LeftFragment leftFragment = new LeftFragment();
		fragmentTransaction.replace(R.id.fl_left,leftFragment, LEFT_TAG);
		fragmentTransaction.replace(R.id.fl_main,new ContentFragment(),CONTENT_TAG);
		fragmentTransaction.commit();


	}
}
