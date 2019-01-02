package cs.bounce.Objects;

import com.badlogic.gdx.math.Vector2;

public class ObjShiftingHazard extends SprObstacle {
    private char cRangeType;
    private float fStartRange, fEndRange;
    private int nDir;
    private Vector2 v2Vel;

    public ObjShiftingHazard(String sFile, float fX, float fY, float fW, float fH, float fRange, char _cRangeType) {
        super(sFile, fX, fY, fW, fH);
        nType = 1;
        v2Vel = new Vector2(0,0);
        cRangeType = _cRangeType;
        if (cRangeType == 'x') {
            fStartRange = fX;
            fEndRange = fX + fRange;
        } else if (cRangeType == 'y') {
            fStartRange = fY;
            fEndRange = fY + fRange;
        }


    }

    public void update() {
        switch (cRangeType) {

            case 'x':
                if (fX == fStartRange){
                 nDir = 1;
                } else if (fX == fEndRange){
                nDir = 2;
            }

            case 'y':
                if (fY == fStartRange){
                    nDir = 3;
                } else if (fY == fEndRange){
                    nDir = 4;
                }

        }
        switch (nDir){
            case 1: v2Vel.set(2,0);
            case 2: v2Vel.set(-2,0);
            case 3: v2Vel.set(0,2);
            case 4: v2Vel.set(0,-2);
        }
    }


}
