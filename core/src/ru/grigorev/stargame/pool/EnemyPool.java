package ru.grigorev.stargame.pool;


import com.badlogic.gdx.audio.Sound;

import ru.grigorev.stargame.base.SpritesPool;
import ru.grigorev.stargame.sprites.Enemy;
import ru.grigorev.stargame.sprites.MainShip;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private Sound shootSound;
    private MainShip mainShip;

    public EnemyPool(BulletPool bulletPool, Sound shootSound, MainShip mainShip) {
        this.bulletPool = bulletPool;
        this.shootSound = shootSound;
        this.mainShip = mainShip;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, shootSound, mainShip);
    }
}
