package cs.bounce.Objects;

import com.badlogic.gdx.math.Vector2;

public class ObjShiftingHazard extends SprObstacle {
    private char cRangeType;
    private float fStartRange, fEndRange;
    private int nDir = 0;
    private Vector2 v2Vel;

    public ObjShiftingHazard(String sFile, float _fX, float fY, float fW, float fH, float fRange, char _cRangeType) {
        super(sFile, _fX, fY, fW, fH);
        nType = 1;
        v2Vel = new Vector2(0, 0);
        cRangeType = _cRangeType;
        if (cRangeType == 'x') {
            fStartRange = _fX;
            fEndRange = fStartRange + fRange;
        } else if (cRangeType == 'y') {
            fStartRange = fY;
            fEndRange = fY + fRange;
        }
    }

    public void move() {
        setPosition(v2Pos.x, v2Pos.y);
        v2Pos.add(v2Vel);
        switch (cRangeType) {
            case 'x':
                if (v2Pos.x <= fStartRange) {
                    nDir = 1;
                }
                if (v2Pos.x >= fEndRange) {
                    nDir = 2;
                }

            case 'y':
                if (v2Pos.y <= fStartRange) {
                    nDir = 3;
                }
                if (v2Pos.y >= fEndRange) {
                    nDir = 4;
                }

        }
        if (nDir == 1)
            v2Vel.set(2, 0);
        if (nDir == 2)
            v2Vel.set(-2, 0);
        if (nDir == 3)
            v2Vel.set(0, 2);
        if (nDir == 4)
            v2Vel.set(0, -2);
    }

    public Vector2 getPos() {
        move();
        return v2Pos;
    }
}

