/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyGame;

import java.awt.Graphics;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Andreina
 */
public class Menu extends javax.swing.JPanel {

    GuiFrame mGui;
    /**
     * Creates new form Menu
     */
    public Menu(GuiFrame gui) {
        mGui = gui;
        initComponents();
        jLabel1.setSize(296,145);
        //jLabel1.setIcon(new ImageIcon(Utils.loadImage(new File("res/welcome.png"))));
        setLabelImage(new ImageIcon(Utils.loadImage(new File("res/welcome.png"))), jLabel1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("to the MnM Game!");

        jToggleButton1.setBackground(new java.awt.Color(255, 153, 153));
        jToggleButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jToggleButton1.setText("PLAY");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.setOpaque(true);
        jToggleButton1.setRequestFocusEnabled(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(255, 153, 153));
        jToggleButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jToggleButton2.setText("Get some HELP");
        jToggleButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jToggleButton2.setFocusPainted(false);
        jToggleButton2.setFocusable(false);
        jToggleButton2.setOpaque(true);
        jToggleButton2.setRequestFocusEnabled(false);
        jToggleButton2.setVerifyInputWhenFocusTarget(false);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(289, 289, 289))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263))))
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        jToggleButton1.setSelected(false);
        mGui.showOnScreen("GamePanel");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        jToggleButton2.setSelected(false);
        mGui.showOnScreen("InstructionsPanel");
    }//GEN-LAST:event_jToggleButton2ActionPerformed

public void setLabelImage(ImageIcon ii, JLabel lbl) {

        double iiAR = (double) ii.getIconWidth() / (double) ii.getIconHeight(); // aspect ratio pentru imaginea de afisat
        double dslAR = (double) lbl.getWidth() / (double) lbl.getHeight(); // aspect ratio al label-ului in care se afiseaza

        int width = lbl.getWidth();
        int height = lbl.getHeight();

        if (iiAR < dslAR) {
            width = -1; // "fit height" mode, keeping aspect ratio)
        } else {
            height = -1; // "fit width" mode, keeping aspect ratio
        }
        lbl.setIcon(new ImageIcon(
                ii.getImage().getScaledInstance(
                        width,
                        height,
                        0)));

    }

@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Utils.loadImage(new File("res/bgnd.png")), 0, 0, getWidth(), getHeight(), this);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
