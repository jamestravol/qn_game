package ru.jt.qn.locations.terrains

fun empty0(): Terrain {
    return Empty()
}

fun absent(): Terrain {
    return Absent()
}

fun ri(vd: VDirections, hd: HDirections): Terrain {
    return River(vd, hd)
}