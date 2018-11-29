package cs.bounce.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import cs.bounce.Menu.GamMain;
import cs.bounce.Objects.*;


public class ScrLvl1 implements Screen, InputProcessor {
    GamMain main;
    SpriteBatch batch;
    Texture txJumper;
    Texture txBackground;
    SprHero sphHero;
    ObjPlatform obFloor;
    ObjPlatform objPlatform;
    ObjPlatform objPlatform2;
    SprBackground bgBackground;

    OrthographicCamera oc = new OrthographicCamera();


    Boolean isAPressed;
    Boolean isDPressed;

    Vector2 v2Gravity;
    float camX;
    float camY;

    public ScrLvl1(GamMain _main) {
        main = _main;
        batch = new SpriteBatch();
        oc.setToOrtho(false, 1000, 800);
        txJumper = new Texture("hero_yeetgirl.png");
        txBackground = new Texture("bg_city.png");
        sphHero = new SprHero(txJumper, 0, 200);
        obFloor = new ObjPlatform("fl_ground.png", -700, 0, 1400, 100);
        objPlatform = new ObjPlatform("fl_ground.png", 100, 100, 100, 100);
        objPlatform2 = new ObjPlatform("fl_ground.png", 360, 270, 200, 50);
        bgBackground = new SprBackground(txBackground);
        isAPressed = false;
        isDPressed = false;
        v2Gravity = new Vector2(0, -1);
        float camX = sphHero.getX();
        float camY = sphHero.getY();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        // System.out.println(sphHero.getJumpState());

        oc.update();
        TrackingCamera();
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        bgBackground.draw(batch);
        obFloor.draw(batch);
        objPlatform.draw(batch);
        objPlatform2.draw(batch);
        sphHero.draw(batch);
        batch.end();


        obFloor.isHit(sphHero);
        objPlatform.isHit(sphHero);
        objPlatform2.isHit(sphHero);

        if (!obFloor.checkHit(sphHero) && !objPlatform.checkHit(sphHero) && !objPlatform2.checkHit(sphHero)) {
            sphHero.setCanJump(false);
            sphHero.applyForce(v2Gravity);
        }


        sphHero.update();


        if (!isAPressed && !isDPressed)
            sphHero.setVel(0, sphHero.getVel().y);

        if (sphHero.getPos().y >= sphHero.getMaxheight()) { //sets can jump false when Hero reaches maximum jump height
            sphHero.setCanJump(false);
        }

    }

    private void TrackingCamera() {
        oc.position.set(camX, camY + 300, 0);
        if (sphHero.getX() > camX + 75) {
            camX += 5;
            System.out.println("Slide to the Right");
        }
        if (sphHero.getX() < camX - 125) {
            camX -= 5;
            System.out.println("Slide to the Left");
        }
        if (sphHero.getY() > camY + 350) {
            camY += 10;
            System.out.println("Go up");
        }
        if (sphHero.getY() > -300) {
            if (sphHero.getY() < camY + 100) {
                camY -= 20;
                System.out.println("Go down");
            }
        }
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
                isAPressed = true;
                break;
            case 32: //D
                sphHero.setVel(5, sphHero.getVel().y);
                isDPressed = true;
                break;
            case 51: //W
                if (sphHero.getJumpState()) {
                    sphHero.setMaxHeight();
                    sphHero.setVel(sphHero.getVel().x, 16);


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


