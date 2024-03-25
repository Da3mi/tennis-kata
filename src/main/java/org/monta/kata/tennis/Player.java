package org.monta.kata.tennis;

import java.util.Objects;

public class Player {
    private int score;
    private int advantageCount;

    public Player(int score, int advantageCount) {
        this.score = score;
        this.advantageCount = advantageCount;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        if(score >= 30){
            this.score += 10;
        } else {
            this.score += 15;
        }
    }

    public int getAdvantageCount() {
        return advantageCount;
    }

    public void initializeAdvantageCounter() {
        this.advantageCount = 0;
    }

    public void updateAdvantageCounter(){
        this.advantageCount +=1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score && advantageCount == player.advantageCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, advantageCount);
    }

}
