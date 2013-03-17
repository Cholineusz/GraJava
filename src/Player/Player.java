package Player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;



public  abstract class Player extends Animation {
	
	private static final int DOWN = 0;
	private static final int LEFT = 1;
	private static final int RIGHT =2;
	private static final int UP =3;
	
	
	static String Nick;

	static Animation[] Walk = new Animation[3];
	
	
	
	
	Player(int look)
	{
		super(false);
		
		try {
			load_sprites(new SpriteSheet("res/Postac/main_edited.png", 32,32 ), 1);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void load_sprites(SpriteSheet obrazki, int delta)
	{
		Walk[DOWN] = new Animation(false);	// DOWN
		Walk[LEFT] = new Animation(false);	// LEFT
		Walk[RIGHT] = new Animation(false);	// RIGHT
		Walk[UP] = new Animation(false);	// UP
		for(int i=0;i<3;i++)
		{
			Walk[DOWN].addFrame(obrazki.getSubImage(delta+i, 0), 100);
			Walk[LEFT].addFrame(obrazki.getSubImage(delta+i, 1),100);
			Walk[RIGHT].addFrame(obrazki.getSubImage(delta+i,2), 100);
			Walk[UP].addFrame(obrazki.getSubImage(delta+i, 3),100);
		}
	}
	
	public static Animation WALK_UP()
	{
		return Walk[UP];
		
		
	}
	
	
	

}
