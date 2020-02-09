package eg.edu.alexu.csd.oop.game.model.utils.score;

public class Score implements Observer {

    private static Score score = null;
    private int current_score = 0;

    private Score() {
    }

    public static Score getInstance() {
        if (score != null)
            return score;
        score = new Score();
        return score;
    }

    @Override
    public void update() {
        incrementScore();
    }

    @Override
    public void update(int x) {
    }

    public int getScore() {
        return current_score;
    }

    public void resetScore() {
        score.current_score = 0;
    }

    private void incrementScore() {
        score.current_score++;
    }
}
