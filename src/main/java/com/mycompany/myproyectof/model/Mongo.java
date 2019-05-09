/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myproyectof.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author brown
 */
public class Mongo {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    public static Patient addPatient(Patient a) {
        try {

            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("patient");
            DBObject doc = new BasicDBObject("patNo", a.getPatNo())
                    .append("name", a.getName())
                    .append("address", a.getAddress())
                    .append("telephone", a.getTelephone())
                    .append("date_of_birth", a.getDate_of_birth())
                    .append("emergency_contact", a.getEmergency_contact())
                    .append("type_of_patient", a.isType_of_patient())
                    .append("medicare", a.getMedicare())
                    .append("ins_company", a.getIns_company())
                    .append("ins_number", a.getIns_number());

            coll.insert(doc);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
        return a;
    }

    public static List<Patient> show() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient(HOST, PORT);
        
           Map<String, Patient> empMap = new HashMap<String, Patient>();
            MongoDatabase database = mongoClient.getDatabase("sampledb");

           MongoCollection<Document> collection = database.getCollection("patient");

           MongoCursor<Document> cursor = collection.find().projection(Projections.excludeId()).iterator();
         

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Gson gson = new Gson();
                Patient c = gson.fromJson(doc.toJson(), Patient.class);
                empMap.put(c.getName(),c);
            }

        } finally {
            cursor.close();
        }
        
        Collection<Patient> c = empMap.values();
        List<Patient> list = new ArrayList<Patient>();
        list.addAll(c);
        return list;
        
    }

}
