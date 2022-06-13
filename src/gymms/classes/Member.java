package gymms.classes;

import gymms.database.DatabaseManeger;
import java.sql.Date;

public class Member {
//TODO program in program

    DatabaseManeger dbmanager = new DatabaseManeger();

    private String FNAME,LNAME;
    private int ID,WEIGHT, HEIGHT,Apt_no;
    Date BIRTHDATE;
    private long PHONE;
    private String EMAIL, street,city, GENDER, PROGRAM;

    public Member(String FNAME,String LNAME, Date BIRTHDATE, int WEIGHT, int HEIGHT, long PHONE, String EMAIL, int Apt_no, String street, String city, String GENDER) {
        this.FNAME = FNAME;
        this.LNAME = LNAME;
        
        this.BIRTHDATE = BIRTHDATE;
        this.WEIGHT = WEIGHT;
        this.HEIGHT = HEIGHT;
        this.PHONE = PHONE;
        this.EMAIL = EMAIL;
        this.Apt_no = Apt_no;
        this.street = street;
        this.city = city;
        this.GENDER = GENDER;
    }

    public boolean generateProgram(String PROGRAM, String NAME) {
        return dbmanager.generateProgram(PROGRAM, NAME);
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public void setPROGRAM(String PROGRAM) {
        this.PROGRAM = PROGRAM;
    }

    public String getPROGRAM() {
        return PROGRAM;
    }

    public Member() {
    }

    public String getGENDER() {
        return GENDER;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public boolean addmember() {
        return dbmanager.addmember(FNAME,LNAME,BIRTHDATE, WEIGHT, HEIGHT, PHONE, EMAIL, Apt_no, street, city, GENDER);
    }

    //overloading 
    public void deletemember(int ID) {
        dbmanager.deletemember(ID);
    }

    public void deletemember(String NAME) {
        dbmanager.deletemember(NAME);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public Date getBIRTHDATE() {
        return BIRTHDATE;
    }

    public void setBIRTHDATE(Date BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
    }


    public int getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(int WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public long getPHONE() {
        return PHONE;
    }

    public void setPHONE(long PHONE) {
        this.PHONE = PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
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


}
