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

import java.awt.event.KeyEvent;

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
    int nDir = 0;
    char c;

    public ScrLvl2(GamMain _main) {
        main = _main;
    }

    @Override
    public void show() {
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
        flGround.floor(sphHero);
        sphHero.move();
        spoWall.isHit(sphHero);
        spoEnd.isWon(sphHero);
        spoSpike.isKilled(sphHero);
        isWon();
        isDead();
        keyTyped(c);
        //KeyHit();
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
    /*
    private void KeyHit() {
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            nDir = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            nDir = 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
           nDir = 3;
        }
    }
*/

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
        return false;
    }



    @Override
    public boolean keyUp ( int keycode){
        return false;
    }

    @Override
    public boolean keyTyped ( char character){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            sphHero.setY(sphHero.getLoc().y + 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            sphHero.setX(sphHero.getVel().x + 5);
            System.out.println("fuck thi natahn guy");
        }
        if(character == 'a' || character == 'A'){
            sphHero.setX(sphHero.getVel().x - 5);
        }

        return false;
    }



    @Override
    public boolean touchDown ( int screenX, int screenY, int pointer, int button){
        return false;
    }

    @Override
    public boolean touchUp ( int screenX, int screenY, int pointer, int button){
        return false;
    }

    @Override
    public boolean touchDragged ( int screenX, int screenY, int pointer){
        return false;
    }

    @Override
    public boolean mouseMoved ( int screenX, int screenY){
        return false;
    }

    @Override
    public boolean scrolled ( int amount){
        return false;
    }
}
