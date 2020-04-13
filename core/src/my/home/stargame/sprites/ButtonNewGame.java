package my.home.stargame.sprites;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import my.home.stargame.base.ScaledButton;
import my.home.stargame.exception.GameException;
import my.home.stargame.math.Rect;
import my.home.stargame.screen.GameScreen;

public class ButtonNewGame extends ScaledButton {
    private final Game game;

    public ButtonNewGame(TextureAtlas atlas, Game game) throws GameException {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.07f);
        setTop(-0.02f);
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen(game));
    }
}
