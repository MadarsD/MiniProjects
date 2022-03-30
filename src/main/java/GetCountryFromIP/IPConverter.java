package GetCountryFromIP;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class IPConverter {
    public static void main(String[] args) throws IOException {
        String IPRawData = getCountry();
        JSONObject jsonObject = new JSONObject(IPRawData);
        String city = jsonObject.getString("city");
        String country = jsonObject.getString("country");

        System.out.println("This IP is registered in " + city + "; " + country);

    }

    public static String getCountry() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter and IP address in format xx.xx.xx.xx");
        String ipAddress = scanner.nextLine();
        scanner.close();

        String theURL = ("http://ip-api.com/json/" + ipAddress);
        URL url = new URL(theURL);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder inputData = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            inputData.append(inputLine);
        }

        return inputData.toString();
    }

}
