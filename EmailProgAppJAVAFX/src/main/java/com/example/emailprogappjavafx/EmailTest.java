package com.example.emailprogappjavafx;

public class EmailTest {

    private String IDColumn;
    private String FirstNameColumn;
    private String DepartmentColumn;
    private String EmailColumn;

    public EmailTest(String IDColumn, String FirstNameColumn, String DepartmentColumn, String EmailColumn) {
        this.IDColumn = IDColumn;
      this.FirstNameColumn  = FirstNameColumn;
     this.DepartmentColumn   = DepartmentColumn;
     this.EmailColumn = EmailColumn;
    }

    public String getIDColumn() {
        return IDColumn;
    }

    public void setIDColumn(String IDColumn) {
        this.IDColumn = IDColumn;
    }

    public String getFirstNameColumn() {
        return FirstNameColumn;
    }

    public void setFirstNameColumn(String firstNameColumn) {
        FirstNameColumn = firstNameColumn;
    }

    public String getDepartmentColumn() {
        return DepartmentColumn;
    }

    public void setDepartmentColumn(String departmentColumn) {
        DepartmentColumn = departmentColumn;
    }

    public String getEmailColumn() {
        return EmailColumn;
    }

    public void setEmailColumn(String emailColumn) {
        EmailColumn = emailColumn;
    }
}
