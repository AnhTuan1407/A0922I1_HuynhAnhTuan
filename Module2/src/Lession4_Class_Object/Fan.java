package Lession4_Class_Object;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = "color";
    }

    public String toString() {
        if (on == true) {
            return "Speed: " + this.getSpeed() + ", Radius: " + this.getRadius() + ", Color: " + this.getColor() + ", Fan is on";
        } else {
            return "Radius: " + this.getRadius() + ", Color: " + this.getColor() + ", Fan is off";
        }
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(3, true, 10, "Yellow");
        Fan fan3 = new Fan(2, false, 5, "Blue");

        System.out.println(fan1);
        System.out.println(fan2);
        System.out.println(fan3);
    }
}
