package com.carlos.app.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carlos.app.model.Nutricionista;
import com.carlos.app.service.NutricionistaService;

@Controller
@RequestMapping("/nutricionista")
public class NutricionistaView {
	@Autowired
	NutricionistaService nutricionistaService;
	
	
	@GetMapping("/listar")
	public ModelAndView listarNutricionista() {
		ModelAndView modelAndView = new ModelAndView("listarNutricionista");
		List<Nutricionista> nutricionistas = nutricionistaService.getAllNutricionistas();
		modelAndView.addObject("nutricionistas",nutricionistas);
		return modelAndView;
	}
	
	@GetMapping("/remover/{id}")
    public String removerTurma(@PathVariable("id") int id) throws NotFoundException {
		nutricionistaService.deleteNutricionista(id);
        return "redirect:/nutricionista/listar";
    }

	
	
}
