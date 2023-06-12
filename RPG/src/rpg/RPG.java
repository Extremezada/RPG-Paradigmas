package rpg;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class RPG {

    static ArrayList<Arma> armas = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Personagem> personagens = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        criarArmas();

        while (true) {
            System.out.println("----------- RPG -----------");
            System.out.println("1 - Criar um Personagem");
            System.out.println("2 - Visualizar Personagens Criados");
            System.out.println("3 - Preencher Atributos");
            System.out.println("4 - Preencher Habilidades Especiais");
            System.out.println("5 - Vamos batalhar?");
            System.out.println("6 - Ver inventário");

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
                    System.out.println("Você escolheu a"+armas.get(indiceArma) + " como arma.");
                    Arma a = new Arma(armas.get(indiceArma).getAtaqueDefesa(), armas.get(indiceArma).getPeso(), armas.get(indiceArma).getTipo(),  armas.get(indiceArma).getPosicaoArma());
                    //Cria um personagem
                    System.out.println("Crie o seu personagem..");
                    System.out.println("Nome do seu personagem:");
                    String nome = scan.next();
                    System.out.println("Descricao do seu personagem:");
                    String descricao = scan.next();
                    System.out.println("Idade do seu personagem:");
                    int idade = scan.nextInt();
                    Personagem p = new Personagem(nome, descricao, idade, a);
                    //adiciona na lista após cria-lo
                    personagens.add(p);
                    System.out.println("O grande "+ descricao +" "+ nome +" foi criado com sucesso!");
                    break;

                //Mostra informações do personagem
                case 2:
                    System.out.println("Digite o nome do personagem que deseja visuzalizar: ");
                    String nomePersonagem = scan.next();

                    boolean encontrado = false;

                    for (Personagem personagem : personagens){
                        if(personagem.getNome().equalsIgnoreCase(nomePersonagem)){
                            personagem.exibirInformacoes();
                            encontrado = true;
                            break;
                        }
                    }
                    if(!encontrado){
                        System.out.println("Personagem nao encontrado!");
                    }
                    break;

                //Preenche os Atributos
                case 3:
                    System.out.print("Digite o indice do personagem que deseja preencher os atributos: ");
                    int indicePersonagem = scan.nextInt();

                    if (indicePersonagem >= 0 && indicePersonagem < personagens.size()) {
                        Personagem personagemSelecionado = personagens.get(indicePersonagem);
                        personagemSelecionado.preencherAtributos();
                        System.out.println("Atributos preenchidos com sucesso!");
                    } else {
                        System.out.println("Índice de personagem inválido!");
                    }
                    break;

                //Adicionar Habilidade Especial
                case 4:
                    System.out.print("Digite o indice do personagem ao qual deseja adicionar a habilidade especial: ");
                    indicePersonagem = scan.nextInt();

                    if (indicePersonagem >= 0 && indicePersonagem < personagens.size()) {
                        Personagem personagemSelecionado = personagens.get(indicePersonagem);
                        personagemSelecionado.adicionarHabilidadeEspecial();
                    } else {
                        System.out.println("Índice de personagem invalido!");
                    }
                    break;
                // Acionar sistema de ganhar XP
                case 5:
                    int caraCoroa = random.nextInt(3);
                    System.out.println("Escolha um numero entre 1 e 2:");
                    if(scan.nextInt() == caraCoroa){
                        Personagem.batalhar();
                    }
                    else{
                        System.out.println("Você perdeu!");
                    }
                case 6:
                    int opcaoInventario = 0;
                    while(opcaoInventario != 3){
                        Personagem.exibirInventarioArmas();
                        System.out.println("O que deseja fazer?");
                        System.out.println("1 - Escolher arma primaria.");
                        System.out.println("2 - Escolher arma secundaria");
                        System.out.println("3 - Sair");
                        opcaoInventario = scan.nextInt();
                        switch (opcaoInventario){
                            case 1:
                                System.out.println("Qual o indice da arma primária que voce deseja escolher?");
                                int opcaoInventario1 = scan.nextInt();
                                if (opcaoInventario1 < armas.size()) {
                                    Personagem.selecionarArmaPrimaria(opcaoInventario1);
                                }
                                else {
                                    System.out.println("Índice invalido!");
                                }
                                break;
                            case 2:
                                System.out.println("Qual o indice da arma secundária que voce deseja escolher?");
                                int opcaoInventario2 = scan.nextInt();
                                if (opcaoInventario2 < armas.size()) {
                                    Personagem.selecionarArmaSecundaria(opcaoInventario2);
                                } else {
                                    System.out.println("Índice invalido!");
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Você escolheu uma opção inválida.");
                                break;
                        }
                    }
            }
        }
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
