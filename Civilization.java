import java.util.Scanner;
public class Civilization {
  public static Scanner scan = new Scanner(System.in);
  public static String empire = null;
  public static String [] cities = {"","","","",""};
  public static double gold = 20.5;
  public static double resources = 30;
  public static int happiness = 10;
  public static int troops = 0;
  public static int tech = 0;
  public static int turn = 0;
  public static int attacks = 0;
  public static int numOfCities = 1;
  public static boolean playing = true;
    
    public static void main(String[] args) {
 
      setUpGame();
      while(playing) {
        startOfTurn();
        preformAction();
        if (attacks==10||tech==20) {endGame();}
        playing = false;
      }
    }

  public static void setUpGame(){
    boolean correct = false;
    System.out.println("Would you like to play as America [1], The Zulu [2], England [3], or China [4]\nPlease return a value between 1 and 4");
    while (!correct){
      int empireNum = scan.nextInt();
      if (empireNum == 1) {
        empire = "American";
        correct = true;}
      else if (empireNum == 2){
        empire = "Zulu";
        correct = true;}
      else if (empireNum == 3){
        empire = "English";
        correct = true;}
      else if (empireNum == 4){
        empire = "Chinese";
        correct = true;}
      else System.out.println ("Please enter a number 1 through 4");
    }
    scan.nextLine();
    System.out.println("\nWhat would you like to call your first city?");
    String firstCityName = scan.nextLine();
    cities[0] = firstCityName;
  }
  public static void startOfTurn(){
    turn++;
    resources++;
    if (happiness>20) resources = resources + (5*numOfCities);
    gold = gold+3;
    if (resources%2 ==0) happiness++;
    else happiness = happiness -3;
    System.out.println(status());
  }
  public static String status(){
    String currentStatus1 = null;
    String currentStatus2 = null;
    String currentStatus3 = null;
    String currentStatus4 = null;
    if (numOfCities>=2){ currentStatus1 = "\nIt is turn "+turn+" and you, the "+empire+ " empire, have: \n"+numOfCities+" cities\n"+gold+ " thousand gold\n"+resources+" tons of resources\n";}
    if (numOfCities==1){ currentStatus1 = "\nIt is turn "+turn+" and you, the "+empire+ " empire, have: \n"+numOfCities+" city\n"+gold+ " thousand gold\n"+resources+" tons of resources\n";}
    if (happiness>0){ currentStatus2 = happiness+" thousand happy citizens\n";}
    if (happiness<0){ currentStatus2 = happiness+" thousand angry citizens\n";}
    if (happiness==0){ currentStatus2 = "Your people are indifferent to your rule\n";}
    if (troops==0){currentStatus3 = "no army\n";}
    if (troops>0){currentStatus3 = troops+" thousand soldiers\n";}
    if (tech==0){currentStatus4 = "and no technology past the stone age\n";}
    if (tech>0){currentStatus4 = "and "+tech+" technologies past the stone age\n";}
    return currentStatus1+currentStatus2+currentStatus3+currentStatus4;
  }
  public static void preformAction(){
    boolean correct = false;
    System.out.println("On your turn you can:\nSettle a City [1]\nDemolish a City [2]\nBuild Your Army [3]\nResearch Technology [4]\nAtttack An Enemy City [5] \nor End Your Turn [6]\n");
    while (!correct){   
      System.out.println("Please enter a number 1-6");
      int choice = scan.nextInt();
      if (choice == 1){
        settleCity();
        correct = true;}
      if (choice == 2){
        demolishCity();
        correct = true;}
      if (choice ==3){
        buildArmy();
        correct = true;}
      if (choice ==4){
        researchTech();
        correct = true;}
      if (choice ==5){
        attackCity();
        correct = true;}
      if (choice ==6){
        endTurn();
        correct = true;}
    }
  }
  public static void settleCity(){
    int buy=0;
    boolean continuing = true;
    if (numOfCities==1){System.out.println("\nYou have 1 city:");}
    else {System.out.println("You have "+numOfCities+" cities:");}
    for (int i =0; i<=(numOfCities-1);i++) {
      System.out.println(cities[i]);
    }
    System.out.println("You can only have at most 5 cities\nTo settle a new city it costs 15.5 gold\nYou currently have "+gold+" gold");
    while (continuing){
      System.out.println("Would you like to buy a city?\nYes[1]\nNo [2]");
      buy = scan.nextInt();
      scan.nextLine();
      if (buy==2) {
        preformAction();
        continuing =false;
      }
      else if (buy==1){
        if (gold<15.5) {
          System.out.println("You do not have enough gold");
        }
        else if (numOfCities>=5) {
          System.out.println("You already have 5 cities");
        }
        else{
          gold = gold-15.5;
          numOfCities++;
          System.out.println("What would you like to name your new city?");
          String newCityName = scan.nextLine();
          cities[numOfCities-1] = newCityName;
          System.out.println("Your new city "+newCityName+" is being built");
        }
        continuing=false;
      }
    }
  }
  public static void demolishCity(){
    int destroy =0;
    boolean cont = true;
    boolean continuing = true;
    if (numOfCities==1){System.out.println("\nYou have 1 city:");}
    else {System.out.println("You have "+numOfCities+" cities:");}
    for (int i =0; i<=(numOfCities-1);i++) {
      System.out.println(cities[i]+" ["+i+"]");
    }
    System.out.println("You must have at least 1 city\nYou will gain 1.5 resources by destroying a city\nYou currently have "+resources+" resources");
    while (cont==true){
      System.out.println("Would you like to raze a city?\nYes[1]\nNo [2]");
      destroy = scan.nextInt();
      if (destroy==2) {
        preformAction();
        cont =false;
      }
      else if (destroy==1){
        if (numOfCities==1) {
          System.out.println("You only have 1 city and cannot destroy it");
        }
        else{
          while(continuing){
            System.out.println("Which city would you like to raze?\n Please enter a number 1 through "+numOfCities+"\nIf you would like to go back to the menu type 6");
            int razeCityNum = scan.nextInt();
            if (razeCityNum == 6){
              preformAction();
              continuing=false;
            }
            else if (razeCityNum<=numOfCities){
              String destoyedCity = cities[razeCityNum];
              for (int i =razeCityNum; i<=(numOfCities-1);i++) {
                cities[i-1] = cities[i];
              }
            cities[numOfCities] = "";
            numOfCities--;
            System.out.println(destoyedCity+" has been razed to the ground");
            continuing =false;
            }
          }
        }
        cont=false;
      }
    }
  }
  public static void buildArmy(){
    int build =0;
    boolean continuing = true;
    System.out.println("You have "+troops+" units\nTo train more units costs 5 gold and 3 resources\nYou currently have "+gold+" gold and "+resources+" resources");
    while (continuing ==true){
      System.out.println("Would you like to train more units?\nYes[1]\nNo [2]");
      build = scan.nextInt();
      scan.nextLine();
      if (build==2) {
        preformAction();
        continuing =false;
      }
      else if (build==1){
        if (gold<5) {
          System.out.println("You do not have enough gold");
        }
        else if (resources<3) {
          System.out.println("You do not have enough resources");
        }
        else{
          gold = gold-5;
          resources = resources-3;
          System.out.println("Congradulations, you successfully trained another unit\nYou have "+troops+" units");
        }
        continuing = false;
      }
    }
  }
  public static void researchTech(){

  }
  public static void attackCity(){

  }
  public static void endTurn(){

  }
  public static void endGame(){
    String endStatus2 = null;
    String endStatus3 = null;
    String endStatus4 = null;
    System.out.println("It took  "+turn+ " turns for the "+empire+" empire to win the game.\n You had:");
    if (happiness>0){ endStatus2 = happiness+" thousand happy citizens\n";}
    if (happiness<0){ endStatus2 = happiness+" thousand angry citizens\n";}
    if (happiness==0){endStatus2 = "Your people are indifferent to your rule\n";}
    if (troops==0){endStatus3 = "no army\n";}
    if (troops>0){endStatus3 = troops+" thousand soldiers\n";}
    if (tech==0){endStatus4 = "and no technology past the stone age\n";}
    if (tech>0){endStatus4 = "and "+tech+" technologies past the stone age\n";}
    System.out.println(endStatus2+endStatus3+endStatus4);
  }
} 