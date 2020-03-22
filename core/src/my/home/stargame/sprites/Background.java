package my.home.stargame.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import my.home.stargame.base.Sprite;
import my.home.stargame.exception.GameException;
import my.home.stargame.math.Rect;

public class Background extends Sprite {

    public Background(Texture texture) throws GameException {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(1f);
        pos.set(worldBounds.pos);
    }
}
