package io.ppettytheftt.practice.gametable;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import io.ppettytheftt.practice.handlers.Assets;
import io.ppettytheftt.practice.states.TitleScreen;

public class GameTable extends Game {

    @Override
    public void create(){
        Assets.portal.load(new AssetManager());
        setScreen(new TitleScreen(this));
    }

    @Override
    public void dispose() {
        Assets.portal.dispose();
        super.dispose();
    }
}
