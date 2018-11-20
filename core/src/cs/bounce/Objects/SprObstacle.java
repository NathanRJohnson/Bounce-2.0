package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SprObstacle extends Sprite {
  public float fX, fY, fW, fH;
  public Polygon plyObstacle;
  public SprObstacle(String sFile, float _fX, float _fY, float _fW, float _fH) {
    super(new Texture(Gdx.files.internal(sFile)));
    fX = _fX;
    fY = _fY;
    setOrigin(fX, fY);
    fW = _fW;
    fH = _fH;
    setSize(fW, fH);
    plyObstacle = new Polygon(new float[] {
            fX, fY, fX + fW,fY, fX + fW, fY + fH, fX, fY +fH
            //fX, fY + fH, fX + fW, fY + fH, fX + fW, fY, fX, fY
    });
  }

  public Polygon getPolygon(){ return plyObstacle;}


  //Used for walls, platforms etc. (it stops the heros movement)

  //Used for harmful obstacles such as spikes (eventually this will trigger his death)
  public boolean isKilled(SprHero s) {
     /*  if (s.getBoundingRectangle().overlaps(rctDeathbox)) {
           System.out.println("You dead");
           return true;
       } else {*/
    return false;
  }
}
//}

