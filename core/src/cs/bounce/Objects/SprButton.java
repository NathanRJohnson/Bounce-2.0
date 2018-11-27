package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;

public class SprButton extends Sprite{
    int nX, nY, nW, nH;
    private Polygon plyButton;
    public SprButton(int _nX, int _nY, int _nW, int _nH, String sFile){
        super(new Texture(Gdx.files.internal(sFile)));
        nX = _nX;
        nY = _nY;
        nW = _nW;
        nH = _nH;
        setPosition(nX, nY);
        //setFlip(false, false);
        setSize(nW, nH);
        plyButton = new Polygon(new float[]{ nX,nY,
                nX + nW,nY,
                nX + nW,nY + nH,
                nX,nY + nH,
        });
        }

    //Thanks Ameer and Joel!!!!!!
    public boolean isMousedOver(){
        int nMouseY;
        nMouseY = 480 - Gdx.input.getY();
        if(plyButton.contains(Gdx.input.getX(), nMouseY)){
            return true;
        }
        return false;
    }

    public Polygon getPlyButton() {
        return plyButton;
    }
}