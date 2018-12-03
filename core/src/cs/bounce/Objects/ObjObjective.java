package cs.bounce.Objects;

import com.badlogic.gdx.math.Intersector;

public class ObjObjective extends SprObstacle {

    public ObjObjective(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);


    }

    public boolean isHit(SprHero sprHero) {
        if (Intersector.overlapConvexPolygons(sprHero.getPolygon(), plyObstacle))
            return true;
        return false;
    }
}
