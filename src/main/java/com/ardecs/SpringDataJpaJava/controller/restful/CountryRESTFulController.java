package com.ardecs.SpringDataJpaJava.controller.restful;

import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class CountryRESTFulController {
    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = {"/country/{id}"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Country getCountry(@PathVariable long id) {
        Country country = countryRepository.findById(Long.valueOf(id)).orElseThrow(IllegalStateException::new);
        return country;
    }

    @RequestMapping(value = {"/country/{id}"}, method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product putCountry(@PathVariable long id, Country country) {
        country.setId(id);
        countryRepository.save(country);
        return null;
    }

    @RequestMapping(value = {"/country/{id}"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product deleteCountry(@PathVariable long id) {
        countryRepository.deleteById(id);
        return null;
    }

    @RequestMapping(value = {"/country"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Product postCountry(@Valid Country country, HttpServletResponse response, BindingResult result) throws BindException {
        if(result.hasErrors()){
            throw new BindException(result);
        }
        countryRepository.save(country);
        response.setHeader("Location","/country/"+country.getId());
        return null;
    }
}
