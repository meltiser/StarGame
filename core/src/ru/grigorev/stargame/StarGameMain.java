package ru.grigorev.stargame;

import com.badlogic.gdx.Game;

import ru.grigorev.stargame.screen.MainScreen;

/**
 * @author Dmitriy Grigorev
 */
public class StarGameMain extends Game {
    @Override
    public void create() {
        setScreen(new MainScreen(this));
    }
}
