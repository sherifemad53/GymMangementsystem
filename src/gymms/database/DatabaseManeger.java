package gymms.database;

import gymms.Gymms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class DatabaseManeger<neededtype> {

    Connection con = javaconnect.connectdb();
    PreparedStatement ps;
    ResultSet rs;
    int x;
    public boolean addmember(String NAME, int AGE, int WEIGHT, int HEIGHT, long PHONE, String EMAIL, String ADDRESS, String GENDER) {
        //TODO here we can use as method from slides for less sql command 
        String register = "INSERT INTO MEMBERS (MEMBERS_NAME,MEMBERS_AGE,MEMBERS_WEIGHT,MEMBERS_HEIGHT,MEMBERS_PHONE,MEMBERS_EMAIL,MEMBERS_ADDRESS,MEMBERS_GENDER) VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(register);
            if (NAME.isEmpty() || EMAIL.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Missing");
            } else {
                ps.setString(1, NAME);
                ps.setInt(2, AGE);
                ps.setInt(3, WEIGHT);
                ps.setInt(4, HEIGHT);
                ps.setLong(5, PHONE);
                ps.setString(6, EMAIL);
                ps.setString(7, ADDRESS);
                ps.setString(8, GENDER);
                int i = ps.executeUpdate();
                return i > 0;
            }
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
        //DELETE FROM table_name WHERE condition;
        String register = "DELETE FROM MEMBERS WHERE MEMBERS_NAME=?";
        String deletesub = "DELETE FROM SUBSCRIBE WHERE MEMBERID=(SELECT MEMBERS_ID FROM MEMBERS WHERE MEMBERS_NAME=?)";
        try {
            ps = con.prepareStatement(deletesub);
            ps.setString(1, NAME);
            ps.executeUpdate();

            ps = con.prepareStatement(register);
            ps.setString(1, NAME);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public ResultSet searchmember(neededtype nameOrid) {
        String searchid = "SELECT * FROM MEMBERS,SUBSCRIBE,"
                + "PACKAGE WHERE MEMBERS_ID =? AND PACKAGE.PACKAGE_ID = SUBSCRIBE.PACKAGEID"
                + " AND SUBSCRIBE.MEMBERID = MEMBERS.MEMBERS_ID";
        String searchname = "SELECT * FROM MEMBERS,SUBSCRIBE,"
                + "PACKAGE WHERE MEMBERS_NAME =? AND PACKAGE.PACKAGE_ID = SUBSCRIBE.PACKAGEID"
                + " AND SUBSCRIBE.MEMBERID = (SELECT MEMBERS_ID FROM MEMBERS WHERE MEMBERS_NAME=?)";
        try {
            try {
                int id = Integer.valueOf(nameOrid.toString());
                ps = con.prepareStatement(searchid);
                ps.setInt(1, id);
                rs=ps.executeQuery();
                if(rs.next()){
                    return rs;
                }
            } catch (NumberFormatException e) {
                ps = con.prepareStatement(searchname);
                ps.setString(1, nameOrid.toString());
                ps.setString(2, nameOrid.toString());
                rs=ps.executeQuery();
                if(rs.next()){
                    return rs;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public ResultSet viewmembersdata() {
        String viewquery = "SELECT USERS.USERS_NAME,MEMBERS.MEMBERS_ID,MEMBERS.MEMBERS_NAME ,PACKAGE.PACKAGE_NAME,PACKAGE.PACKAGE_COST,SUBSCRIBE.STARTDATE,SUBSCRIBE.ENDDATE,MEMBERS.MEMBERS_PROGRAM "
                + "FROM USERS ,MEMBERS, PACKAGE, SUBSCRIBE "
                + "WHERE SUBSCRIBE.MEMBERID=MEMBERS.MEMBERS_ID AND SUBSCRIBE.USERID=USERS.USERS_ID AND SUBSCRIBE.PACKAGEID=PACKAGE.PACKAGE_ID";
        try {
            ps = con.prepareStatement(viewquery);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public ResultSet viewuserdata() {
        String viewquery = "SELECT USERS.USERS_ID, USERS.USERS_NAME,USERS.USERS_EMAIL ,USERS.USERS_USERNAME ,USERS.USERS_PASSWORD,USERS.USERS_PHONE,USERS.USERS_ADDRESS, ROLE.ROLE_NAME, USERS.USERS_GENDER FROM USERS , ROLE WHERE USERS.ROLEID = ROLE.ROLE_ID ";
        try {
            ps = con.prepareStatement(viewquery);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    public void subscribe(String USERNAME, String PACKAGENAME, String MEMBERNAME) {
        int MEMBERID = 0, USERID = 0, PACKAGEID = 0, PACKAGEDURATION = 0;

        String strMEMBERID = "SELECT MEMBERS_ID FROM MEMBERS WHERE MEMBERS_NAME = '" + MEMBERNAME + "'";
        String strUSERID = "SELECT USERS_ID FROM USERS WHERE USERS_NAME = '" + USERNAME + "'";
        String strPACKAGE = "SELECT PACKAGE_ID,PACKAGE_DURATION FROM PACKAGE WHERE PACKAGE_NAME = '" + PACKAGENAME + "'";
        String sub = "INSERT INTO SUBSCRIBE (MEMBERID,USERID,PACKAGEID,STARTDATE,ENDDATE) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(strMEMBERID);
            rs = ps.executeQuery();
            if (rs.next()) {
                MEMBERID = rs.getInt("MEMBERS_ID");
            }
            ps = con.prepareStatement(strUSERID);
            rs = ps.executeQuery();
            if (rs.next()) {
                USERID = rs.getInt("USERS_ID");
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

    public void resubscribe(String PACKAGENAME, String MEMBERNAME) {
        int MEMBERID = 0, PACKAGEID = 0, PACKAGEDURATION = 0;
        String strMEMBERID = "SELECT MEMBERS_ID FROM MEMBERS WHERE MEMBERS_NAME = '" + MEMBERNAME + "'";
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

    public ResultSet getrole() {
        ResultSet rslocal = null;
        String search = "SELECT * FROM ROLE";
        try {
            ps = con.prepareStatement(search);
            rslocal = ps.executeQuery();
            return rslocal;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rslocal;
    }

    public boolean adduser/*register*/(String NAME, String EMAIL, String USERNAME, String PASSWORD, String CONFPASSWORD, String ADDRESS, long PHONE, String ROLENAME, String GENDER) {
        String register = "INSERT INTO USERS (USERS_NAME,USERS_EMAIL,USERS_USERNAME,USERS_PASSWORD,USERS_ADDRESS,USERS_PHONE,ROLEID,USERS_GENDER) VALUES (?,?,?,?,?,?,?,?) ";
        String role = "SELECT ROLE_ID FROM ROLE WHERE ROLE_NAME = ?";
        PreparedStatement ps2;

        int ROLEID = 0;
        try {
            ps = con.prepareStatement(register);
            ps2 = con.prepareStatement(role);
            if (NAME.isEmpty() || EMAIL.isEmpty() || USERNAME.isEmpty()
                    || PASSWORD.isEmpty() || CONFPASSWORD.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Missing");
            } else {
                if (PASSWORD.equals(CONFPASSWORD)) {
                    ps2.setString(1, ROLENAME);
                    rs = ps2.executeQuery();
                    if (rs.next()) {
                        ROLEID = rs.getInt("ROLE_ID");
                        System.out.println(ROLEID);
                    }
                    ps.setString(1, NAME);
                    ps.setString(2, EMAIL);
                    ps.setString(3, USERNAME);
                    ps.setString(4, PASSWORD);
                    ps.setString(5, ADDRESS);
                    ps.setLong(6, PHONE);
                    ps.setInt(7, ROLEID);
                    ps.setString(8, GENDER);
                    int i = ps.executeUpdate();
                    return i > 0;
                    //JOptionPane.showMessageDialog(null, "resgiter complete");
                    //dispose();
                    //new Mainpage().setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Resgiter failed......");
                } else {
                    JOptionPane.showMessageDialog(null, "Password doesn't match.......");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //System.out.println("Loginfailed");
        }
        return false;
    }

    public int login(String USERNAME, String PASSWORD) {
        String loginn = "SELECT * FROM Users WHERE USERS_USERNAME=? AND USERS_PASSWORD=?";
        try {
            ps = con.prepareStatement(loginn);
            ps.setString(1, USERNAME);
            ps.setString(2, PASSWORD);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ROLEID");
            }
            //JOptionPane.showMessageDialog(null, "Login sucessfull");
            //dispose();
            //new Mainpage().setVisible(true);
            //JOptionPane.showMessageDialog(null, "Login failed.....");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //System.out.println("Loginfailed");
        }
        return 0;
    }

    public ResultSet searchuser(neededtype nameOrid) {
        String searchid = "SELECT * FROM USERS,ROLE WHERE USERS_ID =?";
        String searchname = "SELECT * FROM USERS,ROLE WHERE USERS_NAME =? ";
        try {
            try {
                int id = Integer.valueOf(nameOrid.toString());
                ps = con.prepareStatement(searchid);
                ps.setInt(1, id);
                rs=ps.executeQuery();
                if(rs.next()){
                    return rs;
                }
            } catch (NumberFormatException e) {
                ps = con.prepareStatement(searchname);
                ps.setString(1, nameOrid.toString());
                rs=ps.executeQuery();
               if(rs.next()){
                    return rs;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public ResultSet getUser(String ROLENAME) {
        String search = "SELECT USERS_NAME FROM USERS WHERE ROLEID = (SELECT ROLE_ID FROM ROLE WHERE ROLE_NAME = ?)";
        try {
            ps = con.prepareStatement(search);
            ps.setString(1, ROLENAME);
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

    public boolean editmember(int MEMBERID, String name, int age, int weight, int height, long phone, String email, String address, String gender) {
        String editquery = "UPDATE MEMBERS SET MEMBERS_NAME=?,MEMBERS_AGE=?,MEMBERS_WEIGHT=?,"
                + "MEMBERS_HEIGHT=?,MEMBERS_PHONE=?,MEMBERS_EMAIL=?,MEMBERS_ADDRESS=?,MEMBERS_GENDER=? WHERE MEMBERS_ID=?";
        try {
            ps = con.prepareStatement(editquery);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, weight);
            ps.setInt(4, height);
            ps.setLong(5, phone);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setString(8, gender);
            ps.setInt(9, MEMBERID);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public boolean edituser(int userid, String name, String username, String password, String email, long phone, String address, String gender) {
        String editquery = "UPDATE USERS SET USERS_NAME=?,USERS_USERNAME=?,USERS_PASSWORD=?,"
                + "USERS_EMAIL=?,USERS_PHONE=?,USERS_ADDRESS=?,USERS_GENDER=? WHERE USERS_ID=?";
        try {
            ps = con.prepareStatement(editquery);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setLong(5, phone);
            ps.setString(6, address);
            ps.setString(7, gender);
            ps.setInt(8, userid);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public boolean addbranch(Gymms gymms) {
        String addb = "INSERT INTO GYM (ID,GYM_NAME,TYPE,DESCRIPTION,CITY,STREET) VALUES (?,?,?,?,?,?) ";
        try {
            ps = con.prepareStatement(addb);
            ps.setInt(1, gymms.getID());
            ps.setString(2, gymms.getName());
            ps.setString(3, gymms.getTYPE());
            ps.setString(4, gymms.getDESCRIPTION());
            ps.setString(5, gymms.getCity());
            ps.setInt(6, gymms.getStreet());
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;

    }
}