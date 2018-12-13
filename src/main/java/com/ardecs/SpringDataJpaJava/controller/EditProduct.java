package com.ardecs.SpringDataJpaJava.controller;

import java.util.ArrayList;
import java.util.List;

import com.ardecs.SpringDataJpaJava.Entity.Category;
import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.OrderPosition;
import com.ardecs.SpringDataJpaJava.Entity.OrderPositionId;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.CategoryRepository;
import com.ardecs.SpringDataJpaJava.Repository.ClientRepository;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderPositionRepository;
import com.ardecs.SpringDataJpaJava.Repository.OrderRepository;
import com.ardecs.SpringDataJpaJava.Repository.ProductRepository;
import com.ardecs.SpringDataJpaJava.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditProduct {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderPositionRepository orderPositionRepository;
    private OrderPositionId id;
    @Autowired
    private ReportRepository reportRepository;

    @RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") String id, Model model) {
        List<Country> countriesList = (ArrayList<Country>) countryRepository.findAll();
        List<Category> categoriesList = (ArrayList<Category>) categoryRepository.findAll();
        model.addAttribute(countriesList);
        model.addAttribute(categoriesList);
        Product product = new Product();
        if (!id.equals("new")) {
            product = productRepository.findById(Long.valueOf(id)).get();
        }
        model.addAttribute(product);
        return "EditProduct"; // Вернуть имя представления
    }

//    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
//    public String saveProduct(Product product, Model model) {
//        model.addAttribute(product);
////        ArrayList<Product>productList=туц
//        //TODO не работает выборка категории и страны при добавлении/измененеии товара. Пока сделана ниже заглушка
////        String countryName=product.getCountry().getName();
////        product.setCountry(countryRepository.findByName(countryName));
////        String categoryName=product.getCategory().getCategoryName();
////        product.setCategory(categoryRepository.findByName(categoryName));
//        product.setCategory(categoryRepository.findByName("Mobile"));
//        product.setCountry(countryRepository.findByName("USA"));
////        if (!productRepository.existsById(product.getId())) {
//        productRepository.save(product);
//
//        //TODO добавить в модель продукты для корректного обновления
////        }
////        return " redirect:productList";
//        return "productList";
//    }
//
//    @RequestMapping(value = "/productList", method = RequestMethod.GET)
//    public String showProductList(Model model) {
//        ArrayList<Product> productList = (ArrayList<Product>) productRepository.findAll();
//        model.addAttribute(productList);
//        return "productList";
//    }
//
////    @RequestMapping(value = "/listOrder", method = RequestMethod.GET)
////    public String showListOrder(@ModelAttribute("orderPosition") OrderPosition orderPosition) {
////        return "listOrder";
////    }
}