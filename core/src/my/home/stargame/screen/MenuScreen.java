package my.home.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import my.home.stargame.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 pos;
    private Vector2 dir;
    private float goalX = 0;
    private float goalY = 0;
    private float SPEED = 3f;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
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
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        goalX = screenX;
        goalY = Gdx.graphics.getHeight() - screenY;
        return false;
    }

    private void update(float delta) {
        dir = new Vector2(goalX - pos.x,goalY - pos.y).nor();

        float posX = pos.x;
        float posY = pos.y;
        posX += dir.x * SPEED;
        posY += dir.y * SPEED;

        boolean isGoalPointReached = false;

        if((dir.x > 0 && posX >= goalX) || (dir.x < 0 && posX <= goalX)) {
            posX = goalX;
            isGoalPointReached = true;
        }
        if((dir.y > 0 && posY >= goalY) || (dir.y < 0 && posY <= goalY)) {
            posY = goalY;
            isGoalPointReached = true;
        }
        if (!isGoalPointReached) {
            pos.set(posX, posY);
        }
    }

    private void draw() {
        Gdx.gl.glClearColor(0.5f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

}
