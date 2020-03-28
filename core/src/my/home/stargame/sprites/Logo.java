package my.home.stargame.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import my.home.stargame.base.Sprite;
import my.home.stargame.exception.GameException;
import my.home.stargame.math.Rect;

public class Logo extends Sprite {
    private static final float V_LEN = 0.005f;

    private Vector2 userTouch;
    private Vector2 v;
    private Vector2 tmp;

    public Logo(Texture texture) throws GameException {
        super(new TextureRegion(texture));
        userTouch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        userTouch.set(touch.x, touch.y);
        v.set(userTouch.cpy().sub(pos)).setLength(V_LEN);
        return super.touchDown(touch, pointer, button);
    }

    public void logoUpdate() {
        tmp.set(userTouch);
        float remainingDistance = (tmp.sub(pos)).len();
        if (remainingDistance > V_LEN) {
            pos.add(v);
        } else {
            v.setZero();
            pos.set(userTouch);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        pos.set(worldBounds.pos);
    }
}
