package ru.grigorev.stargame.sprites.buttons;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.grigorev.stargame.base.ActionListener;
import ru.grigorev.stargame.base.ScaledTouchUpButton;
import ru.grigorev.stargame.math.Rect;

public class ButtonExit extends ScaledTouchUpButton {

    public ButtonExit(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("btExit"), actionListener, 0.9f);
        setHeightProportion(0.15f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setTop(worldBounds.getTop());
        setRight(worldBounds.getRight());
    }
}
