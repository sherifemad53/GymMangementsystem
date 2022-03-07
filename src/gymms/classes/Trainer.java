package gymms.classes;

public class Trainer extends User {

    public Trainer(String NAME, String EMAIL, String USERNAME, String PASSWORD, String ADDRESS, int PHONE, String ROLENAME,String GENDER) {
        super(NAME, EMAIL, USERNAME, PASSWORD, ADDRESS, PHONE, ROLENAME,GENDER);
    }

    public Trainer()
    {

    }
    ////todo inbody report
    public boolean generateprogram(String name,String program) {
        return getDbmanager().generateProgram(name,program);
    }
}
