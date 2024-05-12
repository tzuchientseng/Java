package function.SimultaneousEquations;
public class Main {
    public static void main(String[] args){
        Line l1 = new Line(1,2,4);
        Line l2 = new Line(2,5,6);
        double X = X(l1,l2);
        double Y = Y(l1,l2);
        System.out.println("("+ X +","+ Y +")");
    }

    private static double X(Line l1, Line l2){
        double value = 0;
        value = (l1.getz()*l2.gety()-l1.gety()*l2.getz())/(l1.getx()*l2.gety()-l1.gety()*l2.getx()); 
        return value;
    }
    private static double Y(Line l1, Line l2){
        double value = 0;
        value = (l1.getx()*l2.getz()-l1.getz()*l2.getx())/(l1.getx()*l2.gety()-l1.gety()*l2.getx()); 
        return value;
    }
}

class Line {
    private double x;
    private double y;
    private double z;

    public Line(double a ,double b ,double c){
        this.x = a;
        this.y = b;
        this.z = c;
    }

    public double getx(){
        return this.x;
    } 
    public double gety(){
        return this.y;
    } 
    public double getz(){
        return this.z;
    } 
}