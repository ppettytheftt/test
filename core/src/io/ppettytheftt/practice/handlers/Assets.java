package io.ppettytheftt.practice.handlers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    public static Assets portal = new Assets();
    private final String IMAGE_PATH = "character.atlas";
    // main
    private AssetManager manager;
    private TextureAtlas atlas;

    // enemies
    private TextureAtlas.AtlasRegion wizard;


    // empty constructor
    private Assets() {
    }

    // load assets
    public void load(AssetManager manager) {
        this.manager = manager;

        manager.load(IMAGE_PATH, TextureAtlas.class);
        manager.finishLoading();

        atlas = manager.get(IMAGE_PATH, TextureAtlas.class);

        // load assets by type
        wizard = atlas.findRegion("Untitled - 1");
    }

    // getters
    public TextureAtlas.AtlasRegion getWizard() {
        return wizard;
    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
