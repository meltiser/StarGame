package ru.grigorev.stargame.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.grigorev.stargame.base.ActionListener;
import ru.grigorev.stargame.base.ScaledTouchUpButton;

/**
 * @author Dmitriy Grigorev
 */
public class MessageNewGame extends ScaledTouchUpButton {
    public MessageNewGame(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("button_new_game"), actionListener, 0.9f);
        setHeightProportion(0.07f);
        setBottom(-0.1f);
    }
}
