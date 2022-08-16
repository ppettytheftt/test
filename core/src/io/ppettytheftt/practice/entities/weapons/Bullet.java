package io.ppettytheftt.practice.entities.weapons;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.ppettytheftt.practice.handlers.GameObject;

public class Bullet extends GameObject {
    public Bullet(float x, float y) {
        pos.x = x;
        pos.y = y;
        dim.x = .2f;
        dim.y = .2f;

        speed = .5f;
        color = Color.RED;
        createGraphics();

        sprite.setPosition(pos.x, pos.y);
        sprite.setSize(dim.x, dim.y);

    }

    public void update(float deltaTime) {
        sprite.translate(speed, 0f);
        pos.x = sprite.getX();
    }

    public void render(SpriteBatch sb) {

    }
}
