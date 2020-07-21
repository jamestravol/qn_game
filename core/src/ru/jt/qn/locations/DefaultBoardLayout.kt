package ru.jt.qn.locations

class DefaultBoardLayout(private val arr: Array<Array<CellTerrain>>): BoardLayout {
    override fun getCellTerrain(x: Int, y: Int): CellTerrain {
        return arr[x][y];
    }
}