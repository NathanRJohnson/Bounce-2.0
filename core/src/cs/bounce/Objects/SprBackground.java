package cs.bounce.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprBackground extends Sprite {

    public SprBackground(Texture tx) {
        super(tx);
        int nWidth = 3000, nHeight = 1500;
        setSize(nWidth, nHeight);
        setPosition(-1500, -350);
    }
}
