package io.ppettytheftt.practice.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.ppettytheftt.practice.handlers.GameObject;

public class Player extends GameObject {
    //vars

    //constructor
    public Player() {
        pos.x = 1f;
        pos.y = 1f;
        dim.x = .5f;
        dim.y = .5f;

        color = Color.WHITE;
        createGraphics();
        sprite.setPosition(pos.x, pos.y);
        sprite.setSize(dim.x, dim.y);
    }

    //update
    public void update(float deltaTime) {

    }

    //render
    public void render(SpriteBatch sb) {
        sprite.draw(sb);
    }
}
