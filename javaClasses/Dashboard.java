package ftblLeagueSimulator;

public class Dashboard {
    // Main
    public static void main(String[] args) {

        // Setting the name of the example league and the names of the relevant teams
        FootballLeague l1 = new FootballLeague("Premier League");
        Team t1 = new Team("Arsenal");
        Team t2 = new Team("Liverpool");
        Team t3 = new Team("Manchester Utd");
        Team t4 = new Team("Manchester City");
        Team t5 = new Team("Chelsea");
        Team t6 = new Team("Newcastle Utd");
        l1.addNewTeam(t1);
        l1.addNewTeam(t2);
        l1.addNewTeam(t3);
        l1.addNewTeam(t4);
        l1.addNewTeam(t5);
        l1.addNewTeam(t6);

        // Setting up another league with teams to base relegation and promotion off
        FootballLeague l2 = new FootballLeague("Championship");
        Team t7 = new Team("Huddersfield");
        Team t8 = new Team("Burnley");
        Team t9 = new Team("Norwich City");
        Team t10 = new Team("Watford");
        Team t11 = new Team("Blackburn");
        Team t12 = new Team("West Brom");
        l2.addNewTeam(t7);
        l2.addNewTeam(t8);
        l2.addNewTeam(t9);
        l2.addNewTeam(t10);
        l2.addNewTeam(t11);
        l2.addNewTeam(t12);

        // Displaying the two leagues
        System.out.println(l1);
        System.out.println(l2);
    }
}
