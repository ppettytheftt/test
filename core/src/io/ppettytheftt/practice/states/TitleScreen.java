package io.ppettytheftt.practice.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.ppettytheftt.practice.gametable.GameTable;
import io.ppettytheftt.practice.handlers.Assets;
import io.ppettytheftt.practice.handlers.GameStateManager;

public class TitleScreen extends GameStateManager {
    // this is the title screen

    //vars
    private BitmapFont titleScreenFont;

    // constructor
    public TitleScreen(GameTable game_table) {
        super(game_table);
    }

    @Override
    public void show() {
        sb = new SpriteBatch();
        font_cam = new OrthographicCamera();
        font_cam.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
        titleScreenFont = Assets.portal.getTitleFont();
    }

    @Override
    public void update(float deltaTime) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            changeScreen(GameState.START);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.D)){
            Assets.portal.getBgm().play();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S)){
            Assets.portal.getBgm().pause();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void render(float deltaTime) {
        // buffer screen
        Gdx.gl20.glClearColor(11f / 255.0f, 11f / 255.0f, 11f / 255.0f, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.setProjectionMatrix(font_cam.combined);

        update(deltaTime);

        sb.begin();
        titleScreenFont.draw(sb, "A Game By: Lovealeggies", 125f, 350f);
        sb.end();
    }
}
