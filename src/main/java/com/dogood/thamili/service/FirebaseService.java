package com.dogood.thamili.service;

import com.dogood.thamili.model.PostDetails;
import com.dogood.thamili.model.ProfileDetails;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;

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

    // save image details in firebase
    public String savePostDetails(PostDetails postDetails) {
        Firestore firestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=firestore.collection("post").document(postDetails.getId()).set(postDetails);
        return "success";
    }

    // get image details in firebase
    public ProfileDetails getImageDetails(String id) throws ExecutionException, InterruptedException {
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

    // get all Images details in firebase
    public ProfileDetails getAllImageDetails(String id) throws ExecutionException, InterruptedException {
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
