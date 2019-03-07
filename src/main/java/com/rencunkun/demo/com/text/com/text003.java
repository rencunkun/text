package com.rencunkun.demo.com.text.com;

class Sringleton{
    static private Sringleton sringleton;
    private int age;
    private int id;
    private Sringleton(){

    }

    public Sringleton(int age, int id) {
        this.age = age;
        this.id = id;
    }

    public  static synchronized   Sringleton getSringleton(){
        if(sringleton==null){//第一层上锁
            synchronized (Sringleton.class){
                if(sringleton==null){//第二层上锁 双重检验锁
                    Sringleton sringleton=new Sringleton(1,2);
                    return sringleton;
                }
            }
        }
        //当对象不足null不考虑线程安全问题
        return sringleton;
    }

}

public class text003 {
    public static void main(String[] args) {
        Sringleton s1=Sringleton.getSringleton();
        Sringleton s2=Sringleton.getSringleton();
        System.out.println(s1==s2);
        System.out.println(s1+""+s2);
    }
}
