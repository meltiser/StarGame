package ru.grigorev.stargame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ru.grigorev.stargame.Star2DGame;
import ru.grigorev.stargame.StarGameMain;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        float aspect = 3f/4f;
        config.resizable = false;
        config.width = 300;
        config.height = (int) (config.width / aspect);
        new LwjglApplication(new Star2DGame(), config);
    }
}
