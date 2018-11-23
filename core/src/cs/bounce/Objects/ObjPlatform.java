package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class ObjPlatform extends SprObstacle {
    private static boolean isHitting;
    private Vector2 v2Normal = new Vector2(0, 1);

    public ObjPlatform(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);

    }


    public void isHit(SprHero sHero) {
        // isHitting = Intersector.overlapConvexPolygons(sHero.getPolygon(), plyObstacle);
        //  System.out.println("yuh");
        if (!sHero.getJumpState()) {
            if (checkHit(sHero)) {
                System.out.println("GUEHGUHGUEGU");
                if (fY != 0) {
                    sHero.setPos(sHero.getPos().x, fY + sHero.getHeight() / 2 - 15);
                    sHero.setMaxHeight();
                } else {
                    sHero.setPos(sHero.getPos().x, sHero.getHeight() - 15);

                }
                sHero.setVel(sHero.getVel().x, 0);
                sHero.setCanJump(true);
            }
        }
/*
        else if (sHero.getJumpState()) {
            if (!checkHit(sHero)){
                sHero.setCanJump(false);
            }
        }
*/
    }

    public boolean checkHit(SprHero sHero) {
        isHitting = Intersector.overlapConvexPolygons(sHero.getPolygon(), plyObstacle);
        if (isHitting) {
            System.out.println("Hit");
            return true;
        }

        return false;
    }

}