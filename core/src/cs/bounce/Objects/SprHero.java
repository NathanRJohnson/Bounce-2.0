package cs.bounce.Objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SprHero extends Sprite implements InputProcessor {
    private Vector2 v2Loc, v2Vel, v2Acc;
    Vector2 v2CurrentPos, v2Gravity;
    float fmaxHeight;
    private boolean canJump;
    Rectangle rectLowerHalf;
    Polygon polyHero;


    public SprHero(Texture tx, float _fX, float _fY){
        super(tx);
        v2Loc = new Vector2(_fX, _fY);
        v2Vel = new Vector2(0, 0);
        v2Acc = new Vector2(0, 0);
        v2CurrentPos = new Vector2(v2Loc);
        v2Gravity = new Vector2(0,-1);

        setSize(100, 100);
        setFlip(true, false);
        setOrigin(v2Loc.x, v2Loc.y);
        canJump = true;
        v2CurrentPos.equals(v2Loc);
        fmaxHeight = v2CurrentPos.y + 100;
        polyHero = new Polygon(new float[] {0,0,0,0,0,0,0,0});

    }
    public void update()//Grouping Function
    {

        v2Vel.add(v2Acc);
        v2Loc.add(v2Vel);
        setPosition(v2Loc.x, v2Loc.y);
        polyHero.setVertices(new float[] {v2Loc.x, v2Loc.y,
                v2Loc.x +getWidth(), v2Loc.y,
                v2Loc.x +getWidth(), v2Loc.y + getHeight(),
                v2Loc.x, v2Loc.y + getHeight()});
        v2Vel.setZero();



        applyForce(v2Gravity);
       // System.out.println(canJump);
    }

    void checkMove() {

    }

    void move() {



        //Left Right Movement
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            //  System.out.println(v2Loc.x);
            v2Vel.x = -5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            // System.out.println(v2Loc.x);
            v2Vel.x = 5;
        }
    }

    void jump() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            v2CurrentPos.equals(v2Loc);
            fmaxHeight = v2CurrentPos.y + 40;

        }
        if (canJump == true) {

            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (v2Loc.y < fmaxHeight)
                    v2Acc.y = 18;

            }

            if (!Gdx.input.isKeyPressed(Input.Keys.W)){
                canJump = false;
            }

            if (v2Loc.y >= fmaxHeight) {
                canJump = false;

            }
        }
    }

    public void applyForce(Vector2 v) {
        Vector2 v2Copy = v.cpy();
        v2Acc.add(v2Copy);

    }

    public Vector2 getLoc() { return v2Loc; }

    public Vector2 getVel(){
        return v2Vel;
    }

    public void setVel(float x, float y){
        v2Vel.x = x;
        v2Vel.y = y;
    }

    public Vector2 getAcc(){
        return v2Acc;
    }

    public Polygon getPolygon(){
        return polyHero;
    }

    public boolean getJumpState(){
        return canJump;
    }

    public void setJumpState(boolean b){
        canJump = b;
    }



    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

