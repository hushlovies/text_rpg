
public class Monster extends Character {
	//constructor monster
	
	
	public Monster (String name, int maxHp,int xp) {
		super(name, maxHp, xp);
			
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
	                                                 
}
