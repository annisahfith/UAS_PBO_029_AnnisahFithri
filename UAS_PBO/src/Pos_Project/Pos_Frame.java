/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pos_Project;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author LENOVO
 */
public class Pos_Frame extends javax.swing.JFrame {

    ArrayList<Makanan> daftarMakanan;
    ArrayList<Pulsa> daftarPulsa;
    ArrayList<Token_Listrik> daftarToken;
    TableModel daftarModel;
    
    QRIS qris = null;
    int totalBarang;
    int totalBelanja;
    int jenisItem = 0;

    /**
     * Creates new form POSFrame
     */
    public Pos_Frame() {

        DBConnector.initDBConnection();

        Makanan.loadMakananFromDB();
        Pulsa.loadPulsaFromDB();
        Token_Listrik.loadTokenFromDB();
        
        daftarPulsa = Pulsa.daftarPulsa;
        daftarMakanan = Makanan.daftarMakanan;
        daftarToken = Token_Listrik.daftarToken;
        
        initComponents();

        daftarModel = daftarTable.getModel();
        daftarModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                if (e.getColumn() == 4) {
                    var baris = e.getFirstRow();

                    var harga = (float) daftarModel.getValueAt(baris, 3);
                    var jumlah = (int) daftarModel.getValueAt(baris, 4);

                    var total = harga * jumlah;
                    daftarModel.setValueAt(total, baris, 5);

                    totalBelanja = 0;

                    for (int i = 0; i < totalBarang; i++) {
                        total = (float) daftarModel.getValueAt(i, 5);
                        totalBelanja += total;
                    }

                    totalBelanjaTextField.setText(String.format("%,d", totalBelanja));
                }
            }
        });
    }

    
    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dialogPembayaranKas = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        nominalKasTextField = new javax.swing.JTextField();
        konfirmasiKasButton = new javax.swing.JButton();
        batalKasButton = new javax.swing.JButton();
        dialogPembayaranKartuDebit = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        bankTextField = new javax.swing.JTextField();
        konfirmasiKartuDebitButton = new javax.swing.JButton();
        batalKartuDebitButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        nomorKartuTextField = new javax.swing.JTextField();
        dialogPembayaranQRIS = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        kontenTextField = new javax.swing.JTextField();
        konfirmasiQRISButton = new javax.swing.JButton();
        batalQRISButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        requestDateTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        invoiceIDTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kodeTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        ketTextField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        daftarTable = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        totalBelanjaTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        togglePulsa = new javax.swing.JToggleButton();
        togglePLN = new javax.swing.JToggleButton();
        toggleFood = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        comboBoxMetodePembayaran = new javax.swing.JComboBox<>();
        transaksiButton = new javax.swing.JButton();
        kembaliBtn = new javax.swing.JButton();
        BatalBtn = new javax.swing.JButton();

        dialogPembayaranKas.setTitle("Transaksi Kas");
        dialogPembayaranKas.setModal(true);
        dialogPembayaranKas.setResizable(false);
        dialogPembayaranKas.setSize(new java.awt.Dimension(0, 0));

        jLabel5.setText("Uang Dibayar");

        konfirmasiKasButton.setText("Ok");
        konfirmasiKasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfirmasiKasButtonActionPerformed(evt);
            }
        });

        batalKasButton.setText("Batal");
        batalKasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalKasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogPembayaranKasLayout = new javax.swing.GroupLayout(dialogPembayaranKas.getContentPane());
        dialogPembayaranKas.getContentPane().setLayout(dialogPembayaranKasLayout);
        dialogPembayaranKasLayout.setHorizontalGroup(
            dialogPembayaranKasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPembayaranKasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(dialogPembayaranKasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogPembayaranKasLayout.createSequentialGroup()
                        .addComponent(batalKasButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(konfirmasiKasButton))
                    .addComponent(nominalKasTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        dialogPembayaranKasLayout.setVerticalGroup(
            dialogPembayaranKasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPembayaranKasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogPembayaranKasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nominalKasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPembayaranKasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batalKasButton)
                    .addComponent(konfirmasiKasButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogPembayaranKartuDebit.setTitle("Transaksi Kartu Kredit");
        dialogPembayaranKartuDebit.setModal(true);

        jLabel9.setText("Bank");

        konfirmasiKartuDebitButton.setText("Ok");
        konfirmasiKartuDebitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfirmasiKartuDebitButtonActionPerformed(evt);
            }
        });

        batalKartuDebitButton.setText("Batal");
        batalKartuDebitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalKartuDebitButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Nomor Kartu");

        javax.swing.GroupLayout dialogPembayaranKartuDebitLayout = new javax.swing.GroupLayout(dialogPembayaranKartuDebit.getContentPane());
        dialogPembayaranKartuDebit.getContentPane().setLayout(dialogPembayaranKartuDebitLayout);
        dialogPembayaranKartuDebitLayout.setHorizontalGroup(
            dialogPembayaranKartuDebitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPembayaranKartuDebitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogPembayaranKartuDebitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPembayaranKartuDebitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogPembayaranKartuDebitLayout.createSequentialGroup()
                        .addComponent(batalKartuDebitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(konfirmasiKartuDebitButton))
                    .addComponent(bankTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(nomorKartuTextField))
                .addContainerGap())
        );
        dialogPembayaranKartuDebitLayout.setVerticalGroup(
            dialogPembayaranKartuDebitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPembayaranKartuDebitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogPembayaranKartuDebitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(bankTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPembayaranKartuDebitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nomorKartuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPembayaranKartuDebitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batalKartuDebitButton)
                    .addComponent(konfirmasiKartuDebitButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogPembayaranQRIS.setTitle("Transaksi QRIS");
        dialogPembayaranQRIS.setModal(true);

        jLabel6.setText("Content");

        kontenTextField.setEditable(false);

        konfirmasiQRISButton.setText("Scan");
        konfirmasiQRISButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfirmasiQRISButtonActionPerformed(evt);
            }
        });

        batalQRISButton.setText("Batal");
        batalQRISButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalQRISButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Tanggal req.");

        requestDateTextField.setEditable(false);

        jLabel11.setText("Invoice ID");

        invoiceIDTextField.setEditable(false);

        javax.swing.GroupLayout dialogPembayaranQRISLayout = new javax.swing.GroupLayout(dialogPembayaranQRIS.getContentPane());
        dialogPembayaranQRIS.getContentPane().setLayout(dialogPembayaranQRISLayout);
        dialogPembayaranQRISLayout.setHorizontalGroup(
            dialogPembayaranQRISLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPembayaranQRISLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogPembayaranQRISLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPembayaranQRISLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogPembayaranQRISLayout.createSequentialGroup()
                        .addComponent(batalQRISButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(konfirmasiQRISButton))
                    .addComponent(kontenTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(requestDateTextField)
                    .addComponent(invoiceIDTextField))
                .addContainerGap())
        );
        dialogPembayaranQRISLayout.setVerticalGroup(
            dialogPembayaranQRISLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPembayaranQRISLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogPembayaranQRISLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kontenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPembayaranQRISLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(requestDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPembayaranQRISLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(invoiceIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dialogPembayaranQRISLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batalQRISButton)
                    .addComponent(konfirmasiQRISButton))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Kode");

        jLabel2.setText("Nama");

        jLabel3.setText("Harga");

        kodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeTextFieldActionPerformed(evt);
            }
        });
        kodeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kodeTextFieldKeyReleased(evt);
            }
        });

        namaTextField.setEditable(false);

        ketTextField.setEditable(false);
        ketTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ketTextFieldActionPerformed(evt);
            }
        });

        daftarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode", "Nama", "Harga Satuan", "Jumlah", "Total", "Keterangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        daftarTable.setShowGrid(true);
        jScrollPane1.setViewportView(daftarTable);
        if (daftarTable.getColumnModel().getColumnCount() > 0) {
            daftarTable.getColumnModel().getColumn(0).setResizable(false);
            daftarTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            daftarTable.getColumnModel().getColumn(1).setResizable(false);
            daftarTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            daftarTable.getColumnModel().getColumn(2).setResizable(false);
            daftarTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            daftarTable.getColumnModel().getColumn(3).setResizable(false);
            daftarTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            daftarTable.getColumnModel().getColumn(4).setResizable(false);
            daftarTable.getColumnModel().getColumn(4).setPreferredWidth(20);
            daftarTable.getColumnModel().getColumn(5).setResizable(false);
            daftarTable.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        totalBelanjaTextField.setEditable(false);
        totalBelanjaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBelanjaTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Belanja");

        buttonGroup1.add(togglePulsa);
        togglePulsa.setText("Pulsa");
        togglePulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togglePulsaActionPerformed(evt);
            }
        });

        buttonGroup1.add(togglePLN);
        togglePLN.setText("Token Listrik");
        togglePLN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togglePLNActionPerformed(evt);
            }
        });

        buttonGroup1.add(toggleFood);
        toggleFood.setText("Belanja");
        toggleFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleFoodActionPerformed(evt);
            }
        });

        jLabel7.setText("Metode Pembayaran");

        comboBoxMetodePembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Credit Card", "QRIS" }));
        comboBoxMetodePembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMetodePembayaranActionPerformed(evt);
            }
        });

        transaksiButton.setText("Transaksi");
        transaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiButtonActionPerformed(evt);
            }
        });

        kembaliBtn.setText("Kembali");
        kembaliBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliBtnActionPerformed(evt);
            }
        });

        BatalBtn.setText("Batal");
        BatalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatalBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2)
                                    .addComponent(jSeparator1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(182, 182, 182)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboBoxMetodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(totalBelanjaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(135, 135, 135))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ketTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BatalBtn)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(togglePulsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(toggleFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(togglePLN, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(transaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(kembaliBtn)
                .addGap(154, 154, 154))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kembaliBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ketTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BatalBtn)
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggleFood, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(togglePLN, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(togglePulsa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(totalBelanjaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxMetodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(transaksiButton)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeTextFieldActionPerformed
        var kodeInput = kodeTextField.getText();
        if (jenisItem == 0) {
            var makanan = Makanan.getMakanan(kodeInput);
            if (makanan != null) {
                var kadaluarsa = makanan.getKadaluarsa();
                kadaluarsa = kadaluarsa.plus(1, ChronoUnit.WEEKS);
                for (int i = 0; i < totalBarang; i++) {
                    var kode = daftarModel.getValueAt(i, 1);
                    if (kode.equals(kodeInput)) {
                        JOptionPane.showMessageDialog(this, "Edit kolom jumlah!");
                        return;
                    }
                }

                int tempIndex = totalBarang;

                totalBarang++;

                System.out.println("Barang ditemukan!");
                namaTextField.setText(makanan.nama);
                ketTextField.setText(Float.toString(makanan.harga));

                daftarModel.setValueAt(totalBarang, tempIndex, 0);
                daftarModel.setValueAt(kodeInput, tempIndex, 1);
                daftarModel.setValueAt(makanan.nama, tempIndex, 2);
                daftarModel.setValueAt(makanan.harga, tempIndex, 3);
                daftarModel.setValueAt(1, tempIndex, 4);
                daftarModel.setValueAt(makanan.harga, tempIndex, 5);
                daftarModel.setValueAt(kadaluarsa, tempIndex, 6);
            }
            
            if (makanan == null) {
                JOptionPane.showMessageDialog(this, "Kode Barang tidak terdaftar!");
            }

        }
        if (jenisItem == 1) {
            var token = Token_Listrik.getToken(kodeInput);
            if (token != null) {
                System.out.println("Kode LPB ditemukan!");
                namaTextField.setText(token.nama);
                ketTextField.setEditable(true);
            }
            
            if (token == null) {
                JOptionPane.showMessageDialog(this, "Kode LPB tidak terdaftar!");
            }
        }
        
        if (jenisItem == 2) {
            var pulsa = Pulsa.getPulsa(kodeInput);
            if (pulsa != null) {
                System.out.println("Operator ditemukan!");
                namaTextField.setText(pulsa.getOperator() + " " + pulsa.getNominal());
                ketTextField.setEditable(true);
            }
            
            if (pulsa == null) {
                JOptionPane.showMessageDialog(this, "Kode Operator tidak terdaftar!");
            }
        }

    }//GEN-LAST:event_kodeTextFieldActionPerformed

    private void kodeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodeTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeTextFieldKeyReleased

    private void ketTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ketTextFieldActionPerformed
        // TODO add your handling code here:
        if (jenisItem == 1) {
            var meteran = ketTextField.getText();
            var kodeInput = kodeTextField.getText();
            var token = Token_Listrik.getToken(kodeInput);
            token.setNoMeteran(meteran);
            float hargaToken = token.getNominal() + 1000;
            long nomorToken = (long) (Math.random() * 1000000000000000L);
            token.setToken(nomorToken);
            int tempIndex = totalBarang;
            totalBarang++;
            daftarModel.setValueAt(totalBarang, tempIndex, 0);
            daftarModel.setValueAt(kodeInput, tempIndex, 1);
            daftarModel.setValueAt(token.nama, tempIndex, 2);
            daftarModel.setValueAt(hargaToken, tempIndex, 3);
            daftarModel.setValueAt(1, tempIndex, 4);
            daftarModel.setValueAt(hargaToken, tempIndex, 5);
            daftarModel.setValueAt(token.getToken(), tempIndex, 6);
        }
        if (jenisItem == 2) {
            var nomorHp = ketTextField.getText();
            var kodeInput = kodeTextField.getText();
            var pulsa = Pulsa.getPulsa(kodeInput);
            pulsa.setNoTelp(nomorHp);
            float hargaPulsa = pulsa.getNominal() + 2000;
            int tempIndex = totalBarang;
            totalBarang++;
            daftarModel.setValueAt(totalBarang, tempIndex, 0);
            daftarModel.setValueAt(kodeInput, tempIndex, 1);
            daftarModel.setValueAt(pulsa.getOperator() + " " + pulsa.getNominal(), tempIndex, 2);
            daftarModel.setValueAt(hargaPulsa, tempIndex, 3);
            daftarModel.setValueAt(1, tempIndex, 4);
            daftarModel.setValueAt(hargaPulsa, tempIndex, 5);
            daftarModel.setValueAt(pulsa.getNoTelp(), tempIndex, 6);
        }
    }//GEN-LAST:event_ketTextFieldActionPerformed

    private void totalBelanjaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBelanjaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalBelanjaTextFieldActionPerformed

    private void toggleFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleFoodActionPerformed
        // TODO add your handling code here:
        if (toggleFood.isSelected()) {
            jenisItem = 0;
            jLabel3.setText("Harga");
            ketTextField.setEditable(false);
        }
    }//GEN-LAST:event_toggleFoodActionPerformed

    private void togglePLNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglePLNActionPerformed
        // TODO add your handling code here:
        if (togglePLN.isSelected()) {
            jenisItem = 1;
            jLabel3.setText("No. Meteran");
        }
    }//GEN-LAST:event_togglePLNActionPerformed

    private void togglePulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglePulsaActionPerformed
        // TODO add your handling code here:
        if (togglePulsa.isSelected()) {
            jenisItem = 2;
            jLabel3.setText("No. Telepon/HP");

        }
    }//GEN-LAST:event_togglePulsaActionPerformed

    private void transaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiButtonActionPerformed
        var caraPembayaran = comboBoxMetodePembayaran.getSelectedIndex();
        JDialog dialog = null;
        
        switch (caraPembayaran) {
            case 0:
                dialog = dialogPembayaranKas;
                break;
            case 1:
                dialog = dialogPembayaranKartuDebit;
                break;
            case 2:
                dialog = dialogPembayaranQRIS;
                qris = new QRIS(LocalDateTime.now());
                qris.setIDPembayaran(getIdTransaksi() + 1);
                qris.setTotalHarga(totalBelanja);
                qris.setWaktuPembayaran(LocalDateTime.now());
                kontenTextField.setText(qris.getKonten());
                requestDateTextField.setText(qris.getRequestDate().toString());
                invoiceIDTextField.setText(qris.getInvoiceID());
                break;
        }
        
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_transaksiButtonActionPerformed

    private void batalKasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalKasButtonActionPerformed
        dialogPembayaranKas.setVisible(false);
    }//GEN-LAST:event_batalKasButtonActionPerformed

    private void batalKartuDebitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalKartuDebitButtonActionPerformed
        dialogPembayaranKartuDebit.setVisible(false);
    }//GEN-LAST:event_batalKartuDebitButtonActionPerformed

    private void batalQRISButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalQRISButtonActionPerformed
        dialogPembayaranQRIS.setVisible(false);
    }//GEN-LAST:event_batalQRISButtonActionPerformed

    private void konfirmasiKasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfirmasiKasButtonActionPerformed
        String nominalString = nominalKasTextField.getText();
        nominalString = nominalString.replace(",", "");
        var nominal = Integer.valueOf(nominalString);
        
        var cash = new Cash(nominal);
        cash.setIDPembayaran(getIdTransaksi());
        cash.setTotalHarga(totalBelanja);
        cash.setWaktuPembayaran(LocalDateTime.now());
        
        if (rekamTransaksi()) {
            try {
                Statement stmt = DBConnector.connection.createStatement();
                Statement stmt2 = DBConnector.connection.createStatement();
                
                String sql = String.format("INSERT INTO kas (id, dibayar, kembalian) VALUES (%d, %f, %f)", getIdTransaksi(), cash.getDibayar(), cash.getKembalian());
                stmt.executeUpdate(sql);
                String sql2 = "SELECT * FROM transaksi";
                ResultSet rs2 = stmt2.executeQuery(sql2);
                
                var id = 0;
                while (rs2.next()) {
                    id = Math.max(id, rs2.getInt("id"));
                }

                JOptionPane.showMessageDialog(this, "Transaksi berhasil dilakukan" + "\nKembalian : " + (nominal-totalBelanja));
            } catch (SQLException ex) {
                Logger.getLogger(Pos_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Transaksi Gagal");
        }
        
        dialogPembayaranKas.setVisible(false);
    }//GEN-LAST:event_konfirmasiKasButtonActionPerformed

    private void konfirmasiKartuDebitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfirmasiKartuDebitButtonActionPerformed
        var debitCard = new Credit_Card(bankTextField.getText(), nomorKartuTextField.getText());
        debitCard.setIDPembayaran(getIdTransaksi());
        debitCard.setTotalHarga(totalBelanja);
        debitCard.setWaktuPembayaran(LocalDateTime.now());
        
        if (rekamTransaksi()) {
            try {
                Statement stmt = DBConnector.connection.createStatement();
                Statement stmt2 = DBConnector.connection.createStatement();
                
                String sql = String.format("INSERT INTO kartu_debit (id, bank, nomor_kartu) VALUES (%d, \"%s\", \"%s\")", getIdTransaksi(), debitCard.getBank(), debitCard.getNomorKartu());
                stmt.executeUpdate(sql);
                String sql2 = "SELECT * FROM transaksi";
                ResultSet rs2 = stmt2.executeQuery(sql2);
                
                var id = 0;
                while (rs2.next()) {
                    id = Math.max(id, rs2.getInt("id"));
                }

                JOptionPane.showMessageDialog(this, "Transaksi berhasil dilakukan");
            } catch (SQLException ex) {
                Logger.getLogger(Pos_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Transaksi Gagal");
        }
        
        dialogPembayaranKartuDebit.setVisible(false);
    }//GEN-LAST:event_konfirmasiKartuDebitButtonActionPerformed

    private void konfirmasiQRISButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfirmasiQRISButtonActionPerformed
        if (rekamTransaksi() && qris != null) {
            try {
                Statement stmt = DBConnector.connection.createStatement();
                Statement stmt2 = DBConnector.connection.createStatement();
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String sql = String.format("INSERT INTO qris (id, konten, request_date) VALUES (%d, \"%s\", \"%s\")", getIdTransaksi(), qris.getKonten(), qris.getRequestDate().format(formatter));
                stmt.executeUpdate(sql);
                String sql2 = "SELECT * FROM transaksi";
                ResultSet rs2 = stmt2.executeQuery(sql2);
 
                var id = 0;
                while (rs2.next()) {
                    id = Math.max(id, rs2.getInt("id"));
                }

                JOptionPane.showMessageDialog(this, "Transaksi berhasil dilakukan");
            } catch (SQLException ex) {
                Logger.getLogger(Pos_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Transaksi Gagal");
        }
        dialogPembayaranQRIS.setVisible(false); }
    /*
        dialogPembayaranQRIS.setVisible(false);    }//GEN-LAST:event_konfirmasiQRISButtonActionPerformed
*/
    private void kembaliBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliBtnActionPerformed
        // TODO add your handling code here:
        new LoginForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_kembaliBtnActionPerformed

    private void comboBoxMetodePembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMetodePembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMetodePembayaranActionPerformed

    private void BatalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatalBtnActionPerformed
        // TODO add your handling code here:
       kodeTextField.setText("");
       namaTextField.setText("");
       ketTextField.setText("");
       totalBelanjaTextField.setText("");
    
    }//GEN-LAST:event_BatalBtnActionPerformed

    private boolean rekamTransaksi() {
        try {
            Statement stmtInsertTransac = DBConnector.connection.createStatement();

            var now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String sqlInsertTransac = String.format("INSERT INTO transaksi (total_harga, waktu_pembayaran) VALUES (%d, \"%s\")", totalBelanja, now.format(formatter));
            stmtInsertTransac.executeUpdate(sqlInsertTransac);

        } catch (Exception e) {
            Logger.getLogger(Pos_Frame.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

        return true;
    }

    private int getIdTransaksi() {
        var max = 0;

        try {
            Statement stmt = DBConnector.connection.createStatement();

            String sql = "SELECT * FROM transaksi";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                max = Math.max(max, rs.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pos_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return max;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BatalBtn;
    private javax.swing.JTextField bankTextField;
    private javax.swing.JButton batalKartuDebitButton;
    private javax.swing.JButton batalKasButton;
    private javax.swing.JButton batalQRISButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboBoxMetodePembayaran;
    private javax.swing.JTable daftarTable;
    private javax.swing.JDialog dialogPembayaranKartuDebit;
    private javax.swing.JDialog dialogPembayaranKas;
    private javax.swing.JDialog dialogPembayaranQRIS;
    private javax.swing.JTextField invoiceIDTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton kembaliBtn;
    private javax.swing.JTextField ketTextField;
    private javax.swing.JTextField kodeTextField;
    private javax.swing.JButton konfirmasiKartuDebitButton;
    private javax.swing.JButton konfirmasiKasButton;
    private javax.swing.JButton konfirmasiQRISButton;
    private javax.swing.JTextField kontenTextField;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JTextField nominalKasTextField;
    private javax.swing.JTextField nomorKartuTextField;
    private javax.swing.JTextField requestDateTextField;
    private javax.swing.JToggleButton toggleFood;
    private javax.swing.JToggleButton togglePLN;
    private javax.swing.JToggleButton togglePulsa;
    private javax.swing.JTextField totalBelanjaTextField;
    private javax.swing.JButton transaksiButton;
    // End of variables declaration//GEN-END:variables
}
