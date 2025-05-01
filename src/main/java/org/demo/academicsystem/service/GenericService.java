package org.demo.academicsystem.service;

import java.util.List;

public interface GenericService<Request, Response, ID> {
    List<Response> getAll();
    Response getById(ID id);
    Response create(Request request);
    Response update(ID id, Request request);
    void delete(ID id);
}
