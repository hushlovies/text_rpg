
public abstract class Character {

	String name;

	public int maxHp, hp, xp;
	
	public Character(String name, int maxHp,int xp){
		this.name=name;
		this.maxHp=maxHp;
		this.xp=xp;
		this.hp=maxHp;
	}
	
	public  String getName() {
		return this.name;
	}
	
	public  void displayMessage() {
		System.out.println("Non defined character");
	}
	public abstract int attack();
	public abstract int defend();
}
