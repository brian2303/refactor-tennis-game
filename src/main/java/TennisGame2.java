import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    public int pointsPlayer1 = 0;
    public int pointsPlayer2 = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScoreWhenTie(){
        String[] scores = {"Love-All","Fifteen-All","Thirty-All","Deuce","Deuce"};
        return scores[pointsPlayer1];
    }

    public String getScorePlayer(Integer pointsPlayer){
        switch (pointsPlayer){
            case 0:
                return "Love";
            case  1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    public String getScoreWhenLovePlayer2(Integer pointsPlayer1){
        return getScorePlayer(pointsPlayer1) + "-" + "Love";
    }

    public String getScoreWhenLovePlayer1(Integer pointsPlayer2){
        return "Love" + "-" + getScorePlayer(pointsPlayer2);
    }

    public String getScoreWhenPlayerIsWinning(){
        return getScorePlayer(pointsPlayer1) + "-" + getScorePlayer(pointsPlayer2);
    }

    public String getLove(){
        if (checkPlayerLove(pointsPlayer1,pointsPlayer2)){
            return getScoreWhenLovePlayer2(pointsPlayer1);
        }
        return getScoreWhenLovePlayer1(pointsPlayer2);
    }

    public String getPlayerWinning(){
        String score = "";
        if (checkPlayerWinning(pointsPlayer1, pointsPlayer2)){
            score = getScoreWhenPlayerIsWinning();
        }
        if (checkPlayerWinning(pointsPlayer2, pointsPlayer1)){
            score = getScoreWhenPlayerIsWinning();
        }
        return score;
    }

    public String getPlayerAdvantage(){
        String score = "";
        if (checkPlayerAdvantage(pointsPlayer1, pointsPlayer2)){
            score = "Advantage player1";
        }
        if (checkPlayerAdvantage(pointsPlayer2, pointsPlayer1)){
            score = "Advantage player2";
        }
        return score;
    }

    public String getPlayerWon(){
        String score = "";
        if (checkPlayerWon(pointsPlayer1, pointsPlayer2)){
            score = "Win for player1";
        }
        if (checkPlayerWon(pointsPlayer2, pointsPlayer1)){
            score = "Win for player2";
        }
        return score;
    }



    public String getScore(){

        String score = "";
        if (isTie()){
            score = getScoreWhenTie();
        }else if(isGameLove(pointsPlayer1, pointsPlayer2)){
            score = getLove();
        }else if(isGameWinning(pointsPlayer1, pointsPlayer2)){
            score = getPlayerWinning();
        }else if(isGameAdvantage(pointsPlayer1, pointsPlayer2)){
            score = getPlayerAdvantage();
        }
        if(isGameWon(pointsPlayer1, pointsPlayer2)){
            score = getPlayerWon();
        }
        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1") pointsPlayer1++;
        else pointsPlayer2++;
    }

    public Boolean checkPlayerLove(Integer points1, Integer points2){
        return points1 > 0 && points2==0;
    }

    public Boolean checkPlayerWinning(Integer points1, Integer points2){
        return points1 > points2 && points1 < 4;
    }

    public Boolean checkPlayerAdvantage(Integer points1, Integer points2){
        return points1 > points2 && points2 >= 3;
    }

    public Boolean isGameLove(Integer points1,Integer points2){
        return checkPlayerLove(points1,points2) || checkPlayerLove(points2, points1) ;
    }

    public Boolean isGameWinning(Integer points1, Integer points2){
        return checkPlayerWinning(points1, points2) || checkPlayerWinning(points2, points1);
    }

    public Boolean isGameAdvantage(Integer points1,Integer points2){
        return checkPlayerAdvantage(points1,points2) || checkPlayerAdvantage(points2, points1);
    }

    public Boolean isGameWon(Integer points1,Integer points2){
        return checkPlayerWon(points1, points2) || checkPlayerWon(points2, points1);
    }

    public Boolean isTie(){
        return pointsPlayer1 == pointsPlayer2;
    }

    public Boolean checkPlayerWon(Integer points1, Integer points2){
        return points1 >=4 && points2 >=0 && (points1-points2) >= 2;
    }
}