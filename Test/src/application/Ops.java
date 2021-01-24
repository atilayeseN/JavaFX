package application;

import java.io.File;
import java.io.IOException;

public interface Ops {
public void addtoDb(int id,String name,String street,String city,String gender,String zip,File f) throws IOException;
public void updateDb(int id,File f,String [] update)throws IOException;
}
