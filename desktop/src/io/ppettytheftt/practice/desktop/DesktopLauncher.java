package io.ppettytheftt.practice.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import io.ppettytheftt.practice.gametable.GameTable;
import io.ppettytheftt.practice.handlers.Constant;

public class DesktopLauncher implements Constant {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = GAME_TITLE;
		config.useGL30 = false;
		config.width = GAME_WIDTH;
		config.height = GAME_HEIGHT;

		new LwjglApplication(new GameTable(), config);
	}
}
