package ru.jt.qn.utils.buttons

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable

fun style() : TextButtonStyle {
    val result = TextButtonStyle()
    result.up = TextureRegionDrawable(Texture(Gdx.files.internal("buttons/button_up.png")))
    result.pressedOffsetX = 1f
    result.pressedOffsetY = -1f
    result.fontColor = Color.BLACK
    result.font = BitmapFont(Gdx.files.internal("font/comic.fnt"));
    return result
}