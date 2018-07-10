/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AviaoDao;
import Dao.VooDao;
import DaoBD.AviaoDaoBD;
import DaoBD.VooDaoBd;
import Form.Menu_Principal;
import Form.Voo_Form;
import Model.Auxiliar;
import Model.Aviao;
import Model.Voo;
import Util.StringUtils;
import java.net.URL;
import java.time.LocalTime;
import java.util.List;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jonh_
 */
public class VooViewController implements Initializable {
    
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    
    @FXML private Button btAtualizaV;
    @FXML private TextField id_voo_atualiza;
    @FXML private Label textAlertAtualizacao;
    @FXML private TextField inputATHorario;
    @FXML private TextField inputATdestino;
    @FXML private TextField inputATorigem;
    @FXML private TextField inputATcodAv;
    
    @FXML private TextField inputCD_Destino;
    @FXML private TextField inputCD_Horario;
    @FXML private TextField inputCD_Origem;
    @FXML private Label textAlertCadastro;
    @FXML private Button btCadastrar;
    @FXML private TextField inputCodAviao_CADASTRO;
    
    @FXML private Label deleteAlert;
    @FXML private Button btDelete;
    @FXML private CheckBox checkBoxDelete;
    @FXML private Label textDLAviao;
    @FXML private Label textDLAviaoAssentos;
    @FXML private Label textDLAviaoNome;
    @FXML private Label textDLDestino;
    @FXML private Label textDLHorario;
    @FXML private Label textDLOrigem;
    @FXML private TextField id_DL_Voo;
    
    
    @FXML private Button btVenda;
    @FXML private Button btVoltar;
    
    @FXML private TableView<Aviao> tableAviao;
    @FXML private TableColumn<Aviao, Integer> TableAviao_Assentos;
    @FXML private TableColumn<Aviao, String> TableAviao_COD;
    @FXML private TableColumn<Aviao, String> TableAviao_NOME;
    
    @FXML private TableView<Auxiliar> tabelaVoo;
    @FXML private TableColumn<Auxiliar, String> colunaOrigem;
    @FXML private TableColumn<Auxiliar, String> colunaDestino;
    @FXML private TableColumn<Auxiliar, LocalTime> colunaHorario;
    @FXML private TableColumn<Auxiliar, String> colunaAviao;
    @FXML private TableColumn<Auxiliar, String> colunaCompania;
    @FXML private TableColumn<Auxiliar, Integer> ColunaVooAssentos;
    @FXML private TableColumn<Auxiliar, Integer> Colunaid;
    
     @FXML
    void initialize() {
        assert ColunaVooAssentos != null : "fx:id=\"ColunaVooAssentos\" was not injected: check your FXML file 'VooView.fxml'.";
        assert Colunaid != null : "fx:id=\"Colunaid\" was not injected: check your FXML file 'VooView.fxml'.";
        assert TableAviao_Assentos != null : "fx:id=\"TableAviao_Assentos\" was not injected: check your FXML file 'VooView.fxml'.";
        assert TableAviao_COD != null : "fx:id=\"TableAviao_COD\" was not injected: check your FXML file 'VooView.fxml'.";
        assert TableAviao_NOME != null : "fx:id=\"TableAviao_NOME\" was not injected: check your FXML file 'VooView.fxml'.";
        assert btCadastrar != null : "fx:id=\"btCadastrar\" was not injected: check your FXML file 'VooView.fxml'.";
        assert btDelete != null : "fx:id=\"btDelete\" was not injected: check your FXML file 'VooView.fxml'.";
        assert btVenda != null : "fx:id=\"btVenda\" was not injected: check your FXML file 'VooView.fxml'.";
        assert btVoltar != null : "fx:id=\"btVoltar\" was not injected: check your FXML file 'VooView.fxml'.";
        assert checkBoxDelete != null : "fx:id=\"checkBoxDelete\" was not injected: check your FXML file 'VooView.fxml'.";
        assert colunaAviao != null : "fx:id=\"colunaAviao\" was not injected: check your FXML file 'VooView.fxml'.";
        assert colunaCompania != null : "fx:id=\"colunaCompania\" was not injected: check your FXML file 'VooView.fxml'.";
        assert colunaDestino != null : "fx:id=\"colunaDestino\" was not injected: check your FXML file 'VooView.fxml'.";
        assert colunaHorario != null : "fx:id=\"colunaHorario\" was not injected: check your FXML file 'VooView.fxml'.";
        assert colunaOrigem != null : "fx:id=\"colunaOrigem\" was not injected: check your FXML file 'VooView.fxml'.";
        assert deleteAlert != null : "fx:id=\"deleteAlert\" was not injected: check your FXML file 'VooView.fxml'.";
        assert id_DL_Voo != null : "fx:id=\"id_DL_Voo\" was not injected: check your FXML file 'VooView.fxml'.";
        assert id_voo_atualiza != null : "fx:id=\"id_voo_atualiza\" was not injected: check your FXML file 'VooView.fxml'.";
        assert inputATHorario != null : "fx:id=\"inputATHorario\" was not injected: check your FXML file 'VooView.fxml'.";
        assert inputATdestino != null : "fx:id=\"inputATdestino\" was not injected: check your FXML file 'VooView.fxml'.";
        assert inputATorigem != null : "fx:id=\"inputATorigem\" was not injected: check your FXML file 'VooView.fxml'.";
        assert inputCD_Destino != null : "fx:id=\"inputCD_Destino\" was not injected: check your FXML file 'VooView.fxml'.";
        assert inputCD_Horario != null : "fx:id=\"inputCD_Horario\" was not injected: check your FXML file 'VooView.fxml'.";
        assert inputCD_Origem != null : "fx:id=\"inputCD_Origem\" was not injected: check your FXML file 'VooView.fxml'.";
        assert inputCodAviao_CADASTRO != null : "fx:id=\"inputCodAviao_CADASTRO\" was not injected: check your FXML file 'VooView.fxml'.";
        assert tabelaVoo != null : "fx:id=\"tabelaVoo\" was not injected: check your FXML file 'VooView.fxml'.";
        assert tableAviao != null : "fx:id=\"tableAviao\" was not injected: check your FXML file 'VooView.fxml'.";
        assert textAlertAtualizacao != null : "fx:id=\"textAlertAtualizacao\" was not injected: check your FXML file 'VooView.fxml'.";
        assert textAlertCadastro != null : "fx:id=\"textAlertCadastro\" was not injected: check your FXML file 'VooView.fxml'.";
        assert textDLAviao != null : "fx:id=\"textDLAviao\" was not injected: check your FXML file 'VooView.fxml'.";
        assert textDLAviaoAssentos != null : "fx:id=\"textDLAviaoAssentos\" was not injected: check your FXML file 'VooView.fxml'.";
        assert textDLAviaoNome != null : "fx:id=\"textDLAviaoNome\" was not injected: check your FXML file 'VooView.fxml'.";
        assert textDLDestino != null : "fx:id=\"textDLDestino\" was not injected: check your FXML file 'VooView.fxml'.";
        assert textDLHorario != null : "fx:id=\"textDLHorario\" was not injected: check your FXML file 'VooView.fxml'.";
        assert textDLOrigem != null : "fx:id=\"textDLOrigem\" was not injected: check your FXML file 'VooView.fxml'.";
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializaListaAviao();
        inicializaListaVoo();
        btCadastrar.setOnMouseClicked((MouseEvent e)->{cadastraVoo();});
        btDelete.setOnMouseClicked((MouseEvent e)->{deleteVoo();});
        btAtualizaV.setOnMouseClicked((MouseEvent e)->{atualizarVoo();});
        btVoltar.setOnMouseClicked((MouseEvent e)->{Fechar();});  
        
    }    
    
    private void cadastraVoo(){
        VooDao vooDao;
        vooDao = new VooDaoBd();
        AviaoDao aviaoDao;
        aviaoDao = new AviaoDaoBD();
        if(StringUtils.isNullOrBlank(inputCD_Destino.getText())==false||StringUtils.isNullOrEmpty(inputCD_Destino.getText())==false
                ||StringUtils.isNullOrBlank(inputCD_Horario.getText())==false||StringUtils.isNullOrEmpty(inputCD_Horario.getText())==false
                ||StringUtils.isNullOrBlank(inputCD_Origem.getText())==false||StringUtils.isNullOrEmpty(inputCD_Origem.getText())==false
                ||StringUtils.isNullOrBlank(inputCodAviao_CADASTRO.getText())==false||StringUtils.isNullOrEmpty(inputCodAviao_CADASTRO.getText())==false){
               Aviao aviao =  aviaoDao.procurarPorCodigo(inputCodAviao_CADASTRO.getText());
               vooDao.salvar(new Voo(aviao, inputCD_Origem.getText(), inputCD_Destino.getText(), LocalTime.parse(inputCD_Horario.getText())));
               textAlertCadastro.setText("Voo Cadastrado com sucesso !");
               inicializaListaVoo();
               
        }else{
        textAlertCadastro.setText("Erro ao codastrar...não deixe campos vazios !");
        }
    
    }
    
    private void atualizarVoo(){
        VooDao vooDao;
        vooDao = new VooDaoBd();
        AviaoDao aviaoDao;
        aviaoDao = new AviaoDaoBD();
        if(StringUtils.isNullOrBlank(id_voo_atualiza.getText())==false||StringUtils.isNullOrEmpty(id_voo_atualiza.getText())==false){
        
            Voo voo = vooDao.procurarPorId(Integer.parseInt(id_voo_atualiza.getText()));
            
        if(inputATHorario.getText()!=null){
        voo.setHorario(LocalTime.parse(inputATHorario.getText()));
        }
        if(inputATorigem.getText() != null){
        voo.setOrigem(inputATorigem.getText());
        }
        if(inputATdestino.getText() !=null){
        voo.setDestino(inputATdestino.getText());
        }
        if(inputATcodAv.getText() != null){
        Aviao av = aviaoDao.procurarPorCodigo(inputATcodAv.getText());
        voo.setAviao(av);
        }
        vooDao.atualizar(voo);
    }else{
        textAlertAtualizacao.setText("Erro ao atualizar.. favor inserir id do voo !");
        id_voo_atualiza.promptTextProperty().set("OBRIGATORIO ! inserir id do voo");
        }
     
    
    }
    
    private void deleteVoo(){
        VooDao vooDao;
        vooDao = new VooDaoBd();
        if(StringUtils.isNullOrBlank(id_DL_Voo.getText())==false||StringUtils.isNullOrEmpty(id_DL_Voo.getText())==false){
            Voo tela = vooDao.procurarPorId(Integer.parseInt(id_DL_Voo.getText()));
            textDLAviao.setText(tela.getAviao().getCodigo());
            textDLAviaoAssentos.setText(""+tela.getAviao().getQtdAssento());
            textDLAviaoNome.setText(tela.getAviao().getNome());
            textDLDestino.setText(tela.getDestino());
            textDLHorario.setText(""+tela.getHorario());
            textDLOrigem.setText(tela.getOrigem());
            if(checkBoxDelete.isSelected()){
            deleteAlert.setText("Deletado com sucesso!");
            vooDao.deletar(tela);
            inicializaListaVoo();
            } else{deleteAlert.setText("Erro - Favor marcar CheckBOX!");}
            inicializaListaVoo();
        }else{deleteAlert.setText("Campo vazio, favor informar ID ! ");}
        
        inicializaListaVoo();
        
  
    }
    
    private void inicializaListaAviao(){   
        TableAviao_COD.setCellValueFactory(new PropertyValueFactory("codigo"));
        TableAviao_NOME.setCellValueFactory(new PropertyValueFactory("nome"));
        TableAviao_Assentos.setCellValueFactory(new PropertyValueFactory("qtdAssento")); 
        tableAviao.setItems(atualizaListaAviao());
    }
    
    private ObservableList<Aviao> atualizaListaAviao(){
        AviaoDao aviaoDao;
        aviaoDao = new AviaoDaoBD();
        return FXCollections.observableArrayList(aviaoDao.listar());
    }
    
    private void inicializaListaVoo(){
        
        colunaOrigem.setCellValueFactory(new PropertyValueFactory("origem"));
        colunaDestino.setCellValueFactory(new PropertyValueFactory("destino"));
        colunaHorario.setCellValueFactory(new PropertyValueFactory("horarioVoo")); 
        colunaAviao.setCellValueFactory(new PropertyValueFactory("cod_avi"));
        colunaCompania.setCellValueFactory(new PropertyValueFactory("nomeAviao"));
        ColunaVooAssentos.setCellValueFactory(new PropertyValueFactory("qtdA"));
        Colunaid.setCellValueFactory(new PropertyValueFactory("id_voo"));
        tabelaVoo.setItems(atualizaListaVoo());
        
    
    }
    
    private ObservableList<Auxiliar> atualizaListaVoo(){
        VooDao vooDao;
        vooDao = new VooDaoBd();
        return FXCollections.observableArrayList(vooDao.listarAuxiliar());
    }

    private void AbrirVendas(){
       Object aux;
 
    }
    
    private void Fechar(){
        Menu_Principal menu = new Menu_Principal();
        try {
            menu.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(VooViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Voo_Form.getStage().close();
    }
    
    
    
    
}
