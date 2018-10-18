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
    public SprFloor(Texture tx){
        super(tx);
        setSize(700,100);
        setPosition(0,-50);
        rctGround = new Rectangle(getBoundingRectangle());
        nState = 0;
    }

    public void floor(SprHero s)
    {

        if (s.getBoundingRectangle().overlaps(rctGround) && !Gdx.input.isKeyPressed((Input.Keys.W))){
            s.v2Loc.y = 45;
            s.canJump = true;
            s.isAirborn = false;
            s.isGrounded = true;
            if (s.v2Acc.y != 0) {
                s.v2Acc.setZero();

            }
            //   }
            //System.out.println("can i get uhh");
        } else if (s.getBoundingRectangle().overlaps(rctGround) && Gdx.input.isKeyPressed((Input.Keys.W)) && s.isAirborn == true ) {
            s.v2Loc.y = 45;
            s.canJump = true;
            s.isAirborn = false;
            s.isGrounded = true;
            if (s.v2Acc.y != 0) {
                s.v2Acc.setZero();

            }
        } else if(s.isGrounded == false){
            s.isAirborn = true;
            s.canJump = false;
        }

    }
}

