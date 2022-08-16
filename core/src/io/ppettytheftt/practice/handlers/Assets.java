package io.ppettytheftt.practice.handlers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    public static Assets portal = new Assets();
    private final String CHARACTER_PATH = "character.atlas";
    private final String DECORE_PATH = "decore.atlas";
    // main
    private AssetManager characterManager;
    private AssetManager decorationManager;
    private TextureAtlas characterAtlas;
    private TextureAtlas decorationAtlas;

    // enemies
    private TextureAtlas.AtlasRegion wizard, smallFire;
    private Animation fire_animation;



    // empty constructor
    private Assets() {
    }

    // load assets
    public void load(AssetManager manager) {
        this.characterManager = manager;


        manager.load(CHARACTER_PATH, TextureAtlas.class);
        manager.finishLoading();

        characterAtlas = manager.get(CHARACTER_PATH, TextureAtlas.class);

        // loads the wizard from the .atlas file from character.atlas
        wizard = characterAtlas.findRegion("Untitled - 1");

        manager.clear();
        //load the small fire
        this.decorationManager = manager;
        manager.load(DECORE_PATH, TextureAtlas.class);
        manager.finishLoading();

        decorationAtlas = manager.get(DECORE_PATH, TextureAtlas.class);

        smallFire = decorationAtlas.findRegion("bundle_fire_animation");
        TextureRegion[][] small_fire_sprite = smallFire.split(32,32);
        // creates animation
        fire_animation = new Animation<TextureRegion>(5f / 60f, small_fire_sprite[0]);
        fire_animation.setPlayMode(Animation.PlayMode.LOOP);
    }

    // getters
    public TextureAtlas.AtlasRegion getWizard() {
        return wizard;
    }

    public Animation getFireAnimation() {
        return fire_animation;
    }


    @Override
    public void dispose() {
        characterManager.dispose();
    }
}
