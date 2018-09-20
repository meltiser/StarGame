package ru.grigorev.stargame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.grigorev.stargame.base.Sprite;
import ru.grigorev.stargame.math.Rect;

/**
 * @author Dmitriy Grigorev
 */
public class MovingLogo extends Sprite {
    public Vector2 touch;
    public Vector2 speed;
    public Vector2 buffer;

    public MovingLogo(TextureRegion region) {
        super(region);
        touch = new Vector2(0f, 0f);
        speed = new Vector2(0f, 0f);
        buffer = new Vector2(0f, 0f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setSize(0.2f, 0.2f);
    }

    public void move() {
        buffer.set(touch);
        if (buffer.sub(pos).len() > 0.01f) {
            pos.add(speed);
        } else {
            pos.set(touch);
        }
    }

    public void setTouch(Vector2 touch) {
        this.touch.set(touch);
        speed.set(this.touch.cpy().sub(pos).setLength(0.01f));
    }
}
