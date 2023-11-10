package model;
import java.sql.DriverManager; // Driver para abrir Conexão
import java.sql.SQLException; // Tratamento de Erros SQL
import java.sql.Connection; // Armazena a Conexão Aberta
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ConectarDao {
    public  Connection con = null;
    public String       sql = null;
    PreparedStatement ps = null;

    public ConectarDao () {
        String strcon = "jdbc:mysql://localhost:3306/projcad";//cria a string de conexão ao servidor xaamp 
        try {

            con = DriverManager.getConnection(strcon, "root", "");
            criarBanco();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Conexão com Mysql não realizada!\n" + ex);
        }
    }


public void criarBanco() {
    
try { sql = "CREATE TABLE IF NOT EXISTS NIVEIS (idNivel int not null,"
+ "dsNivel varchar(20) not null, "
+ "primary key(idNivel) ) ";
ps = con.prepareStatement(sql); // prepara o objeto que irá executar o comando SQL
ps.execute(); // Executa o comando SQL

sql = "CREATE TABLE IF NOT EXISTS USUARIOS ("
+ "cpf varchar(12) not null ,"
+ "nome varchar(50) not null ,"
+ "email varchar(50) not null ,"
+ "celular varchar(20) not null ,"
+ "idNivel int not null, "
+ "endereco varchar(50) not null,"
+ "senha varchar(6) not null, "
+ "primary key (cpf) )";
ps = con.prepareStatement(sql); // prepara o objeto que irá executar o comando SQL
ps.execute(); // Executa o comando SQL

sql = "CREATE TABLE IF NOT EXISTS SABOR ("
+ "calabresa int(99) not null ,"
+ "muzzarela int(99) not null )";
ps = con.prepareStatement(sql); // prepara o objeto que irá executar o comando SQL
ps.execute(); // Executa o comando SQL


sql = "CREATE TABLE IF NOT EXISTS ENTREGADOR ("
+ "id int(99) not null ,"
+ "nome varchar(99) not null ,"
+ "numero varchar(15) not null )";
ps = con.prepareStatement(sql); // prepara o objeto que irá executar o comando SQL
ps.execute(); // Executa o comando SQL

sql = "CREATE TABLE IF NOT EXISTS PEDIDO ("
+ "id int(99) not null ,"
+ "pizza varchar(99) not null ,"
+ "endereco varchar(15) not null )"        ;
ps = con.prepareStatement(sql); // prepara o objeto que irá executar o comando SQL
ps.execute(); // Executa o comando SQL

} catch (SQLException err) {
JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados " + err.getMessage() );
}
}   
}