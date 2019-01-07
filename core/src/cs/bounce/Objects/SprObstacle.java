package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class SprObstacle extends Sprite {
    float fX, fY, fW, fH;
    Polygon plyObstacle;
    String sFile;
    int nType;
    Vector2 v2Pos, v2Vel;

    public SprObstacle(String _sFile, float _fX, float _fY, float _fW, float _fH) {
        super(new Texture(Gdx.files.internal(_sFile)));
        sFile = _sFile;
        fX = _fX;
        fY = _fY;
        v2Pos = new Vector2(fX, fY);
        v2Vel = new Vector2(0, 0);
        setOrigin(fX, fY);
        setPosition(fX, fY);
        fW = _fW;
        fH = _fH;
        setSize(fW, fH);
        plyObstacle = new Polygon(new float[]{ 0,0,0,0,0,0,0,0
                //fX, fY + fH, fX + fW, fY + fH, fX + fW, fY, fX, fY
        });
    }

    public String getFile() {
        return sFile;
    }

    public Polygon getPolygon() {
        return plyObstacle;
    }

    public Vector2 getPos() {
        return v2Pos;
    }

    public boolean isHit(SprHero s, SprObstacle o) {
        if (Intersector.overlapConvexPolygons(s.getPolygon(), o.getPolygon())) {
            s.getHitType(getType(), o);
            return true;
        }
        return false;
    }

    public void move() {
        plyObstacle.setVertices(new float[] {
                v2Pos.x, v2Pos.y,
                v2Pos.x + fW, v2Pos.y,
                v2Pos.x + fW, v2Pos.y + fH,
                v2Pos.x, v2Pos.y + fH});
    }

    public int getType() {
        return nType;
    }

    @Override
    public float getY() {
        return fY;
    }

    public Vector2 getBotLeft() {
        Vector2 v = new Vector2(fX, fY);
        return v;
    }

    public Vector2 getBotRight() {
        Vector2 v = new Vector2(fX + fW, fY);
        return v;
    }

    public Vector2 getTopRight() {
        Vector2 v = new Vector2(fX + fW, fY + fH);
        return v;
    }

    public Vector2 getTopLeft() {
        Vector2 v = new Vector2(fX, fY + fH);
        return v;
    }
}

