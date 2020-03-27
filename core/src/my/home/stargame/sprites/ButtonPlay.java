package my.home.stargame.sprites;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import my.home.stargame.base.ScaledButton;
import my.home.stargame.exception.GameException;
import my.home.stargame.math.Rect;
import my.home.stargame.screen.GameScreen;

public class ButtonPlay extends ScaledButton {

    private final Game game;

    public ButtonPlay(TextureAtlas atlas, Game game) throws GameException {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.25f);
        setLeft(worldBounds.getLeft() + 0.05f);
        setBottom(worldBounds.getBottom() + 0.05f);
    }


    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }
}
