package io.aladiex.temp.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.aladiex.temp.entity.Customer;
import io.aladiex.temp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    ObjectMapper mapper;

    @Autowired
    CustomerService service;

    @GetMapping("{id}")
    public ResponseEntity profile(@PathVariable Long id) throws Exception {
        Optional<Customer> c = service.findOne(id);
        return ResponseEntity.ok().body(c.orElse(null));
    }

    @GetMapping("{id}/wallets")
    public ResponseEntity wallets(@PathVariable Long id) throws Exception {
        Optional<Customer> oc = service.findOne(id);
        Customer c = oc.orElse(null);
        assert c != null;
        return ResponseEntity.ok().body(c.getWallets());
    }

    @GetMapping("{id}/wallet")
    public ResponseEntity wallet(@PathVariable Long id, @RequestParam String symbol) throws Exception {
        Optional<Customer> oc = service.findOne(id);
        Customer c = oc.orElse(null);
        assert c != null;
        return ResponseEntity.ok().body(c.getWallets().stream().filter(item -> item.getCurrency().getSymbol().equals(symbol)).collect(Collectors.toList()));
    }

    @GetMapping("{id}/transaction")
    public ResponseEntity transaction(@PathVariable Long id, @RequestParam String symbol) throws Exception {
        Optional<Customer> oc = service.findOne(id);
        Customer c = oc.orElse(null);
        assert c != null;
        return ResponseEntity.ok().body(c.getWallets().stream().filter(item -> item.getCurrency().getSymbol().equals(symbol)).collect(Collectors.toList()).get(0).getTransactions());
    }
}
