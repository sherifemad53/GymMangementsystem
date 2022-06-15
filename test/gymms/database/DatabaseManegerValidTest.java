/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymms.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class DatabaseManegerValidTest {
    
    public DatabaseManegerValidTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addmember method, of class DatabaseManeger.
     */
    @Test
    public void testAddmember() {
        System.out.println("addmember");
        String NAME = "mazen";
        int AGE = 22;
        int WEIGHT = 60;
        int HEIGHT = 173;
        String PHONE = "01111909085";
        String EMAIL = "mazen11299@gmail,com";
        String ADDRESS = "53 Elhadayq Cairo";
        String GENDER = "Male";
        DatabaseManeger instance = new DatabaseManeger();
        boolean expResult = true;
        boolean result = instance.addmember(NAME, AGE, WEIGHT, HEIGHT, PHONE, EMAIL, ADDRESS, GENDER);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deletemember method, of class DatabaseManeger.
     */
    @Test
    public void testDeletemember_int() {
        System.out.println("deletemember");
        int ID = 2;
        DatabaseManeger instance = new DatabaseManeger();
        instance.deletemember(ID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deletemember method, of class DatabaseManeger.
     */
    @Test
    public void testDeletemember_String() {
        System.out.println("deletemember");
        String NAME = "omar ahmed";
        DatabaseManeger instance = new DatabaseManeger();
        instance.deletemember(NAME);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of searchmember method, of class DatabaseManeger.
     */
    @Test
    public void testSearchmember() throws SQLException {
        DatabaseManeger instance = new DatabaseManeger();
        System.out.println("searchmember");
        Object nameOrid = "mohamad jeahd";
        boolean res=true;
        ResultSet result = instance.searchmember(nameOrid);
        String[] member= {result.getString("MEMBERS_ID"),result.getString("MEMBERS_NAME"),result.getString("MEMBERS_AGE"),result.getString("MEMBERS_ADDRESS"),result.getString("MEMBERS_EMAIL"),result.getString("MEMBERS_HEIGHT"),result.getString("MEMBERS_WEIGHT"),result.getString("MEMBERS_GENDER"),result.getString("MEMBERS_PROGRAM"),result.getString("MEMBERS_PHONE")};
        String[] expmember={"211","mohamad jeahd","20","nasrCity","m.jehad@gmail.com","173","80","Male","","24128275"};
        boolean expresult=true;
        for (int i = 0; i < 10; i++) {
            if(!expmember[i].equals(member[i]))
                 expresult=false; break;
        }
        assertEquals(expresult,res);


        //fail("The test case is a prototype.");
    }


    /**
     * Test of subscribe method, of class DatabaseManeger.
     */
    @Test
    public void testSubscribe() {
        System.out.println("subscribe");
        String USERNAME = "sherif";
        String PACKAGENAME = "longdur";
        String MEMBERNAME = "mohamad jeahd";
        DatabaseManeger instance = new DatabaseManeger();
        instance.subscribe(USERNAME, PACKAGENAME, MEMBERNAME);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of resubscribe method, of class DatabaseManeger.
     */
    @Test
    public void testResubscribe() {
        System.out.println("resubscribe");
        String PACKAGENAME = "longdur";
        String MEMBERNAME = "mohamad jeahd";
        DatabaseManeger instance = new DatabaseManeger();
        instance.resubscribe(PACKAGENAME, MEMBERNAME);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getrole method, of class DatabaseManeger.
     */

    /**
     * Test of adduser method, of class DatabaseManeger.
     */
    @Test
    public void testAdduser() {
        System.out.println("adduser");
        String NAME = "MohamedAbdo";
        String EMAIL = "mosalah11@gmail.com";
        String USERNAME = "mosalah123";
        String PASSWORD = "Mosalah@123";
        String CONFPASSWORD = "Mosalah@123";
        String ADDRESS = "63 NasrCity Cairo";
        String PHONE = "0123564899";
        String ROLENAME = "owner";
        String GENDER = "Male";
        DatabaseManeger instance = new DatabaseManeger();
        boolean expResult = true;
        boolean result = instance.adduser(NAME, EMAIL, USERNAME, PASSWORD, CONFPASSWORD, ADDRESS, PHONE, ROLENAME, GENDER);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class DatabaseManeger.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String USERNAME = "jk";
        String PASSWORD = "jk";
        DatabaseManeger instance = new DatabaseManeger();
        int expResult = 1;
        int result = instance.login(USERNAME, PASSWORD);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of searchuser method, of class DatabaseManeger.
     */
    @Test
    public void testSearchuser() {
        System.out.println("searchuser");
        Object nameOrid = null;
        DatabaseManeger instance = new DatabaseManeger();
        ResultSet expResult = null;
        ResultSet result = instance.searchuser(nameOrid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }




    /**
     * Test of deleteUser method, of class DatabaseManeger.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        int USERID = 114;
        DatabaseManeger instance = new DatabaseManeger();
        instance.deleteUser(USERID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addpackage method, of class DatabaseManeger.
     */
    @Test
    public void testAddpackage() {
        System.out.println("addpackage");
        String NAME = "package1";
        String DESCRIPTION = "newone";
        int COST = 600;
        int DURATION = 2;
        DatabaseManeger instance = new DatabaseManeger();
        boolean expResult = true;
        boolean result = instance.addpackage(NAME, DESCRIPTION, COST, DURATION);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addMonths method, of class DatabaseManeger.
     */
    @Test
    public void testAddMonths() throws ParseException {
        System.out.println("addMonths");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date today = format1.parse("2022-06-10");
        int monthsToAdd = 2;
        Date expResult = format1.parse("2022-08-10");
        Date result = DatabaseManeger.addMonths(today, monthsToAdd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateProgram method, of class DatabaseManeger.
     */
    @Test
    public void testGenerateProgram() {
        System.out.println("generateProgram");
        Object nameOrid = 211;
        String program = "Push-Pull-Leg";
        DatabaseManeger instance = new DatabaseManeger();
        boolean expResult = true;
        boolean result = instance.generateProgram(nameOrid, program);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editmember method, of class DatabaseManeger.
     */
    @Test
    public void testEditmember() {
        System.out.println("editmember");
        int MEMBERID = 216;
        String name = "ali husen";
        int age = 30;
        int weight = 65;
        int height = 188;
        String phone = "0112233445";
        String email = "alilolo@hotmail.com";
        String address = "66 maadi cairo";
        String gender = "Male";
        DatabaseManeger instance = new DatabaseManeger();
        boolean expResult = true;
        boolean result = instance.editmember(MEMBERID, name, age, weight, height, phone, email, address, gender);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edituser method, of class DatabaseManeger.
     */
    @Test
    public void testEdituser() {
        System.out.println("edituser");
        int userid = 219;
        String name = "mohamad mohamad";
        String username = "ttmohamad";
        String password = "tt5566";
        String email = "mo_h_ma_ad@gmail.com";
        String phone = "0111155561";
        String address = "44 elmarghani cairo";
        String gender = "Male";
        DatabaseManeger instance = new DatabaseManeger();
        boolean expResult = true;
        boolean result = instance.edituser(userid, name, username, password, email, phone, address, gender);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
