package cs.bounce;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import cs.bounce.Screens.*;

public class GamMenu extends Game {

	ScrLvl1 scrLvl1;

	int nScreen;
	boolean onMenu = false;

	public void updateScreen(int _nScreen) {
		nScreen = _nScreen;
		if (nScreen == 0) {
			setScreen(scrLvl1);
		/*} else if (nScreen == 1) {
			setScreen(scrLevels);
		} else if (nScreen == 2) {
			setScreen(scrLvl1);
		} else if (nScreen == 3) {
			setScreen(scrLvl2);
		}else if (nScreen == 4) {
			setScreen(scrLvl3);
			*/
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
	public void create() {
		//scrStart = new ScrStart(this);
		//scrLevels = new ScrLevels(this);
		scrLvl1 = new ScrLvl1(this);
		//scrLvl2 = new ScrLvl2(this);
		//scrLvl3 =new ScrLvl3(this);
		updateScreen(0);
	}

	@Override
	public void render() {
		super.render();
		//Menu();
	}

	@Override

	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void dispose() {
		super.dispose();
	}

}



