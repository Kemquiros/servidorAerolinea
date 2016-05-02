/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import clases.Vuelo;
import dao.VueloDao;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * REST Web Service
 *
 * @author t30r3m4
 */
@Path("/vuelos")
public class VuelosResource {

    @Context
    private UriInfo context;
    @EJB
    private VueloDao vueloDao;
    /**
     * Creates a new instance of VuelosResource
     */
    public VuelosResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.VuelosResource
     * @param ciudad
     * @param datos
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getVuelos(@QueryParam("ciudad")String ciudad,
            @QueryParam("destino")String destino,
            @QueryParam("fechaIda")String fechaIda,
            @QueryParam("fechaRegreso")String fechaRegreso,
            @QueryParam("adultos")int adultos,
            @QueryParam("ninos")int ninos,
            @QueryParam("bebes")int bebes
             ) throws JSONException {
        /*String ciudad = "Medellin";
        String destino = "Bogota";
        String fechaIda = "2016-05-02";
        String fechaRegreso = "2016-05-05";
        int adultos= 2;
        int ninos=1;
        int bebes=0;*/
        
        //Consultamos los vuelos que coincidan con esos parametros
        List<Vuelo> vuelos =vueloDao.getVuelos1();
        
        /*String s = null;
        s= new Gson().toJson(vuelos.get(0));
        return s;*/
        
        JSONObject[] ja = new JSONObject[vuelos.size()];
        
        Map<String, String> mapa = new LinkedHashMap<String, String>();
        JSONObject json = new  JSONObject();
        System.out.println("Cantidad objetos-> "+vuelos.size());
        int i=0;
        for(Vuelo v:vuelos){
            String cadena =null;
            ja[i] = new JSONObject(v.toString());
            //ja[i].put("Blabla"+i, v.toString());            
            System.out.println("Objeto-> "+ja[i].toString());
            json.put(Integer.toString(i), v.toString());
            mapa.put(Integer.toString(i), ja[i].toString());
            
            i++;
            //System.out.println("");
            //cadena = new Gson().toJson(v);
        }
        
        //return mapa.toString();
        JSONObject mensaje = new JSONObject(mapa);
        //return mensaje.toString();
        return json.toString();
        //String ciudad,String destino,String fechaIda,String fechaRegreso,int adultos,int ninos, int bebes
        
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of VuelosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
