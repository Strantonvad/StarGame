package my.home.stargame.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import my.home.stargame.base.Sprite;
import my.home.stargame.exception.GameException;
import my.home.stargame.math.Rect;

public class GameOver extends Sprite {

    public GameOver(TextureAtlas atlas) throws GameException {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.07f);
        setTop(0.1f);
    }
}
