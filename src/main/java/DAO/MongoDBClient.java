package DAO;

import Models.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Accumulators.max;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBClient {
    MongoDatabase database;
    public MongoDBClient() {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                                                        pojoCodecRegistry);

        ConnectionString connectionString = new ConnectionString("mongodb+srv://ClaruswayTeam2:jibrary1234@claruswayprjs.69bcdes.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        MongoClient mongoClient = MongoClients.create(clientSettings);
        database = mongoClient.getDatabase("Project01");

    }

    public void createCollection(String collectionName) {
        database.createCollection(collectionName);
    }

    public <T> List<T> loadList(String collectionName, Class<T> aClass) {
        MongoCollection<T> collection = database.getCollection(collectionName, aClass);
        List<T> documents = new ArrayList<T>();

        MongoCursor<T> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                documents.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return  documents;
    }

    public <T> InsertOneResult insert(T item, Class<T> aClass, String collectionName) {
        MongoCollection<T> collection = database.getCollection(collectionName, aClass);
        InsertOneResult result= null;
        try {
            result = collection.insertOne(item);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("error in inserting = " + e.getMessage());
        }
        return result;
    }

    public <T> UpdateResult update(T item, Class<T> aClass, String collectionName, String fieldName, Object value) {
        MongoCollection<T> collection = database.getCollection(collectionName, aClass);
        UpdateResult result = null;
        try {
            //String json = new ObjectMapper().writeValueAsString(p);
            Document document = Document.parse(new ObjectMapper().writeValueAsString(item));
            result = collection.replaceOne(eq(fieldName, value), (T) document);
        } catch (Exception e) {
            System.out.println("Update error = " + e.getMessage());
        }
        return result;
    }

    public <T> DeleteResult delete(T item, Class<T> aClass, String collectionName, String fieldName, Object value) {
        MongoCollection<T> collection = database.getCollection(collectionName, aClass);
        DeleteResult result = null;
        try {
            //String json = new ObjectMapper().writeValueAsString(p);
            Document document = Document.parse(new ObjectMapper().writeValueAsString(item));
            result = collection.deleteOne(eq(fieldName, value));
        } catch (Exception e) {
            System.out.println("Update error = " + e.getMessage());
        }
        return result;
    }

}
