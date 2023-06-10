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
public interface Pembayaran {
    float getTotalHarga();
    void setTotalHarga(float totalHarga);
    
    LocalDateTime getWaktuPembayaran();
    void setWaktuPembayaran(LocalDateTime waktuPembayaran);
    
    int getIDPembayaran();
    void setIDPembayaran(int IDPembayaran);
}
