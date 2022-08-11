package com.halyk.bookstore.service.impl;

import com.halyk.bookstore.data.representation.PublisherRepresentation;
import com.halyk.bookstore.data.request.PublisherRequest;
import com.halyk.bookstore.data.entity.Publisher;
import com.halyk.bookstore.data.mapper.PublisherMapper;
import com.halyk.bookstore.data.repository.PublisherRepository;
import com.halyk.bookstore.service.PublisherService;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository repository;

    private final PublisherMapper mapper;

    @Transactional
    @Override
    public PublisherRepresentation getPublisherById(Long id){
        Publisher publisher = repository.findByIdOrThrowException(id);
        return mapper.fromEntity(publisher);
    }

    @Transactional
    @Override
    public List<PublisherRepresentation> getAllPublisher() {
        List<Publisher> all = repository.findAll();
        return all.stream().map(mapper::fromEntity).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Long savePublisher(PublisherRequest publisherDto) {
        Publisher publisher = mapper.toEntity(publisherDto);
        Publisher save = repository.save(publisher);
        return save.getId();
    }

    @Transactional
    @Override
    public PublisherRepresentation getPublisherByName(String name) {
        Publisher publisher = repository.findPublisherByName(name);
        return mapper.fromEntity(publisher);
    }

    @Transactional
    @Override
    public void updatePublisher(Long id, PublisherRequest publisherDto) {
        Publisher publisher = repository.findByIdOrThrowException(id);
        mapper.updateEntity(publisher, publisherDto);
        repository.save(publisher);
    }

    @Transactional
    @Override
    public Long delete(Long id) {
        return repository.deletePublisherById(id);
    }


}