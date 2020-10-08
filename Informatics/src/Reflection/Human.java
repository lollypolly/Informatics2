package Reflection;

public class Human {
    private int age;
    double height;
    private Human(){

    }
    public void printAge(){
        System.out.println(age);
    }

    public void grow(double value) {
        this.height += value;

    }
    public void grow(){
        this.height +=0.01;
    }
    public double getHeight(){
        return height;
    }

    private void simplePrivat(){
        System.out.println("I'm privat");
    }
}
