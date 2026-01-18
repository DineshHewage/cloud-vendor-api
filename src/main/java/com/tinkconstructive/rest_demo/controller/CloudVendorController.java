package com.tinkconstructive.rest_demo.controller;

import com.tinkconstructive.rest_demo.model.CloudVendor;
import com.tinkconstructive.rest_demo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    /*  Meaning of the constructor in English
    =============================================
    When someone creates a CloudVendorController object,
    they MUST give me a CloudVendorService object.
    I will store that service object so I can use it later in my methods

    Imagine you're a chef (Controller) and you need a kitchen assistant (Service).
    public Chef(KitchenAssistant assistant) {
    this.myAssistant = assistant;
    }

    When you hire a Chef, you must provide them with a Kitchen Assistant.
    The chef will remember who their assistant is so they can ask them to do tasks later.

    Then When the chef needs to cook (handle requests),

    public void cookDish() {
    myAssistant.prepareIngredients();  // Use the assistant!
    }

    How this constructor work
    =========================
    Question 2: Who passes cloudVendorService parameter, in the constructor?. -> The Spring Framework passes it automatically

    How Spring Does This

    Step 1: Application Starts
    ↓
    Step 2: Spring scans for @Component, @Service, @RestController, etc.
    ↓
    Step 3: Spring finds CouldVendorServiceImpl with @Service
    → Creates instance: CouldVendorServiceImpl serviceImpl = new CouldVendorServiceImpl(...)
    ↓
    Step 4: Spring finds CloudVendorController with @RestController
    → Sees constructor needs CloudVendorService
    → Looks in its container for a bean of type CloudVendorService
    → Finds the CouldVendorServiceImpl instance (implements CloudVendorService)
    ↓
    Step 5: Spring calls the constructor and PASSES the implementation
    → new CloudVendorController(serviceImpl)


    // What SPRING does behind the scenes:
    class SpringContainer {
        public void createBeans() {
            // 1. Create the service implementation
            CloudVendorRepository repo = new CloudVendorRepositoryImpl();
            CouldVendorServiceImpl serviceImpl = new CouldVendorServiceImpl(repo);

            // 2. Create the controller and PASS the service
            CloudVendorController controller = new CloudVendorController(serviceImpl);
            //                                                            ^^^^^^^^^^^
            //                                                   Spring passes this parameter!

            // 3. Store both beans in Spring's container for later use
        }
    }
    */

    // Read specific cloud vendor detail.
    @GetMapping("{id}")
    public CloudVendor getCloudVendorDetail(@PathVariable("id") String id) {
        return cloudVendorService.getCloudVendor(id);
    }

    // Read all cloud vendor detail avilable in db.
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetail() {
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId") String vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor deleted Successfully";
    }
}
