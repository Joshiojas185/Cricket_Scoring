/*
This Class is created to use as a medium for scoring our cricket matches showing the total score , strike rotations
and active bowler and batsmen
Program Owner -> Ojas Joshi
Date -> 19/09/2024
*/
import java.util.Scanner;
public class Match {
    // used to swap the strike
    public static String[] swapStrike(String[] strike){
        String temp = strike[0];
        strike[0] = strike[1];
        strike[1] = temp;
        return strike;
    }
    // used to simulate the match, show current score, show On-Strike and Non-Strike batsman and the winner team
    public static void matchSimulation(String[] teams, String[] teamA, String[] teamB,int firstNumber, int secondNumber) {
        int battingIndex = 2;
        String[] bowler = new String[1];
        Scanner scan = new Scanner(System.in);
        System.out.println("The Match is Between " + teams[firstNumber] + " and " + teams[secondNumber]);
        System.out.println(Constant.PLAYING_SQUAD + teams[firstNumber] + " is ");
        for (int i = 0; i < teamA.length; i++) {
            if(i == teamA.length/2){
                System.out.println();
            }
            System.out.print((i+1)+"." + teamA[i] + " ");
        }
        System.out.println();

        System.out.println(Constant.SELECT_PLAYERS+teams[firstNumber]);
        String[] newArray = new String[11];
        int index = 0 ;
        for (int i = 0; i < 11 ; i++) {
            try {
                int inputIndex = scan.nextInt();
                scan.nextLine();
                newArray[index++] = teamA[inputIndex - 1];
                System.out.println(teamA[inputIndex - 1] + " ");
            }
         catch (Exception e){
                System.out.println(Constant.INVALID_NUMBER);
            }
        }
        teamA = newArray ;
        System.out.println(Constant.PLAYING_SQUAD + teams[secondNumber] + " is ");
        for (int i = 0; i < teamB.length ; i++) {
            if(i == teamB.length/2){
                System.out.println();
            }
            System.out.print((i+1)+"."+teamB[i] + " ");
        }
        System.out.println();
        System.out.println(Constant.SELECT_PLAYERS + teams[secondNumber]);
        index = 0;
        newArray = new String[11];
        for (int i = 0; i < 11 ; i++) {
            try {
                int inputIndex = scan.nextInt();
                scan.nextLine();
                newArray[index++] = teamB[inputIndex - 1];
                System.out.println(teamB[inputIndex - 1] + " ");
            }
            catch(Exception e){
                System.out.println(Constant.INVALID_NUMBER);
            }
        }
        teamB = newArray;
        System.out.println();
        System.out.println(Constant.BATTING_FIRST);
        System.out.println("Enter 1 for " + teams[firstNumber] + " and 2 for " + teams[secondNumber]);
        String toss = scan.nextLine();
        if (toss.equalsIgnoreCase("1")) {
            System.out.println(teams[firstNumber] + " is Batting first ");
            System.out.println(Constant.MATCH_RULES);
            int wicketCount = 0 ;
            String[] strike = new String[2];
            strike[0] = teamA[0];
            strike[1] = teamA[1];
            System.out.println(Constant.NO_OF_OVERS);
            String ball;
            int score = 0;
            int targetScore = 0;
            try {
                int overs = scan.nextInt();
                scan.nextLine();
                System.out.println(Constant.SELECT_BOWLER);
                int bowlerIndex = scan.nextInt();
                scan.nextLine();
                bowler[0] = teamB[bowlerIndex-1];
                System.out.println(Constant.ON_STRIKE + strike[0] + "     ||      "+Constant.NON_STRIKE + strike[1]);
                System.out.println(Constant.FIRST_OVER);
                for (int i = 1; i <= overs * 6; i++) {
                    ball = scan.nextLine();
                    if (i % 6 == 0 && i != overs * 6) {
                        System.out.println(Constant.NEW_OVER);
                        strike = swapStrike(strike);
                        System.out.println(Constant.SELECT_BOWLER);
                        bowlerIndex = scan.nextInt();
                        scan.nextLine();
                        bowler[0] = teamB[bowlerIndex-1];
                    }
                    if(ball.equalsIgnoreCase("AP")){
                        double result = ((double) score / (i-1)) * 6;
                        score = (int) (result * overs) ;
                        break;
                    }
                    if(ball.equalsIgnoreCase("s")){
                        swapStrike(strike);
                        i--;
                        continue;
                    }
                    if (ball.equalsIgnoreCase("wd")) {

                        System.out.println(Constant.WIDE_EXTRA);
                        {
                            int extra = scan.nextInt();
                            if (extra % 2 == 1) {
                                strike = swapStrike(strike);
                            }
                            scan.nextLine();
                            score = score + 1 + extra;
                            i--;
                        }
                    } else if (ball.equalsIgnoreCase("nb")) {
                        System.out.println(Constant.FREE_HIT);
                        System.out.println(Constant.NB_EXTRA);
                        int extra = scan.nextInt();
                        if (extra % 2 == 1) {
                            strike = swapStrike(strike);
                        }
                        scan.nextLine();
                        score = score + 1 + extra;
                        i--;
                    } else if (ball.equalsIgnoreCase("W")) {
                        System.out.println(Constant.WICKET);
                        strike[0] = teamA[battingIndex++];
                        wicketCount++;
                        if(wicketCount == 10){
                            System.out.println(Constant.ALL_OUT);
                            break;
                        }
                    } else if (Integer.parseInt(ball) < 0 || Integer.parseInt(ball) > 6) {
                        System.out.println(Constant.INVALID_SCORE);
                        i--;
                    } else {
                        score = score + Integer.parseInt(ball);
                        if (Integer.parseInt(ball) % 2 == 1) {
                            strike = swapStrike(strike);
                        }
                    }
                    System.out.println("Bowler: " + bowler[0]+ "    ||    Balls Remaining " + (6 - ( i%6 )));
                    System.out.println("Current Score : " + score);
                    System.out.println("On Strike : " + strike[0]+ "      || Non Strike : " + strike[1]);

                }
                System.out.println(Constant.INNINGS_END);
                System.out.println(Constant.TOTAL_SCORE + teams[firstNumber] + " is " + score);
                System.out.println(Constant.NEW_INNINGS);
                System.out.println(Constant.SELECT_BOWLER);
                bowlerIndex = scan.nextInt();
                scan.nextLine();
                bowler[0] = teamA[bowlerIndex-1];
                System.out.println(Constant.FIRST_OVER);
                strike[0] = teamB[0];
                strike[1] = teamB[1];
                System.out.println("On Strike : " + strike[0] + "     ||      Non Strike : " + strike[1]);
                battingIndex = 2;
                wicketCount = 0 ;
                for (int i = 1; i <= overs * 6; i++) {
                    {
                        ball = scan.nextLine();
                        if (i % 6 == 0 && i != overs * 6) {
                            System.out.println(Constant.NEW_OVER);
                            swapStrike(strike);
                            System.out.println(Constant.SELECT_BOWLER);
                            bowlerIndex = scan.nextInt();
                            scan.nextLine();
                            bowler[0] = teamA[bowlerIndex-1];

                        }
                        if(ball.equalsIgnoreCase("AP")){
                            double result = ((double) targetScore / (i-1)) * 6;
                            targetScore = (int) (result * overs) ;
                            break;
                        }
                        if(ball.equalsIgnoreCase("s")){
                            swapStrike(strike);
                            i--;
                            continue;
                        }
                        if (ball.equalsIgnoreCase("wd")) {

                            System.out.println(Constant.WIDE_EXTRA);
                            {
                                int extra = scan.nextInt();
                                scan.nextLine();
                                if (extra % 2 == 1) {
                                    strike = swapStrike(strike);
                                }
                                targetScore = targetScore + 1 + extra;
                                i--;
                            }
                        } else if (ball.equalsIgnoreCase("nb")) {
                            System.out.println(Constant.FREE_HIT);
                            System.out.println(Constant.NB_EXTRA);
                            int extra = scan.nextInt();
                            scan.nextLine();
                            targetScore = targetScore + 1 + extra;
                            i--;
                            if (extra % 2 == 1) {
                                strike = swapStrike(strike);
                            }

                        } else if (ball.equalsIgnoreCase("W")) {
                            System.out.println(Constant.WICKET);
                            strike[0] = teamB[battingIndex++];
                            wicketCount++;
                            if(wicketCount == 10){
                                System.out.println(Constant.ALL_OUT);
                                break;
                            }
                        } else if (Integer.parseInt(ball) < 0 || Integer.parseInt(ball) > 6) {
                            System.out.println(Constant.INVALID_SCORE);
                            i--;
                        } else {
                            targetScore = targetScore + Integer.parseInt(ball);
                            if (Integer.parseInt(ball) % 2 == 1) {
                                strike = swapStrike(strike);
                            }
                        }
                    }
                    if(targetScore > score){
                        System.out.println(teams[firstNumber] + " won by " + (10 - wicketCount )+ " Wickets");
                        break;
                    }
                    System.out.println(Constant.CURRENT_BOWLER + bowler[0]+ "    ||    Balls Remaining " + (6 - ( i%6 )));
                    System.out.println(Constant.CURRENT_SCORE + targetScore);
                    System.out.println(Constant.ON_STRIKE + strike[0]+ "      ||"+Constant.NON_STRIKE + strike[1]);

                }

            } catch (Exception e) {
                System.out.println(Constant.ERROR_HANDLING);
            }
            if(score > targetScore){
                System.out.println(teams[firstNumber] + " won by "+ (score-targetScore) + " runs");
            }
            else if(targetScore > score){
                System.out.println(teams[firstNumber] + " lost by " + (targetScore - score) + " runs");
            }
            else{
                System.out.println(Constant.TIE);
            }
        }
        else if(toss.equalsIgnoreCase("2")){

            System.out.println(teams[secondNumber] + " is Batting first ");
            System.out.println(Constant.MATCH_RULES);

            String[] strike = new String[2];
            strike[0] = teamB[0];
            strike[1] = teamB[1];
            int wicketCount = 0 ;
            System.out.println(Constant.NO_OF_OVERS);
            String ball;
            int score = 0;
            int targetScore = 0;
            try {
                int overs = scan.nextInt();
                scan.nextLine();
                System.out.println(Constant.SELECT_BOWLER);
                int bowlerIndex = scan.nextInt();
                scan.nextLine();
                bowler[0] = teamA[bowlerIndex-1];
                System.out.println("On Strike : " + strike[0] + "     ||      Non Strike : " + strike[1]);
                System.out.println(Constant.FIRST_OVER);
                for (int i = 1; i <= overs * 6; i++) {
                    ball = scan.nextLine();
                    if (i % 6 == 0 && i != overs * 6) {
                        System.out.println(Constant.NEW_OVER);
                        swapStrike(strike);
                        System.out.println(Constant.SELECT_BOWLER);
                        bowlerIndex = scan.nextInt();
                        scan.nextLine();
                        bowler[0] = teamA[bowlerIndex-1];
                    }
                    if(ball.equalsIgnoreCase("AP")){
                        double result = ((double) score / (i-1)) * 6;
                        score = (int) (result * overs) ;
                        break;
                    }
                    if(ball.equalsIgnoreCase("s")){
                        swapStrike(strike);
                        i--;
                        continue;
                    }
                    if (ball.equalsIgnoreCase("wd")) {
                        System.out.println(Constant.WIDE_EXTRA);
                        {
                            int extra = scan.nextInt();
                            if(extra % 2 == 1){
                                strike = swapStrike(strike);
                            }
                            scan.nextLine();
                            score = score + 1 + extra;
                            i--;
                        }
                    } else if (ball.equalsIgnoreCase("nb")) {
                        System.out.println(Constant.FREE_HIT);
                        System.out.println(Constant.NB_EXTRA);
                        int extra = scan.nextInt();
                        if (extra % 2 == 1) {
                            strike = swapStrike(strike);
                        }
                        scan.nextLine();
                        score = score + 1 + extra;
                        i--;
                    } else if (ball.equalsIgnoreCase("W")) {
                        wicketCount++;
                        if(wicketCount == 10){
                            break;
                        }
                        System.out.println(Constant.WICKET);
                        strike[0] = teamB[battingIndex++];
                    } else if (Integer.parseInt(ball) < 0 || Integer.parseInt(ball) > 6) {
                        System.out.println(Constant.INVALID_SCORE);
                        i--;
                    } else {
                        score = score + Integer.parseInt(ball);
                        if (Integer.parseInt(ball) % 2 == 1) {
                            strike = swapStrike(strike);
                        }
                    }
                    System.out.println(Constant.CURRENT_BOWLER + bowler[0]+ "    ||    Balls Remaining " + (6 - ( i%6 )));
                    System.out.println(Constant.CURRENT_SCORE + score);
                    System.out.println(Constant.ON_STRIKE + strike[0]+ "      || "+Constant.NON_STRIKE + strike[1]);
                }
                System.out.println(Constant.INNINGS_END);
                System.out.println(Constant.TOTAL_SCORE + teams[secondNumber] + " is " + score);
                System.out.println(Constant.NEW_INNINGS);
                System.out.println(Constant.SELECT_BOWLER);
                bowlerIndex = scan.nextInt();
                scan.nextLine();
                bowler[0] = teamB[bowlerIndex-1];
                System.out.println(Constant.FIRST_OVER);
                wicketCount = 0 ;
                strike[0] = teamA[0];
                strike[1] = teamA[1];
                System.out.println(Constant.ON_STRIKE + strike[0] + "     ||      "+Constant.NON_STRIKE + strike[1]);
                battingIndex = 2;
                for (int i = 1; i <= overs * 6; i++) {
                    {
                        ball = scan.nextLine();
                        if (i % 6 == 0 && i != overs * 6) {
                            System.out.println(Constant.NEW_OVER);
                            swapStrike(strike);
                            System.out.println(Constant.SELECT_BOWLER);
                            bowlerIndex = scan.nextInt();
                            scan.nextLine();
                            bowler[0] = teamB[bowlerIndex-1];

                        }
                        if(ball.equalsIgnoreCase("AP")){
                            double result = ((double) targetScore / (i-1)) * 6;
                            targetScore = (int) (result * overs) ;
                            break;
                        }
                        if (ball.equalsIgnoreCase("wd")) {

                            System.out.println(Constant.WIDE_EXTRA);
                            {
                                int extra = scan.nextInt();
                                if (extra % 2 == 1) {
                                    strike = swapStrike(strike);
                                }
                                scan.nextLine();
                                targetScore = targetScore + 1 + extra;
                                i--;
                            }
                        } else if (ball.equalsIgnoreCase("nb")) {
                            System.out.println(Constant.FREE_HIT);
                            System.out.println(Constant.NB_EXTRA);
                            int extra = scan.nextInt();
                            if (extra % 2 == 1) {
                                strike = swapStrike(strike);
                            }
                            scan.nextLine();
                            targetScore = targetScore + 1 + extra;
                            i--;
                        } else if (ball.equalsIgnoreCase("W")) {
                            System.out.println(Constant.WICKET);
                            strike[0] = teamB[battingIndex++];
                            wicketCount++;
                            if(wicketCount == 10){
                                break;
                            }
                        } else if (Integer.parseInt(ball) < 0 || Integer.parseInt(ball) > 6) {
                            System.out.println(Constant.INVALID_SCORE);
                            i--;
                        } else {
                            targetScore = targetScore + Integer.parseInt(ball);
                            if (Integer.parseInt(ball) % 2 == 1) {
                                strike = swapStrike(strike);
                            }
                        }
                    }
                    if(targetScore > score){
                        System.out.println(teams[firstNumber] + " won by " + (10 - wicketCount) + " wickets");
                        break;
                    }
                    System.out.println(Constant.CURRENT_BOWLER + bowler[0] + "    ||    Balls Remaining " + (6 - ( i%6 )));
                    System.out.println(Constant.CURRENT_SCORE + targetScore);
                    System.out.println(Constant.ON_STRIKE + strike[0]+ "      || "+Constant.NON_STRIKE + strike[1]);
                }

            } catch (Exception e) {
                System.out.println(Constant.ERROR_HANDLING);
            }
            if(score > targetScore){
                System.out.println(teams[secondNumber] + " won by "+ (score-targetScore) + " runs");
            }
            else if (targetScore > score){
                System.out.println(teams[secondNumber] + " lost by " + (targetScore - score) + " runs");
            }
            else{
                System.out.println(Constant.TIE);
            }
        }
        else{
            System.out.println(Constant.INVALID_INPUT);
        }

    }
}