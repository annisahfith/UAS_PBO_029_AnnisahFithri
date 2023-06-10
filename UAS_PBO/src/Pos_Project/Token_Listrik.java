/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pos_Project;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
class Token_Listrik extends Barang {

    /**
     * @return the noMeteran
     */
    public String getNoMeteran() {
        return noMeteran;
    }

    /**
     * @param noMeteran the noMeteran to set
     */
    public void setNoMeteran(String noMeteran) {
        this.noMeteran = noMeteran;
    }

    /**
     * @return the nominal
     */
    public float getNominal() {
        return nominal;
    }

    /**
     * @param nominal the nominal to set
     */
    public void setNominal(float nominal) {
        this.nominal = nominal;
    }

    /**
     * @return the token
     */
    public long getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(long token) {
        this.token = token;
    }

    private String noMeteran;
    private float nominal;
    private long token;
    static ArrayList<Token_Listrik> daftarToken;

    public static void loadTokenFromDB() {
        daftarToken = new ArrayList<Token_Listrik>();
        Token_Listrik token;     
        
        try {
            Statement stmt = DBConnector.connection.createStatement();
            String sql = "SELECT * FROM pln   ";
        
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next())
            {
                token= new Token_Listrik();
                token.kode = Integer.toString(rs.getInt("kode"));
                token.nama = rs.getString("nama");
                token.setNominal(rs.getFloat("nominal"));
                daftarToken.add(token);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static Token_Listrik getToken(String kode) {
        for (int i = 0; i < daftarToken.size(); i++) {
            var token = daftarToken.get(i);
            
            if (token.kode.equals(kode)) {
                return token;
            }
        }
        
        return null;
    }
}
