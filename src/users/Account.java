package users;

import java.util.Date;

public class Account
{
    private int accountID;
    private String accountUsername;
    private Date accountOnline;
    private int accountRank, accountScore;
    
    public Account(int id, String username, Date online, int rank, int score)
    {
        this.accountID = id;
        this.accountUsername = username;
        this.accountOnline = online;
        this.accountRank = rank;
        this.accountScore = score;
    }
    
    public String getUsername()
    {
        return this.accountUsername;
    }

}