import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    public int pointsPlayer1 = 0;
    public int pointsPlayer2 = 0;

    public String scorePlayer1 = "";
    public String scorePlayer2 = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScoreWhenTie(){
        List scores = Arrays.asList(new String[] {"Love-All","Fifteen-All","Thirty-All","Deuce","Deuce"});
        return scores.get(pointsPlayer1).toString();
    }

    public String getScorePlayer(Integer pointsPlayer){
        switch (pointsPlayer){
            case  1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    public String getScoreWhenLovePlayer2(Integer pointsPlayer1){
        scorePlayer1 = getScorePlayer(pointsPlayer1);
        scorePlayer2 = "Love";
        return scorePlayer1 + "-" + scorePlayer2;
    }

    public String getScoreWhenLovePlayer1(Integer pointsPlayer2){
        scorePlayer2 = getScorePlayer(pointsPlayer2);
        scorePlayer1 = "Love";
        return scorePlayer1 + "-" + scorePlayer2;
    }

    public String getScoreWhenPlayer1IsTemporallyWin(){
        //{ 3, 1, "Forty-Fifteen"}
        //{ 2, 1, "Thirty-Fifteen"}
        if (pointsPlayer1>pointsPlayer2 && pointsPlayer1 < 4)
        {
            if (pointsPlayer1==2)
                scorePlayer1="Thirty";
            if (pointsPlayer1==3)
                scorePlayer1="Forty";
            if (pointsPlayer2==1)
                scorePlayer2="Fifteen";
            if (pointsPlayer2==2)
                scorePlayer2="Thirty";
        }
        return scorePlayer1 + "-" + scorePlayer2;
    }

    public String getScoreWhenPlayer2IsTemporallyWin(){
        if (pointsPlayer2>pointsPlayer1 && pointsPlayer2 < 4)
        {
            if (pointsPlayer2==2)
                scorePlayer2="Thirty";
            if (pointsPlayer2==3)
                scorePlayer2="Forty";
            if (pointsPlayer1==1)
                scorePlayer1="Fifteen";
            if (pointsPlayer1==2)
                scorePlayer1="Thirty";
        }
        return scorePlayer1 + "-" + scorePlayer2;
    }



    public String getScore(){

        String score = "";
        if (pointsPlayer1 == pointsPlayer2) score = getScoreWhenTie();
        if (pointsPlayer1 > 0 && pointsPlayer2==0) score = getScoreWhenLovePlayer2(pointsPlayer1);
        if (pointsPlayer2 > 0 && pointsPlayer1==0) score = getScoreWhenLovePlayer1(pointsPlayer2);
        if (pointsPlayer1>pointsPlayer2 && pointsPlayer1 < 4) score = getScoreWhenPlayer1IsTemporallyWin();
        if (pointsPlayer2>pointsPlayer1 && pointsPlayer2 < 4) score = getScoreWhenPlayer2IsTemporallyWin();
        if (pointsPlayer1 > pointsPlayer2 && pointsPlayer2 >= 3) score = "Advantage player1";
        if (pointsPlayer2 > pointsPlayer1 && pointsPlayer1 >= 3) score = "Advantage player2";
        if (pointsPlayer1>=4 && pointsPlayer2>=0 && (pointsPlayer1-pointsPlayer2)>=2) score = "Win for player1";
        if (pointsPlayer2>=4 && pointsPlayer1>=0 && (pointsPlayer2-pointsPlayer1)>=2) score = "Win for player2";
        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1") pointsPlayer1++;
        else pointsPlayer2++;
    }
}