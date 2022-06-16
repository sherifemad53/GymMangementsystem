package gymms.database;

import gymms.Gymms;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class DatabaseManeger<neededtype> {
    
    Connection con = javaconnect.connectdb();
    PreparedStatement ps;
    ResultSet rs;
    int x;
    
    public boolean addmember(String FNAME, String LNAME, Date BIRTHDATE, int WEIGHT, int HEIGHT, String PHONE, String EMAIL, int Apt_no, String street, String city, String GENDER, String branch) {
        //TODO here we can use as method from slides for less sql command 
        int branid = 0;
        String branchid = "SELECT ID FROM GYM WHERE GYM_NAME=?";
        String register = "INSERT INTO MEMBERS (MEMBERS_FNAME,MEMBERS_LNAME,MEMBERS_BIRTHDATE,MEMBERS_WEIGHT,MEMBERS_HEIGHT,MEMBERS_EMAIL,MEMBERS_APT_NO,MEMBERS_STREET,MEMBERS_CITY,MEMBERS_GENDER,GYM_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String addphone = "INSERT INTO MEMBERPHONE (MEMBERPHONE_ID,PHONE_NUMBER) VALUES (?,?)";
        PreparedStatement ps2;
        try {
            
            ps2 = con.prepareStatement(branchid);
            ps2.setString(1, branch);
            rs = ps2.executeQuery();
            rs.next();
            branid = rs.getInt("ID");
            ps = null;
            ps = con.prepareStatement(register, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, FNAME);
            ps.setString(2, LNAME);
            
            ps.setDate(3, BIRTHDATE);
            ps.setInt(4, WEIGHT);
            ps.setInt(5, HEIGHT);
            
            ps.setString(6, EMAIL);
            ps.setInt(7, Apt_no);
            ps.setString(8, street);
            ps.setString(9, city);
            ps.setString(10, GENDER);
            ps.setInt(11, branid);
            
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            
            ps = con.prepareCall(addphone);
            ps.setInt(1, rs.getInt(1));
            ps.setString(2, PHONE);
            ps.executeUpdate();
            return rs != null;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public void deletemember(int ID) {
        //DELETE FROM table_name WHERE condition;
        String deleteMember = "DELETE FROM MEMBERS WHERE MEMBERS_ID=?";
        String deletesub = "DELETE FROM SUBSCRIBE WHERE MEMBERID=?";
        try {
            ps = con.prepareStatement(deletesub);
            ps.setInt(1, ID);
            ps.executeUpdate();
            ps = con.prepareStatement(deleteMember);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void deletemember(String NAME) {
        StringTokenizer st = new StringTokenizer(NAME, " ");
        ArrayList<String> usernamelist = new ArrayList<>();
        while (st.hasMoreTokens()) {
            usernamelist.add(st.nextToken());
        }
        //DELETE FROM table_name WHERE condition;
        String register = "DELETE FROM MEMBERS WHERE MEMBERS_FNAME = ? AND MEMBERS_LNAME =?";
        String deletesub = "DELETE FROM SUBSCRIBE WHERE MEMBERID=(SELECT MEMBERS_ID FROM MEMBERS WHERE MEMBERS_NAME=?)";
        try {
            ps = con.prepareStatement(deletesub);
            ps.setString(1, NAME);
            ps.executeUpdate();
            
            ps = con.prepareStatement(register);
            ps.setString(1, usernamelist.get(0));
            ps.setString(2, usernamelist.get(1));
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public ResultSet searchmember(neededtype nameOrid) {
        
        String searchid = "SELECT * FROM MEMBERS,SUBSCRIBE,GYM,"
                + "PACKAGE WHERE MEMBERS_ID =? AND PACKAGE.PACKAGE_ID = SUBSCRIBE.PACKAGEID AND GYM.ID = MEMBERS.GYM_ID"
                + " AND SUBSCRIBE.MEMBERID = MEMBERS.MEMBERS_ID";
        String searchname = "SELECT * FROM MEMBERS,SUBSCRIBE,GYM,"
                + "PACKAGE WHERE MEMBERS_FNAME = ? AND MEMBERS_LNAME = ? AND PACKAGE.PACKAGE_ID = SUBSCRIBE.PACKAGEID AND GYM.ID = MEMBERS.GYM_ID"
                + " AND SUBSCRIBE.MEMBERID = (SELECT MEMBERS_ID FROM MEMBERS WHERE MEMBERS_FNAME=? AND MEMBERS_LNAME=?)";
        try {
            try {
                int id = Integer.valueOf(nameOrid.toString());
                ps = con.prepareStatement(searchid);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs;
                }
            } catch (NumberFormatException e) {
                StringTokenizer st = new StringTokenizer(nameOrid.toString(), " ");
                ArrayList<String> usernamelist = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    usernamelist.add(st.nextToken());
                }
                ps = con.prepareStatement(searchname);
                ps.setString(1, usernamelist.get(0));
                ps.setString(2, usernamelist.get(1));
                ps.setString(3, usernamelist.get(0));
                ps.setString(4, usernamelist.get(1));
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public ResultSet viewmembersdata() {
        String viewquery = "SELECT USERS.USERS_FNAME, USERS.USERS_LNAME, MEMBERS.MEMBERS_ID,MEMBERS.MEMBERS_FNAME, "
                + "MEMBERS.MEMBERS_LNAME ,PACKAGE.PACKAGE_NAME,PACKAGE.PACKAGE_COST,SUBSCRIBE.STARTDATE,"
                + "SUBSCRIBE.ENDDATE,MEMBERS.MEMBERS_PROGRAM "
                + "FROM USERS ,MEMBERS, PACKAGE, SUBSCRIBE ,TRAINER ,GYM"
                + " WHERE SUBSCRIBE.MEMBERID = MEMBERS.MEMBERS_ID AND SUBSCRIBE.TRAINER_ID = TRAINER.TRAINER_ID "
                + "AND TRAINER.TRAINER_ID = USERS.USERS_ID AND SUBSCRIBE.PACKAGEID=PACKAGE.PACKAGE_ID AND GYM.ID=USERS.GYM_ID";
        try {
            ps = con.prepareStatement(viewquery);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public ResultSet viewuserdata(String orderby) {
        if (orderby == null) {
            orderby = "USERS_ID";
        }
        String viewquery = "SELECT * FROM USERS ORDER BY " + orderby;
        try {
            ps = con.prepareStatement(viewquery);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public ResultSet getmanager() {
        String getmanagerr = "SELECT  USERS_ID ,USERS_FNAME , USERS_LNAME FROM USERS, GYMMANAGER WHERE USERS.USERS_ID = GYMMANAGER.MANAGER_ID";
        try {
            ps = con.prepareStatement(getmanagerr);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public ResultSet getowner() {
        String getmanagerr = "SELECT  USERS_ID ,USERS_FNAME , USERS_LNAME FROM USERS, GYMOWNER WHERE USERS.USERS_ID = GYMOWNER.OWNER_ID";
        try {
            ps = con.prepareStatement(getmanagerr);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public ResultSet totalusermember(String userormember) {
        String viewquery = null;
        if (userormember.equals("USERS")) {
            viewquery = "SELECT COUNT(*) AS TOTALUSERS FROM USERS ";
        } else if (userormember.equals("MEMBERS")) {
            viewquery = "SELECT COUNT(*) AS TOTALMEMBER FROM MEMBERS ";
        }
        try {
            ps = con.prepareStatement(viewquery);
            rs = ps.executeQuery();
            rs.next();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public void subscribe(String USERFNAME, String USERLNAME, String PACKAGENAME, String MEMBERFNAME, String MEMBERLNAME) {
        int MEMBERID = 0, USERID = 0, PACKAGEID = 0, PACKAGEDURATION = 0;
        
        String strMEMBERID = "SELECT MEMBERS_ID FROM MEMBERS WHERE MEMBERS_FNAME = '" + MEMBERFNAME + "' AND MEMBERS_LNAME = '" + MEMBERLNAME + "'";
        String strUSERID = "SELECT TRAINER_ID FROM USERS,TRAINER WHERE TRAINER.TRAINER_ID = USERS.USERS_ID AND USERS_FNAME = '" + USERFNAME + "' AND USERS_LNAME = '" + USERLNAME + "'";
        String strPACKAGE = "SELECT PACKAGE_ID,PACKAGE_DURATION FROM PACKAGE WHERE PACKAGE_NAME = '" + PACKAGENAME + "'";
        String sub = "INSERT INTO SUBSCRIBE (MEMBERID,TRAINER_ID,PACKAGEID,STARTDATE,ENDDATE) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(strMEMBERID);
            rs = ps.executeQuery();
            if (rs.next()) {
                MEMBERID = rs.getInt("MEMBERS_ID");
            }
            ps = con.prepareStatement(strUSERID);
            rs = ps.executeQuery();
            if (rs.next()) {
                USERID = rs.getInt("TRAINER_ID");
            }
            ps = con.prepareStatement(strPACKAGE);
            rs = ps.executeQuery();
            if (rs.next()) {
                PACKAGEID = rs.getInt("PACKAGE_ID");
                PACKAGEDURATION = rs.getInt("PACKAGE_DURATION");
            }
            ps = con.prepareStatement(sub);
            ps.setInt(1, MEMBERID);
            ps.setInt(2, USERID);
            ps.setInt(3, PACKAGEID);
            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(4, sqlDate);
            date = addMonths(date, PACKAGEDURATION);
            sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(5, sqlDate);
            ps.executeUpdate();
            //return rslocal;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        //return rslocal;
    }
    
    public void resubscribe(String PACKAGENAME, String MEMBERFNAME, String MEMBERLNAME) {
        int MEMBERID = 0, PACKAGEID = 0, PACKAGEDURATION = 0;
        String strMEMBERID = "SELECT MEMBERS_ID FROM MEMBERS WHERE MEMBERS_NAME = '" + MEMBERFNAME + "' AND MEMBERS_LNAME = '" + MEMBERLNAME + "'";
        String strPACKAGE = "SELECT PACKAGE_ID,PACKAGE_DURATION FROM PACKAGE WHERE PACKAGE_NAME = '" + PACKAGENAME + "'";
        String sub = "UPDATE SUBSCRIBE SET PACKAGEID=? ,STARTDATE=?,ENDDATE=? WHERE MEMBERID=?";
        try {
            ps = con.prepareStatement(strMEMBERID);
            rs = ps.executeQuery();
            if (rs.next()) {
                MEMBERID = rs.getInt("MEMBERS_ID");
            }
            ps = con.prepareStatement(strPACKAGE);
            rs = ps.executeQuery();
            if (rs.next()) {
                PACKAGEID = rs.getInt("PACKAGE_ID");
                PACKAGEDURATION = rs.getInt("PACKAGE_DURATION");
            }
            ps = con.prepareStatement(sub);
            ps.setInt(1, PACKAGEID);
            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(2, sqlDate);
            date = addMonths(date, PACKAGEDURATION);
            sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(3, sqlDate);
            ps.setInt(4, MEMBERID);
            ps.executeUpdate();
            //return rslocal;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        //return rslocal;
    }
    
    public boolean adduser/*register*/(String FNAME, String LNAME, String EMAIL, String USERNAME, String PASSWORD, String CONFPASSWORD, int Apt_no, String street, String city, String PHONE, String JOBTYPE, String GENDER, String BRANCH, String temp, int managerid) {
        String branchid = "SELECT ID FROM GYM WHERE GYM_NAME=?";
        String register = "INSERT INTO USERS (USERS_FNAME,USERS_LNAME,USERS_EMAIL,USERS_USERNAME,USERS_PASSWORD,USERS_APT_NO,USERS_STREET,USERS_CITY,USERS_GENDER,USERS_JOBTYPE,GYM_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String addphone = "INSERT INTO USERPHONE (USERPHONE_ID,PHONE_NUMBER) VALUES (?,?)";
        String insertindisjointtables = null, assignManagaer = null, addtomanage = null;
        PreparedStatement ps2;
        int branid, genereatedid;
        try {
            ps2 = con.prepareStatement(branchid);
            ps2.setString(1, BRANCH);
            rs = ps2.executeQuery();
            rs.next();
            branid = rs.getInt("ID");
            ps = null;
            ps = con.prepareStatement(register, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, FNAME);
            ps.setString(2, LNAME);
            ps.setString(3, EMAIL);
            ps.setString(4, USERNAME);
            ps.setString(5, PASSWORD);
            ps.setInt(6, Apt_no);
            ps.setString(7, street);
            ps.setString(8, city);
            ps.setString(9, GENDER);
            ps.setString(10, JOBTYPE);
            ps.setInt(11, branid);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            genereatedid = rs.getInt(1);
            
            ps = con.prepareStatement(addphone);
            ps.setInt(1, genereatedid);
            ps.setString(2, PHONE);
            ps.executeUpdate();
            switch (JOBTYPE) {
                case "TRAINER":
                    insertindisjointtables = "INSERT INTO TRAINER (TRAINER_ID,EXPERIENCE_YEARS) VALUES (?,?)";
                    addtomanage = "INSERT INTO MANAGE (GYM_ID,USERS_ID,MANAGER_ID) VALUES(?,?,?)";
                    ps = con.prepareStatement(addtomanage);
                    ps.setInt(1, branid);
                    ps.setInt(2, genereatedid);
                    ps.setInt(3, managerid);
                    ps.executeUpdate();
                    break;
                case "GYMOWNER":
                    insertindisjointtables = "INSERT INTO GYMOWNER (OWNER_ID,PERCENTAGE_CUT) VALUES (?,?)";
                    break;
                case "GYMMANAGER":
                    insertindisjointtables = "INSERT INTO GYMMANAGER (MANAGER_ID,GYMMANAGER_SALARY) VALUES (?,?)";
                    break;
                case "RECEPTIONIST":
                    insertindisjointtables = "INSERT INTO RECEPTIONIST (RECEPTIONIST_ID,SHIFT) VALUES (?,?)";
                    addtomanage = "INSERT INTO MANAGE (GYM_ID,USERS_ID,MANAGER_ID) VALUES(?,?,?)";
                    ps = con.prepareStatement(addtomanage);
                    ps.setInt(1, branid);
                    ps.setInt(2, genereatedid);
                    ps.setInt(3, managerid);
                    ps.executeUpdate();
                    break;
                default:
                    break;
            }
            
            ps = null;
            ps = con.prepareStatement(insertindisjointtables);
            ps.setInt(1, genereatedid);
            ps.setInt(2, Integer.parseInt(temp));
            ps.executeUpdate();
            
            return rs != null;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    //1 for GYMOWNER 2 for TRAINER 3 for RECEPTIONIST 4 for GYMMANAGER
    public int login(String USERNAME, String PASSWORD) {
        String loginn = "SELECT * FROM Users WHERE USERS_USERNAME=? AND USERS_PASSWORD=?";
        String temp;
        try {
            ps = con.prepareStatement(loginn);
            ps.setString(1, USERNAME);
            ps.setString(2, PASSWORD);
            rs = ps.executeQuery();
            if (rs.next()) {
                temp = rs.getString("USERS_JOBTYPE");
                System.out.println(temp);
                if ("GYMOWNER".equals(temp)) {
                    return 1;
                }
                if ("TRAINER".equals(temp)) {
                    return 2;
                }
                if ("RECEPTIONIST".equals(temp)) {
                    return 3;
                }
                if ("GYMMAMAGER".equals(temp)) {
                    return 4;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }
    
    public ResultSet searchuser(neededtype nameOrid) {
        String searchid = "SELECT * FROM USERS,GYM WHERE USERS_ID =? AND GYM.ID=USERS.GYM_ID";
        String searchname = "SELECT * FROM USERS,GYM WHERE USERS_FNAME = ? AND USERS_LNAME = ? AND GYM.ID=USERS.GYM_ID";
        try {
            try {
                int id = Integer.valueOf(nameOrid.toString());
                ps = con.prepareStatement(searchid);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs;
                }
            } catch (NumberFormatException e) {
                StringTokenizer st = new StringTokenizer(nameOrid.toString(), " ");
                ArrayList<String> usernamelist = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    usernamelist.add(st.nextToken());
                }
                
                ps = con.prepareStatement(searchname);
                ps.setString(1, usernamelist.get(0));
                ps.setString(2, usernamelist.get(1));
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
    public ResultSet getUser(String JOBTYPE) {
        String search = "SELECT USERS_FNAME, USERS_LNAME FROM USERS WHERE USERS_JOBTYPE = ?";
        try {
            ps = con.prepareStatement(search);
            ps.setString(1, JOBTYPE);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
    
    public ResultSet getpackage() {
        String search = "SELECT PACKAGE_NAME FROM PACKAGE ";
        try {
            ps = con.prepareStatement(search);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
    
    public void deleteUser(int USERID) {
        String register = "DELETE FROM USERS WHERE USERS_ID=?";
        try {
            ps = con.prepareStatement(register);
            ps.setInt(1, USERID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public boolean addpackage(String NAME, String DESCRIPTION, int COST, int DURATION) {
        String addpack = "INSERT INTO PACKAGE (PACKAGE_NAME,PACKAGE_DESCRIPTION,PACKAGE_COST,PACKAGE_DURATION) VALUES (?,?,?,?) ";
        PreparedStatement ps2;
        int ROLEID = 0;
        try {
            ps = con.prepareStatement(addpack);
            if (NAME.isEmpty() || DESCRIPTION.isEmpty() || COST == 0
                    || DURATION == 0) {
                JOptionPane.showMessageDialog(null, "Missing");
            } else {
                ps.setString(1, NAME);
                ps.setString(2, DESCRIPTION);
                ps.setInt(3, COST);
                ps.setInt(4, DURATION);
                int i = ps.executeUpdate();
                return i > 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public static java.util.Date addMonths(java.util.Date today, int monthsToAdd) {
        if (today != null) {
            java.util.Calendar c = java.util.Calendar.getInstance();
            c.setTime(today);
            c.add(Calendar.MONTH, monthsToAdd);
            return c.getTime();
        } else {
            return null;
        }
    }
    
    public boolean generateProgram(neededtype nameOrid, String program) {
        //UPDATE table_name SET name=@name, email=@email, phone=@phone WHERE client_id=@client_id
        String addprogramid = "UPDATE MEMBERS SET MEMBERS_PROGRAM=? WHERE MEMBERS_ID=? ";
        String addprogramname = "UPDATE MEMBERS SET MEMBERS_PROGRAM=? WHERE MEMBERS_NAME=?  ";
        try {
            if (program.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Missing");
            } else {
                try {
                    int id = Integer.valueOf(nameOrid.toString());
                    ps = con.prepareStatement(addprogramid);
                    ps.setString(1, program);
                    ps.setInt(2, id);
                } catch (NumberFormatException e) {
                    ps = con.prepareStatement(addprogramname);
                    ps.setString(1, program);
                    ps.setString(2, nameOrid.toString());
                }
            }
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public boolean memberaddphone(int ID, String phone) {
        String addphone = "INSERT INTO MEMBERPHONE (MEMBERPHONE_ID,PHONE_NUMBER) VALUES (?,?) ";
        try {
            ps = con.prepareStatement(addphone);
            ps.setInt(1, ID);
            ps.setString(2, phone);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public boolean useraddphone(int ID, String phone) {
        String addphone = "INSERT INTO USERPHONE (USERPHONE_ID,PHONE_NUMBER) VALUES (?,?) ";
        try {
            ps = con.prepareStatement(addphone);
            ps.setInt(1, ID);
            ps.setString(2, phone);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
 
    
    public boolean editmember(int MEMBERID, String fname, String lname, Date birthdate, int weight, int height, String phone, String email, int Apt_no, String street, String city, String gender) {
        String editquery = "UPDATE MEMBERS SET MEMBERS_FNAME=?,MEMBERS_LNAME=?,MEMBERS_AGE=?,MEMBERS_WEIGHT=?,"
                + "MEMBERS_HEIGHT=?,MEMBERS_EMAIL=?,MEMBERS_APT_NO=?,MEMBERS_STREET=?,MEMBERS_CITY=?,MEMBERS_GENDER=? WHERE MEMBERS_ID=?";
        try {
            ps = con.prepareStatement(editquery);
            ps.setString(1, fname);
            ps.setString(2, lname);
            
            ps.setDate(3, birthdate);
            ps.setInt(4, weight);
            ps.setInt(5, height);
            //ps.setString(6, phone);
            ps.setString(6, email);
            ps.setInt(7, Apt_no);
            ps.setString(8, street);
            ps.setString(9, city);
            ps.setString(10, gender);
            ps.setInt(11, MEMBERID);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public boolean edituser(int userid, String fname, String lname, String username, String password, String email, String phone, int Apt_no, String street, String city, String gender) {
        String editquery = "UPDATE USERS SET USERS_FNAME=?,USERS_LNAME=?, ,USERS_USERNAME=?,USERS_PASSWORD=?,"
                + "USERS_EMAIL=?,USERS_PHONE=?,USERS_ADDRESS=?,USERS_GENDER=? WHERE USERS_ID=?";
        try {
            ps = con.prepareStatement(editquery);
            ps.setString(1, fname);
            ps.setString(2, lname);
            
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setInt(7, Apt_no);
            ps.setString(8, street);
            ps.setString(9, city);
            ps.setString(10, gender);
            ps.setInt(11, userid);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public boolean addbranch(Gymms gymms) {
        String addb = "INSERT INTO GYM (ID,GYM_NAME,TYPE,DESCRIPTION,CITY,STREET,OWNER_ID) VALUES (?,?,?,?,?,?,?) ";
        try {
            ps = con.prepareStatement(addb);
            ps.setInt(1, gymms.getID());
            ps.setString(2, gymms.getName());
            ps.setString(3, gymms.getTYPE());
            ps.setString(4, gymms.getDESCRIPTION());
            ps.setString(5, gymms.getCity());
            ps.setString(6, gymms.getStreet());
            ps.setInt(7, gymms.getOWNERID());
            
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
        
    }
    
    public ResultSet getbranch() {
        String search = "SELECT GYM_NAME FROM GYM ";
        try {
            ps = con.prepareStatement(search);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }

    public ResultSet viewfrom() {
        String search = "SELECT * FROM TOTJOBINBRAN  ";
        try {
            ps = con.prepareStatement(search);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public ResultSet getphone(String userormember, int id) {
        String search = null;
        if (userormember.equals("MEMBERS")) {
            search = "SELECT * FROM MEMBERPHONE WHERE MEMBERPHONE_ID = ? ";
        } else if (userormember.equals("USERS")) {
            search = "SELECT * FROM USERPHONE WHERE USERPHONE_ID = ? ";
        }
        
        try {
            ps = con.prepareStatement(search);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
    
}
