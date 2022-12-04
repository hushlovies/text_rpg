//Class that show a 2D map
//'S' for start and 'E' for end

import java.util.Scanner;
public class Map {
	private int x;
	private int y;
	boolean finishLine;
	boolean validInput;
	
	public Map (int x, int y){
		this.x=x;
		this.y=y;
	}
	
	Scanner scanner=new Scanner(System.in);
	char[][] map= {
				
			{'0','0','0','0','E'},
			{'0','0','0','0','0'},
			{'0','0','0','0','0'},
			{'0','0','0','0','0'},
			{'S','0','0','0','0'},
	};
	
	public void afficheMap() {
		for(int i=0;i<map.length;i++) {
			System.out.println();
			for(int j=0;j<map[i].length;j++) {
				System.out.print(map[i][j]+ "  ");
			}
		}	
	};
	
	public int getX() {
			return this.x;
		}
	public int getY() {
		return this.y;
	}
	//showMap
	public void showMap(Map m) {
		
		System.out.println("The X is your starting line");
		m.afficheMap();
		
		while(!finishLine) {
			
			System.out.println("where do you want to move?");
			
			char mov=scanner.next().charAt(0);			
			m.move(mov);
					
			//condition for finishLine
			
			if(x==0 && y==4) {
				finishLine=true;
			}else {
				finishLine=false;
			}
			
			System.out.println("\n current location (" + x +"," + y +")");
			m.afficheMap();
			
			
		}
			System.out.println("\nfinished the game");
	}
	
	
	//posInit=map[4][0];
	//move up=z,down=s,left=q,right=d
	
	public void move(char mov ) {
	
		
		
		try {
			
			
			if(mov =='q') { //left
				y--;
				map[x][y] = 'X';
			}
			if(mov =='z'){  //up
				x--;
				map[x][y] = 'X';
			}
			if(mov =='d'){  //right
				y++;
				map[x][y] = 'X';
			}
			if(mov =='s'){  //down
				x++;
				map[x][y] = 'X';
			}
			
		}
		
		catch(Exception e){
			
			System.out.println("Invalid choice");
		};
		
		//try catch if the direction was over the grid
		
		
			
			
		};
		
		
			
		
		
	};
	

	
	
	

