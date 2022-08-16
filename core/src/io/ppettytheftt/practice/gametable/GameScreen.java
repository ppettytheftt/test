package io.ppettytheftt.practice.gametable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.ppettytheftt.practice.entities.Enemy;
import io.ppettytheftt.practice.entities.Player;
import io.ppettytheftt.practice.entities.environment.SmallFire;
import io.ppettytheftt.practice.handlers.Assets;
import io.ppettytheftt.practice.handlers.GameStateManager;


// Gamescreen is the main Class I think
public class GameScreen extends GameStateManager {

    private final String ID = getClass().getName();

    // variables
    private GameTable gameTable;
    private float runTime;

    // Entities
    private Player player;
    private Enemy enemy;
    private SmallFire small_fire;


    //constructor
    public GameScreen(GameTable gameTable) {
        super(gameTable);

        Gdx.app.log(ID, "This class is loaded!");
    }

    // Game Loop
    @Override
    public void render(float deltaTime) {
        // buffer screen
        Gdx.gl20.glClearColor(50f / 255.0f, 11f / 255.0f, 11f / 255.0f, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sb.setProjectionMatrix(cam.combined);

        // update
        update(deltaTime);


        // render things here
        sb.begin();
        player.render(sb);
        enemy.render(sb);
        small_fire.render(sb);
        sb.setProjectionMatrix(font_cam.combined);

        sb.end();
    }

    // Methods
    @Override
    public void show() {
        sb = new SpriteBatch();
        cam = new OrthographicCamera();

        cam.setToOrtho(false, 5f, 5f);

        font_cam = new OrthographicCamera();
        font_cam.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);

        // game objects
        player = new Player();
        enemy = new Enemy(3.5f);
        small_fire = new SmallFire();

        //Audio
        Assets.portal.getBgm().setVolume(.5f);
        Assets.portal.getBgm().play();

        Gdx.app.log(ID, "The game is running");
    }

    @Override
    public void pause() {
        Gdx.app.log(ID, "The game is paused..");
    }

    @Override
    public void resume() {
        Gdx.app.log(ID, "Game resumed!");
    }

    // this is where we create our graphics
    private void createGraphics() {

    }

    // our update method
    @Override
    public void update(float deltaTime) {
        runTime += deltaTime;

        player.update(deltaTime);
        enemy.update(deltaTime);
        small_fire.update(deltaTime);
        handleInput();
    }

    //Handle Input
    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {


        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            // add sound effect
            Assets.portal.getGlitchEffect().play();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {

        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }
}
