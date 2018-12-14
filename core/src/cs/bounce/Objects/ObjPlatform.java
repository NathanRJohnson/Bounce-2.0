package cs.bounce.Objects;


import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;


public class ObjPlatform extends SprObstacle {
    private static boolean isTopHitting, isBotHitting, isLeftHitting, isRightHitting;

    public ObjPlatform(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);

    }

    public int sideCheck(Polygon p) {
        isTopHitting = Intersector.intersectSegmentPolygon(getTopRight(), getTopLeft(), p);
        isBotHitting = Intersector.intersectSegmentPolygon(getBotRight(), getBotLeft(), p);
        isLeftHitting = Intersector.intersectSegmentPolygon(getTopLeft(), getBotLeft(), p);
        isRightHitting = Intersector.intersectSegmentPolygon(getTopRight(), getBotRight(), p);

        if (isTopHitting)
            return 1;
        if (isBotHitting)
            return 2;
        if (isRightHitting)
            return 3;
        if (isLeftHitting)
            return 4;
        return -1;
    }


    public boolean checkHit(SprHero sHero) {
        //isHitting = Intersector.overlapConvexPolygons(sHero.getPolygon(), plyObstacle);
        isTopHitting = Intersector.intersectSegmentPolygon(getTopRight(), getTopLeft(), sHero.getPolygon());
        isBotHitting = Intersector.intersectSegmentPolygon(getBotRight(), getBotLeft(), sHero.getPolygon());
        isLeftHitting = Intersector.intersectSegmentPolygon(getTopLeft(), getBotLeft(), sHero.getPolygon());
        isRightHitting = Intersector.intersectSegmentPolygon(getTopRight(), getBotRight(), sHero.getPolygon());
        if (isTopHitting) {
            // System.out.println("Hit Top");
            return true;
        }
        if (isBotHitting) {
            //  System.out.println("Hit Bot");
            return true;
        }
        if (isLeftHitting) {

            return true;
        }
        if (isRightHitting) {

            return true;
        }
        return false;
    }

}