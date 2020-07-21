package ru.jt.qn.event

import ru.jt.qn.component.Component
import java.util.*

class TouchEventHandler {
    private val componentMap: MutableMap<TouchHandler, Component> = HashMap()
    fun handleTouch() {}
    fun add(handler: TouchHandler, component: Component) {
        componentMap[handler] = component
    }
}