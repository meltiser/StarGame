package ru.grigorev.stargame.pool;


import ru.grigorev.stargame.base.SpritesPool;
import ru.grigorev.stargame.sprites.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

    @Override
    protected void log() {
        System.out.println("Bullet active/free: " + activeObjects.size() + "/" + freeObjects.size());
    }
}
