package com.soighiri.libraryAp.author;

import ch.qos.logback.core.model.Model;
import com.soighiri.libraryAp.book.BookEntity;
import com.soighiri.libraryAp.exception.ResourceNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/auhtor")
@CrossOrigin
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/authors")
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping(value = "/{authorId}")
    public ResponseEntity<AuthorEntity> getAuthorById(@PathVariable("authorId") Long authorId) {
        Optional<AuthorEntity> authorEntity = authorService.getAuthorById(authorId);
        if (authorEntity.isPresent()) {
            return ResponseEntity.ok(authorEntity.get());
        } else {
            throw new ResourceNotFoundException("Auteur Introuvable avec cet identifiant :: " + authorId);
        }
    }

    @PostMapping(value = "/addAuthor")
    public AuthorEntity createAuthor(@RequestBody AuthorEntity author) {
        return authorService.saveAuthor(author);
    }

    @PutMapping(value = "/updateAuthor/{authorId}")
    public ResponseEntity<AuthorEntity> updateAuthor(@PathVariable("authorId") Long authorId, @RequestBody AuthorEntity author) {
        author.setAuthorId(authorId);
        AuthorEntity updatedAuthor = authorService.updateAuthor(authorId, author);
        if (updatedAuthor != null) {
            return ResponseEntity.ok(updatedAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/delete/{authorId}")
    ResponseEntity<Void>  deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/book/{title}")
    public ResponseEntity<List<AuthorEntity>> getBooksByTitle(@PathVariable("title") String title) {
        List<AuthorEntity> authorEntities = authorService.findAuthorByBookTitle(title);
        return  ResponseEntity.ok(authorEntities);
    }
    @GetMapping(value = "/{authorFirstName}")
    public ResponseEntity<List<AuthorEntity>> getAuthorsByFirstName(@PathVariable("authorFirstName") String firstName) {
        List<AuthorEntity> authorEntities = authorService.findAuthorByFirstName(firstName);
        return  ResponseEntity.ok(authorEntities);
    }
    @GetMapping(value = "/{authorLastName}")
    public ResponseEntity<List<AuthorEntity>> getAuthorsByLastName(@PathVariable("authorLastName") String lastName) {
        List<AuthorEntity> authorEntities = authorService.findAuthorByLastName(lastName);
        return ResponseEntity.ok(authorEntities);
    }
}

