class Apartment extends Property {
    private int lantai;

    public Apartment(String namaProperti,int noProperti, double luas, int lantai) {
        super(namaProperti,noProperti, luas);
        this.lantai = lantai;
        setHargaSewa(hitungHargaSewa());
        
    }

    @Override
    public int hitungHargaSewa() {
        // Harga sewa apartemen dihitung berdasarkan luas dan lantai
        int sewaLuas = (int)getLuas() * 25;
        int sewaLantai = lantai * 30;
        return sewaLantai + sewaLuas;
    }

    // Getter dan setter
    public int getLantai() {
        return lantai;
    }

    

    @Override
    public void info() {
        System.out.println("Nama Properti : "+getNamaProperti());
        System.out.println("No properti : " + getnoProperti());
        System.out.println("Luas: " + getLuas() + " m²");
        System.out.println("Status: " + (isRented() ? "Tersewa" : "Belum Tersewa"));
        System.out.println("Harga Sewa : "+getHargaSewa()+" $ per 6 Bulan");
    }
    public void info(boolean i){
        System.out.println("Nama Properti : "+getNamaProperti());
        System.out.println("No properti : " + getnoProperti());
        System.out.println("Luas: " + getLuas() + " m²");
        System.out.println("Harga Sewa : "+getHargaSewa()+" $ per 6 Bulan");
        System.out.println("Lama sewa : "+ Sewa.getLamaSewa() + " tahun");
    }

    

    

    
}