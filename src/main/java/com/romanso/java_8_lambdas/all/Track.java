package com.romanso.java_8_lambdas.all;

public final class Track {

    private final String mName;
    private final int mLength;

    public Track(String name, int length) {
        mName = name;
        mLength = length;
    }

    @Override
    public String toString() {
        return String.format("%s [%d]", mName, mLength);
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
