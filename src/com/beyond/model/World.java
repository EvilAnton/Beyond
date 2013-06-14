package com.beyond.model;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

@SuppressWarnings("unused")
public class World extends Stage{
	
	public World (int width, int height, boolean scretch) {
		super (width, height, scretch);
		System.out.println ("World created");
	}
	
	
}