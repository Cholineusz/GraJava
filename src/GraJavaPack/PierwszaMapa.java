package GraJavaPack;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class PierwszaMapa extends City {
	
	TiledMap map;
	String name;
	
	PierwszaMapa()
	{
		name = "Plaza";
		 try {
			map = new TiledMap("res/Mapa/Mapa.tmx");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
