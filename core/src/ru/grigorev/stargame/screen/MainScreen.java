package ru.grigorev.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.grigorev.stargame.Background;
import ru.grigorev.stargame.ExitButton;
import ru.grigorev.stargame.MovingLogo;
import ru.grigorev.stargame.base.Base2DScreen;
import ru.grigorev.stargame.math.Rect;

/**
 * @author Dmitriy Grigorev
 */
public class MainScreen extends Base2DScreen {
    Background background;
    ExitButton exitButton;
    MovingLogo logo;
    Texture logoTexture;
    Texture backgroundTexture;
    Texture exitButtonTexture;

    public MainScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        backgroundTexture = new Texture("background2048.jpg");
        exitButtonTexture = new Texture("exit.png");
        logoTexture = new Texture("badlogic.jpg");
        background = new Background(new TextureRegion(backgroundTexture));
        exitButton = new ExitButton(new TextureRegion(exitButtonTexture));
        logo = new MovingLogo(new TextureRegion(logoTexture));
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        logo.move();

        batch.begin();
        background.draw(batch);
        exitButton.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
        exitButton.resize(worldBounds);
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
        if (exitButton.isMe(touch)) {
            Gdx.app.exit();
        }
        return false;
    }
}
