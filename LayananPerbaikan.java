public class LayananPerbaikan implements Layanan {
    private String namaLayanan;
    private int hargaLayanan;
    LayananPerbaikan(String namaLayanan,int hargaLayanan){
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
        System.out.println("Nama Layanan : "+namaLayanan);
        System.out.println("Harga Layanan per 3 bulan : " + hitungHarga() + " $");
    }

    @Override
    public int hitungHarga() {
        return hargaDasar + hargaLayanan;
    }
}
