abstract class Property {
    private String namaProperti;
    private int noProperti;
    private double luas;
    private boolean isRented;
    private int hargaSewa;

    public Property(String namaProperti, int noProperti, double luas) {
        this.namaProperti = namaProperti;
        this.luas = luas;
        this.noProperti = noProperti;
        this.isRented = false;

    }

    public abstract int hitungHargaSewa();

    public abstract void info();
    public abstract void info(boolean i);

    public String getNamaProperti() {
        return namaProperti;
    }

    public int getnoProperti() {
        return noProperti;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public double getLuas() {
        return luas;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}