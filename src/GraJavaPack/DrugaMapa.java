package GraJavaPack;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class DrugaMapa extends City {
	
	TiledMap map;
	String name;
	
	DrugaMapa()
	{
		name = "Snieg";
		 try {
			map = new TiledMap("res/Mapa/Mapa2.tmx");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
