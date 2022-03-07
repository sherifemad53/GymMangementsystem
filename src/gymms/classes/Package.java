package gymms.classes;

import gymms.database.DatabaseManeger;
import java.sql.ResultSet;

public class Package {

    private int ID, COST, DURATION;
    private String NAME, DESCRIPTION;

    DatabaseManeger dbmanager = new DatabaseManeger();

    public Package() {
    }

    public Package(String NAME,String DESCRIPTION,int COST, int DURATION) {
        this.COST = COST;
        this.DURATION = DURATION;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
    }

    public boolean addpackage(String NAME, String DESCRIPTION, int COST, int DURATION) {
        return dbmanager.addpackage(NAME, DESCRIPTION, COST, DURATION);
    }

    public ResultSet getpackage() {
        return dbmanager.getpackage();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCOST() {
        return COST;
    }

    public void setCOST(int COST) {
        this.COST = COST;
    }

    public int getDURATION() {
        return DURATION;
    }

    public void setDURATION(int DURATION) {
        this.DURATION = DURATION;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

}
