package cs.bounce.Screens;


import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import cs.bounce.Menu.GamMain;
import cs.bounce.Objects.SprBackground;
import cs.bounce.Objects.SprFloor;
import cs.bounce.Objects.SprHero;
import cs.bounce.Objects.SprPlatform;


public class ScrLvl1 implements Screen, InputProcessor {
    GamMain main;
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
    SprPlatform ptPlatformA , ptPlatformLong;
    ShapeRenderer sr;
    //Vectors
    Vector2 v2Normal;

    public ScrLvl1(GamMain _main) {
        main = _main;
    }

    @Override
    public void show() {
        oc.setToOrtho(false,800,400);
        batch = new SpriteBatch();
        //Textures
        txCity = new Texture("bg_city.png");
        txJumper = new Texture("hero_yeetgirl.png");
        txFloor = new Texture("fl_ground.png");
        //Backgrounds
        bgCity = new SprBackground(txCity);
        //Jumper
        sphHero = new SprHero(txJumper, 200,150);
        //Floor
        flGround = new SprFloor(txFloor);
        ptPlatformA = new SprPlatform(txFloor, 100,200,100,30);
        ptPlatformLong = new SprPlatform(txFloor, 400,240,200,30);
        sr = new ShapeRenderer();


        //Vector

        v2Normal = new Vector2(0,1);

    }

    @Override
    public void render(float delta) {
        batch.begin();
        bgCity.draw(batch);
        flGround.draw(batch);
        sphHero.draw(batch);
        ptPlatformA.draw(batch);
        ptPlatformLong.draw(batch);
        batch.end();

        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setProjectionMatrix(oc.combined);

        sr.setColor(Color.RED);
        sr.polygon(ptPlatformA.getPolygon().getTransformedVertices());

        sr.setColor(Color.BLUE);
        sr.polygon(ptPlatformLong.getPolygon().getTransformedVertices());

        sr.setColor(Color.FIREBRICK);
        sr.polygon(sphHero.getPolygon().getTransformedVertices());
        sr.end();

        flGround.floor(sphHero);
        sphHero.update();
        ptPlatformA.isHit(sphHero);
        ptPlatformLong.isHit(sphHero);

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
    bgCity.getTexture().dispose();
    flGround.getTexture().dispose();
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
