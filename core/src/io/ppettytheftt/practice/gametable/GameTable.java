package io.ppettytheftt.practice.gametable;

import com.badlogic.gdx.Game;

public class GameTable extends Game {

    @Override
    public void create(){
     setScreen(new GameScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
