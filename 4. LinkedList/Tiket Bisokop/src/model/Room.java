package model;

public enum Room {
    Cinema1("Cinema 1: Batman Begin"),
    Cinema2("Cinema 2: Dragon ball Z"),
    Cinema3("Cinema 3: Warkop DKI"),
    Cinema4("Cinema 4: Naga Bonar");

    private final String deskripsi;

    Room(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    @Override
    public String toString() {
        return deskripsi;
    }

}
