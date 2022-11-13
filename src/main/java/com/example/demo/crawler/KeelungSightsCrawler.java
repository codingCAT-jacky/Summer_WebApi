package com.example.demo.crawler;



import com.example.demo.Sight.Sight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class KeelungSightsCrawler {

    String title1, httpweb, district, category, photoURL, address,
            sightname,desctription;
    Document doc1,doc2,doc3;
    ArrayList<Sight> copy = new ArrayList<>();

    public List<Sight> getItems(String location)  {

        try {
            doc1 = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/")
                    .get();
            Element boxss = doc1.selectFirst("div.box_ss");
            Elements  boxsslocation = boxss.getElementsByTag("a");
            for (Element el : boxsslocation)
            {
                district=el.text();
                title1=district.substring(0,district.length()-1);
                if(title1.equals(location))
                {
                    httpweb = el.attr("abs:href");
                }
            }

            if(httpweb==null)
            {
                System.out.printf("enter the wrong location");
            }
            else
            {
//                System.out.printf("httpweb=%s\n",httpweb);
                doc2 = Jsoup.connect(httpweb).get();
            }
            Element box = doc2.selectFirst("div.box");
            Elements  boxlocation = box.getElementsByTag("li");
            for(Element el : boxlocation)
            {
                Element tmp = el.selectFirst("a");
                sightname = tmp.text();
                httpweb=tmp.attr("abs:href");
//                System.out.printf("httpweb=%s sightname=%s\n",httpweb, sightname);
                doc3 = Jsoup.connect(httpweb).get();

                Element pointype = doc3.selectFirst("span.point_type");
                Element pointype2 = pointype.select("span[property]").first();
                category = pointype2.text();

                Element addr = doc3.selectFirst("div.address");
                Element addr2 = addr.select("span[property]").first();
                address = addr2.text();

                Element phourl = doc3.selectFirst("div.gpic");
                if(phourl==null)
                {
                    photoURL = "";
                }
                else
                {
                    Element phourl2 = phourl.selectFirst("img[src]");
                    photoURL = phourl2.attr("data-src");
                }


                Element des = doc3.selectFirst("div.text");
                desctription = des.text();

                copy.add(new Sight(sightname, location, category, photoURL, address, desctription));
//                System.out.printf("category=%s address=%s photourl=%s desc=%s\n",category, address,photoURL,desctription);
            }

//            theSight = new Sight[copy.size()];
//            copy.toArray(theSight);
//            for (Sight s: theSight) {
//                System.out.println(s);
//            }
        }

        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return this.copy;
    }

}

