package cs.bounce.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SprBackground extends Sprite {

    public SprBackground(Texture tx) {
        super(tx);
        int nWidth = 700, nHeight = 500;
        setSize(nWidth, nHeight);
        setPosition(0, 0);
    }
}