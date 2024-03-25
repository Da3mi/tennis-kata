package org.monta.kata.tennis;

public class SimpleMatch {

    private final Player playerA;
    private final Player playerB;

    public SimpleMatch(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void of(String simpleMatch) {
        var gameFinished = false ;
        for (char c : simpleMatch.toCharArray()) {
            var deuce = playerA.getScore() == 40 && playerB.getScore() == 40;

            if(c == 'A'){
                if (deuce && playerB.getAdvantageCount() >= 1) {
                    this.backToDeuce(playerA, playerB);
                } else if (deuce) {
                    gameFinished = this.gameInDeuce(playerA);
                    this.printScore("advantage", String.valueOf(playerB.getScore()), gameFinished);
                } else {
                    gameFinished = this.gameWithoutDeuce(playerA);
                }
            } else if (c == 'B') {
                if (deuce && playerA.getAdvantageCount() >= 1) {
                    this.backToDeuce(playerB, playerA);
                } else if (deuce) {
                    gameFinished = this.gameInDeuce(playerB);
                    this.printScore(String.valueOf(playerA.getScore()), "advantage", gameFinished);
                } else {
                    gameFinished = this.gameWithoutDeuce(playerB);
                }
            }

            // printing score
            if (gameFinished && deuce){
                System.out.println("Player " + (playerA.getAdvantageCount() > playerB.getAdvantageCount() ? "A" : "B") + " wins the game");
                break;
            } else if (gameFinished) {
                System.out.println("Player " + (playerA.getScore() > playerB.getScore() ? "A" : "B") + " wins the game");
                break;
            }

            if (!deuce) {
                printScore(String.valueOf(playerA.getScore()), String.valueOf(playerB.getScore()), false);
            }
        }
    }

    private boolean gameInDeuce(Player player){
        player.updateAdvantageCounter();
        return player.getAdvantageCount() == 2;
    }

    private void backToDeuce(Player player, Player opponentPlayer){
        System.out.println("** Back to deuce ! **");
        player.initializeAdvantageCounter();
        opponentPlayer.initializeAdvantageCounter();
    }

    private void printScore(String scoreA, String scoreB, boolean gameFinished){
        if(gameFinished) {
            return;
        }
        System.out.println("Player A : " + scoreA +"/ Player B : " + scoreB);
    }

    private boolean gameWithoutDeuce(Player player) {
        player.updateScore(player.getScore());

        return player.getScore() > 40;
    }

    public Player getPlayerA() {
        return playerA;
    }

}
