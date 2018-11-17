package cs.bounce.Screens;

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

   /* GamMain main;
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
    //Floor
    SprFloor flGround;
    //Vectors
    Vector2 v2Gravity, v2Normal; */

    public ScrLvl2(GamMain _main) {
    //    main = _main;
    }

    @Override
    public void show() {
   /*     oc.setToOrtho(false, 800, 400);
        batch = new SpriteBatch();
        //Textures
        txCity = new Texture("bg_city.png");
        txJumper = new Texture("hero_yeetgirl.png");
        txFloor = new Texture("fl_ground.png");
        //Backgrounds
        bgCity = new SprBackground(txCity);
        //Jumper
        sphHero = new SprHero(txJumper, 200, 150);
        //Floor
        flGround = new SprFloor(txFloor);
        //Obstacle
        spoWall = new SprObstacle(100, 50, 100, 100, "wall.jpg");
        spoSpike = new SprObstacle(400, 50, 100, 50, "spikes.png");
        //Vector
        v2Gravity = new Vector2(0, -1);
        v2Normal = new Vector2(0, 1);
*/
    }

    @Override
    public void render(float delta) {
  /*      batch.begin();
        bgCity.draw(batch);
        flGround.draw(batch);
        sphHero.draw(batch);
        spoSpike.draw(batch);
        spoWall.draw(batch);
        batch.end();
        flGround.floor(sphHero);
        sphHero.update();
        spoWall.isHit(sphHero);
        spoSpike.isKilled(sphHero);
        */
    }

   /* if (isHit == true){

    }
*/
    //Stuff below here pretty much can be ignored, at least for now // once you get textures, make sure to dispose of them
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



