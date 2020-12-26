package work.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import work.DAO.IDao;
import work.DAO.SedanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import work.model.Sedan;

import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/sedan")
public class SedanController {
    @Autowired
    private IDao sedanDao;
    public void setSedanDao(SedanDao sedanDao) {
        this.sedanDao = sedanDao;
    }

    @RequestMapping(value = "/index")
    public String showAll(Model model){
        List<Sedan> sedans = null;
        try {
            sedans = sedanDao.getAll();
        } catch (SQLException e) {
            return "redirect:/error";
        }
        model.addAttribute("list", sedans);
        return "index";
    }

    @RequestMapping(value = "getOne/{id}")
    public String showOne(@PathVariable(value = "id") int id, Model model){
        Sedan sedan = null;
        try {
            sedan = sedanDao.getOne(id);
        } catch (SQLException e) {
            return "redirect:/error";
        }
        model.addAttribute("item", sedan);
        return "details";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        try {
            sedanDao.delete(id);
        } catch (SQLException e) {
            return "redirect:/error";
        }
        return "redirect:/sedan/index";
    }

    @RequestMapping(value = "/addNewForm")
    public String addNewForm(Model model){
        try{
            model.addAttribute("command", new Sedan());
            return "addCar";
        }catch (Exception e){
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public String addNew(@ModelAttribute(value = "command") Sedan sedan){
        try {
            sedanDao.addNew(sedan);
        } catch (SQLException e) {
            return "redirect:/error";
        }
        return  "redirect:/sedan/index";
    }

    @RequestMapping(value = "modifyForm/{id}")
    public String modifyForm(@PathVariable(value = "id") int id, Model model) {
        Sedan sedan = null;
        try {
            sedan = sedanDao.getOne(id);
            model.addAttribute("item", sedan);
            return "modifyCar";
        } catch (SQLException e) {
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(@ModelAttribute(value = "item") Sedan sedan){
        try {
            sedanDao.update(sedan);
            return "redirect:/sedan/index";
        } catch (SQLException e) {
            return "error";
        }
    }
}
