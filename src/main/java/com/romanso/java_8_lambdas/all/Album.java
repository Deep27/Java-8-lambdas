package com.romanso.java_8_lambdas.all;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Album {

    private String mName;
    private List<Track> mTracks;
    private List<Artist> mMusicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);

        mName = name;
        mTracks = new ArrayList<>(tracks);
        mMusicians = new ArrayList<>(musicians);
    }

    public String getName() {
        return mName;
    }

    public Stream<Track> getTracks() {
        return mTracks.stream();
    }

    public List<Track> getTrackList() {
        return Collections.unmodifiableList(mTracks);
    }

    public Stream<Artist> getMusicians() {
        return mMusicians.stream();
    }

    public List<Artist> getMusicianList() {
        return Collections.unmodifiableList(mMusicians);
    }

    public Artist getMainMusician() {
        return mMusicians.get(0);
    }

    public Album copy() {
        List<Track> tracks = getTracks().map(Track::copy).collect(Collectors.toList());
        List<Artist> musicians = getMusicians().map(Artist::copy).collect(Collectors.toList());
        return new Album(mName, tracks, musicians);
    }
}
