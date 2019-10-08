package ava;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import java.io.*;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<String> ip_list = new ArrayList<String>();
        get_proxy(ip_list);
        print(ip_list);

    }
    public static void print(ArrayList<String> ip_list){
        for(int i = 0; i<ip_list.size(); i++){
            System.out.println(ip_list.get(i));
        }
    }
    public static void get_proxy(ArrayList<String> ip_list ){


        try{
            Document doc = Jsoup.connect("https://www.free-proxy-list.net/").get();
            Elements tables = doc.select("tbody");
            for(Element table : tables){
                for(Element row : tables.select("tr")){
                    Elements tds = row.select("td");
                    if(tds.size() == 8){
                        String ip = tds.get(0).text();
                        String port = tds.get(1).text();
                        String  fresh_ip = ip+":"+port;
                        ip_list.add(fresh_ip);
                    }
                }
            }


        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
