package gymms;

import gymms.Forms.login;
import gymms.database.DatabaseManeger;
import gymms.database.javaconnect;
import java.sql.Connection;

public class Gymms {
    
    private int ID,street;
    private String TYPE,DESCRIPTION,name,city;

    public Gymms(int ID, String name, String TYPE, String DESCRIPTION, int street,    String city) {
        this.ID = ID;
        this.street = street;
        this.TYPE = TYPE;
        this.DESCRIPTION = DESCRIPTION;
        this.name = name;
        this.city = city;
    }

    DatabaseManeger dbmaneger =new DatabaseManeger();

    public Gymms() {
    }
    
    public boolean addbranch(Gymms gymms){
        return dbmaneger.addbranch(gymms);
    }
    
    // add branches
    // change gym type 
    // add gym description

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   
    
    public static void main(String[] args) {
        {
            Connection con = javaconnect.connectdb();
            new login().setVisible(true);
            
        }
    }
}
