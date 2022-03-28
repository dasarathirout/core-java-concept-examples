package org.concept.lambda.ex20;

public class Employee {

    private int eid;
    private String uname;

    public Employee() {
        this.eid = 0;
        this.uname = "NA";
    }

    public Employee(int eid, String uname) {
        this.eid = eid;
        this.uname = uname;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return " Employee { EID: " + eid + " | UNAME: " + uname + " }";
    }
}
