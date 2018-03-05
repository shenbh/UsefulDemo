package com.gan.quickindex;

import java.util.Collections;

import com.alibaba.fastjson.JSON;
import com.gan.quickindex.QuickIndexBar.OnTouchLetterListener;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.OvershootInterpolator;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private QuickIndexBar quickIndexBar;
	private ListView listview;
	private TextView currentWord;

	private GameInfo games;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		quickIndexBar = (QuickIndexBar) findViewById(R.id.quickIndexBar);
		listview = (ListView) findViewById(R.id.listview);
		currentWord = (TextView) findViewById(R.id.currentWord);

		// 1.准备数据
		fillList();
		// 2.对数据进行排序
		Collections.sort(games.rows);
		// 3.设置Adapter
		listview.setAdapter(new MyAdapter(this, games));
		quickIndexBar.setOnTouchLetterListener(new OnTouchLetterListener() {
			@Override
			public void onTouchLetter(String letter) {
				// 根据当前触摸的字母，去集合中找那个item的首字母和letter一样，然后将对应的item放到屏幕顶端
				for (int i = 0; i < games.rows.size(); i++) {
					String firstWord = games.rows.get(i).initChar;
					if (letter.equals(firstWord)) {
						// 说明找到了，那么应该讲当前的item放到屏幕顶端
						listview.setSelection(i);
						break;// 只需要找到第一个就行
					}
				}
				if (letter.equals("#")) {
					listview.setSelection(0);
				}
				// 显示当前触摸的字母
				showCurrentWord(letter);
			}
		});

		// 通过缩小currentWord来隐藏
		ViewHelper.setScaleX(currentWord, 0);
		ViewHelper.setScaleY(currentWord, 0);
	}

	private boolean isScale = false;
	private Handler handler = new Handler();

	protected void showCurrentWord(String letter) {
		currentWord.setText(letter);
		if (!isScale) {
			isScale = true;
			ViewPropertyAnimator.animate(currentWord).scaleX(1f).setInterpolator(new OvershootInterpolator())
					.setDuration(450).start();
			ViewPropertyAnimator.animate(currentWord).scaleY(1f).setInterpolator(new OvershootInterpolator())
					.setDuration(450).start();
		}

		// 先移除之前的任务
		handler.removeCallbacksAndMessages(null);

		// 延时隐藏currentWord
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				// currentWord.setVisibility(View.INVISIBLE);
				ViewPropertyAnimator.animate(currentWord).scaleX(0f).setDuration(450).start();
				ViewPropertyAnimator.animate(currentWord).scaleY(0f).setDuration(450).start();
				isScale = false;
			}
		}, 1500);
	}

	private void fillList() {
		String json = "{\"rows\":[{\"allChar\":\"5173chongzhika\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"5173充值卡\",\"prodNo\":\"150240\",\"initChar\":\"#\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"baoyuyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"暴雨一卡通\",\"prodNo\":\"150140\",\"initChar\":\"b\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"bingchuantianxiatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"冰川天下通\",\"prodNo\":\"150100\",\"initChar\":\"b\",\"fuzzyChar\":\"BINGC\",\"prodPrice\":\"\"},{\"allChar\":\"jinshanyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"金山一卡通\",\"prodNo\":\"150080\",\"initChar\":\"j\",\"fuzzyChar\":\"JINS\",\"prodPrice\":\"\"},{\"allChar\":\"jiuchengyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"九城一卡通\",\"prodNo\":\"150090\",\"initChar\":\"j\",\"fuzzyChar\":\"JIUC\",\"prodPrice\":\"\"},{\"allChar\":\"jurenyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"巨人一卡通\",\"prodNo\":\"150040\",\"initChar\":\"j\",\"fuzzyChar\":\"JUREN\",\"prodPrice\":\"\"},{\"allChar\":\"junwangyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"骏网一卡通\",\"prodNo\":\"150120\",\"initChar\":\"j\",\"fuzzyChar\":\"JUNW\",\"prodPrice\":\"\"},{\"allChar\":\"kongzhongwangyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"空中网一卡通\",\"prodNo\":\"150060\",\"initChar\":\"k\",\"fuzzyChar\":\"KONGZ\",\"prodPrice\":\"\"},{\"allChar\":\"lianzhongbi\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"联众币\",\"prodNo\":\"150130\",\"initChar\":\"l\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"Mycardka\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"Mycard卡\",\"prodNo\":\"150200\",\"initChar\":\"M\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"mubiaoyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"目标一卡通\",\"prodNo\":\"150250\",\"initChar\":\"m\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"qifanyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"起凡一卡通\",\"prodNo\":\"150160\",\"initChar\":\"q\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"renrenyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"人人一卡通\",\"prodNo\":\"150230\",\"initChar\":\"r\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"shengdayikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"盛大一卡通\",\"prodNo\":\"150030\",\"initChar\":\"s\",\"fuzzyChar\":\"SHEN\",\"prodPrice\":\"\"},{\"allChar\":\"shijitianchengyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"世纪天成一卡通\",\"prodNo\":\"150210\",\"initChar\":\"s\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"souhuyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"搜狐一卡通\",\"prodNo\":\"150070\",\"initChar\":\"s\",\"fuzzyChar\":\"SOUHU\",\"prodPrice\":\"\"},{\"allChar\":\"tianyouyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"天游一卡通\",\"prodNo\":\"150220\",\"initChar\":\"t\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"tianqingyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"天晴一卡通\",\"prodNo\":\"150150\",\"initChar\":\"t\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"wanmeiyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"完美一卡通\",\"prodNo\":\"150050\",\"initChar\":\"w\",\"fuzzyChar\":\"WANM\",\"prodPrice\":\"\"},{\"allChar\":\"wangyiyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"网易一卡通\",\"prodNo\":\"150020\",\"initChar\":\"w\",\"fuzzyChar\":\"WANGY\",\"prodPrice\":\"\"},{\"allChar\":\"xunleileidian\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"迅雷雷点\",\"prodNo\":\"150180\",\"initChar\":\"x\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"zhanwangyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"战网一卡通\",\"prodNo\":\"150010\",\"initChar\":\"z\",\"fuzzyChar\":\"ZHA\",\"prodPrice\":\"\"},{\"allChar\":\"zhonghuawangyouxiyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"中华网游戏一卡通\",\"prodNo\":\"150170\",\"initChar\":\"z\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"},{\"allChar\":\"zhongguangwangyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"中广网一卡通\",\"prodNo\":\"150110\",\"initChar\":\"z\",\"fuzzyChar\":\"ZHONGG\",\"prodPrice\":\"\"},{\"allChar\":\"zhongqingbaowangyikatong\",\"icon\":\"\",\"price\":\"\",\"prodName\":\"中青宝网一卡通\",\"prodNo\":\"150190\",\"initChar\":\"z\",\"fuzzyChar\":\"\",\"prodPrice\":\"\"}]}";
		games = JSON.parseObject(json, GameInfo.class);
		games.reset();
	}

}
