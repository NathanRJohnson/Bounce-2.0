package cs.bounce.Objects;


import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;


public class ObjPlatform extends SprObstacle {
    private static boolean isTopHitting, isBotHitting, isLeftHitting, isRightHitting;


    public ObjPlatform(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);
        nType = 2;
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
    public Vector2 getPos(){
        Vector2 v2Pos = new Vector2(fX,fY);
        return v2Pos;
    }
}
