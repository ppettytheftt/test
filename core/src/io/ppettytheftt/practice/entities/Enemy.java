package io.ppettytheftt.practice.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.ppettytheftt.practice.handlers.Assets;
import io.ppettytheftt.practice.handlers.GameObject;

public class Enemy extends GameObject {
    // vars

    // constructor
    public Enemy(float x) {
        pos.x = x;
        pos.y = 1f;
        dim.x = .5f;
        dim.y = .5f;

        sprite = new Sprite(Assets.portal.getKitty());
        sprite.setPosition(pos.x, pos.y);
        sprite.setSize(dim.x, dim.y);

    }

    // update
    public void update(float deltaTime) {

    }

    // render
    public void render(SpriteBatch sb) {
        sprite.draw(sb);
    }
}
