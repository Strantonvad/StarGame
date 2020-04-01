package my.home.stargame.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import my.home.stargame.base.Sprite;
import my.home.stargame.exception.GameException;
import my.home.stargame.math.Rect;

public class Ship extends Sprite {
    private static final float V_LEN = 0.005f;

    private Vector2 userTouch;
    private Vector2 v;
    private Vector2 tmp;
    private Rect worldBounds;

    private boolean isTouch;

    private boolean leftMove;
    private boolean rightMove;
    private boolean forwardMove;
    private boolean backwardMove;

    public Ship(TextureAtlas atlas) throws GameException {
        super(new TextureRegion(atlas.findRegion("main_ship"), 200, 0, 190, 295));
        userTouch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }

    public void update(float delta) {
        if (isTouch) {
            tmp.set(userTouch);
            float remainingDistance = (tmp.sub(pos)).len();
            if (remainingDistance > V_LEN) {
                pos.add(v);
            } else {
                v.setZero();
                pos.set(userTouch);
            }
        }

        updateMotion();
    }

    private void updateMotion() {
        if (leftMove) {
            if (getLeft() < worldBounds.getLeft()) {
                v.setZero();
            }
            pos.add(v);
        }
        if (rightMove) {
            if (getRight() > worldBounds.getRight()) {
                v.setZero();
            }
            pos.add(v);
        }
        if (forwardMove) {
            if (getTop() > worldBounds.getTop()) {
                v.setZero();
            }
            pos.add(v);
        }
        if (backwardMove) {
            if (getBottom() < worldBounds.getBottom()) {
                v.setZero();
            }
            pos.add(v);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(0.16f);
        setBottom(worldBounds.getBottom() + 0.05f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        userTouch.set(touch.x, touch.y);
        v.set(userTouch.cpy().sub(pos)).setLength(V_LEN);
        isTouch = true;
        return super.touchDown(touch, pointer, button);
    }

    public void keyDown(int keycode) {
        isTouch = false;
        switch (keycode) {
            case Input.Keys.A:
                if (!rightMove) {
                    leftMove = true;
                    v.set(-Gdx.graphics.getWidth() - pos.x, pos.y).setLength(V_LEN);
                }

                if (forwardMove) {
                    v.set(-Gdx.graphics.getWidth() - pos.x, Gdx.graphics.getHeight() - pos.y)
                            .setLength(V_LEN / 2);
                }
                if (backwardMove) {
                    v.set(-Gdx.graphics.getWidth() - pos.x, -Gdx.graphics.getHeight() - pos.y)
                            .setLength(V_LEN / 2);
                }
                break;
            case Input.Keys.D:
                if (!leftMove) {
                    rightMove = true;
                    v.set(Gdx.graphics.getWidth() - pos.x, pos.y).setLength(V_LEN);
                }

                if (forwardMove) {
                    v.set(Gdx.graphics.getWidth() - pos.x, Gdx.graphics.getHeight() - pos.y)
                            .setLength(V_LEN / 2);
                }
                if (backwardMove) {
                    v.set(Gdx.graphics.getWidth() - pos.x, -Gdx.graphics.getHeight() - pos.y)
                            .setLength(V_LEN / 2);
                }
                break;
            case Input.Keys.W:
                if (!backwardMove) {
                    forwardMove = true;
                    v.set(pos.x, Gdx.graphics.getHeight() - pos.y).setLength(V_LEN);
                }

                if (leftMove) {
                    v.set(-Gdx.graphics.getWidth() - pos.x, Gdx.graphics.getHeight() - pos.y)
                            .setLength(V_LEN / 2);
                }
                if (rightMove) {
                    v.set(Gdx.graphics.getWidth() - pos.x, Gdx.graphics.getHeight() - pos.y)
                            .setLength(V_LEN / 2);
                }
                break;
            case Input.Keys.S:
                if (!forwardMove) {
                    backwardMove = true;
                    v.set(pos.x, -Gdx.graphics.getHeight() - pos.y).setLength(V_LEN);
                }

                if (leftMove) {
                    v.set(-Gdx.graphics.getWidth() - pos.x, -Gdx.graphics.getHeight() - pos.y)
                            .setLength(V_LEN / 2);
                }
                if (rightMove) {
                    v.set(Gdx.graphics.getWidth() - pos.x, -Gdx.graphics.getHeight() - pos.y)
                            .setLength(V_LEN / 2);
                }
                break;
        }
    }

    public void keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
                leftMove = false;
                if (forwardMove) {
                    v.set(pos.x, Gdx.graphics.getHeight() - pos.y).setLength(V_LEN);
                } else if (backwardMove) {
                    v.set(pos.x, -Gdx.graphics.getHeight() - pos.y).setLength(V_LEN);
                }
                break;
            case Input.Keys.D:
                rightMove = false;
                if (forwardMove) {
                    v.set(pos.x, Gdx.graphics.getHeight() - pos.y).setLength(V_LEN);
                } else if (backwardMove) {
                    v.set(pos.x, -Gdx.graphics.getHeight() - pos.y).setLength(V_LEN);
                }
                break;
            case Input.Keys.W:
                forwardMove = false;
                if (leftMove) {
                    v.set(-Gdx.graphics.getWidth() - pos.x, pos.y).setLength(V_LEN);
                } else if (rightMove) {
                    v.set(Gdx.graphics.getWidth() - pos.x, pos.y).setLength(V_LEN);
                }
                break;
            case Input.Keys.S:
                backwardMove = false;
                if (leftMove) {
                    v.set(-Gdx.graphics.getWidth() - pos.x, pos.y).setLength(V_LEN);
                } else if (rightMove) {
                    v.set(Gdx.graphics.getWidth() - pos.x, pos.y).setLength(V_LEN);
                }
                break;
        }
    }
}
