import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setCanvasSize(800, 800);

        StdDraw.enableDoubleBuffering();

        List<Lane> lanes = new ArrayList<>();
        Random rand = new Random();

        for (double y = 0.2; y < 0.8; y += 0.1) {
            double carWidth = 0.05 + rand.nextDouble() * 0.1;
            double carHeight = 0.07;
            double carSpeed = 0.01 + rand.nextDouble() * 0.004;
            double carSpacing = 0.5 + rand.nextDouble() * 0.05;
            double laneHeight = 0.1;
            lanes.add(new Lane(y, carWidth, carHeight, carSpeed, carSpacing, laneHeight));
        }

        int lives = 3;
        Frog frog = new Frog(0.5, 0.1, 0.07);
        Goal goal = new Goal(0.8);

        boolean isMouseAlreadyPressed = false;
        while (true) {
            StdDraw.clear();
            for (Lane lane : lanes) {
                lane.draw();
                lane.moveCars();
                for (Car car : lane.cars) {
                    if (frog.collidesWith(car)) {
                        frog = new Frog(0.5, 0.1, 0.07);
                        lives--;
                    }
                }
            }
            StdDraw.picture(0.5, 0.4, "images/start.png", 1.0, 1.2);
            goal.draw();
            frog.draw();
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.text(0.5, 0.05, "Lives: " + lives);
            StdDraw.show();

            // Check if the frog has reached the goal
            if (goal.isReachedBy(frog)) {
                StdDraw.text(0.5, 0.95, "You won!");
                StdDraw.show();
                return;
            }

            if (StdDraw.isMousePressed() && !isMouseAlreadyPressed) {
                frog.mouseJump(StdDraw.mouseX(), StdDraw.mouseY());
                isMouseAlreadyPressed = true;
            }
            isMouseAlreadyPressed = StdDraw.isMousePressed();

            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                frog.keyboardJump(key);
            }
            StdDraw.pause(20);

            if (lives == 0) {
                return;
            }
        }
    }
}