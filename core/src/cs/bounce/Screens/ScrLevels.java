package cs.bounce.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import cs.bounce.Objects.SprBackground;
import cs.bounce.Objects.SprButton;
import cs.bounce.Menu.GamMain;

public class ScrLevels implements Screen {

    GamMain main;
    SpriteBatch batch;
    Texture txbgLevels;
    SprButton btnLvl1,  btnLvl2, btnBack;
    OrthographicCamera oc = new OrthographicCamera();
    Vector2 vMouse;
    SprBackground sprbgLevels;
    ShapeRenderer shapeRenderer;

    public ScrLevels(GamMain main) {
            this.main = main;
            // Gdx.input.setInputProcessor(this);
        //OC Camera
        oc.setToOrtho(false,1000, 800);
        //Texture
        txbgLevels = new Texture("bg_level_select.jpg");
        batch = new SpriteBatch();
        //SprBackground
        sprbgLevels = new SprBackground(txbgLevels);
        //Buttons
        btnBack = new SprButton(0,700,100, 100,"back.png");
        btnLvl1 = new SprButton(100,400,100, 100,"lvl1_select.png");
        btnLvl2 = new SprButton(250,400,100, 100,"lvl2_select.png");
        //Mouse
        vMouse = new Vector2(0,0);
        //ShapeRenderer
        shapeRenderer = new ShapeRenderer();

    }

    public void show() {
    }

    @Override
    public void render(float delta) {
        oc.update();
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        changeScreen();
        sprbgLevels.draw(batch);
        btnLvl1.draw(batch);
        btnLvl2.draw(batch);
        btnBack.draw(batch);
        batch.end();
    }

    private void changeScreen() {
        if (Gdx.input.justTouched()) {
            if (btnLvl1.isMousedOver()) {
                System.out.println("Level 1");
                main.updateScreen(2);
            }
            if (btnLvl2.isMousedOver()) {
                System.out.println("Level 2");
                main.updateScreen(3);
            }
            if (btnBack.isMousedOver()) {
                System.out.println("Start Screen");
                main.updateScreen(0);
            }

        }
    }

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
}


