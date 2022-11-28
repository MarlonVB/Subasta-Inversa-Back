package com.examcomplexivo.subastainversaservices.controllers;

import com.examcomplexivo.subastainversaservices.models.Oferta;
import com.examcomplexivo.subastainversaservices.services.oferta.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/oferta")
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @GetMapping("/listar")
    public List<Oferta> listar(){
        return ofertaService.listar();
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody Oferta oferta, BindingResult result){

//        Optional<Oferta> ofertaBD = ofertaService.findById(oferta.getIdOferta());
//        if(result.hasErrors()){
//            return validar(result);
//        }
//        if (ofertaBD.isPresent()){
//            return ResponseEntity.badRequest().body(
//                    Collections.singletonMap("Mensaje","Esta oferta ya fue registrada")
//            );
//        }
        return  ResponseEntity.status(HttpStatus.CREATED).body(ofertaService.guardar(oferta));
    }

    @PutMapping("/editar/{idOferta}")
    public ResponseEntity<?> editarOderta(@PathVariable(name = "idOferta", required = true)Long idOferta,
                                          @RequestBody Oferta oferta){
        try{
            if (ofertaService.findById(idOferta).isPresent()){
                oferta.setIdOferta(idOferta);
                ofertaService.guardar(oferta);
                return ResponseEntity.ok().body(Collections.singletonMap("mensaje", "Oferta modificada correctamente."));
            }else {
                return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje", "La oferta no existe."));
            }
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{idOferta}")
    public ResponseEntity<?> eliminarOferta (@PathVariable(name = "idOferta", required = true) Long idOferta){
        try{
            if (ofertaService.findById(idOferta).isPresent()){
                ofertaService.eliminar(idOferta);
                return ResponseEntity.ok().body(Collections.singletonMap("mensaje", "Oferta eliminada correctamente."));
            }else {
                return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje", "La oferta no existe."));
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("mensaje", "No se pudo eliminar."));
        }
    }

    @GetMapping("/listar_id/{id}")
    public ResponseEntity<?> listarId(@PathVariable Long id){
        Optional<Oferta> ofertaOptional=ofertaService.findById(id);
        if (ofertaOptional.isPresent()) {

            return ResponseEntity.ok(ofertaOptional.get());
        }
        return ResponseEntity.badRequest().body(
                Collections.singletonMap("Mensaje","No se ha encontrado ninguna oferta")
        );
    }

    @GetMapping("/listar_fecha/{fecha}") //Buscar por fecha
    public ResponseEntity<?> listarFecha(@PathVariable Date fecha){
        Optional<Oferta> ofertaOptional=ofertaService.findByFecha(fecha);
        if (ofertaOptional.isPresent()) {

            return ResponseEntity.ok(ofertaOptional.get());
        }
        return ResponseEntity.badRequest().body(
                Collections.singletonMap("Mensaje","No se ha encontrado ninguna oferta")
        );
    }

    @GetMapping("/listar_estado/{estado}")
    public ResponseEntity<?> listarEstado(@PathVariable Boolean estado){
        Optional<Oferta> ofertaOptional=ofertaService.findByEstado(estado);
        if (ofertaOptional.isPresent()) {

            return ResponseEntity.ok(ofertaOptional.get());
        }
        return ResponseEntity.badRequest().body(
                Collections.singletonMap("Mensaje","No se ha encontrado ninguna oferta")
        );
    }
    private static ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo" + err.getField()
                    + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

}
