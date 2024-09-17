package customer;

import customer.Media;

public class Alacarte {
    private int pointsRemaining;

    public Alacarte(int pointsRemaining) {
        this.pointsRemaining = pointsRemaining;
    }

    public int buyPoints (int points){
        pointsRemaining += points;
    }

    public int getPointsRemaining () {
        return pointsRemaining;
    }

    @Override
    public String play(media Media){
        int pointsRequired = 100;

        if(pointsRemaining.equals(pointsRequired) || pointsRemaining > pointsRequired){
            return "Playing " + media.toString();
        }
        else{
            return "Uh oh, You need more points! This media requires '"+ pointsRequired +". You have '" pointsRemaining" ";
        }
    }
}