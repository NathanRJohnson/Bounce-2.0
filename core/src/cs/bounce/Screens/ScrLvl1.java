package cs.bounce.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.sun.deploy.util.BlackList;
import cs.bounce.Menu.GamMain;
import cs.bounce.Objects.*;


public class ScrLvl1 implements Screen, InputProcessor {
    GamMain main;
    SpriteBatch batch;
    Texture txJumper;
    Texture txBackground;

    SprHero sphHero;
    ObjPlatform obFloor;
    SprBackground bgBackground;

    OrthographicCamera oc = new OrthographicCamera();
    ShapeRenderer sr;

    Boolean isAPressed;
    Boolean isDPressed;

    Vector2 v2Gravity;

    public ScrLvl1(GamMain _main) {
        main = _main;
        batch = new SpriteBatch();
        oc.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sr = new ShapeRenderer();
        txJumper = new Texture("jumper.png");
        txBackground = new Texture("bg_city.png");
        sphHero = new SprHero(txJumper, 250, 250);
        obFloor = new ObjPlatform("fl_ground.png",0,0,700,100);
        bgBackground = new SprBackground(txBackground);
        isAPressed = false;
        isDPressed = false;
        v2Gravity = new Vector2(0,-1);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        System.out.println(sphHero.getJumpState());
        oc.update();
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        bgBackground.draw(batch);
        obFloor.draw(batch);
        sphHero.draw(batch);
        batch.end();

        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setProjectionMatrix(oc.combined);
        sr.setColor(Color.RED);
        sr.line(0, sphHero.getMaxheight(), Gdx.graphics.getWidth(), sphHero.getMaxheight());
        sr.setColor(Color.BLACK);
        sr.polygon(sphHero.getPolygon().getTransformedVertices());
        sr.setColor(Color.BLUE);
        sr.polygon(obFloor.getPolygon().getTransformedVertices());
        sr.end();

        obFloor.isHit(sphHero.getPolygon(),sphHero);


   /*     if (Intersector.overlapConvexPolygons(plyHero,plyObj)) {
            sphHero.setPos(sphHero.getPos().x, obFloor.getY() + sphHero.getHeight() - 15);
            System.out.println("yeouch");
            sphHero.setVel(sphHero.getVel().x, 0);
        } */


        //System.out.println(jumper.getV2Pos());
        if (!sphHero.getJumpState()) {
           // System.out.println("The laws of physics are in effect");
            sphHero.applyForce(v2Gravity);
        }
        sphHero.update();


        if (!isAPressed && !isDPressed)
            sphHero.setVel(0,sphHero.getVel().y);

        if (sphHero.getPos().y >= sphHero.getMaxheight()) //sets can jump false when Hero reaches maximum jump height
            sphHero.setCanJump(false);

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
    obFloor.getTexture().dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case 29: //A
                sphHero.setVel(-5, sphHero.getVel().y);
                System.out.println("a");
                isAPressed = true;
                break;
            case 32: //D
                sphHero.setVel(5, sphHero.getVel().y);
                System.out.println("d");
                isDPressed = true;
                break;
            case 51:
                if (sphHero.getJumpState() && sphHero.getPos().y != sphHero.getMaxheight()) {
                    System.out.println("w");
                    sphHero.setMaxHeight();
                    sphHero.setVel(sphHero.getVel().x, 15);

                }
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
            case 51:
                sphHero.setCanJump(false);
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
