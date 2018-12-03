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

import java.util.ArrayList;


public class ScrLvl1 implements Screen, InputProcessor {
    GamMain main;
    SpriteBatch batch;
    Texture txJumper;
    Texture txBackground;
    SprHero sphHero;
    SprBackground bgBackground;

    OrthographicCamera oc = new OrthographicCamera();

    ObjPlatform oplFloor, oplLeftWall, oplRightWall;

    Boolean isAPressed;
    Boolean isDPressed;

    Vector2 v2Gravity;
    float camX;
    float camY;

    //Array List
    int n = 3;
    ArrayList<ObjPlatform> arplat = new ArrayList<ObjPlatform>(n);


    public ScrLvl1(GamMain _main) {
        main = _main;
        batch = new SpriteBatch();
        oc.setToOrtho(false, 1000, 800);
        txJumper = new Texture("hero_yeetgirl.png");
        txBackground = new Texture("bg_city.png");
        sphHero = new SprHero(txJumper, 0, 200);

        oplFloor = new ObjPlatform("fl_ground.png", -400, -350, 1800, 400);
        oplLeftWall = new ObjPlatform("fl_ground.png", -750, -350, 400, 1350);
        oplRightWall = new ObjPlatform("fl_ground.png", 1350, -350, 400, 1350);

        arplat.add(new ObjPlatform("fl_ground.png", -400, -350, 1800, 400));
        arplat.add(new ObjPlatform("fl_ground.png", -750, -350, 400, 1350));
        arplat.add(new ObjPlatform("fl_ground.png", 1350, -350, 400, 1350));

        bgBackground = new SprBackground(txBackground);
        isAPressed = false;
        isDPressed = false;
        v2Gravity = new Vector2(0, -1);
        camX = sphHero.getX();
        camY = sphHero.getY();
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
        sphHero.draw(batch);

       // oplFloor.draw(batch);
      //  oplLeftWall.draw(batch);
      //  oplRightWall.draw(batch);

        for (int i = 0; i < n; i++) {
            arplat.get(i).draw(batch);
        }

        batch.end();

        for (int i = 0; i < n; i++) {
            arplat.get(i).isHit(sphHero);

            if (!arplat.get(i).checkHit(sphHero)) { // is this saying AND or OR?
                sphHero.setCanJump(false);
                sphHero.applyForce(v2Gravity);
            }

        }

    /*     oplFloor.isHit(sphHero);
         oplLeftWall.isHit(sphHero);
         oplRightWall.isHit(sphHero);

            if (!oplFloor.checkHit(sphHero) && !oplLeftWall.checkHit(sphHero) && !oplRightWall.checkHit(sphHero)) {
            sphHero.setCanJump(false);
            sphHero.applyForce(v2Gravity);
          }
          */


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
        }
        if (sphHero.getX() < camX - 125) {
            camX -= 5;
        }
        if (sphHero.getY() > camY + 350) {
            camY += 10;
        }
        if (sphHero.getY() > -300) {
            if (sphHero.getY() < camY + 100) {
                camY -= 20;
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
        for (int i = 0; i < n; i++) {
            arplat.get(i).getTexture().dispose();
        }
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


