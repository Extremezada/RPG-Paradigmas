/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class Personagem {
    private String nome, descricao;
    private int nivel, idade, forca, vitalidade, destreza, poder;
    private Arma armaPrimaria, armaSecundaria;
    private ArrayList<Habilidade> habilidades;
    
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
    }
    
    public void definirArmaPersonagem(Arma arma){
        if(arma.getPosicaoArma().equalsIgnoreCase("primaria")){
            this.armaPrimaria = arma;
        }else{
            this.armaSecundaria = arma;
        }
    }
    
    public void preencherAtributos(){
        Scanner scan = new Scanner(System.in);
        
        this.forca = preencherUmAtributo("Força: ", scan);
        this.destreza = preencherUmAtributo("Destreza: ", scan);
        this.poder = preencherUmAtributo("Poder: ", scan);
        this.vitalidade = preencherUmAtributo("vitalidade: ", scan);
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
    
    public void inserirHabilidade(Habilidade habilidade){
        this.habilidades.add(habilidade);
    
        
}

    @Override
    public String toString() {
        return "Personagem{" + "nome=" + nome + ", descricao=" + descricao + ", nivel=" + nivel + ", idade=" + idade + ", forca=" + forca + ", vitalidade=" + vitalidade + ", destreza=" + destreza + ", poder=" + poder + ", armaPrimaria=" + armaPrimaria.getTipo() + ", armaSecundaria=" + armaSecundaria + ", habilidades=" + habilidades + '}';
    }
}