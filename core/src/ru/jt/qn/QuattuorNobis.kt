package ru.jt.qn

import com.badlogic.gdx.Game

class QuattuorNobis : Game() {
    //	SpriteBatch batch;
//	Texture img;
    override fun create() { //		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
        setScreen(MenuScreen(this))
    } //	@Override






//	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
//		Gdx.gl.set
//	}
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}