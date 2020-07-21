package ru.jt.qn.locations

interface Location {
    fun getSizeX(): Int
    fun getSizeY(): Int
    fun getBoardLayout(x: Int, y: Int): BoardLayout
}