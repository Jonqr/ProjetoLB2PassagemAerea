/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Form.Aviao_Form;
import Form.Cliente_Form;
import Form.Menu_Principal;
import Form.Venda_Form;
import Form.Voo_Form;
import Main.Principal;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author jonh_
 */
public class MenuViewController implements Initializable {
   
@FXML
    private ResourceBundle resources;

    @FXML private URL location;
    @FXML private AnchorPane Principal;
    @FXML private Button btMAviao;
    @FXML private Button btMClientes;
    @FXML private Button btMRelatorio;
    @FXML private Button btMVenda;
    @FXML private Button btMVoo;
    @FXML private Button btMsair;

    @FXML
    void initialize() {
        assert Principal != null : "fx:id=\"Principal\" was not injected: check your FXML file 'MenuView.fxml'.";
        assert btMAviao != null : "fx:id=\"btMAviao\" was not injected: check your FXML file 'MenuView.fxml'.";
        assert btMClientes != null : "fx:id=\"btMClientes\" was not injected: check your FXML file 'MenuView.fxml'.";
        assert btMRelatorio != null : "fx:id=\"btMRelatorio\" was not injected: check your FXML file 'MenuView.fxml'.";
        assert btMVenda != null : "fx:id=\"btMVenda\" was not injected: check your FXML file 'MenuView.fxml'.";
        assert btMVoo != null : "fx:id=\"btMVoo\" was not injected: check your FXML file 'MenuView.fxml'.";
        assert btMsair != null : "fx:id=\"btMsair\" was not injected: check your FXML file 'MenuView.fxml'.";


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btMClientes.setOnMouseClicked((MouseEvent e)->{ ChamarClienteTela();});
        btMAviao.setOnMouseClicked((MouseEvent e)->{ChamarAviaoTela();});
        btMVoo.setOnMouseClicked((MouseEvent e)->{chamarVooTela();});
        btMVenda.setOnMouseClicked((MouseEvent e)->{chamarVendaTela();});
        btMRelatorio.setOnMouseClicked((MouseEvent e)->{chamarRelatorio();});
        btMsair.setOnMouseClicked((MouseEvent e)->{
        fechar();
        });
    }
    
   
    
    private void ChamarClienteTela(){
        Cliente_Form telaCliente = new Cliente_Form();
        try {
            telaCliente.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(MenuViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechar();
    }
    
    private void ChamarAviaoTela(){
        Aviao_Form telaAviao = new Aviao_Form();
        try {
            telaAviao.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(MenuViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechar();
    }
    
    private void chamarVooTela(){
        Voo_Form voo = new Voo_Form();
            
    try {
        voo.start(new Stage());
    } catch (Exception ex) {
        Logger.getLogger(MenuViewController.class.getName()).log(Level.SEVERE, null, ex);
    }
    fechar();
    
    }
    
    private void chamarVendaTela(){
        Venda_Form venda = new Venda_Form();
    try {
        venda.start(new Stage());
    } catch (Exception ex) {
        Logger.getLogger(MenuViewController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        fechar();
    }
    
    private void chamarRelatorio(){}
    
    private void fechar(){
    
            Menu_Principal.getStage().close();  

    }
    
    
    
    
}
