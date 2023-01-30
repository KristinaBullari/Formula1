import java.io.Serializable;


public class Formula1Driver extends Driver implements Serializable{
    private int firstpositions;
    private int secondpositions;
    private int thirdpositions;
    private int totalPoints;
    private int races;
    private int pointsPerRace;

    public Formula1Driver(String name, String location, String team, int firstpositions, int secondpositions, int thirdpositions, int points, int races){
        super(name, location, team);
        this.firstpositions = firstpositions;
        this.secondpositions = secondpositions;
        this.thirdpositions = thirdpositions;
        this.totalPoints = points;
        this.races = races;
    }

    public Formula1Driver(int races, int points){
        this.races = races;
        this.totalPoints = points;
    }


    public Formula1Driver() {
        super();
    }

    public int getFirstPositions(){
        return firstpositions;
    }

    public int getSecondPositions(){
        return secondpositions;
    }

    public int getThirdPositions(){
        return thirdpositions;
    }

    public int getTotalPoints(){

        return totalPoints;
    }

    public int getRaces(){
        return races;
    }

    public void setFirstPositions(int fp){
        firstpositions = fp;
    }

    public void setSecondPositions(int sp){
        secondpositions = sp;
    }

    public void setThirdPositions(int tp){
        thirdpositions = tp;
    }

    public void setTotalPoints(int pts){
        totalPoints = pts;
    }

    public void setRaces(int rcs){
        races = rcs;
    }

    public int getPointsPerRace() {
        return pointsPerRace;
    }

    public void setPointsPerRace(int pointsPerRace) {
        this.pointsPerRace = pointsPerRace;
    }

    @Override
    public String toString() {
        return "Driver: "+getName()+
                " Location: "+getLocation()+
                " Team: "+getTeam()+
                "\nNo. of 1st positions: " + getFirstPositions() +
                "\nNo. of 2nd positions: "+ getSecondPositions() +
                "\nNo. of 3rd positions: " + getThirdPositions() +
                "\nPoints: " + getTotalPoints() +
                " Races: " + getRaces();
    }
}

//Class ChampionshipManager




