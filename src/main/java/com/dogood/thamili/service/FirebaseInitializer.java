package com.dogood.thamili.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FirebaseInitializer {

    @PostConstruct
    private void initialize(){
        try{

            FileInputStream serviceAccount =
                    new FileInputStream("serviceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://thamili-api.firebaseio.com")
                    .build();

           FirebaseApp firebaseApp= FirebaseApp.initializeApp(options);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
