class Goal {
    private double y;

    public Goal(double y) {
        this.y = y;
    }

    public void draw() {
        StdDraw.picture(0.5, 0.525, "images/goal.png", 1, 1);
    }

    public boolean isReachedBy(Frog frog) {
        return frog.y >= this.y;
    }

}