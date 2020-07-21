package ru.jt.qn.utils

import com.badlogic.gdx.Application.ApplicationType
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle


fun com.badlogic.gdx.Files.dirList(path: String): Array<out FileHandle> {
    val dirHandle: FileHandle
    dirHandle = if (Gdx.app.type == ApplicationType.Desktop) {
        Gdx.files.local("android/assets/$path")
    } else { // ApplicationType.Desktop ..
        Gdx.files.internal(path)

    }
    return dirHandle.list()
}