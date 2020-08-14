package com.dogood.thamili.api;

import com.dogood.thamili.model.IdModel;
import com.dogood.thamili.model.ProfileDetails;
import com.dogood.thamili.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "profile")
public class ProfileDetailsController {

    @Autowired
    private FirebaseService firebaseService;

    // save profile details in firebase
    @RequestMapping("/put")
    @PostMapping()
    public String saveProfileDetails(@RequestBody ProfileDetails profileDetails){
        return firebaseService.saveProfileDetails(profileDetails);
    }

    // get profile details from firebase
    @RequestMapping("/get")
    @PostMapping()
    public ProfileDetails getProfileDetails(@RequestBody IdModel id) throws ExecutionException, InterruptedException {
        return firebaseService.getUserDetails(id.getId());
    }

}
