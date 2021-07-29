package com.bo.structuralPattern.adapter.interfaceAdapter.adapterImpl;

import com.bo.structuralPattern.adapter.interfaceAdapter.HandlerAdapter;
import com.bo.structuralPattern.adapter.interfaceAdapter.impl.SimpleController;

public  class SimpleHandlerAdapter implements HandlerAdapter {//适配器
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof SimpleController);
	}
	@Override
	public void handle(Object handler) {
		((SimpleController) handler).doSimple();
	}
}
