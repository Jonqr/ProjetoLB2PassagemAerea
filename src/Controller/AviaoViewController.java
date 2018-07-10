/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AviaoDao;
import DaoBD.AviaoDaoBD;
import Form.Aviao_Form;
import Form.Menu_Principal;
import Model.Aviao;
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
public class AviaoViewController implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    
// ------- CADASTRO
    @FXML private Label notifica_Cadastro;
    @FXML private TextField input_CD_Assento;
    @FXML private TextField input_CD_Nome;
    @FXML private TextField input_CD_COD;
    @FXML private Button bt_Cadastrar;
    
// ------- ATUALIZA
    @FXML private Button bt_Atualiza;
    @FXML private TextField input_AT_Assentos;
    @FXML private TextField input_AT_BUSCA;
    @FXML private TextField input_AT_Codigo;
    @FXML private TextField input_AT_Nome;
    @FXML private Label notifica_Atualiza;
    
// ------- DELETE
    @FXML private Label Text_Delete_Assento;
    @FXML private Label Text_Delete_Cod;
    @FXML private Label Text_Delete_Nome;
    @FXML private Button bt_Deletar;
    @FXML private CheckBox checkBoxDelete;
    @FXML private Label notifica_Deleta;  
    @FXML private TextField input_DL_COD;
    
    //----------------------------------------------------
    @FXML private Button bt_Table_Atualiza;
    @FXML private TableView<Aviao> tabelaAviao;
    @FXML private TableColumn<Aviao, Integer> ColunaAssentos;
    @FXML private TableColumn<Aviao, String> ColunaCodigo;
    @FXML private TableColumn<Aviao, String> ColunaNome;
    @FXML private Button btVoltar;

    @FXML
    void initialize() {
        assert ColunaAssentos != null : "fx:id=\"ColunaAssentos\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert ColunaCodigo != null : "fx:id=\"ColunaCodigo\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert ColunaNome != null : "fx:id=\"ColunaNome\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert Text_Delete_Assento != null : "fx:id=\"Text_Delete_Assento\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert Text_Delete_Cod != null : "fx:id=\"Text_Delete_Cod\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert Text_Delete_Nome != null : "fx:id=\"Text_Delete_Nome\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert btVoltar != null : "fx:id=\"btVoltar\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert bt_Atualiza != null : "fx:id=\"bt_Atualiza\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert bt_Cadastrar != null : "fx:id=\"bt_Cadastrar\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert bt_Deletar != null : "fx:id=\"bt_Deletar\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert bt_Table_Atualiza != null : "fx:id=\"bt_Table_Atualiza\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert checkBoxDelete != null : "fx:id=\"checkBoxDelete\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert input_AT_Assentos != null : "fx:id=\"input_AT_Assentos\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert input_AT_BUSCA != null : "fx:id=\"input_AT_BUSCA\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert input_AT_Codigo != null : "fx:id=\"input_AT_Codigo\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert input_AT_Nome != null : "fx:id=\"input_AT_Nome\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert input_CD_Assento != null : "fx:id=\"input_CD_Assento\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert input_CD_Nome != null : "fx:id=\"input_CD_Nome\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert input_CD_COD != null : "fx:id=\"input_CD_RG\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert input_DL_COD != null : "fx:id=\"input_DL_RG\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert notifica_Atualiza != null : "fx:id=\"notifica_Atualiza\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert notifica_Cadastro != null : "fx:id=\"notifica_Cadastro\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert notifica_Deleta != null : "fx:id=\"notifica_Deleta\" was not injected: check your FXML file 'AviaoView.fxml'.";
        assert tabelaAviao != null : "fx:id=\"tabelaAviao\" was not injected: check your FXML file 'AviaoView.fxml'.";


    }
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicializaListaAviao();
        bt_Cadastrar.setOnMouseClicked((MouseEvent e)->{ cadastrar();});
        bt_Deletar.setOnMouseClicked((MouseEvent e)->{ delete();});
        bt_Atualiza.setOnMouseClicked((MouseEvent e)->{ atualiza();});
        btVoltar.setOnMouseClicked((MouseEvent e)->{fechar();});
    
    }    
  
    private void cadastrar(){
        
        AviaoDao aviaoDao;
        aviaoDao = new AviaoDaoBD();
        
        if(StringUtils.isNullOrBlank(input_CD_COD.getText())==false||StringUtils.isNullOrEmpty(input_CD_COD.getText())==false
           ||StringUtils.isNullOrBlank(input_CD_Nome.getText())==false||StringUtils.isNullOrEmpty(input_CD_Nome.getText())==false
                ||StringUtils.isNullOrBlank(input_CD_Assento.getText())==false||StringUtils.isNullOrEmpty(input_CD_Assento.getText())==false){
        
            Aviao aviao =null ;
            if(aviaoDao.procurarPorCodigo(input_CD_COD.getText())==null||aviaoDao.procurarPorNome(input_CD_Nome.getText())==null){
                
                if(aviaoDao.salvar(new Aviao(input_CD_COD.getText(), input_CD_Nome.getText(), Integer.parseInt(input_CD_Assento.getText())))==true){
                input_CD_Assento.clear();
                input_CD_Nome.clear();
                input_CD_COD.clear();
                notifica_Cadastro.setText("Aviao cadastrado com Sucesso !");
                inicializaListaAviao();
                }else{
                                notifica_Cadastro.setText("Erro na operação, verifique os dados informados !");

                }
                
            }else{
                notifica_Cadastro.setText("Erro ao cadastrar - Aviao ja cadastrado!");
            }
        }else{
            
            notifica_Cadastro.setText("ERRO - Favor nao deixar campos vazios !");
        }
        inicializaListaAviao();
    }
    
    private void atualiza(){
        AviaoDao aviaoDao;
        aviaoDao = new AviaoDaoBD();
        if(StringUtils.isNullOrBlank(input_AT_BUSCA.getText())==false||StringUtils.isNullOrEmpty(input_AT_BUSCA.getText())==false){
            if(aviaoDao.procurarPorCodigo(input_AT_BUSCA.getText())!=null){
            Aviao aviao = aviaoDao.procurarPorCodigo(input_AT_BUSCA.getText());
            if(!input_AT_Codigo.getText().isEmpty()){
                if(aviaoDao.procurarPorCodigo(input_AT_Codigo.getText())==null){
                    aviao.setCodigo(input_AT_Codigo.getText());
                }else{
                    notifica_Atualiza.setText("Codigo já existente, não é possivel alterar!");
                }
            }
            
            if(!input_AT_Nome.getText().isEmpty()){
                if(aviaoDao.procurarPorCodigo(input_AT_Codigo.getText())==null){
                    aviao.setCodigo(input_AT_Codigo.getText());
                }else{
                    notifica_Atualiza.setText("Nome já existente, não é possivel alterar!");
                }
                
            }
            if(!input_AT_Assentos.getText().isEmpty()){
                aviao.setQtdAssento(Integer.parseInt(input_AT_Assentos.getText()));
            }
            aviaoDao.atualizar(aviao);
            notifica_Atualiza.setText("Aviao atualizado agora");
            }else{
            notifica_Atualiza.setText("Avião não encontrado");
            }
        }else{
            notifica_Atualiza.setText("Erro, favor preencher a Busca de Aviao! ");
        }
    /*

    @FXML private TextField input_AT_Assentos;
    @FXML private TextField input_AT_BUSCA;
    @FXML private TextField input_AT_Codigo;
    @FXML private TextField input_AT_Nome;
        
        
        if (!input_AT_Cliente_RG.getText().isEmpty()){
            if(clienteDao.procurarPorRg(input_AT_Cliente_RG.getText())==null){
                    cliente.setRg(input_AT_Cliente_RG.getText());
            }else{
                notifica_Atualiza.setText("Erro ao atualizar - Cliente com esse RG ja existe");
            }  
        }
        

    }else{
        notifica_Atualiza.setText("Erro - Favor adicionar um RG valido no campo [RG BUSCA] ");
    */
        
    }
    
    private void delete(){
        
        AviaoDao aviaoDao;
            aviaoDao = new AviaoDaoBD();
        if(checkBoxDelete.isSelected()==true){
            
            if(StringUtils.isNullOrBlank(input_DL_COD.getText())==false
             ||StringUtils.isNullOrEmpty(input_DL_COD.getText())==false){
                if(aviaoDao.procurarPorCodigo(input_DL_COD.getText())!=null){
                    Aviao aviao = aviaoDao.procurarPorCodigo(input_DL_COD.getText());
                    
                    Text_Delete_Cod.setText(aviao.getCodigo());
                    Text_Delete_Nome.setText(aviao.getNome());
                    Text_Delete_Assento.setText(""+aviao.getQtdAssento());
                    if(aviaoDao.deletar(aviao)==true){
                        notifica_Deleta.setText("Avião deletado com sucesso !");
                        checkBoxDelete.isDisable();
                        input_DL_COD.clear();
                    }else{  
                        checkBoxDelete.isDisable();
                        input_DL_COD.clear();
                    notifica_Deleta.setText("Erro ao deletar - avião sendo utilizado !");
                    }                
                }     
            }else{
                 notifica_Deleta.setText("Erro - cliente não encontrado ou campo não preenchido !");         
            }   
        }else{
        notifica_Deleta.setText("Erro -- Marcar o Check Box antes de excluir !");
        }
    }
    
    private void inicializaListaAviao(){   
        ColunaCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        ColunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        ColunaAssentos.setCellValueFactory(new PropertyValueFactory("qtdAssento")); 
        tabelaAviao.setItems(atualizaListaAviao());
    }
    
    private ObservableList<Aviao> atualizaListaAviao(){
        AviaoDao aviaoDao;
        aviaoDao = new AviaoDaoBD();
        return FXCollections.observableArrayList(aviaoDao.listar());
    }
        
    private void fechar(){
        Menu_Principal menu = new Menu_Principal();
        
        try {
            menu.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(AviaoViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Aviao_Form.getStage().close();
    }
}
