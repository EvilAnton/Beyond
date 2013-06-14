package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.beyond.Constants;
import com.beyond.MyGame;

public class SplashScreen implements Screen, Constants{
	private static final int TIME_BETWEEN_SCREENS = 5;
	
	MyGame game;
	
	// Rendering options
	OrthographicCamera camera;
	SpriteBatch batch;
	
	Texture backgroundIMG;
	
	public SplashScreen (MyGame game) {
		this.game = game;
		Gdx.app.log (MyGame.LOG, "SplashScreen created"); 
		
    	camera = new OrthographicCamera();
    	batch = new SpriteBatch();
    	
    	backgroundIMG = new Texture (Gdx.files.internal ("images/splash_screen.png"));    	
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
    	batch.end();    	
    	
    	if (Gdx.input.justTouched()) {
    		game.setScreen(game.getMainMenuScreen());
    	}
		
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log (MyGame.LOG, "SplashScreen resized"); 		
	}

	@Override
	public void show() {
		Gdx.app.log (MyGame.LOG, "SplashScreen showed"); 		
    	camera.setToOrtho (false, 800, 480);
    	
		// Переключиться на главное меню через 5 секунд
    	Timer.schedule (new Task () {
			@Override
			public void run() {
				game.setScreen(game.getMainMenuScreen());
				dispose();
			}    		
    	}, TIME_BETWEEN_SCREENS);
    	
	}

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
