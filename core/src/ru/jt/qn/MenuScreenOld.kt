package ru.jt.qn

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
//import org.lwjgl.opengl.Display.getDrawable
import ru.jt.qn.component.Component
import ru.jt.qn.event.TouchEventHandler
import ru.jt.qn.utils.Swipe


class MenuScreenOld : Screen {


    var batch // объект для отрисовки спрайтов нашей игры
            : SpriteBatch
    var camera // область просмотра нашей игры
            : OrthographicCamera

    var startButtonTexture: Texture
    var exitButtonTexture: Texture
    var backGroundTexture: Texture
    var startButtonSprite: Sprite
    var exitButtonSprite: Sprite
    var backGroundSprite: Sprite

    var startComponent: Component

    private val BUTTON_RESIZE_FACTOR = 800f // задаём относительный размер

    private val START_VERT_POSITION_FACTOR = 2.7f // задаём позицию конпки start

    private val EXIT_VERT_POSITION_FACTOR = 4.2f // задаём позицию кнопки exit


//    var temp = Vector3() // временный вектор для "захвата" входных координат


    var touchEventHandler: TouchEventHandler

    init {
        val height = Gdx.graphics.height.toFloat()
        val width = Gdx.graphics.width.toFloat()
        // устанавливаем переменные высоты и ширины в качестве области просмотра нашей игры
        camera = OrthographicCamera(width, height)
        // этим методом мы центруем камеру на половину высоты и половину ширины
        camera.setToOrtho(false)
        batch = SpriteBatch()
        touchEventHandler = TouchEventHandler()
        // инициализируем текстуры и спрайты
        startButtonTexture = Texture(Gdx.files.internal("badlogic.jpg"))
        exitButtonTexture = Texture(Gdx.files.internal("badlogic.jpg"))
        backGroundTexture = Texture(Gdx.files.internal("menubackground.jpg"))
        startButtonSprite = Sprite(startButtonTexture)
        exitButtonSprite = Sprite(exitButtonTexture)
        backGroundSprite = Sprite(backGroundTexture)
        // устанавливаем размер и позиции
        startButtonSprite.setSize(startButtonSprite.width * (width / BUTTON_RESIZE_FACTOR), startButtonSprite.height * (width / BUTTON_RESIZE_FACTOR))
        exitButtonSprite.setSize(exitButtonSprite.width * (width / BUTTON_RESIZE_FACTOR), exitButtonSprite.height * (width / BUTTON_RESIZE_FACTOR))
        backGroundSprite.setSize(width, height)
        startButtonSprite.setPosition(width / 2f - startButtonSprite.width / 2, width / START_VERT_POSITION_FACTOR)
        exitButtonSprite.setPosition(width / 2f - exitButtonSprite.width / 2, width / EXIT_VERT_POSITION_FACTOR)
        // устанавливаем прозрачность заднего фона
        backGroundSprite.setAlpha(0.2f)
        startComponent = object : Component {
            override fun translate(xAmount: Float, yAmount: Float) {
                startButtonSprite.translate(xAmount, yAmount)
            }

            override fun render(delta: Float) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        touchEventHandler.add(Swipe.right(), startComponent)


//        val textButtonStyle = TextButtonStyle()
//        textButtonStyle.up = skin.getDrawable("buttons/buttonup.png")
//        textButtonStyle.over = skin.getDrawable("buttons/buttonpressed.png")
//        textButtonStyle.down = skin.getDrawable("buttons/buttonpressed.png")
//        textButtonStyle.pressedOffsetX = 1f
//        textButtonStyle.pressedOffsetY = -1f
//        textButtonStyle.font = black


//
//        var btn: TextButton = TextButton("Hallo", textButtonStyle)
//
//        com.badlogic.gdx.scenes.scene2d.Stage


    }

    fun MenuScreen() { // получаем размеры экрана устройства пользователя и записываем их в переменнные высоты и ширины

    }

    override fun show() {}

    override fun render(delta: Float) { // Очищаем экран
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        //        System.out.println(System.currentTimeMillis());
        batch.projectionMatrix = camera.combined // устанавливаем в экземпляр spritebatch вид с камеры (области просмотра)
        //отрисовка игровых объектов
        batch.begin()
        backGroundSprite.draw(batch)
        startButtonSprite.draw(batch)
        exitButtonSprite.draw(batch)
        //        handleTouch();
//        camera.update()
        batch.end()
        touchEventHandler.handleTouch()
    }

    override fun resize(width: Int, height: Int) {}

    override fun pause() {}

    override fun resume() {}

    override fun hide() {}

    override fun dispose() {
        startButtonTexture.dispose()
        exitButtonTexture.dispose()
        batch.dispose()
    }

//    fun handleTouch() { // Проверяем были ли касание по экрану?
//        if (Gdx.input.justTouched()) { //            Gdx.input.isTouched()
//// Получаем координаты касания и устанавливаем эти значения в временный вектор
//            temp[Gdx.input.x.toFloat(), Gdx.input.y.toFloat()] = 0f
//            // получаем координаты касания относительно области просмотра нашей камеры
//            camera!!.unproject(temp)
//            val touchX = temp.x
//            val touchY = temp.y
//            // обработка касания по кнопке Stare
//            if (touchX >= startButtonSprite!!.x && touchX <= startButtonSprite!!.x + startButtonSprite!!.width && touchY >= startButtonSprite!!.y && touchY <= startButtonSprite!!.y + startButtonSprite!!.height) { //                game.setScreen(new BasketBall()); // Переход к экрану игры
//                camera!!.translate(Vector2(10, 10))
//            } else if (touchX >= exitButtonSprite!!.x && touchX <= exitButtonSprite!!.x + exitButtonSprite!!.width && touchY >= exitButtonSprite!!.y && touchY <= exitButtonSprite!!.y + exitButtonSprite!!.height) {
//                Gdx.app.exit() // выход из приложения
//            }
//        }
//    }


}