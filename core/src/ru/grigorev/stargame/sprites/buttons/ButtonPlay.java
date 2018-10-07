package ru.grigorev.stargame.sprites.buttons;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.grigorev.stargame.base.ActionListener;
import ru.grigorev.stargame.base.ScaledTouchUpButton;

public class ButtonPlay extends ScaledTouchUpButton {

    public ButtonPlay(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("btPlay"), actionListener, 0.9f);
        setHeightProportion(0.15f);
    }
}
