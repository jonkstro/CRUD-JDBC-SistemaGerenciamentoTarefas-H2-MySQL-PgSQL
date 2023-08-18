import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("SISTEMA DE GERENCIAMENTO DE TAREFAS");
        int op = 0;
        Connection conn = null;
        Statement st = null;
        do {
            conn = DB.gConnection();
            st = conn.createStatement();
            
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

                break;
                case 2:
                
                break;
                case 3:
                
                break;
                case 4:
                
                break;
                default:
                break;
            }
        } while (op != 0);
        sc.close();
    }
}
