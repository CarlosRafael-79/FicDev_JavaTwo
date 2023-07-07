package com.course.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.course.escola.model.Turma;
import com.course.escola.repository.TurmaRepository;

@Controller
@RequestMapping("/turma")
public class TurmaController {
	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping("/lista")
	public ModelAndView listaTurma(Turma turma) {
		ModelAndView modelAndView = new ModelAndView("lista");
		List<Turma> turmas = turmaRepository.findAll();
		modelAndView.addObject("turmas", turmas);
		return modelAndView;
	}
	
	@GetMapping
	public String exibeForm(Turma turma) {
		return "add-turma";
	}
	
	@PostMapping
	public ModelAndView addTurma(Turma turma) {
		turmaRepository.save(turma);
		ModelAndView modelAndView = new ModelAndView("add-turma");
		modelAndView.addObject("mensagem", "Salvo com sucesso!");
		return modelAndView;
	}
	
	@GetMapping("/delete")
	public String deleteTurma(@RequestParam Integer id) {
		turmaRepository.deleteById(id);
		return "redirect:/turma/lista";
	}

}
