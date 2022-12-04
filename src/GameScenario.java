import java.util.Scanner;

public class GameScenario {
	//introduction of the game
	static Scanner scanner= new Scanner(System.in);
	
	//boolean used for loop to verify if game is running
	public static boolean isRunning;
	public static boolean validInput;
	boolean finishLine;
	//prolly add 3 encounters and make it random or cheat your way out
	public String[] encounters= {"Battle","Battle","Rest","Rest","Rock","Rock"}; 
	
	public String[] monsters={"Harpie","Golem","Slime","Ghost","Ogre","Bokoblins(TM)"};
	
	
	//issue with the player; code cannpt recognize the player
	Character player;
	String num= newPlayer();
	Map m= new Map(4,0);
	private String name;
	
	//player dead
	public void dead() {
		clearConsole();
		
		System.out.println("You haven't managed to flee to the dungeon and became a ghost instead \n");
		System.out.println("You continue to wander around the dungeon full of rocks and slowly forgot the purpose of your own existence");
		finishLine=true;
	}
	//random range
	public int range() {
		int min=50;
		int max=100;
		int rnd=(int)Math.random()*(max-min)+min;
		return rnd;
	}
	
	
	//I love this part
	public void randomEvent() {
		
			int event=(int)(Math.random()*encounters.length);
			if(encounters[event].equals("Rest"))
			{
				System.out.println("Go to rest:(Restores HP to max)");
				player.hp = player.maxHp;
			}
			if(encounters[event].equals("Battle"))
			{
				//randomBattle
				rndBattle();
			}
			if(encounters[event].equals("Rock"))
			{
				System.out.println("You encountered a sharp rock! ouchies!! (-5 Hp)");
				player.hp = player.hp-5;
			}
	}
	
	//method for random battles
	public void rndBattle() {
		narrator("You have encountered an enemy!! ");
		battle(new Monster(monsters[(int)(Math.random()*monsters.length)], range(), range()));
	}
	
	public void battle(Monster monster) {
		while(true) {
			clearConsole();
			narrator(monster.name+"\n HP:"+monster.hp+monster.maxHp);
			System.out.println("What do you want to do? ");
			System.out.println("(1) fight \n (2) Run Away");
			int inputUser= scanner.nextInt();
			if(inputUser==1) {
				
				int dmgPlayer= player.attack()-monster.defend();
				int dmgMonster=monster.attack()-player.defend();
				System.out.println("You dealt"+ dmgMonster + "damage!");
				//anything to continue
				if(player.maxHp<=0) {
					dead();
					break;
				}
				else if(monster.maxHp<=0) {
					clearConsole();
					System.out.println("Congrats monsta ded!");
					
					break;
				}
			}
			else if(inputUser==2) {
				System.out.println("You managed to escape (So long sucka!!)");
				break;
			}
			else {
				System.out.println("Invalid choice try again");
			}
			
			
		}
	}
	
	//input the user from the console
	public  int readInt(String readLine,int choiceUser) {
		
		//input user values: (1) for yes and (2) for no	
		int input = 0;
		
		while(input>1 || input>choiceUser) {
			System.out.println(readLine);
			try {
				input=Integer.parseInt(scanner.next());
			}
			catch(Exception E) {
				input=-1;
				System.out.println("please enter an integer");
			}
		}
		return input;
	};
	
	//method to get the player name
	public String newPlayer() {
		String playerName="";
		while(!validInput ) {
			clearConsole();
			narrator("What is your name?");
			String nameSaisie=scanner.next();
			System.out.println("Are you sure your name is "+nameSaisie+"?");
			System.out.println("(1)=Yes \n(2)=No");
			int input = scanner.nextInt();
			
			if(input ==1){
				validInput=true;
				playerName=nameSaisie;
			}
			enterUser();
		}
		return  playerName;
	
	}
	//creation instanced based on the chosen race
	public void playerRace() {
		boolean valid=false;
		while(!valid ) {
			clearConsole();
			narrator("What is your race? Choose between human or elf");
			String r=scanner.next();
			System.out.println("Are you sure your race is "+ r+"?");
			System.out.println("(1)=Yes \n (2)=No");
			int input= scanner.nextInt();
			if(input ==1 && r=="human") {
				valid=true;
				 player = new Human(num);
			}
			else if(input ==1 && r=="elf"){
				
				 player = new Elf(num);
			};
				
				player.displayMessage();
			
		}
	}
				
			
		
	
		//method for main game
		public  void mainGame() {
			clearConsole();
			newPlayer();
			playerRace();
			showMenu();		
		}
	public int showMenu() {
		clearConsole();
		while(!validInput) {
			String headMenu= "Player's Menu";
			narrator(headMenu);
			System.out.println("What do you want to do?");
			divider();
			System.out.println("(1) Character information");
			System.out.println("(2) go to shop");
			System.out.println("(3) move");	
			divider();
			int choicePlayer=scanner.nextInt();
			if(choicePlayer==1 || choicePlayer==2|| choicePlayer==3){
				validInput=false;
				return choicePlayer;
			}
			if(choicePlayer==1){
				validInput=true;
				return choicePlayer;
				charaInfo();
			}
			else if(choicePlayer==2){
				validInput=true;
				return choicePlayer;
				//showShop();
			}
			else if(choicePlayer==3){
				validInput=true;
				return choicePlayer;
				m.showMap(m);
			}
			else {
				System.out.println("Invalid input");
				validInput=false;
			}
			
		}return 1;
		
		
		
	}
	// MAIN GAME
	
	
	
	
	public void charaInfo() {
		clearConsole();
		while(!validInput) {
			narrator("PLAYER INFO");
			System.out.println("name= "+player.name +"\n HP : "+player.hp+"/"+player.maxHp);
			System.out.println("press (1) to exit");
			int input=scanner.nextInt();
			if(input==1) {
				validInput=true;
			}
		}
		
	}
	
	
	
	public  void narrator(String description) {
			System.out.println("\n+++++++++++++++++++++++++++++++");
			System.out.println(description);
			System.out.println("+++++++++++++++++++++++++++++++");
	
		}
	//your choice if you want to put here the method of the game's story
	
	//method to 'clear' out the console
	public  void clearConsole() {
		for(int i=0;i<100;i++) {
			System.out.println();
		}
	}
	public  void divider() {
		
			System.out.println("");
			System.out.println("-----------------------");
			System.out.println("" );
		
	}
	
	
	//method to wait till the user types anything
	public  void enterUser(){
		System.out.println("\n Please type anything to continue....");
		scanner.next();
	}
	
	// MAIN WITH MAP?
	
		//print the map 
		//print the menu 
		//print the scenario
		//isRunning became false once we have reached the destination
}
