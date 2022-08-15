package io.ppettytheftt.practice.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import io.ppettytheftt.practice.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Work in Progress";
		config.useGL30 = false;
		config.width = 480;
		config.height = 320;

		new LwjglApplication(new MyGdxGame(), config);
	}
}
