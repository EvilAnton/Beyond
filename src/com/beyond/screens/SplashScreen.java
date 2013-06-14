package com.beyond.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.beyond.Assets;
import com.beyond.Constants;
import com.beyond.MyGame;

public class SplashScreen implements Screen, Constants{
	
	MyGame game;
	Stage stage;
	
	Texture backgroundIMG;
	
	public SplashScreen (MyGame game) {
		this.game = game;
		Gdx.app.log (MyGame.LOG, "SplashScreen created"); 
    	
    	backgroundIMG = new Texture (Gdx.files.internal ("images/splash_screen.png"));    	
	}

	@Override
	public void render(float delta) {
    	// Это чистит экран и заполняет синим цветом
    	Gdx.gl.glClearColor (0, 0, 0, 1);
    	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    	
    	stage.act(delta);
    	stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log (MyGame.LOG, "SplashScreen resized"); 		
	}

	@Override
	public void show() {
		Gdx.app.log (MyGame.LOG, "SplashScreen showed"); 		
		
		// Загружаем сцену для этого экрана
		stage = new Stage();
		
		// Выгружаем изображение из ассет класса
		Image splashImage = new Image(Assets.splashBackground);
		// Устанавливаем эффект перехода (действие, сколько секунд длится каждое действие)
		splashImage.addAction( Actions.sequence( Actions.fadeOut( 0.001f ), Actions.fadeIn( TIME_BETWEEN_SCREENS ),
				Actions.fadeOut(2f) , Actions.run(onSplashFinishedRunnable)) );
		
		// Выводим изображение на сцену
		stage.addActor(splashImage);   	
	}
	
	Runnable onSplashFinishedRunnable = new Runnable () {
		@Override
		public void run() {
			Gdx.app.log (MyGame.LOG, "Go to the menu screen"); 
			game.setScreen(new MenuScreen (game));
		}
	};

	@Override
	public void hide() {
		Gdx.app.log (MyGame.LOG, "SplashScreen hided"); 		
	}

	@Override
	public void pause() {
		Gdx.app.log (MyGame.LOG, "SplashScreen paused"); 		
	}

	@Override
	public void resume() {
		Gdx.app.log (MyGame.LOG, "SplashScreen resumed"); 		
	}

	@Override
	public void dispose() {
		Gdx.app.log (MyGame.LOG, "SplashScreen disposed"); 		
	}

}
