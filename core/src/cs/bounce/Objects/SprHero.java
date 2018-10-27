package cs.bounce.Objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SprHero extends Sprite implements InputProcessor {
    public Vector2 v2Loc, v2Vel, v2Acc;
    Vector2 v2CurrentPos, v2Gravity;
    float fmaxHeight;
    boolean canJump, isAirborn, isGrounded;
    Rectangle rectLowerHalf;


    public SprHero(Texture tx, float _fX, float _fY){
        super(tx);
        v2Loc = new Vector2(_fX, _fY);
        v2Vel = new Vector2(0, 0);
        v2Acc = new Vector2(0, 0);
        v2CurrentPos = new Vector2(v2Loc);
        v2Gravity = new Vector2(0,-1);
        //setPosition(v2Loc.x, v2Loc.y);
        setSize(100, 100);
        setFlip(true, false);
        canJump = true;
        isAirborn = false;
        isGrounded = false;
        v2CurrentPos.equals(v2Loc);
        fmaxHeight = v2CurrentPos.y + 100;
        //rectLowerHalf = new Rectangle(v2Loc.x, v2Loc.y - 50, 100,50 );

    }
    public void update()//Grouping Function
    {
        move();
        jump();
        applyForce(v2Gravity);
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
            fmaxHeight = v2CurrentPos.y + 40;
            isAirborn = true;
            isGrounded = false;

        }
        if (canJump == true) {

            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (v2Loc.y < fmaxHeight)
                    v2Acc.y = 18;

            }

            if (!Gdx.input.isKeyPressed(Input.Keys.W) && isAirborn == true){
                canJump = false;
            }

            if (v2Loc.y >= fmaxHeight) {
                canJump = false;
                isAirborn = true;

            }
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

