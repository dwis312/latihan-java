public enum Gender {
    PRIA("Pria"),
    WANITA("Wanita");

    private final String deskripsi;

    Gender(String deskripsi) {
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
