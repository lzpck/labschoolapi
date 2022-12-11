package tech.devinhouse.labschoolapi.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschoolapi.model.Professor;
import tech.devinhouse.labschoolapi.service.ProfessorService;
import tech.devinhouse.labschoolapi.web.ProfessorResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/professores")
@AllArgsConstructor
public class ProfessorController {

    private ModelMapper mapper;
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> listarProfessores() {
        List<Professor> professores = professorService.consultar();
        List<ProfessorResponse> professorResponseList = new ArrayList<>();
        for (Professor professor: professores) {
            ProfessorResponse professorResponse = mapper.map(professor, ProfessorResponse.class);
            professorResponseList.add(professorResponse);
        }
        return ResponseEntity.ok(professorResponseList);
    }
}
