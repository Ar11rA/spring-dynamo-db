package com.example.dynamo.controllers;

import com.example.dynamo.repository.ProductInfoRepository;
import com.example.dynamo.models.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="api/v1/products")
public class ProductController {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody ProductInfo productInfo) {
        productInfoRepository.save(productInfo);
        return new ResponseEntity<>("Saved", HttpStatus.CREATED);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ProductInfo>> get() {
        Iterable<ProductInfo> products = productInfoRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(path = "/searchByCost", method = RequestMethod.GET)
    public ResponseEntity<Optional<ProductInfo>> getByCost(@RequestParam("cost") String cost) {
        Optional<ProductInfo> product = productInfoRepository.findByCost(cost);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(path = "/searchById", method = RequestMethod.GET)
    public ResponseEntity<Optional<ProductInfo>> getById(@RequestParam("id") String id) {
        Optional<ProductInfo> product = productInfoRepository.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
