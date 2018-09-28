package ru.grigorev.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.grigorev.stargame.base.Base2DScreen;
import ru.grigorev.stargame.math.Rect;
import ru.grigorev.stargame.sprites.Background;
import ru.grigorev.stargame.sprites.Spaceship;
import ru.grigorev.stargame.sprites.Star;


public class GameScreen extends Base2DScreen {

    private static final int STAR_COUNT = 32;

    Background background;
    Texture bg;
    TextureAtlas atlas;
    Spaceship spaceship;


    Star[] star;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("background2048.jpg");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        spaceship = new Spaceship(atlas);
        star = new Star[STAR_COUNT];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(atlas);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        checkCollisions();
        deleteAllDestroyed();
        draw();
    }

    public void update(float delta) {
        spaceship.update(delta);
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
    }

    public void checkCollisions() {

    }

    public void deleteAllDestroyed() {

    }

    public void draw() {
        Gdx.gl.glClearColor(1, 0.4f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        spaceship.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        batch.end();
    }

    @Override
    protected void resize(Rect worldBounds) {
        super.resize(worldBounds);
        spaceship.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        spaceship.touchDown(touch, pointer);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        spaceship.touchUp(touch, pointer);
        return super.touchUp(touch, pointer);
    }

    @Override
    public boolean keyDown(int keycode) {
        spaceship.keyDown(keycode);
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        spaceship.keyUp(keycode);
        return super.keyUp(keycode);
    }
}
