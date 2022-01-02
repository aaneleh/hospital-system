package Listagem;

import inicio.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QueryAll extends javax.swing.JFrame {

    static String driverJBC = "com.mysql.cj.jdbc.Driver";
    static String url       = "jdbc:mysql://localhost:3306/clinica"; 
    static String user      = "root";
    static String senha     = "";
    
    public QueryAll() {
        initComponents();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaClinicas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaPaciente = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelaMedicos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelaEspecs = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        TabelaUsuarios = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        Refresh = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 345));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Todos os Registros Disponíveis");

        jButton1.setBackground(new java.awt.Color(81, 213, 255));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1GoToMenu(evt);
            }
        });

        TabelaClinicas.setModel(new javax.swing.table.DefaultTableModel(

            DadosTabelaClinicas(),
            new String [] {
                "ID", "Nome","Endereço","Numero","CEP","Razao Social","Excluir"
            }

        ));
        TabelaClinicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaClinicasDelete(evt);
            }
        });
        TabelaClinicas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabelaClinicasUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaClinicas);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Clinicas");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pacientes");

        TabelaPaciente.setModel(new javax.swing.table.DefaultTableModel(

            DadosTabelaPacientes(),
            new String [] {
                "ID", "ID Usuario", "Nome","DOB","CPF","RG","Telefone","Email","Contato","TelefoneContato","Comentario","Excluir"
            }

        ));
        TabelaPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaPacienteDelete(evt);
            }
        });
        TabelaPaciente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabelaPacienteUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaPaciente);

        TabelaMedicos.setModel(new javax.swing.table.DefaultTableModel(

            DadosTabelaMedicos(),
            new String [] {
                "ID", "ID User", "Nome", "CRM", "ID Clinica", "ID Especialidade","Excluir"
            }

        ));
        TabelaMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMedicosDelete(evt);
            }
        });
        TabelaMedicos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabelaMedicosUpdate(evt);
            }
        });
        jScrollPane4.setViewportView(TabelaMedicos);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Médicos");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Especialidades");

        TabelaEspecs.setModel(new javax.swing.table.DefaultTableModel(

            DadosTabelaEspec(),
            new String [] {
                "ID", "Nome","Excluir"
            }

        ));
        TabelaEspecs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaEspecsDelete(evt);
            }
        });
        TabelaEspecs.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabelaEspecsUpdate(evt);
            }
        });
        jScrollPane5.setViewportView(TabelaEspecs);

        TabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(

            DadosTabelaUsuarios(),
            new String [] {
                "ID", "Email","Senha","Tipo","Excluir"
            }

        ));
        TabelaUsuarios.setDragEnabled(true);
        TabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaUsuariosDelete(evt);
            }
        });
        TabelaUsuarios.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TabelaUsuariosUpdate(evt);
            }
        });
        jScrollPane6.setViewportView(TabelaUsuarios);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Usuarios");

        Refresh.setBackground(new java.awt.Color(81, 213, 255));
        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Refresh)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Refresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //FEITO - PREENCHE A TABELA DE USUARIOS 
    private Object[][] DadosTabelaUsuarios(){
        Object[][] dadosTable = null;
        try {
            Connection conexao = DriverManager.getConnection (url, user, senha);
            Statement selecionar = conexao.createStatement();

            //Descobrir o numero de linhas pra criar a tabela
            ResultSet count = selecionar.executeQuery("SELECT COUNT(*) AS 'total' FROM usuario");
            count.next();
            int nLinhas = count.getInt("total");
            dadosTable = new Object[nLinhas][5]; 
            
            //Salvar os dados na variavel
            ResultSet res = selecionar.executeQuery("SELECT * FROM usuario");

            res.next();
            
            int i = 0;
            while (i < nLinhas) {
                dadosTable[i][0] = res.getString("IDusuario");
                dadosTable[i][1] = res.getString("Email");
                dadosTable[i][2] = res.getString("Senha");
                dadosTable[i][3] = res.getString("Tipo_usuario");
                dadosTable[i][4] = "X";

                res.next();
                i++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao exibir dados dos usuarios","Erro SQL",JOptionPane.ERROR_MESSAGE);
            System.out.println("OH NAO FALHA SQL");
        }
        return dadosTable;
    }
    //FEITO - PREENCHE A TABELA DE CLINICAS
    private Object[][] DadosTabelaClinicas(){
        Object[][] dadosTable = null;
        try {
            Connection conexao = DriverManager.getConnection (url, user, senha);
            Statement selecionar = conexao.createStatement();

            //Descobrir o numero de linhas pra criar a tabela
            ResultSet count = selecionar.executeQuery("SELECT COUNT(*) AS 'total' FROM clinica");
            count.next();
            int nLinhas = count.getInt("total");
            dadosTable = new Object[nLinhas][7]; 
            
            //Salvar os dados na variavel
            ResultSet res = selecionar.executeQuery("SELECT * FROM clinica");

            res.next();
            
            int i = 0;
            while (i < nLinhas) {
                dadosTable[i][0] = res.getString("IDClinica");
                dadosTable[i][1] = res.getString("NomeFantasia");
                dadosTable[i][2] = res.getString("Endereco");
                dadosTable[i][3] = res.getString("Numero");
                dadosTable[i][4] = res.getString("Cep");
                dadosTable[i][5] = res.getString("Razao_Social");
                dadosTable[i][6] = "X";

                res.next();
                i++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao exibir dados das Clinicas","Erro SQL",JOptionPane.ERROR_MESSAGE);
            System.out.println("OH NAO FALHA SQL");
        }
        return dadosTable;
    }
    //FEITO - PREENCHE A TABELA DE ESPECIALIDADES
    private Object[][] DadosTabelaEspec(){
        Object[][] dadosTable = null;
        try {
            Connection conexao = DriverManager.getConnection (url, user, senha);
            Statement selecionar = conexao.createStatement();

            //Descobrir o numero de linhas pra criar a tabela
            ResultSet count = selecionar.executeQuery("SELECT COUNT(*) AS 'total' FROM especialidade");
            count.next();
            int nLinhas = count.getInt("total");
            dadosTable = new Object[nLinhas][3]; 

            //Salvar os dados na variavel
            ResultSet res = selecionar.executeQuery("SELECT * FROM especialidade");

            res.next();

            int i = 0;
            while (i < nLinhas) {
                dadosTable[i][0] = res.getString("IDespecialidade");
                dadosTable[i][1] = res.getString("nomeespecialidade");
                dadosTable[i][2] = "X";
                res.next();
                i++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao exibir dados das Especialidades","Erro SQL",JOptionPane.ERROR_MESSAGE);
            System.out.println("OH NAO FALHA SQL");
        }
        return dadosTable;
    }
    //FEITO - PREENCHE A TABELA DE MEDICOS
    private Object[][] DadosTabelaMedicos(){  
        Object[][] dadosTable = null;
        try {
            Connection conexao = DriverManager.getConnection (url, user, senha);
            Statement selecionar = conexao.createStatement();

            //Descobrir o numero de linhas pra criar a tabela
            ResultSet count = selecionar.executeQuery("SELECT COUNT(*) AS 'total' FROM medico");
            count.next();
            int nLinhas = count.getInt("total");
            dadosTable = new Object[nLinhas][7]; 

            //Salvar os dados na variavel
            ResultSet res = selecionar.executeQuery("SELECT * FROM medico");

            res.next();

            int i = 0;
            while (i < nLinhas) {
                dadosTable[i][0] = res.getString("IDMedico");
                dadosTable[i][1] = res.getString("IDusuario");
                dadosTable[i][2] = res.getString("Nomemedico");
                dadosTable[i][3] = res.getString("CRM");
                dadosTable[i][4] = res.getString("IDClinica");
                dadosTable[i][5] = res.getString("IDespecialidade");
                dadosTable[i][6] = "X";

                res.next();
                i++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao exibir dados dos medicos","Erro SQL",JOptionPane.ERROR_MESSAGE);
            System.out.println("OH NAO FALHA SQL");
        }
        return dadosTable;
    }
    //FEITO - PREENCHE A TABELA DE PACIENTE
    private Object[][] DadosTabelaPacientes(){
        Object[][] dadosTable = null;
        try {
            Connection conexao = DriverManager.getConnection (url, user, senha);
            Statement selecionar = conexao.createStatement();

            //Descobrir o numero de linhas pra criar a tabela
            ResultSet count = selecionar.executeQuery("SELECT COUNT(*) AS 'total' FROM paciente");
            //bom que a Bruna deu aula sobre isso hoje, nao ia lembrar que existia e do outro jeito (com um loop) não tava funcionando
            count.next();
            int nLinhas = count.getInt("total");
            dadosTable = new Object[nLinhas][12]; 
            
            //Salvar os dados na variavel
            ResultSet res = selecionar.executeQuery("SELECT * FROM paciente");
            res.next();
            int i = 0;
            while (i < nLinhas) {
                dadosTable[i][0] = res.getString("IDpaciente");
                dadosTable[i][1] = res.getString("ID_usuario");
                dadosTable[i][2] = res.getString("Nomepaciente");
                dadosTable[i][3] = res.getString("DataNascimento");
                dadosTable[i][4] = res.getString("CPF");
                dadosTable[i][5] = res.getString("RG");
                dadosTable[i][6] = res.getString("Telefone");
                dadosTable[i][7] = res.getString("Email");
                dadosTable[i][8] = res.getString("Contato");
                dadosTable[i][9] = res.getString("TelefoneContato");
                dadosTable[i][10] = res.getString("Comentario");
                dadosTable[i][11] = "X";
                res.next();
                i++;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao exibir dados dos pacientes","Erro SQL",JOptionPane.ERROR_MESSAGE);
            System.out.println("OH NAO FALHA SQL");
        }
        return dadosTable;
    }
    //FEITO - VOLTA PRO INICIO
    private void jButton1GoToMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1GoToMenu
        this.dispose();
        Login i = new Login();
        i.setVisible(true);
    }//GEN-LAST:event_jButton1GoToMenu
    //FEITO - PERMITE EDITAR A TABELA DE USUARIOS
    private void TabelaUsuariosUpdate(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabelaUsuariosUpdate
        DefaultTableModel model = (DefaultTableModel) TabelaUsuarios.getModel();
        int selectedRowIndex = TabelaUsuarios.getSelectedRow();
        int selectedColumnIndex = TabelaUsuarios.getSelectedColumn();
        String IdMudado, valorMudado;
        int excluir = 2;
        
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
            } else if (selectedColumnIndex == 4){
                //Ele vai cair na funcao do clique, don't worry about it
            //Se não for nem ID, nem X, tenta/pode alterar (UPDATE)
            } else {
                //qual o novo valor digitado
                valorMudado = model.getValueAt(selectedRowIndex, selectedColumnIndex).toString();
                System.out.println("[valor mudado]" + valorMudado);
                   
                String ColunaSelecionada = null;
                switch(selectedColumnIndex){
                    case 1 -> ColunaSelecionada = "Email";
                    case 2 -> ColunaSelecionada = "Senha";
                    case 3 -> ColunaSelecionada = "Tipo_usuario";
                }
            
                try {
                    Connection conexao = DriverManager.getConnection (url, user, senha);
                    Statement atualizar = conexao.createStatement();

                    
                    System.out.println("[coluna selecionada]" + ColunaSelecionada);
                    
                    atualizar.execute("UPDATE usuario SET "+ ColunaSelecionada +" ='"+ valorMudado +"' WHERE idusuario = "+ IdMudado);
                    System.out.println("Usuario Atualizado com Sucesso");
                    //JOptionPane.showMessageDialog(null, ColunaSelecionada + " do Usuario " + IdMudado + " foi alterado","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Falha ao fazer update","Erro SQL",JOptionPane.ERROR_MESSAGE);
                    System.out.println("OH NAO FALHA SQL");
                }
            }
        }
        
    }//GEN-LAST:event_TabelaUsuariosUpdate
    //FEITO - FECHA E ABRE A LISTAGEM (REFRESH)
    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        //fechar e abrir mesmo kkkk
        this.dispose();
        QueryAll i = new QueryAll();
        i.setVisible(true);
    }//GEN-LAST:event_RefreshActionPerformed
    //FEITO - PERMITE DELETAR LINHAS DE USUARIOS
    private void TabelaUsuariosDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaUsuariosDelete
        DefaultTableModel model = (DefaultTableModel) TabelaUsuarios.getModel();
        int selectedRowIndex = TabelaUsuarios.getSelectedRow();
        int selectedColumnIndex = TabelaUsuarios.getSelectedColumn();
        String IdMudado;
        int excluir;
        
        //Qualquer clique vai cair o que, isso só impede de dar um exeption quando iniciar a primeira vez (em -1,-1)
        if(selectedRowIndex >=0 && selectedColumnIndex >= 0){
            
            //Se for um X tenta excluir (DELETE)
            if (selectedColumnIndex == 4){
                IdMudado = model.getValueAt(selectedRowIndex, 0).toString();
                excluir = JOptionPane.showConfirmDialog(null, "Excluir?");
                System.out.println(excluir);
                if(excluir == 0){
                    try{
                        Connection conexao = DriverManager.getConnection (url, user, senha);
                        Statement deletar = conexao.createStatement();
                        
                        System.out.println("[linha a ser excluida] " + IdMudado);
                        deletar.execute("DELETE FROM usuario WHERE idusuario = "+ IdMudado);
                        System.out.println("Usuario Deletado com Sucesso");
                        JOptionPane.showMessageDialog(null, "Usuario " + IdMudado + " foi excluido","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                        //se excluir, muda essa linha (temporariamente) pra '---' não altera ordem, nem dados, só pela aparencia mesmo
                        model.setValueAt("---", selectedRowIndex, 0);
                        model.setValueAt("---", selectedRowIndex, 1);
                        model.setValueAt("---", selectedRowIndex, 2);
                        model.setValueAt("---", selectedRowIndex, 3);
                        model.setValueAt("---", selectedRowIndex, 4);
                        
                    } catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Falha ao deletar","Erro SQL",JOptionPane.ERROR_MESSAGE);
                        System.out.println("OH NAO FALHA SQL");
                    }
                }
                

            } 
        }
    }//GEN-LAST:event_TabelaUsuariosDelete
    //FEITO - PERMITE EDITAR A TABELA DE CLINICAS
    private void TabelaClinicasUpdate(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabelaClinicasUpdate
        DefaultTableModel model = (DefaultTableModel) TabelaClinicas.getModel();
        int selectedRowIndex = TabelaClinicas.getSelectedRow();
        int selectedColumnIndex = TabelaClinicas.getSelectedColumn();
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
                    case 1 -> ColunaSelecionada = "NomeFantasia";
                    case 2 -> ColunaSelecionada = "Endereco";
                    case 3 -> ColunaSelecionada = "Numero";
                    case 4 -> ColunaSelecionada = "Cep";
                    case 5 -> ColunaSelecionada = "Razao_Social";
                }
            
                try {
                    Connection conexao = DriverManager.getConnection (url, user, senha);
                    Statement atualizar = conexao.createStatement();

                    
                    System.out.println("[coluna selecionada]" + ColunaSelecionada);
                    
                    atualizar.execute("UPDATE clinica SET "+ ColunaSelecionada +" ='"+ valorMudado +"' WHERE IDClinica = "+ IdMudado);
                    System.out.println("Usuario Atualizado com Sucesso");
                    //JOptionPane.showMessageDialog(null, ColunaSelecionada + " do Usuario " + IdMudado + " foi alterado","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Falha ao fazer update","Erro SQL",JOptionPane.ERROR_MESSAGE);
                    System.out.println("OH NAO FALHA SQL");
                }
            }
        }
    }//GEN-LAST:event_TabelaClinicasUpdate
    //FEITO - PERMITE DELETAR LINHAS DE ESPECIALIDADES
    private void TabelaEspecsDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaEspecsDelete
        DefaultTableModel model = (DefaultTableModel) TabelaEspecs.getModel();
        int selectedRowIndex = TabelaEspecs.getSelectedRow();
        int selectedColumnIndex = TabelaEspecs.getSelectedColumn();
        String IdMudado;
        int excluir;
        
        //Qualquer clique vai cair o que, isso só impede de dar um exeption quando iniciar a primeira vez (em -1,-1)
        if(selectedRowIndex >=0 && selectedColumnIndex >= 0){
            
            //Se for um X tenta excluir (DELETE)
            if (selectedColumnIndex == 2){
                IdMudado = model.getValueAt(selectedRowIndex, 0).toString();
                excluir = JOptionPane.showConfirmDialog(null, "Excluir?");
                System.out.println(excluir);
                if(excluir == 0){
                    try{
                        Connection conexao = DriverManager.getConnection (url, user, senha);
                        Statement deletar = conexao.createStatement();
                        
                        System.out.println("[linha a ser excluida] " + IdMudado);
                        deletar.execute("DELETE FROM especialidade WHERE IDespecialidade = "+ IdMudado);
                        System.out.println("Especialidade Deletada com Sucesso");
                        JOptionPane.showMessageDialog(null, "Especialidade " + IdMudado + " foi excluida","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                        //se excluir, muda essa linha (temporariamente) pra '---' não altera ordem, nem dados, só pela aparencia mesmo
                        model.setValueAt("---", selectedRowIndex, 0);
                        model.setValueAt("---", selectedRowIndex, 1);
                        model.setValueAt("---", selectedRowIndex, 2);
                        
                    } catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Falha ao deletar","Erro SQL",JOptionPane.ERROR_MESSAGE);
                        System.out.println("OH NAO FALHA SQL");
                    }
                }
                

            } 
        }
    }//GEN-LAST:event_TabelaEspecsDelete
    //FEITO - PERMITE EDITAR A TABELA DE ESPECIALIDADES
    private void TabelaEspecsUpdate(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabelaEspecsUpdate
        DefaultTableModel model = (DefaultTableModel) TabelaEspecs.getModel();
        int selectedRowIndex = TabelaEspecs.getSelectedRow();
        int selectedColumnIndex = TabelaEspecs.getSelectedColumn();
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
            } else if (selectedColumnIndex == 2){
                //Ele vai cair na funcao do clique, don't worry about it
            //Se não for nem ID, nem X, tenta/pode alterar (UPDATE)
            } else {
                //qual o novo valor digitado
                valorMudado = model.getValueAt(selectedRowIndex, selectedColumnIndex).toString();
                System.out.println("[valor mudado]" + valorMudado);
                   
                String ColunaSelecionada = null;
                switch(selectedColumnIndex){
                    case 1 -> ColunaSelecionada = "nomeespecialidade";
                }
            
                try {
                    Connection conexao = DriverManager.getConnection (url, user, senha);
                    Statement atualizar = conexao.createStatement();

                    
                    System.out.println("[coluna selecionada]" + ColunaSelecionada);
                    
                    atualizar.execute("UPDATE especialidade SET "+ ColunaSelecionada +" ='"+ valorMudado +"' WHERE IDespecialidade = "+ IdMudado);
                    System.out.println("Especialidade Atualizada com Sucesso");
                    //JOptionPane.showMessageDialog(null, ColunaSelecionada + " do Usuario " + IdMudado + " foi alterado","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Falha ao fazer update","Erro SQL",JOptionPane.ERROR_MESSAGE);
                    System.out.println("OH NAO FALHA SQL");
                }
            }
        }
    }//GEN-LAST:event_TabelaEspecsUpdate
    //FEITO - PERMITE EDITAR A TABELA DE MEDICOS
    private void TabelaMedicosUpdate(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabelaMedicosUpdate
        DefaultTableModel model = (DefaultTableModel) TabelaMedicos.getModel();
        int selectedRowIndex = TabelaMedicos.getSelectedRow();
        int selectedColumnIndex = TabelaMedicos.getSelectedColumn();
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
                    case 1 -> ColunaSelecionada = "IDusuario";
                    case 2 -> ColunaSelecionada = "Nomemedico";
                    case 3 -> ColunaSelecionada = "CRM";
                    case 4 -> ColunaSelecionada = "IDClinica";     
                    case 5 -> ColunaSelecionada = "IDespecialidade"; 
                }
            
                try {
                    Connection conexao = DriverManager.getConnection (url, user, senha);
                    Statement atualizar = conexao.createStatement();

                    
                    System.out.println("[coluna selecionada]" + ColunaSelecionada);
                    atualizar.execute("UPDATE medico SET "+ ColunaSelecionada +" ='"+ valorMudado +"' WHERE IDMedico = "+ IdMudado);
                    System.out.println("Medico Atualizado com Sucesso");
                    //JOptionPane.showMessageDialog(null, ColunaSelecionada + " do Usuario " + IdMudado + " foi alterado","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Falha ao fazer update","Erro SQL",JOptionPane.ERROR_MESSAGE);
                    System.out.println("OH NAO FALHA SQL");
                }
            }
        }
    }//GEN-LAST:event_TabelaMedicosUpdate
    //FEITO - PERMITE DELETAR LINHAS DE MEDICOS
    private void TabelaMedicosDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMedicosDelete
        DefaultTableModel model = (DefaultTableModel) TabelaMedicos.getModel();
        int selectedRowIndex = TabelaMedicos.getSelectedRow();
        int selectedColumnIndex = TabelaMedicos.getSelectedColumn();
        String IdMudado;
        int excluir = 2;
        
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
                        deletar.execute("DELETE FROM medico WHERE IDMedico = "+ IdMudado);
                        System.out.println("Medico Deletado com Sucesso");
                        JOptionPane.showMessageDialog(null, "Medico " + IdMudado + " foi excluido","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                        //se excluir, muda essa linha (temporariamente) pra '---' não altera ordem, nem dados, só pela aparencia mesmo
                        model.setValueAt("---", selectedRowIndex, 0);
                        model.setValueAt("---", selectedRowIndex, 1);
                        model.setValueAt("---", selectedRowIndex, 2);
                        model.setValueAt("---", selectedRowIndex, 3);
                        model.setValueAt("---", selectedRowIndex, 4);
                        model.setValueAt("---", selectedRowIndex, 5);                        
                    } catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Falha ao deletar","Erro SQL",JOptionPane.ERROR_MESSAGE);
                        System.out.println("OH NAO FALHA SQL");
                    }
                }
                

            } 
        }
    }//GEN-LAST:event_TabelaMedicosDelete
    //FEITO - PERMITE EDITAR A TABELA DE PACIENTES
    private void TabelaPacienteUpdate(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TabelaPacienteUpdate
        DefaultTableModel model = (DefaultTableModel) TabelaPaciente.getModel();
        int selectedRowIndex = TabelaPaciente.getSelectedRow();
        int selectedColumnIndex = TabelaPaciente.getSelectedColumn();
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
            } else if (selectedColumnIndex == 11){
                //Ele vai cair na funcao do clique, don't worry about it
            //Se não for nem ID, nem X, tenta/pode alterar (UPDATE)
            } else {
                //qual o novo valor digitado
                valorMudado = model.getValueAt(selectedRowIndex, selectedColumnIndex).toString();
                System.out.println("[valor mudado]" + valorMudado);

                String ColunaSelecionada = null;
                switch(selectedColumnIndex){
                    case 1 -> ColunaSelecionada = "IDpaciente";
                    case 2 -> ColunaSelecionada = "Id_usuario";
                    case 3 -> ColunaSelecionada = "Nomepaciente";
                    case 4 -> ColunaSelecionada = "CPF";     
                    case 5 -> ColunaSelecionada = "RG"; 
                    case 6 -> ColunaSelecionada = "Telefone";
                    case 7 -> ColunaSelecionada = "Email";
                    case 8 -> ColunaSelecionada = "Contato";     
                    case 9 -> ColunaSelecionada = "TelefoneContato"; 
                    case 10 -> ColunaSelecionada = "Comentario";                         
                }
                try {
                    Connection conexao = DriverManager.getConnection (url, user, senha);
                    Statement atualizar = conexao.createStatement();

                    
                    System.out.println("[coluna selecionada]" + ColunaSelecionada);
                    atualizar.execute("UPDATE paciente SET "+ ColunaSelecionada +" ='"+ valorMudado +"' WHERE IDpaciente = "+ IdMudado);
                    System.out.println("Paciente Atualizado com Sucesso");
                    //JOptionPane.showMessageDialog(null, ColunaSelecionada + " do Usuario " + IdMudado + " foi alterado","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Falha ao fazer update","Erro SQL",JOptionPane.ERROR_MESSAGE);
                    System.out.println("OH NAO FALHA SQL");
                }
            }
        }
    }//GEN-LAST:event_TabelaPacienteUpdate
    //FEITO - PERMITE DELETAR LINHAS DE PACIENTES
    private void TabelaPacienteDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaPacienteDelete
        DefaultTableModel model = (DefaultTableModel) TabelaPaciente.getModel();
        int selectedRowIndex = TabelaPaciente.getSelectedRow();
        int selectedColumnIndex = TabelaPaciente.getSelectedColumn();
        String IdMudado;
        int excluir;
        
        //Qualquer clique vai cair o que, isso só impede de dar um exeption quando iniciar a primeira vez (em -1,-1)
        if(selectedRowIndex >=0 && selectedColumnIndex >= 0){
            
            //Se for um X tenta excluir (DELETE)
            if (selectedColumnIndex == 11){
                IdMudado = model.getValueAt(selectedRowIndex, 0).toString();
                excluir = JOptionPane.showConfirmDialog(null, "Excluir?");
                System.out.println(excluir);
                if(excluir == 0){
                    try{
                        Connection conexao = DriverManager.getConnection (url, user, senha);
                        Statement deletar = conexao.createStatement();
                        
                        System.out.println("[linha a ser excluida] " + IdMudado);
                        deletar.execute("DELETE FROM paciente WHERE IDpaciente = "+ IdMudado);
                        System.out.println("Paciente Deletado com Sucesso");
                        JOptionPane.showMessageDialog(null, "Paciente " + IdMudado + " foi excluido","Sucesso",JOptionPane.INFORMATION_MESSAGE);

                        //se excluir, muda essa linha (temporariamente) pra '---' não altera ordem, nem dados, só pela aparencia mesmo
                        model.setValueAt("---", selectedRowIndex, 0);
                        model.setValueAt("---", selectedRowIndex, 1);
                        model.setValueAt("---", selectedRowIndex, 2);
                        model.setValueAt("---", selectedRowIndex, 3);
                        model.setValueAt("---", selectedRowIndex, 4);
                        model.setValueAt("---", selectedRowIndex, 5);      
                        model.setValueAt("---", selectedRowIndex, 6);
                        model.setValueAt("---", selectedRowIndex, 7);
                        model.setValueAt("---", selectedRowIndex, 8);
                        model.setValueAt("---", selectedRowIndex, 9);
                        model.setValueAt("---", selectedRowIndex, 10); 
                        model.setValueAt("---", selectedRowIndex, 11);                         
                        
                    } catch(SQLException e){
                        JOptionPane.showMessageDialog(null, "Falha ao deletar","Erro SQL",JOptionPane.ERROR_MESSAGE);
                        System.out.println("OH NAO FALHA SQL");
                    }
                }
                

            } 
        }
    }//GEN-LAST:event_TabelaPacienteDelete
    //FEITO - PERMITE DELETAR LINHAS DE CLINICAS
    private void TabelaClinicasDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaClinicasDelete
        DefaultTableModel model = (DefaultTableModel) TabelaClinicas.getModel();
        int selectedRowIndex = TabelaClinicas.getSelectedRow();
        int selectedColumnIndex = TabelaClinicas.getSelectedColumn();
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
                        deletar.execute("DELETE FROM clinica WHERE IDClinica = "+ IdMudado);
                        System.out.println("Clinica Deletada com Sucesso");
                        JOptionPane.showMessageDialog(null, "Clinica " + IdMudado + " foi excluida","Sucesso",JOptionPane.INFORMATION_MESSAGE);

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
    }//GEN-LAST:event_TabelaClinicasDelete

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
            java.util.logging.Logger.getLogger(QueryAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueryAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueryAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueryAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>   
                      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueryAll().setVisible(true);
            }
        });
   
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Refresh;
    private javax.swing.JTable TabelaClinicas;
    private javax.swing.JTable TabelaEspecs;
    private javax.swing.JTable TabelaMedicos;
    private javax.swing.JTable TabelaPaciente;
    private javax.swing.JTable TabelaUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}