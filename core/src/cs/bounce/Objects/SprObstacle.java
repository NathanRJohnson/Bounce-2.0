package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class SprObstacle extends Sprite {
  public float fX, fY, fW, fH;
  public Polygon plyObstacle;
  public String sFile;
  int nType;

  public SprObstacle(String _sFile, float _fX, float _fY, float _fW, float _fH) {
    super(new Texture(Gdx.files.internal(_sFile)));
    sFile = _sFile;
    fX = _fX;
    fY = _fY;
    setOrigin(fX, fY);
    setPosition(fX, fY);
    fW = _fW;
    fH = _fH;
    setSize(fW, fH);
    plyObstacle = new Polygon(new float[]{
            fX, fY,
            fX + fW, fY,
            fX + fW, fY + fH,
            fX, fY + fH
            //fX, fY + fH, fX + fW, fY + fH, fX + fW, fY, fX, fY
    });
  }
    public String getFile() {
        return sFile;
    }

    public Polygon getPolygon() {
        return plyObstacle;
    }

    public boolean isHit(SprHero s, SprObstacle o) {
        if (Intersector.overlapConvexPolygons(s.getPolygon(), o.getPolygon())) {
            s.handleHitType(getType(), o);
            return true;
        }
        return false;
    }

    public int getType() {
        return nType;
    }

  @Override
  public float getY() {
    return fY;
  }

  public Vector2 getBotLeft(){
    Vector2 v = new Vector2(fX, fY);
    return v;
  }

  public Vector2 getBotRight(){
    Vector2 v = new Vector2(fX + fW, fY);
    return v;
  }

  public Vector2 getTopRight(){
    Vector2 v = new Vector2(fX + fW, fY + fH);
    return v;
  }

  public Vector2 getTopLeft(){
    Vector2 v = new Vector2(fX, fY + fH);
    return v;
  }
}

