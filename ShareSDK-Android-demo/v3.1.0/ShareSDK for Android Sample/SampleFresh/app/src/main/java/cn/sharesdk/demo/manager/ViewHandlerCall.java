package cn.sharesdk.demo.manager;

import cn.sharesdk.demo.entity.BaseEntity;

/**
 * Created by yjin on 2017/5/10.
 */

public interface ViewHandlerCall {
	public void showLoad();

	public void cancelLoad();

	public void refreshResult(BaseEntity baseEntity);
}
