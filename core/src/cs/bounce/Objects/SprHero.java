package cs.bounce.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import cs.bounce.Menu.GamMain;
import cs.bounce.Screens.ScrLevels;

public class SprHero extends Sprite {
    private Vector2 v2Pos, v2Vel, v2Acc, v2Start;
    private float fX, fY;
    private int fW = 100, fH = 100, nHitState;
    private float fMaxHeight;
    private boolean canJump = false;
    private Polygon plyHero;

    public SprHero(Texture tx, float _fX, float _fY) {
        super(tx);
        fX = _fX;
        fY = _fY;
        v2Pos = new Vector2(fX, fY);
        setOrigin(fX, fY);
        setSize(fW, fH);
        setFlip(true, false);
        v2Vel = new Vector2(0, 0);
        v2Acc = new Vector2(0, 0);
        fMaxHeight = v2Pos.y + 40;
        plyHero = new Polygon(new float[]{0, 0, 0, 0, 0, 0, 0, 0});

    }

    public void update() {
        plyHero.setVertices(new float[]{v2Pos.x + 25, v2Pos.y + 15,
                v2Pos.x + 80, v2Pos.y + 15,
                v2Pos.x + 80, v2Pos.y + 80,
                v2Pos.x + 25, v2Pos.y + 80});
        setPosition(v2Pos.x, v2Pos.y);
        v2Pos.add(v2Vel);
        v2Vel.add(v2Acc);
        v2Acc.setZero();

    }

    public void getHitType(int nHitType, SprObstacle o) {
        switch (nHitType) {
            case 0:

            case 1: die(o);

            case 2: registerHit(o);
        }

    }

    public void die(SprObstacle o) {
        ObjFixedHazard h = new ObjFixedHazard(o.getFile(), o.getX(), o.getY(), o.getWidth(), o.getHeight());
        setPos(v2Start);
    }

    public void win(SprObstacle o){
        ObjObjective w = new ObjObjective(o.getFile(), o.getX(), o.getY(), o.getWidth(), o.getHeight());
        // need to change the screen
    }

    public void registerHit(SprObstacle o){
        ObjPlatform p = new ObjPlatform(o.getFile() ,o.getX(), o.getY(), o.getWidth(), o.getHeight());
        int n = p.sideCheck(plyHero);

        if (!canJump && n == 1) {
            if (p.getTopRight().y != 0){
                setPos(v2Pos.x, p.getTopRight().y - 15);
                setMaxHeight();
            } else{
                setPos(v2Pos.x, fH - 15);
            }
            setVel(v2Vel.x,0);
            canJump = true;
        }
        if (n == 2) {
            canJump = false;
            if (v2Vel.y > 0) {
                setVel(v2Vel.x, v2Vel.y / -2);
            }
        }
        if (n == 3){
            v2Vel.x = 0;
            setPos(v2Pos.x + 1,v2Pos.y);
        }
        if (n == 4) {
            v2Vel.x = 0;
            setPos(v2Pos.x - 1,v2Pos.y);
        }
    }

    public void applyForce(Vector2 v) {
        Vector2 v2Copy = v.cpy();
        v2Acc.add(v2Copy);

    }

    public Vector2 getPos() {
        return v2Pos;
    }

    public Vector2 getVel() {
        return v2Vel;
    }

    public Vector2 getAcc() {
        return v2Acc;
    }

    public void setPos(Vector2 v) {
        v2Pos.x = v.x;
        v2Pos.y = v.y;
    }

    public void setPos(float x, float y) {
        v2Pos.x = x;
        v2Pos.y = y;
    }

    public void setVel(Vector2 v) {
        v2Vel.equals(v);
    }

    public void setVel(float x, float y) {
        v2Vel.x = x;
        v2Vel.y = y;

    }

    public void setAcc(Vector2 v) {
        v2Acc.equals(v);
    }

    public void setAcc(float x, float y) {
        v2Acc.x = x;
        v2Acc.y = y;
    }

    public boolean getJumpState() {
        return canJump;
    }

    public void setCanJump(boolean b) {
        canJump = b;
    }

    public float getMaxheight() {
        return fMaxHeight;
    }

    public void setMaxHeight() {
        fMaxHeight = v2Pos.y + 140;
    }

    public Polygon getPolygon() {
        return plyHero;
    }

    public void setHitState(int n){
        nHitState = n;
    }

}


