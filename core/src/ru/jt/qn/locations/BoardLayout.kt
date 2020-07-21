package ru.jt.qn.locations

interface BoardLayout {

//    companion object {
        public fun of(arr: Array<Array<CellTerrain>>): BoardLayout {
            return DefaultBoardLayout(arr)
        }
//    }

    fun getCellTerrain(x: Int, y: Int): CellTerrain

    fun getCellState(x: Int, y: Int):

}