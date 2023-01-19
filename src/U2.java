import java.util.ArrayList;
import java.util.Random;

public class U2 extends Rocket {

    {
        cost = 120000000; //$120 Million = 120 000 000 $
        weight = 18000; // 18 Tonnes = 18 000 kg
        maxWeight = 29000; //(with cargo) = 29 Tonnes = 29 000 kg
        ArrayList<Item> cargoList;
        currentWeight = weight;
    }
        // Chance of launch explosion = 4 % *(cargo carried / cargo limit)
        // Chance of landing crash = 8 % *(cargo carried / cargo limit)


    public boolean launch() {
        double chanceOfExplode = new Random().nextDouble();
        double chanceOfLaunchEXP = 0.04 *((double)(currentWeight-weight)/(double)(maxWeight-weight));
        if (chanceOfExplode>=chanceOfLaunchEXP){
            System.out.println("Launch succeeded!!!");
            return true;
        }
        else {
            System.out.println("Rocket exploded when start!!!");
            return false;}
    }

    public boolean land() {
        double chanceOfExplode = new Random().nextDouble();
        double chanceOfLandingCrash = 0.08 *((double)(currentWeight-weight)/(double)(maxWeight-weight));
        if (chanceOfExplode>=chanceOfLandingCrash){
            System.out.println("Landed succeeded!!!");
            return true;
        }
        else {
            System.out.println("Rocket exploded when landing!!!");
            return false;}
    }
}