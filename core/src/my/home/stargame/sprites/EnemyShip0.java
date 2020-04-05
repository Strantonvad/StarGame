package my.home.stargame.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import my.home.stargame.base.Sprite;
import my.home.stargame.exception.GameException;
import my.home.stargame.math.Rect;

public class EnemyShip0 extends Sprite {
    private static final float SHIP_HEIGHT = 0.2f;

    private final Vector2 v;

    public EnemyShip0(TextureAtlas atlas) throws GameException {
        super(atlas.findRegion("enemy2"), 1, 2, 2);

        v = new Vector2(0, -0.3f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(SHIP_HEIGHT);
        setTop(worldBounds.getTop());
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
    }
}
