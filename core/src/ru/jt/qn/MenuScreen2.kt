package ru.jt.qn

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.Event
import com.badlogic.gdx.scenes.scene2d.EventListener
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ScalingViewport
import kotlin.math.abs

class MenuScreen2(game: QuattuorNobis) : Screen {

//    var camera : OrthographicCamera

    private var stage: Stage
    private var table: Table
    private var atlas: TextureAtlas
    private var skin: Skin


    private var btn: TextButton
    private var bkg: Image
    private var img: Image

//    MenuScreen2(){};

    init {


//        camera = OrthographicCamera(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())

        stage = Stage()

        atlas = TextureAtlas();

//        atlas.

        skin = Skin(atlas)

//        var skin = Skin(atlas);
        table = Table()

        table.setBounds(0f, 0f, Gdx.graphics.getWidth().toFloat(), Gdx.graphics.getHeight().toFloat());


        val startButtonTexture = Texture(Gdx.files.internal("buttons/button_up.png"))
        val t2 = Texture(Gdx.files.internal("badlogic.jpg"))
        val t3 = Texture(Gdx.files.internal("menubackground.jpg"))
//        exitButtonTexture = Texture(Gdx.files.internal("badlogic.jpg"))
//        backGroundTexture = Texture(Gdx.files.internal("menubackground.jpg"))
        val startButtonSprite = Sprite(startButtonTexture)
        val s2 = Sprite(t2)

        val textButtonStyle = TextButton.TextButtonStyle()
        textButtonStyle.up = SpriteDrawable(startButtonSprite)//skin.getDrawable("buttons/buttonup.png")
//        textButtonStyle.over = SpriteDrawable(startButtonSprite)//skin.getDrawable("buttons/buttonup.png")
//        textButtonStyle.down = SpriteDrawable(startButtonSprite)//skin.getDrawable("buttons/buttonup.png")
//        textButtonStyle.checked = SpriteDrawable(startButtonSprite)//skin.getDrawable("buttons/buttonup.png")
//        textButtonStyle.over = skin.getDrawable("buttons/buttonpressed.png")
//        textButtonStyle.down = skin.getDrawable("buttons/buttonpressed.png")
        textButtonStyle.overFontColor = Color.BLACK
//        textButtonStyle.overFontColor = Color.BROWN
//        textButtonStyle.overFontColor = Color.BROWN
        textButtonStyle.pressedOffsetX = 1f
        textButtonStyle.pressedOffsetY = -1f
        textButtonStyle.font = BitmapFont(Gdx.files.internal("font/comic.fnt"));

        btn = TextButton("Play", textButtonStyle)

//        btn.setScale(100f, 100f)
//        btn.setPosition(0f, 0f)



        // 900x1600 -> 800x1000 ->


//        table.add(btn)

        btn.addListener(object : ActorGestureListener() {
            override fun tap(event: InputEvent?, x: Float, y: Float, count: Int, button: Int) {
                Gdx.app.exit()
            }
        })


//        stage.get

//        stage.addActor(btn)

//        Gdx.app.exit()

        bkg = Image(t3)



        stage.addActor(bkg)

        img = Image(t2)

        img.setBounds(0f, 0f, 50f, 50f)

//        img.addListener(object : ActorGestureListener() {
//            override fun tap(event: InputEvent?, x: Float, y: Float, count: Int, button: Int) {
//                println("Sadasdsadasd")
//            }
//
//
//        })

//        img.addListener(EventListener { e ->
//            println(e.toString())
//            true
//        })


        val listener = object : ActorGestureListener() {
            override fun fling(event: InputEvent?, velocityX: Float, velocityY: Float, button: Int) {
//                print(event)
//                print(' ')
//                print(velocityX)
//                print(' ')
//                print(velocityY)
//                print(' ')
//                println(button)


                if (abs(velocityX) > abs(velocityY)) {
                    if (velocityX > 0) {
                        img.x += 100
                    } else {
                        img.x -= 100
                    }
                } else {
                    if (velocityY > 0) {
                        img.y += 100
                    } else {
                        img.y -= 100
                    }
                }
            }
        }
        bkg.addListener(listener)
        img.addListener(listener)



        stage.addActor(img)




        Gdx.input.setInputProcessor(stage);

    }

    override fun hide() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun show() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        stage.act(Gdx.graphics.getDeltaTime());
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


        btn.setBounds(0f, 0f, 100f, 100f)

        bkg.setBounds(10f, 10f, 880f, 1580f)

        img.setBounds(0f, 0f, 100f, 100f)

//        stage.viewport.update(width, height , true);

//        stage.viewport = ScalingViewport(Scaling.stretch, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat(), OrthographicCamera())


//        HdpiUtils.glViewport(

//        stage.viewport = ScreenViewport();
    }

    override fun dispose() {
        stage.dispose();
    }

//    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//    stage.act(Gdx.graphics.getDeltaTime());
//    stage.draw();

}