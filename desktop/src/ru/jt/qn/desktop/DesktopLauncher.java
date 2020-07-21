package ru.jt.qn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.jt.qn.QuattuorNobis;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 270;
		config.height = 480;
//		config.width = 540;
//		config.height = 960;
		new LwjglApplication(new QuattuorNobis(), config);
	}
}
