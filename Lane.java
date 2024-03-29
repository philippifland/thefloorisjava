import java.util.ArrayList;
import java.util.List;

class Lane {
    List<Car> cars = new ArrayList<>();
    double y, carWidth, carHeight, carSpeed, carSpacing, laneHeight;

    Lane(double y, double carWidth, double carHeight, double carSpeed, double carSpacing, double laneHeight) {
        this.y = y;
        this.carWidth = carWidth;
        this.carHeight = carHeight;
        this.carSpeed = carSpeed;
        this.carSpacing = carSpacing;
        this.laneHeight = laneHeight;

        for (double x = 0; x < 1.0; x += carWidth + carSpacing) {
            cars.add(new Car(x, y, carWidth, carHeight, carSpeed));
        }
    }

    void draw() {
        StdDraw.picture(0.5, y, "images/Road.png", 1.0, laneHeight);

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