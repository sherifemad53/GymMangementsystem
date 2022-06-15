package gymms.classes;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Receptionist extends User {


    public Receptionist() {
    }

    public Receptionist(String FNAME, String LNAME, String EMAIL, String USERNAME, String PASSWORD, int Apt_no, String street, String city, String PHONE, String ROLENAME, String GENDER, String BRANCH) {
        super(FNAME, LNAME, EMAIL, USERNAME, PASSWORD, Apt_no, street, city, PHONE, ROLENAME, GENDER, BRANCH);
    }


    public boolean addmember(Member member, String PACKAGENAME, String USERNAME,String branch) {
        StringTokenizer st = new StringTokenizer(USERNAME," ");
        ArrayList<String> usernamelist = new ArrayList<>();
        while (st.hasMoreTokens()) {  
            usernamelist.add(st.nextToken());  
         }  
        boolean flag = false;
        flag = dbmanager.addmember(member.getFNAME(),member.getLNAME(),member.getBIRTHDATE(), member.getWEIGHT(), member.getHEIGHT(), member.getPHONE(), member.getEMAIL(), member.getApt_no(), member.getStreet(),member.getCity(),member.getGENDER(),branch);
        if (flag) {
            dbmanager.subscribe(usernamelist.get(0),usernamelist.get(1) ,PACKAGENAME, member.getFNAME(),member.getLNAME());
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
         StringTokenizer st = new StringTokenizer(USERNAME," ");
        ArrayList<String> usernamelist = new ArrayList<>();
        while (st.hasMoreTokens()) {  
            usernamelist.add(st.nextToken());  
         }  
        getDbmanager().resubscribe(ROLENAME, usernamelist.get(0),usernamelist.get(1));
    }

    public boolean editmember(Member member) {
        return getDbmanager().editmember(member.getID(), member.getFNAME(),member.getLNAME(),member.getBIRTHDATE(), member.getWEIGHT(), member.getHEIGHT(), member.getPHONE(), member.getEMAIL(), member.getApt_no(), member.getStreet(),member.getCity(), member.getGENDER());
    }

}
