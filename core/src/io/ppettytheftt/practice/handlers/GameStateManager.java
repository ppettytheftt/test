package io.ppettytheftt.practice.handlers;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.ppettytheftt.practice.gametable.GameTable;
import io.ppettytheftt.practice.states.PlayScreen;
import io.ppettytheftt.practice.states.TitleScreen;

public abstract class GameStateManager extends ScreenAdapter implements Constant {
    // vars
    protected SpriteBatch sb;
    protected OrthographicCamera camera, font_cam;
    protected GameTable game_table;

    public enum GameState {
        TITLE, START, GAME_OVER
    }
    protected GameState current_state;

    protected GameStateManager(GameTable game_table) {
        this.game_table = game_table;

        current_state = GameState.TITLE;
    }

    protected abstract void update(float deltaTime);

    //change screen method
    protected void changeScreen(GameState state) {
        if (state == GameState.TITLE){
            game_table.setScreen(new TitleScreen(game_table));
        } else if(state == GameState.START) {
            game_table.setScreen(new PlayScreen(game_table));
        }
    }
}
