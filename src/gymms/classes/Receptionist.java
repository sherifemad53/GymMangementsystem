package gymms.classes;

public class Receptionist extends User {

    public Receptionist(String NAME, String EMAIL, String USERNAME, String PASSWORD, String ADDRESS, int PHONE, String ROLENAME, String GENDER) {
        super(NAME, EMAIL, USERNAME, PASSWORD, ADDRESS, PHONE, ROLENAME, GENDER);
    }

    public Receptionist() {
    }

    public boolean addmember(Member member, String PACKAGENAME, String USERNAME) {
        boolean flag = false;
        flag = dbmanager.addmember(member.getNAME(), member.getAGE(), member.getWEIGHT(), member.getHEIGHT(), member.getPHONE(), member.getEMAIL(), member.getADDRESS(), member.getGENDER());
        if (flag) {
            dbmanager.subscribe(USERNAME, PACKAGENAME, member.getNAME());
        }
        return flag;
    }

    public void deletemember(int MEMBERID) {
        Member member = new Member();
        member.deletemember(MEMBERID);
    }

    public void deletemember(String MEMBERNAME) {
        Member member = new Member();
        member.deletemember(MEMBERNAME);
    }

    public void resubscribe(String ROLENAME, String MEMBERNAME) {
        getDbmanager().resubscribe(ROLENAME, MEMBERNAME);
    }

    public boolean editmember(Member member) {
        return getDbmanager().editmember(member.getID(), member.getNAME(), member.getAGE(), member.getWEIGHT(), member.getHEIGHT(), member.getPHONE(), member.getEMAIL(), member.getADDRESS(), member.getGENDER());
    }

}
