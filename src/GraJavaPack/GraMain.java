package GraJavaPack;
import org.newdawn.slick.BasicGame;

import java.lang.System;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class GraMain extends BasicGame {
	
	private TiledMap map;

	public GraMain() {
		super("GraJava");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		map.render(0, 0);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		map = new TiledMap("res/Mapa/Mapa.tmx");
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HEHE_COS_ZMIENILEM"); // komentarz
		try {
			AppGameContainer app = new AppGameContainer(new GraMain());
			app.setDisplayMode(320, 320, false);
			app.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
