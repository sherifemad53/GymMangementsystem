package gymms;

import gymms.Forms.login;
import gymms.database.javaconnect;
import java.sql.Connection;

public class Gymms {
    
    private int ID;
    private String TYPE,DESCRIPTION;

    public Gymms(int ID, String TYPE, String DESCRIPTION) {
        this.ID = ID;
        this.TYPE = TYPE;
        this.DESCRIPTION = DESCRIPTION;
    }
    
    // add branches
    // change gym type 
    // add gym description
    
    
    public static void main(String[] args) {
        {
            Connection con = javaconnect.connectdb();
            new login().setVisible(true);
            
            System.out.println("hello");
            System.out.println("Shefoxo");
        }
    }
}
