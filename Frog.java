public class Frog {
    double x, y, size;

    Frog(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    void draw() {
        StdDraw.picture(x, y, "images/frog.png", size, size);
    }

    void mouseJump(double targetX, double targetY) {
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

    void keyboardJump(char key) {

        if (key == 'w') {
            this.y += 0.1;
        } else if (key == 'a' && this.x > 0.1) {
            this.x -= 0.1;
        } else if (key == 's' && this.y > 0.1) {
            this.y -= 0.1;
        } else if (key == 'd' && this.x < 0.9) {
            this.x += 0.1;
        }
    }

    boolean collidesWith(Car car) {
        boolean notToLeft = this.x + this.size / 2 >= car.x - car.width / 2;
        boolean notToRight = this.x - this.size / 2 <= car.x + car.width / 2;
        boolean notAbove = this.y - this.size / 2 <= car.y + car.height / 2;
        boolean notBelow = this.y + this.size / 2 >= car.y - car.height / 2;
        return notToLeft && notToRight && notAbove && notBelow;
    }
}
