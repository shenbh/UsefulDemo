package cn.sharesdk.demo.entity;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.mob.MobSDK;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

import cn.sharesdk.demo.R;
import cn.sharesdk.framework.Platform;

/**
 * Created by yjin on 2017/5/12.
 */

/**
 * 参数设置类
 */

public class ResourcesManager {

	private static ResourcesManager instance;
	private Context context;
	public static String testImage;
	public static String testVideo;
	public static String testImageUrl;
	public static HashMap<Integer, String> testText;

	private String filePath ;
	private String title;
	private String titleUrl;
	private String url;
	private String musicUrl;
	private String text;
	private String imagePath ;
	private String imageUrl ;
	private String comment;
	private String site;
	private String siteUrl;
	private String venueName;
	private Bitmap imageBmp;
	public static final String NOTEBOOK = "notebook";
	public static final String STACK = "stack";
	public static final String[] TAGS ={"tags"} ;
	public static final boolean IS_PUBLIC =  false;
	public static final boolean IS_FRIEND = false;
	public static final boolean IS_FAMILY = false;
	public static final String VENUE_NAME = "ShareSDK";
	public String [] imgArrays;
	public static float latitude = 23.169f;
	public static float longitude = 112.908f;
	public static final String VENUE_DESCRIPTION = "This is a beautiful place!";
	public String venueId = null;
	public String checkId = null;
	public static final String EXT_INFO = "extInfo";
	public static final String ADDRESS = "address";
	private String venueDescription;

	public static ResourcesManager getInstace(Context context){
		synchronized (ResourcesManager.class){
			if(instance == null){
				synchronized (ResourcesManager.class){
					if(instance == null){
						instance = new ResourcesManager(context);
					}
				}
			}
		}
		return instance;
	}

	public String getTitle() {
		if(TextUtils.isEmpty(title)){
			return context.getString(R.string.evenote_title);
		}
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleUrl() {
		if(TextUtils.isEmpty(titleUrl)){
			return "http://mob.com";
		}
		return titleUrl;
	}

	public void setTitleUrl(String titleUrl) {
		this.titleUrl = titleUrl;
	}

	public String getUrl() {
		if(TextUtils.isEmpty(url)){
			return "http://www.mob.com";
		}
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMusicUrl() {
		if(TextUtils.isEmpty(musicUrl)){
			return "http://play.baidu.com/?__m=mboxCtrl.playSong&__a=7320512&__o=song/7320512||playBtn&fr=altg_new3||www.baidu.com#";
		}
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getText() {
		if(TextUtils.isEmpty(text)){
			return context.getString(R.string.share_content);
		}
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImagePath() {
		if(TextUtils.isEmpty(imagePath)){
			download();
		}
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getComment() {
		if(TextUtils.isEmpty(comment)){
			return context.getString(R.string.ssdk_oks_share);
		}
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSite() {
		if(TextUtils.isEmpty(site)){
			return context.getString(R.string.app_name);
		}
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getSiteUrl() {
		if(TextUtils.isEmpty(siteUrl)){
			return "http://mob.com";
		}
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getVenueName() {
		if(TextUtils.isEmpty(venueName)){
			return "ShareSDK";
		}
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueDescription() {
		if(TextUtils.isEmpty(venueDescription)){
			return "This is a beautiful place!";
		}
		return venueDescription;
	}

	public void setVenueDescription(String venueDescription) {
		this.venueDescription = venueDescription;
	}

	private ResourcesManager(final Context context){
		this.context = context;
		download();
	}

	private void download(){
		new Thread() {
			public void run() {
				String[] urls = randomPic();
				testImageUrl = urls[1];
				imageUrl = urls[1];
				try {
					testImage = BitmapHelper.downloadBitmap(MobSDK.getContext(), urls[1]);
					imageBmp = BitmapHelper.getBitmap(testImage);
					imagePath = testImage;
				} catch (Throwable t) {
					t.printStackTrace();
					testImage = null;
				}
				initTestText();
				String videoUrl = "http://f1.webshare.mob.com/dvideo/demovideos.mp4";
				try {
					testVideo = new NetworkHelper().downloadCache(MobSDK.getContext(), videoUrl, "videos", true, null);
					filePath = testVideo;
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	private void initTestText() {
		testText = new HashMap<Integer, String>();
		try {
			NetworkHelper network = new NetworkHelper();
			NetworkHelper.NetworkTimeOut timeOut = null;
			String resp = network.httpGet("http://mob.com/Assets/snsplat.json", null, null, timeOut);
			JSONObject json = new JSONObject(resp);
			int status = json.optInt("status");
			if (status == 200) {
				JSONArray democont = json.optJSONArray("democont");
				if (democont != null && democont.length() > 0) {
					for (int i = 0, size = democont.length(); i < size; i++) {
						JSONObject plat = democont.optJSONObject(i);
						if (plat != null) {
							int snsplat = plat.optInt("snsplat", -1);
							String cont = plat.optString("cont");
							testText.put(snsplat, cont);
						}
					}
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static String[] randomPic() {
		String url = "http://git.oschina.net/alexyu.yxj/MyTmpFiles/raw/master/kmk_pic_fld/";
		String urlSmall = "http://git.oschina.net/alexyu.yxj/MyTmpFiles/raw/master/kmk_pic_fld/small/";
		String[] pics = new String[]{
				"120.JPG",
				"127.JPG",
				"130.JPG",
				"18.JPG",
				"184.JPG",
				"22.JPG",
				"236.JPG",
				"237.JPG",
				"254.JPG",
				"255.JPG",
				"263.JPG",
				"265.JPG",
				"273.JPG",
				"37.JPG",
				"39.JPG",
				"IMG_2219.JPG",
				"IMG_2270.JPG",
				"IMG_2271.JPG",
				"IMG_2275.JPG",
				"107.JPG"
		};
		int index = 0;
		return new String[]{
				url + pics[index],
				urlSmall + pics[index],
				url + pics[index + 1],
				urlSmall + pics[index + 1],
				url + pics[index + 2],
				urlSmall + pics[index + 2],
				url + pics[index + 3],
				urlSmall + pics[index + 3],
				url + pics[index + 4]
		};
	}

	public String getFilePath() {
		if(TextUtils.isEmpty(filePath)){
			download();
		}
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	//#endif
	public static String actionToString(int action) {
		switch (action) {
			case Platform.ACTION_AUTHORIZING: {
				return "ACTION_AUTHORIZING";
			}
			case Platform.ACTION_GETTING_FRIEND_LIST: {
				return "ACTION_GETTING_FRIEND_LIST";
			}
			case Platform.ACTION_FOLLOWING_USER: {
				return "ACTION_FOLLOWING_USER";
			}
			case Platform.ACTION_SENDING_DIRECT_MESSAGE: {
				return "ACTION_SENDING_DIRECT_MESSAGE";
			}
			case Platform.ACTION_TIMELINE: {
				return "ACTION_TIMELINE";
			}
			case Platform.ACTION_USER_INFOR: {
				return "ACTION_USER_INFOR";
			}
			case Platform.ACTION_SHARE: {
				return "ACTION_SHARE";
			}
			default: {
				return "UNKNOWN";
			}
		}
	}

	public Bitmap getImageBmp() {
		return imageBmp;
	}

	public void setImageBmp(Bitmap imageBmp) {
		this.imageBmp = imageBmp;
	}

	public String[] getImgArrays() {
		if(imgArrays == null){
			imgArrays = new String []{};
		}
		return imgArrays;
	}

	public void setImgArrays(String[] imgArrays) {
		this.imgArrays = imgArrays;
	}
}
