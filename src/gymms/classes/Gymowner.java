package gymms.classes;

import gymms.database.DatabaseManeger;
import java.sql.ResultSet;

public class Gymowner extends User{
    
    public Gymowner(String NAME, String EMAIL, String USERNAME, String PASSWORD, String ADDRESS, long PHONE,String ROLENAME, String GENDER) {
        super(NAME, EMAIL, USERNAME, PASSWORD, ADDRESS, PHONE,ROLENAME,GENDER);
    }

    public Gymowner() {
    }
    
    public boolean adduser(){
        return getDbmanager().adduser(NAME, EMAIL, USERNAME, PASSWORD, PASSWORD, ADDRESS,PHONE,ROLENAME,GENDER);
    }
    
    public ResultSet viewUserdata(){
        return getDbmanager().viewuserdata();
    }
    
    public void deleteUser(int USERID){
        getDbmanager().deleteUser(USERID);
    }
    
    public boolean addpackage(Package packagee){
       return packagee.addpackage(packagee.getNAME(),packagee.getDESCRIPTION(),packagee.getCOST(),packagee.getDURATION());
    }
    
    public ResultSet searchUser(String userid) {
        return getDbmanager().searchuser(userid);
    }

    public boolean editUser(User user) {
       return getDbmanager().edituser(user.getID(), user.getNAME(), 
               user.getUSERNAME(), user.getPASSWORD(),user.getEMAIL(), 
               user.getPHONE(), user.getADDRESS(), user.getGENDER());
    }
}
