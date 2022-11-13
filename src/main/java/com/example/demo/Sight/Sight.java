package com.example.demo.Sight;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Sight")
public class Sight {


    String sightName;
    String zone;
    String category;
    String photoURL;
    String address;
    String description;
    public Sight() {}
    public Sight(String sightName, String zone, String category, String photoURL, String address, String description)
    {
        this.sightName = sightName;
        this.category = category;
        this.zone=zone;
        this.photoURL=photoURL;
        this.address=address;
        this.description=description;
    }
    public void setSightName(String sightName)
    {
        this.sightName = sightName;
    }
    public String getSightName()
    {
        return sightName;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory()
    {
        return category;
    }

    public void setZone(String zone)
    {
        this.zone=zone;
    }
    public String getZone()
    {
        return zone;
    }

    public void setPhotoURL(String photoURL)
    {
        this.photoURL=photoURL;
    }
    public String getPhotoURL()
    {
        return photoURL;
    }

    public  void setAddress(String address)
    {
        this.address=address;
    }
    public String getAddress()
    {
        return address;
    }

    public void setDescription(String description)
    {
        this.description=description;
    }
    public  String getDescription(){return description;}

    public String toString()
    {
        System.out.printf("SightName: %s\nZone: %s\nCategory: %s\nPhotoURL:\n%s\nDescription:\n%s\n" +
                "Address: %s\n\n", sightName, zone, category, photoURL, description, address);
        return "";
    }
}
