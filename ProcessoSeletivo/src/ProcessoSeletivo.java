import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProcessoSeletivo {
    public static void main(String[] args) {
        ArrayList<String> canditatosSelecionados = selecaoCandidato();
        imprimirCandidatos(canditatosSelecionados);
        ligarCandidatos(canditatosSelecionados);

    }

    static void ligarCandidatos(ArrayList<String> candidatos){
        boolean flag = false;
        for (String n: candidatos){
            for(int i=0; i<3; i++){
                if(tentaLigar()){
                    System.out.println("Conseguimos contato com o canditado "+n+" após tentativa "+(i+1));
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println("Nao coseguimos contato com o candidato "+ n);
            }
            flag = false;
        }
    }

    static boolean tentaLigar(){
        return ThreadLocalRandom.current().nextBoolean();
    }

    static void imprimirCandidatos(ArrayList<String> candidatos){
        for (String n: candidatos){
            System.out.println(n);
        }
    }

    static ArrayList<String> selecaoCandidato(){
        String [] candidatos = {"S","V","B","D","E","R","XZ","EX","VC","L","U","B","J","GF","A","Q","X","H"};
        ArrayList<String> canditatosSelecionados = new ArrayList<>();
        int qtdCanditadoSelecionado = 0;
        int canditadoAtual = 0;
        double salarioBase = 2000.0;

        while(qtdCanditadoSelecionado < 5 && canditadoAtual < candidatos.length){
            String candidato = candidatos[canditadoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("canditado: "+ candidato);
            System.out.println("salario pretendido: "+ salarioPretendido);

            if (salarioPretendido<=salarioBase) {
                qtdCanditadoSelecionado++;
                System.out.println("Candidato selecionado");
                canditatosSelecionados.add(candidato);
            }else{
                System.out.println("Seu curriculo ficará no sistema");
            }

            canditadoAtual++;
        }
        return canditatosSelecionados;
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCadidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase==salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }

    }
}