package com.demo.game.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.demo.game.handler.GameStateManager;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	private GameStateManager gsm;
	
	private static final float STEP = 1/60f;
	private float accum;
	
	private SpriteBatch sb;
	private OrthographicCamera cam;
	private OrthographicCamera hudCam;
	private Viewport vp;
	public static final String TITLE = "Game";
	public static final float V_RATIO = 16f/9f;
	public static final int V_HEIGHT = 720;
	public static final int V_WIDTH = (int)(V_HEIGHT * V_RATIO);
	public static final float SCALE = 1f;
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		cam = new OrthographicCamera();
		cam.setToOrtho(false,V_WIDTH,V_HEIGHT);
		hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false,V_WIDTH,V_HEIGHT);
		vp = new ScreenViewport(cam);
		gsm = new GameStateManager(this);
	}

	@Override
	public void resize (int width, int height) {
		super.resize(width, height);
		vp.update(width, height);
	}
	
	
	@Override
	public void render () {
		accum += Gdx.graphics.getDeltaTime();
		while(accum >= STEP) {
			accum -= STEP;
			gsm.update(STEP);
		}
		gsm.render();
	}
	
	@Override
	public void dispose () {
		gsm.dispose();
	}
	
	public SpriteBatch getSpriteBatch() {
		return sb;
	}
	public OrthographicCamera getCamera() {
		return cam;
	}
	public OrthographicCamera getHudCam() {
		return hudCam;
	}
	public Viewport getViewPort() {
		return vp;
	}
}
