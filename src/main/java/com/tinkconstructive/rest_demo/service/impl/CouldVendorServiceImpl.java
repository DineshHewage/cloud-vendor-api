package com.tinkconstructive.rest_demo.service.impl;

import com.tinkconstructive.rest_demo.model.CloudVendor;
import com.tinkconstructive.rest_demo.repository.CloudVendorRepository;
import com.tinkconstructive.rest_demo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouldVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository couldVendorRepository;

    public CouldVendorServiceImpl(CloudVendorRepository couldVendorRepository) {
        this.couldVendorRepository = couldVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        couldVendorRepository.save(cloudVendor);
        return "Successfully created cloud vendor";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        couldVendorRepository.save(cloudVendor);
        return "Successfully updated cloud vendor";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        couldVendorRepository.deleteById(vendorId);
        return "Successfully deleted cloud vendor";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        return couldVendorRepository.findById(vendorId).get();
        /*Here findById() returns 'optional' and not the exact CloudVendor entity Optional<CloudVendor>.
        Optional is a container that may or may not contain a value.
        If the id is exit in the DB, Optional will return the exact CloudVendor and if not Optional is Empty.

        * What .get() does - It extract the actual object from the Optional container.
        The problem with .get() is if the Optional container is empty, 'NoSuchElementException' exception will through program will crash

        So you can use below to handle the exception.

         return couldVendorRepository.findById(vendorId)
            .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + vendorId));
        */
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return couldVendorRepository.findAll();
        // .findAll() returns a list
    }
}
