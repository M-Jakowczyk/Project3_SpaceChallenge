import java.util.ArrayList;
import java.util.Random;

public class U1 extends Rocket {

    {
        cost = 100000000; //$100 Million = 100 000 000 $
        weight = 10000; // 10 Tonnes = 10 000 kg
        maxWeight = 18000; //(with cargo) = 18 Tonnes = 18 000 kg
        ArrayList<Item> cargoList;
        currentWeight = weight;
    }
    public U1() {
        int cost = 100000000;
        int weight = 10000; // 10 Tonnes = 10 000 kg
        int maxWeight = 18000; //(with cargo) = 18 Tonnes = 18 000 kg
        ArrayList<Item> cargoList;
        // Chance of launch explosion = 5 % *(cargo carried / cargo limit)
        // Chance of landing crash = 1 % *(cargo carried / cargo limit)
    }

    public boolean launch() {
        //double chanceOfLaunchEXP = (0.05 * (cargoCarried/maxWeight));
        double chanceOfExplode = new Random().nextDouble();
 /*       System.out.println("Max cargo weight: "+ (maxWeight-weight));
        System.out.println("Cargo weight: "+ (currentWeight-weight));
        System.out.println("Current weight: "+ (double)((currentWeight-weight)/(maxWeight-weight)));
   */   double chanceOfLaunchEXP = 0.05 *((double)(currentWeight-weight)/(double)(maxWeight-weight));
   //     System.out.println("Chance Explode: "+ chanceOfExplode);
   //     System.out.println("Chance to explode: "+ chanceOfLaunchEXP);
        if (chanceOfExplode>=chanceOfLaunchEXP){
            System.out.println("Launch succeeded!!!");
            return true;
        }
        else {
            System.out.println("Rocket exploded when start!!!");
        return false;}
    }

    public boolean land() {
        //double chanceOfLandingCrash = 0.01 * (cargoCarried/maxWeight);
        double chanceOfExplode = new Random().nextDouble();
  /*      System.out.println("Max cargo weight: "+ (maxWeight-weight));
        System.out.println("Cargo weight: "+ (currentWeight-weight));
        System.out.println("Current weight: "+ ((double)(currentWeight-weight)/(double)(maxWeight-weight)));
   */   double chanceOfLandingCrash = 0.01 *((double)(currentWeight-weight)/(double)(maxWeight-weight));
   //     System.out.println("Chance Explode: "+ chanceOfExplode);
   //     System.out.println("Chance to explode: "+ chanceOfLandingCrash);
        if (chanceOfExplode>=chanceOfLandingCrash){
            System.out.println("Landed succeeded!!!");
            return true;
        }
        else {
            System.out.println("Rocket exploded when landing!!!");
            return false;}
    }
}
