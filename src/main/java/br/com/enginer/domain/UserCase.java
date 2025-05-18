package br.com.enginer.domain;

import java.util.List;
import java.util.Map;

import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.port.inbound.SubscriberInboundPort;
import br.com.enginer.domain.ui.port.outbound.PublisherOutboundPort;
import br.com.enginer.domain.ui.port.outbound.RepositoryOutboundPort;
import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.infrastructure.adapter.outbound.repository.TypeRepository;

public interface UserCase {
	
	void setRepositoryOutboundPort(RepositoryOutboundPort repositoryOutboundPort);
	void setPublisherOutboundPort(PublisherOutboundPort publisherOutboundPort);
	void setSubscriberInboundPort(SubscriberInboundPort subscriberInboundPort);
	
	Domain<?> findById(Domain<?> domain) throws CheckedException;
	
	Domain<?> findByIdComposite(Domain<?> domain, Map<String, Object> ids) throws UncheckedException;
	
	Domain<?> findBySingle(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	Domain<?> findBySingle(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException;
	
	Domain<?> findBySingle(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException;
	
	List<Domain<?>> findAll(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	List<Domain<?>> findAll(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException;
	
	List<Domain<?>> findAll(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException;
	
	List<Domain<?>> findAllById(Domain<?> domain, Object... id) throws UncheckedException;
	
	List<Domain<?>> findAllById(Domain<?> domain, List<?> ids) throws UncheckedException;
	
	PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException;
	
	PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException;
	
	Integer count(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	Integer count(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException;
	
	Integer count(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException;

	boolean existsById(Domain<?> domain, Object id) throws UncheckedException;
	
	void delete(Domain<?> domain) throws UncheckedException;
	
	void delete(Domain<?> domain, List<?> ids) throws UncheckedException;
	
	void delete(Domain<?> domain, Object id) throws UncheckedException;
	
	Domain<?> save(Domain<?> domain) throws UncheckedException;
	
	Domain<?> save(Domain<?> domain, Boolean flush) throws UncheckedException;
	
	List<Domain<?>> save(Domain<?> domain, List<Domain<?>> entities) throws UncheckedException;
	
	List<Domain<?>> save(Domain<?> domain, List<Domain<?>> entities, Boolean flush) throws UncheckedException;

}
