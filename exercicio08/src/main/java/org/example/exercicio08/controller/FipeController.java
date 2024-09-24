package org.example.exercicio08.controller;

import org.example.exercicio08.dto.CarInfoDto;
import org.example.exercicio08.service.Fipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class FipeController {

    private final Fipe fipe;

    @Autowired
    public FipeController(Fipe fipe) {
        this.fipe = fipe;
    }

    @GetMapping("/fipe/codigo/marca/{nameBrand}")
    @ResponseBody
    public String getCodeBrand(@PathVariable String nameBrand) {
        return fipe.getBrandCode(nameBrand);
    }

    @GetMapping("/fipe/codigo/modelo/{codeBrand}/{nameModel}")
    @ResponseBody
    public String getCodeModel(@PathVariable String codeBrand, @PathVariable String nameModel) {
        return fipe.getModelCode(codeBrand, nameModel);
    }

    @GetMapping("/fipe/codigo/ano/{codeBrand}/{codeModel}/{nameYear}")
    @ResponseBody
    public String getCodeYear(@PathVariable String codeBrand, @PathVariable String codeModel, @PathVariable String nameYear) {
        return fipe.getYearCode(codeBrand, codeModel, nameYear);
    }

    @PostMapping("/fipe")
    @ResponseBody
    public HashMap<String, String> carValue(@RequestBody CarInfoDto carRequest) {
        String brandCode = fipe.getBrandCode(carRequest.getMarca());
        String modelCode = fipe.getModelCode(brandCode, carRequest.getModelo());
        String yearCode = fipe.getYearCode(brandCode, modelCode, carRequest.getAno());

        return fipe.getValue(brandCode, modelCode, yearCode);
    }
}
