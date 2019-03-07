package com.rencunkun.demo.com.text.com;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//这是一个注解类  METHOD 表示这个注解只能使用在方法上 TYPE表示能在接口能加入  多个方法使用valve   Target表示注解使用权限  FLELD说明是属性上
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
//retention 表示注解生命周期
@Retention(RetentionPolicy.RUNTIME)
@interface  shou1 {
    int  beanId() default  0;
    String className() default  "";
    String [] arrArry();
}

@shou1(arrArry ={"22","23","24"},beanId = 21,className = "任存坤")
public  class shou2{

}

