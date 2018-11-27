package cs.bounce.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.regexp.internal.REDebugCompiler;
import cs.bounce.Menu.GamMain;
import cs.bounce.Objects.*;

public class ScrLvl2 implements Screen, InputProcessor {

    GamMain main;
    SpriteBatch batch;
   ShapeRenderer sr;
    Texture txCity;
    Texture txFloor;


    SprBackground bgCity;
    ObjPlatform ptPlatform;
    SprHero sphHero;

    OrthographicCamera oc = new OrthographicCamera();

    SprFloor flGround;

    Vector2 v2Gravity, v2Normal;

    public ScrLvl2(GamMain _main) {
       main = _main;
        oc.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sr = new ShapeRenderer();
        batch = new SpriteBatch();
        txCity = new Texture("bg_city.png");
        txFloor = new Texture("fl_ground.png");
        ptPlatform = new ObjPlatform("fl_ground.png", 0, 0, 100, 100);
        bgCity = new SprBackground(txCity);

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        batch.begin();
        bgCity.draw(batch);
        ptPlatform.draw(batch);
        batch.end();

        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setProjectionMatrix(oc.combined);

        sr.setColor(Color.RED);
        sr.line(0,100,Gdx.graphics.getWidth(),100);
        sr.setColor(Color.ORANGE);
        sr.line(0,200,Gdx.graphics.getWidth(),200);
        sr.setColor(Color.YELLOW);
        sr.line(0,300,Gdx.graphics.getWidth(),300);
        sr.setColor(Color.GREEN);
        sr.line(0,400,Gdx.graphics.getWidth(),400);
        sr.setColor(Color.BLUE);
        sr.line(0,500,Gdx.graphics.getWidth(),500);
        sr.setColor(Color.PURPLE);
        sr.line(0,600,Gdx.graphics.getWidth(),600);
        sr.end();

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



