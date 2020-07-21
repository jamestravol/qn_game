package ru.jt.qn.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class MyPacker {
    public static void main (String[] args) throws Exception {
        TexturePacker.process("android/assets/terrains/", "atlas", "catatlas");
    }
}