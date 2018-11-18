package cs.bounce.Objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class SprHero extends Sprite {
    private Vector2 v2Pos, v2Vel, v2Acc;
    private float fmaxHeight;
    private boolean canJump;

    public SprHero(Texture tx, float _fX, float _fY) {
        super(tx);
        v2Pos = new Vector2(_fX, _fY);
        setOrigin(_fX, _fY);
        setSize(100, 100);
        setFlip(true, false);
        v2Vel = new Vector2(0, 0);
        v2Acc = new Vector2(0, 0);

    }

    public void update() {
        setPosition(v2Pos.x, v2Pos.y);
        v2Pos.add(v2Vel);
        v2Vel.add(v2Acc);

    }


    public void applyForce(Vector2 v) {
        Vector2 v2Copy = v.cpy();
        v2Acc.add(v2Copy);

    }
    public Vector2 getV2Pos() {
        return v2Pos;
    }

    public Vector2 getV2Vel() {
        return v2Vel;
    }

    public Vector2 getV2Acc() {
        return v2Acc;
    }

    public void setV2Pos(Vector2 v) {
        v2Pos.equals(v);
    }

    public void setV2Pos(float x, float y) {
        v2Pos.x = x;
        v2Pos.y = y;
    }

    public void setV2Vel(Vector2 v) {
        v2Vel.equals(v);
    }

    public void setV2Vel(float x, float y) {
        v2Vel.x = x;
        v2Vel.y = y;
    }

    public void setV2Acc(Vector2 v) {
        v2Acc.equals(v);
    }

    public boolean getJumpState() {
        return canJump;
    }

    public void setCanJump(boolean b) {
        canJump = b;
    }

}

