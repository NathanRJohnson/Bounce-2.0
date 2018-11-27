package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class ObjPlatform extends SprObstacle {
    private static boolean isTopHitting, isBotHitting, isLeftHitting, isRightHitting;
    private boolean hitEdge = false;
    private Vector2 v2Normal = new Vector2(0, 1);
    public ObjPlatform(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);

    }


    public void isHit(SprHero sHero) {
        isTopHitting = Intersector.intersectSegmentPolygon(getTopRight(), getTopLeft(), sHero.getPolygon());
        isBotHitting = Intersector.intersectSegmentPolygon(getBotRight(), getBotLeft(), sHero.getPolygon());

        if (!sHero.getJumpState()) {
            if (isTopHitting) {
                if (fY != 0) {
                    sHero.setPos(sHero.getPos().x, fY + getHeight() - 15);
                    sHero.setMaxHeight();
                } else {
                    sHero.setPos(sHero.getPos().x, sHero.getHeight() - 15);

                }
                sHero.setVel(sHero.getVel().x, 0);
                sHero.setCanJump(true);
                hitEdge = false;
            }
        }
        if (isBotHitting){
            sHero.setCanJump(false);

            if (sHero.getVel().y > 0) {
                sHero.setVel(sHero.getVel().x, sHero.getVel().y * -1);
                sHero.setVel(sHero.getVel().x, sHero.getVel().y / 2);
            }
        }

        if (isRightHitting || isLeftHitting){
            if (hitEdge) {
                sHero.setVel(sHero.getVel().setZero());
                sHero.setPos(sHero.getX(),sHero.getY());
                hitEdge = false;
            }

            }
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
        if (isBotHitting){
          //  System.out.println("Hit Bot");
            return true;
        }
        if (isLeftHitting){
            System.out.println("Hit Left");
            return true;
        }
        if (isRightHitting){
            System.out.println("Hit Right");
            return true;
        }
        hitEdge = false;
        return false;
    }

}