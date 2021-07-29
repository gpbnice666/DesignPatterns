package com.bo.structuralPattern.adapter.interfaceAdapter;

import com.bo.structuralPattern.adapter.interfaceAdapter.adapterImpl.HttpHandlerAdapter;
import com.bo.structuralPattern.adapter.interfaceAdapter.adapterImpl.OtherHandlerAdapter;
import com.bo.structuralPattern.adapter.interfaceAdapter.adapterImpl.SimpleHandlerAdapter;
import com.bo.structuralPattern.adapter.interfaceAdapter.impl.HttpController;

import java.util.ArrayList;
import java.util.List;

public class DispatchServlet {
    public static List<HandlerAdapter> handlerAdapters=new ArrayList<HandlerAdapter>();

    DispatchServlet() {
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
        handlerAdapters.add(new OtherHandlerAdapter());
    }

    public void doDispatch() {
        HttpController httpController=new HttpController();//创建被适配者(适配器可以获取到希望的Controller)
        HandlerAdapter handlerAdapter=getHandler(httpController);//创建适配器并进行适配(得到适配器)
        handlerAdapter.handle(httpController);//通过适配器执行对应的controller对应方法
    }

    public HandlerAdapter getHandler(Controller controller) {
        for(HandlerAdapter adapter:handlerAdapters) {
            if(adapter.supports(controller)) {
                return adapter;//根据得到的controller(handler)返回对应的适配器
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //适配器与控制器(目标)解耦
        new DispatchServlet().doDispatch();
    }

}
