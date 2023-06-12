package rpg;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Personagem {
    private String nome, descricao;
    private static int nivel;
    private int idade;
    private int forca;
    private int vitalidade;
    private int destreza;
    private int poder;
    private static int experiencia;
    private static int pontosAtributo;
    private static Arma armaPrimaria;
    private static Arma armaSecundaria;
    private static ArrayList<Arma> inventarioArmas;
    private static final ArrayList<Habilidade> habilidades = new ArrayList<>();
    public Personagem(String nome, String descricao, int idade, Arma arma){
        this.nome = nome;
        this.descricao = descricao;
        this.idade = idade;
        definirArmaPersonagem(arma);
        this.nivel = 1;
        this.forca = 1;
        this.vitalidade = 1;
        this.destreza = 1;
        this.poder =1;
        this.pontosAtributo = 0;
        this.experiencia = 0;
        inventarioArmas = new ArrayList<>();
        inventarioArmas.add(arma);
        armaPrimaria = arma;
        armaSecundaria = null;
    }

    public void definirArmaPersonagem(Arma arma){
        if(arma.getPosicaoArma().equalsIgnoreCase("primaria")){
            this.armaPrimaria = arma;
        }else{
            this.armaSecundaria = arma;
        }
    }
    public static void adicionarArma(Arma arma) {
        inventarioArmas.add(arma);
    }
    public static void selecionarArmaPrimaria(int indice) {
        if (indice >= 0 && indice < inventarioArmas.size()) {
            armaPrimaria = inventarioArmas.get(indice);
        } else {
            System.out.println("Índice inválido!");
        }
    }
    public static void selecionarArmaSecundaria(int indice) {
        if (indice >= 0 && indice < inventarioArmas.size()) {
            armaSecundaria = inventarioArmas.get(indice);
        } else {
            System.out.println("Índice inválido!");
        }
    }
    public void preencherAtributos(){
        Scanner scan = new Scanner(System.in);
        int pontosRestantes = 10;
        int pontosAtribuidos = 0;

        while(pontosRestantes > 0){
            System.out.println("Pontos Restantes: " + pontosRestantes);
            System.out.println("Escolha um atributo para adicionar pontos: ");
            System.out.println("1 - Forca");
            System.out.println("2 - Destreza");
            System.out.println("3 - Poder");
            System.out.println("4 - Vitalidade");

            int opcao = scan.nextInt();
            switch(opcao){
                case 1:
                    pontosAtribuidos = preencherUmAtributo("ForÃ§a", scan, pontosRestantes);
                    forca += pontosAtribuidos;
                    break;

                case 2:
                    pontosAtribuidos = preencherUmAtributo("Destreza", scan, pontosRestantes);
                    destreza += pontosAtribuidos;
                    break;

                case 3:
                    pontosAtribuidos = preencherUmAtributo("Poder", scan, pontosRestantes);
                    poder += pontosAtribuidos;
                    break;

                case 4:
                    pontosAtribuidos = preencherUmAtributo("Vitalidade", scan, pontosRestantes);
                    destreza += vitalidade;
                    break;

                default:
                    System.out.println("Digite uma opcao valida!");
                    break;

            }
            pontosRestantes -= pontosAtribuidos;
        }

    }


    private int preencherUmAtributo(String atributo, Scanner scan, int pontosRestantes) {
        while (true) {
            System.out.println("Digite o valor para o atributo " + atributo + ": ");
            int valor = scan.nextInt();

            if (valor >= 1 && valor <= pontosRestantes) {
                return valor;
            } else {
                System.out.println("O valor do atributo deve ser entre 1 e " + pontosRestantes);
            }
        }
    }
    private int preencherUmAtributo(String atributo, Scanner scan){
        while(true){
            System.out.println("Digite o valor para o atributo "+ atributo + ": ");
            int valor = scan.nextInt();
            if(valor > 0 && valor <=10){
                return valor;
            }else{
                System.out.println("O valor do atributo deve ser entre 1 e 10");
            }
        }
    }

    public static void batalhar(){
        Random random = new Random();
        int qntXP = random.nextInt(1000) + 1;

        experiencia += qntXP;

        int xpLimite = upar();

        if (experiencia >= xpLimite) {
            subirDeNivel();
        }
        System.out.println("Você recebeu " + qntXP + " XP!");
    }
    private static int upar() {
        return (nivel - 1) * 3000 + 1000;
    }

    private static void subirDeNivel() {
        nivel++;
        pontosAtributo++;
        System.out.println("Up, você evoluiu para o nível " + nivel + "!");
    }
    public static void exibirInventarioArmas() {
        System.out.println("----- INVENTÁRIO DE ARMAS -----");
        for (int i = 0; i < inventarioArmas.size(); i++) {
            Arma arma = inventarioArmas.get(i);
            System.out.println("Índice: " + i+1 + ", Arma: " + arma);
        }
    }
    //get nome, como fazeR?
    //PRIVACIDADE   TipoDeRetorno   NomeMetodo  (TipoDado PARAMETRO1, TipoDado PARAMETRO2)
    public String getNome(){
        return this.nome;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public int getNivel(){
        return this.nivel;
    }
    public int getIdade(){
        return this.forca;
    }
    public int getVitalidade(){
        return this.vitalidade;
    }
    public int getDestreza(){
        return this.destreza;
    }
    public int getPoder(){
        return this.poder;
    }

    public Arma getArmaPrimaria(){
        return this.armaPrimaria;
    }

    public Arma getArmaSecundaria(){
        return this.armaSecundaria;
    }

    public ArrayList<Habilidade> getHabilidades(){
        return this.habilidades;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    //nivel, idade, forca, vitalidade, destreza, poder
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public void setForca(int forca){
        this.forca = forca;
    }
    public void setVitalidade(int vitalidade){
        this.vitalidade = vitalidade;
    }
    public void setDestreza(int destreza){
        this.destreza = destreza;
    }
    public void setPoder(int poder){
        this.poder = poder;
    }

    public void setArmaPrimaria(Arma armaPrimaria){
        this.armaPrimaria = armaPrimaria;
    }
    public void setArmaSecundaria(Arma armaSecundaria){
        this.armaSecundaria = armaSecundaria;
    }
    public int getXp() {
        return experiencia;
    }

    public int getPontosAtributo() {
        return pontosAtributo;
    }

    public void inserirHabilidade(Habilidade habilidade){
        this.habilidades.add(habilidade);
    }

    //Adicionar habilidade
    public void adicionarHabilidadeEspecial() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome da habilidade especial: ");
        String nome = scan.nextLine();
        System.out.print("Digite a descriaoo da habilidade especial: ");
        String descricao = scan.nextLine();
        System.out.print("Digite o poder minimo da habilidade especial: ");
        int poderMinimo = scan.nextInt();
        System.out.println("Digite o tipo do atributo: ");
        String tipoAtributo = scan.nextLine();

        Habilidade habilidade = new Habilidade(nome, descricao, poderMinimo, tipoAtributo);
        habilidades.add(habilidade);
        System.out.println("Habilidade especial adicionada com sucesso!");
    }


    //Visualizar informações do Personagem
    public void exibirInformacoes(){
        System.out.println("-------- INFORMACOES DO PERSONAGEM --------");
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Idade: " + idade);
        System.out.println("Nivel: " + nivel);
        System.out.println("===== ATRIBUTOS =====");
        System.out.println("Forca: " + forca);
        System.out.println("Destreza: " + destreza);
        System.out.println("Vitalidade: " + vitalidade);
        System.out.println("Poder: " + poder);
        System.out.println("===== ARMAS =====");
        System.out.println("Arma primaria: " + armaPrimaria);
        System.out.println("Arma secundaria: " + armaSecundaria);
        System.out.println("===== HABILIDADES =====");
        for (Habilidade habilidade : habilidades) {
            System.out.println("Nome: " + habilidade.getNome());
            System.out.println("Descricao: " + habilidade.getDescricao());
            System.out.println("Poder Minimo: " + habilidade.getPoderMinimo());
            System.out.println("Tipo de Atributo: " + habilidade.getTipoAtributo());
            System.out.println("---------------------");
        }
    }


    @Override
    public String toString() {
        return "Personagem{" + "nome=" + nome + ", descricao=" + descricao + ", nivel=" + nivel + ", idade=" + idade + ", forca=" + forca + ", vitalidade=" + vitalidade + ", destreza=" + destreza + ", poder=" + poder + ", armaPrimaria=" + armaPrimaria.getTipo() + ", armaSecundaria=" + armaSecundaria + ", habilidades=" + habilidades + '}';
    }
}