package rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class RPG {

    static ArrayList<Arma> armas = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Personagem> personagens = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
      
         
        criarArmas();

        while (true) {
            System.out.println("Deseja criar um personagem? \n1-Sim\n2-Não");
            int opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Selecione a sua arma");
                    int cont=0;
                    //Percorre a lista com todas as armas e busca apenas as que são do tipo primaria
                    for (Arma indice : armas) {
                        if (indice.getPosicaoArma().equals("primaria")) {
                            cont++;
                            System.out.println(cont+ " " + indice);
                        }
                    }
                    //Selecionar a arma
                    int indiceArma = scan.nextInt();
                    System.out.println("Teste:"+armas.get(indiceArma));
                    Arma a = new Arma(armas.get(indiceArma).getAtaqueDefesa(), armas.get(indiceArma).getPeso(), armas.get(indiceArma).getTipo(),  armas.get(indiceArma).getPosicaoArma());
                    
                    //Cria um personagem
                    System.out.println("Crie o seu personagem:");
                    String nome = scan.next();
                    String descricao = scan.next();
                    int idade = scan.nextInt();
                    Personagem p = new Personagem(nome, descricao, idade, a);
                    //adiciona na lista após cria-lo
                    personagens.add(p);
                    break;
                case 2:
                    //Mostra todos os personagens criados.
                    for (Personagem indice : personagens) {
                        System.out.println("Memoria:" + indice.getNome() + "arma: "+ indice.getArmaPrimaria());
                    }
            }
        }

        // Personagem p = new Personagem("Legolas", "Arqueiro elfo", 512, a);
        //p.preencherAtributos();
        // System.out.println(p.toString());
        // Arma a2 = new Arma(23, 2, "Viola Encantada", "primaria");
        //Personagem p2 = new Personagem("Leonardo", "ferreiro anão e bardo", 123, a2);
    }

    public static void criarArmas() {
        Arma a = new Arma(10, 7, "Machado", "primaria");
        armas.add(a);
        Arma a2 = new Arma(10, 7, "Machado", "secundario");
        armas.add(a2);
        Arma a3 = new Arma(10, 7, "Espada longa", "primaria");
        armas.add(a3);
        Arma a4 = new Arma(10, 7, "Adaga", "secundaria");
        armas.add(a4);
        Arma a5 = new Arma(10, 7, "Escudo", "secundaria");
        armas.add(a5);
        Arma a6 = new Arma(10, 7, "Martelo", "primaria");
        armas.add(a6);
        Arma a7 = new Arma(10, 7, "Arco e Flecha", "primaria");
        armas.add(a7);
        Arma a8 = new Arma(10, 7, "Cetro", "primaria");
        armas.add(a8);
    }

}
