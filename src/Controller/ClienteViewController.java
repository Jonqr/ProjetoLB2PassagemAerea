/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ClienteDao;
import DaoBD.ClienteDaoBD;
import Form.Cliente_Form;
import Form.Menu_Principal;
import Model.Cliente;
import Util.StringUtils;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jonh_
 */
public class ClienteViewController implements Initializable {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    
    @FXML private Button btVoltar;

    //  TABLE
    @FXML private Button btCliente_Table_Atualiza;
    @FXML private TableView<Cliente> tabelaClientes;    
    @FXML private TableColumn<Cliente, String> ColunaNome;
    @FXML private TableColumn<Cliente, String> ColunaRG;
    @FXML private TableColumn<Cliente, String> ColunaTelefone;
    
    //DELETE
    @FXML private Label Text_Delete_Nome;
    @FXML private Label Text_Delete_RG;
    @FXML private Label Text_Delete_Telefone;
    @FXML private Button bt_Deletar_Cliente;
    @FXML private CheckBox checkBoxDelete;
    @FXML private Label notifica_Deleta;
    @FXML private TextField input_DL_Cliente_RG;
    
    //UPDATE
    @FXML private Label notifica_Atualiza;
    @FXML private Button bt_Atualiza_Cliente;    
    @FXML private TextField input_AT_Cliente_BUSCA;
    @FXML private TextField input_AT_Cliente_Nome;
    @FXML private TextField input_AT_Cliente_RG;
    @FXML private TextField input_AT_Cliente_Telefone;
    
    //INSERT
    @FXML private TextField input_CD_Cliente_Nome;
    @FXML private TextField input_CD_Cliente_RG;
    @FXML private TextField input_CD_Cliente_Telefone;
    @FXML private Label notifica_Cadastro;
    @FXML private Button bt_Cadastrar;
    
    @FXML
    void initialize() {
        assert ColunaNome != null : "fx:id=\"ColunaNome\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert ColunaRG != null : "fx:id=\"ColunaRG\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert ColunaTelefone != null : "fx:id=\"ColunaTelefone\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert Text_Delete_Nome != null : "fx:id=\"Text_Delete_Nome\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert Text_Delete_RG != null : "fx:id=\"Text_Delete_RG\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert Text_Delete_Telefone != null : "fx:id=\"Text_Delete_Telefone\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert btCliente_Table_Atualiza != null : "fx:id=\"btCliente_Table_Atualiza\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert btVoltar != null : "fx:id=\"btVoltar\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert bt_Atualiza_Cliente != null : "fx:id=\"bt_Atualiza_Cliente\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert bt_Cadastrar != null : "fx:id=\"bt_Cadastrar\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert bt_Deletar_Cliente != null : "fx:id=\"bt_Deletar_Cliente\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert checkBoxDelete != null : "fx:id=\"checkBoxDelete\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert input_AT_Cliente_BUSCA != null : "fx:id=\"input_AT_Cliente_BUSCA\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert input_AT_Cliente_Nome != null : "fx:id=\"input_AT_Cliente_Nome\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert input_AT_Cliente_RG != null : "fx:id=\"input_AT_Cliente_RG\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert input_AT_Cliente_Telefone != null : "fx:id=\"input_AT_Cliente_Telefone\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert input_CD_Cliente_Nome != null : "fx:id=\"input_CD_Cliente_Nome\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert input_CD_Cliente_RG != null : "fx:id=\"input_CD_Cliente_RG\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert input_CD_Cliente_Telefone != null : "fx:id=\"input_CD_Cliente_Telefone\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert input_DL_Cliente_RG != null : "fx:id=\"input_DL_Cliente_RG\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert notifica_Atualiza != null : "fx:id=\"notifica_Atualiza\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert notifica_Cadastro != null : "fx:id=\"notifica_Cadastro\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert notifica_Deleta != null : "fx:id=\"notifica_Deleta\" was not injected: check your FXML file 'ClienteView.fxml'.";
        assert tabelaClientes != null : "fx:id=\"tabelaClientes\" was not injected: check your FXML file 'ClienteView.fxml'.";
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializaListaClientes();
        
        /*
        btCliente_Table_Atualiza.setOnMouseClicked((MouseEvent e)->{});
        */
        
        bt_Cadastrar.setOnMouseClicked((MouseEvent e)->{ paneActionInsert();});
        bt_Deletar_Cliente.setOnMouseClicked((MouseEvent e)->{paneActionDelete();});
        notifica_Atualiza.setText("Preencha apenas os campos que deseja atualizar");
        bt_Atualiza_Cliente.setOnMouseClicked((MouseEvent e)->{paneActionUpdate();});   

        btCliente_Table_Atualiza.setOnMouseClicked((MouseEvent e)->{inicializaListaClientes();});
        btVoltar.setOnMouseClicked((MouseEvent e)->{
        fechar();
        });
    }
    
    /**
     * 
     */
    private void paneActionInsert(){
        ClienteDao clienteDao;
        clienteDao = new ClienteDaoBD();
        
        if(StringUtils.isNullOrBlank(input_CD_Cliente_Nome.getText())==false||StringUtils.isNullOrEmpty(input_CD_Cliente_Nome.getText())==false
           ||StringUtils.isNullOrBlank(input_CD_Cliente_RG.getText())==false||StringUtils.isNullOrEmpty(input_CD_Cliente_RG.getText())==false){
            
            Cliente cliente = clienteDao.procurarPorRg(input_CD_Cliente_RG.getText());
            if(clienteDao.procurarPorRg(input_CD_Cliente_RG.getText())==null){
                if(clienteDao.salvar(new Cliente(input_CD_Cliente_Nome.getText(), input_CD_Cliente_RG.getText(), input_CD_Cliente_Telefone.getText()))==true){
                notifica_Cadastro.setText("Cliente cadastrado com Sucesso !");
                input_CD_Cliente_Nome.clear();
                input_CD_Cliente_RG.clear();
                input_CD_Cliente_Telefone.clear();
                inicializaListaClientes();
                }
                
            }else{
            notifica_Cadastro.setText("Erro ao cadastrar - Cliente Já existente!");
            }
        }else{
         notifica_Cadastro.setText("Erro ao cadastrar - CAMPOS VAZIOS !!");
        }
        inicializaListaClientes();
      
    }
    
    private void paneActionDelete(){
    //DELETE
    ClienteDao clienteDao;
    clienteDao = new ClienteDaoBD();
    
        if (checkBoxDelete.isSelected()==true) {
            if(StringUtils.isNullOrBlank(input_DL_Cliente_RG.getText())==false||StringUtils.isNullOrEmpty(input_DL_Cliente_RG.getText())==false){
            Cliente cliente = clienteDao.procurarPorRg(input_DL_Cliente_RG.getText());
            Text_Delete_Nome.setText(cliente.getNome());
            Text_Delete_RG.setText(cliente.getRg());
            Text_Delete_Telefone.setText(cliente.getTelefone()); 
                if(clienteDao.deletar(cliente)==true){
                    notifica_Deleta.setText("Cliente Deletado Com sucesso");
                    input_DL_Cliente_RG.clear();
                    inicializaListaClientes();
                }      
            }else{
                 notifica_Deleta.setText("Erro - cliente não encontrado ou campo não preenchido !");         
            }
        }else{
        notifica_Deleta.setText("Erro -- Marcar o Check Box antes de excluir !");
        }
    }
    
    private void paneActionUpdate(){
    ClienteDao clienteDao;
    clienteDao = new ClienteDaoBD();    
    Cliente cliente = null;
    if(StringUtils.isNullOrBlank(input_AT_Cliente_BUSCA.getText())==false||StringUtils.isNullOrEmpty(input_AT_Cliente_BUSCA.getText())==false){   
        cliente = clienteDao.procurarPorRg(input_AT_Cliente_BUSCA.getText()); 
        if(clienteDao.procurarPorRg(input_AT_Cliente_BUSCA.getText())==null){

        if (!input_AT_Cliente_RG.getText().isEmpty()){
            if(clienteDao.procurarPorRg(input_AT_Cliente_RG.getText())==null){
                    cliente.setRg(input_AT_Cliente_RG.getText());
            }else{
                notifica_Atualiza.setText("Erro ao atualizar - Cliente com esse RG ja existe");
            }  
        }
        if (!input_AT_Cliente_Nome.getText().isEmpty()){
            cliente.setNome(input_AT_Cliente_Nome.getText());
        }
        if (!input_AT_Cliente_Telefone.getText().isEmpty()){
             cliente.setTelefone(input_AT_Cliente_Telefone.getText());
        }
            clienteDao.atualizar(cliente);
            inicializaListaClientes();       
        }

    }else{
        notifica_Atualiza.setText("Erro - Favor adicionar um RG valido no campo [RG BUSCA] ");
    }
        input_AT_Cliente_BUSCA.clear();
        notifica_Atualiza.setText("Preencha apenas os campos que deseja atualizar");
        input_AT_Cliente_Nome.clear();
        input_AT_Cliente_RG.clear();
        input_AT_Cliente_Telefone.clear();
    }
      
    private void inicializaListaClientes(){   
        ColunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        ColunaRG.setCellValueFactory(new PropertyValueFactory("rg"));
        ColunaTelefone.setCellValueFactory(new PropertyValueFactory("telefone")); 
        tabelaClientes.setItems(atualizaListaClientes());
    }
    
    private ObservableList<Cliente> atualizaListaClientes(){
        ClienteDao clienteDao;
        clienteDao = new ClienteDaoBD();
        return FXCollections.observableArrayList(clienteDao.listar());
    }
        
    private void fechar(){
        Menu_Principal menu = new Menu_Principal();
        try {
            menu.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ClienteViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cliente_Form.getStage().close();
    }
    
    
    
}


