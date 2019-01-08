package cs.bounce.Menu;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import cs.bounce.Screens.*;

public class GamMain extends Game {

	ScrLvl1 scrLvl1;

	int nScreen;
	boolean onMenu = false;

	public void updateScreen(int _nScreen) {
		nScreen = _nScreen;
		 if (nScreen == 2) {
			setScreen(scrLvl1);
		}

	}
	/*
        public boolean Menu() {
            if (Gdx.input.isKeyPressed(Input.Keys.M)) {
                System.out.println("MENU");
                updateScreen(0);
            }
            return false;
        }
    */
		@Override
		public void create () {
			scrLvl1 = new ScrLvl1(this);
			updateScreen(2);
		}

		@Override
		public void render () {
			super.render();
			//Menu();
		}

		@Override

		public void pause () {

		}

		@Override
		public void resume () {

		}

		@Override
		public void resize ( int width, int height){

		}

		@Override
		public void dispose () {
			super.dispose();
		}


}



