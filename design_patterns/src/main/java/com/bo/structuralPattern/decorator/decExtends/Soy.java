package com.bo.structuralPattern.decorator.decExtends;

import com.bo.structuralPattern.decorator.Beverage;
import com.bo.structuralPattern.decorator.Decorator;

/**
 * @author gpb
 * 具体装饰类
 */
public class Soy extends Decorator {

	private String description = "加了豆浆！";

	private Beverage beverage = null;

	public Soy(Beverage beverage){
		this.beverage = beverage;
	}
	public String getDescription(){
		return beverage.getDescription()+"\n"+description;
	}

	public Double getPrice(){
		return beverage.getPrice()+15;	//15表示豆浆的价格
	}
}
