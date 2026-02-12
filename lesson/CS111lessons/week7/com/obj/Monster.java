package com.obj;
public class Monster {
    public static int id = 0;
    
    private final double BASE_VIEW_SIGTH = 5.0;
    private double[] position;
    private double viewSigth;
    private boolean sleep;

    public Monster() {
        id++;
        position = new double[2];
        viewSigth = BASE_VIEW_SIGTH;
        sleep = false;
    }

    public double[] getPosition() {
        return position;
    }
    public void moveTo(double x, double y) {
        position[0] = x;
        position[1] = y;
    }
}