package br.edu.atitus.paradigma.saudacao_service;

import br.edu.atitus.paradigma.saudacao_service.config.SaudacaoConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("saudacao-service")
public class SaudacaoController {

	private final SaudacaoConfig saudacaoConfig;

	public SaudacaoController(SaudacaoConfig saudacaoConfig) {
		super();
		this.saudacaoConfig = saudacaoConfig;
	}

	@GetMapping({"", "/", "/{nomePath}"})
	public ResponseEntity<String> getSaudacao(
			@RequestParam(required = false) String nome,
			@PathVariable(required = false) String nomePath){
		String template = "%s %s!";
		if (nome == null) nome 
		        = nomePath == null ? saudacaoConfig.getNomePadrao() : nomePath;
		return ResponseEntity.ok(
				String.format(template, saudacaoConfig.getSaudacao(), nome));
	}
}
