package org.demo.academicsystem.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GenericService<Request, Response, ID> {
    List<Response> getAll();
    Response getById(ID id);
    @Transactional
    Response create(Request request);
    @Transactional
    Response update(ID id, Request request);
    @Transactional
    void delete(ID id);
}
