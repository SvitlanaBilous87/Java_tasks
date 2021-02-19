package com.company.hometask_07;

public class Main {
    public static void main(String[] args){
        String name = "Robot";
        robot r1 = new robot(name);
        coffeRobot r2 = new coffeRobot(name);
        robotDancer r3 = new robotDancer(name);
        robotCoocker r4= new robotCoocker(name);
        robot[] R = {r1, r2, r3, r4};
        int k;
        for (k=0; k<R.length; k++){
R[k].work();
        }
        steeringWheel sw = new steeringWheel(20, "plastic", "black");
        wheels w = new wheels(50, 20, "GoodYear");
        body b = new body("white", "sedan");
        Car c = new Car("Toyota", 2006, "petrol", 0, sw, w, b);
        System.out.println("Basic configuration:");
        System.out.println(c);
        c.longRide();
        sw.tuningSteeringWheel(2, "red");
        w.tuningWheels(3, 3, "Michelin");
        b.tuningBody("black", "sport");
        System.out.println("Tuning configuration:");
        System.out.println(c);
        c.longRide();
    }

}
