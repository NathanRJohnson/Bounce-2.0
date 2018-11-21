package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class ObjPlatform extends SprObstacle {
    boolean isHitting;

    public ObjPlatform(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);

    }


    public void isHit(SprHero sHero) {
        isHitting = Intersector.overlapConvexPolygons(sHero.getPolygon(), plyObstacle);
       // if (!sHero.getJumpState()) {//Triggers only on initial touch
        System.out.println(isHitting);
            if (isHitting && !sHero.getJumpState()) {
                sHero.setCanJump(true);
                if (fY != 0) {
                    sHero.setPos(sHero.getPos().x, fY + sHero.getHeight() / 2 - 15);
                    sHero.setMaxHeight();
                } else {
                    sHero.setPos(sHero.getPos().x, sHero.getHeight() - 15);

                }
                sHero.setVel(sHero.getVel().x, 0);
            } else if (!isHitting) {
                sHero.setCanJump(false);
            }

        }
    }

//}