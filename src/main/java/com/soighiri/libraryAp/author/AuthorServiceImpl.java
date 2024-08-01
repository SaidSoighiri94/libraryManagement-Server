package com.soighiri.libraryAp.author;

import com.soighiri.libraryAp.book.BookEntity;
import com.soighiri.libraryAp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<AuthorEntity> getAuthorById(Long authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public AuthorEntity saveAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {

    }

    @Override
    public List<AuthorEntity> findAuthorByBookTitle(String title) {
        return authorRepository.findAuthorsByBookTitle(title);
    }

    @Override
    public AuthorEntity updateAuthor(Long authorId, AuthorEntity author) {
        return authorRepository.findById(authorId)
                .map(existingAuthor -> {
                    existingAuthor.setAuthorFirstName(author.getAuthorFirstName());
                    existingAuthor.setAuthorLastName(author.getAuthorLastName());
                    existingAuthor.setAuthorEmail(author.getAuthorEmail());
                    existingAuthor.setAuthorAddress(author.getAuthorAddress());
                    existingAuthor.setBiography(author.getBiography());
                    return authorRepository.save(existingAuthor);
                } )
                .orElseThrow(()->new ResourceNotFoundException("Aucun auteur avec l'identifiant " +authorId));
    }

    @Override
    public List<AuthorEntity> findAuthorByFirstName(String authorFirstName) {
        return authorRepository.findByAuthorFirstName (authorFirstName);
    }

    @Override
    public List<AuthorEntity> findAuthorByLastName(String authorLastName) {
        return authorRepository.findByAuthorLastName(authorLastName);
    }

    @Override
    public List<BookEntity> findBooksByAuthorId(Long authorId) {
        return authorRepository.findById(authorId)
                .map(AuthorEntity::getBooks)
                .orElseThrow(()-> new ResourceNotFoundException("Aucun livre ave l'identifiant de l'auteur suivant " +authorId));
    }
}
