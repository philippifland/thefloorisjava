class Goal {
    private double y;

    public Goal(double y) {
        this.y = y;
    }

    public void draw() {
        StdDraw.picture(0, this.y, "images/goalarea.png", 2, 0.05);
    }

    public boolean isReachedBy(Frog frog) {
        return frog.y >= this.y;
    }

}