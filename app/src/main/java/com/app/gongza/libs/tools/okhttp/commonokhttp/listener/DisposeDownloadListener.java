package com.app.gongza.libs.tools.okhttp.commonokhttp.listener;

/**
 * @author vision
 * @function 监听下载进度
 */
public interface DisposeDownloadListener extends DisposeDataListener {
	public void onProgress(int progrss);
}
