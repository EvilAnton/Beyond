package com.beyond.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.beyond.Assets;
import com.beyond.Constants;
import com.beyond.MyGame;

public class MenuScreen implements Screen, Constants{
	MyGame game;
	Stage stage;
	
	// Rendering options
	OrthographicCamera camera;
	SpriteBatch batch;
    
	// —оздаем текстуры и звуки
	Texture backgroundIMG;
	Texture girlIMG;
	Texture playIMG;
	Texture exitIMG;
	Texture optionsIMG;
	
	Actor optionBtn;

    Sound dropSound;
    Music rainMusic;

    public MenuScreen (MyGame game) {
        // —сылка на главный класс
    	this.game = game;
    	
    	Gdx.app.log (MyGame.LOG, "Main menu created");  

    	
    	backgroundIMG = new Texture (Gdx.files.internal ("images/background.png"));
    	girlIMG = new Texture (Gdx.files.internal ("images/girl.png"));   	
    	playIMG = new Texture (Gdx.files.internal ("images/play_button.png"));
    	exitIMG = new Texture (Gdx.files.internal ("images/exit_button.png"));
    	optionsIMG = new Texture (Gdx.files.internal ("images/options_button.png"));
    	
    	Gdx.app.log (MyGame.LOG, "Images loaded");

    	rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/rain.mp3"));
    	rainMusic.setLooping (true);
    	rainMusic.setVolume (0.3f);
    	Gdx.app.log (MyGame.LOG, "Sounds loaded");
    }
    
	@Override
	public void render(float delta) {
    	// Ёто чистит экран и заполн€ет синим цветом
    	Gdx.gl.glClearColor (0, 0, 0, 1);
    	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);    	  	
    	
    	stage.act(delta);
    	stage.draw();
	}

	@Override
	public void resize(int width, int height) {
        Gdx.app.log( MyGame.LOG, "Resize menu screen" );		
	}

	@Override
	public void show() {
		Gdx.app.log( MyGame.LOG, "Show menu screen" );
		stage = new Stage ();
		
		// ”станавливаем фон
		Image background = new Image (Assets.menuBackground);
		Image girlBack = new Image (Assets.girlInMenu);
		Image options_title = new Image (Assets.menuButtons);
		// Ёффект дл€ по€влени€ фона
		stage.addAction(Actions.sequence(Actions.fadeOut (0.001f), Actions.fadeIn( 0.5f )));
		
		stage.addActor(background);
		stage.addActor(girlBack);
		stage.addActor(options_title);
	}
	
	

	@Override
	public void hide() {
		Gdx.app.log( MyGame.LOG, "Hide menu screen" );
		
	}

	@Override
	public void pause() {
		Gdx.app.log( MyGame.LOG, "Pause menu screen" );
		
	}

	@Override
	public void resume() {
		Gdx.app.log( MyGame.LOG, "Resume menu screen" );
		
	}

	@Override
	public void dispose() {
		Gdx.app.log( MyGame.LOG, "Dispose menu screen" );
		
	}
}
