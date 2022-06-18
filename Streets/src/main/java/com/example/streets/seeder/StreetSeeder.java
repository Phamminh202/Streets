package com.example.streets.seeder;

import com.example.streets.entity.District;
import com.example.streets.entity.Street;
import com.example.streets.entity.myenum.StreetStatus;
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
public class StreetSeeder {
    @Autowired
    StreetRepository streetRepository;
    @Autowired
    DistrictRepository districtRepository;
    Faker faker;
    public static final int numberOfStreet = 500;

    public void generate() {
        log.debug("----------------Start seeder district-----------------");
        List<District> districts = districtRepository.findAll();
        List<Street> streetList = new ArrayList<>();
        for (int i = 0; i < numberOfStreet; i++) {
            Street street = new Street();
            street.setId(UUID.randomUUID().toString());
            street.setName(faker.address().cityName());
            District randomDistrict = districts.get(faker.number().numberBetween(0, districts.size() - 1));
            street.setDescription(faker.lorem().sentence());
            street.setDistrict(randomDistrict);
            street.setStatus(StreetStatus.InUse);
            streetList.add(street);
        }
        streetRepository.saveAll(streetList);
        log.debug("----------------End seeder district-----------------");
    }
}
