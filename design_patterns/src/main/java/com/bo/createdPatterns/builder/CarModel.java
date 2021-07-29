package com.bo.createdPatterns.builder;

import java.util.ArrayList;

//车子模型
public abstract class CarModel {
    //各个基本方法执行顺序
    private ArrayList<String> sequence = new ArrayList<>();

    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engineBoom();

    final public void run(){
        for (int i = 0; i < this.sequence.size(); i++) {
            String actionName = this.sequence.get(i);
            if(actionName.equalsIgnoreCase("start")){
                this.start();
            }else if(actionName.equalsIgnoreCase("stop")){
                this.stop();
            }else if(actionName.equalsIgnoreCase("alarm")){
                this.alarm();
            }else if(actionName.equalsIgnoreCase("engineBoom")){
                this.engineBoom();
            }
        }
    }

    public final void setSequence(ArrayList<String> sequence){
        this.sequence = sequence;
    }



}
