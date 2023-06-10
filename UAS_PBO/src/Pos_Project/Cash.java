/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pos_Project;

import java.time.LocalDateTime;

/**
 *
 * @author LENOVO
 */
public class Cash implements Pembayaran {

    private int id;
    private float totalHarga;
    private LocalDateTime waktuPembayaran;
    private final float dibayar;
    private float kembalian;
    
    public Cash(float dibayar) {
        this.dibayar = dibayar;
    }
    
    @Override
    public float getTotalHarga() {
        return totalHarga;
    }

    @Override
    public void setTotalHarga(float totalHarga) {
        this.totalHarga = totalHarga;
        kembalian = dibayar - totalHarga;
    }

    @Override
    public LocalDateTime getWaktuPembayaran() {
        return waktuPembayaran;
    }

    @Override
    public void setWaktuPembayaran(LocalDateTime waktuPembayaran) {
        this.waktuPembayaran = waktuPembayaran;
    }

    @Override
    public int getIDPembayaran() {
        return id;
    }

    @Override
    public void setIDPembayaran(int IDPembayaran) {
        id = IDPembayaran;
    }
    
    public float getDibayar() {
        return dibayar;
    }

    /**
     * @return the kembalian
     */
    public float getKembalian() {
        return kembalian;
    }
}
