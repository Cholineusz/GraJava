package Player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;



public class Player  {
	
	private static final int DOWN = 0;
	private static final int LEFT = 1;
	private static final int RIGHT =2;
	private static final int UP =3;
	
	private static SpriteSheet obrazki;
	
	static String Nick;

	 Animation[] Walk = new Animation[4];
	
	public Animation current = new Animation(false);
	
	
	
	public Player() throws SlickException
	{
		
		obrazki = new SpriteSheet("res/Postac/main_edited.png", 32,32 );
		
		load_sprites();
		
		current = Walk[DOWN];
		
		
	}
	
	public  void load_sprites()
	{
		Walk[DOWN] = new Animation(false);	// DOWN
		Walk[LEFT] = new Animation(false);	// LEFT
		Walk[RIGHT] = new Animation(false);	// RIGHT
		Walk[UP] = new Animation(false);	// UP
		for(int i=0;i<3;i++)
		{
			Walk[DOWN].addFrame(obrazki.getSubImage(0+i, 0), 100);
			Walk[LEFT].addFrame(obrazki.getSubImage(0+i, 1),100);
			Walk[RIGHT].addFrame(obrazki.getSubImage(0+i,2), 100);
			Walk[UP].addFrame(obrazki.getSubImage(0+i, 3),100);
		}
	}
	
	
	public void WALK_DOWN(int delta)
	{
		current=Walk[DOWN];
		current.update(delta);
		
	}
	
	public void WALK_UP(int delta)
	{
		current=Walk[UP];
		current.update(delta);
	}
	
	public void WALK_LEFT(int delta)
	{
		current=Walk[LEFT];
		current.update(delta);
	}
	
	public void WALK_RIGHT(int delta)
	{
		current=Walk[RIGHT];
		current.update(delta);
	}
	
	public void STAY()
	{
		current.setCurrentFrame(1);
	}
	
	
	public void RENDER(float x, float y)
	{
		current.draw(x, y);
	}
	

}
