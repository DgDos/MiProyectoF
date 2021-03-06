/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miproyectof;

import com.mycompany.myproyectof.dao.PatientDAO;
import com.mycompany.myproyectof.model.Mongo;
import com.mycompany.myproyectof.model.Patient;
import java.net.UnknownHostException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/patient")
public class PatientREST {
    // URI:
    // /contextPath/servletPath/employees
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Patient> getEmployees_JSON() throws UnknownHostException {
        return Mongo.show();
    }
 
    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{patNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Patient getEmployee(@PathParam("patNo") String patNo) throws UnknownHostException {
        return Mongo.showOne(patNo);
    }
 
    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Patient addEmployee(Patient pat) {
        return Mongo.addPatient(pat);
    }
}
