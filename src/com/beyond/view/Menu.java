package com.beyond.view;

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
import com.beyond.Constants;
import com.beyond.MyGame;

public class Menu implements Constants, Screen{
	MyGame game;
	
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

    public Menu (MyGame game) {
        // —сылка на главный класс
    	this.game = game;
    	
    	Gdx.app.log (MyGame.LOG, "Main menu created");  
    	
    	camera = new OrthographicCamera();
    	batch = new SpriteBatch();
    	
    	backgroundIMG = new Texture (Gdx.files.internal ("images/background.png"));
    	girlIMG = new Texture (Gdx.files.internal ("images/girl.png"));   	
    	playIMG = new Texture (Gdx.files.internal ("images/play_button.png"));
    	exitIMG = new Texture (Gdx.files.internal ("images/exit_button.png"));
    	optionsIMG = new Texture (Gdx.files.internal ("images/options_button.png"));
    	
    	optionBtn = new Actor ();
    	optionBtn.setBounds(150, 240, 200, 75);
    	optionBtn.setColor(Color.GREEN);
    	optionBtn.setVisible(true);
    	
    	Gdx.app.log (MyGame.LOG, "Images loaded");

    	rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/rain.mp3"));
    	rainMusic.setLooping (true);
    	rainMusic.setVolume (0.3f);
    	Gdx.app.log (MyGame.LOG, "Sounds loaded");
    }
    
	@Override
	public void render(float delta) {
    	// Ёто чистит экран и заполн€ет синим цветом
    	Gdx.gl.glClearColor (0, 0, 0.2f, 1);
    	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    	
    	camera.update();
    	
    	batch.setProjectionMatrix(camera.combined);
    	
    	batch.begin();
    	//batch.draw (backgroundIMG,  0, 0);
    	//batch.draw (playIMG, 0, 0);
    	//batch.draw (exitIMG, 0, 0);
    	//batch.draw (optionsIMG, 0, 0);
    	//batch.draw (girlIMG, 0, 0);   
    	optionBtn.draw(batch, 1);
    	batch.end();    	
    	
    	if (Gdx.input.justTouched()) {
    		Gdx.app.log(MyGame.LOG, "Screen was touched at " + Gdx.input.getX() + "/" + Gdx.input.getY());
    	}
	}

	@Override
	public void resize(int width, int height) {
        Gdx.app.log( MyGame.LOG, "Resize menu screen" );		
	}

	@Override
	public void show() {
		Gdx.app.log( MyGame.LOG, "Show menu screen" );

    	camera.setToOrtho (false, 800, 480);


    	//rainMusic.play();
    	Gdx.app.log (MyGame.LOG, "Menu created");
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
