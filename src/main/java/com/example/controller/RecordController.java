package com.example.controller;

import com.example.entity.Client;
import com.example.entity.Record;
import com.example.service.ClientService;
import com.example.service.RecordService;
import com.example.validation.forms.RecordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Roma on 06.03.2017.
 */
@Controller
public class RecordController extends WebMvcConfigurerAdapter{

    @Autowired
    private RecordService recordService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/hello")
    public String hello(RecordForm recordForm, Model model, HttpServletRequest request) {
        Client client = this.clientService.findClient(request.getRemoteUser());

        if (request.getParameter("first_name") != null) {

            List<Record> recordList = this.recordService.searchByClientAndFirstName(client, request.getParameter("filtr1"));
            model.addAttribute("records", recordList);

        } else if (request.getParameter("last_name") != null) {

            List<Record> recordList = this.recordService.searchByClientAndLastName(client, request.getParameter("filtr2"));
            model.addAttribute("records", recordList);

        } else if (request.getParameter("tel_number") != null) {

            List<Record> recordList = this.recordService.findByClientAndMobileTel(client, request.getParameter("filtr3"));
            model.addAttribute("records", recordList);

        } else if (request.getParameter("dis_filtr") != null) {

            List<Record> recordList = client.getRecords();
            model.addAttribute("records", recordList);

        } else {
            List<Record> recordList = client.getRecords();
            model.addAttribute("records", recordList);
        }
        return "hello";
    }

    @PostMapping("/hello")
    public String saveRecord(@Valid RecordForm recordForm,
                             BindingResult bindingResult, HttpServletRequest request, Model model) {
        if (bindingResult.hasErrors()) {
            return hello(recordForm, model, request);
        } else {
            Record record = new Record();
            record.setFirstName(recordForm.getFirstName());
            record.setLastName(recordForm.getLastName());
            record.setMiddleName(recordForm.getMiddleName());
            record.setMobileTel(recordForm.getMobileTel());
            record.setHomeTel(recordForm.getHomeTel());
            record.setAddress(recordForm.getAddress());
            record.setMail(recordForm.getMail());
            record.setClient(this.clientService.findClient(request.getRemoteUser()));
            this.recordService.addRecord(record);
            return "redirect:/hello?par=success";
        }
    }

    @GetMapping("/hello/remove/{id}")
    public String removePerson(@PathVariable("id") Long id){
        this.recordService.deleteRecord(id);
        return "redirect:/hello?del=success";
    }
}
