package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprObstacles extends Sprite {
    int nX, nY, nW, nH;

    public SprObstacles(int _nX, int _nY, int _nW, int _nH, String sFile) {
        super(new Texture(Gdx.files.internal(sFile)));
        nX = _nX;
        nY = _nY;
        nW = _nW;
        nH = _nH;
        setPosition(nX, nY);
        setFlip(false, true);
        setSize(nW, nH);
    }
}
