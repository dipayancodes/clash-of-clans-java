import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;
    private int townhallLevel;
    private int gold;
    private int elixir;
    private int troopCapacity;
    private List<Troop> troops;

    public Player(String name) {
        this.name = name;
        this.townhallLevel = 1;
        this.gold = 1000;
        this.elixir = 1000;
        this.troopCapacity = 20;
        this.troops = new ArrayList<>();
    }

    public void printResources() {
        System.out.println("Gold: " + gold);
        System.out.println("Elixir: " + elixir);
    }

    public void printTroops() {
        System.out.println("Troops: ");
        for (Troop troop : troops) {
            System.out.println(troop);
        }
    }

    public void attack() {
        Random random = new Random();
        int enemyTownhallLevel = random.nextInt(10) + 1;
        if (townhallLevel > enemyTownhallLevel) {
            System.out.println("You won the attack!");
        } else {
            System.out.println("You lost the attack!");
        }
    }

    public void trainTroop(Troop troop) {
        if (troops.size() >= troopCapacity) {
            System.out.println("Troop capacity reached. Upgrade your camps to train more troops.");
        } else {
            if (gold >= troop.getCost()) {
                gold -= troop.getCost();
                troops.add(troop);
            } else {
                System.out.println("Not enough gold to train the troops.");
            }
        }
    }
}

class Troop {
    private String name;
    private int cost;

    public Troop(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + " - Cost: " + cost;
    }
}

public class ClashOfClans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Clash of Clans (CLI Version)!");
        System.out.print("Enter Your Name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        while (true) {
            System.out.println("\n[MAIN MENU]");
            System.out.println("1. Print Resources");
            System.out.println("2. Print Troops");
            System.out.println("3. Train Troops");
            System.out.println("4. Attack");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                player.printResources();
            } else if (choice.equals("2")) {
                player.printTroops();
            } else if (choice.equals("3")) {
                System.out.print("Enter the Troop name: ");
                String troopName = scanner.nextLine();
                System.out.print("Enter the troop cost: ");
                int troopCost = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                Troop troop = new Troop(troopName, troopCost);
                player.trainTroop(troop);
            } else if (choice.equals("4")) {
                player.attack();
            } else if (choice.equals("5")) {
                System.out.println("Thanks for Playing Clash of Clans (CLI version)!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

