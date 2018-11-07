package com.romanso.java_8_lambdas.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class Artist {

    private String mName;
    private List<Artist> mMembers;
    private String mNationality;

    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        mName = name;
        mMembers = members;
        mNationality = nationality;
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return mName;
    }

    public Stream<Artist> getMembers() {
        return mMembers.stream();
    }

    public String getNationality() {
        return mNationality;
    }

    public boolean isSolo() {
        return mMembers.isEmpty();
    }

    public boolean isFrom(String nationality) {
        return mNationality.equals(nationality);
    }

    public Artist copy() {
        List<Artist> members = getMembers().map(Artist::copy).collect(toList());
        return new Artist(mName, members, mNationality);
    }
}
