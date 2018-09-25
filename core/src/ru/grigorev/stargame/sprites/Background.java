package ru.grigorev.stargame.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.grigorev.stargame.base.Sprite;
import ru.grigorev.stargame.math.Rect;


public class Background extends Sprite {
    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        setWidth(worldBounds.getWidth());
        pos.set(worldBounds.pos);
    }
}
