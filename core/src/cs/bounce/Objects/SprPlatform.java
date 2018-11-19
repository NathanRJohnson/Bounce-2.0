package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegionLoader;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import javafx.scene.shape.Sphere;


public class SprPlatform extends Sprite {
    Rectangle rectTopPlatform, rectBotPlatform, rectPlatform;
    Boolean isTouchBottom;
    Polygon polyPlatform;
    Vector2 v2TopL, v2TopR, v2BotL, v2BotR;



    public SprPlatform(Texture tx, float fX, float fY, float fW, float fH) {
        super(tx);
        setSize(fW, fH);
        setPosition(fX, fY);
        isTouchBottom = false;
        v2TopL = new Vector2(fX, fY);
        v2TopR = new Vector2(fX + (fW), fY);
        v2BotL = new Vector2(fX, fY - fH);
        v2BotR = new Vector2(fX + (fW), fY - fH);
        polyPlatform = new Polygon(new float[]{
                fX, fY,             //top left
                fX + (fW), fY,      //top right
                fX + (fW), fY - fH, //bot right
                fX, fY - fH         //bot left
        });
     //   polyPlatform.setPosition(fX + 25, fY);
   //     polyPlatform.setOrigin((fX + 25) + fW / 2, fY - fH / 2);


    }

    public boolean isHit(SprHero h) {
        Polygon polyHero = new Polygon(new float[] { 0, 0, h.getWidth(), 0, h.getWidth(), h.getHeight(), 0, h.getHeight()});
        polyHero.setPosition(h.getLoc().x, h.getLoc().y);
        if (Intersector.intersectLinePolygon(v2TopR , v2TopL, polyHero) && Intersector.intersectLinePolygon(v2TopR , v2BotR, polyHero) && Intersector.intersectLinePolygon(v2TopL , v2BotL, polyHero)) {
            System.out.println("Hit");
            return true;
        }

        return false;
    }

   /* @Override
    public float[] getVertices(){
        float[] V = {v2TopL.x, v2TopL.y, v2TopR.x, v2TopR.y, v2BotR.x, v2BotR.y, v2BotL.x, v2BotL.y};
        return V;
    }*/

    public Polygon getPolygon(){
        return polyPlatform;
    }



  /*  public void hold(SprHero j) {
        if (j.getBoundingRectangle().overlaps(rectTopPlatform) && !Gdx.input.isKeyPressed((Input.Keys.W))) {
            System.out.println("overlapping");
            j.fmaxHeight = j.getLoc().y + 100;

            j.setJumpState(true);

            j.getLoc().y = (rectTopPlatform.getY() + 21);
            if (j.getAcc().y != 0)
                j.getAcc().setZero();

        } else if (j.getBoundingRectangle().overlaps(rectTopPlatform) && Gdx.input.isKeyPressed((Input.Keys.W)) && !j.getJumpState()) {
            j.fmaxHeight = j.getLoc().y + 100;

            j.setJumpState(true);

            j.getLoc().y = (rectTopPlatform.getY() + 21);
            if (j.getAcc().y != 0)
                j.getAcc().setZero();
        }

        if (j.getBoundingRectangle().overlaps(rectBotPlatform)) {
            System.out.println("eskidiaita");
            isTouchBottom = true;
            j.getAcc().y /= -1;
            j.setJumpState(false);
        } else {
            isTouchBottom = false;
        }

    } */

}
