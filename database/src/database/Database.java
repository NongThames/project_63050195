/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author NongPupe
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import database.Coviddata;

public class Database {

    /**
     * @param args the command line arguments
     */
    public static void main (String []args) throws FileNotFoundException, JSONException {
        JsonReader reader = Json.createReader(new FileReader("C:\\Users\\Thamess\\Desktop\\weeklist.json"));
        JsonStructure jsonst = reader.read();

        String str = jsonst.toString();

        JSONArray arr = new JSONArray(str);
        for(int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            int id = i+1;
            int yearnum = obj.getInt("year");
            int weeknum = obj.getInt("weeknum");
            String province = obj.getString("province");
            int age = obj.getInt("age");
            String age_range = obj.getString("age_range");
            String occupation = obj.getString("occupation");
            String typed = obj.getString("type");
            String death_cluster = obj.getString("death_cluster");
            String update_date = obj.getString("update_date");
 
            Coviddata cov = new Coviddata(id, yearnum, weeknum, province, age, age_range, occupation,typed, death_cluster, update_date );
          persist(cov);
        }
    
}

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databasePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
}