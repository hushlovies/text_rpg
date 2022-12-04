
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		boolean finishLine=false;
		Map m= new Map(4,0);
		GameScenario g= new GameScenario();
		Character player;
		Scanner scanner=new Scanner(System.in);
		String name=scanner.next();
		player = new Human(name);
		player.displayMessage();
		String num= g.newPlayer();
		System.out.println(num);
		
		g.playerRace();
			while(!finishLine){
				
				
				g.clearConsole();	
				System.out.println("The X is your current position");
				m.afficheMap();
				g.narrator("where do you want to move?");
				System.out.println("current location ("+m.getX()+","+m.getY()+")\n");
				System.out.println("INSTRUCTIONS: \n(z) for top \n(s) for bottom \n(q) for left \n(d) for right \n" );
				System.out.print("player choice: " );
				char mov=scanner.next().charAt(0);	
				  m.move(mov);
				  
				//condition for finishLine
				
				if(m.getX()==0 && m.getY()==4) {
					finishLine=true;
				}else {
					finishLine=false;
				}
				m.afficheMap();
				
			}
				g.narrator("Congatulations of finishing  the game");
		}

	
		
		
	}

		
		//loop for character information to be implemented on gamescenario


	
		
		// Loop for map
		
		
		
		
		/*//introduction of the game
		System.out.println("Welcome to my Text rpg game where the goal is to get out of the dangerous dungeon filled with monsters. \n "
				+ "Shall we start the game? 1 = yes / 2 = no");
		*/
		
			

	

