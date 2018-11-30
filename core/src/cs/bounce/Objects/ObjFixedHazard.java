package cs.bounce.Objects;

import com.badlogic.gdx.math.Intersector;

import java.awt.*;

public class ObjFixedHazard extends SprObstacle {

    public ObjFixedHazard(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);

    }

    public boolean isHit(SprHero sHero) {
        if (Intersector.overlapConvexPolygons(sHero.getPolygon(), plyObstacle))
            return true;
        return false;
    }
}
