package com.dogood.thamili.service;

import com.dogood.thamili.model.PostDetails;
import com.dogood.thamili.model.ProfileDetails;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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

    // get all posts
    public List<PostDetails> getAllPosts() throws ExecutionException, InterruptedException {
        Firestore dbFireStore= FirestoreClient.getFirestore();
        List<PostDetails> postsList=new ArrayList<>();
        ApiFuture<QuerySnapshot> future=dbFireStore.collection("post").get();
        List<QueryDocumentSnapshot> documentSnapshots=future.get().getDocuments();
        for(QueryDocumentSnapshot documentSnapshot:documentSnapshots){
            postsList.add(documentSnapshot.toObject(PostDetails.class));
        }
        return postsList;
    }
}
