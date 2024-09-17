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
public String play(Media media) {
    int pointsRequired = media.getPoints();;

    // Check if the user has enough points to play the media
    if (pointsRemaining >= pointsRequired) {
        pointsRemaining -= pointsRequired;  // Deduct points after playing the media
        return "Playing " + media.toString() + ". You have " + pointsRemaining + " points remaining.";
    } else {
        return "Uh oh, You need more points! This media requires " + pointsRequired + " points. You have " + pointsRemaining + " points.";
    }
}
}