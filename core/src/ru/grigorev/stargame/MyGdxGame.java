package ru.grigorev.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture backgroundImg;

	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundImg = new Texture("background.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(backgroundImg,0,0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		backgroundImg.dispose();
	}
}
