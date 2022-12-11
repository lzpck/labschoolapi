package tech.devinhouse.labschoolapi.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.labschoolapi.model.Pedagogo;
import tech.devinhouse.labschoolapi.model.Professor;
import tech.devinhouse.labschoolapi.service.PedagogoService;
import tech.devinhouse.labschoolapi.service.ProfessorService;
import tech.devinhouse.labschoolapi.web.PedagogoResponse;
import tech.devinhouse.labschoolapi.web.ProfessorResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/pedagogo")
@AllArgsConstructor
public class PedagogoController {

    private ModelMapper mapper;
    private PedagogoService pedagogoService;

    @GetMapping
    public ResponseEntity<List<PedagogoResponse>> listarPedagogo() {
        List<Pedagogo> pedagogos = pedagogoService.consultar();
        List<PedagogoResponse> pedagogoResponseList = new ArrayList<>();
        for (Pedagogo pedagogo: pedagogos) {
            PedagogoResponse pedagogoResponse = mapper.map(pedagogo, PedagogoResponse.class);
            pedagogoResponseList.add(pedagogoResponse);
        }
        return ResponseEntity.ok(pedagogoResponseList);
    }
}
