package com.rencunkun.demo.com.text.com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//静态代理
public class staticAgency {

    public static void main(String[] args) {
        /*Hose hose = new Proxyy(new RenCunKun());
        hose.maifang();*/
       /* RenCunKun renCunKun=new RenCunKun();
        Proxyy proxyy=new Proxyy(renCunKun);
        proxyy.maifang();*/
       Integer or=0;
       if(or==null || or==0){
           System.out.println("222");
       }
    }
}

interface  Hose{
    void  maifang();
}

class RenCunKun  implements  Hose{

    @Override
    public void maifang() {
        System.out.println("我是任存坤，我上上了");
    }
}

//代理对象
class Proxyy implements  Hose{
    private RenCunKun renCunKun;


    public Proxyy(RenCunKun renCunKun){
        this.renCunKun=renCunKun;
    }
    @Override
    public void maifang() {
        System.out.println("我是中介，你买房开始交给我了。");
        renCunKun.maifang();
        System.out.println("我是任存坤 ，你买房已经结束了");
    }
}

