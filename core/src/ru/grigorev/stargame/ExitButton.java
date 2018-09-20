package ru.grigorev.stargame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.grigorev.stargame.base.Sprite;
import ru.grigorev.stargame.math.Rect;

/**
 * @author Dmitriy Grigorev
 */
public class ExitButton extends Sprite {
    public ExitButton(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setSize(0.08f,0.08f);
        pos.set(worldBounds.getWidth() * 0.40f, worldBounds.getHeight() * 0.41f);
    }
}
