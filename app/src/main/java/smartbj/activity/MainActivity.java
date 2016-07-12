package smartbj.activity;

import android.os.Bundle;

import com.iceblood.dalu.smartbj.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

/**
 * 主页面
 * 
 * @author Kevin
 * @date 2015-10-17
 */
public class MainActivity extends SlidingActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activty_main);
		setBehindContentView(R.layout.slm_left);

		SlidingMenu slidingMenu = getSlidingMenu();
		slidingMenu.setBehindOffset(200);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

	}
}
