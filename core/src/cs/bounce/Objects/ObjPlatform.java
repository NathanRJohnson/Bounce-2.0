package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class ObjPlatform extends SprObstacle {
    private static boolean isHitting;

    public ObjPlatform(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);

    }

    public static boolean getIsHitting() {
        return isHitting;
    }

    public static void setIsHitting(boolean b) {
        isHitting = b;
    }


    public void isHit(SprHero sHero) {
        System.out.println(Intersector.overlapConvexPolygons(sHero.getPolygon(), plyObstacle));
            if (Intersector.overlapConvexPolygons(sHero.getPolygon(), plyObstacle)) {
                sHero.setCanJump(true);
                if (fY != 0) {
                    sHero.setPos(sHero.getPos().x, fY + sHero.getHeight() / 2 - 15);
                    sHero.setMaxHeight();
                } else {
                    sHero.setPos(sHero.getPos().x, sHero.getHeight() - 15);

                }
                sHero.setVel(sHero.getVel().x, 0);

            } else {
                sHero.setCanJump(false);
            }
        }

    }