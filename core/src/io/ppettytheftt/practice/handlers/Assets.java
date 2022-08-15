package io.ppettytheftt.practice.handlers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    public static Assets portal = new Assets();
    private final String IMAGE_PATH = "sprites.atlas";
    // main
    private AssetManager manager;
    private TextureAtlas atlas;

    // enemies
    private TextureAtlas.AtlasRegion kitty;
    private TextureAtlas.AtlasRegion fire;

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
        kitty = atlas.findRegion("Characters/kittykat");
    }

    // getters
    public TextureAtlas.AtlasRegion getKitty() {
        return kitty;
    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
