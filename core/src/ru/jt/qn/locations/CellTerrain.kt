package ru.jt.qn.locations

enum class CellTerrain(public val drawGrid: Boolean, public val frameDuration: Float) {

    ABS(false, 0.05f),//absent
    EMP,//empty



    //
    FB0,
    FU0,
    FD0,

    F0B,
    FBB,
    FUB,
    FDB,

    F0L,
    FBL,
    FUL,
    FDL,

    F0R,
    FBR,
    FUR,
    FDR,

    //water
    W00,
    WB0,
    WU0,
    WD0,

    W0B,
    WBB,
    WUB,
    WDB,

    W0L,
    WBL,
    WUL,
    WDL,

    W0R,
    WBR,
    WUR,
    WDR,

    // dessert
    D00,
    DB0,
    DU0,
    DD0,

    D0B,
    DBB,
    DUB,
    DDB,

    D0L,
    DBL,
    DUL,
    DDL,

    D0R,
    DBR,
    DUR,
    DDR;

//    constructor() {
//        this(true, false, false)
//    }

    constructor() : this(true, 0.05f)

}