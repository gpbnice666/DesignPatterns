package com.bo.structuralPattern.adapter.interfaceAdapter.adapterImpl;

import com.bo.structuralPattern.adapter.interfaceAdapter.HandlerAdapter;
import com.bo.structuralPattern.adapter.interfaceAdapter.impl.HttpController;

public class HttpHandlerAdapter implements HandlerAdapter {//适配器
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof HttpController);
	}
	@Override
	public void handle(Object handler) {
		((HttpController)handler).doHttp();
	}
}
