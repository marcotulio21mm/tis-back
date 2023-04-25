package com.api.queviagem.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.queviagem.models.PackageModel;
import com.api.queviagem.services.PackageService;

@RestController
@CrossOrigin
@RequestMapping("/packages")

public class PackageController {

    final PackageService packageService;
    
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

	@GetMapping("/get-finished")
	public ResponseEntity<List<PackageModel>> index(@RequestParam(name = "initialDate") LocalDate initialDate,
			@RequestParam(name = "finalDate") LocalDate finalDate) {

		ResponseEntity<List<PackageModel>> all = ResponseEntity.status(HttpStatus.OK)
				.body(packageService.getFinishedPackages(initialDate, finalDate));
		return all;
	}
}