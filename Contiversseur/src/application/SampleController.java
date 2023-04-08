package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable
{

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt1;

    @FXML
    private Button btnexit;

    @FXML
    private ComboBox<String> cbo2;

    @FXML
    private ComboBox<String> cbo1;
    
    @FXML
    private TextField textField2;

    @FXML
    private TextField textField1;
    
    @FXML
    private ComboBox<String> ComboBox2;

    @FXML
    private ComboBox<String> ComboBox1;

    @FXML
    private Button Exit;
    
    @FXML
    private TextField txtField1;
    
    @FXML
    private TextField txtField2;
    
    @FXML
    private Button Exitbtn;
    
    @FXML
    private ComboBox<String> Cbox2;
    
    @FXML
    private ComboBox<String> Cbox1;
    
    private ObservableList<String> listViscosité=FXCollections.observableArrayList("Mètre Carré par Seconde(m^2/s)", "Mètre Carré par Heure(m^2/h)", "Stokes(St)", "megaStokes(MSt)", "gigaStokes(GSt)");
    private double []Viscosité = {1,3600,10000,0.01,0.00001};
    
    
    private ObservableList<String> listVitesse=FXCollections.observableArrayList("Metrè par Second(m/s)", "Millimètre par Second(mm/s)", "Kilometrè par Heure(km/h) ", "Yard par Minute(yd/min)", "Metrè par Minute(m/min)");
    private double []Vitesse = {1,1000,3.6,65.6167979,60};
    
    private ObservableList<String> listForce=FXCollections.observableArrayList("Newton", "Micronewton", "Decinewton ", "Giganewton");
    private double []Force = {1, 1000000,0.000000001,10};

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		cbo1.setItems(listForce);
		cbo2.setItems(listForce);
		//le premier élément va toujours être sélecter.
		cbo1.getSelectionModel().selectFirst();
		cbo2.getSelectionModel().selectFirst();
		
		ComboBox1.setItems(listVitesse);
		ComboBox2.setItems(listVitesse);
		//le premier élément va toujours être sélecter.
		ComboBox1.getSelectionModel().selectFirst();
		ComboBox2.getSelectionModel().selectFirst();
		
		Cbox1.setItems(listViscosité);
		Cbox2.setItems(listViscosité);
		//le premier élément va toujours être sélecter.
		Cbox1.getSelectionModel().selectFirst();
		Cbox2.getSelectionModel().selectFirst();
		
	}
	
	@FXML
	private void verifNum(KeyEvent e)
	{
	TextField txt=(TextField)e.getSource();

	txt.textProperty().addListener((observable,oldValue,newValue)->
//3 text property. Observable,oldValue,newValue. 
	{
	if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
	{
	txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
	}

	});

	}
	

	private double setTaux(ComboBox a, double tbl[])
	{
		int item=a.getSelectionModel().getSelectedIndex();
		//prendre la valuer
		double val=tbl[item];
		//mets la valeur dans la tableau.
		return val;
		//retourn la valeur convertie
		
	}
	
	
	private void convert(ComboBox a, ComboBox b, TextField c, TextField d, double tbl[])
	{
		double from=setTaux(a,tbl);
		double depart=0;
		
		if(c.getText().equals(""))
			depart=0;
		//s'il n'y a pas de valuer, depart est zero.
		else
			depart=Double.parseDouble(c.getText());
		//convertie string à int
		double to=setTaux(b,tbl);
		double dest=(to/from)*depart;
		//calcultation
		d.setText(String.valueOf(dest));
		//valeur de la string dans le textfield
	}
	
	
	
	@FXML
	private void ConvertF1()
	{
		convert(cbo1,cbo2,txt1,txt2,Force);
		//contiversseur
	}
	
	@FXML
	private void ConvertF2()
	{
		convert(cbo2,cbo1,txt2,txt1,Force);
	}
	@FXML
	 private void quit()
	    {
	    	Alert alert=new Alert(AlertType.CONFIRMATION);
	    	//Crée une alerte de confirmation
	    	alert.setHeaderText("Confirmation");
	    	alert.setTitle("Sortie");
	    	alert.setContentText("Voudrais tu vraiment quitter");
	    	//Text
	    	Optional<ButtonType> result=alert.showAndWait();
	    	//Attendre
	    	if(result.get()==ButtonType.OK);
	    	//Si OK est cliqué sur quitter
	    		System.exit(0);
	    }
	
	private double setTaux2(ComboBox a, double tbl[])
	{
		int component=a.getSelectionModel().getSelectedIndex();
		//prendre la valuer
		double valeur=tbl[component];
		//mets la valeur dans la tableau.
		return valeur;
		//retourn la valeur convertie
		
	}
	
	private void convertion(ComboBox a, ComboBox b, TextField c, TextField d, double tbl[])
	{
		double from=setTaux(a,tbl);
		double depart=0;
		
		if(c.getText().equals(""))
			depart=0;
		//s'il n'y a pas de valuer, depart est zero.
		else
			depart=Double.parseDouble(c.getText());
		//convertie string à int
		double to=setTaux(b,tbl);
		double dest=(to/from)*depart;
		//calcultation
		d.setText(String.valueOf(dest));
		//valeur de la string dans le textfield
	}
	
	@FXML
	private void ConvertV1()
	{
		convert(ComboBox1,ComboBox2,textField1,textField2,Vitesse);
		//contiversseur
	}
	
	@FXML
	private void ConvertV2()
	{
		convert(ComboBox2,ComboBox1,textField2,textField1,Vitesse);
		//contiversseur
	}
	@FXML
	 private void quitter()
	    {
	    	Alert alert=new Alert(AlertType.CONFIRMATION);
	    	//Crée une alerte de confirmation
	    	alert.setHeaderText("Confirmation");
	    	alert.setTitle("Sortie");
	    	alert.setContentText("Voudrais tu vraiment quitter");
	    	//Textew
	    	Optional<ButtonType> result=alert.showAndWait();
	    	//Attendre
	    	if(result.get()==ButtonType.OK);
	    	//Si OK est cliqué sur quitter
	    		System.exit(0);
	    }
	
	
	
	private double setTaux3(ComboBox a, double tbl[])
	{
		int info=a.getSelectionModel().getSelectedIndex();
		//prendre la valuer
		double value=tbl[info];
		//mets la valeur dans la tableau.
		return value;
		//retourn la valeur convertie
		
	}
	
	private void change(ComboBox a, ComboBox b, TextField c, TextField d, double tbl[])
	{
		double from=setTaux(a,tbl);
		double depart=0;
		
		if(c.getText().equals(""))
			depart=0;
		//s'il n'y a pas de valuer, depart est zero.
		else
			depart=Double.parseDouble(c.getText());
		//convertie string à int
		double to=setTaux(b,tbl);
		double dest=(to/from)*depart;
		//calcultation
		d.setText(String.valueOf(dest));
		//valeur de la string dans le textfield
	}
	
	@FXML
	private void ConvertVi1()
	{
		convert(Cbox1,Cbox2,txtField1,txtField2,Viscosité);
		//contiversseur
	}
	
	@FXML
	private void ConvertVi2()
	{
		convert(Cbox2,Cbox1,txtField2,txtField1,Viscosité);
		//contiversseur
	}
	@FXML
	 private void exit()
	    {
	    	Alert alert=new Alert(AlertType.CONFIRMATION);
	    	//Crée une alerte de confirmation
	    	alert.setHeaderText("Confirmation");
	    	alert.setTitle("Sortie");
	    	alert.setContentText("Voudrais tu vraiment quitter");
	    	//Textew
	    	Optional<ButtonType> result=alert.showAndWait();
	    	//Attendre
	    	if(result.get()==ButtonType.OK);
	    	//Si OK est cliqué sur quitter
	    		System.exit(0);
	    }



}
