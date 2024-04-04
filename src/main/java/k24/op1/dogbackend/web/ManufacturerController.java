package k24.op1.dogbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import k24.op1.dogbackend.domain.Manufacturer;
import k24.op1.dogbackend.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {


    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturerlist")
    public String showDogStore(Model model) {
        model.addAttribute("products", manufacturerRepository.findAll());
        return "manufacturerlist";
    }

    @GetMapping("/addmanufacturer")
    public String addManufacturerForm(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer";
    }

    @PostMapping("/addmanufacturer")
    public String addManufacturer(@ModelAttribute Manufacturer newManufacturer) {
        manufacturerRepository.save(newManufacturer);
        return "redirect:/manufacturerlist";
    }

    @GetMapping("/deletemanufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") Long id, Model model) {
        if (id != null) {
            manufacturerRepository.deleteById(id);
        }
        return "redirect:/manufacturerlist";
    }

    @GetMapping("/editmanufacturer/{id}")
    public String editManufacturer(@PathVariable("id") Long id, Model model) {
        if (id != null) {
            Manufacturer manufacturer = manufacturerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
            model.addAttribute("manufacturer", manufacturer);
        }
        return "editproduct";
    }
}
