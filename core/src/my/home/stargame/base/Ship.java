package my.home.stargame.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import my.home.stargame.exception.GameException;
import my.home.stargame.math.Rect;
import my.home.stargame.pool.BulletPool;
import my.home.stargame.sprites.Bullet;

public abstract class Ship extends Sprite {

    protected Rect worldBounds;
    protected BulletPool bulletPool;
    protected TextureRegion bulletRegion;
    protected Vector2 bulletV;
    protected float bulletHeight;
    protected int damage;
    protected Sound shootSound;
    protected int hp;

    protected Vector2 v0;
    protected Vector2 v;

    protected float reloadInterval;
    protected float reloadTimer;

    protected boolean isOnScreen;

    public Ship() {
    }

    public Ship(TextureRegion region, int rows, int cols, int frames) throws GameException {
        super(region, rows, cols, frames);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval) {
            if (isOnScreen) {
                shoot();
                reloadTimer = 0f;
            }
        }
    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, damage);
        shootSound.play();
    }
}
