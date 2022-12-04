
public class Human extends Character{
	
	private String race;


	private String equip;
	protected Human(String name) {
		super(name, 105, 0);
		this.race="human";	
		
	}
	@Override
	public String getName() {
		return this.name;
	}
	public String getRace() {
		return this.race;
	};
	public String setRace(String race) {
		return this.race=race;
	}
	@Override
	public  void displayMessage() {
		System.out.println("Your character is a normal human being");
	}
	
	public String setEquipment(String equip) {
		return this.equip=equip;
	}
	
	
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return (int)Math.random()*6;
	}
	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return (int)Math.random()*6;
	};
	
	//has a plus damage

}
