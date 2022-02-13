package com.athira.fleetapp.controllers;

import com.athira.fleetapp.entities.Client;
import com.athira.fleetapp.entities.Invoice;
import com.athira.fleetapp.services.ClientService;
import com.athira.fleetapp.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired	private ClientService clientService;


    @GetMapping("/invoices")
    public String getInvoices(Model model) {
//        List<Invoice> invoiceList = invoiceService.getInvoices();
//        model.addAttribute("invoices", invoiceList);
//
//        List<Client> countryList = countryService.getClients();
//        model.addAttribute("countries", countryList);

        model.addAttribute("invoices", invoiceService.getInvoices());
        model.addAttribute("clients", clientService.getClients());

        return "Invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id) {
        return invoiceService.findById(id);
    }

    @RequestMapping(value="/invoices/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value="/invoices/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }

}
