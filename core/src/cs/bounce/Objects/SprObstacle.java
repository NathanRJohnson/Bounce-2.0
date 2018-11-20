package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SprObstacle extends Sprite {
    private float fX, fY, fW, fH;
    private Polygon plyObstacle;

    public SprObstacle(String sFile, float _fX, float _fY, float _fW, float _fH) {
        super(new Texture(Gdx.files.internal(sFile)));
        fX = _fX;
        fY = _fY;
        setOrigin(fX, fY);
        setPosition(fX,fY);
        fW = _fW;
        fH = _fH;
        setSize(fW, fH);
        plyObstacle = new Polygon(new float[]{
                fX, fY, fX + fW, fY, fX + fW, fY + fH, fX, fY + fH
                //fX, fY + fH, fX + fW, fY + fH, fX + fW, fY, fX, fY
        });
    }

    public void isHit(Polygon pHero, SprHero sHero) {
        if (!sHero.getJumpState()) {


            if (Intersector.overlapConvexPolygons(pHero, plyObstacle)) {
                System.out.println("bing");
                sHero.setCanJump(true);
                sHero.setPos(sHero.getPos().x, plyObstacle.getY() + sHero.getHeight() - 15);
                sHero.setVel(sHero.getVel().x, 0);

            }
/*
            if (Intersector.intersectLinePolygon(getTopRight(), getTopLeft(), pHero)) {
                System.out.println("bing");
                sHero.setCanJump(true);
                sHero.setPos(sHero.getPos().x, plyObstacle.getY() + sHero.getHeight() - 15);
                sHero.setVel(sHero.getVel().x, 0);

            } */
        }
     }

    public Polygon getPolygon() {
        return plyObstacle;
    }

    public Vector2 getTopRight() {
        Vector2 v = new Vector2(fX + fW, fY + fH);
        return v;
    }

    public Vector2 getTopLeft() {
        Vector2 v = new Vector2(fX , fY + fH);
        return v;
    }

    public Vector2 getBotRight() {
        Vector2 v = new Vector2(fX + fW, fY);
        return v;
    }

    public Vector2 getBotLeft() {
        Vector2 v = new Vector2(fX, fY);
        return v;
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
