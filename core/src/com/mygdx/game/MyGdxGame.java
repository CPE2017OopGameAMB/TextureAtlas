package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private TextureAtlas textureAtlas, backIdle;
	private Animation animation, backIdleAnim;
	private float elapsedTime = 0f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("SpriteSheet\\myspritesheet.atlas"));
		backIdle = new TextureAtlas(Gdx.files.internal("SpriteSheet/backIdleSpritesheet.atlas"));
		animation = new Animation(1f/30f, textureAtlas.getRegions());
		backIdleAnim = new Animation(1f/30f, backIdle.getRegions());
	}

	@Override
	public void dispose()
	{
		batch.dispose();
		textureAtlas.dispose();
	}

	@Override
	public void render () {
		elapsedTime += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0);
		batch.draw(backIdleAnim.getKeyFrame(elapsedTime,true), 80, 0);
		batch.end();
	}
}
