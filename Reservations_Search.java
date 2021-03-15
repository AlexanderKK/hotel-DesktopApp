/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Stanislav
 */
public class Reservations_Search extends javax.swing.JFrame {
    public DefaultTableModel m;
    public ArrayList<String> getData = new ArrayList<>();
    public ArrayList<Integer> getDataInt = new ArrayList<>();
    /**
     * Creates new form Reservations_Search
     */
    public Reservations_Search() {
        initComponents();
        m = (DefaultTableModel) jTable2.getModel();
        this.setResizable(false);
        this.setTitle("SEARCH RESERVATIONS");
        JTableHeader tableHeader = jTable2.getTableHeader();
        Font HeaderFont = new Font("Felix Titling", Font.BOLD, 14);
        tableHeader.setFont(HeaderFont);
        HiddenLabel.setVisible(false);
        
//        String a = "";
//        for (int i = 0; i < 5; i++) {
//            a += " ";
//        }
//        System.out.println(a.length());
        
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setWidth(0);
        
//        jTable2.getColumnModel().getColumn(1).setPreferredWidth(30);
//        jTable2.getColumnModel().getColumn(2).setPreferredWidth(30);
//        jTable2.getColumnModel().getColumn(3).setPreferredWidth(20);
//        jTable2.getColumnModel().getColumn(4).setPreferredWidth(30);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(20);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(15);
//        jTable2.getColumnModel().getColumn(7).setPreferredWidth(30);
//        jTable2.getColumnModel().getColumn(8).setPreferredWidth(10);
//        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        fillTable();
        fillDiscountsBox();
        sumTotalIncome();
    }
    
    private void fillTable() {
        getData.clear();
        m.setRowCount(0);
        getData = DB_Connection.selectReservationsJoin();
        
        for (int i = 0; i < getData.size(); i++) {
            String[] arr = getData.get(i).split("_");
            m.addRow(new Object[] {
                arr[0], arr[1], arr[2], arr[3], arr[4].equals("RO") ? "Room Only" : arr[4].equals("BB") ? "Breakfast & Bed" : arr[4].equals("HB") ? "Breakfast & Dinner" : arr[4].equals("FB") ? "All Inclusive" : arr[4], arr[5].equals("0.0") ? "None" : arr[5] + " %", arr[6], arr[7].equals("1") ? arr[7] + " day" : arr[7] + " days", arr[8] + " €", arr[9]
            });
        }
        
        for (int i = 0; i < m.getRowCount(); i++) {
            if(m.getValueAt(i, 9).equals("VIP")) {
                m.setValueAt("None", i, 8);
            }
        }
        getData.clear();
        
    }
    
    private void sumTotalIncome() {
        double sum = 0;
        for (int i = 0; i < m.getRowCount(); i++) {
            if(m.getValueAt(i, 9).equals("Paid")) {
                String[] arr = String.valueOf(m.getValueAt(i, 8)).split(" ");
                double price = Double.parseDouble(arr[0]);
                sum += price;
            }            
        }
        sum = (double) Math.round(sum * 100) / 100;
        jLabel2.setText(String.valueOf(sum) + " €");
    }
    
    private void fillSearchInfo() {
        getData.clear();
        
        int row = jTable2.getSelectedRow();
        String firstname = String.valueOf(m.getValueAt(row, 1));
        String lastname = String.valueOf(m.getValueAt(row, 2));
        jTextField2.setText(firstname + " " + lastname);
        int id = Integer.parseInt(String.valueOf((m.getValueAt(row, 0))));
        HiddenLabel.setText("ID: " + String.valueOf(id));
        
        String[] whereColumn = {"Reservations.Reservation_ID"};
        int[] whereValue = {id};
        getData.clear();
        roomNumber.removeAllItems();
        getData = DB_Connection.selectRoomsJoin(whereColumn, whereValue);
        for (int i = 0; i < getData.size(); i++) {
            roomNumber.addItem(getData.get(i));
        }
        
        String docID = String.valueOf(m.getValueAt(row, 3));
        jTextField3.setText(docID);
        
        getData.clear();
        service.removeAllItems();
        getData = DB_Connection.selectServicesJoin(whereColumn, whereValue);
        for (int i = 0; i < getData.size(); i++) {
            service.addItem(getData.get(i));
        }
        
        getData.clear();
        String discount = String.valueOf(m.getValueAt(row, 5));
        String[] arr = discount.split(" ");
        getData = DB_Connection.selectWhere3(new String[] {"Company"},
        new String[] {"Discount"}, new String[] {arr[0]}, "Discounts");
        
        if(arr[0].equals("None")) {
            discountsBox.getModel().setSelectedItem("No Discount");
        }
        else {
            discountsBox.getModel().setSelectedItem(getData.get(0));
        }
        
        getData.clear();
    }
    
    private void fillDiscountsBox() {
        getData.clear();
        getData = DB_Connection.select(new String[] {"DiscountID", "Company"}, "Discounts");
        discountsBox.removeAllItems();
        discountsBox.addItem("Pick a Discount");
        String arr[];
        for (int i = 0; i < getData.size(); i++) {
            arr = getData.get(i).split("_");
            discountsBox.addItem(arr[1]);
        }
        getData.clear();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        discountsBox = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        roomNumber = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        service = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        HiddenLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Home = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        add_delete = new javax.swing.JMenuItem();
        update_delete = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        discountsBox.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        jButton3.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jButton3.setText("Filter by Discount Pass");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setText("Total income");

        jButton5.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jButton5.setText("Go Back");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        jTextField2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        roomNumber.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        service.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 0));
        jLabel3.setText("Client Name");

        jLabel4.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 0));
        jLabel4.setText("Room Number");

        jLabel5.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 0));
        jLabel5.setText("Document ID");

        jLabel6.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 0));
        jLabel6.setText("Service");

        jTable2.setFont(new java.awt.Font("Felix Titling", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation ID", "First  Name", "Last  Name", "Document  ID", "Breeding  Type", "Discount", "Reservation  Date", "Stay", "Total Price", "Payment  Status"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        HiddenLabel.setText("ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel5)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(roomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(discountsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(298, 298, 298))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel3)
                                .addGap(144, 144, 144)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(HiddenLabel)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HiddenLabel)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(discountsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jMenuBar1.setFont(new java.awt.Font("Felix Titling", 0, 14)); // NOI18N

        Home.setForeground(new java.awt.Color(98, 98, 98));
        Home.setText("Main Menu");
        Home.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HomeMousePressed(evt);
            }
        });
        jMenuBar1.add(Home);

        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(98, 98, 98));
        jMenu1.setText("Reservations");
        jMenu1.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu1MouseExited(evt);
            }
        });

        add_delete.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        add_delete.setForeground(new java.awt.Color(98, 98, 98));
        add_delete.setText("Add & DELETE");
        add_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_deleteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_deleteMousePressed(evt);
            }
        });
        add_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_deleteActionPerformed(evt);
            }
        });
        jMenu1.add(add_delete);

        update_delete.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        update_delete.setForeground(new java.awt.Color(98, 98, 98));
        update_delete.setText("UPDATE & DELETE");
        update_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                update_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                update_deleteMouseExited(evt);
            }
        });
        update_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_deleteActionPerformed(evt);
            }
        });
        jMenu1.add(update_delete);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(98, 98, 98));
        jMenu2.setText("Clients");
        jMenu2.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(98, 98, 98));
        jMenu3.setText("Rooms");
        jMenu3.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu5.setForeground(new java.awt.Color(98, 98, 98));
        jMenu5.setText("Services");
        jMenu5.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu5MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu4.setForeground(new java.awt.Color(98, 98, 98));
        jMenu4.setText("Discounts");
        jMenu4.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu4MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        setSize(new java.awt.Dimension(1496, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Do you wish to continue?", "Exit", JOptionPane.YES_NO_OPTION);
        if(result == 0){
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        else {
            this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        try {
            fillSearchInfo();
            int row = jTable2.getSelectedRow();
            double price = 0;
            if(m.getValueAt(row, 9).equals("Paid")) {
                String[] arr = String.valueOf(m.getValueAt(row, 8)).split(" ");
                price = Double.parseDouble(arr[0]);
                price = (double) Math.round(price * 100) / 100;
            }
            jLabel2.setText(String.valueOf(price) + " €");
        }
        catch(Exception e) {
            System.out.println("Initial Click");
        }
    }//GEN-LAST:event_jTable2MouseReleased

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        getData.clear();
        discountsBox.getModel().setSelectedItem("Pick a Discount");

        if(jTextField3.getText().isBlank()) {
            jTextField2.setText(jTextField3.getText());
            roomNumber.removeAllItems();
            service.removeAllItems();

            fillTable();
            sumTotalIncome();
            //            m.setRowCount(0);
            //            String name = jTextField3.getText();
            //            String[] whereValue = {name, name, name};
            //            getData = DB_Connection.selectWhereReservationsDocIDJoin(whereValue);
            //
            //            for (int i = 0; i < getData.size(); i++) {
                //                String[] arr = getData.get(i).split("_");
                //                m.addRow(new Object[] {
                    //                    arr[0], arr[1], arr[2], arr[3], arr[4].equals("RO") ? "Room Only" : arr[4].equals("BB") ? "Breakfast & Bed" : arr[4].equals("HB") ? "Breakfast & Dinner" : arr[4].equals("FB") ? "All Inclusive" : arr[4], arr[5].equals("0.0") ? "None" : arr[5] + " %", arr[6], arr[7] + " days", arr[8] + " €", arr[9]
                    //                });
            //            }
        //
        //            for (int i = 0; i < m.getRowCount(); i++) {
            //                if(m.getValueAt(i, 9).equals("VIP")) {
                //                    m.setValueAt("None", i, 8);
                //                }
            //            }
        //
        //            getData.clear();
        }

        else {
            m.setRowCount(0);
            String docID = jTextField3.getText();
            String[] whereValue = {docID, docID, docID};
            getData = DB_Connection.selectWhereReservationsDocIDJoin(whereValue);

            for (int i = 0; i < getData.size(); i++) {
                String[] arr = getData.get(i).split("_");
                jTextField2.setText(arr[1] + " " + arr[2]);
                m.addRow(new Object[] {
                    arr[0], arr[1], arr[2], arr[3], arr[4].equals("RO") ? "Room Only" : arr[4].equals("BB") ? "Breakfast & Bed" : arr[4].equals("HB") ? "Breakfast & Dinner" : arr[4].equals("FB") ? "All Inclusive" : arr[4], arr[5].equals("0.0") ? "None" : arr[5] + " %", arr[6], arr[7] + " days", arr[8] + " €", arr[9]
                });
            }

            for (int i = 0; i < m.getRowCount(); i++) {
                if(m.getValueAt(i, 9).equals("VIP")) {
                    m.setValueAt("None", i, 8);
                }
            }

            sumTotalIncome();

            getData.clear();
            roomNumber.removeAllItems();

            String[] whereColumn1 = {"DocumentID"};
            String docID1 = jTextField3.getText();
            String[] whereValue1 = {docID1};
            String[] groupColumn1 = {"Room_Number"};
            getData = DB_Connection.selectRoomsJoin2(whereColumn1, whereValue1, groupColumn1);
            for (int i = 0; i < getData.size(); i++) {
                roomNumber.addItem(getData.get(i));
            }

            getData.clear();
            service.removeAllItems();

            String[] whereColumn2 = {"DocumentID"};
            String docID2 = jTextField3.getText();
            String[] whereValue2 = {docID2};
            String[] groupColumn2 = {"Service_Type"};
            getData = DB_Connection.selectServicesJoin2(whereColumn2, whereValue2, groupColumn2);
            for (int i = 0; i < getData.size(); i++) {
                service.addItem(getData.get(i));
            }

            getData.clear();
        }

        getData.clear();
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
//         TODO add your handling code here:
        getData.clear();
        discountsBox.getModel().setSelectedItem("Pick a Discount");

        if(jTextField2.getText().isBlank()) {
            jTextField3.setText(jTextField2.getText());
            roomNumber.removeAllItems();
            service.removeAllItems();
            fillTable();
            sumTotalIncome();
            //                m.setRowCount(0);
            //                String name = jTextField2.getText();
            //                String[] whereValue = {name, name, name};
            //                getData = DB_Connection.selectWhereReservationsClientJoin(whereValue);
            //
            //                for (int i = 0; i < getData.size(); i++) {
                //                    String[] arr = getData.get(i).split("_");
                //                    m.addRow(new Object[] {
                    //                        arr[0], arr[1], arr[2], arr[3], arr[4].equals("RO") ? "Room Only" : arr[4].equals("BB") ? "Breakfast & Bed" : arr[4].equals("HB") ? "Breakfast & Dinner" : arr[4].equals("FB") ? "All Inclusive" : arr[4], arr[5].equals("0.0") ? "None" : arr[5] + " %", arr[6], arr[7] + " days", arr[8] + " €", arr[9]
                    //                    });
            //                }
        //
        //                for (int i = 0; i < m.getRowCount(); i++) {
            //                    if(m.getValueAt(i, 9).equals("VIP")) {
                //                        m.setValueAt("None", i, 8);
                //                    }
            //                }
        //
        //                getData.clear();

        }
        else {
            m.setRowCount(0);
            String name = jTextField2.getText();
            String[] whereValue = {name, name, name};
            getData = DB_Connection.selectWhereReservationsClientJoin(whereValue);
            for (int i = 0; i < getData.size(); i++) {
                String[] arr = getData.get(i).split("_");
                jTextField3.setText(arr[3]);
                m.addRow(new Object[] {
                    arr[0], arr[1], arr[2], arr[3], arr[4].equals("RO") ? "Room Only" : arr[4].equals("BB") ? "Breakfast & Bed" : arr[4].equals("HB") ? "Breakfast & Dinner" : arr[4].equals("FB") ? "All Inclusive" : arr[4], arr[5].equals("0.0") ? "None" : arr[5] + " %", arr[6], arr[7] + " days", arr[8] + " €", arr[9]
                });
            }

            for (int i = 0; i < m.getRowCount(); i++) {
                if(m.getValueAt(i, 9).equals("VIP")) {
                    m.setValueAt("None", i, 8);
                }
            }

            sumTotalIncome();

            getData.clear();
            roomNumber.removeAllItems();

//            String[] whereColumn1 = {"First_Name", "Last_Name"};
            String name1 = jTextField2.getText();
            String[] whereValue1 = {name1, name1, name1};
            String[] groupColumn1 = {"Room_Number"};
            getData = DB_Connection.selectRoomsJoinByClientName(whereValue1, groupColumn1);
            for (int i = 0; i < getData.size(); i++) {
                roomNumber.addItem(getData.get(i));
            }

            getData.clear();
            service.removeAllItems();

//            String[] whereColumn2 = {"First_Name", "Last_Name"};
            String name2 = jTextField2.getText();
            String[] whereValue2 = {name2, name2, name2};
            String[] groupColumn2 = {"Service_Type"};
            getData = DB_Connection.selectServicesJoinByClientName(whereValue2, groupColumn2);
            for (int i = 0; i < getData.size(); i++) {
                service.addItem(getData.get(i));
            }
            service.list();

            getData.clear();
        }
        getData.clear();
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        // TODO add your handling code here:
        Main_Menu Menu = new Main_Menu();
        this.dispose();
        Menu.setVisible(true);
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:
        if(discountsBox.getSelectedItem().equals("Pick a Discount")) {
            m.setRowCount(0);
            jTextField2.setText("");
            jTextField3.setText("");
            roomNumber.removeAllItems();
            service.removeAllItems();
            fillTable();
            sumTotalIncome();
        }
        else {
            jTextField2.setText("");
            jTextField3.setText("");
            roomNumber.removeAllItems();
            service.removeAllItems();
//        int ID = discountsBox.getSelectedIndex();
            String company = String.valueOf(discountsBox.getSelectedItem());
            getData.clear();

            getData = DB_Connection.selectWhere4(new String[] {"DiscountID"},
            new String[] {"Company"}, new String[] {company}, "Discounts");

            int discountID = Integer.parseInt(getData.get(0));

            String[] whereColumn = {"Discounts.DiscountID"};
            int[] whereValue = {discountID};
            
            getData.clear();
            
            getData = DB_Connection.selectReservationsByDiscountPassJoin(whereColumn, whereValue);

            m.setRowCount(0);

            for (int i = 0; i < getData.size(); i++) {
                String[] arr = getData.get(i).split("_");
                m.addRow(new Object[] {
                    arr[0], arr[1], arr[2], arr[3], arr[4].equals("RO") ? "Room Only" : arr[4].equals("BB") ? "Breakfast & Bed" : arr[4].equals("HB") ? "Breakfast & Dinner" : arr[4].equals("FB") ? "All Inclusive" : arr[4], arr[5].equals("0.0") ? "None" : arr[5] + " %", arr[6], arr[7] + " days", arr[8] + " €", arr[9]
                });
            }

            for (int i = 0; i < m.getRowCount(); i++) {
                if(m.getValueAt(i, 9).equals("VIP")) {
                    m.setValueAt("None", i, 8);
                }
            }

            sumTotalIncome();

            getData.clear();
            roomNumber.removeAllItems();

            String[] whereColumn1 = {"Discounts.DiscountID"};
            int[] whereValue1 = {discountID};
            String[] groupColumn1 = {"Room_Number"};
            getData = DB_Connection.selectRoomsJoin1(whereColumn1, whereValue1, groupColumn1);
            for (int i = 0; i < getData.size(); i++) {
                roomNumber.addItem(getData.get(i));
            }

            getData.clear();
            service.removeAllItems();

            String[] groupColumn2 = {"Service_Type"};
            getData = DB_Connection.selectServicesJoin1(whereColumn1, whereValue1, groupColumn2);
            for (int i = 0; i < getData.size(); i++) {
                service.addItem(getData.get(i));
            }

            getData.clear();
        }
    }//GEN-LAST:event_jButton3MouseReleased

    private void HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseEntered
        // TODO add your handling code here:
        Home.setForeground(new Color(172, 165, 31));

        jMenu1.setForeground(new Color(98, 98, 98));
        jMenu2.setForeground(new Color(98, 98, 98));
        jMenu3.setForeground(new Color(98, 98, 98));
        jMenu4.setForeground(new Color(98, 98, 98));
        jMenu5.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_HomeMouseEntered

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        // TODO add your handling code here:
        if(!Home.isSelected()) {
            Home.setForeground(new Color(98, 98, 98));
        }
    }//GEN-LAST:event_HomeMouseExited

    private void HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMousePressed
        // TODO add your handling code here:
        Main_Menu Menu = new Main_Menu();
        this.dispose();
        Menu.setVisible(true);
    }//GEN-LAST:event_HomeMousePressed

    private void add_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_deleteMouseEntered
        // TODO add your handling code here:
        add_delete.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_add_deleteMouseEntered

    private void add_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_deleteMouseExited
        // TODO add your handling code here:
        add_delete.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_add_deleteMouseExited

    private void add_deleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_deleteMousePressed
        // TODO add your handling code here:
        this.dispose();
        new Reservations_Add_Delete().setVisible(true);
    }//GEN-LAST:event_add_deleteMousePressed

    private void add_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_deleteActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Reservations_Add_Delete().setVisible(true);
    }//GEN-LAST:event_add_deleteActionPerformed

    private void update_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_deleteMouseEntered
        // TODO add your handling code here:
        update_delete.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_update_deleteMouseEntered

    private void update_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_deleteMouseExited
        // TODO add your handling code here:
        update_delete.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_update_deleteMouseExited

    private void update_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_deleteActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Reservations_Update_Delete().setVisible(true);
    }//GEN-LAST:event_update_deleteActionPerformed

    private void jMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseEntered
        // TODO add your handling code here:
        jMenu1.setForeground(new Color(172, 165, 31));

        Home.setForeground(new Color(98, 98, 98));
        jMenu2.setForeground(new Color(98, 98, 98));
        jMenu3.setForeground(new Color(98, 98, 98));
        jMenu4.setForeground(new Color(98, 98, 98));
        jMenu5.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu1MouseEntered

    private void jMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseExited
        // TODO add your handling code here:
        if(!jMenu1.isSelected()) {
            jMenu1.setForeground(new Color(98, 98, 98));
        }
    }//GEN-LAST:event_jMenu1MouseExited

    private void jMenu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseEntered
        // TODO add your handling code here:
        jMenu2.setForeground(new Color(172, 165, 31));

        Home.setForeground(new Color(98, 98, 98));
        jMenu1.setForeground(new Color(98, 98, 98));
        jMenu3.setForeground(new Color(98, 98, 98));
        jMenu4.setForeground(new Color(98, 98, 98));
        jMenu5.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu2MouseEntered

    private void jMenu2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseExited
        // TODO add your handling code here:
        if(!jMenu2.isSelected()) {
            jMenu2.setForeground(new Color(98, 98, 98));
        }
    }//GEN-LAST:event_jMenu2MouseExited

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        // TODO add your handling code here:
        this.dispose();
        new Clients_Add_Update_Delete().setVisible(true);
    }//GEN-LAST:event_jMenu2MousePressed

    private void jMenu3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseEntered
        // TODO add your handling code here:
        jMenu3.setForeground(new Color(172, 165, 31));

        Home.setForeground(new Color(98, 98, 98));
        jMenu1.setForeground(new Color(98, 98, 98));
        jMenu2.setForeground(new Color(98, 98, 98));
        jMenu4.setForeground(new Color(98, 98, 98));
        jMenu5.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu3MouseEntered

    private void jMenu3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseExited
        // TODO add your handling code here:
        if(!jMenu3.isSelected()) {
            jMenu3.setForeground(new Color(98, 98, 98));
        }
    }//GEN-LAST:event_jMenu3MouseExited

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        // TODO add your handling code here:
        this.dispose();
        new Rooms().setVisible(true);
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenu5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseEntered
        // TODO add your handling code here:
        jMenu5.setForeground(new Color(172, 165, 31));

        Home.setForeground(new Color(98, 98, 98));
        jMenu1.setForeground(new Color(98, 98, 98));
        jMenu2.setForeground(new Color(98, 98, 98));
        jMenu3.setForeground(new Color(98, 98, 98));
        jMenu4.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu5MouseEntered

    private void jMenu5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseExited
        // TODO add your handling code here:
        if(!jMenu5.isSelected()) {
            jMenu5.setForeground(new Color(98, 98, 98));
        }
    }//GEN-LAST:event_jMenu5MouseExited

    private void jMenu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MousePressed
        // TODO add your handling code here:
        this.dispose();
        new Services().setVisible(true);
    }//GEN-LAST:event_jMenu5MousePressed

    private void jMenu4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseEntered
        // TODO add your handling code here:
        jMenu4.setForeground(new Color(172, 165, 31));

        Home.setForeground(new Color(98, 98, 98));
        jMenu1.setForeground(new Color(98, 98, 98));
        jMenu2.setForeground(new Color(98, 98, 98));
        jMenu3.setForeground(new Color(98, 98, 98));
        jMenu5.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu4MouseEntered

    private void jMenu4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseExited
        // TODO add your handling code here:
        if(!jMenu4.isSelected()) {
            jMenu4.setForeground(new Color(98, 98, 98));
        }
    }//GEN-LAST:event_jMenu4MouseExited

    private void jMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MousePressed
        // TODO add your handling code here:
        this.dispose();
        new Discounts().setVisible(true);
    }//GEN-LAST:event_jMenu4MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservations_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservations_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservations_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservations_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservations_Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HiddenLabel;
    private javax.swing.JMenu Home;
    private javax.swing.JMenuItem add_delete;
    private javax.swing.JComboBox<String> discountsBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox<String> roomNumber;
    private javax.swing.JComboBox<String> service;
    private javax.swing.JMenuItem update_delete;
    // End of variables declaration//GEN-END:variables

    private Object getDataInt(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
