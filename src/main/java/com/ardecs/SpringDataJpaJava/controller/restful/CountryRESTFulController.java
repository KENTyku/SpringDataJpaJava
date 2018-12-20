package com.ardecs.SpringDataJpaJava.controller.restful;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryRESTFulController {
    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = {"/country/{id}"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Country getCountry(@PathVariable long id, HttpServletResponse response) throws IOException {
        try {
            Country country = countryRepository.findById(Long.valueOf(id)).get();
            return country;
        } catch (NoSuchElementException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Country with ID=" + id + " no found");
            return null;
        }

    }

    @RequestMapping(value = {"/country/{id}"}, method = RequestMethod.PUT)
    public void updateCountry(@PathVariable long id, String name, HttpServletResponse response) throws IOException {
        if (null == name || name.equals("")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Name of country can't be empty");
        } else {
            try {
                Country country = countryRepository.findById(id).get();
                country.setName(name);
                countryRepository.save(country);
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (NoSuchElementException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Country with ID=" + id + " no found ");
            } catch (JpaSystemException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Name of country:" + name + " is used");
            }
        }
    }

    @RequestMapping(value = {"/country/{id}"}, method = RequestMethod.DELETE)
    public void deleteCountry(@PathVariable long id, HttpServletResponse response) throws IOException {
        try {
            countryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Country with ID=" + id + " no found ");
        } catch (JpaSystemException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Bad countrie's param  ID=" + id + ". " +
                    "This ID can't delete because it's use ");
        }
    }

    @RequestMapping(value = {"/country"}, method = RequestMethod.POST)
    public void createCountry(String name, HttpServletResponse response) throws IOException {

        if (null == name || name.equals("")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Name of country can't be empty");
        } else {
            try {
                Country country = new Country();
                country.setName(name);
                countryRepository.save(country);
                response.setHeader("Location", "/country/" + country.getId());
                response.setStatus(HttpServletResponse.SC_CREATED);
            } catch (JpaSystemException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Name of country:" + name + " is used");
            }
        }
    }

}
