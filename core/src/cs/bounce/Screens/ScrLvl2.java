package cs.bounce.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import cs.bounce.Menu.GamMain;
import cs.bounce.Objects.SprBackground;
import cs.bounce.Objects.SprFloor;
import cs.bounce.Objects.SprHero;
import cs.bounce.Objects.SprObstacle;


public class ScrLvl2 implements Screen, InputProcessor {

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
    //Obstalces
    SprObstacle spoWall;
    SprObstacle spoSpike;
    SprObstacle spoEnd;
    //Floor
    SprFloor flGround;
    //Vectors

    Vector2 v2Gravity, v2Normal;
    int nMove;
    char c;

    public ScrLvl2(GamMain _main) {
        main = _main;
        Gdx.input.setInputProcessor((this));
    }

    @Override
    public void show() {
        System.out.println("Up");
        oc.setToOrtho(false, 800, 400);
        batch = new SpriteBatch();
        //Textures
        txCity = new Texture("bg_city.png");
        txJumper = new Texture("hero_yeetgirl.png");
        txFloor = new Texture("fl_ground.png");
        //Backgrounds
        bgCity = new SprBackground(txCity);
        //Jumper
        sphHero = new SprHero(txJumper, 150, 150);
        //Floor
        flGround = new SprFloor(txFloor);
        //Obstacle
        spoWall = new SprObstacle(0, 50, 100, 600, "wall.jpg");
        spoSpike = new SprObstacle(300, 50, 100, 50, "spikes.png");
        spoEnd = new SprObstacle(550, 50, 100, 50, "finish.png");
        //Vector
        v2Gravity = new Vector2(0, -1);
        v2Normal = new Vector2(0, 1);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        bgCity.draw(batch);
        flGround.draw(batch);
        sphHero.draw(batch);
        spoSpike.draw(batch);
        spoWall.draw(batch);
        spoEnd.draw(batch);
        batch.end();
        sphHero.update();
        flGround.floor(sphHero);
        spoWall.isHit(sphHero);
        spoEnd.isWon(sphHero);
        spoSpike.isKilled(sphHero);
        isWon();
        isDead();
        //keyDown(nMove);
   /*     if (sphHero.getcanJump()) {
      if (Gdx.input.isKeyPressed(Input.Keys.W)) {
        //sphHero.setY(sphHero.getv2CurrentPos().y + 40);
        sphHero.getAcc().y = 18;
        System.out.println("Up");
   //     canJump = false;
    }
}
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            sphHero.setVel(5,0);
           // System.out.println("Right");
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            sphHero.setVel(-5,0);
         //   System.out.println("Left");
        }
        */
    }


    private void isDead() {
        if (spoSpike.isKilled(sphHero)) {
            main.updateScreen(3);
        }
    }

    private void isWon() {
        if (spoEnd.isWon(sphHero)) {
            main.updateScreen(1);
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
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("Up");
        /*if(keycode == 52){
            sphHero.setY(sphHero.getv2CurrentPos().y + 40);
            System.out.println("Up");
        }
        if(keycode == 32){
            sphHero.setVel(5,0);
            System.out.println("Right");
        }
        if(keycode == 29){
            sphHero.setVel(-5,0);
            System.out.println("Left");
        }*/
        return true;
    }


    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        System.out.println("Up");
        if (character == 'a') {
            sphHero.setY(sphHero.getv2CurrentPos().y + 40);
            System.out.println("Up");

        }


        return true;
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("Up");
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
