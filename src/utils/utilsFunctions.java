package utils;

public class utilsFunctions {

    public utilsFunctions() {
    }

    //todo check functions in this class and all functions that doesn't need to be in databse manager
    //like get date 
    public boolean checkname(String name) {
        //todo check for containing number
        boolean flag = true;
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i)) || Character.isSpaceChar(name.charAt(i))) {
                flag = false;
                //JOptionPane.showMessageDialog(null, "hello");
            }
        }
        return name.length() <= 10 && name.length() >= 3 && flag;

    }

    public boolean checkusername(String username) {
        //Username contains number or not upto us to decide??
        boolean flag = true;
        for (int i = 0; i < username.length(); i++) {
            if (Character.isSpaceChar(username.charAt(i))) {
                flag = false;
                //JOptionPane.showMessageDialog(null, "hello");
            }
        }
        return username.length() >= 8 && flag;
    }

    public boolean checkpassword(String password) {
            boolean contains_spaceflag = false, contains_digit = false, contains_upper = false;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isDigit(password.charAt(i))) {
                contains_digit = true;
                // JOptionPane.showMessageDialog(null, "hello");
            }
            if (Character.isSpaceChar(password.charAt(i))) {
                contains_spaceflag = true;
                //JOptionPane.showMessageDialog(null, "hello1");
            }
            
            if (Character.isUpperCase(password.charAt(i))) {
                contains_upper = true;
                //JOptionPane.showMessageDialog(null, "hello1");
            }
        }
        return password.length() >= 8 && contains_digit && contains_upper && !contains_spaceflag;
    }

    public boolean checkpassword(String password, String confpassword) {
        //Username contains number or not upto us to decide??
        boolean contains_spaceflag = false, contains_digit = false, contains_upper = false;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isDigit(password.charAt(i))) {
                contains_digit = true;
                // JOptionPane.showMessageDialog(null, "hello");
            }
            if (Character.isSpaceChar(password.charAt(i))) {
                contains_spaceflag = true;
                //JOptionPane.showMessageDialog(null, "hello1");
            }
            
            if (Character.isUpperCase(password.charAt(i))) {
                contains_upper = true;
                //JOptionPane.showMessageDialog(null, "hello1");
            }
        }
        return password.length() >= 8 && contains_digit && contains_upper && !contains_spaceflag && password.equals(confpassword);
    }

    public boolean checkphone(String phone) {
        boolean contains_spaceflag = false, contains_digit = true;
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                contains_digit = false;
                // JOptionPane.showMessageDialog(null, "hello");
            }
            if (Character.isSpaceChar(phone.charAt(i))) {
                contains_spaceflag = true;
                //JOptionPane.showMessageDialog(null, "hello1");
            }
        }
        return phone.length() == 11 && contains_digit && !contains_spaceflag;
    }

    public boolean checkemail(String email) {
        boolean contains_spaceflag = false, contains_at = false, flag = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                contains_at = true;
                //JOptionPane.showMessageDialog(null, "hello1");
            }
            if (Character.isSpaceChar(email.charAt(i))) {
                contains_spaceflag = true;
                //JOptionPane.showMessageDialog(null, "hello1");
            }
        }
        if (email.contains("yahoo.com") || email.contains("gmail.com") || email.contains("hotmail.com")) {
            flag = true;
        }
        return contains_at && flag && !contains_spaceflag;
    }

    //Todo : edit after datebase
    public boolean checkaddress(String address) {
        return address.length() > 15;
    }

     //Todo : edit after datebase
    public boolean checkage(String age) {
        //Age 0 ---> 99
        return age.length() < 3;
    }

    public boolean checkcost(String cost) {
        boolean contains_spaceflag = false, contains_alpha = false;
        for (int i = 0; i < cost.length(); i++) {
            if (!Character.isDigit(cost.charAt(i))) {
                contains_alpha = true;
                //JOptionPane.showMessageDialog(null, "hello1");
            }
            if (Character.isSpaceChar(cost.charAt(i))) {
                contains_spaceflag = true;
                //JOptionPane.showMessageDialog(null, "hello1");
            }
        }
        return !contains_alpha && !contains_spaceflag;
    }

}
