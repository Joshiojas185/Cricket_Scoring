import java.util.Scanner;

public class Match {
    public static String[] swapStrike(String[] strike){
        String temp = strike[0];
        strike[0] = strike[1];
        strike[1] = temp;
        return strike;
    }
    public static void matchSimulation(String[] teams, String[] teamA, String[] teamB,int number, int number2) {
        int index = 2;
        Scanner scan = new Scanner(System.in);
        System.out.println("The Match is Between " + teams[number] + " and " + teams[number2]);
        System.out.println("Playing 11 for team " + teams[number] + " is ");
        for (int i = 0; i < 11; i++) {
            System.out.print(teamA[i] + " ");
        }
        System.out.println();
        System.out.println("Playing 11 for team " + teams[number2] + " is ");
        for (int i = 0; i < 11; i++) {
            System.out.print(teamB[i] + " ");
        }
        System.out.println();
        System.out.println("Who is Batting First");
        System.out.println("Enter 1 for " + teams[number] + " and 2 for " + teams[number2]);
        String toss = scan.nextLine();
        if (toss.equalsIgnoreCase("1")) {
            System.out.println(teams[number] + " is Batting first ");
            String[] strike = new String[2];
            strike[0] = teamA[0];
            strike[1] = teamA[1];

            System.out.println("Enter no of overs");

            String ball;
            int score = 0;
            int score1 = 0;
            try {
                int overs = scan.nextInt();
                scan.nextLine();
                System.out.println("On Strike : " + strike[0] + "     ||      Non Strike : " + strike[1]);
                System.out.println("First Over");
                for (int i = 1; i <= overs * 6; i++) {

                    ball = scan.nextLine();
                    if (i % 6 == 0 && i != overs * 6) {
                        System.out.println("New Over");
                    }
                    if (ball.equalsIgnoreCase("wd")) {

                        System.out.println("Is there any extra more than a Wide");
                        {
                            int extra = scan.nextInt();
                            scan.nextLine();
                            score = score + 1 + extra;
                            i--;
                        }
                    } else if (ball.equalsIgnoreCase("nb")) {
                        System.out.println("Wohoo! You've got a free hit");
                        System.out.println("Is there any extra more than a No Ball ");
                        int extra = scan.nextInt();
                        if (extra % 2 == 1) {
                            strike = swapStrike(strike);
                        }
                        scan.nextLine();
                        score = score + 1 + extra;
                        i--;

                    } else if (ball.equalsIgnoreCase("W")) {
                        System.out.println("Oh! A wicket is gone");
                        strike[0] = teamA[index++];
                    } else if (Integer.parseInt(ball) < 0 || Integer.parseInt(ball) > 6) {
                        System.out.println("Invalid Score ");
                        i--;
                    } else {
                        score = score + Integer.parseInt(ball);
                        if (Integer.parseInt(ball) % 2 == 1) {
                            strike = swapStrike(strike);
                        }
                    }
                    System.out.println("Current Score : " + score);
                    System.out.println("On Strike : " + strike[0]);
                    System.out.println("Non Strike : " + strike[1]);
                }
                System.out.println("Inning ends");
                System.out.println("Total Score by Team " + teams[number] + " is " + score);
                System.out.println("New Innings: ");
                System.out.println("First Over");
                strike[0] = teamB[0];
                strike[1] = teamB[1];
                System.out.println("On Strike : " + strike[0] + "     ||      Non Strike : " + strike[1]);
                index = 2;
                for (int i = 1; i <= overs * 6; i++) {
                    {
                        ball = scan.nextLine();
                        if (i % 6 == 0 && i != overs * 6) {
                            System.out.println("New Over");
                        }
                        if (ball.equalsIgnoreCase("wd")) {

                            System.out.println("Is there any extra more than a Wide");
                            {
                                int extra = scan.nextInt();
                                scan.nextLine();
                                if (extra % 2 == 1) {
                                    strike = swapStrike(strike);
                                }
                                score1 = score1 + 1 + extra;
                                i--;
                            }
                        } else if (ball.equalsIgnoreCase("nb")) {
                            System.out.println("Wohoo! You've got a free hit");
                            System.out.println("Is there any extra more than a No Ball ");
                            int extra = scan.nextInt();
                            scan.nextLine();
                            score1 = score1 + 1 + extra;
                            i--;
                            if (extra % 2 == 1) {
                                strike = swapStrike(strike);
                            }

                        } else if (ball.equalsIgnoreCase("W")) {
                            System.out.println("Oh! A wicket is gone");
                            strike[0] = teamB[index++];
                        } else if (Integer.parseInt(ball) < 0 || Integer.parseInt(ball) > 6) {
                            System.out.println("Invalid Score ");
                            i--;
                        } else {
                            score1 = score1 + Integer.parseInt(ball);
                        }
                    }
                    System.out.println("Current Score : " + score1);
                    System.out.println("On Strike : " + strike[0]);
                    System.out.println("Non Strike : " + strike[1]);

                }

            } catch (Exception e) {
                System.out.println("Invalid Output");
            }
            if(score > score1){
                System.out.println(teams[number] + " won by "+ (score-score1) + " runs");
            }
            else{
                System.out.println(teams[number] + " loss by " + (score1 - score) + " runs");
            }
        }
        else if(toss.equalsIgnoreCase("2")){

                System.out.println(teams[number2] + " is Batting first ");

                String[] strike = new String[2];
                strike[0] = teamB[0];
                strike[1] = teamB[1];

                System.out.println("Enter no of overs");

                String ball;
                int score = 0;
                int score1 = 0;
                try {
                    int overs = scan.nextInt();
                    scan.nextLine();
                    System.out.println("On Strike : " + strike[0] + "     ||      Non Strike : " + strike[1]);
                    System.out.println("First Over");
                    for (int i = 1; i <= overs * 6; i++) {

                        ball = scan.nextLine();
                        if (i % 6 == 0 && i != overs * 6) {
                            System.out.println("New Over");
                        }
                        if (ball.equalsIgnoreCase("wd")) {

                            System.out.println("Is there any extra more than a Wide");
                            {
                                int extra = scan.nextInt();
                                scan.nextLine();
                                score = score + 1 + extra;
                                i--;
                            }
                        } else if (ball.equalsIgnoreCase("nb")) {
                            System.out.println("Wohoo! You've got a free hit");
                            System.out.println("Is there any extra more than a No Ball ");
                            int extra = scan.nextInt();
                            if (extra % 2 == 1) {
                                strike = swapStrike(strike);
                            }
                            scan.nextLine();
                            score = score + 1 + extra;
                            i--;

                        } else if (ball.equalsIgnoreCase("W")) {
                            System.out.println("Oh! A wicket is gone");
                            strike[0] = teamB[index++];
                        } else if (Integer.parseInt(ball) < 0 || Integer.parseInt(ball) > 6) {
                            System.out.println("Invalid Score ");
                            i--;
                        } else {
                            score = score + Integer.parseInt(ball);
                            if (Integer.parseInt(ball) % 2 == 1) {
                                strike = swapStrike(strike);
                            }
                        }
                        System.out.println("Current Score : " + score);
                        System.out.println("On Strike : " + strike[0]);
                        System.out.println("Non Strike : " + strike[1]);
                    }
                    System.out.println("Inning ends");
                    System.out.println("Total Score by Team " + teams[number2] + " is " + score);
                    System.out.println("New Innings: ");
                    System.out.println("First Over");
                    strike[0] = teamA[0];
                    strike[1] = teamA[1];
                    System.out.println("On Strike : " + strike[0] + "     ||      Non Strike : " + strike[1]);
                    index = 2;
                    for (int i = 1; i <= overs * 6; i++) {
                        {
                            ball = scan.nextLine();
                            if (i % 6 == 0 && i != overs * 6) {
                                System.out.println("New Over");
                            }
                            if (ball.equalsIgnoreCase("wd")) {

                                System.out.println("Is there any extra more than a Wide");
                                {
                                    int extra = scan.nextInt();
                                    scan.nextLine();
                                    if (extra % 2 == 1) {
                                        strike = swapStrike(strike);
                                    }
                                    score1 = score1 + 1 + extra;
                                    i--;
                                }
                            } else if (ball.equalsIgnoreCase("nb")) {
                                System.out.println("Wohoo! You've got a free hit");
                                System.out.println("Is there any extra more than a No Ball ");
                                int extra = scan.nextInt();
                                scan.nextLine();
                                score1 = score1 + 1 + extra;
                                i--;
                                if (extra % 2 == 1) {
                                    strike = swapStrike(strike);
                                }

                            } else if (ball.equalsIgnoreCase("W")) {
                                System.out.println("Oh! A wicket is gone");
                                strike[0] = teamB[index++];
                            } else if (Integer.parseInt(ball) < 0 || Integer.parseInt(ball) > 6) {
                                System.out.println("Invalid Score ");
                                i--;
                            } else {
                                score1 = score1 + Integer.parseInt(ball);
                            }
                        }
                        System.out.println("Current Score : " + score1);
                        System.out.println("On Strike : " + strike[0]);
                        System.out.println("Non Strike : " + strike[1]);

                    }

                } catch (Exception e) {
                    System.out.println("Invalid Output");
                }
                if(score > score1){
                    System.out.println(teams[number2] + " won by "+ (score-score1) + " runs");
                }
                else{
                    System.out.println(teams[number2] + " loss by " + (score1 - score) + " runs");
                }
            }
        else{
            System.out.println("Invalid Option");
        }


    }
}