package cs.bounce.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprBackground extends Sprite {

    public SprBackground(Texture tx) {
        super(tx);
        int nWidth = 4000, nHeight = 2000;
        setSize(nWidth, nHeight);
        setPosition(-2500, -500);
    }
}
