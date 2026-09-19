/*
 * Practice 1: Basic Class and Object
 * Define a simple Car class with fields and an instance method, then
 * create and use an object of that class.
 */
public class Problem1_BasicClassObject {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Corolla", 2022);
        myCar.displayInfo();
    }
}

class Car {
    String brand;
    String model;
    int year;

    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    void displayInfo() {
        System.out.println(year + " " + brand + " " + model);
    }
}
