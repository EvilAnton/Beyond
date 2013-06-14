package com.beyond.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.beyond.Constants;
import com.beyond.MyGame;

public class MenuSettingScreen implements Screen, Constants {
	MyGame game; 
	
	// Rendering options
	OrthographicCamera camera;
	SpriteBatch batch;
	
	Texture backgroundIMG;
	Texture girlIMG;
	Texture aboutIMG;
	Texture menuIMG;
	Texture soundIMG;
	Texture soundRectIMG;
	
	public MenuSettingScreen (MyGame game) {
		this.game = game;
		Gdx.app.log (MyGame.LOG, "SplashScreen created"); 
		
    	camera = new OrthographicCamera();
    	batch = new SpriteBatch();
    	
    	backgroundIMG = new Texture (Gdx.files.internal ("images/background.png"));   
    	girlIMG = new Texture (Gdx.files.internal ("images/girl.png"));   
    	aboutIMG = new Texture (Gdx.files.internal ("images/about_button.png"));  
    	menuIMG = new Texture (Gdx.files.internal ("images/menu_button.png"));  
    	soundIMG = new Texture (Gdx.files.internal ("images/sound_button.png"));  
    	soundRectIMG = new Texture (Gdx.files.internal ("images/sound_rect.png"));  
	}

	@Override
	public void render(float delta) {
    	// Это чистит экран и заполняет синим цветом
    	Gdx.gl.glClearColor (0, 0, 0.2f, 1);
    	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    	
    	camera.update();
    	
    	batch.setProjectionMatrix(camera.combined);
    	
    	batch.begin();
    	batch.draw (backgroundIMG,  0, 0);
    	batch.draw (girlIMG,  0, 0);
    	batch.draw (aboutIMG,  0, 0);
    	batch.draw (menuIMG,  0, 0);
    	batch.draw (soundIMG,  0, 0);
    	batch.draw (soundRectIMG, 0, 0);
    	batch.end();  		
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log (MyGame.LOG, "MenuSetting screen resized"); 			
	}

	@Override
	public void show() {
		Gdx.app.log (MyGame.LOG, "MenySetting screen showed"); 		
    	camera.setToOrtho (false, WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	@Override
	public void hide() {
		Gdx.app.log (MyGame.LOG, "MenuSetting screen hided"); 		
	}

	@Override
	public void pause() {
		Gdx.app.log (MyGame.LOG, "MenuSetting screen paused"); 		
	}

	@Override
	public void resume() {
		Gdx.app.log (MyGame.LOG, "MenuSetting screen resumed"); 		
	}

	@Override
	public void dispose() {
		Gdx.app.log (MyGame.LOG, "MenuSetting screen disposed"); 		
	}


}
