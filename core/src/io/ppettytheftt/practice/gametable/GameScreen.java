package io.ppettytheftt.practice.gametable;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.ppettytheftt.practice.entities.Enemy;
import io.ppettytheftt.practice.entities.Player;
import io.ppettytheftt.practice.entities.environment.SmallFire;


// Gamescreen is the main Class I think
public class GameScreen extends ScreenAdapter {

    private final String ID = getClass().getName();

    // variables
    private Game game;
    private SpriteBatch sb;
    private OrthographicCamera cam;


    private float runTime;

    // Entities
    private Player player;
    private Enemy enemy;
    private SmallFire small_fire;

    //constructor
    public GameScreen(Game game) {
        this.game = game;

        Gdx.app.log(ID, "This class is loaded!");
    }

    // Game Loop
    @Override
    public void render(float deltaTime) {
        // buffer screen
        Gdx.gl20.glClearColor(11f / 255.0f, 11f / 255.0f, 11f / 255.0f, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sb.setProjectionMatrix(cam.combined);

        // update
        update(deltaTime);


        // render things here
        sb.begin();
        player.render(sb);
        enemy.render(sb);
        small_fire.render(sb);
        sb.end();
    }

    // Methods
    @Override
    public void show() {
        sb = new SpriteBatch();
        cam = new OrthographicCamera();

        cam.setToOrtho(false, 5f, 5f);

        player = new Player();
        enemy = new Enemy(3.5f);
        small_fire = new SmallFire();
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
    private void update(float deltaTime) {
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
