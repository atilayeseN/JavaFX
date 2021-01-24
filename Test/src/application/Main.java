package application;
	

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application{
	private static ArrayList<Person> p=new ArrayList<Person>();
	File db=new File("DB.txt");
	
	
	TextField tfID=new TextField();
	TextField tfSUID=new TextField();
    TextField tfName=new TextField();
	TextField tfStreet=new TextField();
	TextField tfCity=new TextField();
	TextField tfGender=new TextField();
	TextField tfZip=new TextField();
	
	Button btAdd=new Button("Add");
	Button btFirst=new Button("First");
	Button btNext=new Button("Next");
	Button btPrevious=new Button("Previous");
	Button btLast=new Button("Last");
	Button btUbyID=new Button("UpdateByID");
	Button btSbyID=new Button("SearchByID");
	Button btClear=new Button("Clean textFields");
	
	Label lbID=new Label("ID");
	Label lbSUID=new Label("Search/Update ID");
	Label lbName=new Label("Name");
	Label lbStreet=new Label("Street");
	Label lbCity=new Label("City");
	Label lbGender=new Label("Gender");
	Label lbZip=new Label("Zip");
	
	
	public static void main(String[] args) {
		
		
		launch(args); 
		
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	try {
		
		tfID.setPrefColumnCount(1);
		tfID.setDisable(true);
		tfGender.setPrefColumnCount(1);
		tfZip.setPrefColumnCount(4);
		tfCity.setPrefColumnCount(12);
		tfStreet.setPrefColumnCount(20);
		
		
	
		
		
		
		GridPane p1=new GridPane();
		p1.setAlignment(Pos.CENTER);
		p1.setHgap(5);
		p1.setVgap(5);
		
		
	    p1.add(lbID, 0, 0);
		
		p1.add(lbName, 0, 1);
		p1.add(tfName, 1, 1);
		
		p1.add(lbStreet, 0, 2);
		p1.add(tfStreet, 1, 2);
		
		p1.add(lbCity,0,3);
		
		
		HBox top=new HBox(2);
		top.getChildren().addAll(tfID,lbSUID,tfSUID);
		p1.add(top, 1, 0);
		
		
		HBox p2=new HBox(5);
		p2.getChildren().addAll(tfCity,lbGender,tfGender,lbZip,tfZip);
		p1.add(p2, 1, 3);
		
		HBox p3=new HBox(5);
		p3.getChildren().addAll(btAdd,btFirst,btNext,btPrevious,btLast,btUbyID,btSbyID,btClear);
		p3.setAlignment(Pos.CENTER);
		
		BorderPane b=new BorderPane();
		
		b.setCenter(p1);
		b.setBottom(p3);
		
		Scene scene=new Scene(b,550,180);
		primaryStage.setTitle("AdressBook");
		primaryStage.setScene(scene);
		primaryStage.show();
		createDb();
		
		//Button Actions
	
btAdd.setOnAction(e->{
			
			try {
				
				if(db.length() != 0) {
				  int id=p.size();
				  p.add(new Person(id, tfName.getText(), tfStreet.getText(), tfCity.getText(),tfGender.getText(),Integer.parseInt(tfZip.getText())));
	              p.get(p.size()-1);
				  if(p.get(p.size()-1)!=null) {
					  
					  FileOps fnew=new FileOps();
					  fnew.addtoDb(id, tfName.getText(), tfStreet.getText(), tfCity.getText(), tfGender.getText(),tfZip.getText(),db);
					  }
				  
			    }
				else {
					 p.add(new Person(0, tfName.getText(), tfStreet.getText(), tfCity.getText(),tfGender.getText(),Integer.parseInt(tfZip.getText())));
			
						  FileOps fnew=new FileOps();
						  fnew.addtoDb(0, tfName.getText(), tfStreet.getText(), tfCity.getText(), tfGender.getText(),tfZip.getText(),db);					
					
				}
				
				Alert inf =new Alert(AlertType.CONFIRMATION);
				inf.setTitle("Info");
				inf.setHeaderText("You recorded successfully");
				inf.show();
				
			}
			
			catch (Exception e1) {
				Alert inf =new Alert(AlertType.ERROR);
				inf.setTitle("Info");
				inf.setHeaderText("You did something wrong,please record correctly");
				inf.show();
			
			    }
			
		});
btFirst.setOnAction(e->{
	try {
		if(p.get(0)!=null) {
			tfID.setText(Integer.toString(p.get(0).getId()));
			tfName.setText(p.get(0).getName());
			tfStreet.setText(p.get(0).getStreet());
			tfCity.setText(p.get(0).getCity());
			tfGender.setText(String.valueOf(p.get(0).getGender()));
			tfZip.setText(Integer.toString(p.get(0).getZip()));
			}
		}
		catch(Exception e2) {
			}
		
	
	});
		btNext.setOnAction(e->{
			if(tfID.getText() == "") {
				
				try {
					tfID.setText(Integer.toString(p.get(0).getId()));
					tfName.setText(p.get(0).getName());
					tfStreet.setText(p.get(0).getStreet());
					tfCity.setText(p.get(0).getCity());
					tfGender.setText(p.get(0).getGender());
					tfZip.setText(Integer.toString(p.get(0).getZip()));
				}
				catch(Exception e2) {
					Alert alN=new Alert(AlertType.INFORMATION);
					alN.setTitle("Info");
					alN.setHeaderText("There is no one in your addressbook");
					alN.show();
				}
				
				
					
				
			}
			else{
				try{

					
					tfName.setText(p.get(Integer.parseInt(tfID.getText())+1).getName());
					tfStreet.setText(p.get(Integer.parseInt(tfID.getText())+1).getStreet());
					tfCity.setText(p.get(Integer.parseInt(tfID.getText())+1).getCity());
                    tfGender.setText(p.get(Integer.parseInt(tfID.getText())+1).getGender());
                    tfZip.setText(Integer.toString(p.get(Integer.parseInt(tfID.getText())+1).getZip()));
                    tfID.setText(Integer.toString(p.get(Integer.parseInt(tfID.getText())+1).getId()));
				}
				catch(Exception e1) {
					tfID.setText(Integer.toString(p.get(0).getId()));
					tfName.setText(p.get(0).getName());
					tfStreet.setText(p.get(0).getStreet());
					tfCity.setText(p.get(0).getCity());
					tfGender.setText(p.get(0).getGender());
					tfZip.setText(Integer.toString(p.get(0).getZip()));
				}
			}
		});
		btPrevious.setOnAction(e->{
if(tfID.getText() == "") {
				
				try {
					tfID.setText(Integer.toString(p.get(0).getId()));
					tfName.setText(p.get(0).getName());
					tfStreet.setText(p.get(0).getStreet());
					tfCity.setText(p.get(0).getCity());
					tfGender.setText(p.get(0).getGender());
					tfZip.setText(Integer.toString(p.get(0).getZip()));
				}
				catch(Exception e2) {
					Alert alN=new Alert(AlertType.INFORMATION);
					alN.setTitle("Info");
					alN.setHeaderText("There is no one in your addressbook");
					alN.show();
				}
				
				
					
				
			}
			else{
				try{

					
					tfName.setText(p.get(Integer.parseInt(tfID.getText())-1).getName());
					tfStreet.setText(p.get(Integer.parseInt(tfID.getText())-1).getStreet());
					tfCity.setText(p.get(Integer.parseInt(tfID.getText())-1).getCity());
                    tfGender.setText(p.get(Integer.parseInt(tfID.getText())-1).getGender());
                    tfZip.setText(Integer.toString(p.get(Integer.parseInt(tfID.getText())-1).getZip()));
                    tfID.setText(Integer.toString(p.get(Integer.parseInt(tfID.getText())-1).getId()));
				}
				catch(Exception e1) {
					tfID.setText(Integer.toString(p.get(0).getId()));
					tfName.setText(p.get(0).getName());
					tfStreet.setText(p.get(0).getStreet());
					tfCity.setText(p.get(0).getCity());
					tfGender.setText(p.get(0).getGender());
					tfZip.setText(Integer.toString(p.get(0).getZip()));
				}
			}
		});
		
	
		btLast.setOnAction(e->{
		 try {
			tfID.setText(Integer.toString(p.get(p.size()-1).getId()));
			tfName.setText(p.get(p.size()-1).getName());
			tfStreet.setText(p.get(p.size()-1).getStreet());
			tfCity.setText(p.get(p.size()-1).getCity());
			tfGender.setText(p.get(p.size()-1).getGender());
			tfZip.setText(Integer.toString(p.get(p.size()-1).getZip()));
		 }
		 catch(Exception e3) {
			 e3.printStackTrace();
		 }
		}); 
		btUbyID.setOnAction(e->{
			try {
		    int id=Integer.parseInt(tfSUID.getText());
		    p.get(id);
		    p.get(id).setName(tfName.getText());
			p.get(id).setStreet(tfStreet.getText());
			p.get(id).setCity(tfCity.getText());
			p.get(id).setGender(tfGender.getText());
			p.get(id).setZip(Integer.parseInt(tfZip.getText()));
			String updaterow[]= {p.get(id).getName(),p.get(id).getStreet(),p.get(id).getCity(),p.get(id).getGender(),Integer.toString(p.get(id).getZip())};
			FileOps update=new FileOps();
			update.updateDb(id, db, updaterow);
			}
			catch(Exception e2) {
				Alert er=new Alert(AlertType.ERROR);
				er.setTitle("Error");
				er.setHeaderText("Invalid ID");
			}
		});
		btSbyID.setOnAction(e->{
		try {
			int id=Integer.parseInt(tfSUID.getText());
			p.get(id);
			tfID.setText(tfSUID.getText());
			tfName.setText(p.get(id).getName());
			tfStreet.setText(p.get(id).getStreet());
			tfCity.setText(p.get(id).getCity());
			tfGender.setText(p.get(id).getGender());
			tfZip.setText(Integer.toString(p.get(id).getZip()));
		}
		catch(Exception e1) {
			Alert alN=new Alert(AlertType.ERROR);
			alN.setTitle("Error");
			alN.setHeaderText("ID is invalid");
			alN.show();
		}
		});
		btClear.setOnAction(e->{
			tfID.clear();
			tfName.clear();
			tfStreet.clear();
			tfCity.clear();
			tfGender.clear();
			tfSUID.clear();
			tfZip.clear();
		});
		

	
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	}
	public static void createDb() {
		try {
		      File myObj = new File("DB.txt");
		 
		      if (myObj.createNewFile()) {
		        Alert create =new Alert(AlertType.INFORMATION);
		        create.setTitle("Info");
		        create.setHeaderText("Your database created");
		        create.show();
		   
		      }
		      if(myObj.length()==0) {
		    	  Alert db =new Alert(AlertType.CONFIRMATION);
			      db.setTitle("Info");
			      db.setHeaderText("Welcome");
			      db.show();
		      }
		      else {
		    	  Alert db =new Alert(AlertType.CONFIRMATION);
			      db.setTitle("Info");
			      db.setHeaderText("Welcome again");
			      db.show();
		    	read();
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		  }
		
	}
	public static void read() {
		try {
			  BufferedReader br=new BufferedReader(new FileReader("DB.txt"));
		  		String line="";
		  		while ((line=br.readLine()) != null) {
		  			String data[]=new String[5];
		  			data=line.split(",");
		  			int id=Integer.parseInt(data[0]);
		  			int zip=Integer.parseInt(data[5]);
		  			p.add(new Person(id, data[1], data[2], data[3],data[4], zip));
		  		}
		  		br.close();
		}
		  catch(Exception e4) {
			  e4.printStackTrace();
		  }
		  			
		  		
	}
	
	


	


	
}




