/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import inicio.Inicio;
import inicio.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class addDoc extends javax.swing.JFrame {

    static String driverJBC = "com.mysql.cj.jdbc.Driver";
    static String url       = "jdbc:mysql://localhost:3306/clinica"; 
    static String user      = "root";
    static String senha     = "";
    
    private int docIdUser;
    private String docNome;
    private String docCrm;
    private int docClinica;
    private int docEspec;
    
    public addDoc() {
        initComponents();
    }

    private String[] GetClinicas(){
        
        String[] clinicas = null;

        try {
            Connection conexao = DriverManager.getConnection (url, user, senha);
            Statement selecionar = conexao.createStatement();

            //Descobrir o numero de linhas pra criar a tabela
            ResultSet count = selecionar.executeQuery("SELECT COUNT(*) AS 'total' FROM clinica");
            count.next();
            int nLinhas = count.getInt("total");
            clinicas = new String[nLinhas]; 

            //Salvar os dados na variavel
            ResultSet res = selecionar.executeQuery("SELECT * FROM clinica");

            res.next();

            int i = 0;
            while (i < nLinhas) {
                clinicas[i] = res.getString("IDClinica");

                res.next();
                i++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao exibir dados dos medicos","Erro SQL",JOptionPane.ERROR_MESSAGE);
            System.out.println("OH NAO FALHA SQL");
        }
        
        return clinicas;
    }
    
     private String[] GetEspecs(){
        
        String[] especs = null;

        try {
            Connection conexao = DriverManager.getConnection (url, user, senha);
            Statement selecionar = conexao.createStatement();

            //Descobrir o numero de linhas pra criar a tabela
            ResultSet count = selecionar.executeQuery("SELECT COUNT(*) AS 'total' FROM especialidade");
            count.next();
            int nLinhas = count.getInt("total");
            especs = new String[nLinhas]; 

            //Salvar os dados na variavel
            ResultSet res = selecionar.executeQuery("SELECT * FROM especialidade");

            res.next();

            int i = 0;
            while (i < nLinhas) {
                especs[i] = res.getString("IDespecialidade");

                res.next();
                i++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao exibir dados dos medicos","Erro SQL",JOptionPane.ERROR_MESSAGE);
            System.out.println("OH NAO FALHA SQL");
        }
        
        return especs;
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        IdUser = new javax.swing.JTextField();
        NomeDoc = new javax.swing.JTextField();
        CrmDoc = new javax.swing.JTextField();
        ClinicaComboBox = new javax.swing.JComboBox<>();
        EspecComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 345));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar M??dico");

        jButton1.setBackground(new java.awt.Color(81, 213, 255));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1GoToMenu(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Id Usu??rio");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CRM");

        jButton2.setBackground(new java.awt.Color(81, 213, 255));
        jButton2.setText("Inserir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertDoc(evt);
            }
        });

        jLabel5.setText("ID Cl??nica");

        jLabel6.setText("ID Especialidade");

        ClinicaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
            GetClinicas()
        )
    );
    ClinicaComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ClinicaComboBoxActionPerformed(evt);
        }
    });

    EspecComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(GetEspecs()));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(54, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(EspecComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClinicaComboBox, 0, 129, Short.MAX_VALUE)
                        .addComponent(CrmDoc)
                        .addComponent(NomeDoc)
                        .addComponent(IdUser))
                    .addGap(98, 98, 98))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(146, 146, 146))
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jButton1)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(jButton1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(IdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(NomeDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(CrmDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(ClinicaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(EspecComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jButton2)
            .addContainerGap(30, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    

    
    private void jButton1GoToMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1GoToMenu
        // TODO add your handling code here:
        this.dispose();

        Inicio i = new Inicio();
        i.setVisible(true);
    }//GEN-LAST:event_jButton1GoToMenu

    private void InsertDoc(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertDoc
        
        //passa pra variavel independente de ser null ou vazio
        
        this.docNome = NomeDoc.getText();
        this.docCrm = CrmDoc.getText();
        
        try {   
            this.docIdUser = Integer.parseInt(IdUser.getText() ); 
        } 
        catch (NumberFormatException e){
            System.out.println("N??mero inv??lido!");    
            JOptionPane.showMessageDialog(null, "N??mero Inv??lido", "Erro seu",JOptionPane.WARNING_MESSAGE);
        }
        try {   
            this.docClinica = Integer.parseInt( ClinicaComboBox.getSelectedItem().toString() );
        } 
        catch (NumberFormatException e){
            System.out.println("N??mero inv??lido!");    
            JOptionPane.showMessageDialog(null, "N??mero Inv??lido", "Erro seu",JOptionPane.WARNING_MESSAGE);
        }
        try {   
            this.docEspec = Integer.parseInt( EspecComboBox.getSelectedItem().toString() );
        } 
        catch (NumberFormatException e){
            System.out.println("N??mero inv??lido!");    
            JOptionPane.showMessageDialog(null, "N??mero Inv??lido", "Erro seu",JOptionPane.WARNING_MESSAGE);
        }
        
        
        //Verifica se est??o preenchidas
        if(this.docIdUser == -1 || this.docNome.equals("") || this.docCrm.equals("") ||this.docClinica == -1 || this.docEspec == -1){
            System.out.println("PREENCHA TUDO");
            JOptionPane.showMessageDialog(null, "PREENCHA TUDO", "Erro seu",JOptionPane.WARNING_MESSAGE);

        //Tenta enviar pro server    
        } else {
            System.out.println("tudo preenchido :)");
            System.out.println("[IdUsuario]" + this.docIdUser + "\n[Nome]" + this.docNome + "\n[CRM]" + this.docCrm + "\n[Clinica]" + this.docClinica +"\n[Espec]" + this.docEspec);
            
            try {      
                Connection conexao = DriverManager.getConnection (url, user, senha);
                Statement inserir = conexao.createStatement();

                System.out.println("INSERT INTO medico (IDusuario, Nomemedico, CRM, IDClinica, IDespecialidade) VALUES (' "+this.docIdUser+" ','  "+this.docNome+"  ','  "+this.docCrm+"  ',' "+this.docClinica+" ',' "+this.docEspec+" ')");

                inserir.execute("INSERT INTO medico (IDusuario, Nomemedico, CRM, IDClinica, IDespecialidade)"
                      + "VALUES (' "+this.docIdUser+" ','  "+this.docNome+"  ','  "+this.docCrm+"  ',' "+this.docClinica+" ',' "+this.docEspec+" ')" );
                
                JOptionPane.showMessageDialog(null, "Feita a inser????o","Sucesso",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Feita a inser????o, par??a\n-----------------------------------------");

            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "OH NAO FALHA SQL","Erro SQL",JOptionPane.ERROR_MESSAGE);
                System.out.println("OH NAO FALHA SQL");
            }        
        }
        
    }//GEN-LAST:event_InsertDoc

    private void ClinicaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClinicaComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClinicaComboBoxActionPerformed


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
            java.util.logging.Logger.getLogger(addDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addDoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ClinicaComboBox;
    private javax.swing.JTextField CrmDoc;
    private javax.swing.JComboBox<String> EspecComboBox;
    private javax.swing.JTextField IdUser;
    private javax.swing.JTextField NomeDoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
