package ru.grigorev.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.grigorev.stargame.base.Base2DScreen;

/**
 * @author Dmitriy Grigorev
 */
public class MainScreen extends Base2DScreen {
    SpriteBatch batch;
    Texture backgroundTexture;
    Texture logo;
    Sprite backgroundSprite;
    Vector2 position;

    Vector2 speedVector;
    Vector2 positionTouched;
    boolean touched;

    public MainScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        backgroundTexture = new Texture("background2048.jpg");
        logo = new Texture("badlogic.jpg");
        backgroundSprite = new Sprite(backgroundTexture);
        //position = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        position = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        backgroundSprite.draw(batch);
        batch.draw(logo, position.x, position.y);
        batch.end();
        if (touched) {
            position.add(speedVector);
            //System.out.println("NOW IN x: " + position.x + " y: " + position.y);
            if (between(position.x, positionTouched.x - 1, positionTouched.x + 1)) {
                touched = false;
                //System.out.println("STOPED IN x: " + position.x + " y: " + position.y);
            }
        }
    }

    public boolean between(float num, float from, float to) {
        return (num >= from && num <= to);
    }

    @Override
    public void dispose() {
        logo.dispose();
        batch.dispose();
        backgroundTexture.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        positionTouched = new Vector2(screenX, Gdx.graphics.getHeight() - screenY);
        //System.out.println("TOUCHED x: " + positionTouched.x + " y: " + positionTouched.y);
        Vector2 direction = positionTouched.sub(position);
        Vector2 normalDirection = direction.nor();
        speedVector = normalDirection.scl(5);
        touched = true;

        return super.touchDown(screenX, screenY, pointer, button);
    }
}
