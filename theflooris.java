import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

class Lane {
    List<Car> cars = new ArrayList<>();
    double y, carWidth, carHeight, carSpeed, carSpacing;

    Lane(double y, double carWidth, double carHeight, double carSpeed, double carSpacing) {
        this.y = y;
        this.carWidth = carWidth;
        this.carHeight = carHeight;
        this.carSpeed = carSpeed;
        this.carSpacing = carSpacing;

        for (double x = 0; x < 1.0; x += carWidth + carSpacing) {
            cars.add(new Car(x, y, carWidth, carHeight, carSpeed));
        }
    }

    void draw() {
        for (Car car : cars) {
            car.draw();
        }
    }

    void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}

class Frog {
    double x, y, size;
    Color color;

    Frog(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
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

    boolean collidesWith(Car car) {
        double dx = this.x - car.x;
        double dy = this.y - car.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < this.size + car.width / 2;
    }
}

public class Main {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        List<Lane> lanes = new ArrayList<>();
        Random rand = new Random();

        for (double y = 0; y < 1.0; y += 0.2) {
            double carWidth = 0.05 + rand.nextDouble() * 0.05;
            double carHeight = 0.1;
            double carSpeed = 0.01 + rand.nextDouble() * 0.02;
            double carSpacing = 0.05 + rand.nextDouble() * 0.05;
            lanes.add(new Lane(y, carWidth, carHeight, carSpeed, carSpacing));
        }

        Frog frog = new Frog(0.5, 0.1, 0.05, Color.GREEN);
        int lives = 3;

        while (true) {
            StdDraw.clear();

            if (StdDraw.isMousePressed()) {
                frog.moveTowards(StdDraw.mouseX(), StdDraw.mouseY());
            }

            for (Lane lane : lanes) {
                lane.draw();
                lane.moveCars();
                for (Car car : lane.cars) {
                    if (frog.collidesWith(car)) {
                        frog = new Frog(0.5, 0.1, 0.05, Color.GREEN);
                        lives--;
                        if (lives == 0) {
                            return;
                        }
                    }
                }
            }

            frog.draw();

            StdDraw.text(0.05, 0.95, "Lives: " + lives);

            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}