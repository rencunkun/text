package com.rencunkun.demo.com.text.com;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

interface  XiaoMing{
    void maiche();
}

class  XiaoHongParoxy implements  XiaoMing{

    @Override
    public void maiche() {
        System.out.println("我是小红代理");
    }
}

//实现cglib动态代理
class Cglib implements MethodInterceptor{

    @Override
    public Object intercept(Object oj, Method method, Object[] arrays, MethodProxy methodProxy) throws Throwable {
        System.out.println("请问你是");
        Object invokeSuper = methodProxy.invokeSuper(oj, arrays);
        System.out.println("现在开始购车交易手续");
        return invokeSuper;
    }
}

public class CglibProxy {
    public static void main(String[] args) {
        Cglib cglib=new Cglib();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(XiaoHongParoxy.class);
        enhancer.setCallback(cglib);
        XiaoMing xiaoMing = (XiaoMing) enhancer.create();
        xiaoMing.maiche();
    }
}
