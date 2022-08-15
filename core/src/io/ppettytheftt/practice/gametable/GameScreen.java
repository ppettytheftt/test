package io.ppettytheftt.practice.gametable;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


// Gamescreen is the main Class I think
public class GameScreen extends ScreenAdapter {

    private final String ID = getClass().getName();

    // variables
    private Game game;
    private SpriteBatch sb;
    private OrthographicCamera cam;

    private Texture texture;
    private Sprite sprite;

    //constructor
    public GameScreen(Game game) {
        this.game = game;

        Gdx.app.log(ID, "This class is loaded!");
    }

    // Game Loop
    @Override
    public void render(float deltaTime) {
        // buffer screen
        Gdx.gl20.glClearColor(11f /255.0f, 11f/255.0f, 11f/255.0f, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sb.setProjectionMatrix(cam.combined);

        // update
        sprite.rotate(1f);
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);

        // render things here
        sb.begin();
        sprite.draw(sb);
        sb.end();
    }

    // Methods
    @Override
    public void show() {
        sb = new SpriteBatch();
        cam = new OrthographicCamera();

        cam.setToOrtho(false, 5f, 5f);

        createGraphics();
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
        int width = 8;
        int height = 8;

        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        pixmap.drawRectangle(0, 0, width, height);

        // Texture
        texture = new Texture(pixmap);

        // Our sprite
        sprite = new Sprite(texture);
        sprite.setPosition(1f, 1f);
        sprite.setSize(.5f, .5f);

    }
}