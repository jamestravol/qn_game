package ru.jt.qn.locations

import ru.jt.qn.locations.CellTerrain.*

class TestLocation : Location {

    private val lay1 = DefaultBoardLayout(arrayOf(
            arrayOf(EMP, ABS, ABS, ABS, ABS, ABS, ABS, ABS, ABS, D00),
            arrayOf(ABS, ABS, ABS, ABS, ABS, ABS, ABS, ABS, D00, ABS),
            arrayOf(ABS, ABS, EMP, EMP, EMP, EMP, EMP, ABS, ABS, ABS),
            arrayOf(ABS, ABS, EMP, EMP, EMP, EMP, EMP, ABS, ABS, ABS),
            arrayOf(ABS, ABS, EMP, EMP, EMP, EMP, EMP, ABS, ABS, ABS),
            arrayOf(ABS, ABS, EMP, EMP, EMP, EMP, EMP, ABS, ABS, ABS),
            arrayOf(ABS, ABS, EMP, EMP, EMP, EMP, EMP, ABS, ABS, ABS),
            arrayOf(ABS, ABS, EMP, EMP, EMP, EMP, EMP, ABS, EMP, ABS),
            arrayOf(ABS, ABS, ABS, ABS, ABS, ABS, ABS, ABS, EMP, EMP),
            arrayOf(D00, D00, ABS, ABS, ABS, ABS, ABS, ABS, EMP, EMP))
    )

    private val lay2 = DefaultBoardLayout(arrayOf(
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP))
    )

    private val lay3 = DefaultBoardLayout(arrayOf(
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, D00, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, D00, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP))
    )

    private val lay4 = DefaultBoardLayout(arrayOf(
            arrayOf(ABS, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, ABS),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, ABS, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, ABS, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP),
            arrayOf(ABS, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, ABS))
    )

    private val boards = arrayOf(
            arrayOf(lay1, lay2),
            arrayOf(lay3, lay4)
    )

    override fun getSizeX(): Int {
        return 2;
    }

    override fun getSizeY(): Int {
        return 2;
    }

    override fun getBoardLayout(x: Int, y: Int): BoardLayout {
        return boards[y][x]
    }

}