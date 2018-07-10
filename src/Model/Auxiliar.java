/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalTime;

/**
 *
 * @author jonh_
 */
public class Auxiliar {
    private String nomeCliente, nomeAviao, rg_cliente,cod_avi, destino, origem;
    private int id_voo, qtdA;
    LocalTime horarioVenda, horarioVoo;

    public Auxiliar(String nomeAviao, String cod_avi, String destino, String origem, int id_voo, int qtdA, LocalTime horarioVoo) {
        this.nomeAviao = nomeAviao;
        this.cod_avi = cod_avi;
        this.destino = destino;
        this.origem = origem;
        this.id_voo = id_voo;
        this.qtdA = qtdA;
        this.horarioVoo = horarioVoo;
    }
//    public Auxiliar(String nomeCliente, String nomeAviao, String rg_cliente, String cod_avi, String destino, String origem, int id_voo, int qtdA, LocalTime horarioVenda, LocalTime horarioVoo) {
//        this.nomeCliente = nomeCliente;
//        this.nomeAviao = nomeAviao;
//        this.rg_cliente = rg_cliente;
//        this.cod_avi = cod_avi;
//        this.destino = destino;
//        this.origem = origem;
//        this.id_voo = id_voo;
//        this.qtdA = qtdA;
//        this.horarioVenda = horarioVenda;
//        this.horarioVoo = horarioVoo;
//    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeAviao() {
        return nomeAviao;
    }

    public String getRg_cliente() {
        return rg_cliente;
    }

    public String getCod_avi() {
        return cod_avi;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }

    public int getId_voo() {
        return id_voo;
    }

    public int getQtdA() {
        return qtdA;
    }

    public LocalTime getHorarioVenda() {
        return horarioVenda;
    }

    public LocalTime getHorarioVoo() {
        return horarioVoo;
    }




}