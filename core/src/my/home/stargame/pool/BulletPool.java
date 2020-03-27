package my.home.stargame.pool;

import my.home.stargame.base.SpritesPool;
import my.home.stargame.sprites.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
