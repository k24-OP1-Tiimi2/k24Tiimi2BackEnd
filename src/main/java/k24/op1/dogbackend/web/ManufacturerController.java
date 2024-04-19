package k24.op1.dogbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import k24.op1.dogbackend.domain.Manufacturer;
import k24.op1.dogbackend.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturerlist")
    public String showDogStore(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "manufacturerlist";
    }

    @GetMapping("/addmanufacturer")
    public String addManufacturerForm(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer";
    }

    @PostMapping("/addmanufacturer")
    public String addManufacturer(@Valid Manufacturer manufacturer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addmanufacturer";
        }
        manufacturerRepository.save(manufacturer);
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
                    .orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id: " + id));
            model.addAttribute("manufacturer", manufacturer);
        }
        return "editmanufacturer";
    }
}