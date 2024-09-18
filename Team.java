public class Team {
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
    public static void main(String[] args) {

    }
    public static void showTeams(String[] teams){
        for(int i = 0 ; i < teams.length; i++){
            System.out.println((i+1)+ "." + teams[i]);
        }
    }
    public static String[] addTeam(String[] teamArray,String newTeam){
        teamArray = MyArray.addItem(teamArray,newTeam);
        return teamArray;
    }
    public static String[][] addTeamMembers(String[][] teamMembers, String[] teams){
        String[][] newArray = new String[teamMembers.length+1][];
        for(int i = 0 ; i < teamMembers.length; i++){
            for (int j = 0; j < teamMembers[i].length ; j++) {
              newArray[i][j] = teamMembers[i][j];
            }
        }
        newArray[newArray.length-1] = teams;
        return newArray;
    }
    public static String[] get11(int index){
//        index = index - 1;
        String[] newArray = new String[11];
        for(int i = 0 ; i < newArray.length;i++){
            newArray[i] = teamMembers[index][i];
        }
        return newArray;
    }
public static String[] getTeamMembers(int teamIndex) {
    if (teamIndex >= 0 && teamIndex < teamMembers.length) {
        return teamMembers[teamIndex];
    } else {
        return new String[0];
    }
}

}
