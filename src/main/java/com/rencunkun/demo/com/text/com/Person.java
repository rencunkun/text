package com.rencunkun.demo.com.text.com;

import jdk.nashorn.internal.objects.annotations.Property;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

//注解是对应表得关联
@Retention(RetentionPolicy.RUNTIME)
@interface  Animal{
    String value();
}

//属性对应注解
@Retention(RetentionPolicy.RUNTIME)
@interface Dog{
    String name();
    int leng() default  0;
}

//正和属性之间对应关系列
@Animal("company")
class Cat{
    @Dog(name="company_id")
    private  String  companyId;
    @Dog(name="company_name")
    private  String  companyName;
    @Dog(name = "company_age")
    private  String  companyAge;

}

public class Person {



    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> forName = Class.forName("com.rencunkun.demo.com.text.com.Cat");
        //获取当前类所有方法
        StringBuffer stringBuffer=new StringBuffer();
        Field[] declaredFields = forName.getDeclaredFields();
        stringBuffer.append(" select ");
        for (int i = 0; i <declaredFields.length ; i++) {
            Field declaredField = declaredFields[i];
            Dog declaredAnnotation = declaredField.getDeclaredAnnotation(Dog.class);
            stringBuffer.append(declaredAnnotation.name());
            if(i<declaredFields.length-1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(" from ");
        //获取类上注解参数
        Animal declaredAnnotation = forName.getDeclaredAnnotation(Animal.class);
        stringBuffer.append(declaredAnnotation.value());
        System.out.println(stringBuffer);
    }

}
