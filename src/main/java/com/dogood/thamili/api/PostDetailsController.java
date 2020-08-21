package com.dogood.thamili.api;

import com.dogood.thamili.model.IdModel;
import com.dogood.thamili.model.PostDetails;
import com.dogood.thamili.model.ProfileDetails;
import com.dogood.thamili.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "post")
public class PostDetailsController {

    @Autowired
    private FirebaseService firebaseService;

    // save profile details in firebase
    @PostMapping("/put")
    public String savePostDetails(@RequestBody PostDetails postDetails){
        return firebaseService.savePostDetails(postDetails);
    }

    // get profile details from firebase
    @GetMapping("/all")
    public List<PostDetails> getPostDetails() throws ExecutionException, InterruptedException {
        return firebaseService.getAllPosts();
    }


}
