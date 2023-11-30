package com.guilherme.vitrine.controllers;

import com.guilherme.vitrine.models.ImageCarrocel;
import com.guilherme.vitrine.models.Newsletter;
import com.guilherme.vitrine.repository.NewsletterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/newsletters"})
public class NewsletterController {
  private final NewsletterRepository repository;

  NewsletterController (NewsletterRepository newsletterRepository){
    this.repository = newsletterRepository;
  }

  @GetMapping()
  public List<Newsletter> list() {
    return repository.findAll();
  }

  @PostMapping(path= {"/save"})
  @ResponseStatus(HttpStatus.CREATED)
  public Newsletter create(@RequestBody Newsletter newsletter){
    return repository.save(newsletter);
  }

  @GetMapping(path={"/verify/{email}"})
  public boolean existsByEmail(@PathVariable String email){
    return repository.existsByEmail(email);
  }


  @GetMapping(path = {"/{id}"})
  public ResponseEntity<Newsletter> findById(@PathVariable Integer id){
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping(path = {"email/{email}"})
  public ResponseEntity<Newsletter> findByEmail(@PathVariable String email){
    return repository.findByEmail(email)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping(value="/{id}")
  public ResponseEntity<Newsletter> update(@PathVariable("id") Integer id,
                                           @RequestBody Newsletter newsletter) {
    return repository.findById(id)
      .map(record -> {
        record.setNome(newsletter.getNome());
        record.setEmail(newsletter.getEmail());
        Newsletter updated = repository.save(record);
        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(value = "delete/{id}")
  public ResponseEntity<Newsletter> deleteNewsletter(@PathVariable(value = "id") Newsletter id) {
    // Access the DB and delete the order
    return ResponseEntity.ok(id);
  }
}
