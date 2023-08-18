import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;
import models.Tarefa;

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
                    Tarefa tarefa = new Tarefa(null, nome, descricao, isConcluido);


                    
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
