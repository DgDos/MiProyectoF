/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myproyectof.dao;

import com.mycompany.myproyectof.model.Mongo;
import com.mycompany.myproyectof.model.Patient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PatientDAO {

    private static final Map<String, Patient> patMap = new HashMap<String, Patient>();
    
    public static Patient getPatient(String patNo){
        return patMap.get(patNo);
    }
    
    public static Patient addPatient(Patient pat) {
        patMap.put(pat.getPatNo(), pat);
        return pat;
    }
    
    public static List<Patient> getAllPatients(){
        Collection<Patient> c= patMap.values();
        List<Patient> list=new ArrayList<Patient>();
        list.addAll(c);
        return list;
    }
    
}
