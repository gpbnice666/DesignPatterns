package com.bo.structuralPattern.adapter.interfaceAdapter;

public interface HandlerAdapter {
    public boolean supports(Object handle);
    public void handle(Object handle);
}
