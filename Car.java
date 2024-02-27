import java.util.Random;

class Car {
    double x, y, width, height, speed;
    String image;

    Car(double x, double y, double width, double height, double speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;

        // Select a random image
        String[] images = { "images/bluecar.png", "images/redcar.png", "images/greencar.png" };
        this.image = images[new Random().nextInt(images.length)];
    }

    void draw() {
        StdDraw.picture(x, y, image, width, height);
    }

    void move() {
        this.x += this.speed;
        if (this.x - this.width / 2 > 1.0) {
            this.x = -this.width / 2;
        }
    }
}