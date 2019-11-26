package com.demo.game.handler;

import java.util.Stack;

import com.demo.game.main.Game;
import com.demo.game.state.GameState;
import com.demo.game.state.Menu;

public class GameStateManager {

	private Game game;
	
	private Stack<GameState> gameStates;
	
	private static final int PLAY = 911;
	
	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(PLAY);
	}
	
	public Game getGame() { return game; }
	
	public void update(float dt) {
		gameStates.peek().update(dt);
	}
	
	public void render() {
		gameStates.peek().render();
	}
	public void dispose () {
		while(!gameStates.empty())
			popState();
	}
	
	private GameState getState(int state) {
		if(state == PLAY) return new Menu(this);
		return null;
	}
	
	public void setState(int state) {
		popState();
		pushState(state);
	}

	private void popState() {
		GameState g = gameStates.pop();
		g.dispose();
	}

	private void pushState(int state) {
		// TODO Auto-generated method stub
		gameStates.push(getState(state));
	}
}
