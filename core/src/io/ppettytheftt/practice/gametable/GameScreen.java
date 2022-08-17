package io.ppettytheftt.practice.gametable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import io.ppettytheftt.practice.entities.Enemy;
import io.ppettytheftt.practice.entities.Player;
import io.ppettytheftt.practice.entities.environment.SmallFire;
import io.ppettytheftt.practice.entities.weapons.Bullet;
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
    private Array<Enemy> enemy;
    private Array<Bullet> bullets;
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

        sb.setProjectionMatrix(camera.combined);

        // update
        update(deltaTime);


        // render things here
        sb.begin();
        player.render(sb);
        for (Enemy e : enemy) {
            e.render(sb);
        }
        for (Bullet b : bullets) {
            b.render(sb);
        }
        small_fire.render(sb);
        sb.setProjectionMatrix(font_cam.combined);

        sb.end();
    }


    // our update method
    @Override
    public void update(float deltaTime) {
        runTime += deltaTime;

        player.update(deltaTime);
        for (int i = 0; i < enemy.size; i++) {
            Enemy e = enemy.get(i);

            // update
            e.update(deltaTime);
            // remove method
            if (e.isRemove()) {
                enemy.removeIndex(i);
            }
        }
        // update bullets
        for (int i = 0; i < bullets.size; i++) {
            Bullet b = bullets.get(i);
            b.update(deltaTime);

            if (b.isRemove()) {
                bullets.removeIndex(i);
            }
        }

        small_fire.update(deltaTime);
        handleInput();
        checkCollision();
    }

    // Collision checking

    private void checkCollision() {
        // fire colliding
        for (int i = 0; i < enemy.size; i++) {
            Enemy e = enemy.get(i);

            // collision
            if (e.collide(player)) {
                // remove the fire
                e.setRemove(true);
                Gdx.app.log(ID, "They Collide!");
            }
        }
        //bullet -> enemy
        for (int j = 0; j < bullets.size; j++) {
            Bullet b = bullets.get(j);

            for (int i = 0; i < enemy.size; i++) {
                Enemy e = enemy.get(i);

                if (b.collide(e)) {
                    e.setRemove(true);
                    b.setRemove(true);
                }
            }
        }
    }


    // Methods
    // this is where we create our graphics
    @Override
    public void show() {
        sb = new SpriteBatch();
        camera = new OrthographicCamera();

        camera.setToOrtho(false, 5f, 5f);

        font_cam = new OrthographicCamera();
        font_cam.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);

        // game objects
        player = new Player();
        enemy = new Array<Enemy>();
        enemy.add(new Enemy(3.5f));
        small_fire = new SmallFire();
        bullets = new Array<Bullet>();

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

    private void createGraphics() {

    }

    //Handle Input
    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            bullets.add(new Bullet(player.getPos().x, player.getPos().y));

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
