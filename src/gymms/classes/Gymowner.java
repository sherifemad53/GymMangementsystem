package gymms.classes;

import gymms.database.DatabaseManeger;
import java.sql.ResultSet;

public class Gymowner extends User{

    public Gymowner(String FNAME, String LNAME, String EMAIL, String USERNAME, String PASSWORD, int Apt_no, String street, String city, long PHONE, String ROLENAME, String GENDER) {
        super(FNAME, LNAME, EMAIL, USERNAME, PASSWORD, Apt_no, street, city, PHONE, ROLENAME, GENDER);
    }
    
    public Gymowner() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getApt_no() {
        return Apt_no;
    }

    public void setApt_no(int Apt_no) {
        this.Apt_no = Apt_no;
    }

    public long getPHONE() {
        return PHONE;
    }

    public void setPHONE(long PHONE) {
        this.PHONE = PHONE;
    }

    public String getFNAME() {
        return FNAME;
    }

    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }

    public String getLNAME() {
        return LNAME;
    }

    public void setLNAME(String LNAME) {
        this.LNAME = LNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getROLENAME() {
        return ROLENAME;
    }

    public void setROLENAME(String ROLENAME) {
        this.ROLENAME = ROLENAME;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }
    
    public boolean adduser(){
        return getDbmanager().adduser(FNAME,LNAME, EMAIL, USERNAME, PASSWORD, PASSWORD, Apt_no, street, city, PHONE,ROLENAME,GENDER);
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
       return getDbmanager().edituser(user.getID(), user.getFNAME(),user.getLNAME(), 
               user.getUSERNAME(), user.getPASSWORD(),user.getEMAIL(), 
               user.getPHONE(), user.getApt_no(), user.getStreet(), user.getCity(), user.getGENDER());
    }
}
