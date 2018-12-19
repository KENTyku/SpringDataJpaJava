package com.ardecs.SpringDataJpaJava.controller.restful;

import com.ardecs.SpringDataJpaJava.Entity.Country;
import com.ardecs.SpringDataJpaJava.Entity.Product;
import com.ardecs.SpringDataJpaJava.Repository.CountryRepository;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

//@Validated
@RestController
public class CountryRESTFulController {
    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = {"/country/{id}"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Country getCountry(@PathVariable long id, HttpServletResponse response) throws IOException {
        try {
            Country country = countryRepository.findById(Long.valueOf(id)).orElseThrow(NoSuchElementException::new);
            return country;
        } catch (NoSuchElementException e) {
        }
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Country with ID=" + id + " no found");
        return null;
    }

    @RequestMapping(value = {"/country/{id}"}, method = RequestMethod.PUT)
    public void updateCountry(@PathVariable long id, String name, HttpServletResponse response) throws IOException {
        if (null == name) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Name of country can't be null");
        } else {
            try {
                Country country = countryRepository.findById(id).orElseThrow(NoSuchElementException::new);
                if (null != countryRepository.findByName(name)) {
                    throw new SQLException();
                }
                country.setName(name);
                countryRepository.save(country);
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (NoSuchElementException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Country with ID=" + id + " no found ");
            } catch (SQLException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Name of country:" + name + " is used");
            }
        }
    }

    @RequestMapping(value = {"/country/{id}"}, method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable @Valid @Pattern(regexp = "^[1-9][0-9]+") long id, BindingResult result,HttpServletResponse response) throws IOException {
        try {
            if (result.hasFieldErrors("id")) {
                throw new ValidationException();
            }
            if (null == countryRepository.findById(Long.valueOf(id))) {
                throw new NoSuchElementException();
            }
            countryRepository.deleteById(id);
        }catch (ValidationException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Bad countrie's param  ID="+id);
        }catch (NoSuchElementException e){
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entity Country with ID=" + id + " no found ");
        }
    }

    @RequestMapping(value = {"/country"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCountry(@Valid Country country, HttpServletResponse response, BindingResult result) throws
            BindException {
        if (result.hasErrors()) {
            throw new BindException(result);
        }
        countryRepository.save(country);
        response.setHeader("Location", "/country/" + country.getId());
    }
}
