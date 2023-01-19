import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Rocket> rocketU1List;
    public ArrayList<Rocket> rocketU2List;
   // public String filepath = "src/phase-1.txt";
    public ArrayList<Item> itemsList;
    int missionBudget = 0;


    //this method loads all items from a text file and returns an ArrayList of Items
    ArrayList<Item> loadItems(String filepath) throws FileNotFoundException {
        File filesItem = new File(filepath);
        itemsList = new ArrayList<>();
        System.out.println("Loading items...");
        if (filesItem.exists()) {
            Scanner scanner = new Scanner(filesItem);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split("=");
                Item oneItem = new Item(splitLine[0], Integer.parseInt(splitLine[1]));

                itemsList.add(oneItem);
            }
        }

        return itemsList;
    }

    //is method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets
    ArrayList<Rocket> loadU1() {
        rocketU1List = new ArrayList<Rocket>();
        Rocket rocket = new U1();
        ArrayList<Item> collectItemsU1 = new ArrayList<>();
        System.out.println("Create U1 rocket...");

        while(!itemsList.isEmpty()) {
            for (Item item1 : itemsList) {
                System.out.println("Current item: " + item1.name);
                if (rocket.canCarry(item1)) {
                    collectItemsU1.add(item1);
                    rocket.carry(item1);
                }
                else { break;}
            }
            System.out.println("Rocket (" + (rocketU1List.size() + 1) + ") U1 is full.");
            System.out.println("Loaded: ");
            for (Item item2 : collectItemsU1) {
                System.out.print(item2.name);
                System.out.print(" : ");
                System.out.println(item2.weight);
                itemsList.remove(itemsList.indexOf(item2));
            }
            System.out.println("Current weight: " + rocket.currentWeight);
            rocket.cargoList = collectItemsU1;
            rocketU1List.add(rocket);

            if (!itemsList.isEmpty()) {
                System.out.println("Create next U1 rocket...");
                collectItemsU1 = new ArrayList<>();
                rocket = new U1();
            }
        }

        return rocketU1List;
    }

    ArrayList<Rocket> loadU2() {
        rocketU2List = new ArrayList<Rocket>();
        Rocket rocket = new U1();
        ArrayList<Item> collectItemsU1 = new ArrayList<>();
        System.out.println("Create U2 rocket...");

        while(!itemsList.isEmpty()) {
            for (Item item1 : itemsList) {
                System.out.println("Current item: " + item1.name);
                if (rocket.canCarry(item1)) {
                    collectItemsU1.add(item1);
                    rocket.carry(item1);
                }
                else { break;}
            }
            System.out.println("Rocket (" + (rocketU2List.size() + 1) + ") U2 is full.");
            System.out.println("Loaded: ");
            for (Item item2 : collectItemsU1) {
                System.out.print(item2.name);
                System.out.print(" : ");
                System.out.println(item2.weight);
                itemsList.remove(itemsList.indexOf(item2));
            }
            System.out.println("Current weight: " + rocket.currentWeight);
            rocket.cargoList = collectItemsU1;
            rocketU2List.add(rocket);

            if (!itemsList.isEmpty()) {
                System.out.println("Create next U2 rocket...");
                collectItemsU1 = new ArrayList<>();
                rocket = new U1();
            }
        }

        return rocketU2List;
    }

    int runSimulation(ArrayList<Rocket> rocketList) {
        int i = 1;
        int totalLaunched = 0;
        int totalLanded = 0;
        int totalCrashed = 0;
        int rocketCost = rocketList.get(0).cost;
        int totalNumberRockets = rocketList.size();
        boolean landed;

        for (Rocket rocket1 : rocketList) {
            landed = false;
            System.out.println("Starting rocket " + i);
            while (!landed) {
                if (rocket1.launch()) {
                    i++;
                    //System.out.println("Rocket launched!!!");
                    totalLaunched++;
                    if (rocket1.land()) {
                        //System.out.println("Rocket landed!!!");
                        totalLanded++;
                        landed = true;
                    } else {
                        System.out.println("Rocket crash when land \\|/ :(");
                        System.out.println("We need send another rocket...");
                        totalCrashed++;
                    }
                } else {
                    System.out.println("Rocket crash when launch /|\\ :(");
                    totalCrashed++;
                }
            }

        }
        System.out.println("Total landed: "+totalLanded);
        System.out.println("Total crashed: "+ totalCrashed);
        missionBudget = (totalLanded + totalCrashed) * rocketCost;
        return missionBudget;
    }
}
