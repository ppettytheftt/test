package io.ppettytheftt.practice.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.ppettytheftt.practice.entities.environment.SmallFire;
import io.ppettytheftt.practice.gametable.GameTable;
import io.ppettytheftt.practice.handlers.Assets;
import io.ppettytheftt.practice.handlers.GameStateManager;

public class PlayScreen extends GameStateManager {
    private final String ID = getClass().getName();

    private OrthogonalTiledMapRenderer renderer;
    private SmallFire smallFire;

    private float runtime;

    FitViewport viewport;


    public PlayScreen(GameTable gameTable) {

        super(gameTable);

        Gdx.app.log(ID, "This class has loaded!");
    }

    @Override
    public void show() {
        sb = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
        viewport = new FitViewport(GAME_WIDTH, GAME_HEIGHT, camera);
        renderer = new OrthogonalTiledMapRenderer(Assets.portal.getTestRoom());

        smallFire = new SmallFire();
    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl20.glClearColor(11f / 255.0f, 11f / 255.0f, 11f / 255.0f, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(deltaTime);

        renderer.setView((OrthographicCamera) viewport.getCamera());
        sb.begin();
        renderer.render();

        smallFire.render(sb);
        sb.setProjectionMatrix(viewport.getCamera().combined);
        sb.end();
    }

    @Override
    protected void update(float deltaTime) {
        camera.update();
        smallFire.update(deltaTime);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.translate(-3, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.translate(3, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.translate(0, -3, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.translate(0, 3, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        sb.dispose();
        renderer.dispose();
    }
}
