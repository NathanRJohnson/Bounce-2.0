package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SprObstacle extends Sprite {
    int nX, nY, nW, nH;
    Vector2 v2PrevLoc;
    Rectangle rctHitbox;
    public SprObstacle(int _nX, int _nY, int _nW, int _nH, String sFile) {
        super(new Texture(Gdx.files.internal(sFile)));
        v2PrevLoc = new Vector2(0, 0);
        nX = _nX;
        nY = _nY;
        nW = _nW;
        nH = _nH;
        setPosition(nX, nY);
        setFlip(false, true);
        setSize(nW, nH);
        rctHitbox = new Rectangle(getBoundingRectangle());
    }


    //Used for walls, platforms etc. (it stops the heros movement)
    public void isHit(SprHero s) {

        if (s.getBoundingRectangle().overlaps(rctHitbox)) {

            System.out.println("There is a wall here");
            s.getLoc().x = v2PrevLoc.x;
        } else {
            v2PrevLoc = s.getLoc().cpy();
        }
    }

    //Used for harmful obstacles such as spikes (eventually this will trigger his death)
    public boolean isKilled(SprHero s) {
        if (s.getBoundingRectangle().overlaps(rctHitbox)) {
            System.out.println("You dead");
            return true;
        } else {
            return false;
        }
    }

}
