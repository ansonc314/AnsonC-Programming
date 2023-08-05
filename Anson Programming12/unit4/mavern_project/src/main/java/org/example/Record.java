package org.example;

public class Record {
    private String userName, password, lastUpdated, group, comments;  // fields in each record
    /**
     * record[0]  = userName, record[1]  = password, record[2]  = lastUpdated, record[3]  = group, record[5]  = comments
     */
    public String[] record = new String[5];


    /**
     * Default Constructor
     */
    public Record(){
    }

    /**
     * Constructor
     * @param userName
     * @param password
     */
    public Record(String userName, String password){
        setRecordSimple(userName,password);
    }

    /**
     * Constructor
     * @param userName
     * @param password
     * @param lastUpdated
     * @param group
     * @param comments
     */
    public Record(String userName, String password, String lastUpdated, String group , String comments) {
        setRecord(userName, password, lastUpdated, group ,comments);
    }

    public String toString(){
        String output;
        output = "User Name: " + this.userName + "\n" ;
        output = output + "Password: " + this.password+ "\n" ;
        output = output + "Last Updated: " + this.lastUpdated+ "\n" ;
        output = output + "Group: " + this.group+ "\n" ;
        output = output + "Comments: " + this.comments+ "\n" ;
        return output;
    }

    public String[] getRecord(){
        String[] out = new String[5];
        out[0]  = userName;
        out[1]  = password;
        out[2]  = lastUpdated;
        out[3]  = group;
        out[4]  = comments;
        return out;
    }

    public void setRecord(String userName, String password, String lastUpdated, String group , String comments) {
        record[0] = this.userName = userName;
        record[1] = this.password = password;
        record[2] = this.lastUpdated = lastUpdated;
        record[3] = this.group = group;
        record[4] = this.comments = comments;
    }
    public void setRecordSimple(String userName, String password) {
        record[0] = this.userName = userName;
        record[1] = this.password = password;
    }




}
