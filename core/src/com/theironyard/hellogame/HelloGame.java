package com.theironyard.hellogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float x = 0;//creates float variable for position on screen
    float y = 0;
    float xVelocity = 0;//creates float variable for velocity
    float yVelocity = 0;

    final float MAX_VELOCITY = 100; //sets the max (final) potential velocity

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){//constant value that represents the UP key
            yVelocity = MAX_VELOCITY;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            yVelocity = MAX_VELOCITY * -1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            xVelocity = MAX_VELOCITY;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            xVelocity = MAX_VELOCITY * -1;
        }

        x += xVelocity * Gdx.graphics.getDeltaTime();//function that adapts to users PC frames per second
        y += yVelocity * Gdx.graphics.getDeltaTime();

        xVelocity *= .09;//dampening, adding "friction" to slow a stop!
        yVelocity *= .09;

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
}
