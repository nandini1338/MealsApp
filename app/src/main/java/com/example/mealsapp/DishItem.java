package com.example.mealsapp;

public class DishItem {

    private String dishname1;
    private int pic1;

    public DishItem(String dishname, int pic){
         dishname1 = dishname;
         pic1 = pic;
    }

    public String getDishName(){
        return dishname1;
    }

    public int getPic(){
        return pic1;
    }
}
