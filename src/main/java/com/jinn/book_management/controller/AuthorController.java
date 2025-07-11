package com.jinn.book_management.controller;

import com.jinn.book_management.dto.AuthorDto;
import com.jinn.book_management.model.Author;
import com.jinn.book_management.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public List<Author> list() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Author get(@PathVariable Integer id) {
        return authorService.getById(id);
    }

    @PostMapping
    public Author create(@Valid @RequestBody AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());

        return authorService.create(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        authorService.delete(id);

        return ResponseEntity.noContent().build();
    }
}