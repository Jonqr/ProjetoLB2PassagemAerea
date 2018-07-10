/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Aviao;
import java.util.List;

/**
 *
 * @author jonh_
 */
public interface AviaoDao {
    public boolean salvar(Aviao aviao);
    public boolean deletar(Aviao aviao);
    public void atualizar(Aviao aviao);
    public List<Aviao> listar();
    public Aviao procurarPorCodigo(String cod);
    public Aviao procurarPorNome(String nome);
}
