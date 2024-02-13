import java.awt.Color;

public class Frog {
    double x, y, size;
    Color color = Color.GREEN;

    Frog(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, size);
    }

    void moveTowards(double targetX, double targetY) {
        double dx = targetX - this.x;
        double dy = targetY - this.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        this.x += dx / distance * 0.05;
        this.y += dy / distance * 0.05;
    }

    // void jump(double targetX, double targetY) {
    // double offsetX = Math.abs(targetX - this.x);
    // double offsetY = Math.abs(targetY - this.y);

    // if (Math.abs(offsetX) > offsetY) {
    // this.x +=
    // } else {
    // this.y = targetY;
    // }
    // }

    boolean collidesWith(Car car) {
        double dx = this.x - car.x;
        double dy = this.y - car.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < this.size + car.width / 2;
    }

    double getY() {
        return this.y;
    }
}
