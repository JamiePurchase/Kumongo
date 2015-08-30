package network;

import debug.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import users.Account;

public class Server
{
    
    public static boolean checkVersion(int release)
    {
        ArrayList<String> data = request("action=checkversion&release=" + release);
        if(data.get(0).equals("TRUE")) {return true;}
        return false;
    }
    
    public static ArrayList<Account> lobby()
    {
        // DEBUG
        Console.print("SERVER -> LOBBY");
        
        // Create an empty array of accounts
        ArrayList<Account> userArray = new ArrayList();
        
        // TEMP
        int accountID = 1;
        
        // Request lobby data from the server
        ArrayList<String> data = request("action=lobby&accountID=" + accountID);        
        if(data.size() < 1)
        {
            Console.print("null response");
            return null;
        }
        int userCount = Integer.parseInt(data.get(0));
        
        // DEBUG
        Console.print(data.toString());
        
        // Add online users to the array
        if(userCount > 0)
        {
            for(int x = 0; x < userCount; x++)
            {
                String[] userData = data.get(x + 1).split("\\|");
                try
                {
                    Date userOnline = new SimpleDateFormat("dd/MM/yyyy").parse(userData[2]);
                    userArray.add(new Account(Integer.parseInt(userData[0]), userData[1], userOnline, Integer.parseInt(userData[3]), Integer.parseInt(userData[4])));
                }
                catch (ParseException e) {Console.error(e);}
            }
        }
        
        // Return the array of accounts
        return userArray;
    }
    
    private static ArrayList<String> request(String url)
    {
        return NetworkService.request("http://kumongo.co.nf/request.php?" + url);
    }

}