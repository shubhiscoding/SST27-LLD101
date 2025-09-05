package com.example.imports;

import java.nio.file.Path;

public class CsvProfileImporter implements ProfileImporter{
    NaiveCsvReader csvReader;
    ProfileService profileService;

    CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService){
        this.csvReader = csvReader;
        this.profileService = profileService;
    }

    @Override
    public int importFrom(Path csvFile) {
        int count = 0;
        for(String[] row : csvReader.read(csvFile)){
            profileService.createProfile(row[0], row[1], row[2]);
            count++;
        }
        return count;
    }
    
}
