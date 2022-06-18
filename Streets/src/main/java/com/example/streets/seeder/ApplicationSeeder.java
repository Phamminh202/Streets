package com.example.streets.seeder;

import com.example.streets.entity.District;
import com.example.streets.entity.Street;
import com.example.streets.entity.myenum.StreetStatus;
import com.example.streets.repository.DistrictRepository;
import com.example.streets.repository.StreetRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ApplicationSeeder implements CommandLineRunner {

    boolean createSeedData = false;
    final DistrictRepository districtRepository;
    final StreetRepository streetRepository;
    Faker faker;
    int numberOfDistrict = 10;
    int numberOfStreet = 500;

    public ApplicationSeeder(DistrictRepository districtRepository,
            StreetRepository streetRepository) {
        this.districtRepository =districtRepository;
        this.streetRepository= streetRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        if(createSeedData){
            districtRepository.deleteAll();
            streetRepository.deleteAll();
            seedDistrict();
            seedStreet();

        }
    }
    private void seedStreet() {
        List<District> districts = districtRepository.findAll();
        List<Street> streetList = new ArrayList<>();
        for (int i = 0; i < numberOfStreet; i++) {
            Street street = new Street();
            street.setId(UUID.randomUUID().toString());
            street.setName(faker.address().cityName());
            District randomDistrict = districts.get(faker.number().numberBetween(0, districts.size() - 1));
            street.setDistrict(randomDistrict);
            street.setStatus(StreetStatus.InUse);
            streetList.add(street);
        }
        streetRepository.saveAll(streetList);
    }

    private void seedDistrict() {
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
    }

    public static void main(String[] args) {

    }
}
