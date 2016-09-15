import java.util.Scanner;
public class Civilization {
    private static Scanner scan = new Scanner(System.in);
    private static String empire = null;
    private static String[] cities = {"", "", "", "", ""};
    private static double gold = 20.5;
    private static double resources = 30;
    private static int happiness = 10;
    private static int troops = 0;
    private static int tech = 0;
    private static int turn = 0;
    private static int attacks = 0;
    private static int numOfCities = 1;
    private static boolean playing = true;
    private static String reset = "------------------------------";

    public static void main(String[] args) {
        setUpGame();
        while (playing) {
            preformAction();
            if (attacks == 10 || tech == 20) {
                endGame();
            }
            endOfTurn();
        }
    }

    public static void setUpGame() {
        boolean correct = false;
        System.out.println("\n\nWho would you like to play as:");
        System.out.println("America (George Washington) [1]");
        System.out.println("The Zulu (Shaka Zulu)       [2]");
        System.out.println("England (Queen Elizabeth I) [3]");
        System.out.println("or China (Wu Zetian)        [4]\n\n");
        while (!correct) {
            System.out.println("Please enter a number 1 through 4");
            int empireNum = scan.nextInt();
            System.out.println("---");
            if (empireNum == 1) {
                empire = "American";
                correct = true;
            } else if (empireNum == 2) {
                empire = "Zulu";
                correct = true;
            } else if (empireNum == 3) {
                empire = "English";
                correct = true;
            } else if (empireNum == 4) {
                empire = "Chinese";
                correct = true;
            }
        }
        scan.nextLine();
        System.out.println("\nWhat would you like to call your first city?");
        String firstCityName = scan.nextLine();
        System.out.println("---");
        cities[0] = firstCityName;
    }

    public static void endOfTurn() {
        turn++;
        resources++;
        if (happiness > 20) {
            resources = resources + (5 * numOfCities);
        }
        gold = gold + (3 * numOfCities);
        if (resources % 2 == 0) {
            happiness++;
        } else {
            happiness = happiness - 3;
        }
    }

    public static String status() {
        String cS1 = null;
        String currentStatus1 = null;
        String cS2 = null;
        String cS3 = null;
        String cS4 = null;
        if (numOfCities > 1) {
            cS1 = ("\nIt is turn " + turn + " and you, the ");
            cS1 = (cS1 + empire + " empire, have:\n");
            cS1 = (cS1 + numOfCities + " cities\n");
            cS1 = (cS1 + gold + " thousand gold\n");
            cS1 = (cS1 + resources);
            currentStatus1 = (cS1 + " tons of resources\n");
        }
        if (numOfCities == 1) {
            cS1 = "\nIt is turn " + turn + " and you, the ";
            cS1 = cS1 + empire + " empire, have: \n";
            cS1 = cS1 + numOfCities + " city\n";
            cS1 = cS1 + gold + " thousand gold\n";
            currentStatus1 = cS1 + resources + " tons of resources\n";
        }
        if (happiness > 0) {
            cS2 = happiness + " thousand happy citizens\n";
        }
        if (happiness < 0) {
            cS2 = happiness + " thousand angry citizens\n";
        }
        if (happiness == 0) {
            cS2 = "Your people are indifferent to your rule\n";
        }
        if (troops == 0) {
            cS3 = "no army\n";
        }
        if (troops > 0) {
            cS3 = troops + " thousand soldiers\n";
        }
        if (tech == 0) {
            cS4 = "and no technology past the stone age\n";
        }
        if (tech > 0) {
            cS4 = "and " + tech + " technologies past the stone age\n";
        }
        return currentStatus1 + cS2 + cS3 + cS4;
    }

    public static void preformAction() {
        System.out.println(status());
        boolean continuing = true;
        String printing = "On your turn you can:\nSettle a City         ";
        printing = printing + "[1]\nDemolish a City       [2]\nBuild Your";
        printing = printing + " Army       [3]\nResearch Technology   [4]";
        printing = printing + "\nAttack An Enemy City  [5]\nor End Your";
        printing = printing + " Turn      [6]\n";
        System.out.println(printing);
        while (continuing) {
            System.out.println("Please enter a number 1-6");
            int choice = scan.nextInt();
            System.out.println("---");
            scan.nextLine();
            if (choice == 1) {
                settleCity();
                continuing = false;
            }
            if (choice == 2) {
                demolishCity();
                continuing = false;
            }
            if (choice == 3) {
                buildArmy();
                continuing = false;
            }
            if (choice == 4) {
                researchTech();
                continuing = false;
            }
            if (choice == 5) {
                attackCity();
                continuing = false;
            }
            if (choice == 6) {
                continuing = false;
            }
        }
    }

    public static void settleCity() {
        int buy = 0;
        boolean continuing = true;
        if (numOfCities == 1) {
            System.out.println("\nYou have 1 city:");
        } else {
            System.out.println("You have " + numOfCities + " cities:");
        }
        for (int i = 0; i <= (numOfCities - 1); i++) {
            System.out.println(cities[i]);
        }
        String printing = "\nYou can only have at most 5 cities\n";
        printing = printing + "To settle a new city it costs 15.5 gold\n";
        printing = printing + "You currently have " + gold + " gold";
        System.out.println(printing);
        while (continuing) {
            System.out.println("\nWould you like to buy a city?");
            System.out.println("Yes[1]\nNo [2]");
            buy = scan.nextInt();
            System.out.println("---");
            scan.nextLine();
            if (buy == 2) {
                preformAction();
                continuing = false;
            } else if (buy == 1) {
                if (gold < 15.5) {
                    System.out.println("You do not have enough gold");
                    System.out.println(reset);
                } else if (numOfCities >= 5) {
                    System.out.println("You already have 5 cities");
                    System.out.println(reset);
                } else {
                    gold = gold - 15.5;
                    numOfCities++;
                    System.out.println("What will the new city be called?");
                    String newCityName = scan.nextLine();
                    System.out.println("---");
                    cities[numOfCities - 1] = newCityName;
                    System.out.print("Your new city " + newCityName);
                    System.out.println(" is being built");
                    System.out.println(reset);
                }
                continuing = false;
            }
        }
    }

    public static void demolishCity() {
        int destroy = 0;
        boolean cont = true;
        boolean continuing = true;
        if (numOfCities == 1) {
            System.out.println("\nYou have 1 city:");
        } else {
            System.out.println("\nYou have " + numOfCities + " cities:");
        }
        for (int i = 0; i <= (numOfCities - 1); i++) {
            int j = i + 1;
            System.out.println(cities[i] + " [" + j + "]");
        }
        System.out.println("You must have at least 1 city");
        System.out.println("You will gain 1.5 resources by destroying a city");
        System.out.println("You currently have " + resources + " resources");
        while (cont) {
            System.out.println("\nWould you like to raze a city?");
            System.out.println("Yes[1]\nNo [2]");
            destroy = scan.nextInt();
            System.out.println("---");
            scan.nextLine();
            if (destroy == 2) {
                preformAction();
                cont = false;
            } else if (destroy == 1) {
                if (numOfCities == 1) {
                    System.out.print("You only have 1 city and cannot destroy");
                    System.out.println(" it\n" + reset);
                } else {
                    while (continuing) {
                        System.out.print("Which city would you like to raze?");
                        System.out.print("\nPlease enter a number 1 through ");
                        System.out.print(numOfCities + "\nIf you would like ");
                        System.out.println("to go back to the menu type 6");
                        int razeCityNum = scan.nextInt();
                        scan.nextLine();
                        System.out.println("---");
                        if (razeCityNum == 6) {
                            preformAction();
                            continuing = false;
                        } else if (razeCityNum <= numOfCities) {
                            String destoyedCity = cities[razeCityNum - 1];
                            int nOC = numOfCities;
                            for (int i = razeCityNum; i <= (nOC - 1); i++) {
                                cities[i - 1] = cities[i];
                            }
                            cities[nOC] = "";
                            numOfCities--;
                            System.out.print(destoyedCity + " has been ");
                            System.out.println("razed to the ground");
                            System.out.println(reset);
                            continuing = false;
                        }
                    }
                }
                cont = false;
            }
        }
    }

    public static void buildArmy() {
        int build = 0;
        boolean continuing = true;
        System.out.print("You have " + troops + " units\nTo train more");
        System.out.println("units costs 5 gold and 3 resources");
        System.out.print("You currently have " + gold + " gold and ");
        System.out.println(resources + " resources");
        while (continuing) {
            System.out.println("Would you like to train more units?");
            System.out.println("Yes[1]\nNo [2]");
            build = scan.nextInt();
            System.out.println("---");
            scan.nextLine();
            if (build == 2) {
                preformAction();
                continuing = false;
            } else if (build == 1) {
                if (gold < 5) {
                    System.out.println("You do not have enough gold");
                    System.out.println(reset);
                } else if (resources < 3) {
                    System.out.println("You do not have enough resources");
                    System.out.println(reset);
                } else {
                    gold = gold - 5;
                    resources = resources - 3;
                    troops++;
                    System.out.print("Congradulations, you successfully");
                    System.out.print(" trained another unit\nYou have ");
                    System.out.println(troops + " thousand soldiers");
                    System.out.println(reset);
                }
                continuing = false;
            }
        }
    }

    public static void researchTech() {
        int research = 0;
        boolean continuing = true;
        System.out.print("You have " + tech + " technology past the st");
        System.out.print("one age\nTo develop more technology costs 50");
        System.out.print(" gold and 2 resources\nYou currently have ");
        System.out.println(gold + " gold and " + resources + " resources");
        while (continuing) {
            System.out.print("Would you like to advance your civilizatio");
            System.out.println("ns technology?\nYes[1]\nNo [2]");
            research = scan.nextInt();
            System.out.println("---");
            scan.nextLine();
            if (research == 2) {
                preformAction();
                continuing = false;
            } else if (research == 1) {
                if (gold < 50) {
                    System.out.println("You do not have enough gold");
                    System.out.println(reset);
                } else if (resources < 2) {
                    System.out.println("You do not have enough resources");
                    System.out.println(reset);
                } else {
                    gold = gold - 50;
                    resources = resources - 2;
                    tech++;
                    System.out.print("Congradulations, you successfully bu");
                    System.out.print("ilt up your civilizations technology");
                    System.out.println("You have " + tech + " technologies");
                    System.out.println(" past the stone age");
                    System.out.println(reset);
                }
                continuing = false;
            }
        }
    }

    public static void attackCity() {
        int attack = 0;
        boolean continuing = true;
        System.out.println("You have won " + attacks + " battles");
        System.out.print("To attack an enemy city costs 6 units and 3 happi");
        System.out.print("ness\nYou currently have " + troops + " military un");
        System.out.println("its and " + happiness + " thousand happy citizens");
        while (continuing) {
            System.out.print("Would you like to attack a neighboring enemy ci");
            System.out.println("ty?\nYes[1]\nNo [2]");
            attack = scan.nextInt();
            System.out.println("---");
            scan.nextLine();
            if (attack == 2) {
                preformAction();
                continuing = false;
            } else if (attack == 1) {
                if (troops < 6) {
                    System.out.println("You have lost the battle");
                    System.out.println(reset);
                    troops = 0;
                    happiness--;
                } else {
                    troops = troops - 6;
                    happiness = happiness - 3;
                    attacks++;
                    gold = gold + 10;
                    System.out.print("Congradulations, you successfully ");
                    System.out.print("attacked another city\nYou have won ");
                    System.out.println(attacks + " battles");
                    System.out.println(reset);
                }
                continuing = false;
            }
        }
    }
    public static void endTurn() {
        System.out.println("Would you like to leave the game?");
        System.out.println("Yes[1]\nNo [2]");
        boolean quit = (scan.nextInt() == 1);
        System.out.println("---");
        scan.nextLine();
        if (quit) {
            playing = false;
        }
    }
    public static void endGame() {
        String endStatus2 = "";
        String endStatus3 = "";
        String endStatus4 = "";
        int negHappiness = (-1) * happiness;
        System.out.print("It took  " + turn + " turns for the " + empire);
        System.out.println(" empire to win the game.\n You had:");
        if (happiness > 0) {
            endStatus2 = happiness + " thousand happy citizens\n";
        } else if (happiness < 0) {
            endStatus2 = negHappiness + " thousand angry citizens\n";
        } else if (happiness == 0) {
            endStatus2 = "Your people are indifferent to your rule\n";
        }
        if (attacks == 0) {
            endStatus3 = "no military victories\n";
        } else if (attacks > 0) {
            endStatus3 = "You won " + attacks + " battles\n";
        }
        if (tech == 0) {
            endStatus4 = "and no technology past the stone age\n";
        } else if (tech > 0) {
            endStatus4 = "and " + tech + " technologies past the stone age\n";
        }
        System.out.println(endStatus2 + endStatus3 + endStatus4);
        playing = false;
    }
}