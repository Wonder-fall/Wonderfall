package com.wonderfall.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Scaling;

/**
 * This class is used for a basic image actor class that handles simple box
 * collision detection The main purpose of the creation of this class is to sync
 * between the texture and the actor's position efficiently. Note that the
 * bounding box is attached to the texture. Note that there is no need to draw
 * the texture as this class is extending {@link Image} and therefore draws the
 * texure itself
 * 
 * TL;DR: sync actor and texture
 * 
 * @author BarDavid
 * @version 1.0
 */
public abstract class BoxedImageActor extends Image {

	private Rectangle boundingBox;

	public BoxedImageActor() {
		super();
		boundingBox = new Rectangle();
	}

	public BoxedImageActor(Drawable drawable, Scaling scaling, int align) {
		super(drawable, scaling, align);
		boundingBox = new Rectangle();
	}

	public BoxedImageActor(Drawable drawable, Scaling scaling) {
		super(drawable, scaling);
		boundingBox = new Rectangle();
	}

	public BoxedImageActor(Drawable drawable) {
		super(drawable);
		boundingBox = new Rectangle();
	}

	public BoxedImageActor(NinePatch patch) {
		super(patch);
		boundingBox = new Rectangle();
	}

	public BoxedImageActor(Skin skin, String drawableName) {
		super(skin, drawableName);
		boundingBox = new Rectangle();
	}

	public BoxedImageActor(Texture texture) {
		super(texture);
		boundingBox = new Rectangle(getX(), getY(), texture.getWidth(), texture.getHeight());
	}

	public BoxedImageActor(TextureRegion region) {
		super(region);
		boundingBox = new Rectangle(getX(), getY(), region.getRegionWidth(), region.getRegionHeight());
	}

	public Rectangle getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(Rectangle boundingBox) {
		this.boundingBox = boundingBox;
	}

	@Override
	public void setX(float x) {
		super.setX(x);
		boundingBox.setX(x);
	}

	@Override
	public void setY(float y) {
		super.setY(y);
		boundingBox.setY(y);
	}

	@Override
	public void setWidth(float width) {
		super.setWidth(width);
		boundingBox.setWidth(width);
	}

	@Override
	public void setHeight(float height) {
		super.setHeight(height);
		boundingBox.setHeight(height);
	}

	@Override
	public void setBounds(float x, float y, float width, float height) {
		super.setBounds(x, y, width, height);
		boundingBox.set(x, y, width, height);
	}

	@Override
	public void setPosition(float x, float y) {
		super.setPosition(x, y);
		boundingBox.setPosition(x, y);
	}

	public boolean isCollidedWith(Rectangle r) {
		return this.boundingBox.overlaps(r);
	}
}
