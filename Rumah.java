class Rumah extends Property  {
    private int kamar;
    private boolean punyaTaman;

    public Rumah(String namaProperti,int noProperti, double luas, int kamar, boolean hasGarden) {
        super(namaProperti,noProperti, luas);
        this.kamar = kamar;
        this.punyaTaman = hasGarden;
        this.setHargaSewa(hitungHargaSewa());
    }

    @Override
    public int hitungHargaSewa() {
        // Harga sewa rumah dihitung berdasarkan luas dan jumlah kamar tidur
        int sewaLuas =(int)getLuas() * 10;
        int sewaKamar = kamar * 50;
        if (punyaTaman) {
            return sewaLuas + kamar + 8;    
        }
        else{
            return sewaLuas + kamar;
        }
        
    }

    // Getter dan setter
    public int getkamar() {
        return kamar;
    }

    public boolean hasGarden() {
        return punyaTaman;
    }

    public void setHasGarden(boolean hasGarden) {
        this.punyaTaman = hasGarden;
    }

    @Override
    public void info() {
        System.out.println("Nama Properti : "+getNamaProperti());
        System.out.println("No properti : " + getnoProperti());
        System.out.println("Luas: " + getLuas() + " m²");
        System.out.println("Status: " + (isRented() ? "Tersewa" : "Belum Tersewa"));
        System.out.println("Harga Sewa : "+getHargaSewa()+" $ per 6 Bulan");
    }
    public void info(boolean i) {
        System.out.println("Nama Properti : "+getNamaProperti());
        System.out.println("No properti : " + getnoProperti());
        System.out.println("Luas: " + getLuas() + " m²");
        System.out.println("Harga Sewa : "+getHargaSewa()+" $ per 6 Bulan");
        System.out.println("Lama sewa : "+ Sewa.getLamaSewa()+ " tahun");
    }

}
