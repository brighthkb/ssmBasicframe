package com.sczh.weixin.core.entity.message.req;

/**
 * 文本消息
 * 
 * @author xiaoling
 * @date 2017-11-19
 */
public class TextMessage extends BaseMessage {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}