package ru.grigorev.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.grigorev.stargame.sprites.Background;
import ru.grigorev.stargame.sprites.MyExitButton;
import ru.grigorev.stargame.sprites.MovingLogo;
import ru.grigorev.stargame.base.Base2DScreen;
import ru.grigorev.stargame.math.Rect;

/**
 * @author Dmitriy Grigorev
 */
public class MyScreen extends Base2DScreen {
    Background background;
    MyExitButton myExitButton;
    MovingLogo logo;
    Texture logoTexture;
    Texture backgroundTexture;
    Texture exitButtonTexture;

    public MyScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        backgroundTexture = new Texture("background2048.jpg");
        exitButtonTexture = new Texture("exit.png");
        logoTexture = new Texture("badlogic.jpg");
        background = new Background(new TextureRegion(backgroundTexture));
        myExitButton = new MyExitButton(new TextureRegion(exitButtonTexture));
        logo = new MovingLogo(new TextureRegion(logoTexture));
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        logo.move();

        batch.begin();
        background.draw(batch);
        myExitButton.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
        myExitButton.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        exitButtonTexture.dispose();
        logoTexture.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        logo.setTouch(touch);
        if (myExitButton.isMe(touch)) {
            Gdx.app.exit();
        }
        return false;
    }
}
