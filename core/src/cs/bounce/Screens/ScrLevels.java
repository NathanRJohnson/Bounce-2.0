package cs.bounce.Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import cs.bounce.Objects.SprButton;
import cs.bounce.Menu.GamMain;

public class ScrLevels implements Screen, InputProcessor {
    SpriteBatch batch;
    GamMain main;
    SprButton btnLvl1,  btnLvl2, btnBack;
    OrthographicCamera oc;
    Vector2 vMouse;
    Texture txbgLevels;
    Sprite sprbgLevels;

    public ScrLevels(GamMain main) {
        this.main = main;
    }

    public void show() {
        //OC Camera
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        Gdx.input.setInputProcessor(this);

        //Texture
        txbgLevels = new Texture("bg_level_select.jpg");
        //Sprites
        sprbgLevels = new Sprite(txbgLevels, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        batch = new SpriteBatch();

        //SprBackground

        //Buttons
        btnBack = new SprButton(0,0,100, 100,"back.png");
        btnLvl1 = new SprButton(50,150,100, 100,"lvl1_select.png");
        btnLvl2 = new SprButton(200,150,100, 100,"lvl2_select.png");
        //Mouse
        vMouse = new Vector2(0,0);
        System.out.println("Level 1 is just Gravity");
        System.out.println("Level 2 has hit testing");
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        changeScreen();
        sprbgLevels.draw(batch);
        btnLvl1.draw(batch);
        btnLvl2.draw(batch);
        btnBack.draw(batch);
        batch.end();
    }

    private void changeScreen() {
        if (Gdx.input.justTouched()) {
            if (btnLvl1.isMousedOver()) {
                System.out.println("Level 1");
                main.updateScreen(2);
            }
            if (btnLvl2.isMousedOver()) {
                System.out.println("Level 2");
                main.updateScreen(3);
            }
            if (btnBack.isMousedOver()) {
                System.out.println("Start Screen");
                main.updateScreen(0);
            }

        }
    }

    //Stuff below here pretty much can be ignored, at least for now // once you get textures, make sure to dispose of them
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
