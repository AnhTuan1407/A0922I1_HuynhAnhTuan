package lesson6_inheritance;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] test = new float[2];
        test[0] = this.x;
        test[1] = this.y;
        return test;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public static class MovablePoint extends Point {
        private float xSpeed = 0.0f;
        private float ySpeed = 0.0f;

        public MovablePoint() {
        }

        public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
            super(x, y);
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
        }

        public float getxSpeed() {
            return xSpeed;
        }

        public void setxSpeed(float xSpeed) {
            this.xSpeed = xSpeed;
        }

        public float getySpeed() {
            return ySpeed;
        }

        public void setySpeed(float ySpeed) {
            this.ySpeed = ySpeed;
        }

        public float[] getSpeed(float xSpeed, float ySpeed) {
            float[] test = new float[2];
            test[0] = this.xSpeed;
            test[1] = this.ySpeed;
            return test;
        }

        @Override
        public String toString() {
            return super.toString() + ", speed = (" + this.xSpeed + ", " + this.ySpeed + ")";
        }

        public String move() {
            this.setX(this.getX() + this.xSpeed);
            this.setY(this.getY() + this.ySpeed);
            return "(" + this.getX() + "," + this.getY() + ")";
        }
    }

    public static void main(String[] args) {
        Point2D point2D = new Point2D(2, 3);
        MovablePoint point = new MovablePoint(0, 0, 1, 2);
        System.out.println(point2D);
        System.out.println(point);
        System.out.println(point.move());
    }
}
