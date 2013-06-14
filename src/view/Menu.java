package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.beyond.Constants;
import com.beyond.MyGame;

public class Menu implements Constants, Screen{
	MyGame game;
	
	// Rendering options
	OrthographicCamera camera;
	SpriteBatch batch;
    
	// ������� �������� � �����
	Texture backgroundIMG;
	Texture girlIMG;
	Texture playIMG;
	Texture exitIMG;
	Texture optionsIMG;

    Sound dropSound;
    Music rainMusic;

    public Menu (MyGame game) {
        // ������ �� ������� �����
    	this.game = game;
    	
    	Gdx.app.log (MyGame.LOG, "Main menu created");  
    	
    	camera = new OrthographicCamera();
    	batch = new SpriteBatch();
    	
    	backgroundIMG = new Texture (Gdx.files.internal ("images/background.png"));
    	girlIMG = new Texture (Gdx.files.internal ("images/girl.png"));   	
    	playIMG = new Texture (Gdx.files.internal ("images/play.png"));
    	exitIMG = new Texture (Gdx.files.internal ("images/exit.png"));
    	optionsIMG = new Texture (Gdx.files.internal ("images/options.png"));
    	
    	Gdx.app.log (MyGame.LOG, "Images loaded");

    	rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/rain.mp3"));
    	rainMusic.setLooping (true);
    	rainMusic.setVolume (0.3f);
    	Gdx.app.log (MyGame.LOG, "Sounds loaded");
    }
    
	@Override
	public void render(float delta) {
    	// ��� ������ ����� � ��������� ����� ������
    	Gdx.gl.glClearColor (0, 0, 0.2f, 1);
    	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    	
    	camera.update();
    	
    	batch.setProjectionMatrix(camera.combined);
    	
    	batch.begin();
    	batch.draw (backgroundIMG,  0, 0);
    	batch.draw (playIMG, 0, 0);
    	batch.draw (exitIMG, 0, 0);
    	batch.draw (optionsIMG, 0, 0);
    	batch.draw (girlIMG, 0, 0);    	
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


    	rainMusic.play();
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
