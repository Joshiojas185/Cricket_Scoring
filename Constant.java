/*
In this class we are declaring the constants which we will be using in the other classes.
This class will contain all the hard coded or the constant values
Program Owner -> Ojas Joshi
Date -> 19/09/2024
 */
public class Constant {
    static String[] teamArray = {"India", "Australia","South Africa"};
    static String WELCOME = "Welcome to the Program";
    static String ADD_TEAM = "Enter the New Team Name";
    static String UPDATED_TEAM_LIST = "The Updated Team List is";
    static String CHOOSE_OPERATION = "Choose the Operation | Enter 0 To EXIT";
    static String CHOOSE_TEAM_NUMBER = "Choose Team Number";
    static String N0_MEMBER = "No Members for Team ";
    static String INVALID_TEAM_NO = "Invalid team number! Or There is No Members in the Team";
    static String INPUT_TEAM_MEMBER = "Enter 4 to the members of the team (type 'N' to stop):";
    static String ENTER_TEAM_MEMBERS = "Enter the members of the team (type 'N' to stop):";
    static String MATCH_TEAMS = "Between Which Teams u want the Match";
    static String EXIT_MESSAGE = "Program exits";
    static String ERROR_HANDLING = "Error: Invalid input. Please try again.";
    static String INVALID_INPUT = "Please Choose a Valid Input";
    static String FIRST_OVER = "First Over";
    static String CURRENT_BOWLER = "Bowler: " ;
    static String CURRENT_SCORE = "Current Score : " ;
    static String NEW_OVER = "New Over";
    static String WIDE_EXTRA = "Is there any extra more than a Wide";
    static String NB_EXTRA = "Is there any extra more than a No Ball ";
    static String FREE_HIT = "Wohoo! You've got a free hit";
    static String ALL_OUT = "All 10 Wickets are gone ";
    static String WICKET = "Oh! A wicket is gone";
    static String TIE = "Scores Level - The Match is Tied";
    static String INVALID_SCORE = "Invalid Score ";
    static String ON_STRIKE = "On Strike : ";
    static String NON_STRIKE = "Non Strike : ";
    static String NO_OF_OVERS = "Enter no of overs";
    static String INNINGS_END = "End Of Innings";
    static String TOTAL_SCORE = "Total Score After the Inning Ends for Team ";
    static String NEW_INNINGS = "Start of New Innings";
    static String PLAYING_11 = "Playing 11 for team ";
    static String ADD_COMMENT = "Add the New Comment ";
    static String COMMENT = "Do u wanna add a Comment or you Just wanna look for Others (Y/N)";
    static String SELECT_BOWLER = "Select Bowler";
    static String PLAY = "LET'S PLAY !!!!!!!! ";
    static String INVALID_NUMBER = "Invalid Player Number";
    static String SELECT_PLAYERS = "Select your 11 for Team ";
    static String PLAYING_SQUAD = "Playing Squad for team " ;
    static String BATTING_FIRST = "Which Team is Batting First ? ";
    static String ADD_TEAM_MEMBER = "Do You want to add Members in the newly created Team ?(Type Y for Yes / N for No) ";
    static String MATCH_RULES = """
        Cricket Match Rules (Input is case-insensitive):
        1 - 6 : Run corresponding to ball (must be between 1 to 6)
        wd    : Wide ball, extra run awarded
        nb    : No ball, extra run and free hit awarded
        s     : Swap strike
        w     : Wicket, batsman out
        ap    : Autoplay the innings
        """;
    static String[] LookingFor = {"Yash is Looking a ground for Sunday",
            "Harshit is Looking for a team as a oppononet on Sunday"
            ,"Kunal is Looking for a Team to Join in as an All-Rounder"
    };
    public static String[][] teamMembers = {
            {"Hardik", "Virat", "Rohit", "Jasprit", "Yashaswi", "Md.Siraj", "Kuldeep",
                    "Shubman", "Arshdeep", "Ravindra", "Rishabh Pant", "Shreyas","Axar","Prasidh"},
            {"Steve Smith", "Pat Cummins", "JFM", "Mitch Starc", "Josh Hazlewood",
                    "Mitch Marsh", "Sean Abbott", "Matt Short", "Travis Head", "Glenn", "Marcus","Adam Zampa"},
            {"Aiden Markram", "Heinrich Klassen", "Marco Jansen", "Ab De Villiers"
                    ,"David Miller","Reeza Hendricks","Vernon Philander","Faf Du Plessis"
                    ,"Farhaan Behardein","Imran Tahir","Dale Steyn","Morne Morkel"
            }
    };
    static String OPERATION_CHOICES = """
            1 -> Show Teams
            2 -> Add New Team
            3 -> Show Team Members
            4 -> Add Members in a Team
            5 -> Create a Match
            6 -> Looking for !------
            0 -> TO EXIT THE PROGRAM""" ;
}
