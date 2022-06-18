package com.example.streets.seeder;

import com.example.streets.entity.District;
import com.example.streets.repository.DistrictRepository;
import com.example.streets.repository.StreetRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class DistrictSeeder {
    @Autowired
    DistrictRepository districtRepository;
    Faker faker;
    public static final int numberOfDistrict = 10;

    public void generate() {
        log.debug("----------------Start seeder district-----------------");
        List<District> streetList = new ArrayList<>();
        for (int i = 0; i < numberOfDistrict; i++) {
            System.out.println(i + 1);
            District district = new District();
            district.setId(UUID.randomUUID().toString());
            district.setName(faker.address().streetName());
            streetList.add(district);
            System.out.println(district.toString());
        }
        districtRepository.saveAll(streetList);
        log.debug("----------------End seeder district-----------------");
    }
}
