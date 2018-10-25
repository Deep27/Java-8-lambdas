## Problem domain example: music
### Artist
* _name_: The name of the artist (e.g., "Metallica")
* _members_: A set of other artists who comprise this group (e.g. "James Hetfield");
    this field might be empty
* _origin_: The primary location of origin of the group (e.g. "USA").

### Track
A single piece of music

* _name_: The name of the track (e.g., "Ride the lightning")

### Album
* _name_: The name of the album (e.g., "For whom the bell tolls")
* _tracks_: A list of tracks
* _musicians_: A list of artists who helped create the music on this album

### Important functional interfaces
        ---------------------------------------------------------------------------------
        | Interface         | Arguments | Returnns | Example                            |
        ---------------------------------------------------------------------------------
        | Predicate<T>      | T         | boolean  | Has this album been released yet?  |
        | Consumer<T>       | T         | void     | Printing out a value               |
        | Function<T,R>     | T         | R        | Get the name from an Artist object |
        | Supplier<T>       | None      | T        | A factory method                   |
        | UnaryOperator<T>  | T         | T        | Logical not (!)                    |
        | BinaryOperator<T> | (T,T)     | T        | Multiplying two numbers (*)        |
        ---------------------------------------------------------------------------------
