import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;
import db.DbException;
import models.Tarefa;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("SISTEMA DE GERENCIAMENTO DE TAREFAS");
        int op = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            
            conn = DB.gConnection();
            st = conn.createStatement();
            
            createTable(st);
            do {
                System.out.println("\n");
                System.out.println("SELECIONE O QUE DESEJA: ");
                System.out.println("1 - CADASTRAR");
                System.out.println("2 - LISTAR");
                System.out.println("3 - ATUALIZAR");
                System.out.println("4 - APAGAR");
                System.out.println("0 - SAIR");
                op = sc.nextInt();
                sc.nextLine();
                switch(op) {
                    case 1:
                    create(sc, st);
                    break;
                    case 2:
                    rs = read(st);
                    break;
                    case 3:
                    rs = read(st);
                    update(sc, st);        
                    break;
                    case 4:
                    rs = read(st);
                    delete(sc, st);
                    break;
                    default:
                    break;
                }
                
            } while (op != 0);
        } 
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
            sc.close();
        }
    }

    private static void delete(Scanner sc, Statement st) throws SQLException {
        System.out.print("Selecione o ID da tarefa que deseja excluir");
        int id = sc.nextInt();
        sc.nextLine();
        String query = "DELETE FROM tb_tarefas WHERE id = "+id+";";
        st.executeUpdate(query);
        System.out.println("\nDeletado com sucesso!!!\n");
    }

    private static void update(Scanner sc, Statement st) throws SQLException {
        System.out.print("SELECIONE O ID QUE DESEJA ATUALIZAR: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("");
        System.out.print("Insirar o nome da nova tarefa: ");
        String nome = sc.nextLine();
        System.out.print("Insirar a descricao da nova tarefa: ");
        String descricao = sc.nextLine();
        System.out.print("Tarefa tá concluída? SIM/NÃO: ");
        String aux = sc.nextLine();
        boolean isConcluido = false;
        if (aux.toLowerCase().charAt(0) == 's') {
            isConcluido = true;
        } else {
            isConcluido = false;
        }

        String query = "UPDATE tb_tarefas SET"+
                        " nome = '"+nome+"', "+
                        " descricao = '"+descricao+"', "+
                        " is_concluido = '"+isConcluido+"' "+
                        "WHERE id = "+id+";";
        st.executeUpdate(query);
        System.out.println("\nAtualizado com sucesso!!!\n");
    }
    
    private static ResultSet read(Statement st) throws SQLException {
        ResultSet rs;
        rs = st.executeQuery("SELECT * FROM tb_tarefas;");
        while(rs.next()) {
            System.out.println("------------------------------");
            System.out.println("ID: "+rs.getInt("id"));
            System.out.println("Nome: "+rs.getString("nome"));
            System.out.println("Descrição: "+rs.getString("descricao"));
            if (rs.getBoolean("is_concluido") == true) {
                System.out.println("Concluído? SIM");
            } else {
                System.out.println("Concluído? NÃO");
            }
            System.out.println("------------------------------");
        }
        return rs;
    }
    
    private static void create(Scanner sc, Statement st) throws SQLException {
        System.out.println("");
        System.out.print("Insirar o nome da tarefa: ");
        String nome = sc.nextLine();
        System.out.print("Insirar a descricao da tarefa: ");
        String descricao = sc.nextLine();
        System.out.print("Tarefa tá concluída? SIM/NÃO: ");
        String aux = sc.nextLine();
        boolean isConcluido = false;
        if (aux.toLowerCase().charAt(0) == 's') {
            isConcluido = true;
        } else {
            isConcluido = false;
        }
        
        String query = "INSERT INTO tb_tarefas (nome, descricao, is_concluido) "+
        "VALUES ("+
        "'"+nome+"', "+
        "'"+descricao+"', "+
        "'"+isConcluido+"'"+
        ");";
        st.executeUpdate(query);
        System.out.println("\nCriado com sucesso!!!\n");
    }
    
    private static void createTable(Statement st) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS tb_tarefas ("+
        "id INTEGER PRIMARY KEY AUTO_INCREMENT, "+
        "nome VARCHAR(50) NOT NULL, "+
        "descricao VARCHAR(150) NOT NULL, "+
        "is_concluido BOOLEAN NOT NULL"+
        ");";
        st.execute(query);
    }
}
