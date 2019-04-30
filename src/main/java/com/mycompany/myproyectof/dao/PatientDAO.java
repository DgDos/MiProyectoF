/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myproyectof.dao;

import com.mycompany.myproyectof.model.Patient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PatientDAO {

    private static final Map<String, Patient> patMap = new HashMap<String, Patient>();

    static {
        initEmps();
    }
 
    private static void initEmps() {
        Patient pat1 = new Patient("P01", "Oscar", "Calle 1", "5554", "27/09/2014", "Flor", true, 1, "", "");
        Patient pat2 = new Patient("P02", "Gibran", "Calle 2", "11223", "27/09/2015", "Andrea", false, 0, "Sura", "00001");
        Patient pat3 = new Patient("P03", "Andres", "Calle 3", "5334", "27/09/2016", "Sol", true, 2, "", "");
        
       
 
        patMap.put(pat1.getPatNo(), pat1);
        patMap.put(pat2.getPatNo(), pat2);
        patMap.put(pat3.getPatNo(), pat3);
        
    }
    
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
