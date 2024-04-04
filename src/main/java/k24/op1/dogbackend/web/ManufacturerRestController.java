package k24.op1.dogbackend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k24.op1.dogbackend.domain.Manufacturer;
import k24.op1.dogbackend.domain.ManufacturerRepository;

@CrossOrigin
@Controller
public class ManufacturerRestController {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/allmanufacturers")
    public @ResponseBody List<Manufacturer> manufacturerListRest() {
        return (List<Manufacturer>) manufacturerRepository.findAll();
    }
}
