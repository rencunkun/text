package com.rencunkun.demo.com.text.com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JdkDynamicState {
    public static void main(String[] args) {
        RenKunTao  renKunTao=new RenKunTao();
       JdkProxy jdkProxy=new JdkProxy( renKunTao);
        Realize realize= (Realize) java.lang.reflect.Proxy.newProxyInstance(renKunTao.getClass().getClassLoader(),renKunTao.getClass().getInterfaces(),jdkProxy);
        realize.maifang();
    }

}
class  RenKunTao implements  Realize{

    @Override
    public void maifang() {
        System.out.println("我是任坤涛 请问有什么可以为你服务的");
    }
}


interface  Realize {
    void maifang();
}

//jdk 动态代理
 class JdkProxy  implements InvocationHandler {
    //目标对象
    private Object tarjet;
     JdkProxy(RenKunTao renKunTao){
        this.tarjet=renKunTao;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("我是任存坤，现在开始了");
        Object invoke = method.invoke(tarjet, args);
        System.out.println("我是任存坤，现在结束了");
        return invoke;
    }
}


