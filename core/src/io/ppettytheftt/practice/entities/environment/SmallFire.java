package io.ppettytheftt.practice.entities.environment;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import io.ppettytheftt.practice.handlers.Assets;
import io.ppettytheftt.practice.handlers.GameObject;

public class SmallFire extends GameObject {
    //vars
    private Animation small_fire_animation;
    private float runTime;

    //constructor
    public SmallFire() {
        pos.x = 3f;
        pos.y =4f;
        dim.x = 2f;
        dim.y = 2f;

        small_fire_animation = Assets.portal.getFireAnimation();
    }

    //update
    public void update(float deltaTime) {
        runTime += deltaTime;
    }

    public void render(SpriteBatch sb) {
        sb.draw((TextureRegion)small_fire_animation.getKeyFrame(runTime), pos.x, pos.y, dim.x, dim.y);
    }
}
