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


public class ScrLvl2 implements Screen, InputProcessor {

    GamMain main;
    SpriteBatch batch;
    Texture txJumper;
    Texture txBackground;
    SprHero sphHero;
    SprBackground bgBackground;
    OrthographicCamera oc = new OrthographicCamera();
    Boolean isAPressed;
    Boolean isDPressed;
    Vector2 v2Gravity, v2HeroStart, v2StartingPos;
    float camX,camY;
    static float startCamX, startCamY;
    boolean hasHit;
    ArrayList<SprObstacle> ArObs = new ArrayList<SprObstacle>(13);

    public ScrLvl2(GamMain _main) {
        main = _main;
        batch = new SpriteBatch();
        oc.setToOrtho(false, 1000, 800);
        txJumper = new Texture("dinner_sprite.png");
        txBackground = new Texture("barn.png");
        v2HeroStart = new Vector2(-210, 450);
        sphHero = new SprHero(txJumper, v2HeroStart.x, v2HeroStart.y);
        bgBackground = new SprBackground(txBackground);
        isAPressed = false;
        isDPressed = false;
        v2Gravity = new Vector2(0, -1);
        camX = sphHero.getX();
        camY = sphHero.getY();
        startCamX = camX;
        startCamY = camY;

        ArObs.add(new ObjPlatform("dirt_floor.jpg", -400, -350, 1800, 400)); //ground
        ArObs.add(new ObjPlatform("barn_wall.png", -750, -350, 400, 1350)); //wall 1
        ArObs.add(new ObjPlatform("barn_wall.png", 1350, -350, 400, 1350)); //wall 2
        ArObs.add(new ObjPlatform("hay_plat.jpg", -250, 50, 200, 450)); // tall start
        ArObs.add(new ObjPlatform("hay_plat.jpg", 100, 50, 400, 200)); // 2nd block
        ArObs.add(new ObjPlatform("hay_plat.jpg", 600, 50, 300, 350)); // third
        ArObs.add(new ObjFixedHazard("spikes.png",-350, 50, 100, 40)); //left most spikes
        ArObs.add(new ObjFixedHazard("spikes.png", -50, 50, 150, 40)); //between tall and 2nd
        ArObs.add(new ObjFixedHazard("spikes.png",220, 250, 80, 40)); // on second
        ArObs.add(new ObjFixedHazard("spikes.png",500, 50, 100, 40)); // between second and third
        ArObs.add(new ObjFixedHazard("spikes.png",725, 400, 80, 40)); // on third
        ArObs.add(new ObjFixedHazard("spikes.png",900, 50, 175, 40)); // before objective
        ArObs.add(new ObjObjective("seeds.png", 1250, 50, 100,100));

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        oc.update(); //https://github.com/calebjanhunen/SplashShot/blob/scratch/HitDetection/core/src/project/splash/ScrPlay.java

        TrackingCamera();

        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        bgBackground.draw(batch);
        sphHero.draw(batch);
        for (int i = 0; i < ArObs.size(); i++) {
            ArObs.get(i).draw(batch);
        }
        batch.end();

        for (int i = 0; i < ArObs.size(); i++) {
            if (ArObs.get(i).isHit(sphHero, ArObs.get(i))) {
                sphHero.registerHit(ArObs.get(i));
                hasHit = true;
                if (ArObs.get(i).getType() == 1) {
                    sphHero.setPos(v2HeroStart.x, v2HeroStart.y);
                    camX = startCamX;
                    camY = startCamY;
                    main.updateScreen(3);
                }
                if (ArObs.get(i).getType() == 0) {
                    sphHero.setPos(v2HeroStart);
                    camX = startCamX;
                    camY = startCamY;
                    main.updateScreen(1);
                }
            }

        }

        if (!hasHit) {
            sphHero.applyForce(v2Gravity);
            sphHero.setCanJump(false);
        }
        hasHit = false;
        sphHero.update();


        if (!isAPressed && !isDPressed)
            sphHero.setVel(0, sphHero.getVel().y);


        if (sphHero.getPos().y >= sphHero.getMaxheight()) { //sets can jump false when Hero reaches maximum jump height
            sphHero.setCanJump(false);
        }


    }

    private void TrackingCamera() { //https://stackoverflow.com/questions/24534159/how-do-i-make-the-camera-follow-the-player-in-libgdx
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
    public void dispose() {//https://github.com/libgdx/libgdx/wiki/Memory-management
        
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case 29: //A
                System.out.println("AAA");
                sphHero.setVel(-5, sphHero.getVel().y);
                isAPressed = true;
                break;
            case 32: //D
                System.out.println("DDD");
                sphHero.setVel(5, sphHero.getVel().y);
                isDPressed = true;
                break;
            case 51: //W
                System.out.println("WWW");
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



