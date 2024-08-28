package com.code.Question1.tester;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import entity.HashGenerator;
import entity.RandomStringGenerator;
import jsonfiles.JsonFileReader;
import jsonfiles.JsonParser;

public class DestinationHashGenerator {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar DestinationHashGenerator.jar 240340120204 E:\\Cdac\\bajaj");
            return;
        }

        String prnNumber = args[0].toLowerCase().replace(" ", "");
        String jsonFilePath = args[1];

        try {
            // Parse the JSON file and find the destination value
            String jsonContent = JsonFileReader.readJsonFile(jsonFilePath);
            String destinationValue = JsonParser.findDestinationValue(jsonContent);

            if (destinationValue == null) {
                System.out.println("No 'destination' key found in the JSON file.");
                return;
            }

            
            String randomString = RandomStringGenerator.generateRandomString(8);
           
            String concatenatedString = prnNumber + destinationValue + randomString;

            String md5Hash = HashGenerator.generateMD5Hash(concatenatedString);


        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
