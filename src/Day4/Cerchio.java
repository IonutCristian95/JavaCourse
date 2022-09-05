package Day4;

public class Cerchio {
    private double radius = 0;

    public Cerchio(double radius){
        this.radius = radius;
    }

    public double getCircumference(){
        return Math.PI * this.radius * 2;
    }

    public double getArea(){
        return (Math.PI * Math.pow(this.radius, 2));
    }

}
