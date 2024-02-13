import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        StdDraw.enableDoubleBuffering();

        List<Lane> lanes = new ArrayList<>();
        Random rand = new Random();

        for (double y = 0; y < 1.0; y += 0.2) {
            double carWidth = 0.05 + rand.nextDouble() * 0.05;
            double carHeight = 0.07;
            double carSpeed = 0.01 + rand.nextDouble() * 0.01;
            double carSpacing = 0.5 + rand.nextDouble() * 0.05;
            double laneHeight = 0.1;
            lanes.add(new Lane(y, carWidth, carHeight, carSpeed, carSpacing, laneHeight));
        }

        Frog frog = new Frog(0.5, 0.1, 0.05);
        int lives = 3;

        Goal goal = new Goal(0.95);

        boolean isMouseAlreadyPressed = false;
        while (true) {
            StdDraw.clear();
            for (Lane lane : lanes) {
                lane.draw();
                lane.moveCars();
                for (Car car : lane.cars) {
                    if (frog.collidesWith(car)) {
                        frog = new Frog(0.5, 0.1, 0.05);
                        lives--;
                        if (lives == 0) {
                            return;
                        }
                    }
                }
            }
            frog.draw();
            goal.draw(); // Draw the goal area
            StdDraw.show();
            StdDraw.text(0.05, 0.95, "Lives: " + lives);

            // Check if the frog has reached the goal
            if (goal.isReachedBy(frog)) {
                StdDraw.text(0.5, 0.5, "You won!");
                StdDraw.show();
                return;
            }
            if (StdDraw.isMousePressed() && !isMouseAlreadyPressed) {
                frog.jump(StdDraw.mouseX(), StdDraw.mouseY());
                isMouseAlreadyPressed = true;
            }
            isMouseAlreadyPressed = StdDraw.isMousePressed();

            StdDraw.pause(20);
        }
    }
}