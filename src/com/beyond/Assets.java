package com.beyond;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * In this class main information about view and pictures is contained.
 * @author Anton Shekhov
 *
 */
public class Assets {
	public static Texture menuBackground;
	public static Texture splashBackground;
	public static Texture girlInMenu;
	
	public static TextureRegion menuButtons;
	
	public static void load () {
		TextureAtlas menuAtlas = new TextureAtlas (Gdx.files.internal("data/menu.txt"));
		menuBackground = new Texture (Gdx.files.internal("images/background.png"));
		splashBackground = new Texture (Gdx.files.internal("images/splash_screen.png"));
		girlInMenu = new Texture (Gdx.files.internal("images/girl.png"));
		
		menuButtons = menuAtlas.findRegion("options_title");
	}
}
