package gymms.classes;

import gymms.database.DatabaseManeger;
import java.sql.ResultSet;

public class User<needtype> {

    DatabaseManeger dbmanager = new DatabaseManeger();

    protected int ID, Apt_no;
    protected String PHONE;
    protected String FNAME, LNAME, EMAIL, USERNAME, PASSWORD, street, city, ROLENAME, GENDER, BRANCH;

    public User() {
    }



    public User(String FNAME, String LNAME, String EMAIL, String USERNAME, String PASSWORD, int Apt_no, String street, String city, String PHONE, String ROLENAME, String GENDER, String BRANCH) {
        this.PHONE = PHONE;
        this.FNAME = FNAME;
        this.FNAME = FNAME;
        this.EMAIL = EMAIL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.Apt_no = Apt_no;
        this.street = street;
        this.city = city;
        this.ROLENAME = ROLENAME;
        this.GENDER = GENDER;
        this.BRANCH = BRANCH;
    }

    public String getBRANCH() {
        return BRANCH;
    }

    public void setBRANCH(String BRANCH) {
        this.BRANCH = BRANCH;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public DatabaseManeger getDbmanager() {
        return dbmanager;
    }

    public String getFNAME() {
        return FNAME;
    }

    public String getLNAME() {
        return LNAME;
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

    public String getROLENAME() {
        return ROLENAME;
    }

    public String getGENDER() {
        return GENDER;
    }

    public int login(String USERNAME, String PASSWORD) {
        return dbmanager.login(USERNAME, PASSWORD);
    }

    public ResultSet getUser(String ROLENAME) {
        return dbmanager.getUser(ROLENAME);
    }

    public ResultSet viewMemberdata() {
        return dbmanager.viewmembersdata();
    }

    public ResultSet SearchMember(needtype nameorid) {
        
        return dbmanager.searchmember(nameorid);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }

    public void setLNAME(String LNAME) {
        this.LNAME = LNAME;
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

    public int getApt_no() {
        return Apt_no;
    }

    public void setApt_no(int Apt_no) {
        this.Apt_no = Apt_no;
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
