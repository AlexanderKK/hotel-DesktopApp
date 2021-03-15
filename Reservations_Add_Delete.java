/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.sql.*;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author ALEX
 */
public class Reservations_Add_Delete extends javax.swing.JFrame {
    public DefaultTableModel m;
    DefaultListModel list = new DefaultListModel();
    DefaultListModel list1 = new DefaultListModel();
    DefaultListModel list2 = new DefaultListModel();
    public ArrayList<String> getData = new ArrayList<>();
    public ArrayList<String> getData1 = new ArrayList<>();
    public ArrayList<String> getRoomNumber = new ArrayList<>();
    public ArrayList<Integer> getDataInt = new ArrayList<>();
    /**
     * Creates new form Reservations_Add_Update
     */
    public Reservations_Add_Delete() {
        initComponents();
        m = (DefaultTableModel) jTable2.getModel();
        this.setResizable(false);
        this.setTitle("ADD RESERVATIONS");
//        this.setExtendedState(this.MAXIMIZED_BOTH);
        JTableHeader tableHeader = jTable2.getTableHeader();
        Font HeaderFont = new Font("Felix Titling", Font.BOLD, 14);
        tableHeader.setFont(HeaderFont);
        
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setWidth(0);
        
//        jTable2.getColumnModel().getColumn(1).setPreferredWidth(30);
//        jTable2.getColumnModel().getColumn(2).setPreferredWidth(30);
//        jTable2.getColumnModel().getColumn(3).setPreferredWidth(20);
//        jTable2.getColumnModel().getColumn(4).setPreferredWidth(30);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(20);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(15);
//        jTable2.getColumnModel().getColumn(7).setPreferredWidth(30);
//        jTable2.getColumnModel().getColumn(8).setPreferredWidth(10);
//        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        fillTable();
        fillInsertInfo();
    }
    
    private void fillTable() {
        getData.clear();
        m.setRowCount(0);
        getData = DB_Connection.selectReservationsJoin();
        
        for (int i = 0; i < getData.size(); i++) {
            String[] arr = getData.get(i).split("_");
            m.addRow(new Object[] {
                arr[0], arr[1], arr[2], arr[3], arr[4].equals("RO") ? "Room Only" : arr[4].equals("BB") ? "Breakfast & Bed" : arr[4].equals("HB") ? "Breakfast & Dinner" : arr[4].equals("FB") ? "All Inclusive" : arr[4], arr[5].equals("0.0") ? "0.0 %" : arr[5] + " %", arr[6], arr[7].equals("1") ? arr[7] + " day" : arr[7] + " days", arr[8] + " €", arr[9]
            });
        }
        
        for (int i = 0; i < m.getRowCount(); i++) {
            if(m.getValueAt(i, 9).equals("VIP")) {
                m.setValueAt("None", i, 8);
            }
        }
        
        getData.clear();
    }
    
    private void fillInsertInfo() {
        //Clients
        getData.clear();
        
        clients.removeAllItems();
        clients.addItem("Choose an Existing Client");
        String[] columns1 = {"First_Name", "Last_Name", "DocumentID"};
        getData = DB_Connection.selectOrderBy(columns1, "Clients", "ClientID", "ASC");
        String arr1[];
        for (int i = 0; i < getData.size(); i++) {
            arr1 = getData.get(i).split("_");
            clients.addItem(arr1[0] + " " + arr1[1] + "_" + arr1[2]);
        }
        
        //Breeding
        getData.clear();
        
        breeding.removeAllItems();
        breeding.addItem("Pick a Type");
        String[] columns2 = {"Breeding_Type"};
        getData = DB_Connection.selectOrderBy(columns2, "Breeding", "Breeding_ID", "ASC");
        for (int i = 0; i < getData.size(); i++) {
            breeding.addItem(getData.get(i));
        }
        
        getData.clear();
        
        //Discounts
        getData = DB_Connection.selectOrderBy(new String[] {"Company"}, "Discounts", "DiscountID", "ASC");
        discounts.removeAllItems();
        discounts.addItem("Pick a Discount");
        for (int i = 0; i < getData.size(); i++) {
            discounts.addItem(getData.get(i));
        }
        
        getData.clear();
        
        //Status
        getData = DB_Connection.selectOrderBy(new String[] {"Paid"}, "Payment_Status", "ID_status", "ASC");
        status.removeAllItems();
        status.addItem("Pick a Status");
        for (int i = 0; i < getData.size(); i++) {
            status.addItem(getData.get(i));
        }
        
        getData.clear();
        
        //Room
        
        getData = DB_Connection.selectOrderBy(new String[] {"Room_Number"}, "Rooms", "RoomID", "ASC");
        room.removeAllItems();
        room.addItem("Pick a Room Number");
        for (int i = 0; i < getData.size(); i++) {
            room.addItem(getData.get(i));
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

        PopUpDelete = new javax.swing.JPopupMenu();
        deleteItem = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        clients = new javax.swing.JComboBox<>();
        breeding = new javax.swing.JComboBox<>();
        discounts = new javax.swing.JComboBox<>();
        date = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        stay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        room = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomsList = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        firstname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        docID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        country = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Home = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        search = new javax.swing.JMenuItem();
        update_delete = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        deleteItem.setText("Delete Reservation");
        deleteItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteItemMousePressed(evt);
            }
        });
        PopUpDelete.add(deleteItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setFont(new java.awt.Font("Felix Titling", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation ID", "First  Name", "Last  Name", "Document  ID", "Breeding  Type", "Discount", "Reservation  Date", "Stay", "Total Price", "Payment  Status"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        clients.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        breeding.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        discounts.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        date.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        status.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        stay.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel1.setText("First Name");

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel2.setText("Breeding");

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel3.setText("Discount");

        jLabel4.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel4.setText("Date of Reservation");

        jLabel5.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel5.setText("Stay");

        jLabel6.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel6.setText("Status");

        jButton1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jButton1.setText("Add Reservation");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel7.setText("Room");

        room.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        roomsList.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        roomsList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roomsListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(roomsList);

        jButton2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jButton2.setText("Add Selected Room");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        firstname.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        firstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstnameFocusGained(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 0));
        jLabel8.setText("Client Info");

        jLabel9.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 0));
        jLabel9.setText("Reservation Info");

        jLabel10.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel10.setText("Last Name");

        lastname.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        lastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastnameFocusGained(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 0));
        jLabel11.setText("Add a New Client");

        jLabel12.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel12.setText("Document ID");

        docID.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        docID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                docIDFocusGained(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel13.setText("Phone");

        phone.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneFocusGained(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel14.setText("Address");

        address.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressFocusGained(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel15.setText("City");

        city.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        city.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cityFocusGained(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel16.setText("Country");

        country.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        country.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                countryFocusGained(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 0));
        jLabel17.setText("INSERT DATA");

        jButton6.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jButton6.setText("Go Back");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });

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

        search.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        search.setForeground(new java.awt.Color(98, 98, 98));
        search.setText("Search");
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchMousePressed(evt);
            }
        });
        jMenu1.add(search);

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
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 95, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(437, 437, 437))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(discounts, 0, 194, Short.MAX_VALUE)
                                    .addComponent(breeding, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(room, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(stay, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clients, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1))
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(docID)
                                            .addComponent(lastname)
                                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(25, 25, 25)))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(address)
                                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(91, 91, 91)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(breeding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(discounts, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(docID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        setSize(new java.awt.Dimension(1376, 821));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        try {
            
        }
        catch(Exception e) {
            System.out.println("Initial Click");
        }
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        getData.clear();
        
        if(list.isEmpty() ||
           breeding.getSelectedItem().equals("Pick a Type") ||
           discounts.getSelectedItem().equals("Pick a Discount") ||
           status.getSelectedItem().equals("Pick a Status") ||
           date.getText().isBlank() || stay.getText().isBlank()) {
           
           JOptionPane.showMessageDialog(this, "Do Not Leave It Blank!", "Input Error", 0);
        }
        else {
            try {
                int value = Integer.parseInt(stay.getText());
                stay.setText(String.valueOf(value));
                if(clients.getSelectedItem().equals("Choose an Existing Client")) {

                    getData.clear();

                    if(firstname.getText().isBlank() || lastname.getText().isBlank() || docID.getText().isBlank() ||
                    phone.getText().isBlank() || address.getText().isBlank() || city.getText().isBlank() || country.getText().isBlank()) {
                        JOptionPane.showMessageDialog(this, "Blank Spots Encountered", "Operation Not Successful", 0);
                    }

                    else {
                        String Firstname = firstname.getText();
                        String Lastname = lastname.getText();
                        String DocumentID = docID.getText();
                        String Phone = phone.getText();
                        String Address = address.getText();
                        String City = city.getText();
                        String Country = country.getText();

                        getData.clear();

                        getData = DB_Connection.selectWhere4(new String[] {"DocumentID"}, new String[]{"DocumentID"}, new String[] {DocumentID}, "Clients");
                        String existingdocID = "";
                        if(!getData.isEmpty()) {
                            existingdocID = getData.get(0);
                        }

                        getData.clear();

                        getData = DB_Connection.selectWhere4(new String[] {"Phone"}, new String[]{"Phone"}, new String[] {Phone}, "Clients");
                        String existingPhone = "";
                        if(!getData.isEmpty()) {
                            existingPhone = getData.get(0);
                        }

                        getData.clear();

                        if(existingdocID.equals(DocumentID) || existingPhone.equals(Phone)){
                            JOptionPane.showMessageDialog(this, "Client With The Same Document ID Or Phone Number Encountered", "Operation Impossible", 0);
                        }
                        else {

                            String[] columns1 = {"First_Name", "Last_name", "DocumentID", "Phone", "Address", "City", "Country"};
                            String[] values1 = {Firstname, Lastname, DocumentID, Phone, Address, City, Country};
                            DB_Connection.insert2(columns1, values1, "Clients");

                            getData = DB_Connection.selectWhere4(new String[] {"ClientID"}, new String[] {"DocumentID"}, new String[] {DocumentID}, "Clients");
                            String clientID = getData.get(0);

                            String Breeding = String.valueOf(breeding.getSelectedItem());
                            getData.clear();
                            getData = DB_Connection.selectWhere4(new String[] {"Breeding_ID"},
                            new String[] {"Breeding_Type"}, new String[] {Breeding}, "Breeding");
                            String breedingID = getData.get(0);
                            getData.clear();

                            String Company = String.valueOf(discounts.getSelectedItem());
                            getData.clear();
                            getData = DB_Connection.selectWhere4(new String[] {"DiscountID"},
                            new String[] {"Company"}, new String[] {Company}, "Discounts");
                            String discountID = getData.get(0);
                            getData.clear();

                            String Date = date.getText();

                            String Stay = stay.getText();

                            String Status = String.valueOf(status.getSelectedItem());
                            getData.clear();
                            getData = DB_Connection.selectWhere4(new String[] {"ID_status"},
                            new String[] {"Paid"}, new String[] {Status}, "Payment_Status");
                            String statusID = getData.get(0);
                            getData.clear();

                            String[] columns2 = {"ClientID", "Breeding_ID", "DiscountID", "Date_Reservation", "Stay", "ID_status"};
                            String[] values2 = {clientID, breedingID, discountID, Date, Stay, statusID};
                            DB_Connection.insert3(columns2, values2, "Reservations");

                            getData.clear();

                            String[] columns3 = {"Reservation_ID", "ClientID", "Breeding_ID", "DiscountID", "Date_Reservation", "Stay", "ID_status"};
                            getData = DB_Connection.select(columns3, "Reservations");
                            String arr2[] = {""};
                            for (int i = 0; i < getData.size(); i++) {
                                arr2 = getData.get(i).split("_");
                            }
                            String lastResID = arr2[0];

                            getData.clear();

                            for (int i = 0; i < getRoomNumber.size(); i++) {
    //                            String roomIndex = getRoomIndex.get(i);

                                getData = DB_Connection.selectWhere4(new String[] {"RoomID"},
                                new String[] {"Room_Number"}, new String[] {getRoomNumber.get(i)}, "Rooms");
                                String roomIndex = getData.get(0);

                                String[] columns4 = {"Reservation_ID", "RoomID", "ID_status"};
                                String[] values4 = {lastResID, roomIndex, statusID};
                                DB_Connection.insert(columns4, values4, "Rooms_Reservations");

                                DB_Connection.updateString(new String[] {"Room_State"},
                                new String []{"Reserved"}, new String []{"RoomID"},
                                new String []{roomIndex}, "Rooms");
                            }

                            getData.clear();

                            String[] columns5 = {"Reservation_ID", "ServiceID", "ID_status"};
                            String[] values5 = {lastResID, "15", "4"};
                            DB_Connection.insert2(columns5, values5, "Services_Reservations");

                            getData.clear();

                            resetInsertInfo();

                            JOptionPane.showMessageDialog(this, "Reservation Added Successfully", "Operation Success", 1);



                        }
                    }   //Add client
                }   //If not existing client

                else {
                    firstname.setText("");
                    lastname.setText("");
                    docID.setText("");
                    phone.setText("");
                    address.setText("");
                    city.setText("");
                    country.setText("");

                    getData.clear();

                    String client = String.valueOf(clients.getSelectedItem());
                    String arr1[] = {""};
                    for (int i = 0; i < client.length(); i++) {
                        arr1 = client.split("_");
                    }

                    //changed
                    getData = DB_Connection.selectWhere4(new String[] {"ClientID"}, new String[] {"DocumentID"}, new String[] {arr1[1]}, "Clients");
                    String clientID = getData.get(0);

                    String Breeding = String.valueOf(breeding.getSelectedItem());
                    getData.clear();
                    getData = DB_Connection.selectWhere4(new String[] {"Breeding_ID"},
                    new String[] {"Breeding_Type"}, new String[] {Breeding}, "Breeding");
                    String breedingID = getData.get(0);
                    getData.clear();

                    String Company = String.valueOf(discounts.getSelectedItem());
                    getData.clear();
                    getData = DB_Connection.selectWhere4(new String[] {"DiscountID"},
                    new String[] {"Company"}, new String[] {Company}, "Discounts");
                    String discountID = getData.get(0);
                    getData.clear();

                    String Date = date.getText();

                    String Stay = stay.getText();

                    String Status = String.valueOf(status.getSelectedItem());
                    getData.clear();
                    getData = DB_Connection.selectWhere4(new String[] {"ID_status"},
                    new String[] {"Paid"}, new String[] {Status}, "Payment_Status");
                    String statusID = getData.get(0);
                    getData.clear();

                    String[] columns2 = {"ClientID", "Breeding_ID", "DiscountID", "Date_Reservation", "Stay", "ID_status"};
                    String[] values2 = {clientID, breedingID, discountID, Date, Stay, statusID};
                    DB_Connection.insert3(columns2, values2, "Reservations");

                    getData.clear();

                    String[] columns3 = {"Reservation_ID", "ClientID", "Breeding_ID", "DiscountID", "Date_Reservation", "Stay", "ID_status"};
                    getData = DB_Connection.select(columns3, "Reservations");
                    String arr2[] = {""};
                    for (int i = 0; i < getData.size(); i++) {
                        arr2 = getData.get(i).split("_");
                    }
                    String lastResID = arr2[0];

                    getData.clear();

                    for (int i = 0; i < getRoomNumber.size(); i++) {
    //                    String roomIndex = getRoomIndex.get(i);

                        //changed
                        getData = DB_Connection.selectWhere4(new String[] {"RoomID"},
                        new String[] {"Room_Number"}, new String[] {getRoomNumber.get(i)}, "Rooms");
                        String roomIndex = getData.get(0);

                        String[] columns4 = {"Reservation_ID", "RoomID", "ID_status"};
                        String[] values4 = {lastResID, roomIndex, statusID};
                        DB_Connection.insert(columns4, values4, "Rooms_Reservations");
                        
                        DB_Connection.updateString(new String[] {"Room_State"},
                        new String []{"Reserved"}, new String []{"RoomID"},
                        new String []{roomIndex}, "Rooms");
                    }

                    getData.clear();

                    String[] columns5 = {"Reservation_ID", "ServiceID", "ID_status"};
                    String[] values5 = {lastResID, "15", "4"};
                    DB_Connection.insert2(columns5, values5, "Services_Reservations");

                    getData.clear();

                    resetInsertInfo();

                    JOptionPane.showMessageDialog(this, "Reservation Added Successfully", "Operation Success", 1);
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Stay Not In Correct Format", "Stay Constraint", 0);
            }
        }
    }//GEN-LAST:event_jButton1MousePressed
    
    private void resetInsertInfo() {
        room.removeAllItems();
        breeding.removeAllItems();
        discounts.removeAllItems();
        status.removeAllItems();
        date.setText("");
        stay.setText("");
        list.clear();
        getData.clear();
        getRoomNumber.clear();
        fillInsertInfo();
        
        firstname.setText("");
        lastname.setText("");
        docID.setText("");
        phone.setText("");
        address.setText("");
        city.setText("");
        country.setText("");
        
        fillTable();
    }
    
    
    
    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
        if(room.getSelectedItem() != "Pick a Room Number") {
            String selectedRoom = String.valueOf(room.getSelectedItem());
            boolean flag = false;

            for (int i = 0; i < list.size(); i++) {
                if(selectedRoom.equals(list.get(i))) {
                    flag = true;
                }
            }
            
            if(flag) {
                room.getModel().setSelectedItem("Pick a Room Number");
                JOptionPane.showMessageDialog(this, "Repeating Room", "Room Constraint", 0);
            }
            else {
                list.clear();
                getRoomNumber.add(selectedRoom);
                for (int i = 0; i < getRoomNumber.size(); i++) {
                    list.addElement(getRoomNumber.get(i));
                }
                roomsList.setModel(list);
                room.getModel().setSelectedItem("Pick a Room Number");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Pick an Existing Room", "Room Not Selected", 2);
        }
    }//GEN-LAST:event_jButton2MousePressed

    private void roomsListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomsListKeyReleased
        // TODO add your handling code here:
        try {
            int keyCode = evt.getKeyCode();
            if(keyCode == KeyEvent.VK_DELETE) { 
                int selectedIndex = roomsList.getSelectedIndex();
                list.remove(selectedIndex);
                roomsList.setModel(list);
                getRoomNumber.remove(selectedIndex);
            }
            System.out.println("Item removed successfully");
        }
        catch(Exception e) {
            System.out.println("Empty List");
        }
    }//GEN-LAST:event_roomsListKeyReleased

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        // TODO add your handling code here:
        if(SwingUtilities.isRightMouseButton(evt)) {
            PopUpDelete.show(evt.getComponent(), evt.getX(), evt.getY());
            int row = jTable2.rowAtPoint(evt.getPoint());
            jTable2.setRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_jTable2MousePressed

    private void deleteItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteItemMousePressed
        // TODO add your handling code here:
        try {
            if(jTable2.getSelectedRow() == -1) {
                resetInsertInfo();
                JOptionPane.showMessageDialog(this, "You Need To Select an Existing Reservation", "Operation Failure", 0);
            }
            if(jTable2.getSelectedRow() != -1) {
                int result = JOptionPane.showConfirmDialog(this, "Do you wish to continue?\nThis process cannot be undone.", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if(result == 0){
                    deleteReservation();
                    resetInsertInfo();
                    JOptionPane.showMessageDialog(this, "Reservation Deleted Successfully", "Operation Success", 1);
                }
            }
        }
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_deleteItemMousePressed

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:
        try {
            int keyCode = evt.getKeyCode();
            if(keyCode == KeyEvent.VK_DELETE && jTable2.getSelectedRow() == -1) {
                resetInsertInfo();
                JOptionPane.showMessageDialog(this, "You Need To Select an Existing Reservation", "Operation Failure", 0);
            }
            
            else if(keyCode == KeyEvent.VK_DELETE && jTable2.getSelectedRow() != -1) {
                int result = JOptionPane.showConfirmDialog(this, "Do you wish to continue?\nThis process cannot be undone.", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if(result == 0){
                    deleteReservation();
                    resetInsertInfo();
                    JOptionPane.showMessageDialog(this, "Reservation Deleted Successfully", "Operation Success", 1);
                }
            }
        }
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_jTable2KeyPressed

    private void firstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameFocusGained
        // TODO add your handling code here:
        clients.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_firstnameFocusGained

    private void lastnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameFocusGained
        // TODO add your handling code here:
        clients.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_lastnameFocusGained

    private void docIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_docIDFocusGained
        // TODO add your handling code here:
        clients.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_docIDFocusGained

    private void phoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneFocusGained
        // TODO add your handling code here:
        clients.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_phoneFocusGained

    private void addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFocusGained
        // TODO add your handling code here:
        clients.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_addressFocusGained

    private void cityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFocusGained
        // TODO add your handling code here:
        clients.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_cityFocusGained

    private void countryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryFocusGained
        // TODO add your handling code here:
        clients.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_countryFocusGained

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

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        // TODO add your handling code here:
        search.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        // TODO add your handling code here:
        search.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_searchMouseExited

    private void searchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMousePressed
        // TODO add your handling code here:
        Reservations_Search Search = new Reservations_Search();
        this.dispose();
        Search.setVisible(true);
    }//GEN-LAST:event_searchMousePressed

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

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        // TODO add your handling code here:
        Main_Menu Menu = new Main_Menu();
        this.dispose();
        Menu.setVisible(true);
    }//GEN-LAST:event_jButton6MouseReleased

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
    
    private void deleteReservation() {
        
        int row = jTable2.getSelectedRow();
        String resID = String.valueOf(m.getValueAt(row, 0));

        //Rooms Deletion
        getData.clear();

        //Get Rooms ID
        String[] columns1 = {"RoomID"};
        String[] whereColumns1 = {"Reservation_ID"};
        String[] whereValues1 = {resID};
        String table1 = "Rooms_Reservations";
        getData = DB_Connection.selectWhere3(columns1, whereColumns1, whereValues1, table1);

        for (int i = 0; i < getData.size(); i++) {
            String roomID = getData.get(i);

            DB_Connection.updateString(new String[] {"Room_State"},
            new String []{"Free"}, new String []{"RoomID"},
            new String []{roomID}, "Rooms");

            //Delete Rooms by ResID
            String[] whereColumns2 = {"Reservation_ID", "RoomID"};
            String[] whereValues2 = {resID, roomID};
            String table2 = "Rooms_Reservations";
            DB_Connection.delete(whereColumns2, whereValues2, table2);
        }

        //Services Deletion
        getData1.clear();

        String[] columns3 = {"ServiceID"};
        String[] whereColumns3 = {"Reservation_ID"};
        String[] whereValues3 = {resID};
        String table3 = "Services_Reservations";
        getData1 = DB_Connection.selectWhere3(columns3, whereColumns3, whereValues3, table3);

        for (int i = 0; i < getData1.size(); i++) {
            String serviceID = getData1.get(i);

            //Delete Services by ResID
            String[] whereColumns4 = {"Reservation_ID", "ServiceID"};
            String[] whereValues4 = {resID, serviceID};
            String table4 = "Services_Reservations";
            DB_Connection.delete(whereColumns4, whereValues4, table4);
        }

        //Reservation Deletion
        String[] whereColumns5 = {"Reservation_ID"};
        String[] whereValues5 = {resID};
        String table5 = "Reservations";
        DB_Connection.delete(whereColumns5, whereValues5, table5);

        getData.clear();
        getData1.clear();
            
    }
    
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
            java.util.logging.Logger.getLogger(Reservations_Add_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservations_Add_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservations_Add_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservations_Add_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservations_Add_Delete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Home;
    private javax.swing.JPopupMenu PopUpDelete;
    private javax.swing.JTextField address;
    private javax.swing.JComboBox<String> breeding;
    private javax.swing.JTextField city;
    private javax.swing.JComboBox<String> clients;
    private javax.swing.JTextField country;
    private javax.swing.JTextField date;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JComboBox<String> discounts;
    private javax.swing.JTextField docID;
    private javax.swing.JTextField firstname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField phone;
    private javax.swing.JComboBox<String> room;
    private javax.swing.JList<String> roomsList;
    private javax.swing.JMenuItem search;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField stay;
    private javax.swing.JMenuItem update_delete;
    // End of variables declaration//GEN-END:variables
}
