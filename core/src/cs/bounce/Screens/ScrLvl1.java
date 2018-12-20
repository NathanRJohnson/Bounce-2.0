package cs.bounce.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import cs.bounce.Menu.GamMain;
import cs.bounce.Objects.*;



public class ScrLvl1 implements Screen, InputProcessor {
    GamMain main;
    SpriteBatch batch;
    Texture txJumper;
    Texture txBackground;
    SprHero sphHero;
    SprBackground bgBackground;

    OrthographicCamera oc = new OrthographicCamera();

    ObjPlatform oplFloor, oplLeftWall, oplRightWall, oplPlat1, oplPlat2, oplPlat3;
    ObjObjective objFinish;

    Boolean isAPressed;
    Boolean isDPressed;

    Vector2 v2Gravity, v2HeroStart;
    float camX;
    float camY;

    public ScrLvl1(GamMain _main) {
        main = _main;
        batch = new SpriteBatch();
        oc.setToOrtho(false,1000, 800);
        txJumper = new Texture("dinner_sprite.png");
        txBackground = new Texture("barn.png");
        v2HeroStart = new Vector2(0,200);
        sphHero = new SprHero(txJumper, v2HeroStart.x,v2HeroStart.y);

        oplFloor = new ObjPlatform("dirt_floor.jpg", -400,-350,1800,400);
        oplLeftWall = new ObjPlatform("barn_wall.png", -750,-350,400,1350);
        oplRightWall = new ObjPlatform("barn_wall.png",1350,-350,400,1350);
        oplPlat1 = new ObjPlatform("hay_plat_small.jpg",-350,285,550,50);
        oplPlat2 = new ObjPlatform("hay_plat_small.jpg",350,285,500,50);
        oplPlat3 = new ObjPlatform("hay_plat.jpg",850,50,500,135);

        objFinish = new ObjObjective("seeds.png",-350,335,100,100);
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

        oplFloor.draw(batch);
        oplPlat1.draw(batch);
        oplPlat2.draw(batch);
        oplPlat3.draw(batch);
        objFinish.draw(batch);
        oplLeftWall.draw(batch);
        oplRightWall.draw(batch);

        batch.end();

        oplFloor.isHit(sphHero);
        oplLeftWall.isHit(sphHero);
        oplRightWall.isHit(sphHero);
        oplPlat1.isHit(sphHero);
        oplPlat2.isHit(sphHero);
        oplPlat3.isHit(sphHero);

        if (objFinish.isHit(sphHero)) {
            System.out.println("You won");
            sphHero.setPos(v2HeroStart.x, v2HeroStart.y);
            main.updateScreen(1);
        }

            if (!oplFloor.checkHit(sphHero) && !oplLeftWall.checkHit(sphHero) && !oplRightWall.checkHit(sphHero) && !oplPlat1.checkHit(sphHero) && !oplPlat2.checkHit(sphHero) && !oplPlat3.checkHit(sphHero)) {
                System.out.println("falling");
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
        oplFloor.getTexture().dispose();
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


