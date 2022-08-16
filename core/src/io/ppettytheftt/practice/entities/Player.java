package io.ppettytheftt.practice.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import io.ppettytheftt.practice.handlers.Assets;
import io.ppettytheftt.practice.handlers.GameObject;

public class Player extends GameObject {
    //vars
    private Animation fire_animation;
    private float runTime;

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
        fire_animation = Assets.portal.getFireAnimation();
    }

    //update
    public void update(float deltaTime) {
        runTime += deltaTime;
    }

    //render
    public void render(SpriteBatch sb) {
        sprite.draw(sb);
        sb.draw((TextureRegion) fire_animation.getKeyFrame(runTime), pos.x, pos.y, dim.x, dim.y);
    }
}
