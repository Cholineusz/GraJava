package GraJavaPack;
import org.newdawn.slick.BasicGame;

import java.lang.System;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

public class GraMain extends BasicGame {
	
	//Zmienne obrazkow
	private TiledMap map;
	private Image postac;
	//Zmienne ruchu
	float x = 50.0f;
	float y = 50.0f;
	float speed = 0.2f;
	SpriteSheet zbior_obrazkow;
	
	public GraMain() {
		super("GraJava");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		// Tutaj odtwarzamy grafiki
		map.render(0, 0);
		g.drawImage(postac, x ,y);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {

		// TODO Auto-generated method stub
		arg0.setVSync(true);

		// Tutaj wklejamy grafiki

		map = new TiledMap("res/Mapa/Mapa.tmx");
		
		zbior_obrazkow = new SpriteSheet("res/Postac/main_edited.png", 32,32 );
		postac = zbior_obrazkow.getSprite(0, 0);
		//postac = new Image("res/Postac/mainc.png");
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// Logic i ai
		
		//ruch postaci
		Input klik = gc.getInput();
		if(klik.isKeyDown(Input.KEY_D))
		{
		x += speed * delta;	
		}
		if(klik.isKeyDown(Input.KEY_A))
		{
		x -= speed * delta;	
		}
		if(klik.isKeyDown(Input.KEY_W))
		{
		y -= speed * delta;	
		}
		if(klik.isKeyDown(Input.KEY_S))
		{
		y += speed * delta;	
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
