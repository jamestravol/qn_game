package ru.jt.qn.component

interface Component {

    abstract fun translate(xAmount: Float, yAmount: Float)


    fun render(delta: Float)

}