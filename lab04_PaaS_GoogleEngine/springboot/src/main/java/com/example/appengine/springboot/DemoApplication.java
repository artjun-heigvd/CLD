package com.example.appengine.springboot;

import java.util.Map;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class DemoApplication {
    private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

    @GetMapping("/")
    public String hello() {
    return "Hello, world!";
  }


    @GetMapping("/dswritesimple")
    public String writeEntityToDatastoreSimple(@RequestParam Map<String, String> queryParameters) {
        StringBuilder message = new StringBuilder();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("book");
        Key key = datastore.allocateId(keyFactory.newKey());
        Entity entity = Entity.newBuilder(key)
                .set("title", "The grapes of wrath")
                .set("author", "John Steinbeck")
                .build();
        message.append("Writing entity to Datastore\n");
        datastore.put(entity);
        Entity retrievedEntity = datastore.get(key);
        message.append("Entity retrieved from Datastore: "
                + retrievedEntity.getString("title")
                + " " + retrievedEntity.getString("author")
                + "\n");
        return message.toString();
    }

    @GetMapping("/dswrite")
    public String writeEntityToDatastore(@RequestParam Map<String, String> queryParameters) {
        String kind = queryParameters.get("_kind");
        StringBuilder message = new StringBuilder();
        if(kind == null){
            message.append("The kind attribute is mandatory!");
            return message.toString();
        }

        //if we got a kind
        KeyFactory keyFactory = datastore.newKeyFactory().setKind(kind);
        Key key = null;
        if(queryParameters.containsKey("_key")){
            key = keyFactory.newKey(queryParameters.get("_key"));
        } else {
            key = datastore.allocateId(keyFactory.newKey());
        }

        //Create the builder
        Entity.Builder builder = Entity.newBuilder(key);

        for(var param : queryParameters.entrySet()){
            if(!param.getKey().equals("_key") && !param.getKey().equals("_kind")){
                builder.set(param.getKey(), param.getValue());
            }
        }

        message.append("Writing entity to Datastore\n");
        datastore.put(builder.build());

        return message.toString();
    }
}