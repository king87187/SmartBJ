package smartbj.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * 主页面
 * 
 * @author Kevin
 * @date 2015-10-17
 */
public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题,
		// 必须在setContentView之前调用

	}
}
