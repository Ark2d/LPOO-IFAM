/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADIMINISTRADOR.PRODUTOeCATEGORIA;

import ADIMINISTRADOR.TelaCadastroAdm;
import Objetos.Adm;
import Objetos.Categoria;
import Objetos.ObjectDao;
import java.awt.Toolkit;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TelaListarCategoria extends javax.swing.JDialog {
    java.awt.Frame parent;
    /**
     * Creates new form TelaListarCategoria
     */
    public TelaListarCategoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarCategoria();
        this.parent = parent;
        setIcon();
    }
    
    private void carregarCategoria(){
        if(new File("src\\Dados\\categoria.dat").exists()){
            ObjectDao obj = new ObjectDao();       
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Código");
            modelo.addColumn("Nome");
            List<Categoria> list = (List<Categoria>)(Object)obj.show("categoria");
            for (Categoria categoria : list) {
                 modelo.addRow(new Object[]{categoria.getCodigo(),categoria.getNome()});
            } 
            boxCategoria.setModel(modelo);
            boxCategoria.getTableHeader().setReorderingAllowed(false);
        }      
    }
    private int procurarCategoria(){
        int i=0;
        int codigo =(Integer)boxCategoria.getValueAt(boxCategoria.getSelectedRow(), 0);
        ObjectDao obj = new ObjectDao();       
        List<Categoria> list = (List<Categoria>)(Object)obj.show("categoria");
        for (Categoria categoria : list) {
             if(categoria.getCodigo()==codigo){
                 System.out.println(i);
                 return i;
             }
             i++;
        } 
        return i;
    }
    
    private void abrirAlterarCategoria(){      
        TelaAlteraCategoria t = new TelaAlteraCategoria(this.parent, true, procurarCategoria());
        t.setVisible(true);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExcluir = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        boxCategoria = new javax.swing.JTable();
        jTextFieldAdm = new javax.swing.JTextField();
        btnPesquisarAdm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VK Sistemas");

        btnExcluir.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Categorias");

        boxCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        boxCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(boxCategoria);

        btnPesquisarAdm.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPesquisarAdm.setText("Pesquisar");
        btnPesquisarAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarAdmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextFieldAdm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrar, btnEditar, btnExcluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(0==JOptionPane.showConfirmDialog
            (this,"Tem certeza que deseja\n"
                + "excluir "+boxCategoria.getValueAt(boxCategoria.getSelectedRow(), 1),
                "Excluir Administrador",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)
        ){
            ObjectDao obj = new ObjectDao();
            Categoria c;
            int index = procurarCategoria();
            if(new File("src\\Dados\\categoria.dat").exists()){
                int codigo=0;            
                List<Categoria> list = (List<Categoria>)(Object)obj.show("categoria");
                new File("src\\Dados\\categoria.dat").delete();
                for (Categoria categoria : list) {
                    if(codigo==index){                    
                        codigo++;
                        continue;
                    }
                    obj.save("categoria", categoria);
                    codigo++;
                }

            } 
            carregarCategoria();
        }
       
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TelaCadastroCategoria t = new TelaCadastroCategoria(parent,true);
        t.setVisible(true);
        carregarCategoria();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        abrirAlterarCategoria();
        carregarCategoria();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void boxCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxCategoriaMouseClicked
        if(evt.getClickCount()==2){
            DefaultTableModel modelo = (DefaultTableModel)boxCategoria.getModel();
            int selectedRowIndex = boxCategoria.getSelectedRow();

        }
    }//GEN-LAST:event_boxCategoriaMouseClicked

    private void btnPesquisarAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarAdmActionPerformed
        // TODO add your handling code here:
        String nome = jTextFieldAdm.getText();

        ObjectDao obj = new ObjectDao();       
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        List<Categoria> list = (List<Categoria>)(Object)obj.show("categoria");
        
        for (Categoria cat : list){
            if(cat.getNome().contains(nome)){
                modelo.addRow(new Object[]{cat.getCodigo(),cat.getNome()});
            }
        }
        boxCategoria.setModel(modelo);
    }//GEN-LAST:event_btnPesquisarAdmActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaListarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaListarCategoria dialog = new TelaListarCategoria(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable boxCategoria;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisarAdm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAdm;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Imagens\\code.png"));
    }
}