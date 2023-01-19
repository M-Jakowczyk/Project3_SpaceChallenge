import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation simulation = new Simulation();
        ArrayList<String> pathFileList = new ArrayList<>();
        pathFileList.add("src/phase-1.txt");
        pathFileList.add("src/phase-2.txt");
        ArrayList<Integer> budgets = new ArrayList<>();

        for (String pathFile : pathFileList) {
            System.out.println("---------------U1-------------------");
            simulation.loadItems(pathFile);
            simulation.loadU1();

            int budgetU1 = simulation.runSimulation(simulation.rocketU1List);
            System.out.println("Budget use for U1 rocket: " + budgetU1);

            System.out.println("---------------U2-------------------");
            simulation.loadItems(pathFile);
            simulation.loadU2();

            int budgetU2 = simulation.runSimulation(simulation.rocketU2List);
            System.out.println("Budget use for U2 rocket: " + budgetU2);

            budgets.add(budgetU1);
            budgets.add(budgetU2);
        }

        System.out.println("__________________Compare_________________");
        int j=1;
        for (int i=0;i<=3;i++){
            System.out.println("Phase "+(j));

            if(i%2==0){
                System.out.println("Budget use for U1 rocket: "+budgets.get(i));
            }
            else{
                System.out.println("Budget use for U2 rocket: "+budgets.get(i));
                j++;
            }
        }
        System.out.println("Difference between U1 - U2 (phase_1): ");
        System.out.println(Math.abs(budgets.get(0)-budgets.get(1)));
        System.out.println("Difference between U1 - U2 (phase_2): ");
        System.out.println(Math.abs(budgets.get(2)-budgets.get(3)));

    }
}

