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

    void jump(double targetX, double targetY) {
        double offsetX = Math.abs(targetX - this.x);
        double offsetY = Math.abs(targetY - this.y);

        if (Math.abs(offsetX) > offsetY) {
            if (targetX < this.x) {
                this.x -= 0.1;
            } else {
                this.x += 0.1;
            }
        } else {
            if (targetY < this.y) {
                this.y -= 0.1;
            } else {
                this.y += 0.1;
            }
        }
    }

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
