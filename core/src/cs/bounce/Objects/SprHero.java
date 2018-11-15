package cs.bounce.Objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class SprHero extends Sprite {
    private Vector2 v2Loc, v2Vel, v2Acc;
    Vector2 v2CurrentPos, v2Gravity;
    float fmaxHeight;
    boolean canJump, isAirborn;

    public SprHero(Texture tx, float _fX, float _fY){
        super(tx);
        v2Loc = new Vector2(_fX, _fY);
        v2Vel = new Vector2(0, 0);
        v2Acc = new Vector2(0, 0);
        v2CurrentPos = new Vector2(v2Loc);
        v2Gravity = new Vector2(0,-1);
        //setPosition(v2Loc.x, v2Loc.y);
        setSize(100, 100);
        setFlip(true, false);
        canJump = true;
        isAirborn = false;
        v2CurrentPos.equals(v2Loc);
        fmaxHeight = v2CurrentPos.y + 100;

    }
    public void update()//Grouping Function
    {
        applyForce(v2Gravity);
        v2Vel.add(v2Acc);
        v2Loc.add(v2Vel);
        setPosition(v2Loc.x, v2Loc.y);
        v2Vel.setZero();
        //System.out.println(v2Loc.x +" "+ v2Loc.y);
        v2CurrentPos.equals(v2Loc);
       // System.out.println(canJump);
    }


    public void move() {

        /*
            if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {

                v2CurrentPos.equals(v2Loc);
                fmaxHeight = v2CurrentPos.y + 40;
                isAirborn = true;

            }
            if (canJump == true) {

                if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                    if (v2Loc.y < fmaxHeight)
                        v2Acc.y = 18;
                }

                if (!Gdx.input.isKeyPressed(Input.Keys.W) && isAirborn == true) {
                    canJump = false;
                }

                if (v2Loc.y >= fmaxHeight) {
                    canJump = false;
                    isAirborn = true;
                }
            }
            */
        }


    public void applyForce(Vector2 v) {
        Vector2 v2Copy = v.cpy();
        v2Acc.add(v2Copy);
    }
    //Accessors

    public Vector2 getLoc() {
        return v2Loc;
    }

    public Vector2 getVel(){
        return v2Vel;
    }

    public Vector2 getAcc(){
        return v2Acc;
    }

    public Vector2 getv2CurrentPos(){ return v2CurrentPos; }

    public boolean getcanJump() { return canJump; }

    public void setVel(float x, float y){
        v2Vel.x = x;
        v2Vel.y = y;
    }


  /*  public Vector2 set(Vector2 v){

       Vector2 vNew;

       return vNew;
    }*/

}

