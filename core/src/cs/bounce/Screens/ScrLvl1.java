package cs.bounce.Screens;


import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import cs.bounce.GamMenu;
import cs.bounce.Objects.SprBackground;
import cs.bounce.Objects.SprFloor;
import cs.bounce.Objects.SprHero;


public class ScrLvl1 implements Screen, InputProcessor {
    GamMenu main;
    SpriteBatch batch;
    //Textures
    Texture txCity;
    Texture txJumper;
    Texture txFloor;
    //Backgrounds
    SprBackground bgCity;
    //Jumper
    SprHero sphHero;
    //Orthographic Camera
    OrthographicCamera oc = new OrthographicCamera();
    //Floor
    SprFloor flGround;
    //Vectors
    Vector2 v2Gravity, v2Normal;

    public ScrLvl1(GamMenu _main) {
        main = _main;
    }

    @Override
    public void show() {
        oc.setToOrtho(false,800,400);
        batch = new SpriteBatch();
        //Textures
        txCity = new Texture("bg_city.png");
        txJumper = new Texture("jumper.png");
        txFloor = new Texture("city_ground.png");
        //Backgrounds
        bgCity = new SprBackground(txCity);
        //Jumper
        sphHero = new SprHero(txJumper, 200,100);
        //Floor
        flGround = new SprFloor(txFloor);
        //Vector
        v2Gravity = new Vector2(0,-1);
        v2Normal = new Vector2(0,1);

    }

    @Override
    public void render(float delta) {
        batch.begin();
        bgCity.draw(batch);
        flGround.draw(batch);
        sphHero.draw(batch);
        batch.end();
        flGround.floor(sphHero,v2Gravity);
        sphHero.Update();

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
