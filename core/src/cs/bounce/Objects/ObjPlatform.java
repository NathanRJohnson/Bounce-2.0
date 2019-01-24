package cs.bounce.Objects;


import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;


public class ObjPlatform extends SprObstacle {
    private static boolean isTopHitting, isBotHitting, isLeftHitting, isRightHitting;


    public ObjPlatform(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);
        nType = 2;
    }


    public int sideCheck(Polygon p) { //https://libgdx.badlogicgames.com/ci/nightlies/docs/api/com/badlogic/gdx/math/Intersector.html
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
}
