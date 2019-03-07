package com.rencunkun.demo.com.text.com;

import java.util.Date;

public class text extends Object {
    public static void main(String[] args) {
        Short i=678;
        i.toString();
        System.out.println(i);
        System.out.println("这是");
    }

    @Override
    public String toString() {
        System.out.println("nihao");
        return super.toString();
    }

    //清楚警告
    @SuppressWarnings("")
    public  void add(){
      //  new Date().parce("");
    }

    //表示方法过期
 @Deprecated
    public void   delete(){

    }

}
