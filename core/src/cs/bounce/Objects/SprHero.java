package cs.bounce.Objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
public class SprHero extends Sprite {
    public Vector2 v2Loc, v2Vel, v2Acc;
    Vector2 v2CurrentPos;
    int nJumpState;
    float fmaxHeight;

    public SprHero(Texture tx, float _fX, float _fY){
        super(tx);
        v2Loc = new Vector2(_fX, _fY);
        v2Vel = new Vector2(0, 0);
        v2Acc = new Vector2(0, 0);
        v2CurrentPos = new Vector2(v2Loc);
        nJumpState = 0;
        //setPosition(v2Loc.x, v2Loc.y);
        setSize(50, 50);
        setFlip(true, false);

    }
    public void Update()//Grouping Function
    {
        move();
        jump();
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

        System.out.println( nJumpState);
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            v2CurrentPos.equals(v2Loc);
            fmaxHeight = v2CurrentPos.y + 100;
            nJumpState = 1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)&& nJumpState == 1) {
            if (v2Loc.y < fmaxHeight)
                v2Acc.y = 10;

        }
        if (v2Loc.y >= fmaxHeight){
            nJumpState = 0;
            System.out.println("YEEEET");
        }
    }

    public void applyForce(Vector2 v) {
        Vector2 v2Copy = v.cpy();
        v2Acc.add(v2Copy);

    }
}

