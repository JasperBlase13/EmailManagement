package com.example.emailprogappjavafx;

public class Email{
    private String FirstName;
    private String LastName;
    private String department;

    private String password;

    private String email;

    private static int EmailAccountsCapacity = 0;

    private String ID;







    Email(String fname, String lname, String department)
    {
        this.FirstName = fname;
        this.LastName = lname;
        this.department = department;
        this.password = setPassword();
        this.email = fname.toLowerCase() + "." + lname.toLowerCase() + "@" + department.toLowerCase() + "." + "company.com";
        this.ID = generateID();
        EmailAccountsCapacity++;

    }

    public static int EmailAccountsCheck()
    {
        return EmailAccountsCapacity;
    }
    private String setPassword()
    {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%";
        char[] newPassword = new char[8];
        for(int i=0; i<newPassword.length; i++)
        {
            int rand = (int) (Math.random() * passwordSet.length());
            newPassword[i] = passwordSet.charAt(rand);
        }
        return new String(newPassword);
    }

    public String generateID()
    {
        int max = 800;
        int min = 100;
        int val = (int) (Math.random() * ((max-min)-1) - min);
        String addedzeroes = String.format("%05d", val);
        return addedzeroes;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public static void resetMailCapacity()
    {
        EmailAccountsCapacity=0;
    }
}

/*
class EmailObjectInitializer
{
       private Email[] storeEmail = new Email[4];




        public boolean checkCapacity()
        {
            boolean isAvailable;
            if(Email.EmailAccountsCheck() < 4)
            {
                isAvailable = true;
            }
            else
            {
                isAvailable = false;
            }

            return isAvailable;
        }



        public void createEmail(String fname, String lname, String Department)
        {

            boolean isAvailable = checkCapacity();
            int index = Email.EmailAccountsCheck();
            if(isAvailable)
            {
               storeEmail[index] = new Email(fname, lname, Department);
               CallEmail();

            }




        }

        public void CallEmail()
        {
            Email.increaseEmailCapacity();
        }

        public String getfname()
        {
            String fname;
            fname = storeEmail[2].getfName();
                    return fname;
        }





}
*/
