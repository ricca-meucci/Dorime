/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dorime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author informatica
 */
public class Latire
{
    public static String getAllEmployees()
    {
        String ret = "";
        try {

            URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                                            + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                                                   (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null)
            {
                ret += output;
            }

            conn.disconnect();

        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return ret;
    }
    
    
    public static String getEmployee(int id)
    {
        String ret = "";
        try {

            URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                                            + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                                                   (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null)
            {
                ret += output;
            }

            conn.disconnect();

        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return ret;
    }
    
    
    public static boolean doRequest(String request, String location, String method)
    {
        try
        {

            URL url = new URL(location);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(request.getBytes());
            os.flush();

            if (conn.getResponseCode() >=300)
            {
                throw new RuntimeException("Failed : HTTP error code : "
                                            + conn.getResponseCode());
            }
            conn.disconnect();

        } 
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
}
