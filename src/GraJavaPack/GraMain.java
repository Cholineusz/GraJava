package GraJavaPack;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.BasicGame;

import java.lang.System;
import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

public class GraMain extends BasicGame {
	
	private City[] map_array;
	
	//Zmienne obrazkow
	private TiledMap currentmap;
	//private Image postac;
	//Zmienne ruchu
	float x = 50.0f;
	float y = 50.0f;
	float speed = 0.2f;
	int[] duration ={200,200};
	SpriteSheet zbior_obrazkow;
	private Animation walkUP,walkDOWN,walkRIGHT,walkLEFT, postac;
	
	/// Zmienne przechowujace szerokosc i wys mapy
	private int screenWidth;
	private int screenHeight;
	private int cameraX;
	private int cameraY;
	private int playerX=0;
	private int playerY=0;
	private String mousestring = "No mouse";
	
	
	public GraMain() {
		super("GraJava");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		// Tutaj odtwarzamy grafiki
		// Postac na srodku mapy, mapa zalezna od player x i y
		screenHeight = arg0.getHeight();
		screenWidth = arg0.getWidth();
		
		cameraX = (screenWidth/2);
		cameraY = (screenHeight/2);
		
	
		currentmap.render(playerX, playerY);
		postac.draw(cameraX, cameraY);
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {

		// TODO Auto-generated method stub
		arg0.setVSync(true);

		// Tutaj wklejamy grafiki
		map_array = new City[]{new PierwszaMapa(), new DrugaMapa()};

		currentmap = map_array[0];
		
		
		//ROZDZIELA na obrazki 32x32 pix
		zbior_obrazkow = new SpriteSheet("res/Postac/main_edited.png", 32,32 );
		
		//Laduje obrazki do poszczegolnych kontenerow typu image
		walkDOWN = new Animation(false);
		walkUP = new Animation(false);
		walkLEFT = new Animation(false);
		walkRIGHT = new Animation(false);
		for(int i=0;i<3;i++)
		{
			walkDOWN.addFrame(zbior_obrazkow.getSubImage(0+i, 0), 100);
			walkLEFT.addFrame(zbior_obrazkow.getSubImage(0+i, 1),100);
			walkRIGHT.addFrame(zbior_obrazkow.getSubImage(0+i,2), 100);
			walkUP.addFrame(zbior_obrazkow.getSubImage(0+i, 3),100);
		}
		
		
		
		
		postac = walkLEFT;
		//postac = new Image("res/Postac/mainc.png");
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// Logic i ai
		
	
	
		
		
		
		
		//ruch postaci
		Input klik = gc.getInput();
		
		if(klik.isKeyDown(Input.KEY_1))
		{
			currentmap= map_array[0];
		}
		
		if(klik.isKeyDown(Input.KEY_2))
		{
			currentmap= map_array[1];
		}
		
		
		if(klik.isKeyDown(Input.KEY_S) && klik.isKeyDown(Input.KEY_D))
		{
			postac = walkRIGHT;
			postac.update(delta);
		
			
		playerX -= speed * delta;
		playerY -= speed * delta;	
			
		}else if(klik.isKeyDown(Input.KEY_S) && klik.isKeyDown(Input.KEY_A))
		{
			postac = walkLEFT;
			
			postac.update(delta);
			playerX += speed * delta;
			
			playerY -= speed * delta;	
		}else if(klik.isKeyDown(Input.KEY_W)&& klik.isKeyDown(Input.KEY_A))
		{
postac = walkLEFT;
			
			postac.update(delta);
		playerX += speed * delta;
		playerY += speed * delta;	
			
		}else if(klik.isKeyDown(Input.KEY_W) && klik.isKeyDown(Input.KEY_D))
		{
			postac = walkRIGHT;
			postac.update(delta);
		
			
		playerX -= speed * delta;
		playerY += speed * delta;	
			
		}
		else if(klik.isKeyDown(Input.KEY_D))
		{
			postac = walkRIGHT;
			postac.update(delta);
		
			
		playerX -= speed * delta;	
		
					}
		else if(klik.isKeyDown(Input.KEY_A))
		{
			postac = walkLEFT;
			
			postac.update(delta);
		playerX += speed * delta;	
		
		}
		else if(klik.isKeyDown(Input.KEY_W))
		{
			postac = walkUP;
			
			postac.update(delta);
		playerY += speed * delta;	
		}
		else if(klik.isKeyDown(Input.KEY_S))
		{
			postac = walkDOWN;
			
			postac.update(delta);
		playerY -= speed * delta;	
		}
		else 
		{
			postac.setCurrentFrame(1); 	// gdy stoi zeby wracalo do obrazku stania.
		
		}
		
	}
				

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HEHE_COS_ZMIENILEM"); // komentarz
		try {
			
			AppGameContainer app = new AppGameContainer(new GraMain());
			app.setDisplayMode(400, 400, false);
			app.setVSync(true);
			app.start();
		
			
		} catch (SlickException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			

		}
	}

}



