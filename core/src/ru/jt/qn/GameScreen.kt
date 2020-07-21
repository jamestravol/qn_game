package ru.jt.qn

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.viewport.StretchViewport
import ru.jt.qn.component.Board
import ru.jt.qn.locations.Location
import ru.jt.qn.utils.buttons.style
import kotlin.math.abs


class GameScreen(game: QuattuorNobis, location: Location) : ScreenAdapter() {

    companion object {
        const val BOARD_X = 98f
        const val BOARD_Y = 500f
    }

    private var stage: Stage
    private val camera: OrthographicCamera
    private val batch: SpriteBatch
    private val boards: ArrayList<ArrayList<Board>> = ArrayList()

    init {

        camera = OrthographicCamera()
        camera.setToOrtho(false, Settings.appWidth, Settings.appHeight)

        batch = SpriteBatch()
        batch.projectionMatrix = camera.combined

        stage = Stage(StretchViewport(Settings.appWidth, Settings.appHeight, camera))

//        stage.se

//        val g = Group()

//        g.setScale()

//        g.setBounds(50f, 600f, 800f, 800f)


        for (i in 0 until location.getSizeX()) {
            val bList = ArrayList<Board>()
            boards.add(bList)
            for (j in 0 until location.getSizeY()) {
                val board = Board(location.getBoardLayout(i, j))
                board.x = BOARD_X + Settings.appWidth * i
                board.y = BOARD_Y - Settings.appHeight * j
                board.width = 800f
                board.height = 800f
                stage.addActor(board)
                board.addListener(object : ActorGestureListener() {
                    override fun fling(event: InputEvent?, velocityX: Float, velocityY: Float, button: Int) {
                        if (abs(velocityX) > abs(velocityY)) {
                            if (velocityX > 0) {
                                moveBoards(Settings.appWidth, 0f)
                            } else {
                                moveBoards(-Settings.appWidth, 0f)
                            }
                        } else {
                            if (velocityY > 0) {
                                moveBoards(0f, Settings.appHeight)
                            } else {
                                moveBoards(0f, -Settings.appHeight)
                            }
                        }
                    }
                })
                bList.add(board)
            }
        }

//        boards[0][0].addListener(object : ClickListener() {
//            override fun clicked(event: InputEvent?, x: Float, y: Float) {
//                moveBoards(-Settings.appWidth, 0f)
//            }
//        })
//
//        boards[1][0].addListener(object : ClickListener() {
//            override fun clicked(event: InputEvent?, x: Float, y: Float) {
//                moveBoards(Settings.appWidth, 0f)
//            }
//        })

//        moveBoards(0f, 0f)


        Gdx.input.inputProcessor = stage;
    }

    private fun moveBoards(x: Float, y: Float) {

        // validate move possibility

        if (x > 0 && boards[0][0].x == BOARD_X) return
        if (x < 0 && boards[boards.size - 1][0].x == BOARD_X) return
        if (y > 0 && boards[0][boards[0].size - 1].y == BOARD_Y) return
        if (y < 0 && boards[0][0].y == BOARD_Y) return

        //todo sync
        for (it in boards) {
            for (board in it) {
                board.move(x, y)
            }
        }

    }


    private fun abc() {
        val table: Table = Table()

        table.background = TextureRegionDrawable(Texture(Gdx.files.internal("board/background.png")))

        val ls = Label.LabelStyle()
        ls.font = BitmapFont(Gdx.files.internal("font/comic.fnt"));

        table.debugAll()

        val style = style()
        for (i in (1..12)) {
            for (j in (1..12)) {
//                val textButton = TextButton("$i-$j", style)
//                textButton.setBounds(0, 0, 40, 40)
//                table.add(textButton)
                val l: Label = Label("$i-$j", ls)
                table.add(l)

            }
            table.row()
        }


        val textButton = TextButton("$0-$0", style)
        textButton.setBounds(0f, 0f, 40f, 40f)
//        table.add(textButton)


//        ls.

//        val l: Label = Label("ololo", ls)
//        table.add(l)

        table.setBounds(50f, 600f, 800f, 800f)

        stage.addActor(table)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    override fun dispose() {
        stage.dispose()
    }

}