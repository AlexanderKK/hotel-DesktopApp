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
public class Reservations_Update_Delete extends javax.swing.JFrame {
    public DefaultTableModel m;
    DefaultListModel list = new DefaultListModel();
    DefaultListModel list1 = new DefaultListModel();
    DefaultListModel list2 = new DefaultListModel();
    public ArrayList<String> getData = new ArrayList<>();
    public ArrayList<String> getData1 = new ArrayList<>();
    public ArrayList<String> getRoomNumber = new ArrayList<>();
    public ArrayList<String> getRoomIndex = new ArrayList<>();
    public ArrayList<Integer> getDataInt = new ArrayList<>();
    /**
     * Creates new form Reservations_Add_Update
     */
    public Reservations_Update_Delete() {
        initComponents();
        m = (DefaultTableModel) jTable2.getModel();
        this.setResizable(false);
        this.setTitle("UPDATE RESERVATIONS");
        this.setExtendedState(this.MAXIMIZED_BOTH);
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
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(70);
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
        
        clients1.removeAllItems();
        clients1.addItem("Choose an Existing Client");
        String[] columns1 = {"First_Name", "Last_Name", "DocumentID"};
        getData = DB_Connection.selectOrderBy(columns1, "Clients", "ClientID", "ASC");
        String arr1[];
        for (int i = 0; i < getData.size(); i++) {
            arr1 = getData.get(i).split("_");
            clients1.addItem(arr1[0] + " " + arr1[1] + "_" + arr1[2]);
        }
        
        //Breeding
        getData.clear();
        
        breeding1.removeAllItems();
        breeding1.addItem("Pick a Type");
        String[] columns2 = {"Breeding_Type"};
        getData = DB_Connection.selectOrderBy(columns2, "Breeding", "Breeding_ID", "ASC");
        for (int i = 0; i < getData.size(); i++) {
            breeding1.addItem(getData.get(i));
        }
        
        getData.clear();
        
        //Discounts
        getData = DB_Connection.selectOrderBy(new String[] {"Company"}, "Discounts", "DiscountID", "ASC");
        discounts1.removeAllItems();
        discounts1.addItem("Pick a Discount");
        for (int i = 0; i < getData.size(); i++) {
            discounts1.addItem(getData.get(i));
        }
        
        getData.clear();
        
        //Status
        getData = DB_Connection.selectOrderBy(new String[] {"Paid"}, "Payment_Status", "ID_status", "ASC");
        status1.removeAllItems();
        status1.addItem("Pick a Status");
        for (int i = 0; i < getData.size(); i++) {
            status1.addItem(getData.get(i));
        }
        
        getData.clear();
        
        //Room
        
        getData = DB_Connection.selectOrderBy(new String[] {"Room_Number"}, "Rooms", "RoomID", "ASC");
        room1.removeAllItems();
        room1.addItem("Pick a Room Number");
        for (int i = 0; i < getData.size(); i++) {
            room1.addItem(getData.get(i));
        }
        
        getData.clear();
        
        //Service
        
        getData = DB_Connection.selectOrderBy(new String[] {"Service_Type"}, "Services", "ServiceID", "ASC");
        service.removeAllItems();
        service.addItem("Pick a Service");
        for (int i = 0; i < getData.size(); i++) {
            service.addItem(getData.get(i));
        }
        
        getData.clear();
    }   
    
    private void fillUpdateInfo() {
        int row = jTable2.getSelectedRow();
        //Rooms
        getData.clear();
        getData1.clear();
        
        String resID = String.valueOf(m.getValueAt(row, 0));
        String[] whereColumn1 = {"Reservations.Reservation_ID"};
        String[] whereValue1 = {resID};
        getData = DB_Connection.selectWhereRooms_ReservationsJoin(whereColumn1, whereValue1);
        list1.clear();
        for (int i = 0; i < getData.size(); i++) {
            list1.addElement(getData.get(i));
        }
        roomsList1.setModel(list1);
        
        //Services
        getData.clear();
        
        getData = DB_Connection.selectWhereServices_ReservationsJoin(whereColumn1, whereValue1);
        list2.clear();
        for (int i = 0; i < getData.size(); i++) {
            list2.addElement(getData.get(i));
        }
        servicesList.setModel(list2);
        
        //Breeding
        String breeding = String.valueOf(m.getValueAt(row, 4));
        if(breeding.equals("All Inclusive")) {
            breeding1.getModel().setSelectedItem("FB");
        }
        else if(breeding.equals("Breakfast & Dinner")) {
            breeding1.getModel().setSelectedItem("HB");
        }
        else if(breeding.equals("Breakfast & Bed")) {
            breeding1.getModel().setSelectedItem("BB");
        }
        else if(breeding.equals("Room Only")) {
            breeding1.getModel().setSelectedItem("RO");
        }
        
        //Discounts
        getData.clear();
        
        String discount = String.valueOf(m.getValueAt(row, 5));
        String arr[] = {""};
        if(discount.equals("None")) {
            discounts1.getModel().setSelectedItem("No Discount");
        }
        
        for (int i = 0; i < discount.length(); i++) {
            arr = discount.split(" ");
        }

        getData = DB_Connection.selectWhereDouble(new String[] {"Company"},
        new String[] {"Discount"}, new double[] {Double.parseDouble(arr[0])}, "Discounts");
        discounts1.getModel().setSelectedItem(getData.get(0));
        
        //Status
        getData.clear();
        
        String status = String.valueOf(m.getValueAt(row, 9));
        status1.getModel().setSelectedItem(status);
        
        //Date
        date1.setText(String.valueOf(m.getValueAt(row, 6)));
        
        //Stay
        String stayString = String.valueOf(m.getValueAt(row, 7));
        String[] arrStay = {""};
        for (int i = 0; i < stayString.length(); i++) {
            arrStay = stayString.split(" ");
        }
        stay1.setText(arrStay[0]);
        
        //Clients
        clients1.getModel().setSelectedItem(String.valueOf(m.getValueAt(row, 1)) +
                " " + String.valueOf(m.getValueAt(row, 2)) + "_" + String.valueOf(m.getValueAt(row, 3)));
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
        jLabel18 = new javax.swing.JLabel();
        firstname1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lastname1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        docID1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        phone1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        address1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        city1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        country1 = new javax.swing.JTextField();
        room1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        roomsList1 = new javax.swing.JList<>();
        clients1 = new javax.swing.JComboBox<>();
        breeding1 = new javax.swing.JComboBox<>();
        discounts1 = new javax.swing.JComboBox<>();
        date1 = new javax.swing.JTextField();
        status1 = new javax.swing.JComboBox<>();
        stay1 = new javax.swing.JTextField();
        updateRoom = new javax.swing.JButton();
        addRoom = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        servicesList = new javax.swing.JList<>();
        jLabel34 = new javax.swing.JLabel();
        service = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        addService = new javax.swing.JButton();
        updateService = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Home = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        search = new javax.swing.JMenuItem();
        add_delete = new javax.swing.JMenuItem();
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

        jLabel18.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 0));
        jLabel18.setText("UPDATE DATA");

        firstname1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        firstname1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstname1FocusGained(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 0));
        jLabel19.setText("Set to an Existing Client");

        jLabel21.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel21.setText("Last Name");

        lastname1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lastname1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastname1FocusGained(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 0));
        jLabel22.setText("Set to a New Client");

        jLabel23.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel23.setText("Document ID");

        docID1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        docID1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                docID1FocusGained(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel24.setText("Phone");

        phone1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        phone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phone1FocusGained(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel25.setText("First Name");

        jLabel26.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel26.setText("Address");

        jLabel27.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel27.setText("Breeding");

        address1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        address1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                address1FocusGained(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel28.setText("Discount");

        jLabel29.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel29.setText("City");

        jLabel30.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel30.setText("Date of Reservation");

        city1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        city1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                city1FocusGained(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel31.setText("Stay");

        jLabel32.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel32.setText("Country");

        jLabel33.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel33.setText("Status");

        country1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        country1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                country1FocusGained(evt);
            }
        });

        room1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        roomsList1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        roomsList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roomsList1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(roomsList1);

        clients1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        breeding1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        discounts1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        date1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        status1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        stay1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        updateRoom.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 16)); // NOI18N
        updateRoom.setText("Update Room");
        updateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRoomActionPerformed(evt);
            }
        });

        addRoom.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 16)); // NOI18N
        addRoom.setText("Add Room");
        addRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 0));
        jLabel35.setText("Current Rooms");

        jLabel20.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 0));
        jLabel20.setText("Room");

        servicesList.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        servicesList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                servicesListKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(servicesList);

        jLabel34.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 153, 0));
        jLabel34.setText("Current Services");

        service.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(153, 153, 0));
        jLabel36.setText("Service");

        addService.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 16)); // NOI18N
        addService.setText("Add Service");
        addService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addServiceActionPerformed(evt);
            }
        });

        updateService.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 16)); // NOI18N
        updateService.setText("Update Service");
        updateService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateServiceActionPerformed(evt);
            }
        });

        Update.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 16)); // NOI18N
        Update.setText("Update Reservation");
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateMousePressed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel20)
                        .addGap(12, 12, 12)
                        .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(addRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateRoom))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel35))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(addService)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(updateService))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addGap(19, 19, 19)))
                            .addGap(62, 62, 62)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel28)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(discounts1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(breeding1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(status1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(stay1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(54, 54, 54)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(clients1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(phone1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(docID1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(12, 12, 12)))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastname1)
                                    .addComponent(firstname1))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel32))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(city1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(country1))
                                    .addComponent(address1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(101, 101, 101))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(updateRoom)
                                    .addComponent(addRoom))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(clients1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel36))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(addService)
                                            .addComponent(updateService))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel34)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel27)
                                            .addComponent(breeding1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(discounts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel28))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(status1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel33))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(stay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel31)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(firstname1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(lastname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(docID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(phone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(city1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(country1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1556, 875));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        try {
            fillUpdateInfo();
        }
        catch(Exception e) {
            System.out.println("Initial Click");
        }
    }//GEN-LAST:event_jTable2MouseReleased
    
    private void resetUpdateInfo() {
        room1.removeAllItems();
        service.removeAllItems();
        breeding1.removeAllItems();
        discounts1.removeAllItems();
        status1.removeAllItems();
        date1.setText("");
        stay1.setText("");
        list1.clear();
        roomsList1.setModel(list1);
        list2.clear();
        servicesList.setModel(list2);
        clients1.removeAllItems();
        
        fillInsertInfo();
        fillTable();
        
//        firstname1.setText("");
//        lastname1.setText("");
//        docID1.setText("");
//        phone1.setText("");
//        address1.setText("");
//        city1.setText("");
//        country1.setText("");
    }
    
    private void addRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomActionPerformed
        // TODO add your handling code here:
        getData1.clear();
        try {
            if(room1.getSelectedItem() != "Pick a Room Number") {
                int row = jTable2.getSelectedRow();
                String resID = String.valueOf(m.getValueAt(row, 0));
                String[] whereColumn1 = {"Reservations.Reservation_ID"};
                String[] whereValue1 = {resID};
                getData1 = DB_Connection.selectWhereRooms_ReservationsJoin(whereColumn1, whereValue1);
                boolean flag = false;
                for (int i = 0; i < getData1.size(); i++) {
                    if(room1.getSelectedItem().equals(getData1.get(i))) {
                        room1.getModel().setSelectedItem("Pick a Room Number");
                        flag = true;
                    }
                }
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Room Already Exists", "Repeating Room", 0);
                }
                else {
                    getData.clear();
                    
                    String roomNumber = String.valueOf(room1.getSelectedItem());
                    getData = DB_Connection.selectWhere4(new String[] {"RoomID"},
                    new String[] {"Room_Number"}, new String[] {roomNumber}, "Rooms");
                    String newRoomID = getData.get(0);
                    
                    getData.clear();
                    
                    String statusID = String.valueOf(status1.getSelectedIndex());
                    String[] columns = {"Reservation_ID", "RoomID", "ID_status"};
                    String[] values = {resID, newRoomID, statusID};
                    
                    //Insert
                    DB_Connection.insert(columns, values, "Rooms_Reservations");
                    
                    DB_Connection.updateString(new String[] {"Room_State"},
                    new String []{"Reserved"}, new String []{"RoomID"},
                    new String []{newRoomID}, "Rooms");
                    
                    getData1.add(String.valueOf(room1.getSelectedItem()));
                    getData1.clear();
                    
                    list1.addElement(room1.getSelectedItem());
                    roomsList1.setModel(list1);
                    
//                    fillTable();
                    
                    room1.getModel().setSelectedItem("Pick a Room Number");
                    JOptionPane.showMessageDialog(this, "Room Added Successfully", "Success", 1);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Pick an Existing Room", "Room Not Selected", 2);
            }
        }
        catch (Exception e) {
            room1.getModel().setSelectedItem("Pick a Room Number");
            JOptionPane.showMessageDialog(this, "You Have Not Selected Room Or Reservation", "Room Or Reservation Not Present", 0);
        }
    }//GEN-LAST:event_addRoomActionPerformed

    private void addServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServiceActionPerformed
        // TODO add your handling code here:
        getData1.clear();
        try {
            if(service.getSelectedItem() != "Pick a Service") {
                int row = jTable2.getSelectedRow();
                String resID = String.valueOf(m.getValueAt(row, 0));
                String[] whereColumn1 = {"Reservations.Reservation_ID"};
                String[] whereValue1 = {resID};
                getData1 = DB_Connection.selectWhereServices_ReservationsJoin(whereColumn1, whereValue1);
                
                boolean flag = false;
                for (int i = 0; i < getData1.size(); i++) {
                    if(service.getSelectedItem().equals(getData1.get(i))) {
                        service.getModel().setSelectedItem("Pick a Service");
                        flag = true;
                    }
                }
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Service Already Exists", "Repeating Service", 0);
                }
                else {
                    getData.clear();

                    String Service = String.valueOf(service.getSelectedItem());
                    getData = DB_Connection.selectWhere4(new String[] {"ServiceID"},
                    new String[] {"Service_Type"}, new String[] {Service}, "Services");
                    String newServiceID = getData.get(0);

                    getData.clear();

                    if(list2.contains("None")) {
                        DB_Connection.delete(new String[] {"Reservation_ID", "ServiceID", "ID_status"}, new String[] {resID, "15", "1"}, "Services_Reservations");
                        list2.clear();
                        servicesList.setModel(list2);
                    }

                    String statusID = String.valueOf(status1.getSelectedIndex());
                    String[] columns = {"Reservation_ID", "ServiceID", "ID_status"};
                    String[] values = {resID, newServiceID, statusID};
                    DB_Connection.insert(columns, values, "Services_Reservations");
                    
                    String[] columns2 = {"RoomID"};
                    String[] whereColumns2 = {"Reservation_ID"};
                    String[] whereValues2 = {resID};
                    getData = DB_Connection.selectWhere3(columns2, whereColumns2, whereValues2, "Rooms_Reservations");
                    
                    for (int i = 0; i < getData.size(); i++) {
                        DB_Connection.updateString(new String[] {"Room_State"},
                        new String []{"Occupied"}, new String []{"RoomID"},
                        new String []{getData.get(i)}, "Rooms");
                    }
                    
                    getData.clear();
                    
                    getData1.add(String.valueOf(service.getSelectedItem()));

                    list2.addElement(service.getSelectedItem());
                    servicesList.setModel(list2);

                    getData1.clear();
                    
//                    fillTable();
                    
                    service.getModel().setSelectedItem("Pick a Service");
                    JOptionPane.showMessageDialog(this, "Service Added Successfully", "Success", 1);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Pick an Existing Service", "Service Not Selected", 2);
            }
        }
        catch (Exception e) {
            service.getModel().setSelectedItem("Pick a Service");
            JOptionPane.showMessageDialog(this, "You Have Not Selected Service Or Reservation", "Service Or Reservation Not Present", 0);
        }
    }//GEN-LAST:event_addServiceActionPerformed

    private void updateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRoomActionPerformed
        // TODO add your handling code here:
        getData1.clear();
        getData.clear();
        try {
            if(room1.getSelectedItem() != "Pick a Room Number") {
                int row = jTable2.getSelectedRow();
                String resID = String.valueOf(m.getValueAt(row, 0));
                String[] whereColumn1 = {"Reservations.Reservation_ID"};
                String[] whereValue1 = {resID};
                getData1 = DB_Connection.selectWhereRooms_ReservationsJoin(whereColumn1, whereValue1);
                boolean flag = false;
                for (int i = 0; i < getData1.size(); i++) {
                    if(room1.getSelectedItem().equals(getData1.get(i))) {
                        room1.getModel().setSelectedItem("Pick a Room Number");
                        flag = true;
                    }
                }
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Room Already Exists", "Repeating Room", 0);
                }
                else {

                    getData.clear();
                    
                    String roomNumber = String.valueOf(room1.getSelectedItem());
                    getData = DB_Connection.selectWhere4(new String[] {"RoomID"},
                    new String[] {"Room_Number"}, new String[] {roomNumber}, "Rooms");
                    String newRoomID = getData.get(0);
                    
                    getData.clear();
                    
                    String[] columnsArray = {"RoomID"};
                    String[] valuesArray = {newRoomID};
                    String[] whereColumns = {"Reservation_ID", "RoomID"};
                    String selectedRoomNumber = roomsList1.getSelectedValue();
                    
                    getData = DB_Connection.selectWhere4(new String[] {"RoomID"},
                    new String[]{"Room_Number"}, new String[] {selectedRoomNumber}, "Rooms");
                    
                    String[] whereValues = {resID, getData.get(0)};
                    DB_Connection.updateInt(columnsArray, valuesArray, whereColumns, whereValues, "Rooms_Reservations");
                    
                    DB_Connection.updateString(new String[] {"Room_State"},
                    new String []{"Free"}, new String []{"RoomID"},
                    new String []{getData.get(0)}, "Rooms");
                    
                    DB_Connection.updateString(new String[] {"Room_State"},
                    new String []{"Reserved"}, new String []{"RoomID"},
                    new String []{newRoomID}, "Rooms");
                    
//                    getData1.add(String.valueOf(room1.getSelectedItem()));
//                    list1.addElement(room1.getSelectedItem());
                    getData.clear();
                    
                    list1.removeElementAt(roomsList1.getSelectedIndex());
                    list1.addElement(room1.getSelectedItem());
                    
                    roomsList1.setModel(list1);
                    
//                    fillTable();
                    
                    room1.getModel().setSelectedItem("Pick a Room Number");
                    JOptionPane.showMessageDialog(this, "Room Updated Successfully", "Success", 1);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Pick an Existing Room", "Room Not Selected", 2);
            }
        }
        catch (Exception e) {
            room1.getModel().setSelectedItem("Pick a Room Number");
            JOptionPane.showMessageDialog(this, "You Have Not Selected Room Or Reservation", "Room Or Reservation Not Present", 0);
        }
    }//GEN-LAST:event_updateRoomActionPerformed

    private void updateServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateServiceActionPerformed
        // TODO add your handling code here:
        getData1.clear();
        getData.clear();
        try {
            if(service.getSelectedItem() != "Pick a Service") {
                int row = jTable2.getSelectedRow();
                String resID = String.valueOf(m.getValueAt(row, 0));
                String[] whereColumn1 = {"Reservations.Reservation_ID"};
                String[] whereValue1 = {resID};
                getData1 = DB_Connection.selectWhereServices_ReservationsJoin(whereColumn1, whereValue1);
                boolean flag = false;
                for (int i = 0; i < getData1.size(); i++) {
                    if(service.getSelectedItem().equals(getData1.get(i))) {
                        service.getModel().setSelectedItem("Pick a Service");
                        flag = true;
                    }
                }
                if(flag) {
                    JOptionPane.showMessageDialog(this, "Service Already Exists", "Repeating Service", 0);
                }
                else {
                    
                    getData.clear();
                    
                    String Service = String.valueOf(service.getSelectedItem());
                    getData = DB_Connection.selectWhere4(new String[] {"ServiceID"},
                    new String[] {"Service_Type"}, new String[] {Service}, "Services");
                    String newServiceID = getData.get(0);
                    
                    getData.clear();
                    
                    String[] columnsArray = {"ServiceID"};
                    String[] valuesArray = {newServiceID};
                    String[] whereColumns = {"Reservation_ID", "ServiceID"};
                    String selectedService = servicesList.getSelectedValue();
                    
                    getData = DB_Connection.selectWhere4(new String[] {"ServiceID"},
                    new String[]{"Service_Type"}, new String[] {selectedService}, "Services");
                    
                    String[] whereValues = {resID, getData.get(0)};
                    DB_Connection.updateInt(columnsArray, valuesArray, whereColumns, whereValues, "Services_Reservations");
                    
                    String[] columns2 = {"RoomID"};
                    String[] whereColumns2 = {"Reservation_ID"};
                    String[] whereValues2 = {resID};
                    getData = DB_Connection.selectWhere3(columns2, whereColumns2, whereValues2, "Rooms_Reservations");
                    
                    for (int i = 0; i < getData.size(); i++) {
                        DB_Connection.updateString(new String[] {"Room_State"},
                        new String []{"Occupied"}, new String []{"RoomID"},
                        new String []{getData.get(i)}, "Rooms");
                    }
                    
                    getData.clear();
                    
                    list2.removeElementAt(servicesList.getSelectedIndex());
                    list2.addElement(service.getSelectedItem());
                    servicesList.setModel(list2);
                    
//                    fillTable();
                    
                    service.getModel().setSelectedItem("Pick a Service");
                    JOptionPane.showMessageDialog(this, "Service Updated Successfully", "Success", 1);
                    
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Pick an Existing Service", "Service Not Selected", 2);
            }
        }
        catch (Exception e) {
            service.getModel().setSelectedItem("Pick a Service");
            JOptionPane.showMessageDialog(this, "You Have Not Selected Service Or Reservation", "Service Or Reservation Not Present", 0);
        }
    }//GEN-LAST:event_updateServiceActionPerformed

    private void roomsList1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomsList1KeyReleased
        // TODO add your handling code here:
        try {
            int keyCode = evt.getKeyCode();
            if(keyCode == KeyEvent.VK_DELETE) {
                if(list1.getSize() > 1) {
                    getData.clear();
                    
                    int row = jTable2.getSelectedRow();
                    String resID = String.valueOf(m.getValueAt(row, 0));
                    
                    String selectedRoomNumber = roomsList1.getSelectedValue();
                    getData = DB_Connection.selectWhere4(new String[] {"RoomID"},
                    new String[]{"Room_Number"}, new String[] {selectedRoomNumber}, "Rooms");
                    String roomID = getData.get(0);
                    
                    getData.clear();
                    
                    String[] columns = {"Reservation_ID", "RoomID"};
                    String[] values = {resID, roomID};
                    DB_Connection.delete(columns, values, "Rooms_Reservations");
                    
                    DB_Connection.updateString(new String[] {"Room_State"},
                    new String []{"Free"}, new String []{"RoomID"},
                    new String []{roomID}, "Rooms");
                    
                    int selectedIndex = roomsList1.getSelectedIndex();
                    list1.remove(selectedIndex);
                    roomsList1.setModel(list1);
                    
//                    fillTable();
//                    JOptionPane.showMessageDialog(this, "Room Removed Successfully", "Successful Operation", 1);
                }
                else {
                    JOptionPane.showMessageDialog(this, "No Reservation Selected Or Room Constraint Activated", "Operation Not Possible", 0); 
                }
            }
        }
        catch(Exception e) {
//            JOptionPane.showMessageDialog(this, "No Reservation Selected Or Room Constraint Activated", "Operation Not Possible", 0); 
        }
    }//GEN-LAST:event_roomsList1KeyReleased

    private void servicesListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servicesListKeyReleased
        // TODO add your handling code here:
        try {
            int keyCode = evt.getKeyCode();
            if(keyCode == KeyEvent.VK_DELETE) {
                int row = jTable2.getSelectedRow();
                String resID = String.valueOf(m.getValueAt(row, 0));
                
                getData.clear();
                
                String selectedService = servicesList.getSelectedValue();
                getData = DB_Connection.selectWhere4(new String[] {"ServiceID"},
                new String[]{"Service_Type"}, new String[] {selectedService}, "Services");
                String serviceID = getData.get(0);

                getData.clear();

                String[] columns = {"Reservation_ID", "ServiceID"};
                String[] values = {resID, serviceID};
                DB_Connection.delete(columns, values, "Services_Reservations");
                int selectedIndex = servicesList.getSelectedIndex();
                list2.remove(selectedIndex);
                
                if(list2.isEmpty()) {
                    DB_Connection.insert2(new String[] {"Reservation_ID", "ServiceID", "ID_status"},
                    new String[] {resID, "15", "1"} , "Services_Reservations");
                    list2.addElement("None");
                }
                servicesList.setModel(list2);
                
//                fillTable();
//                JOptionPane.showMessageDialog(this, "Service Removed Successfully", "Successful Operation", 1);
            }
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "There Are No Services", "Error Message", 0);
        }
    }//GEN-LAST:event_servicesListKeyReleased

    private void UpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMousePressed
        // TODO add your handling code here:
        if(breeding1.getSelectedItem().equals("Pick a Type") ||
           discounts1.getSelectedItem().equals("Pick a Discount") ||
           status1.getSelectedItem().equals("Pick a Status") ||
           date1.getText().isBlank() || stay1.getText().isBlank()) {

               JOptionPane.showMessageDialog(this, "Blank Input Or No Selected Reservation", "Contraint Activated", 0);
        }
        else {
            try {
                int value = Integer.parseInt(stay1.getText());
                stay1.setText(String.valueOf(value));
                if(clients1.getSelectedItem().equals("Choose an Existing Client")) {

                    if(firstname1.getText().isBlank() || lastname1.getText().isBlank() || docID1.getText().isBlank() || phone1.getText().isBlank() ||
                       address1.getText().isBlank() || city1.getText().isBlank() || country1.getText().isBlank()) {

                           JOptionPane.showMessageDialog(this, "Blank Spots Encountered", "Operation Not Successful", 0);
                    }
                    //Add a new Client to Reservation
                    else {
                        getData.clear();

                        String Firstname = firstname1.getText();
                        String Lastname = lastname1.getText();
                        String DocumentID = docID1.getText();
                        String Phone = phone1.getText();
                        String Address = address1.getText();
                        String City = city1.getText();
                        String Country = country1.getText();

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

                            //New ClientID
                            getData = DB_Connection.selectWhere4(new String[] {"ClientID"}, new String[] {"DocumentID"}, new String[] {DocumentID}, "Clients");
                            String ClientID = getData.get(0);

                            int row = jTable2.getSelectedRow();
                            String resID = String.valueOf(m.getValueAt(row, 0));

                            String Breeding = String.valueOf(breeding1.getSelectedItem());
                            getData.clear();
                            getData = DB_Connection.selectWhere4(new String[] {"Breeding_ID"},
                            new String[] {"Breeding_Type"}, new String[] {Breeding}, "Breeding");
                            String breedingID = getData.get(0);
                            getData.clear();

                            String Company = String.valueOf(discounts1.getSelectedItem());
                            getData.clear();
                            getData = DB_Connection.selectWhere4(new String[] {"DiscountID"},
                            new String[] {"Company"}, new String[] {Company}, "Discounts");
                            String discountID = getData.get(0);
                            getData.clear();

                            String Date = date1.getText();

                            String Stay = stay1.getText();

                            String Status = String.valueOf(status1.getSelectedItem());
                            getData.clear();
                            getData = DB_Connection.selectWhere4(new String[] {"ID_status"},
                            new String[] {"Paid"}, new String[] {Status}, "Payment_Status");
                            String statusID = getData.get(0);
                            getData.clear();

                            String arr[] = Stay.split(" ");

                            String[] columnsArray = {"ClientID", "Breeding_ID", "DiscountID", "Date_Reservation", "Stay", "ID_status"};
                            String[] valuesArray = {ClientID, breedingID, discountID, Date, arr[0], statusID};
                            String[] whereColumns = {"Reservation_ID"};
                            String[] whereValues = {resID};
                            DB_Connection.updateInt(columnsArray, valuesArray, whereColumns, whereValues, "Reservations");

                            getData.clear();

                            firstname1.setText("");
                            lastname1.setText("");
                            docID1.setText("");
                            phone1.setText("");
                            address1.setText("");
                            city1.setText("");
                            country1.setText("");

                            resetUpdateInfo();

                            JOptionPane.showMessageDialog(this, "Reservation Updated Successfully");
                        } 
                    }
                }
                //Add an Existing Client to Reservation
                else {
                    firstname1.setText("");
                    lastname1.setText("");
                    docID1.setText("");
                    phone1.setText("");
                    address1.setText("");
                    city1.setText("");
                    country1.setText("");

                    getData.clear();

                    String client = String.valueOf(clients1.getSelectedItem());
                    String arr1[] = {""};
                    for (int i = 0; i < client.length(); i++) {
                        arr1 = client.split("_");
                    }
                    getData = DB_Connection.selectWhere4(new String[] {"ClientID"}, new String[] {"DocumentID"}, new String[] {arr1[1]}, "Clients");
                    String clientID = getData.get(0);

                    int row = jTable2.getSelectedRow();
                    String resID = String.valueOf(m.getValueAt(row, 0));

                    String Breeding = String.valueOf(breeding1.getSelectedItem());
                    getData.clear();
                    getData = DB_Connection.selectWhere4(new String[] {"Breeding_ID"},
                    new String[] {"Breeding_Type"}, new String[] {Breeding}, "Breeding");
                    String breedingID = getData.get(0);
                    getData.clear();

                    String Company = String.valueOf(discounts1.getSelectedItem());
                    getData.clear();
                    getData = DB_Connection.selectWhere4(new String[] {"DiscountID"},
                    new String[] {"Company"}, new String[] {Company}, "Discounts");
                    String discountID = getData.get(0);
                    getData.clear();

                    String Date = date1.getText();

                    String Stay = stay1.getText();

                    String Status = String.valueOf(status1.getSelectedItem());
                    getData.clear();
                    getData = DB_Connection.selectWhere4(new String[] {"ID_status"},
                    new String[] {"Paid"}, new String[] {Status}, "Payment_Status");
                    String statusID = getData.get(0);
                    getData.clear();

                    String arr2[] = Stay.split(" ");

                    String[] columnsArray = {"ClientID", "Breeding_ID", "DiscountID", "Date_Reservation", "Stay", "ID_status"};
                    String[] valuesArray = {clientID, breedingID, discountID, Date, arr2[0], statusID};
                    String[] whereColumns = {"Reservation_ID"};
                    String[] whereValues = {resID};
                    DB_Connection.updateInt(columnsArray, valuesArray, whereColumns, whereValues, "Reservations");

                    resetUpdateInfo();
                    JOptionPane.showMessageDialog(this, "Reservation Updated Successfully");
                }
            }
            catch (Exception e) {
                resetUpdateInfo();
                JOptionPane.showMessageDialog(this, "Operation Reset", "Refresh", 1);
            }
        }
    }//GEN-LAST:event_UpdateMousePressed

    private void firstname1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstname1FocusGained
        // TODO add your handling code here:
        clients1.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_firstname1FocusGained

    private void lastname1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastname1FocusGained
        // TODO add your handling code here:
        clients1.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_lastname1FocusGained

    private void docID1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_docID1FocusGained
        // TODO add your handling code here:
        clients1.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_docID1FocusGained

    private void phone1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone1FocusGained
        // TODO add your handling code here:
        clients1.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_phone1FocusGained

    private void address1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address1FocusGained
        // TODO add your handling code here:
        clients1.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_address1FocusGained

    private void city1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_city1FocusGained
        // TODO add your handling code here:
        clients1.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_city1FocusGained

    private void country1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_country1FocusGained
        // TODO add your handling code here:
        clients1.getModel().setSelectedItem("Choose an Existing Client");
    }//GEN-LAST:event_country1FocusGained

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
                resetUpdateInfo();
                JOptionPane.showMessageDialog(this, "You Need To Select an Existing Reservation", "Operation Failure", 0);
            }
            if(jTable2.getSelectedRow() != -1) {
                int result = JOptionPane.showConfirmDialog(this, "Do you wish to continue?\nThis process cannot be undone.", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if(result == 0){
                    deleteReservation();
                    resetUpdateInfo();
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
                resetUpdateInfo();
                JOptionPane.showMessageDialog(this, "You Need To Select an Existing Reservation", "Operation Failure", 0);
            }
            
            else if(keyCode == KeyEvent.VK_DELETE && jTable2.getSelectedRow() != -1) {
                int result = JOptionPane.showConfirmDialog(this, "Do you wish to continue?\nThis process cannot be undone.", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if(result == 0){
                    deleteReservation();
                    resetUpdateInfo();
                    JOptionPane.showMessageDialog(this, "Reservation Deleted Successfully", "Operation Success", 1);
                }
            }
        }
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_jTable2KeyPressed

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
        try {
            fillTable();
            this.dispose();
            new Main_Menu().setVisible(true);
        }
        catch (Exception e) {
            fillTable();
            this.dispose();
            new Main_Menu().setVisible(true);
        }
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
        try {
            fillTable();
            this.dispose();
            new Reservations_Add_Delete().setVisible(true);
        }
        catch (Exception e) {
            fillTable();
            this.dispose();
            new Reservations_Add_Delete().setVisible(true);
        }
    }//GEN-LAST:event_add_deleteMousePressed

    private void add_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_deleteActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Reservations_Add_Delete().setVisible(true);
    }//GEN-LAST:event_add_deleteActionPerformed

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
        try {
            fillTable();
            this.dispose();
            new Reservations_Search().setVisible(true);
        }
        catch (Exception e) {
            fillTable();
            this.dispose();
            new Reservations_Search().setVisible(true);
        }
    }//GEN-LAST:event_searchMousePressed

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
        try {
            fillTable();
            this.dispose();
            new Clients_Add_Update_Delete().setVisible(true);
        }
        catch (Exception e) {
            fillTable();
            this.dispose();
            new Clients_Add_Update_Delete().setVisible(true);
        }
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
        try {
            fillTable();
            this.dispose();
            new Rooms().setVisible(true);
        }
        catch (Exception e) {
            fillTable();
            this.dispose();
            new Rooms().setVisible(true);
        }
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
        try {
            fillTable();
            this.dispose();
            new Services().setVisible(true);
        }
        catch (Exception e) {
            fillTable();
            this.dispose();
            new Services().setVisible(true);
        }
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
        try {
            fillTable();
            this.dispose();
            new Discounts().setVisible(true);
        }
        catch (Exception e) {
            fillTable();
            this.dispose();
            new Discounts().setVisible(true);
        }
    }//GEN-LAST:event_jMenu4MousePressed

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        // TODO add your handling code here:
        try {
            fillTable();
            this.dispose();
            new Main_Menu().setVisible(true);
        }
        catch (Exception e) {
            fillTable();
            this.dispose();
            new Main_Menu().setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(Reservations_Update_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservations_Update_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservations_Update_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservations_Update_Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservations_Update_Delete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Home;
    private javax.swing.JPopupMenu PopUpDelete;
    private javax.swing.JButton Update;
    private javax.swing.JButton addRoom;
    private javax.swing.JButton addService;
    private javax.swing.JMenuItem add_delete;
    private javax.swing.JTextField address1;
    private javax.swing.JComboBox<String> breeding1;
    private javax.swing.JTextField city1;
    private javax.swing.JComboBox<String> clients1;
    private javax.swing.JTextField country1;
    private javax.swing.JTextField date1;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JComboBox<String> discounts1;
    private javax.swing.JTextField docID1;
    private javax.swing.JTextField firstname1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField lastname1;
    private javax.swing.JTextField phone1;
    private javax.swing.JComboBox<String> room1;
    private javax.swing.JList<String> roomsList1;
    private javax.swing.JMenuItem search;
    private javax.swing.JComboBox<String> service;
    private javax.swing.JList<String> servicesList;
    private javax.swing.JComboBox<String> status1;
    private javax.swing.JTextField stay1;
    private javax.swing.JButton updateRoom;
    private javax.swing.JButton updateService;
    // End of variables declaration//GEN-END:variables
}
