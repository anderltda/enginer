package br.com.enginer.infrastructure.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class DomainAbstractMixIn<T, I> {
    @JsonIgnore public T domain;
    @JsonIgnore public I id;
}