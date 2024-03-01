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
        String[] images = { "images/0.png", "images/1.png", "images/2.png", "images/3.png", "images/4.png",
                "images/5.png", "images/6.png", "images/7.png", "images/8.png", "images/9.png", "images/10.png" };
        this.image = images[new Random().nextInt(images.length)];
    }

    void draw() {
        StdDraw.picture(x, y, image, width, height * 1.5);
    }

    void move() {
        this.x += this.speed;
        if (this.x - this.width / 2 > 1.0) {
            this.x = -this.width / 2;
        }
    }
}