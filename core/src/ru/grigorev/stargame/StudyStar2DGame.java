package ru.grigorev.stargame;

import com.badlogic.gdx.Game;

import ru.grigorev.stargame.screen.StudyMenuScreen;


public class StudyStar2DGame extends Game {
    @Override
    public void create() {
        setScreen(new StudyMenuScreen(this));
    }
}
