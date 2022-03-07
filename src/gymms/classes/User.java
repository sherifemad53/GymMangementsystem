package gymms.classes;

import gymms.database.DatabaseManeger;
import java.sql.ResultSet;

public class User<needtype> {

    DatabaseManeger dbmanager = new DatabaseManeger();

    protected int ID; 
    protected long PHONE;
    protected String NAME, EMAIL, USERNAME, PASSWORD, ADDRESS, ROLENAME,GENDER;

    public User(){
    }

    public long getPHONE() {
        return PHONE;
    }

    public void setPHONE(long PHONE) {
        this.PHONE = PHONE;
    }
    
    public User(String NAME, String EMAIL, String USERNAME, String PASSWORD, String ADDRESS, long PHONE, String ROLENAME,String GENDER) {
        this.PHONE = PHONE;
        this.NAME = NAME;
        this.EMAIL = EMAIL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.ADDRESS = ADDRESS;
        this.ROLENAME = ROLENAME;
        this.GENDER=GENDER;
    }

    public DatabaseManeger getDbmanager() {
        return dbmanager;
    }

    public String getNAME() {
        return NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getROLENAME() {
        return ROLENAME;
    }

    public String getGENDER() {
        return GENDER;
    }

    public int login(String USERNAME, String PASSWORD) {
        return dbmanager.login(USERNAME, PASSWORD);
    }
    
    public ResultSet getUser(String ROLENAME){
        return dbmanager.getUser(ROLENAME);
    }
    
    public ResultSet viewMemberdata(){
        return dbmanager.viewmembersdata();
    }
    
    public ResultSet SearchMember(needtype nameorid){
    return dbmanager.searchmember(nameorid);
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setROLENAME(String ROLENAME) {
        this.ROLENAME = ROLENAME;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public int getID() {
        return ID;
    }   
}
