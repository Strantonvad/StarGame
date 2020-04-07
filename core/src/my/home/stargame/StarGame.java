package my.home.stargame;

import com.badlogic.gdx.Game;

import my.home.stargame.screen.MenuScreen;

public class StarGame extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
