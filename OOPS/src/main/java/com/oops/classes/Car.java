package com.oops.classes;

interface EngineStatus{
    void engineStop();
    void engineStart();
}
enum CarType{
    SPORTSCAR,NORMALCAR,OFFROADCAR
}

interface CarCompany{
   void buildCar();
}
class SportsCar implements CarCompany{
    @Override
    public void buildCar(){
        System.out.println("Building sports car");
    }
}
class NormalCar implements CarCompany{
    @Override
    public void buildCar(){
        System.out.println("Building a Normal car");
    }
}
class OffRoadCar implements CarCompany{
    @Override
    public void buildCar(){
        System.out.println("Building a offRoad car");

    }
}
class CarFactory {
    public static CarCompany getCar(CarType carType) {
        return switch (carType) {
            case SPORTSCAR -> new SportsCar();
            case NORMALCAR -> new NormalCar();
            case OFFROADCAR -> new OffRoadCar();
            default -> throw new IllegalArgumentException("Invalid Car type");
        };
    }
}

public class Car implements EngineStatus{
    @Override
    public void engineStop(){
        System.out.println("Car stopped");

    }
    @Override
    public void engineStart(){
        System.out.println("car started");
    }
}
class Main {
    public static void main(String[] args) {
        CarCompany carCompany = CarFactory.getCar(CarType.SPORTSCAR);
        carCompany.buildCar();
        Car car = new Car();
        car.engineStart();
        car.engineStop();
    }
}