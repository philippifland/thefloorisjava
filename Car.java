import java.awt.Color;

class Car {
    double x, y, width, height, speed;

    Car(double x, double y, double width, double height, double speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    void draw() {
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.filledRectangle(x, y, width / 2, height / 2);
    }

    void move() {
        this.x += this.speed;
        if (this.x - this.width / 2 > 1.0) {
            this.x = -this.width / 2;
        }
    }
}
