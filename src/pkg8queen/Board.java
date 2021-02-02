package pkg8queen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import static pkg8queen.Main.simulatedAnnealing;

public class Board extends javax.swing.JFrame {

    private JLabel[][] cell = new JLabel[8][8];
    private Queen[] insertedQeens = new Queen[8];

    public Board() {
        initComponents();
        setLocationRelativeTo(null);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                cell[row][col] = new JLabel();
                cell[row][col].setVisible(true);
                cell[row][col].setSize(70, 70);
                cell[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/N_PLACED.png")));
                cell[row][col].setLocation(70 * col, 70 * row);
                add(cell[row][col]);
                boardPanel.add(cell[row][col]);
                int r = row;
                int c = col;
                cell[row][col].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (insertedQeens[c] != null && insertedQeens[c].getRow() == r) {
                            cell[r][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/N_PLACED.png")));
                            insertedQeens[c] = null;
                        } else {
                            if (insertedQeens[c] != null) {
                                cell[insertedQeens[c].getRow()][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/N_PLACED.png")));
                                insertedQeens[c] = null;
                            }
                            cell[r][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/QUEEN.png")));

                            insertedQeens[c] = new Queen(r, c);
                        }
                    }
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boardPanel = new javax.swing.JPanel();
        runButton = new javax.swing.JButton();
        randomSA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(620, 750));
        setPreferredSize(new java.awt.Dimension(620, 750));
        getContentPane().setLayout(null);

        boardPanel.setMinimumSize(new java.awt.Dimension(640, 640));
        boardPanel.setPreferredSize(new java.awt.Dimension(640, 640));
        boardPanel.setLayout(null);
        getContentPane().add(boardPanel);
        boardPanel.setBounds(20, 20, 680, 560);

        runButton.setText("Run SA");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });
        getContentPane().add(runButton);
        runButton.setBounds(370, 660, 140, 23);

        randomSA.setText("Run SA with random initial");
        randomSA.setToolTipText("");
        randomSA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomSAActionPerformed(evt);
            }
        });
        getContentPane().add(randomSA);
        randomSA.setBounds(80, 660, 280, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        State result = simulatedAnnealing(generateInitialState());
        System.out.println(result + "\nh : " + result.getH());
    }//GEN-LAST:event_runButtonActionPerformed

    private void randomSAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomSAActionPerformed
        State result = simulatedAnnealing(null);
        System.out.println(result + "\nh : " + result.getH());
    }//GEN-LAST:event_randomSAActionPerformed

    State generateInitialState() {
        return new State(insertedQeens);
    }

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
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardPanel;
    private javax.swing.JButton randomSA;
    private javax.swing.JButton runButton;
    // End of variables declaration//GEN-END:variables
}
