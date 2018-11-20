package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;

public class SprButton extends Sprite{
    int nX, nY, nW, nH;
    public Polygon plyButton;
    public SprButton(int _nX, int _nY, int _nW, int _nH, String sFile){
        super(new Texture(Gdx.files.internal(sFile)));
        nX = _nX;
        nY = _nY;
        nW = _nW;
        nH = _nH;
        setPosition(nX, nY);
        //setFlip(false, true);
        setSize(nW, nH);
        plyButton = new Polygon(new float[]{ nX,nY,
                nX + nW,nY,
                nX + nW,nY + nH,
                nX,nY + nH,
        });
        }

    //Thanks Ameer and Joel!!!!!!
    public boolean isMousedOver(){
        if(plyButton.contains(Gdx.input.getX(), Gdx.input.getY())){
            return true;
        }
        return false;
    }

}