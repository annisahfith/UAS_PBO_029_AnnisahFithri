/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pos_Project;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
class Makanan extends Barang {
    private LocalDate expire_date = LocalDate.now();
    static ArrayList<Makanan> daftarMakanan;
    
    public static void loadMakananFromDB() {
        daftarMakanan = new ArrayList<Makanan>();
        Makanan makanan;
        
        try {
            Statement stmt = DBConnector.connection.createStatement();
            String sql = "SELECT * FROM barang";
        
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next())
            {
                makanan = new Makanan();
                makanan.kode = Integer.toString(rs.getInt("kode"));
                makanan.nama = rs.getString("nama");
                makanan.harga = rs.getFloat("harga");
                daftarMakanan.add(makanan);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static Makanan getMakanan(String kode) {
        for (int i = 0; i < daftarMakanan.size(); i++) {
            var makanan = daftarMakanan.get(i);
            
            if (makanan.kode.equals(kode)) {
                return makanan;
            }
        }
        
        return null;
    }

    /**
     * @return the expire_date
     */
    public LocalDate getKadaluarsa() {
        return expire_date;
    }

    /**
     * @param kadaluarsa the expire_date to set
     */
    public void setKadaluarsa(LocalDate expire_date) {
        this.expire_date = expire_date;
    }
}
