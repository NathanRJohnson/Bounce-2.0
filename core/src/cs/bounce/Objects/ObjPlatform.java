package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class ObjPlatform extends SprObstacle {

    public ObjPlatform(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);

    }

    public void isHit(SprHero sHero) {
        if (!sHero.getJumpState()) {
            if (Intersector.overlapConvexPolygons(sHero.getPolygon(), plyObstacle)) {
                sHero.setCanJump(true);
                sHero.setPos(sHero.getPos().x, plyObstacle.getY() + sHero.getHeight() - 15);
                sHero.setVel(sHero.getVel().x, 0);

            }
        }
    }
}