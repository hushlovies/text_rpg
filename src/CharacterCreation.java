import java.util.HashMap;
import java.util.Map;

abstract class  CharacterCreation  {
		
		
		private String name;
		
		protected CharacterCreation (String name){
			this.name=name;	
		}
		/*System.out.print("Welcome to the world of Oz. what is your name?");
		Scanner name= new Scanner();
		System.out.print("What race are you?");
		Scanner race= new Scanner();
		System.out.print("What about your class?");
		Scanner class= new Scanner();
		*/
		//methods get and set the characteristic of character 
		public String getName() {
			return name;
		};
		public String setName(String name) {
			return this.name;
		};
		
		public void getStatus(){
			Map<String,Integer> status=new HashMap<>();
			status.put(getName(),1);//name and xp
			status.put("HP",5);//HP and xp
			status.put("MP",10);//MP and xp
		}
		

		
	}
