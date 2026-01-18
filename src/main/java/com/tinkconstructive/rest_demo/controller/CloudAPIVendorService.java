package com.tinkconstructive.rest_demo.controller;

import com.tinkconstructive.rest_demo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController // This class receives http requests and returns data as JSON.
@RequestMapping("/cloudvendor") // Every request handled by this controller must start with /cloudvendor
public class CloudAPIVendorService {

    CloudVendor cloudVendor_obj;

    // End point is not compulsory for @GetMapping. Below method will work.
    //    @GetMapping
    //    public CloudVendor getCloudVendorDetail() {
    //        return new CloudVendor("C1","Vendor 1", "Address one", "0771758937");
    //    }

    @GetMapping("{id}")
    public CloudVendor getCloudVendorDetail(@PathVariable String id) {
        // URL: /cloudvendor/ABC123
        // id = "ABC123"

        //        return new CloudVendor(id,"Vendor 1", "Address one", "0771758937");
        /*        Here if the URL comes as http://localhost:8080/cloudvendor/C003 id will be replaced with C003 and return the JASON*/

        //        return new CloudVendor("C1","Vendor 1", "Address one", "0771758937");
        /*        Here if the URL comes as http://localhost:8080/cloudvendor/C003 id is C1 and return the JASON*/

        return cloudVendor_obj;
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendor_obj = cloudVendor;
        return "Cloud Vendor Created Successfully";
        /*When the POST request comes with values in body, the cloudVendor object will be created in the memory and return the success message*/
        /*Then after the POST request, if the GET request comes, the object created in the POST request will be return*/
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendor_obj = cloudVendor;
        return "Cloud Vendor updated Successfully";
    }

    @DeleteMapping("{id}")
    public String deleteCloudVendor(String id) {
        this.cloudVendor_obj = null;
        return "Cloud Vendor deleted Successfully";
    }
}
