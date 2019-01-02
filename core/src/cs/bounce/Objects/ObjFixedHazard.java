package cs.bounce.Objects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;


public class ObjFixedHazard extends SprObstacle {

    public ObjFixedHazard(String sFile, float fX, float fY, float fW, float fH) {
        super(sFile, fX, fY, fW, fH);
        nType = 1;
    }
    public Vector2 getPos(){
        Vector2 v2Pos = new Vector2(fX,fY);
        return v2Pos;
    }
}
