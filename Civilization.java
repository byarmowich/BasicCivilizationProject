import java.util.Scanner;
public class Civilization {
    static boolean playing = true;
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
      String empire = null;
      String [] cities = {"a"};
    	double gold = 20.5;
   	 	double resources = 30;
   	 	int happiness = 10;
    	int troops = 0;
    	int tech = 0;
      int turn = 0;
      boolean correct = false;
      System.out.println("Would you like to play as America [1], The Zulu [2], England [3], or China [4]");
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
      System.out.println("What would you like to call your first city?");
      String firstCityName = scan.nextLine();
      cities[0] = firstCityName;


        while(playing) {
        	System.out.println(status(turn, cities, empire, gold, resources, happiness, troops, tech));
            playing = false;
        }
    }

    public static String status(int turn, String[] cities, String empire, double gold, double resources, int happiness, int troops, int tech){
   		String currentStatus1 = null;
   		String currentStatus2 = null;
   		String currentStatus3 = null;
   		String currentStatus4 = null;
      if (cities.length>=2)currentStatus1 = "\n\nIt is turn "+turn+" and you, the "+empire+ " empire, have: \n"+cities.length+" cities\n"+gold+ " thousand gold\n"+resources+" tons of resources\n";
      if (cities.length==1) currentStatus1 = "\n\nIt is turn "+turn+" and you, the "+empire+ " empire, have: \n"+cities.length+" city\n"+gold+ " thousand gold\n"+resources+" tons of resources\n";
   		if (happiness>0)currentStatus2 = happiness+" thousand happy citizens\n";
   		if (happiness<0)currentStatus2 = happiness+" thousand angry citizens\n";
   		if (happiness==0)currentStatus2 = "Your people are indifferent to your rule\n";
   		if (troops==0) currentStatus3 = "no army\n";
   		if (troops>0) currentStatus3 = troops+" thousand soldiers\n";
   		if (tech==0) currentStatus4 = "and no technology past the stone age\n";
		  if (tech>0) currentStatus4 = "and "+tech+" technologies past the stone age\n";
    	return currentStatus1+currentStatus2+currentStatus3+currentStatus4;
		
    }
}