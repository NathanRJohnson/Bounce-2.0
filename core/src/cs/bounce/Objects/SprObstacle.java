package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SprObstacle extends Sprite {
    private int nX, nY, nW, nH;
    private Polygon plyObstacle;
    public SprObstacle(int _nX, int _nY, int _nW, int _nH, String sFile) {
        super(new Texture(Gdx.files.internal(sFile)));
        nX = _nX;
        nY = _nY;
        setOrigin(nX, nY);
        nW = _nW;
        nH = _nH;
        setSize(nW, nH);
        plyObstacle = new Polygon(new float[] {0,0,0,0,0,0,0,0});
    }


    //Used for walls, platforms etc. (it stops the heros movement)
    public boolean isHit(SprHero s) {


    return false;
    }

    //Used for harmful obstacles such as spikes (eventually this will trigger his death)
    public boolean isKilled(SprHero s) {
      /*  if (s.getBoundingRectangle().overlaps(rctDeathbox)) {
            System.out.println("You dead");
            return true;
        } else {*/
            return false;
        }
    }
//}
