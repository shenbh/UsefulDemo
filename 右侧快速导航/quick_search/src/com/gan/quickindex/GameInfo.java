package com.gan.quickindex;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * QQ币信息（qqb与服务）/Game信息
 * 
 * @ClassName: QQProdInfo
 * @Description: TODO
 * @author 甘玉飞
 * @date 2016年7月21日 下午6:23:55
 *
 */
public class GameInfo implements Serializable {
	public ArrayList<QQ> rows;
	public GameInfo() {
		super();
		rows=new ArrayList<QQ>();
	}

	public class QQ implements Serializable,Comparable<QQ> {
		public String price;// 兑换价 单位：分（包含手续费）
		public String prodPrice;// 面额 分
		public String icon;// 图标
		public String prodName;// 产品名称
		public String prodNo;// 产品号
		public String allChar;
		public String initChar;
		public String fuzzyChar;
		@Override
		public int compareTo(QQ another) {
			return initChar.compareTo(another.initChar);
		}
		
	}

	/**
	 * 进行小写字母转换大写字母
	 */
	public void reset() {
		for (int i = 0; i < rows.size(); i++) {
			QQ qq=rows.get(i);
			qq.initChar=qq.initChar.toUpperCase();
			qq.allChar=qq.allChar.toUpperCase();
			qq.fuzzyChar=qq.fuzzyChar.toUpperCase();
		}
	}
}
