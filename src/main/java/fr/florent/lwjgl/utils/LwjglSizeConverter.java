package fr.florent.lwjgl.utils;

public class LwjglSizeConverter {


    public static double convertPositionToLwjgl(int position, int size) {
        return ((double) position - (double) size / 2) / size;
    }

    public static int convertPositionFromLwjgl(double position, int size) {
        return (int) (position * size + (double) size / 2);
    }

    public static double convertLengthToLwjgl(int length, int size) {
        return (double) length / size;
    }

    public static int convertLengthFromLwjgl(double length, int size) {
        return (int) length * size;
    }


}
