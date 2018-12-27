package com.ardecs.SpringDataJpaJava.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.CategoryRepository;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SaveProductController {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    final Random random = new Random();
    private float price;

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(
            @RequestParam("id") long id,
            @RequestParam("name") String name,
            @RequestParam("comment") String comment,
            @RequestParam("price") String priceString,
            @RequestParam("countryId") long countryId,
            @RequestParam("categoryId") long categoryId,
            @RequestParam(value = "image", required = false) MultipartFile image
    ) throws IOException {
        try {
            price = Float.parseFloat(priceString);
        } catch (NumberFormatException ex) {
            return "redirect:home";
        }

        if (name == null || name.isEmpty()) {
            name = String.valueOf(random.nextInt(10000000) + 1);
        }
        if (comment == null || comment.isEmpty()) {
            comment = String.valueOf(random.nextInt(10000000) + 1);
        }
        Country country = countryRepository.findById(countryId).get();
        Category category = categoryRepository.findById(categoryId).get();

        Product product = new Product(price, name, comment, country, category);

        if (id != 0) {
            product = productRepository.findById(id).get();
            product.setName(name);
            product.setComment(comment);
            product.setCountry(country);
            product.setCategory(category);
            product.setPrice(price);
            if (!image.isEmpty()) {
                System.out.println("TEST!!!!!!1" + image.getOriginalFilename());
                saveImage("image_" + id + "_" + image.getOriginalFilename(), image);

            }
        }
        productRepository.save(product);
        return "redirect:/";
    }

    private void saveImage(String filePath, MultipartFile image) throws IOException {
//
//        try {
//            File file =new File(webRootPath + "/resources/" + filePath)
//            FileOutputStream fileOutputStream=new FileOutputStream(file);
////            fileOutputStream.write();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        BufferedWriter w = Files.newBufferedWriter(Paths.get(filePath));
        w.write(new String(image.getBytes()));
        w.flush();
    }
}
