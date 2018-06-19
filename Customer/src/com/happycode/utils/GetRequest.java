package com.happycode.utils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 对GET请求参数加以处理！
 *
 */
public class GetRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	
	public GetRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		// 获取参数
		String value = request.getParameter(name);
		if(value == null) return null;//如果为null，直接返回null
		try {
			// 对参数进行编码处理后返回
			return new String(value.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Map getParameterMap() {
		Map<String,String[]> map = request.getParameterMap();
		if(map == null) return map;
		// 遍历map，对每个值进行编码处理
		for(String key : map.keySet()) {
			String[] values = map.get(key);
			for(int i = 0; i < values.length; i++) {
				try {
					values[i] = new String(values[i].getBytes("ISO-8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			}
		}
		// 处理后返回
		return map;
	}
}
