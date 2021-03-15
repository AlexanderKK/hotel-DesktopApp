/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPackage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author ALEX
 */

public class Main_Menu extends javax.swing.JFrame {
    
    public DefaultTableModel m;
    public ArrayList<String> getData = new ArrayList<>();
    public ArrayList<Integer> getDataInt = new ArrayList<>();
    
    /** Creates new form mainMenu */
    public Main_Menu() {
        initComponents();
        this.setTitle("MAIN MENU");
        fillLabels();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel26 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        search = new javax.swing.JMenuItem();
        add_delete = new javax.swing.JMenuItem();
        update_delete = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 200));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(145, 140, 39));
        jLabel1.setText("Summarised Data");

        jLabel5.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(172, 165, 31));
        jLabel5.setText("Rooms State");

        jLabel6.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel6.setText("Free");

        jLabel7.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel7.setText("Reserved");

        jLabel8.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel8.setText("Occupied");

        jLabel9.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel9.setText("Out of Order");

        jLabel11.setText("freeCount");

        jLabel12.setText("res");

        jLabel13.setText("ocp");

        jLabel14.setText("ofo");

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

        jLabel18.setText("paidCount");

        jLabel19.setText("notPaidCount");

        jLabel20.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel20.setText("Count");

        jLabel21.setText("resCount");

        jLabel22.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel22.setText("Count");

        jLabel23.setText("count");

        jLabel24.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel24.setText("Preferred VIEW");

        jLabel25.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel25.setText("TOP country");

        jLabel28.setText("top country");

        jLabel29.setText("preferred view");

        jLabel26.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel26.setText("VIP");

        jLabel2.setText("vipCount");

        jLabel27.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel27.setText("COUNT");

        jLabel30.setText("count");

        jMenuBar1.setFont(new java.awt.Font("Felix Titling", 0, 14)); // NOI18N

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
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel30))
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel2))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel24)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel23)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21))
                                        .addGap(58, 58, 58)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel19)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel18))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel30))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(812, 436));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseEntered
        // TODO add your handling code here:
        jMenu1.setForeground(new Color(172, 165, 31));
        
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

    private void jMenu3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseEntered
        // TODO add your handling code here:
        jMenu3.setForeground(new Color(172, 165, 31));
        
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

    private void jMenu4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseEntered
        // TODO add your handling code here:
        jMenu4.setForeground(new Color(172, 165, 31));
        
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

    private void jMenu5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseEntered
        // TODO add your handling code here:
        jMenu5.setForeground(new Color(172, 165, 31));
        
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

    private void searchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMousePressed
        // TODO add your handling code here:
        Reservations_Search Search = new Reservations_Search();
        this.dispose();
        Search.setVisible(true);
    }//GEN-LAST:event_searchMousePressed

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        // TODO add your handling code here:
        search.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        // TODO add your handling code here:
        search.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_searchMouseExited

    private void add_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_deleteMouseEntered
        // TODO add your handling code here:
        add_delete.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_add_deleteMouseEntered

    private void add_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_deleteMouseExited
        // TODO add your handling code here:
        add_delete.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_add_deleteMouseExited

    private void update_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_deleteMouseEntered
        // TODO add your handling code here:
        update_delete.setForeground(new Color(172, 165, 31));
    }//GEN-LAST:event_update_deleteMouseEntered

    private void update_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_deleteMouseExited
        // TODO add your handling code here:
        update_delete.setForeground(new Color(98, 98, 98));
    }//GEN-LAST:event_update_deleteMouseExited

    private void add_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_deleteActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Reservations_Add_Delete().setVisible(true);
    }//GEN-LAST:event_add_deleteActionPerformed

    private void add_deleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_deleteMousePressed
        // TODO add your handling code here:
        this.dispose();
        new Reservations_Add_Delete().setVisible(true);
    }//GEN-LAST:event_add_deleteMousePressed

    private void update_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_deleteActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Reservations_Update_Delete().setVisible(true);
    }//GEN-LAST:event_update_deleteActionPerformed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        // TODO add your handling code here:
        this.dispose();
        new Clients_Add_Update_Delete().setVisible(true);
    }//GEN-LAST:event_jMenu2MousePressed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        // TODO add your handling code here:
        this.dispose();
        new Rooms().setVisible(true);
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MousePressed
        // TODO add your handling code here:
        this.dispose();
        new Services().setVisible(true);
    }//GEN-LAST:event_jMenu5MousePressed

    private void jMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MousePressed
        // TODO add your handling code here:
        this.dispose();
        new Discounts().setVisible(true);
    }//GEN-LAST:event_jMenu4MousePressed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

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
    
    private void fillLabels() {
        getDataInt.clear();
        
        Color color = new Color(172,165,31);
        
        getDataInt.clear();
        
        String column0 = "RoomID";
        String table0 = "Rooms";
        getDataInt = DB_Connection.selectCount(column0, table0);
        jLabel30.setText(String.valueOf(getDataInt.get(0)));
        jLabel30.setForeground(color);
        jLabel30.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getDataInt.clear();
        
        String column1 = "RoomID";
        String table1 = "Rooms";
        String[] whereColumn1 = {"Room_State"};
        String[] whereValue1 = {"Free"};
        getDataInt = DB_Connection.selectCountWhere(column1, table1, whereColumn1, whereValue1);
        jLabel11.setText(String.valueOf(getDataInt.get(0)));
        jLabel11.setForeground(color);
        jLabel11.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getDataInt.clear();
        
        String[] whereValue2 = {"Reserved"};
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
        
        int[] whereValue7 = {3};
        getDataInt = DB_Connection.selectCountWhereInt(column2, table2, whereColumn2, whereValue7);
        jLabel2.setText(String.valueOf(getDataInt.get(0)));
        jLabel2.setForeground(color);
        jLabel2.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
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

        getData = DB_Connection.selectTopRoom_ViewJoin();
        jLabel29.setText(String.valueOf(getData.get(0)));
        jLabel29.setForeground(color);
        jLabel29.setFont(new Font("Felix Titling", Font.BOLD, 18));

        getData.clear();
        
        String column4 = "Country";
        String table4 = "Clients";
        String groupValue1 = "Country";
        String orderValue1 = "COUNT(Country)";
        String orderChoise1 = "DESC";
        getData = DB_Connection.selectGroupByOrderBy(column4, table4, groupValue1, orderValue1, orderChoise1);
        jLabel28.setText(String.valueOf(getData.get(0)));
        jLabel28.setForeground(color);
        jLabel28.setFont(new Font("Felix Titling", Font.BOLD, 18));
        
        getData.clear();
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
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Menu().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem add_delete;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem search;
    private javax.swing.JMenuItem update_delete;
    // End of variables declaration//GEN-END:variables

}
