package io.ppettytheftt.practice.handlers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
    // vars
    protected Vector2 pos, dim;
    protected float speed;
    protected int health;
    protected boolean hit, remove;
    //image
    protected Pixmap pixmap;
    protected Texture texture;
    protected Sprite sprite;
    protected Color color;

    // contructor
    protected GameObject() {
        pos = new Vector2();
        dim = new Vector2();
        speed = 0f;
        health = 0;

        hit = false;
        remove = false;
    }

    // Create graphics
    protected void createGraphics() {
        int width = 8;
        int height = 8;

        //pixmap
        pixmap = new Pixmap(width, height, Pixmap.Format.RGB888);
        pixmap.setColor(color);
        pixmap.fill();
        pixmap.drawRectangle(0, 0, width, height);

        //texture
        texture = new Texture(pixmap);

        //sprite
        sprite = new Sprite(texture);
    }

    protected Rectangle getArea() {
        return new Rectangle(pos.x, pos.y, dim.x, dim.y);
    }

    public boolean collide(GameObject object) {
        Rectangle rectangle1 = getArea();
        Rectangle rectangle2 = object.getArea();

        return rectangle1.overlaps(rectangle2);
    }

    // getters
    public Vector2 getPos() {
        return pos;
    }

    public Vector2 getDim() {
        return dim;
    }

    public float getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public boolean isHit() {return hit;}

    public boolean isRemove() {return remove;}

    // setters
    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public void setDim(Vector2 dim) {
        this.dim = dim;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setRemove(boolean b) { remove = b;}
}
