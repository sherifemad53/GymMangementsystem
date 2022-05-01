/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
public class utilsFunctionsTest {
    
    public utilsFunctionsTest() {
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
     * Test of checkname method, of class utilsFunctions.
     */
    @Test
    public void testCheckname() {
        System.out.println("checkname");
        String name = "1mazen";
        utilsFunctions instance = new utilsFunctions();
        boolean expResult = false;
        boolean result = instance.checkname(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkusername method, of class utilsFunctions.
     */
    @Test
    public void testCheckusername() {
        System.out.println("checkusername");
        String username = "5sameh";
        utilsFunctions instance = new utilsFunctions();
        boolean expResult = false;
        boolean result = instance.checkusername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkpassword method, of class utilsFunctions.
     */
    @Test
    public void testCheckpassword_String() {
        System.out.println("checkpassword");
        String password = "mazen1";
        utilsFunctions instance = new utilsFunctions();
        boolean expResult = false;
        boolean result = instance.checkpassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of checkpassword method, of class utilsFunctions.
     */
    @Test
    public void testCheckpassword_String_String() {
        System.out.println("checkpassword");
        String password = "mazen1234";
        String confpassword = "mazen1234";
        utilsFunctions instance = new utilsFunctions();
        boolean expResult = true;
        boolean result = instance.checkpassword(password, confpassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkphone method, of class utilsFunctions.
     */
    @Test
    public void testCheckphone() {
        System.out.println("checkphone");
        String phone = "01111909085";
        utilsFunctions instance = new utilsFunctions();
        boolean expResult = true;
        boolean result = instance.checkphone(phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkemail method, of class utilsFunctions.
     */
    @Test
    public void testCheckemail() {
        System.out.println("checkemail");
        String email = "mazen11299@gmail.com";
        utilsFunctions instance = new utilsFunctions();
        boolean expResult = true;
        boolean result = instance.checkemail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkaddress method, of class utilsFunctions.
     */
    @Test
    public void testCheckaddress() {
        System.out.println("checkaddress");
        String address = "NasrCity";
        utilsFunctions instance = new utilsFunctions();
        boolean expResult = true;
        boolean result = instance.checkaddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkage method, of class utilsFunctions.
     */
    @Test
    public void testCheckage() {
        System.out.println("checkage");
        String age = "0";
        utilsFunctions instance = new utilsFunctions();
        boolean expResult = false;
        boolean result = instance.checkage(age);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkcost method, of class utilsFunctions.
     */
    @Test
    public void testCheckcost() {
        System.out.println("checkcost");
        String cost = "250";
        utilsFunctions instance = new utilsFunctions();
        boolean expResult = true;
        boolean result = instance.checkcost(cost);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
