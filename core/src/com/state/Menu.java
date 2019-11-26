package com.demo.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.demo.game.handler.GameStateManager;

public class Menu extends GameState{

	private Texture img;
	private BitmapFont font;
	private long time;
	private long UPS;
	private long FPS;
	private long PrintUPS;
	private long PrintFPS;
	
	public Menu(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		time = System.nanoTime();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		UPS += 1;
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		long elapsed = (System.nanoTime() - time) / 1000000;
		font.draw(sb, "height:"+vp.getScreenHeight(), 200, 100);
		font.draw(sb, "width:"+vp.getScreenWidth(), 200, 200);
		font.draw(sb, "UPS:"+PrintUPS , 100, 100);
		font.draw(sb, "FPS:"+PrintFPS, 100, 200);
		FPS += 1;
		if(elapsed > 1000) {
			time = System.nanoTime();
			PrintUPS = UPS;
			PrintFPS = FPS;
			FPS = 0;
			UPS = 0;
		}
		sb.end();
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		sb.dispose();
		img.dispose();
	}

}
