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
class Pulsa extends Barang {
    private String operator;
    private String noTelp;
    private float nominal;
    static ArrayList<Pulsa> daftarPulsa;
    
    public static void loadPulsaFromDB() {
        daftarPulsa = new ArrayList<Pulsa>();
        Pulsa pulsa;     
        
        try {
            Statement stmt = DBConnector.connection.createStatement();
            String sql = "SELECT * FROM pulsa";
        
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next())
            {
                pulsa = new Pulsa();
                pulsa.kode = Integer.toString(rs.getInt("kode"));
                pulsa.setOperator(rs.getString("operator"));
                pulsa.setNominal(rs.getFloat("nominal"));
                daftarPulsa.add(pulsa);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static Pulsa getPulsa(String kode) {
        for (int i = 0; i < daftarPulsa.size(); i++) {
            var pulsa = daftarPulsa.get(i);
            
            if (pulsa.kode.equals(kode)) {
                return pulsa;
            }
        }
        
        return null;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return the noTelp
     */
    public String getNoTelp() {
        return noTelp;
    }

    /**
     * @param noTelp the noTelp to set
     */
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
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
}
