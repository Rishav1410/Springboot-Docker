package com.example.demo.Data.Domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public abstract class Entity<TEntity> {
    @Id
    private TEntity id;
}