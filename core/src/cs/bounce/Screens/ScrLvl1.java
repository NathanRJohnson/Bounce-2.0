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
import com.badlogic.gdx.utils.viewport.ScreenViewport;
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
    ShapeRenderer sr;
    OrthographicCamera oc = new OrthographicCamera();

    Boolean isAPressed;
    Boolean isDPressed;

    Vector2 v2Gravity, v2HeroStart;
    float camX;
    float camY;
    boolean hasHit;
    ArrayList<SprObstacle> ArObs = new ArrayList<SprObstacle>(7);

    public ScrLvl1(GamMain _main) {
        main = _main;
        batch = new SpriteBatch();
        oc.setToOrtho(false, 1000, 800);
        txJumper = new Texture("dinner_sprite.png");
        txBackground = new Texture("barn.png");
        v2HeroStart = new Vector2(0, 200);
        sphHero = new SprHero(txJumper, v2HeroStart.x, v2HeroStart.y);
        sr = new ShapeRenderer();

        ArObs.add(new ObjPlatform("dirt_floor.jpg", -400, -350, 1800, 400)); //ground
        ArObs.add(new ObjPlatform("barn_wall.png", -750, -350, 400, 1350)); //pt1
        ArObs.add(new ObjPlatform("barn_wall.png", 1350, -350, 400, 1350)); //pt2
        ArObs.add(new ObjPlatform("hay_plat_small.jpg", -350, 285, 550, 50));
        ArObs.add(new ObjPlatform("hay_plat_small.jpg", 350, 285, 500, 50));
        ArObs.add(new ObjPlatform("hay_plat.jpg", 850, 50, 500, 135));
        ArObs.add(new ObjObjective("seeds.png", -350, 335, 100, 100));
        ArObs.add(new ObjShiftingHazard("sawblade.png", 150, 20, 60, 60, 200, 'x'));
       // ArObs.add(new ObjFixedHazard("sawblade.png", 150, 20, 70, 70));
       // oshSaw = new ObjShiftingHazard("sawblade.png", 150, 20, 100, 100, 200, 'x');

        bgBackground = new SprBackground(txBackground);
        isAPressed = false;
        isDPressed = false;
        v2Gravity = new Vector2(0, -1);

        camX = sphHero.getX();
        camY = sphHero.getY();

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        oc.update();
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
            ArObs.get(i).move();
            if (ArObs.get(i).isHit(sphHero, ArObs.get(i))) {
                sphHero.registerHit(ArObs.get(i));
                hasHit = true;
                if (ArObs.get(i).getType() == 1) {
                    sphHero.setPos(v2HeroStart);
                    camX = sphHero.getPos().x;
                    camY = sphHero.getPos().y;
                    main.updateScreen(2);
                }
                if (ArObs.get(i).getType() == 0) {
                    sphHero.setPos(v2HeroStart);
                    camX = sphHero.getPos().x;
                    camY = sphHero.getPos().y;
                    main.updateScreen(1);
                }
            }

        }

        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setProjectionMatrix(oc.combined);
        sr.setColor(Color.BLUE);
        for (int i = 0; i < ArObs.size(); i++){

            sr.polygon(ArObs.get(i).getVertices());
        }
        sr.end();

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
        //  oc.viewportWidth = width;
        //  oc.viewportHeight = height;
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
        for (int i = 0; i < ArObs.size(); i++) {
            ArObs.get(i).getTexture().dispose();
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("mm");
        switch (keycode) {
            case 29: //A
                sphHero.setVel(-5, sphHero.getVel().y);
                isAPressed = true;
                System.out.println("a");
                break;
            case 32: //D
                sphHero.setVel(5, sphHero.getVel().y);
                isDPressed = true;
                System.out.println('d');
                break;
            case 51: //W
                if (sphHero.getJumpState()) {
                    sphHero.setMaxHeight();
                    sphHero.setVel(sphHero.getVel().x, 16);
                    System.out.println("w");
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
