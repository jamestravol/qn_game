package ru.jt.qn.component

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.Actor
import ru.jt.qn.locations.BoardLayout
import ru.jt.qn.locations.CellTerrain
import ru.jt.qn.utils.dirList
import java.util.*
import kotlin.math.max
import kotlin.math.min


class Board(private val boardLayout: BoardLayout) : Actor() {

    companion object {
        const val CELL_SIZE_X = 70f
        const val CELL_SIZE_Y = 70f
        const val CELL_COUNT_X = 10
        const val CELL_COUNT_Y = 10
        const val LINE_SIZE = 6f
        const val MOVE_MULTIPLIER = 4000f
    }

    private val shapeRenderer: ShapeRenderer = ShapeRenderer();

    private val terrainAnimations: EnumMap<CellTerrain, Animation<Texture>> = EnumMap(CellTerrain::class.java)

    private val gridTexture: Texture = Texture(Gdx.files.internal("draw/gray.png"))

    private var boardMoveX: Float = 0f
    private var boardMoveY: Float = 0f

    init {
    }


    override fun draw(batch: Batch?, parentAlpha: Float) {

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line)

        iterate(batch, this@Board::drawTerrain)
        iterate(batch, this@Board::drawGrid)

        shapeRenderer.end();

    }

    fun move(x: Float, y: Float) {
        if (boardMoveX == 0f && boardMoveY == 0f) {
            boardMoveX = x
            boardMoveY = y
        }
    }

    override fun act(delta: Float) {

        if (boardMoveX > 0f) {
            val step = max(1f, min(delta * MOVE_MULTIPLIER, boardMoveX)).toInt()
            boardMoveX -= step
            x += step
        }

        if (boardMoveX < 0f) {
            val step = max(1f, min(delta * MOVE_MULTIPLIER, -boardMoveX)).toInt()
            boardMoveX += step
            x -= step
        }


        if (boardMoveY > 0f) {
            val step = max(1f, min(delta * MOVE_MULTIPLIER, boardMoveY)).toInt()
            boardMoveY -= step
            y += step
        }

        if (boardMoveY < 0f) {
            val step = max(1f, min(delta * MOVE_MULTIPLIER, -boardMoveY)).toInt()
            boardMoveY += step
            y -= step
        }

        super.act(delta)
    }

    private fun drawGrid(batch: Batch?, i: Int, j: Int, x: Float, y: Float, w: Float, h: Float) {

        val terrainCell = boardLayout.getCellTerrain(i, j)

        if (terrainCell.drawGrid) {
            val offset = LINE_SIZE / 2f
            val ex = x - offset
            val ey = y - offset
            val ew = w + 2f * offset
            val eh = h + 2f * offset
            batch?.draw(gridTexture, ex, ey, ew, LINE_SIZE)
            batch?.draw(gridTexture, ex, ey, LINE_SIZE, eh)
            batch?.draw(gridTexture, ex, ey + h, ew, LINE_SIZE)
            batch?.draw(gridTexture, ex + w, ey, LINE_SIZE, eh)
        }

    }

    private fun iterate(batch: Batch?, process: (batch: Batch?, i: Int, j: Int, x: Float, y: Float, w: Float, h: Float) -> Unit) {

        for (i in (0 until CELL_COUNT_X)) {
            for (j in (0 until CELL_COUNT_Y)) {
                process(batch,
                        i,
                        j,
                        x + (1f * i * CELL_SIZE_X + (1f * LINE_SIZE / 2)),
                        y + (1f * j * CELL_SIZE_Y + (1f * LINE_SIZE / 2)),
                        CELL_SIZE_X,
                        CELL_SIZE_Y)
            }
        }
    }


    private fun drawTerrain(batch: Batch?, i: Int, j: Int, x: Float, y: Float, w: Float, h: Float) {

        val terrainCell = boardLayout.getCellTerrain(i, j)

        if (terrainCell != CellTerrain.ABS && terrainCell != CellTerrain.EMP) {
            val animation = loadOrGetTerrainAnimation(terrainCell)
            val frame = animation.getKeyFrame(Gdx.graphics.deltaTime, true)
            batch?.draw(frame, x, y, w, h)
        }

    }

    private fun loadOrGetTerrainAnimation(cellTerrain: CellTerrain): Animation<Texture> {
        return terrainAnimations.getOrElse(cellTerrain, {
            val dir = Gdx.files.dirList("terrains/${cellTerrain.name}")
            val arr = dir.map { Texture(it) }.toTypedArray()
            val arrBL = com.badlogic.gdx.utils.Array<Texture>(arr)
            val animation = Animation<Texture>(cellTerrain.frameDuration, arrBL)
            terrainAnimations[cellTerrain] = animation
            animation
        })
    }

}