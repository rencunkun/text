package com.rencunkun.demo.com.text.com;
//简单工厂模式
    interface Car{
        void run();
    }

    class CatTo implements Car{

        @Override
        public void run() {
            System.out.println("你是小猫");
        }
    }

  class DogTo implements  Car{

      @Override
      public void run() {
          System.out.println("你是小狗");
      }
  }

    class AnimalFatory{
       static  public Car Animal(String name){
            Car car = null;
            switch (name){
                case "猫":
                    car=new CatTo();
                    break;
                case "狗":
                    car=new DogTo();
                    break;
                default:
                    break;
            }
            return car;
        }
    }

    public class Text002{
        public static void main(String[] args) {
            Car car = AnimalFatory.Animal("猫");
            car.run();
        }
    }
