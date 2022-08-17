package io.ppettytheftt.practice.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    public static Assets portal = new Assets();
    private final String CHARACTER_PATH = "character.atlas";
    private final String DECORE_PATH = "decore.atlas";
    private final String TILED_MAP_PATH = "test-room1.tmx";
    // main
    private AssetManager characterManager;
    private AssetManager decorationManager;
    private TextureAtlas characterAtlas;
    private TextureAtlas decorationAtlas;

    //font
    private BitmapFont titleFont;

    // Game Objects
    private TextureAtlas.AtlasRegion wizard, smallFire;
    private Animation fire_animation;
    private TiledMap map;

    // Audio
    private Music bgm;
    private Sound glitchEffect;

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

        //load the small fire
        this.decorationManager = manager;
        manager.load(DECORE_PATH, TextureAtlas.class);
        manager.finishLoading();

        decorationAtlas = manager.get(DECORE_PATH, TextureAtlas.class);

        smallFire = decorationAtlas.findRegion("bundle_fire_animation");
        TextureRegion[][] small_fire_sprite = smallFire.split(32, 32);
        // creates animation
        fire_animation = new Animation<TextureRegion>(5f / 60f, small_fire_sprite[0]);
        fire_animation.setPlayMode(Animation.PlayMode.LOOP);

        //loads our map into TmxMapLoader
        map = retrieveMap(TILED_MAP_PATH);

        //load audio
        // music
        bgm = Gdx.audio.newMusic(Gdx.files.internal("test-song.mp3"));
        // Sound effect
        glitchEffect = Gdx.audio.newSound(Gdx.files.internal("glitch_effect.mp3"));

        // load font
        titleFont = new BitmapFont(Gdx.files.internal("openingScreenFnt.fnt"));

    }

    // getters
    public TextureAtlas.AtlasRegion getWizard() {
        return wizard;
    }

    public Animation getFireAnimation() {
        return fire_animation;
    }

    public Music getBgm() {
        return bgm;
    }

    public BitmapFont getTitleFont() {
        return titleFont;
    }

    public Sound getGlitchEffect() {
        return glitchEffect;
    }

    public TiledMap getTestRoom() { return map;}


    @Override
    public void dispose() {
        characterManager.dispose();
        decorationManager.dispose();
        bgm.dispose();
        glitchEffect.dispose();
        titleFont.dispose();
        map.dispose();
    }

    private TiledMap retrieveMap(String mapPath) {
        TmxMapLoader loader = new TmxMapLoader();
        return loader.load(mapPath);
    }
}
