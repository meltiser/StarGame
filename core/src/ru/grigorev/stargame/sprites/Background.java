package ru.grigorev.stargame.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.grigorev.stargame.base.Sprite;
import ru.grigorev.stargame.math.Rect;

public class Background extends Sprite {
    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}
