package iceCreamOrderPoster.run;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.script.ScriptException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import iceCreamOrderPoster.httpService.SendHttpRequest;

public class Main {

	public static void main(String[] args) throws ClientProtocolException, IOException, ParseException, ScriptException, InterruptedException {
		// TODO Auto-generated method stub
		
		//this json object holds the random names that can be generated
		String json = "[{\"first_name\":\"Amy\",\"last_name\":\"Hart\"},{\"first_name\":\"Johnny\",\"last_name\":\"Little\"},{\"first_name\":\"Joseph\",\"last_name\":\"Bryant\"},{\"first_name\":\"Victor\",\"last_name\":\"Stone\"},{\"first_name\":\"Barbara\",\"last_name\":\"Williams\"},{\"first_name\":\"Ann\",\"last_name\":\"Gutierrez\"},{\"first_name\":\"Sean\",\"last_name\":\"Johnson\"},{\"first_name\":\"Craig\",\"last_name\":\"Richards\"},{\"first_name\":\"Helen\",\"last_name\":\"Gonzales\"},{\"first_name\":\"Phillip\",\"last_name\":\"Lane\"},{\"first_name\":\"James\",\"last_name\":\"Lawrence\"},{\"first_name\":\"Albert\",\"last_name\":\"Arnold\"},{\"first_name\":\"George\",\"last_name\":\"Alexander\"},{\"first_name\":\"Phyllis\",\"last_name\":\"Wallace\"},{\"first_name\":\"Kevin\",\"last_name\":\"Armstrong\"},{\"first_name\":\"Wanda\",\"last_name\":\"Rivera\"},{\"first_name\":\"Ralph\",\"last_name\":\"Oliver\"},{\"first_name\":\"Johnny\",\"last_name\":\"Ramirez\"},{\"first_name\":\"Peter\",\"last_name\":\"Stone\"},{\"first_name\":\"Diana\",\"last_name\":\"Day\"},{\"first_name\":\"Christina\",\"last_name\":\"Parker\"},{\"first_name\":\"Juan\",\"last_name\":\"Shaw\"},{\"first_name\":\"Ashley\",\"last_name\":\"Rose\"},{\"first_name\":\"Mark\",\"last_name\":\"Mitchell\"},{\"first_name\":\"Jane\",\"last_name\":\"Garrett\"},{\"first_name\":\"Mark\",\"last_name\":\"Williams\"},{\"first_name\":\"Carolyn\",\"last_name\":\"Patterson\"},{\"first_name\":\"Bruce\",\"last_name\":\"Grant\"},{\"first_name\":\"Cheryl\",\"last_name\":\"Griffin\"},{\"first_name\":\"Paul\",\"last_name\":\"Roberts\"},{\"first_name\":\"Johnny\",\"last_name\":\"Holmes\"},{\"first_name\":\"Nicholas\",\"last_name\":\"Alexander\"},{\"first_name\":\"Betty\",\"last_name\":\"Alexander\"},{\"first_name\":\"Craig\",\"last_name\":\"Day\"},{\"first_name\":\"Catherine\",\"last_name\":\"Martinez\"},{\"first_name\":\"Bruce\",\"last_name\":\"Reid\"},{\"first_name\":\"Anthony\",\"last_name\":\"Burton\"},{\"first_name\":\"Annie\",\"last_name\":\"Flores\"},{\"first_name\":\"Katherine\",\"last_name\":\"Scott\"},{\"first_name\":\"Kimberly\",\"last_name\":\"Mendoza\"},{\"first_name\":\"Joseph\",\"last_name\":\"Schmidt\"},{\"first_name\":\"Gerald\",\"last_name\":\"Arnold\"},{\"first_name\":\"Jack\",\"last_name\":\"Fisher\"},{\"first_name\":\"Emily\",\"last_name\":\"Thomas\"},{\"first_name\":\"Mildred\",\"last_name\":\"Mcdonald\"},{\"first_name\":\"Carl\",\"last_name\":\"Harper\"},{\"first_name\":\"Anne\",\"last_name\":\"Bradley\"},{\"first_name\":\"Debra\",\"last_name\":\"Washington\"},{\"first_name\":\"Matthew\",\"last_name\":\"Burton\"},{\"first_name\":\"Russell\",\"last_name\":\"Mitchell\"},{\"first_name\":\"Henry\",\"last_name\":\"Shaw\"},{\"first_name\":\"Elizabeth\",\"last_name\":\"Hicks\"},{\"first_name\":\"Ashley\",\"last_name\":\"Garcia\"},{\"first_name\":\"Jose\",\"last_name\":\"Campbell\"},{\"first_name\":\"Edward\",\"last_name\":\"Ramos\"},{\"first_name\":\"Shirley\",\"last_name\":\"Chapman\"},{\"first_name\":\"Linda\",\"last_name\":\"Johnston\"},{\"first_name\":\"Kathryn\",\"last_name\":\"Rodriguez\"},{\"first_name\":\"Peter\",\"last_name\":\"George\"},{\"first_name\":\"Ernest\",\"last_name\":\"Hudson\"},{\"first_name\":\"Adam\",\"last_name\":\"Andrews\"},{\"first_name\":\"Betty\",\"last_name\":\"Burton\"},{\"first_name\":\"Rachel\",\"last_name\":\"Stevens\"},{\"first_name\":\"Brian\",\"last_name\":\"Anderson\"},{\"first_name\":\"Joseph\",\"last_name\":\"Ramos\"},{\"first_name\":\"Kimberly\",\"last_name\":\"Ellis\"},{\"first_name\":\"Louis\",\"last_name\":\"King\"},{\"first_name\":\"Marie\",\"last_name\":\"Tucker\"},{\"first_name\":\"Adam\",\"last_name\":\"King\"},{\"first_name\":\"Samuel\",\"last_name\":\"Ruiz\"},{\"first_name\":\"Susan\",\"last_name\":\"Welch\"},{\"first_name\":\"Gary\",\"last_name\":\"Reid\"},{\"first_name\":\"Laura\",\"last_name\":\"Hawkins\"},{\"first_name\":\"Norma\",\"last_name\":\"Wilson\"},{\"first_name\":\"Henry\",\"last_name\":\"Tannembauer\"},{\"first_name\":\"Dennis\",\"last_name\":\"Olson\"},{\"first_name\":\"Anne\",\"last_name\":\"Russell\"},{\"first_name\":\"Kathleen\",\"last_name\":\"George\"},{\"first_name\":\"Shirley\",\"last_name\":\"Fisher\"},{\"first_name\":\"Pamela\",\"last_name\":\"Perry\"},{\"first_name\":\"Johnny\",\"last_name\":\"Butler\"},{\"first_name\":\"Julie\",\"last_name\":\"Mendoza\"},{\"first_name\":\"Chris\",\"last_name\":\"Lane\"},{\"first_name\":\"Patricia\",\"last_name\":\"Hill\"},{\"first_name\":\"Susan\",\"last_name\":\"Wagner\"},{\"first_name\":\"Annie\",\"last_name\":\"Meyer\"},{\"first_name\":\"Ann\",\"last_name\":\"Myers\"},{\"first_name\":\"Pamela\",\"last_name\":\"Kelly\"},{\"first_name\":\"Laura\",\"last_name\":\"Richardson\"},{\"first_name\":\"Michelle\",\"last_name\":\"Black\"},{\"first_name\":\"Melissa\",\"last_name\":\"Franklin\"},{\"first_name\":\"Frances\",\"last_name\":\"Ferguson\"},{\"first_name\":\"Tammy\",\"last_name\":\"Carter\"},{\"first_name\":\"Antonio\",\"last_name\":\"James\"},{\"first_name\":\"Bruce\",\"last_name\":\"Butler\"},{\"first_name\":\"Maria\",\"last_name\":\"Nguyen\"},{\"first_name\":\"Barbara\",\"last_name\":\"Sullivan\"},{\"first_name\":\"Joe\",\"last_name\":\"Reynolds\"},{\"first_name\":\"Peter\",\"last_name\":\"Griffin\"},{\"first_name\":\"Carl\",\"last_name\":\"Ramirez\"}]";
		//here are the flavor codes that will be randomly assigned
		String flavors = "[{\"label\":\"All Natural - Chocolate\",\"value\":\"01uF000000P6Pf7IAF\"},{\"label\":\"All Natural - Cookie Dough\",\"value\":\"01uF000000P6PfRIAV\"},{\"label\":\"All Natural - Cookies and Cream\",\"value\":\"01uF000000P6PhNIAV\"},{\"label\":\"All Natural - Mint Chocolate Chip\",\"value\":\"01uF000000P6Ph3IAF\"},{\"label\":\"All Natural - Vanilla\",\"value\":\"01uF000000P6PhmIAF\"},{\"label\":\"Low Fat/Cal - Chocolate\",\"value\":\"01uF000000P6PioIAF\"},{\"label\":\"Low Fat/Cal - Cookie Dough\",\"value\":\"01uF000000P6Pj8IAF\"},{\"label\":\"Low Fat/Cal - Cookies and Cream\",\"value\":\"01uF000000P6PjSIAV\"},{\"label\":\"Low Fat/Cal - Mint Chocolate Chip\",\"value\":\"01uF000000P6PmDIAV\"},{\"label\":\"Low Fat/Cal - Vanilla\",\"value\":\"01uF000000P6PjmIAF\"},{\"label\":\"Non-dairy - Soy Chocolate\",\"value\":\"01uF000000P6Pk6IAF\"},{\"label\":\"Non-dairy - Soy Mocha Fudge\",\"value\":\"01uF000000P6PkQIAV\"},{\"label\":\"Non-dairy - Soy Neapolitan\",\"value\":\"01uF000000P6PkkIAF\"},{\"label\":\"Non-dairy - Soy Vanilla\",\"value\":\"01uF000000P6Pl4IAF\"},{\"label\":\"All Natural - Chocolate\",\"value\":\"01uF000000P6PfCIAV\"},{\"label\":\"All Natural - Cookie Dough\",\"value\":\"01uF000000P6PfWIAV\"},{\"label\":\"All Natural - Cookies and Cream\",\"value\":\"01uF000000P6PhIIAV\"},{\"label\":\"All Natural - Mint Chocolate Chip\",\"value\":\"01uF000000P6PhXIAV\"},{\"label\":\"All Natural - Vanilla\",\"value\":\"01uF000000P6PhrIAF\"},{\"label\":\"Low Fat/Cal - Chocolate\",\"value\":\"01uF000000P6PitIAF\"},{\"label\":\"Low Fat/Cal - Cookie Dough\",\"value\":\"01uF000000P6PjDIAV\"},{\"label\":\"Low Fat/Cal - Cookies and Cream\",\"value\":\"01uF000000P6PjXIAV\"},{\"label\":\"Low Fat/Cal - Mint Chocolate Chip\",\"value\":\"01uF000000P6Pm8IAF\"},{\"label\":\"Low Fat/Cal - Vanilla\",\"value\":\"01uF000000P6PjrIAF\"},{\"label\":\"Non-dairy - Soy Chocolate\",\"value\":\"01uF000000P6PkBIAV\"},{\"label\":\"Non-dairy - Soy Mocha Fudge\",\"value\":\"01uF000000P6PkVIAV\"},{\"label\":\"Non-dairy - Soy Neapolitan\",\"value\":\"01uF000000P6PkpIAF\"},{\"label\":\"Non-dairy - Soy Vanilla\",\"value\":\"01uF000000P6Pl9IAF\"}]";
		
		//create json util to read objects
		JSONParser parser = new JSONParser();
		JSONArray jsonA = (JSONArray) parser.parse(json);
		JSONArray jsonFlavorArray = (JSONArray) parser.parse(flavors);
		
		int cycles = Integer.parseInt(args[0]);

		
		String fName, lName, flavorSelected;
		
		JSONObject jsonO;
		JSONObject jsonFlavorsO; 
		
		//loop to run process
		for (int i = 0; i < cycles; i++){
			//get random name and flavor
			jsonO = (JSONObject) jsonA.get(getRandomNum(100));
			jsonFlavorsO = (JSONObject) jsonFlavorArray.get(getRandomNum(28));
			
			fName = jsonO.get("first_name").toString();
			lName = jsonO.get("last_name").toString();
			flavorSelected = jsonFlavorsO.get("value").toString();
			
			postForms(fName, lName, flavorSelected);
			
			System.out.println("waiting 5 seconds before next cycle");
			Thread.sleep(5000);
		}

	}
	
	public static void postForms(String fName, String lName, String flavor) throws ClientProtocolException, IOException, ScriptException, InterruptedException{
		String url, randomDOB, today, email, leadSource;
		
		url = "http://na-sjp.marketo.com/index.php/leadCapture/save";
		
		/** String today = new SimpleDateFormat("yyyy-mm-dd").format(cal.getTime()); **/
		
		randomDOB = getRandomDate();
		
		String[] leadSources = {"In Person", "Social", "Web"};
		
		leadSource = leadSources[getRandomNum(3)];
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		today = sdf.format(date);
		
		email = "ick.treat+" + (fName + "." + lName).toLowerCase() + "@gmail.com";
		
		int price = getRandomNum(2);
		
		if (price == 2)
			price = 5;
		else
			price = 9;

		SendHttpRequest postRequest = new SendHttpRequest();
				
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		List<NameValuePair> urlParameters2 = new ArrayList<NameValuePair>();
				
		urlParameters.add(new BasicNameValuePair("FirstName", fName));
		urlParameters.add(new BasicNameValuePair("LastName", lName));
		urlParameters.add(new BasicNameValuePair("Email", email));
		urlParameters.add(new BasicNameValuePair("DateofBirth", randomDOB));
		urlParameters.add(new BasicNameValuePair("Company", "Consumer - " + fName + " " + lName + " - " + (fName + "." + lName).toLowerCase()));
		urlParameters.add(new BasicNameValuePair("Lead_Type__c", "Consumer"));
		urlParameters.add(new BasicNameValuePair("Contact_Account_ID__c", ""));
		urlParameters.add(new BasicNameValuePair("LeadSource", leadSource));
		urlParameters.add(new BasicNameValuePair("_marketo_comments", ""));
		urlParameters.add(new BasicNameValuePair("lpId", "12192"));
		urlParameters.add(new BasicNameValuePair("subId", "181"));
		urlParameters.add(new BasicNameValuePair("lpurl", "http://na-sjp.marketo.com/lp/026-COU-482/Loyalty-Profile-Registration.html?cr={creative}&amp;kw={keyword}"));
		urlParameters.add(new BasicNameValuePair("formid", "3587"));
		urlParameters.add(new BasicNameValuePair("ret", ""));
		urlParameters.add(new BasicNameValuePair("munchkinId", "026-COU-482"));
		urlParameters.add(new BasicNameValuePair("kw", ""));
		urlParameters.add(new BasicNameValuePair("cr", ""));
		urlParameters.add(new BasicNameValuePair("searchstr", ""));
		urlParameters.add(new BasicNameValuePair("_mkt_disp", "return"));
		urlParameters.add(new BasicNameValuePair("_mkt_trk", ""));
		
		System.out.println("Form 1: \n");
		printList(urlParameters);
		System.out.println();
		
		//Get cookie from response and reset url/params
		
		
		urlParameters2.add(new BasicNameValuePair("item1UnitPrice", Integer.toString(price)));
		urlParameters2.add(new BasicNameValuePair("item1Flavor", flavor));
		urlParameters2.add(new BasicNameValuePair("item1Quantity", Integer.toString(getRandomNum(10))));
		urlParameters2.add(new BasicNameValuePair("item2UnitPrice", ""));
		urlParameters2.add(new BasicNameValuePair("item2Flavor", ""));
		urlParameters2.add(new BasicNameValuePair("item2Quantity", ""));
		urlParameters2.add(new BasicNameValuePair("item3UnitPrice", ""));
		urlParameters2.add(new BasicNameValuePair("item3Flavor", ""));
		urlParameters2.add(new BasicNameValuePair("item3Quantity", ""));
		urlParameters2.add(new BasicNameValuePair("Email", email));
		urlParameters2.add(new BasicNameValuePair("dateToday", today));
		urlParameters2.add(new BasicNameValuePair("_marketo_comments", ""));
		urlParameters2.add(new BasicNameValuePair("lpId", "12198"));
		urlParameters2.add(new BasicNameValuePair("subId", "181"));
		urlParameters2.add(new BasicNameValuePair("lpurl", "http://na-sjp.marketo.com/lp/026-COU-482/Loyalty-Profile-Order.html?cr={creative}&amp;kw={keyword}"));
		urlParameters2.add(new BasicNameValuePair("formid", "3590"));
		urlParameters2.add(new BasicNameValuePair("ret", ""));
		urlParameters2.add(new BasicNameValuePair("munchkinId", "026-COU-482"));
		urlParameters2.add(new BasicNameValuePair("kw", ""));
		urlParameters2.add(new BasicNameValuePair("cr", ""));
		urlParameters2.add(new BasicNameValuePair("searchstr", ""));
		urlParameters2.add(new BasicNameValuePair("_mkt_disp", "return"));
		urlParameters2.add(new BasicNameValuePair("_mkt_trk", ""));
		
		System.out.println("Form 2: \n");
		printList(urlParameters2);
		System.out.println();

		
		//send form 2
		/**BasicClientCookie cookie = new BasicClientCookie("_mkto_trk");
		cookie.setDomain(".marketo.com");
		cookie.setPath("/"); **/
		
		postRequest.sendPost(url, urlParameters, urlParameters2, 15000);
	}
	
	public static int getRandomNum(int bound){
		Random rand = new Random();
		
		return rand.nextInt(bound);
	}
	
	public static String getRandomDate(){
		
		String randomDate, randomMonthS, randomDayS;
		int ten = 10;
		int randomMonth, randomDay, randomYear;
        randomMonth =  (int) Math.floor((Math.random() * 12) + 1);
        randomDay = (int) Math.floor((Math.random() * 28) + 1);
        randomYear = (int) (Math.floor((Math.random() * 50) + 51) + 1900);
        
    if (randomMonth < ten) {
        randomMonthS = "0" + randomMonth;
    }
    else {
    	randomMonthS = "" + randomMonth + "";
    }
    
    if (randomDay < ten) {
    	randomDayS = "0" + randomDay;
    }
    else {
    	randomDayS = "" + randomDay + "";
    }
        
    randomDate = randomYear + "-" + randomMonthS + "-" + randomDayS;
    
    return randomDate;
	}
	
	public static void printList(List<NameValuePair> list){
		for (int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
