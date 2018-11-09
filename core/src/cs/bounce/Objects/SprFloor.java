package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class SprFloor extends Sprite {
    Rectangle rctGround;
    public int nState;

    public SprFloor(Texture tx) {
        super(tx);
        setSize(700, 100);
        setPosition(0, -50);
        rctGround = new Rectangle(getBoundingRectangle());
        nState = 0;
    }

    public void floor(SprHero s) {

        if (s.getBoundingRectangle().overlaps(rctGround) && !Gdx.input.isKeyPressed((Input.Keys.W))) {
            s.getLoc().y = 45;
            s.setJumpState(true);
            if (s.getAcc().y != 0) {
                s.getAcc().setZero();

            }

        } else if (s.getBoundingRectangle().overlaps(rctGround) && Gdx.input.isKeyPressed((Input.Keys.W)) && !s.getJumpState()) {
            s.getLoc().y = 45;
            s.setJumpState(true);
            if (s.getAcc().y != 0) {
                s.getAcc().setZero();

            }
        }
    }
}




