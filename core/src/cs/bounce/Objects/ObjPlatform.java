package cs.bounce.Objects;


import com.badlogic.gdx.math.Intersector;


public class ObjPlatform extends SprObstacle {
    private static boolean isTopHitting, isBotHitting, isLeftHitting, isRightHitting;

    public ObjPlatform(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);

    }


    public void isHit(SprHero sHero) {
        isTopHitting = Intersector.intersectSegmentPolygon(getTopRight(), getTopLeft(), sHero.getPolygon());
        isBotHitting = Intersector.intersectSegmentPolygon(getBotRight(), getBotLeft(), sHero.getPolygon());
        isLeftHitting = Intersector.intersectSegmentPolygon(getTopLeft(), getBotLeft(), sHero.getPolygon());
        isRightHitting = Intersector.intersectSegmentPolygon(getTopRight(), getBotRight(), sHero.getPolygon());

        if (!sHero.getJumpState()) {
            if (isTopHitting) {
                if (fY != 0) {
                    sHero.setPos(sHero.getPos().x, fY + getHeight() - 15);
                    sHero.setMaxHeight();
                } else {
                    sHero.setPos(sHero.getPos().x, sHero.getHeight() - 15);

                }
                System.out.println("Hit Top");
                sHero.setVel(sHero.getVel().x, 0);
                sHero.setCanJump(true);
            }
        }
        if (isBotHitting) {
            sHero.setCanJump(false);
            System.out.println("Hit Bottom");
            if (sHero.getVel().y > 0) {
                sHero.setVel(sHero.getVel().x, sHero.getVel().y * -1);
                sHero.setVel(sHero.getVel().x, sHero.getVel().y / 2);
            }
        }

        if (isRightHitting || isLeftHitting) {
            if (!isTopHitting) {
                sHero.setVel(0, sHero.getVel().y);
                if (isRightHitting) {
                    System.out.println("Hit Left");
                    sHero.setPos(sHero.getX() + 1, sHero.getPos().y);
                }
                if (isLeftHitting) {
                    System.out.println("Hit Right");
                    sHero.setPos(sHero.getX() - 1, sHero.getPos().y);
                }
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
