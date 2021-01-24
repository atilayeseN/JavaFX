package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FileOps implements Ops{

	

	@Override
	public void addtoDb(int id, String name, String street, String city, String gender, String zip, File f)throws IOException  
	{
		try {
			PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
		      pw.append(id+","+name+","+street+","+city+","+gender+","+zip+"\n");
		      pw.close();
		}
		catch (Exception e) {
			Alert er =new Alert(AlertType.ERROR);
			er.setTitle("Error");
			er.setHeaderText("An error occured");
			
		}
		  
		
	}

	@Override
	public void updateDb(int id, File f,String [] update){
		
		 StringBuffer sb=new StringBuffer();
	        try
	        {
	            BufferedReader br=new BufferedReader(new FileReader("DB.txt"));
	            String s="";
	            while((s=br.readLine())!=null)
	            {
	                String data[]=new String[6];
	                data=s.split(",");
	                if(id==Integer.parseInt(data[0]))
	                {
	                    String row=data[0]+",";
	                    for(int i=0;i<5;i++)
	                    {
	                            row=row+update[i]+",";
	                    }
	                    sb.append(row);
	                    sb.append("\n");
	                }
	                else
	                {
	                    sb.append(s);
	                    sb.append("\n");
	                }
	            }
	            

	   
	        
	        PrintWriter pw=new PrintWriter(new FileOutputStream(f,false));
	        pw.print(sb.toString());
	        pw.close();
	        Alert suc=new Alert(AlertType.CONFIRMATION);
	        suc.setTitle("Success");
	        suc.setHeaderText("Update successful");
	        suc.show();
	        }
	        catch(Exception e)
	        {
	        	Alert error=new Alert(AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("An error occured");
	        }
    
	}
                
          
}



	

