import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Formula1ChampionshipManager extends Formula1Driver implements file {
    private int f1drivers;
    private int f1cars;
    private int fp=0;
    private int sp=0;
    private int tp=0;
    private int noOfRaces=0;
    private int currentPoints;
    Scanner input = new Scanner(System.in);

    Random random = new Random();

    static ArrayList<Formula1Driver> driverList = new ArrayList<Formula1Driver>();
    static ArrayList<Gara> raceList = new ArrayList<Gara>();

    public void getDriverList() {

    }

    public Formula1ChampionshipManager(int f1drivers, int f1cars){
        super();
        this.f1drivers = f1drivers;
        this.f1cars = f1cars;
    }

    public int getF1drivers() {
        return f1drivers;
    }

    public void setF1drivers(int f1drivers) {
        this.f1drivers = f1drivers;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getNoOfRaces() {
        return noOfRaces;
    }

    public void setNoOfRaces(int noOfRaces) {
        this.noOfRaces = noOfRaces;
    }

    public int getf1drivers(){
        return f1drivers;
    }

    public int getf1cars(){
        return f1cars;
    }

    public void createNewDriver() {
        System.out.println("Enter the new driver's name: ");
        super.setName(input.nextLine());
        System.out.println("Enter "+super.getName()+"'s team name: ");
        super.setTeam(input.nextLine());
        System.out.println("Enter "+super.getName()+"'s country: ");
        super.setLocation(input.nextLine());
        super.setRaces(getNoOfRaces());
        super.setFirstPositions(getFp());
        super.setSecondPositions(getSp());
        super.setThirdPositions(getTp());
        Formula1Driver newDriver = new Formula1Driver(getName(), getLocation(), getTeam(),
                getFirstPositions(), getSecondPositions(), getThirdPositions(), getTotalPoints(), getRaces());
        driverList.add(newDriver);
        System.out.println(newDriver.getName()+" has been added to this season!");
        for(Formula1Driver driver : driverList){
            System.out.println(driver.toString());
        }
    }
    public void deleteDriver() {
        System.out.println("Enter the name of the driver you want to delete: ");
        String deletingDriver = input.next();
        for (Formula1Driver driver : driverList){
            if (deletingDriver.equalsIgnoreCase(driver.getName())){
                driverList.remove(driver);
            }
        }
        System.out.println(deletingDriver+" has been deleted!");
    }
    public void changeDriver () {
        System.out.println("Enter the team you wish to change the driver for: ");
        String changingTeam = input.next();
        for (Formula1Driver driver : driverList){
            if (changingTeam.equalsIgnoreCase(driver.getTeam())){
                System.out.println("Enter the name of the new driver: ");
                String newDriver = input.next();
                driver.setName(newDriver);
            }
        }
        System.out.println("The racer for "+changingTeam+" has been changed!");
    }
    public void displayStats () {
        System.out.println("Enter the name of the driver you wish to see the statistics for: ");
        String statDriver = input.next();
        for (Formula1Driver driver : driverList){
            if (statDriver.equals(driver.getName())){
                System.out.println("Races participated this season: "+driver.getRaces()+
                        "\nNumber of first positions: "+driver.getFirstPositions()+
                        "\nNumber of second positions: "+driver.getSecondPositions()+
                        "\nNumber of third positions: "+driver.getThirdPositions()+
                        "\nTotal number of points: "+driver.getTotalPoints());
            }
        }
    }
    public void displayTable () {
        System.out.println("Formula 1 Championship 2021 points table");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s", "DRIVER","|", "LOCATION","|", "TEAM","|", "POINTS","|", "1ST POSITIONS","|", "RACES");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        for (Formula1Driver driver : driverList){
            System.out.format("%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s",
                    driver.getName(), "|", driver.getLocation(), "|", driver.getTeam(), "|", driver.getTotalPoints(), "|", driver.getFirstPositions(), "|", driver.getRaces()+"\n");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }



    public void recoverInfo(){

        //Leximi i File-it "race.txt" dhe vendosja e informacionit ne objekt-vektorin ArrayList<GUI.Main.Gara> races
        try {
            FileReader fr = new FileReader(file2);
            BufferedReader input = new BufferedReader(fr);
            String line;
            while((line = input.readLine()) != null)
            {
                String[] info = null;
                info = line.split("\\t");
                raceList.add(new Gara(info[0].toString(), info[1].toString(), info[2].toString(), info[3].toString(),parseInt(info[4])));
            }
            input.close();
            fr.close();
        }
        catch (IOException e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u lexuan me sukses nga file.");

    }
    public static void SaveData(){

        //Vendosja e cdo informacioni te futur nga user-i deri ne kete moment nga objekt-vektori ArrayList<GUI.Main.Gara> races ne file-in "garat.txt"
        try {
            FileWriter fw = new FileWriter(file2);
            Writer output = new BufferedWriter(fw);

            for(Gara race : raceList)
            {
                output.write(race.getData().toString()+ "\t"+ race.getVendndodhja().toString()+ "\t" +race.getEmriShoferit().toString() + "\t" + race.getEmriSkuadres().toString() + "\t" + race.getPozicioni() +"\n");
            }
            output.close();
            fw.close();
        }
        catch (Exception e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u ruajten me sukses ne file.");
    }


    public void recoverInfoShofer(){

        //Leximi i File-it "garat.txt" dhe vendosja e informacionit ne objekt-vektorin ArrayList<GUI.Main.Gara> races
        try {
            FileReader fr1 = new FileReader(file1);
            BufferedReader input = new BufferedReader(fr1);
            String line;
            while((line = input.readLine()) != null)
            {
                String[] info = null;
                info = line.split("\\t");
                driverList.add(new Formula1Driver(info[0].toString(), info[1].toString(), info[2].toString(),parseInt(info[3]),parseInt(info[4]),parseInt(info[5]),parseInt(info[6]),parseInt(info[7])));
            }
            input.close();
            fr1.close();
        }
        catch (IOException e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u lexuan me sukses nga file.");

    }
    public static void SaveDataShofer(){

        //Vendosja e cdo informacioni te futur nga user-i deri ne kete moment nga objekt-vektori ArrayList<GUI.Main.Gara> races ne file-in "garat.txt"
        try {

            FileWriter fw1 = new FileWriter(file1);
            Writer output = new BufferedWriter(fw1);

            for(Formula1Driver drivers : driverList)
            {
                output.write(drivers.getName().toString()+ "\t" +drivers.getLocation().toString() + "\t" + drivers.getTeam().toString() + "\t" + drivers.getFirstPositions() +"\t"+ drivers.getSecondPositions() +"\t"+ drivers.getThirdPositions() +"\t"+ drivers.getTotalPoints() +"\t"+ drivers.getRaces()  +"\n");
            }
            output.close();
            fw1.close();
        }
        catch (Exception e) {
            System.out.println("Ndodhi nje gabim");
            e.printStackTrace();
        }
        System.out.println("Infos u ruajten me sukses ne file.");
    }
    public static void main(String[] args) {


        try{
        Formula1ChampionshipManager fcm1 = new Formula1ChampionshipManager(10, 10);
        Gara gara = new Gara();
        //put info from file to arraylist
        fcm1.recoverInfo();
        fcm1.recoverInfoShofer();
        System.out.println("---------Welcome to FORMULA 1 Championship 2021---------");

        Scanner input = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("\n----Please use the following menu to do your changes----");
            System.out.println("'ND' - Create a new driver" + "\n'DD' - Delete a driver" + "\n'CD' - Change Driver"
                    + "\n'DS' - Display Statistics" + "\n'DT' - Display Table" + "\n'AR' - Add a race"
                    + "\n'SI' - Save information to a file"
                    + "\n'EX' - Exit Program");
            System.out.println("\nPlease enter an option:");
            userInput = input.next();
            userInput = userInput.toUpperCase();
            if (userInput.equals("ND")) {
                fcm1.createNewDriver();

            } else if (userInput.equals("DD")) {
                fcm1.deleteDriver();

            } else if (userInput.equals("CD")) {
                fcm1.changeDriver();

            } else if (userInput.equals("DS")) {
                fcm1.displayStats();

            } else if (userInput.equals("DT")) {
                fcm1.displayTable();

            }
            else if (userInput.equals("AR")) {
                Gara.addRace(raceList, driverList);

            }
            else if (userInput.equals("SI")) {
                fcm1.SaveData();
                fcm1.SaveDataShofer();

            }  else if (userInput.equals("EX")){
                System.out.println("Thank you for using this Formula 1 Championship Manager. Have a nice day!");
                System.exit(0);
            }
        } while (true);

    }
catch (Exception e){
        System.out.println("Ndodhi nje gabim");
        e.printStackTrace();
    }
    }

    @Override
    public String toString() {
            return super.toString();
    }
}
