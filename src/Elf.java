
public class Elf extends Character{
	private String race;
	protected Elf (String name) {
		super(name, 80, 0);
		this.race="elf";	
	}
	public String getRace() {
		return race;
	};
	public String setRace(String race) {
		return this.race;
	}
	
	@Override
	public  void displayMessage() {
		System.out.println("Your character is an Elf");
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return 0;
	};
	
	// Has a plus damage

}
