package cs.bounce.Objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class SprHero extends Sprite implements InputProcessor {
    public Vector2 v2Loc, v2Vel, v2Acc;
    Vector2 v2CurrentPos;
    float fmaxHeight;
    boolean canJump, isInAir;
    int nKeyCodeW = (int)'w';

    public SprHero(Texture tx, float _fX, float _fY){
        super(tx);
        v2Loc = new Vector2(_fX, _fY);
        v2Vel = new Vector2(0, 0);
        v2Acc = new Vector2(0, 0);
        v2CurrentPos = new Vector2(v2Loc);
        //setPosition(v2Loc.x, v2Loc.y);
        setSize(100, 100);
        setFlip(true, false);
        canJump = true;
        isInAir = false;
        v2CurrentPos.equals(v2Loc);
        fmaxHeight = v2CurrentPos.y + 100;

    }
    public void update()//Grouping Function
    {
        move();
        jump();
       // System.out.println(canJump);
    }

    void checkMove() {

    }

    void move() {
        v2Vel.add(v2Acc);
        v2Loc.add(v2Vel);
        setPosition(v2Loc.x, v2Loc.y);
        v2Vel.setZero();

        //Left Right Movement
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            //  System.out.println(v2Loc.x);
            v2Vel.x = -5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            // System.out.println(v2Loc.x);
            v2Vel.x = 5;
        }
    }

    void jump() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
        v2CurrentPos.equals(v2Loc);
        fmaxHeight = v2CurrentPos.y + 100;

       // canJump = true;
    }

        if (canJump == true) {

            if (Gdx.input.isKeyPressed(Input.Keys.W) && isInAir == false) {
                if (v2Loc.y < fmaxHeight)
                    v2Acc.y = 10;
                    isInAir = true;
            }

            }
            if (v2Loc.y >= fmaxHeight) {
                System.out.println("YEEEET");
                canJump = false;

            }
    }

    public void applyForce(Vector2 v) {
        Vector2 v2Copy = v.cpy();
        v2Acc.add(v2Copy);

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

