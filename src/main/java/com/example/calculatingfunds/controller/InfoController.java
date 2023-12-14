package com.example.calculatingfunds.controller;


import com.example.calculatingfunds.entity.Info;
import com.example.calculatingfunds.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class InfoController {
    private final InfoService infoService;

    private int infoUpdateId;

    @RequestMapping({"/","/welcome"})
    public String LandingPage(Model model){
        model.addAttribute("info",new Info());
        model.addAttribute("list",infoService.findAllInfo());
        double totalAmount = infoService.calculateTotalAmount();
        model.addAttribute("total",totalAmount);
        return "welcome";
    }
    @ModelAttribute("infoSize")
    public Integer infoSize(){
        return infoService.infoSize();
    }


    @PostMapping("/save-info")
    public String saveData(Info info, BindingResult result) {
        if (result.hasErrors()) {
            return "welcome";
        }
        infoService.saveInfo(info);
        return "redirect:/welcome";
    }
    @GetMapping("/edit/info")
    public String editInfo(@RequestParam("id")int id,Model model){
        model.addAttribute("info",
                infoService.findInformationById(id));
        this.infoUpdateId=id;
        return "editForm";
    }


    @PostMapping("/info/edit")
    public String saveEditInfo(Info info,BindingResult result){
        if (result.hasErrors()){
            return "editForm";
        }
        info.setId(infoUpdateId);
        infoService.editInfo(info);
        return "redirect:/welcome";

    }
    @GetMapping("list-info")
    public String listInfo(Model model){
        model.addAttribute("list",
                infoService.findAllInfo());
        return "welcome";
    }
    @GetMapping("/info/delete")
    public String deleteUser(@RequestParam("id")int id){
        infoService.deleteInfo(id);
        return"redirect:/welcome";
    }
}
