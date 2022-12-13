package ftblLeagueSimulator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FootballLeague {
    private final String leagueName;
    private final List<Team> teamList;
    Random rand = new Random();

    // Constructor for creating a new FootballLeague 'instance'
    public FootballLeague(String leagueName){
        this.leagueName = leagueName;
        this.teamList = new LinkedList(); // Initializing the teamList instance variable with a new LinkedList object


    }
    // Overriding the toString method to print out information about the league and its teams
    public String toString(){
        String output = "";
        output += "FootballLeague: " + this.leagueName + "\n"; // Adding the league name to the output

        // Loop through each team in the teamList and add its information to the output
        Integer position = 1; // Creating a new Integer variable for the team's position in the league
        for (Team tInstance: this.teamList)
        {
            output += "\n#" + position.toString() + "\n";
            output += tInstance;
            position += 1;
        }
        return output;
    }

    // This method adds a new team to the teamList if it does not already exist
    public void addNewTeam(Team t){
// Loop through each team in the teamList
        for (int index = 0; index < teamList.size(); index++){
// Check if the current team has the same name as the team being added
            if (teamList.get(index).getName().equals(t.getName())) {
// If there is a match, print an error message and return
                System.out.println("\nERROR: Duplicate team\n\n");
                return;
            }
        }
// If the team does not exist in the list, add it
        this.teamList.add(t);
    }

    // This method removes a team from the teamList
    public void removeOldTeam(Team t){
// Remove the specified team from the teamList
        this.teamList.remove(t);
    }

    // This method simulates a random win for one of the teams and updates their win/loss count
    public void win_random(Team t1, Team t2) {
// Generate a random number between 0 and 2
        if (rand.nextInt(3) == 1){
// If the number is 1, team 1 wins and team 2 loses
            t1.increaseWin();
            t2.increaseLosses();
        }
        else {
// If the number is not 1, team 2 wins and team 1 loses
            t2.increaseWin();
            t1.increaseLosses();
        }

    }

    // This method simulates a draw between the two teams and updates their draw count
    public void drawMatch(Team t1, Team t2) {
// Loop through all teams in the teamList
        for (Team team : this.teamList) {
// Check if team 1's name matches the current team in the loop
            if (t1.getName().compareTo(team.getName()) == 0) {
// If it does, increase team 1's draw count
                t1.increaseDraws();
            }
// Check if team 2's name matches the current team in the loop
            if (t2.getName().compareTo(team.getName()) == 0) {
// If it does, increase team 2's draw count
                t2.increaseDraws();
            }
        }
// Sort the teamList by team stats
        Collections.sort(this.teamList);
// Print out the updated team standings
        System.out.println(this);
    }

    public void relegation(FootballLeague league1, FootballLeague league2){

        //Loop through 3 times for 3 teams to be relegated/promoted
        for (int i = 0; i < 3; i++) {

            //Get the team at the bottom of the table from league1
            Team tmp = teamList.get(3);

            //Remove the team from league1
            league1.removeOldTeam(teamList.get(3));

            //Promote the top team from league2 to league1
            league1.addNewTeam(league2.teamList.get((0)));

            //Remove the promoted team from league2
            league2.removeOldTeam(league2.teamList.get(0));

            //Relegate the bottom team from league1 to league2
            league2.addNewTeam(tmp);

        }
    }






























    //Addition
    public void matchRandomizer(Team t1, Team t2){
        switch(rand.nextInt(3)){
            case 0: win_random(t1,t2);
                break;
            case 1: drawMatch(t1,t2);
                break;
        }
    }
    //Comments are important, exiplain it
    public void full_season(FootballLeague league){
        for(int i =0 ; i < 20; i++){
            league.matchRandomizer(league.teamList.get(0), league.teamList.get(1));
            league.matchRandomizer(league.teamList.get(2), league.teamList.get(3));
            league.matchRandomizer(league.teamList.get(4), league.teamList.get(5));
        }
    }
    ///function called round --> round 20 = relegation
}
