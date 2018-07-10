/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente;
import java.util.List;

/**
 *
 * @author jonh_
 */
public interface ClienteDao {
    public boolean salvar(Cliente cliente);
    public boolean deletar(Cliente cliente);
    public void atualizar(Cliente cliente);
    public List<Cliente> listar();
    public Cliente procurarPorRg(String rg);
    public List<Cliente> listarPorNome(String nome);
}
