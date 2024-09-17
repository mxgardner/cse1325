package customer;

import product.Media;

public class Alacarte extends Account {
    private int pointsRemaining;

    public Alacarte(int pointsRemaining) {
        this.pointsRemaining = pointsRemaining;
    }

    public void buyPoints (int points){
        pointsRemaining += points;
    }

    public int getPointsRemaining () {
        return pointsRemaining;
    }

    @Override
    public String play(Media media){
        int pointsRequired = 100;

        if(pointsRemaining >= pointsRequired){
            return "Playing " + media.toString();
        }
        else{
            return "Uh oh, You need more points! This media requires " + pointsRequired + ". You have " + pointsRemaining + ".";
        }
    }
}