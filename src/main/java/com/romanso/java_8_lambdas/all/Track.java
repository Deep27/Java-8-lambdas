package com.romanso.java_8_lambdas.all;

public final class Track {

    private final String mName;
    private final int mLength;

    public Track(String name, int length) {
        mName = name;
        mLength = length;
    }

    public String getName() {
        return mName;
    }

    public int getLength() {
        return mLength;
    }

    public Track copy() {
        return new Track(mName, mLength);
    }
}
