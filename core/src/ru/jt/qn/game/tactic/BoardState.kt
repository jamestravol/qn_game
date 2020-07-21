package ru.jt.qn.game.tactic

import ru.jt.qn.locations.BoardLayout

class BoardState {

    private val terrain: BoardLayout

    private val buildings: ArrayList

    private val cellStates: Array<Array<CellState>>

}