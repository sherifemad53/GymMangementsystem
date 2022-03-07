package gymms.classes;

public class Role {
    
    
    private int ID;
    private String NAME,DESCRIPTION;

    public Role(String NAME, String DESCRIPTION) {
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
    }
    
    //gymowner can add new role
    public void addNewRole(){
    }

    public int getID() {
        return ID;
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
