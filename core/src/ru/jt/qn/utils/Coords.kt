package ru.jt.qn.utils

import com.badlogic.gdx.Gdx

//const val WIDTH: Float = 900f;
//const val HEIGHT: Float = 1600f;
//const val RATIO: Float = WIDTH / HEIGHT;
//
//var Number.x: Float
//    get() = x()
//    set(v) {}
//
//var Number.y: Float
//    get() = y()
//    set(v) {}
//
//var Number.w: Float
//    get() = w()
//    set(v) {}
//
//var Number.h: Float
//    get() = h()
//    set(v) {}
//
//fun Number.x(): Float {
//
//    val width = Gdx.graphics.width
//    val height = Gdx.graphics.height
//
//    val overheadX = 1f * width / height - RATIO
//
//    if (overheadX > 0) {
//
//        val countedMaxWidth = 1f * height * RATIO
//
//        val offset = (width - countedMaxWidth) / 2f
//
//        return (countedMaxWidth) * this.toFloat() / WIDTH + offset;
//    }
//
//    return width * this.toFloat() / WIDTH
//}
//
//fun Number.y(): Float {
//
//    val width = Gdx.graphics.width
//    val height = Gdx.graphics.height
//
//    val overheadY = RATIO - 1f * width / height
//
//    if (overheadY > 0) {
//        val countedMaxHeight = 1f * width / RATIO
//
//        val offset = (height - countedMaxHeight) / 2f
//
//        return (countedMaxHeight) * this.toFloat() / HEIGHT + offset;
//    }
//
//    return height * this.toFloat() / HEIGHT
//}
//
//fun Number.w(): Float {
//
//    val width = Gdx.graphics.width
//    val height = Gdx.graphics.height
//
//    val overheadX = 1f * width / height - RATIO
//
//    if (overheadX > 0) {
//        val countedMaxWidth = 1f * height * RATIO
//        return (countedMaxWidth) * this.toFloat() / WIDTH
//    }
//
//    return width * this.toFloat() / WIDTH
//}
//
//fun Number.h(): Float {
//
//    val width = Gdx.graphics.width
//    val height = Gdx.graphics.height
//
//    val overheadY = RATIO - 1f * width / height
//
//    if (overheadY > 0) {
//        val countedMaxHeight = 1f * width / RATIO
//        return (countedMaxHeight) * this.toFloat() / WIDTH
//    }
//
//    return height * this.toFloat() / HEIGHT
//}