package inicio;

import inicio.Inicio;

import java.sql.Connection;
import java.sql.DriverManager;    
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    static String driverJBC = "com.mysql.cj.jdbc.Driver";
    static String url       = "jdbc:mysql://localhost:3306/clinica"; 
    static String user      = "root";
    static String senha     = "";
    
    private String userEmail;
    private String userSenha;
    
    public Login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        emailField = new javax.swing.JTextField();
        passField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 345));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bem - Vindo");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Senha");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Email");

        jButton2.setBackground(new java.awt.Color(81, 213, 255));
        jButton2.setText("Entrar");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(81, 213, 255));
        jButton1.setText("Registrar-se");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logon(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login

        //passa pra variavel independente de ser null ou vazio
        this.userEmail = emailField.getText();
        this.userSenha = passField.getText();

        boolean logou = false;
        
        //Verifica se as variavel estão preenchidas
        if(this.userEmail.equals("") || this.userSenha.equals("")){
            System.out.println("PREENCHA TUDO");
            JOptionPane.showMessageDialog(null, "PREENCHA TUDO", "Erro seu",JOptionPane.WARNING_MESSAGE);

        //Tenta fazer o login
        } else {
            System.out.println("tudo preenchido :)");
            System.out.println("[email]" + this.userEmail + "\n[senha]" + this.userSenha + "\n[tipo]");
            
            try {      
                Connection conexao = DriverManager.getConnection (url, user, senha);
                Statement selecionar = conexao.createStatement();

                //Descobrir o numero de linhas pra criar os vetores
                ResultSet count = selecionar.executeQuery("SELECT COUNT(*) AS 'total' FROM usuario");
                count.next();
                int nLinhas = count.getInt("total");
                String users[] = new String[nLinhas];
                String senhas[] = new String[nLinhas];
                                
                //Salvar os dados na variavel
                ResultSet res = selecionar.executeQuery("SELECT * FROM usuario");
              
                res.next();
            
                int i = 0;
                while (i < nLinhas) {
                    users[i] = res.getString("Email");
                    senhas[i] = res.getString("Senha");
                    
                    if(users[i].equals(this.userEmail) && senhas[i].equals(this.userSenha)){
                        this.dispose();

                        Inicio l = new Inicio();
                        l.setVisible(true);
                        
                        logou = true;
                    }

                    res.next();
                    i++;
                }
                
                if(logou == false) {
                    JOptionPane.showMessageDialog(null, "Esse conjunto de Usuario e Senha não está registrado","Erro SQL",JOptionPane.WARNING_MESSAGE);
                    System.out.println("Usuario não encontrado");
                }

            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "OH NAO FALHA SQL","Erro SQL",JOptionPane.ERROR_MESSAGE);
                System.out.println("OH NAO FALHA SQL");
            }
            
        }

    }//GEN-LAST:event_Login

    private void Logon(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logon

        this.dispose();

        Logon l = new Logon();
        l.setVisible(true);
        
    }//GEN-LAST:event_Logon

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });

                /*CONECTAR NO BD*/
        try{
            System.out.println("Carregando driver JBC...");
            Class.forName(driverJBC);
            
            System.out.println("Driver carregado com sucesso");
            
        } catch (Exception e){
            System.out.println("Falha no carregamento");
            JOptionPane.showMessageDialog(null, "OH NAO FALHA SQL","Erro SQL",JOptionPane.ERROR_MESSAGE);

        }
        
        try {
            System.out.println("Conectando ao Banco...");
            Connection conexao = DriverManager.getConnection (url, user, senha);
            
            System.out.println("GG WP");
            System.out.println("-----------------------------------------");

        } catch (Exception e){
            System.out.println("Falha na conexão");
            JOptionPane.showMessageDialog(null, "OH NAO FALHA SQL","Erro SQL",JOptionPane.ERROR_MESSAGE);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField passField;
    // End of variables declaration//GEN-END:variables
}
