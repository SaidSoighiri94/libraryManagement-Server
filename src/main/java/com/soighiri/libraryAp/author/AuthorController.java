package com.soighiri.libraryAp.author;

import ch.qos.logback.core.model.Model;
import com.soighiri.libraryAp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/library")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping(value = "/authors")
        public List<AuthorEntity> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    @GetMapping(value = "/{authorId}")
    public ResponseEntity<AuthorEntity> getAuthorById(@PathVariable("authorId") Long authorId){
        Optional<AuthorEntity> authorEntity = authorService.getAuthorById(authorId);
        if(authorEntity.isPresent()){
            return ResponseEntity.ok(authorEntity.get());
        } else {
            throw new ResourceNotFoundException("Auteur Introuvable avec cet identifiant :: "+authorId);
        }
    }

    @PostMapping
    public AuthorEntity createAuthor(@RequestBody AuthorEntity author){
        return authorService.saveAuthor(author);
    }
    @PutMapping(value = "/{authorId}")
    public ResponseEntity<AuthorEntity> updateAuthor(@PathVariable("authorId") Long authorId, @RequestBody AuthorEntity author){
        AuthorEntity updatedAuthor = authorService.updateAuthor(authorId, author);
        return ResponseEntity.ok(updatedAuthor);
    }

}
