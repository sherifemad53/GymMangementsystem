package gymms.classes;

public class Trainer extends User {

    public Trainer(String FNAME, String LNAME, String EMAIL, String USERNAME, String PASSWORD, int Apt_no, String street, String city, long PHONE, String ROLENAME, String GENDER) {
        super(FNAME, LNAME, EMAIL, USERNAME, PASSWORD, Apt_no, street, city, PHONE, ROLENAME, GENDER);
    }


    public Trainer()
    {

    }
    ////todo inbody report
    public boolean generateprogram(String name,String program) {
        return getDbmanager().generateProgram(name,program);
    }
}
