/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author ALEX
 */

public class Authorization extends javax.swing.JFrame {
    
    public DefaultTableModel m;
    public ArrayList<String> getData = new ArrayList<>();
    public ArrayList<Integer> getDataInt = new ArrayList<>();
    
    /** Creates new form mainMenu */
    public Authorization() {
        
        initComponents();
        
        jDialog1.setSize(578, 326);
        jDialog1.setTitle("HOTEL RESERVATIONS");
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setVisible(true);
        
        fillLabels();
        
        
//        m = (DefaultTableModel) jTable1.getModel();
//        fillTable();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jDialog1.setResizable(false);
        jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialog1WindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel3.setText("Password");

        jTextField1.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Felix Titling", 0, 36)); // NOI18N
        jLabel4.setText("AUTHORIZATION");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(133, 133, 133))))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 200));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(145, 140, 39));
        jLabel1.setText("Hotel \"Fortune\"");

        jLabel5.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(172, 165, 31));
        jLabel5.setText("Rooms State");

        jLabel6.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel6.setText("Free");

        jLabel7.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel7.setText("Being Cleaned");

        jLabel8.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel8.setText("Occupied");

        jLabel9.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel9.setText("Out of Order");

        jLabel10.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(172, 165, 31));
        jLabel10.setText("Reservations");

        jLabel15.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(172, 165, 31));
        jLabel15.setText("Clients INFO");

        jLabel16.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel16.setText("Paid");

        jLabel17.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel17.setText("Not Paid");

        jLabel20.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel20.setText("Count");

        jLabel22.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel22.setText("Count");

        jLabel24.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel24.setText("Preferred VIEW");

        jLabel25.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel25.setText("TOP country");

        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(98, 98, 98));
        jMenu1.setText("Reservations");
        jMenu1.setFocusPainted(true);
        jMenu1.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu1MouseExited(evt);
            }
        });

        jMenuItem3.setText("Search");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText("Add & Update");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Delete");
        jMenu1.add(jMenuItem2);

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
        });
        jMenuBar1.add(jMenu3);

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
        });
        jMenuBar1.add(jMenu4);

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
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel10)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel23))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel28))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel18)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14)))
                    .addComponent(jLabel11))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(778, 387));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        int code = evt.getKeyCode();
        if(code == KeyEvent.VK_ENTER) {
            authorization();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        int code = evt.getKeyCode();
        if(code == KeyEvent.VK_ENTER) {
            authorization();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jDialog1WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowClosing
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Do you wish to continue?", "Exit", JOptionPane.YES_NO_OPTION);
        if(result == 0){
            jDialog1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Runtime.getRuntime().exit(0);
        }
        else {
            jDialog1.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_jDialog1WindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        authorization();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void authorization() {
        String username = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        if(username.equals("administrator") && password.equals("101admin101")) {
            jDialog1.dispose();
            jDialog1.setVisible(false);
            Main_Menu Menu = new Main_Menu();
            Menu.setVisible(true);
        }
        else {
            Color color = new Color(150, 0, 0);
            jDialog1.getContentPane().setBackground(color);
            jDialog1.setTitle("WRONG INPUT");
            jLabel4.setText("Incorrect username or password");
            jLabel4.setForeground(Color.WHITE);
            jLabel4.setFont(new Font("Felix Titling", Font.PLAIN, 16));
            jDialog1.setSize(578, 300);
            jTextField1.setText("");
            jPasswordField1.setText("");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void jMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseEntered
        // TODO add your handling code here:
        jMenu1.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_jMenu1MouseEntered

    private void jMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseExited
        // TODO add your handling code here:
        jMenu1.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu1MouseExited

    private void jMenu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseEntered
        // TODO add your handling code here:
        jMenu2.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_jMenu2MouseEntered

    private void jMenu2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseExited
        // TODO add your handling code here:
         jMenu2.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu2MouseExited

    private void jMenu3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseEntered
        // TODO add your handling code here:
        jMenu3.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_jMenu3MouseEntered

    private void jMenu3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseExited
        // TODO add your handling code here:
        jMenu3.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu3MouseExited

    private void jMenu4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseEntered
        // TODO add your handling code here:
        jMenu4.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_jMenu4MouseEntered

    private void jMenu4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseExited
        // TODO add your handling code here:
         jMenu4.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu4MouseExited

    private void jMenu5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseEntered
        // TODO add your handling code here:
         jMenu5.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_jMenu5MouseEntered

    private void jMenu5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseExited
        // TODO add your handling code here:
        jMenu5.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_jMenu5MouseExited

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        // TODO add your handling code here:
        Reservations_Search Search = new Reservations_Search();
        this.dispose();
        Search.setVisible(true);
    }//GEN-LAST:event_jMenuItem3MousePressed
    
//    private void fillTable() {
//        getData.clear();
//        
//        String[] columns = {"RoomID", "Room_Type", "Room_Number", "Room_View", "Room_State", "Room_Price"};
//        String table = "Rooms";
//        getData = DB_Connection.select(columns, table);
//        for (int i = 0; i < getData.size(); i++) {
//            String[] arr = getData.get(i).split("_");
//            m.addRow(new Object[] {
//                arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]
//            });
//        }
//        
//        getData.clear();
//    }
    
    private void fillLabels() {
        getDataInt.clear();
        
        Color color = new Color(172,165,31);
        String column1 = "RoomID";
        String table1 = "Rooms";
        String[] whereColumn1 = {"Room_State"};
        String[] whereValue1 = {"Free"};
        getDataInt = DB_Connection.selectCountWhere(column1, table1, whereColumn1, whereValue1);
        jLabel11.setText(String.valueOf(getDataInt.get(0)));
        jLabel11.setForeground(color);
        jLabel11.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getDataInt.clear();
        
        String[] whereValue2 = {"Being Cleaned"};
        getDataInt = DB_Connection.selectCountWhere(column1, table1, whereColumn1, whereValue2);
        jLabel12.setText(String.valueOf(getDataInt.get(0)));
        jLabel12.setForeground(color);
        jLabel12.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getDataInt.clear();
        
        String[] whereValue3 = {"Occupied"};
        getDataInt = DB_Connection.selectCountWhere(column1, table1, whereColumn1, whereValue3);
        jLabel13.setText(String.valueOf(getDataInt.get(0)));
        jLabel13.setForeground(color);
        jLabel13.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getDataInt.clear();
        
        String[] whereValue4 = {"Out of Order"};
        getDataInt = DB_Connection.selectCountWhere(column1, table1, whereColumn1, whereValue4);
        jLabel14.setText(String.valueOf(getDataInt.get(0)));
        jLabel14.setForeground(color);
        jLabel14.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getDataInt.clear();
        
        String column2 = "Reservation_ID";
        String table2 = "Reservations";
        getDataInt = DB_Connection.selectCount(column2, table2);
        jLabel21.setText(String.valueOf(getDataInt.get(0)));
        jLabel21.setForeground(color);
        jLabel21.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getDataInt.clear();
        
        String[] whereColumn2 = {"ID_status"};
        int[] whereValue5 = {1};
        getDataInt = DB_Connection.selectCountWhereInt(column2, table2, whereColumn2, whereValue5);
        jLabel18.setText(String.valueOf(getDataInt.get(0)));
        jLabel18.setForeground(color);
        jLabel18.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getDataInt.clear();
        
        int[] whereValue6 = {2};
        getDataInt = DB_Connection.selectCountWhereInt(column2, table2, whereColumn2, whereValue6);
        jLabel19.setText(String.valueOf(getDataInt.get(0)));
        jLabel19.setForeground(color);
        jLabel19.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getDataInt.clear();
        
        String column3 = "ClientID";
        String table3 = "Clients";
        getDataInt = DB_Connection.selectCount(column3, table3);
        jLabel23.setText(String.valueOf(getDataInt.get(0)));
        jLabel23.setForeground(color);
        jLabel23.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
//        SELECT Country FROM Clients
//        GROUP BY Country
//        ORDER BY COUNT(Country) DESC
        getDataInt.clear();


        getData.clear();
        
        String column4 = "Country";
        String table4 = "Clients";
        String groupValue1 = "Country";
        String orderValue1 = "COUNT(Country)";
        String orderChoise1 = "DESC";
        getData = DB_Connection.selectGroupByOrderBy(column4, table4, groupValue1, orderValue1, orderChoise1);
        jLabel28.setText(getData.get(0));
        jLabel28.setForeground(color);
        jLabel28.setFont(new Font("Felix Titling", Font.BOLD, 18));       

        getData.clear();
        
        getData = DB_Connection.selectTopRoom_ViewJoin();
        jLabel29.setText(getData.get(0));
        jLabel29.setForeground(color);
        jLabel29.setFont(new Font("Felix Titling", Font.BOLD, 18));
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
            java.util.logging.Logger.getLogger(Authorization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authorization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authorization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authorization.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authorization().setVisible(false);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
