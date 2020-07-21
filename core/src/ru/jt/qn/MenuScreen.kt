package ru.jt.qn

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.StretchViewport
import ru.jt.qn.locations.TestLocation
import ru.jt.qn.utils.buttons.style


class MenuScreen(game: QuattuorNobis) : Screen {

    private val stage: Stage
    private val camera: OrthographicCamera
    private val batch: SpriteBatch

    init {

        camera = OrthographicCamera()
        camera.setToOrtho(false, Settings.appWidth, Settings.appHeight)

        batch = SpriteBatch()
        batch.projectionMatrix = camera.combined

        stage = Stage(StretchViewport(Settings.appWidth, Settings.appHeight, camera))

        val background = Image(Texture(Gdx.files.internal("menubackground.jpg")))
        background.setBounds(0f, 0f, 900f, 1600f)
        stage.addActor(background)

        val playButton = TextButton("Play", style())
        playButton.setBounds(250f, 800f, 400f, 100f);
        playButton.label.setFontScale(1.5f, 1.5f)
        playButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                game.screen = GameScreen(game, TestLocation())
            }
        })
        stage.addActor(playButton)

        val optionsButton = TextButton("Options", style())
        optionsButton.setBounds(250f, 650f, 400f, 100f);
        optionsButton.label.setFontScale(1.5f, 1.5f)
        optionsButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                Gdx.app.exit()
            }
        })
        stage.addActor(optionsButton)

        val exitButton = TextButton("Exit", style())
        exitButton.setBounds(250f, 500f, 400f, 100f);
        exitButton.label.setFontScale(1.5f, 1.5f)
        exitButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                Gdx.app.exit()
            }
        })
        stage.addActor(exitButton)

        Gdx.input.inputProcessor = stage;

    }


    override fun hide() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun show() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    override fun pause() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resize(width: Int, height: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dispose() {
        stage.dispose()
    }
}