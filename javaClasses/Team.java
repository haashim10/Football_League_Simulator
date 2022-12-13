package ftblLeagueSimulator;

public class Team implements Comparable<Team> {
    // Declare instance variables for the team's name, wins, draws, losses, and points
    private String name;
    private Integer wins;
    private Integer draws;
    private Integer losses;
    private Integer points;

   //Constructor that takes the team name, and initializes the team's wins, draws, losses, and points.
    public Team(String name){
        this.name = name;
        this.wins   = 0;
        this.draws  = 0;
        this.losses = 0;
        this.points = 0;
    }
    // Getter method for the team's name
    public String getName(){
        return this.name;
    }


    //increases the number of wins for a team by 1 and adds 3 points to their total.
    public void increaseWin(){
        this.wins += 1;
        this.points += 3;
    }

    //increases the number of losses for a team by 1.
    public void increaseLosses(){
        this.losses += 1;
    }

    //increases the number of draws for a team by 1 and adds 1 point to their total.
    public void increaseDraws() {
        this.draws += 1;
        this.points += 1;
    }

    //returns the number of points.
    public int getPoints(){
        return points;
    }

    //toString() method to output each teams details
    public String toString(){
        String output = "";
        output += "Team";
        output += "Name: " + this.name + "\n";
        output += "\tGames Played: " + (this.wins + this.draws + this.losses) + "\n";
        output += "\tWins: " + this.wins + "\n";
        output += "\tDraws: " + this.draws + "\n";
        output += "\tLosses: " + this.losses + "\n";
        output += "\tPoints: " + this.points + "\n";
        output += "";
        return  output;
    }

    // Compares the points of the two teams and returns the difference in points.
    @Override
    public int compareTo(Team o) {
        return -this.points.compareTo(o.points);
    }
}
