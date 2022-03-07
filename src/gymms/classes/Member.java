package gymms.classes;

import gymms.database.DatabaseManeger;

public class Member {
//TODO program in program

    DatabaseManeger dbmanager = new DatabaseManeger();

    private String NAME;
    private int ID, AGE, WEIGHT, HEIGHT;
    private long PHONE;
    private String EMAIL, ADDRESS, GENDER, PROGRAM;

    public Member(String NAME, int AGE, int WEIGHT, int HEIGHT, long PHONE, String EMAIL, String ADDRESS, String GENDER) {
        this.NAME = NAME;
        this.AGE = AGE;
        this.WEIGHT = WEIGHT;
        this.HEIGHT = HEIGHT;
        this.PHONE = PHONE;
        this.EMAIL = EMAIL;
        this.ADDRESS = ADDRESS;
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
        return dbmanager.addmember(NAME, AGE, WEIGHT, HEIGHT, PHONE, EMAIL, ADDRESS, GENDER);
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

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
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

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

}
