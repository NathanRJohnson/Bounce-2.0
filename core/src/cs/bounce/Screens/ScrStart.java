package cs.bounce.Screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import cs.bounce.Objects.SprBackground;
import cs.bounce.Objects.SprButton;
import cs.bounce.Menu.GamMain;

public class ScrStart implements Screen, InputProcessor {
    SpriteBatch batch;
    GamMain main;
    SprButton btnStart;
    SprBackground bgStart;
    OrthographicCamera oc;
    Vector2 vMouse;


    public ScrStart(GamMain main) {
        this.main = main;
    }

    @Override
    public void show() {
        //OC Camera
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        Gdx.input.setInputProcessor(this);

        //Textures

        //Sprites

        batch = new SpriteBatch();
        //SprBackground
        bgStart = new SprBackground(0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), "bg_start.jpg");

        //Buttons
        btnStart = new SprButton(200,200,200, 200,"start_button.png");


        //Mouse
        vMouse = new Vector2(0,0);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        changeScreen();
        bgStart.draw(batch);
        btnStart.draw(batch);
        batch.end();
    }

    private void changeScreen() {
        if (Gdx.input.justTouched()) {
            if (btnStart.isMousedOver()) {
                System.out.println("Levels Screen");
                main.updateScreen(1);
            }
        }
    }



    //Stuff below here pretty much can be ignored, at least for now // once you get textures, make sure to dispose of them
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        return;
    }

    @Override
    public void resume() {
        return;
    }

    @Override
    public void hide() {
        return;
    }

    @Override
    public void dispose() {
        btnStart.getTexture().dispose();
        return;
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





