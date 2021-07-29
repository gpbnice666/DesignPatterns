package com.bo.structuralPattern.adapter.interfaceAdapter.adapterImpl;

import com.bo.structuralPattern.adapter.interfaceAdapter.HandlerAdapter;
import com.bo.structuralPattern.adapter.interfaceAdapter.impl.OtherController;

public class OtherHandlerAdapter implements HandlerAdapter {//适配器
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof OtherController);
	}
	@Override
	public void handle(Object handler) {
		((OtherController)handler).doOther();
	}
}
