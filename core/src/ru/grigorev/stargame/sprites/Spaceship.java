package ru.grigorev.stargame.sprites;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.grigorev.stargame.base.Sprite;
import ru.grigorev.stargame.math.Rect;

/**
 * @author Dmitriy Grigorev
 */
public class Spaceship extends Sprite {
    Vector2 v;
    Rect worldBounds;

    public Spaceship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship_1"));
        setHeightProportion(0.15f);
        v = new Vector2(0f, 0f);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        checkAndHandleBounds();
        super.update(delta);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setBottom(worldBounds.getBottom() + 0.05f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if (touch.x > 0) v.add(1f, 0f);
        else v.add(-1f, 0f);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        v.set(0f, 0f);
        return super.touchUp(touch, pointer);
    }

    public void keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) v.add(-1f, 0f);
        if (keycode == Input.Keys.RIGHT) v.add(1f, 0f);
    }


    public void keyUp(int keycode) {
        v.set(0f, 0f);
    }

    private void checkAndHandleBounds() {
        if (getLeft() < worldBounds.getLeft()) setLeft(worldBounds.getLeft());
        if (getRight() > worldBounds.getRight()) setRight(worldBounds.getRight());
    }
}
