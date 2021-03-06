package com.beyond;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;


public class MyGame extends Game  {
	    // constant useful for logging
	    public static final String LOG = MyGame.class.getSimpleName();
	 
	    // a libgdx helper class that logs the current FPS each second
	    private FPSLogger fpsLogger;
	    
    	@Override
		public void create () {
            Gdx.app.log( MyGame.LOG, "Creating game" );
            fpsLogger = new FPSLogger();
            
            Assets.load();
            setScreen (new com.beyond.screens.SplashScreen(this));
        }

        @Override 
        public void render () {    
        	super.render();
        	fpsLogger.log();
        }
        
        @Override
        public void resize (int width, int height) {
        	Gdx.app.log (MyGame.LOG, "Resize game to: " + width + "x" + height);
        }
        
        @Override
        public void pause () {
            Gdx.app.log( MyGame.LOG, "Pausing game" );
        }
        
        @Override
        public void resume () {
            Gdx.app.log( MyGame.LOG, "Resuming game" );
        }

        @Override
        public void dispose () {
            Gdx.app.log( MyGame.LOG, "Disposing game" );
        }
}