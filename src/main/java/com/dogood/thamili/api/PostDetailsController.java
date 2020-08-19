package com.dogood.thamili.api;

import com.dogood.thamili.model.IdModel;
import com.dogood.thamili.model.PostDetails;
import com.dogood.thamili.model.ProfileDetails;
import com.dogood.thamili.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "post")
public class PostDetailsController {

    @Autowired
    private FirebaseService firebaseService;

    // save profile details in firebase
    @RequestMapping("/put")
    @PostMapping()
    public String savePostDetails(@RequestBody PostDetails postDetails){
        return firebaseService.savePostDetails(postDetails);
    }

    // get profile details from firebase
    @RequestMapping("/get")
    @PostMapping()
    public ProfileDetails getProfileDetails(@RequestBody IdModel id) throws ExecutionException, InterruptedException {
        return firebaseService.getUserDetails(id.getId());
    }


}
