package com.tenant.resolver.entity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("instruments")
public class InstrumentController {

    private final InstrumentRepository instrumentRepository;

    public InstrumentController(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @GetMapping
    List<Instrument> getInstruments(){
        return instrumentRepository.findAll();
    }

    @GetMapping("{type}")
    List<Instrument> getInstrumentsByType(@PathVariable String type){
        return instrumentRepository.findByType(type);
    }

    @PostMapping
    Instrument getInstrumentsByType(@RequestBody Instrument type){
        return instrumentRepository.save(type);
    }

}
