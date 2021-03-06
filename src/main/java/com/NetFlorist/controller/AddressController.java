/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
//checking git
 * and open the template in the editor.
 */
package com.NetFlorist.controller;

import com.NetFlorist.exceptions.DataNotFoundException;
import com.NetFlorist.model.Address;
import com.NetFlorist.services.AddressService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
//adds the @Controller and @ResponseBody annotations
@RestController
//map web requests onto specific handler classes and/or handler methods.
@RequestMapping(value = "/address")
public class AddressController {
    
    //Marks a constructor, method or config method as to be autowired by Spring's dependency injection facilities. 
    @Autowired
    private AddressService addressService;
    
    //**********************Save Delivary Detatils********************************
    @RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
    //used to bind the HTTP request/response body with a domain object in method parameter or return type
    @ResponseBody
    public Address saveAddress(@RequestBody Address address)
    {
        Address addresses = addressService.saveAddress(address);
          if(addresses == null)
          {
              throw new DataNotFoundException("Address Not Saved...");
          }
        return addresses;
    }
    
    //=====================Get Delivary based on order no============
    @RequestMapping(value = "/findAddressByOrderNo/{orderno}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Address> viewByOrderNo(@PathVariable int orderno)
    {
        ArrayList<Address> addressList =  addressService.findAddressByOrderNo(orderno);
        if(addressList == null)
        {
            throw new DataNotFoundException("Address Not Found...");
        }
        
        return addressList;
    }
}
