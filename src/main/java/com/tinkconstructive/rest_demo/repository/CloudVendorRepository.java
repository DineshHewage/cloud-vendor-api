package com.tinkconstructive.rest_demo.repository;

import com.tinkconstructive.rest_demo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CloudVendorRepository extends JpaRepository<CloudVendor, String> {
    // Spring creates the implementation automatically!
    // <CloudVendor, String> - <What entity/table this repository manage, What data type the primary key (@Id) of your entity is>

    // If I need, I can write the signature of custom method. But japrepository has most of CRUD operation methods.
}
