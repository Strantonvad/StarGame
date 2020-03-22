package my.home.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import my.home.stargame.base.BaseScreen;
import my.home.stargame.exception.GameException;
import my.home.stargame.math.Rect;
import my.home.stargame.sprites.Background;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;
    private Vector2 pos;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        try {
            background = new Background(bg);
        } catch (GameException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
       update(delta);
       draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bg.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        pos.set(touch);
        return false;
    }

    private void update(float delta) {
    }

    private void draw() {
        Gdx.gl.glClearColor(0.5f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        batch.end();
    }

}
