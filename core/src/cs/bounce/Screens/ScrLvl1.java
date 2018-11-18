package cs.bounce.Screens;


import com.badlogic.gdx.Gdx;
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
import cs.bounce.Menu.GamMain;
import cs.bounce.Objects.SprBackground;
import cs.bounce.Objects.SprFloor;
import cs.bounce.Objects.SprHero;
import cs.bounce.Objects.SprObstacle;


public class ScrLvl1 implements Screen, InputProcessor {
    GamMain main;
    SpriteBatch batch;
    Texture txJumper;
    Texture txBackground;

    SprHero sphHero;
    SprObstacle obFloor;
    SprBackground bgBackground;

    OrthographicCamera oc = new OrthographicCamera();
    ShapeRenderer sr;

    Boolean isAPressed;
    Boolean isDPressed;

    Vector2 v2Gravity;

    Polygon plyHero, plyObj;

    public ScrLvl1(GamMain _main) {
        main = _main;
        batch = new SpriteBatch();
        oc.setToOrtho(false, 700, 700);
        sr = new ShapeRenderer();
        txJumper = new Texture("jumper.png");
        txBackground = new Texture("bg_city.png");
        sphHero = new SprHero(txJumper, 250, 250);
        obFloor = new SprObstacle(0,-50,700,100, "fl_ground.png");
        bgBackground = new SprBackground(txBackground);
        isAPressed = false;
        isDPressed = false;
        v2Gravity = new Vector2(0,-1);
        plyHero = new Polygon(new float[]
                {sphHero.getX(), sphHero.getY(), sphHero.getX() + sphHero.getWidth(), sphHero.getY() , sphHero.getX() + sphHero.getWidth(), sphHero.getY() + sphHero.getHeight(), sphHero.getX(), sphHero.getY() + sphHero.getHeight()
                        /*sphHero.getPos().x, sphHero.getPos().y, sphHero.getPos().x + sphHero.getWidth(), sphHero.getPos().y,
                sphHero.getPos().x + sphHero.getWidth(), sphHero.getPos().y + sphHero.getHeight(),
                sphHero.getPos().x, sphHero.getPos().y + sphHero.getHeight()*/});
        plyObj = new Polygon(new float[]
                {obFloor.getX(), obFloor.getY(),
                        obFloor.getX() + obFloor.getWidth(), obFloor.getY(),
                        obFloor.getX() + obFloor.getWidth(), obFloor.getY() + obFloor.getHeight(),
                        obFloor.getX(), obFloor.getY() + obFloor.getHeight()});

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
        obFloor.draw(batch);
        sphHero.draw(batch);
        batch.end();

        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setProjectionMatrix(oc.combined);
        sr.setColor(Color.RED);
        sr.polygon(plyHero.getTransformedVertices());
        sr.setColor(Color.BLUE);
        sr.polygon(plyObj.getTransformedVertices());

        sr.end();

    plyHero.setOrigin(sphHero.getWidth()/2,sphHero.getHeight());
        plyHero.setPosition(sphHero.getPos().x, sphHero.getPos().y + sphHero.getHeight()/2);
        plyObj.setOrigin(obFloor.getOriginX(), obFloor.getOriginY());
        plyObj.setPosition(obFloor.getX(), obFloor.getY());

        if (Intersector.overlapConvexPolygons(plyHero,plyObj)) {
            sphHero.setPos(sphHero.getPos().x, obFloor.getY() + obFloor.getHeight()/2);
            System.out.println("yeouch");
            sphHero.setVel(sphHero.getVel().x, 0);
        }


        //System.out.println(jumper.getV2Pos());
        sphHero.applyForce(v2Gravity);
        sphHero.update();


        if (!isAPressed && !isDPressed)
            sphHero.setVel(0,sphHero.getVel().y);

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
                sphHero.setVel(-5, sphHero.getVel().y);
                System.out.println("a");
                isAPressed = true;
                break;
            case 32:
                sphHero.setVel(5, sphHero.getVel().y);
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
