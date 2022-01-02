package Listagem;

import inicio.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QueryVisits extends javax.swing.JFrame {

    static String driverJBC = "com.mysql.cj.jdbc.Driver";
    static String url       = "jdbc:mysql://localhost:3306/clinica"; 
    static String user      = "root";
    static String senha     = "";
    
    public QueryVisits() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaConsultas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Consultas");

        jButton1.setBackground(new java.awt.Color(81, 213, 255));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1GoToMenu(evt);
            }
        });

        TabelaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            DadosTabelaConsultas(),
            new String [] {
                "ID", "ID Medico", "ID Paciente", "Data", "Descricao","Status","Excluir"
            }
        ));
        TabelaConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaConsultasDelete(evt);
            }
        });
        TabelaConsultas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabelaConsultasUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaConsultas);

        jButton2.setBackground(new java.awt.Color(81, 213, 255));
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(20, 20, 20))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private Object[][] DadosTabelaConsultas(){
        Object[][] dadosTable = null;
        try {
            Connection conexao = DriverManager.getConnection (url, user, senha);
            Statement selecionar = conexao.createStatement();

            //Descobrir o numero de linhas pra criar a tabela
            ResultSet count = selecionar.executeQuery("SELECT COUNT(*) AS 'total' FROM consulta");
            count.next();
            int nLinhas = count.getInt("total");
            dadosTable = new Object[nLinhas][7]; 
            
            //Salvar os dados na variavel
            ResultSet res = selecionar.executeQuery("SELECT * FROM consulta");
            res.next();
            int i = 0;
            while (i < nLinhas) {
                dadosTable[i][0] = res.getString("IDConsulta");
                dadosTable[i][1] = res.getString("IDMedico");
                dadosTable[i][2] = res.getString("IDpaciente");
                dadosTable[i][3] = res.getString("DataConsulta");
                dadosTable[i][4] = res.getString("Descricao");
                dadosTable[i][5] = res.getString("StatusConsulta");
                dadosTable[i][6] = "X";
                res.next();
                i++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao exibir dados das consultas","Erro SQL",JOptionPane.ERROR_MESSAGE);
            System.out.println("OH NAO FALHA SQL");
        }
        return dadosTable;
    }
    
    private void jButton1GoToMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1GoToMenu
        // TODO add your handling code here:
        this.dispose();

        Login i = new Login();
        i.setVisible(true);
    }//GEN-LAST:event_jButton1GoToMenu

    private void TabelaConsultasUpdate(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabelaConsultasUpdate
        DefaultTableModel model = (DefaultTableModel) TabelaConsultas.getModel();
        int selectedRowIndex = TabelaConsultas.getSelectedRow();
        int selectedColumnIndex = TabelaConsultas.getSelectedColumn();
        String IdMudado, valorMudado;
        
        //Qualquer clique vai cair o que, isso só impede de dar um exeption quando iniciar a primeira vez (em -1,-1)
        if(selectedRowIndex >=0 && selectedColumnIndex >= 0){
            //id de qual linha esta sendo alterada
            IdMudado = model.getValueAt(selectedRowIndex, 0).toString();
            System.out.println("[id selecionado]" + IdMudado);

            //Se for um id não pode ser editado
            if(selectedColumnIndex == 0){
                JOptionPane.showMessageDialog(null, "Proibido alterar o ID","PARO AÍ",JOptionPane.WARNING_MESSAGE);
                System.out.println("Proibido alterar o ID");
                
            //Se for um X tenta excluir (DELETE)
            } else if (selectedColumnIndex == 6){
                //Ele vai cair na funcao do clique, don't worry about it
            //Se não for nem ID, nem X, tenta/pode alterar (UPDATE)
            } else {
                //qual o novo valor digitado
                valorMudado = model.getValueAt(selectedRowIndex, selectedColumnIndex).toString();
                System.out.println("[valor mudado]" + valorMudado);

                String ColunaSelecionada = null;
                switch(selectedColumnIndex){
                    case 1 -> ColunaSelecionada = "IDMedico";
                    case 2 -> ColunaSelecionada = "IDpaciente";
                    case 3 -> ColunaSelecionada = "DataConsulta";
                    case 4 -> ColunaSelecionada = "Descricao";     
                    case 5 -> ColunaSelecionada = "StatusConsulta";                      
                }
                try {
                    Connection conexao = DriverManager.getConnection (url, user, senha);
                    Statement atualizar = conexao.createStatement();

                    System.out.println("[coluna selecionada]" + ColunaSelecionada);
                    atualizar.execute("UPDATE consulta SET "+ ColunaSelecionada +" ='"+ valorMudado +"' WHERE IDConsulta = "+ IdMudado);
                    System.out.println("Consulta Atualizado com Sucesso");
                    //JOptionPane.showMessageDialog(null, ColunaSelecionada + " do Usuario " + IdMudado + " foi alterado","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Falha ao fazer update","Erro SQL",JOptionPane.ERROR_MESSAGE);
                    System.out.println("OH NAO FALHA SQL");
                }
            }
        }
    }//GEN-LAST:event_TabelaConsultasUpdate

    private void TabelaConsultasDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaConsultasDelete
        DefaultTableModel model = (DefaultTableModel) TabelaConsultas.getModel();
        int selectedRowIndex = TabelaConsultas.getSelectedRow();
        int selectedColumnIndex = TabelaConsultas.getSelectedColumn();
        String IdMudado;
        int excluir;
        
        //Qualquer clique vai cair o que, isso só impede de dar um exeption quando iniciar a primeira vez (em -1,-1)
        if(selectedRowIndex >=0 && selectedColumnIndex >= 0){
            
            //Se for um X tenta excluir (DELETE)
            if (selectedColumnIndex == 6){
                IdMudado = model.getValueAt(selectedRowIndex, 0).toString();
                excluir = JOptionPane.showConfirmDialog(null, "Excluir?");
                System.out.println(excluir);
                if(excluir == 0){
                    try{
                        Connection conexao = DriverManager.getConnection (url, user, senha);
                        Statement deletar = conexao.createStatement();
                        
                        System.out.println("[linha a ser excluida] " + IdMudado);
                        deletar.execute("DELETE FROM consulta WHERE IDConsulta = "+ IdMudado);
                        System.out.println("Consulta Deletada com Sucesso");
                        JOptionPane.showMessageDialog(null, "Consulta " + IdMudado + " foi excluida","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                        //se excluir, muda essa linha (temporariamente) pra '---' não altera ordem, nem dados, só pela aparencia mesmo
                        model.setValueAt("---", selectedRowIndex, 0);
                        model.setValueAt("---", selectedRowIndex, 1);
                        model.setValueAt("---", selectedRowIndex, 2);
                        model.setValueAt("---", selectedRowIndex, 3);
                        model.setValueAt("---", selectedRowIndex, 4);
                        model.setValueAt("---", selectedRowIndex, 5);
                        model.setValueAt("---", selectedRowIndex, 6);
                        
                    } catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Falha ao deletar","Erro SQL",JOptionPane.ERROR_MESSAGE);
                        System.out.println("OH NAO FALHA SQL");
                    }
                }
                

            } 
        }
    }//GEN-LAST:event_TabelaConsultasDelete

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        //fechar e abrir mesmo kkkk
        this.dispose();
        QueryVisits i = new QueryVisits();
        i.setVisible(true);
    }//GEN-LAST:event_RefreshActionPerformed
    
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
            java.util.logging.Logger.getLogger(QueryVisits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueryVisits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueryVisits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueryVisits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueryVisits().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaConsultas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
