package com.ardecs.SpringDataJpaJava.controller;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    private final Random random = new Random();
    private float price;

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(
            @RequestParam("id") long id,
            @RequestParam("name") String name,
            @RequestParam("comment") String comment,
            @RequestParam("price") String priceString,
            @RequestParam("countryId") long countryId,
            @RequestParam("categoryId") long categoryId,
            @RequestParam(value = "image", required = false) MultipartFile image,
            HttpServletRequest request
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
                String rootPath = request.getSession().getServletContext().getRealPath("/");
//                File dir = new File(rootPath + File.separator + "img");
                File dir = new File(rootPath + "/resources");
//                dir.mkdirs();
                String fileName = "name_" + String.valueOf(random.nextInt(10000000) + 1) + image.getOriginalFilename();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
                serverFile.createNewFile();
                try {
                    try (InputStream is = image.getInputStream();
                         BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                        int i;
                        while ((i = is.read()) != -1) {
                            stream.write(i);
                        }
                        stream.flush();
                    }
                } catch (IOException e) {
                    System.out.println("error : " + e.getMessage());
                }

//                saveImage(filePath, image);
                product.setImageUrl(fileName);
            }
        }
        productRepository.save(product);
        return "redirect:/";
    }

    private void saveImage(String filePath, MultipartFile image) throws IOException {
        BufferedWriter w = Files.newBufferedWriter(Paths.get(filePath));
        w.write(new String(image.getBytes()));
        w.flush();
    }
}
