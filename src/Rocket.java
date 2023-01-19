import java.util.ArrayList;

public class Rocket implements SpaceShip {
    int cost;
    int weight;
    int maxWeight;
    int currentWeight;
    ArrayList<Item> cargoList;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item items) {
        //method that takes an Item as an argument and returns true if the rocket can carry such item or false if it will exceed the weight limit.
      //  System.out.println("run canCarry..." + maxWeight +" "+weight+" "+items.weight);
        if ((maxWeight - currentWeight) >= items.weight){
       //     System.out.println("return true");
            return true;
        }
        else {return false;}
    }

    public void carry(Item item) {
        //updates the current weight of the rocket
     //   System.out.println("run carry...");
        currentWeight += item.weight;
    }
}
