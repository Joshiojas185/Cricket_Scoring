/*
This Class is created to implement three methods such as showing teams, adding a new Team to the list, and adding
teams to the teamMembers array
 */
public class Team {
    public static String[][] teamMembers = Constant.teamMembers;
    // used to show names of all existing Teams
    public static void showTeams(String[] teams){
        for(int i = 0 ; i < teams.length; i++){
            System.out.println((i+1)+ "." + teams[i]);
        }
    }
    // used to add a string in the Array
    public static String[] addTeam(String[] teamArray,String newTeam){
        teamArray = MyArray.addItem(teamArray,newTeam);
        return teamArray;
    }
    // used to add a member in a particular team
    public static String[] addInATeam(String[] teamMembers, String[] team){
        String[] newArray = new String[teamMembers.length + team.length];
        int index = 0 ;
        for(int i = 0 ; i < teamMembers.length ; i++){
            newArray[index++] = teamMembers[i];
        }
        for(int i = 0 ; i < team.length ; i++){
            newArray[index++] = team[i];
        }
        return newArray;
    }
    // used to add a String array in the teamMember Array
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
    // used to get the name of the member at a particular Index
    public static String[] getTeamMembers(int teamIndex) {
        if (teamIndex >= 0 && teamIndex < teamMembers.length) {
            return teamMembers[teamIndex];
        } else {
            return new String[0];
        }
    }

}
