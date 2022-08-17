package io.ppettytheftt.practice.gametable;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import io.ppettytheftt.practice.handlers.Assets;
import io.ppettytheftt.practice.states.TitleScreen;

public class GameTable extends Game {

    @Override
    public void create(){
        Assets.portal.load(new AssetManager());
        setScreen(new TitleScreen(this));

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        Assets.portal.dispose();
        super.dispose();
    }
}
