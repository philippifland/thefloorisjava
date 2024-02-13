class Goal {
    private double y;

    public Goal(double y) {
        this.y = y;
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledRectangle(0.5, this.y, 0.5, 0.05);
        StdDraw.setPenColor(StdDraw.BLACK);
    }

    public boolean isReachedBy(Frog frog) {
        return frog.getY() >= this.y;
    }

}