package cs.bounce.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import cs.bounce.Menu.GamMain;
import cs.bounce.Objects.SprBackground;
import cs.bounce.Objects.SprFloor;
import cs.bounce.Objects.SprHero;


public class ScrLvl1 implements Screen, InputProcessor {
    GamMain main;
    SpriteBatch batch;
    Texture txJumper;
    Texture txBackground;

    SprHero sphHero;
    SprBackground bgBackground;
    OrthographicCamera oc = new OrthographicCamera();

    Boolean isAPressed;
    Boolean isDPressed;

    public ScrLvl1(GamMain _main) {
        main = _main;
        batch = new SpriteBatch();
        oc.setToOrtho(false, 700, 700);
        txJumper = new Texture("hero_yeetgirl.png");
        txBackground = new Texture("bg_city.png");
        sphHero = new SprHero(txJumper, 250, 250);
        bgBackground = new SprBackground(txBackground);
        isAPressed = false;
        isDPressed = false;

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        oc.update();
        batch.begin();
        // batch.setProjectionMatrix(oc.combined);
        bgBackground.draw(batch);
        sphHero.draw(batch);
        batch.end();


        //System.out.println(jumper.getV2Pos());
        sphHero.update();

        if (!isAPressed && !isDPressed)
            sphHero.setV2Vel(0,sphHero.getV2Vel().y);

    }

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
    sphHero.getTexture().dispose();
    bgBackground.getTexture().dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case 29:
                sphHero.setV2Vel(-5, sphHero.getV2Vel().y);
                System.out.println("a");
                isAPressed = true;
                break;
            case 32:
                sphHero.setV2Vel(5, sphHero.getV2Vel().y);
                System.out.println("d");
                isDPressed = true;
                break;

        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case 29:
                isAPressed = false;
                break;
            case 32:
                isDPressed = false;
                break;
        }
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
