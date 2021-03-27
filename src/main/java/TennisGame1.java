
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1;
    private String player2;

    public TennisGame1(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        String score = "";
        if (isResultEqual()) score = getScoreWhenTie(scorePlayer1);
        else if (isResultGreaterThanFour()) score = getScoreWhenIsAdvantageOrWin();
        else score = getScoreWhenIsZeroToThree();
        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScoreWhenTie(int score){
        switch (score)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    public String getScoreWhenIsAdvantageOrWin(){
        String score = "";
        int resultDifference = getResultDifference();
        if (isDifferenceOne(resultDifference)) score ="Advantage player1";
        else if (isDifferenceMinusOne(resultDifference)) score ="Advantage player2";
        else if (isDifferenceGreaterThanTwo(resultDifference)) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    public String getScoreWhenIsZeroToThree(){
        String score = "";
        Integer scorePlayers[] = {scorePlayer1,scorePlayer2};
        for (int scorePlayer = 0;scorePlayer <scorePlayers.length;scorePlayer++){
            if(isLastScorePlayer(scorePlayer)) score += "-";
            score += assignScoreByPlayer(scorePlayers[scorePlayer]);
        }
        return score;
    }

    public Boolean isLastScorePlayer(Integer scorePlayer){
        return scorePlayer == 1;
    }

    public String assignScoreByPlayer(Integer scoreByPlayer){
        String score = "";
        switch(scoreByPlayer)
        {
            case 0:
                return score+="Love";
            case 1:
                return score+="Fifteen";
            case 2:
                return score+="Thirty";
            default:
                return score+="Forty";
        }
    }

    public Boolean isResultEqual(){
        return scorePlayer1==scorePlayer2;
    }

    public Boolean isResultGreaterThanFour(){
        return scorePlayer1 >= 4 || scorePlayer2>=4;
    }

    public Integer getResultDifference(){
        return scorePlayer1 - scorePlayer2;
    }

    public Boolean isDifferenceOne(Integer resultDifference){
        return resultDifference == 1;
    }

    public Boolean isDifferenceMinusOne(Integer resultDifference){
        return resultDifference == -1;
    }

    public Boolean isDifferenceGreaterThanTwo(Integer resultDifference){
        return resultDifference >= 2;
    }
}
