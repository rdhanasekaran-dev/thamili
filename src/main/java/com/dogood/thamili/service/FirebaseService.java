package com.dogood.thamili.service;

import com.dogood.thamili.model.ProfileDetails;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.util.concurrent.ExecutionException;

@Component
public class FirebaseService {

    // save profile details in firebase
    public String saveProfileDetails(ProfileDetails profileDetails) {
        Firestore firestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=firestore.collection("profile").document(profileDetails.getId()).set(profileDetails);
        return "success";
    }

    // get profile details in firebase
    public ProfileDetails getUserDetails(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore=FirestoreClient.getFirestore();
        DocumentReference documentReference=dbFirestore.collection("profile").document(id);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture=documentReference.get();
        DocumentSnapshot documentSnapshot=documentSnapshotApiFuture.get();

        ProfileDetails profileDetails=null;

        if(documentSnapshot.exists()){
            profileDetails=documentSnapshot.toObject(ProfileDetails.class);
            return profileDetails;
        }else {
            return null;
        }

    }

}
