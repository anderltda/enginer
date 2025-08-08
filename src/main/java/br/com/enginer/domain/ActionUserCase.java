package br.com.enginer.domain;

import java.util.List;
import java.util.Map;

import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.port.outbound.PublisherOutboundPort;
import br.com.enginer.domain.ui.port.outbound.RepositoryOutboundPort;
import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.exception.UncheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.infrastructure.adapter.outbound.repository.TypeRepository;

public interface ActionUserCase {
	
	public static final String buscarPorId = "buscarPorId";
	public static final String buscarTodos = "buscarTodos";
	public static final String buscarPorRegistroUnico = "buscarPorRegistroUnico";
	public static final String buscarPorIds = "buscarPorIds";
	public static final String buscarTodosPaginado = "buscarTodosPaginado";
	public static final String existe = "existe";
	public static final String excluir = "excluir";
	public static final String salvar = "salvar";
	public static final String plus = "plus";
	
	void setRepositoryOutboundPort(RepositoryOutboundPort repositoryOutboundPort);
	
	void setPublisherOutboundPort(PublisherOutboundPort publisherOutboundPort);
	
	RepositoryOutboundPort getRepositoryOutboundPort();	
	
	PublisherOutboundPort getPublisherOutboundPort();
	
	Domain<?> buscarPorId(Domain<?> domain) throws CheckedException;
	
	Domain<?> buscarPorRegistroUnico(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	Domain<?> buscarPorRegistroUnico(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException;
	
	Domain<?> buscarPorRegistroUnico(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException;
	
	List<Domain<?>> buscarTodos(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	List<Domain<?>> buscarTodos(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException;
	
	List<Domain<?>> buscarTodos(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException;
	
	List<Domain<?>> buscarPorIds(Domain<?> domain, Object... id) throws UncheckedException;
	
	List<Domain<?>> buscarPorIds(Domain<?> domain, List<?> ids) throws UncheckedException;
	
	PageResult<?> buscarTodosPaginado(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	PageResult<?> buscarTodosPaginado(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException;
	
	PageResult<?> buscarTodosPaginado(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException;
	
	Integer buscarTotal(Domain<?> domain, Map<String, Object> filter) throws UncheckedException;
	
	Integer buscarTotal(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException;
	
	Integer buscarTotal(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException;

	boolean existe(Domain<?> domain) throws UncheckedException;
	
	void excluir(Domain<?> domain) throws UncheckedException;
	
	void excluir(Domain<?> domain, List<?> ids) throws UncheckedException;
	
	void excluir(Domain<?> domain, Object id) throws UncheckedException;
	
	Domain<?> salvar(Domain<?> domain) throws UncheckedException;
	
	Domain<?> salvar(Domain<?> domain, Boolean flush) throws UncheckedException;
	
	List<Domain<?>> salvar(List<Domain<?>> entities) throws UncheckedException;
	
	List<Domain<?>> salvar(List<Domain<?>> entities, Boolean flush) throws UncheckedException;
	
	Domain<?> plus(Domain<?> domain);

}
