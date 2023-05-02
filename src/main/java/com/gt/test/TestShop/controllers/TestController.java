package com.gt.test.TestShop.controllers;

import com.gt.test.TestShop.models.TestOrder;
import com.gt.test.TestShop.servises.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {

    TestService service;

    @Autowired
    public TestController(TestService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("orders", service.index());
        return "TestOrder/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model){
        model.addAttribute("testorder", service.show(id));
        return "TestOrder/show";
    }

    @GetMapping("/new")
    public String newTestOrder(@ModelAttribute("testorder") TestOrder testOrder){
        return "TestOrder/create";
    }

    @PostMapping()
    public String create(@ModelAttribute("testorder") TestOrder testOrder){
        service.save(testOrder);
        return "redirect:/test";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("testorder",service.show(id));
        return "TestOrder/edit";
    }

    @PatchMapping("/{id}")
    public String patch(@PathVariable String id,@ModelAttribute("testorder") TestOrder testOrder){
        service.save(testOrder);
        return "redirect:/test/"+id;

    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/test";
    }

}
