package com.guilherme.vitrine.controllers;

import com.guilherme.vitrine.models.ImageCarrocel;
import com.guilherme.vitrine.repository.ImageCarrocelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/imagecarrocel"})
public class ImageCarrocelController {

  private final ImageCarrocelRepository repository;

  ImageCarrocelController(ImageCarrocelRepository imageCarrocelRepository) {
    this.repository = imageCarrocelRepository;
  }

  @GetMapping()
  public @ResponseBody List<ImageCarrocel> list() {
  //public List<ImageCarrocel> list() {
    return repository.findAll();
  }

  @PostMapping(path = {"/save"})
  @ResponseStatus(code = HttpStatus.CREATED)
  public ImageCarrocel create(@RequestBody ImageCarrocel imageCarrocel){
   // System.out.println(imageCarrocel.getDescricao());
    return repository.save(imageCarrocel);
  }
  /*public ImageCarrocel create(@RequestBody ImageCarrocel imageCarrocel) {
    return repository.save(imageCarrocel);
  }*/

  @GetMapping(path = {"/{id}"})
  public ResponseEntity<ImageCarrocel> findById(@PathVariable long id) {
    return repository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping(value = "edit/{id}")
  public ResponseEntity<ImageCarrocel> updateImageCarrocel(@PathVariable("id") long id,
                                              @RequestBody ImageCarrocel imageCarrocel) {
    Optional<ImageCarrocel> imageCarrocelData = repository.findById(id);

    if (imageCarrocelData.isPresent()) {
      ImageCarrocel _imageCarrocel = imageCarrocelData.get();
      _imageCarrocel.setDescricao(imageCarrocel.getDescricao());
      _imageCarrocel.setEnderecoImagem(imageCarrocel.getEnderecoImagem());
      return new ResponseEntity<>(repository.save(_imageCarrocel), HttpStatus.OK);
    }
    else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @DeleteMapping("/delete/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
      repository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
