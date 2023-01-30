import java.util.ArrayList;
import java.util.Scanner;

public class Gara {
    String data;
    String vendndodhja;
    String emriShoferit;
    String emriSkuadres;
    int pozicioni;

    Gara() {}; //konstruktori default
    Gara(String data, String vendndodhja, String emriShoferit, String emriSkuadres, int pozicioni){
        this.vendndodhja = vendndodhja;
        this.data = data;
        this.emriShoferit = emriShoferit;
        this.emriSkuadres = emriSkuadres;
        this.pozicioni = pozicioni;
    }

    static int FindPointsFromPosition(int pozicioni)
    {
        switch (pozicioni) {
            case 1:
                return 25;
            case 2:
                return 18;
            case 3:
                return 15;
            case 4:
                return 12;
            case 5:
                return 10;
            case 6:
                return 8;
            case 7:
                return 6;
            case 8:
                return 4;
            case 9:
                return 2;
            case 10:
                return 1;
            default:
                return 0;
        }

    }
    public static void addRace(ArrayList<Gara> races, ArrayList<Formula1Driver> drivers){

        String data;
        String vendndodhja;
        int id;
        int pozicioni = 0;

        Scanner a = new Scanner(System.in);

        System.out.println("Shtoni nje gare" +"\n");

        System.out.println("Data ne formatin dd/mm/yyyy: ");
        data = a.next();
        System.out.println("Vendndodhja: ");
        vendndodhja = a.next();

        System.out.println("Nr. i pjesmarresve ne gare: ");
        int nr = a.nextInt();
        for(int i = 0; i < nr; i++){
            System.out.println("Shkruani te dhenat per pjesmarresin nr.  "+i+": ");
            System.out.println("Zgjidhni shoferin duke dhene numrin perkates: ");

            int count = 0;
            for (Formula1Driver x : drivers) {
                System.out.println(count + " - " + x.getName().toString());
                count++;
            }


            id = a.nextInt();
            String emriShoferit = drivers.get(id).getName();
            String emriSkuadres = drivers.get(id).getTeam();

            System.out.println("Shkruani pozicionin per shoferin # "+emriShoferit+" # dhe skuadren # "+emriSkuadres+" #:");
            pozicioni = a.nextInt();

            updataDrivers(id, drivers, pozicioni);
            races.add(new Gara(data, vendndodhja, emriShoferit, emriSkuadres, pozicioni));


        }



    }
    public static void updataDrivers(int idShoferi, ArrayList<Formula1Driver> drivers,int pozicioni){

        Formula1Driver a = drivers.get(idShoferi);


        int Vend1 = 0;
        int Vend2 = 0;
        int Vend3 = 0;

        switch (pozicioni){
            case 1:
                Vend1++;
                break;
            case 2:
                Vend2++;
                break;
            case 3:
                Vend3++;
                break;
            default: break;
        }
        int piket = FindPointsFromPosition(pozicioni);

        Formula1Driver driver = new Formula1Driver(
                a. getName(),
                a.getLocation(),
                a.getTeam(),
                a.getFirstPositions() + Vend1,
                a.getSecondPositions() + Vend2,
                a.getThirdPositions() + Vend3,
                a.getTotalPoints() + piket,
                a.getRaces() + 1

        );

        drivers.set(idShoferi, driver);
    }
    public String getData() {
        return data;
    }

    public String getVendndodhja() {
        return vendndodhja;
    }

    public int getPozicioni() {
        return pozicioni;
    }

    public String getEmriShoferit() {
        return emriShoferit;
    }

    public String getEmriSkuadres() {
        return emriSkuadres;

    }
}

