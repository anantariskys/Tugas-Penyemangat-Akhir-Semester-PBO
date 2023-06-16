public class LayananKebersihan implements Layanan{
    private String namaLayanan;
    private int hargaLayanan;
    LayananKebersihan(String namaLayanan,int hargaLayanan){
        this.namaLayanan = namaLayanan;
        this.hargaLayanan = hargaLayanan;
    }
    public int getHargaLayanan() {
        return hargaLayanan + hargaDasar;
    }
    public String getNamaLayanan() {
        return namaLayanan;
    }
    @Override
    public void infoLayanan() {
        System.out.println("Jenis Layanan : "+namaLayanan);
        System.out.println("Harga Layanan per meter : "+ hitungHarga()+" $");
    }
    @Override
    public int hitungHarga() {
        return hargaDasar + hargaLayanan;
    }
    
    
}
