package DAM2.ConexionMongoDB;

/**
 * Hello world!
 *
 */
import com.mongodb.ConnectionString;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.Arrays;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class App 
{
    public static void main( String[] args )
    {
    	//AQUI PONER LA URL QUE ME DE EL CLUSTER	
    	 String conexion = "mongodb+srv://kike:<password>@cluster0.gz7cyjm.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
         
         //Establezco conexion
         try(MongoClient cl = MongoClients.create(new ConnectionString(conexion))) {
         
             //Conecto BDD
             MongoDatabase bd = cl.getDatabase("Prueba2");
             //Cojo datos
             MongoCollection<Document> todo = bd.getCollection("prueba");
             
             //insertar documento de ejemplo
             Document inserto = new Document("nombre", "Enrique").append("Apellido", "Moreno");
             todo.insertOne(inserto);
             
             //Consulta
             MongoCursor<Document> cursor = todo.find().iterator();
             try {
                 while (cursor.hasNext()) {
                     System.out.println(cursor.next().toJson());
                 }
             }
             finally {
                 cursor.close();
             }
             
    }
    }
}
    

