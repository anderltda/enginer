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
import br.com.enginer.domain.ui.usercase.utils.ReflectionUtils;
import br.com.enginer.infrastructure.adapter.outbound.repository.TypeRepository;

/**
 * 
 */
public abstract class AbstractUserCase implements UserCase {
	
	protected RepositoryOutboundPort repositoryOutboundPort;
	protected PublisherOutboundPort publisherOutboundPort;
	protected SubscriberInboundPort subscriberInboundPort;

	/**
	 *
	 */
	@Override
	public void setRepositoryOutboundPort(RepositoryOutboundPort repositoryOutboundPort) {
		this.repositoryOutboundPort = repositoryOutboundPort;
	}
	
	/**
	 *
	 */
	@Override
	public void setPublisherOutboundPort(PublisherOutboundPort publisherOutboundPort) {
		this.publisherOutboundPort = publisherOutboundPort;
	}

	/**
	 *
	 */
	@Override
	public void setSubscriberInboundPort(SubscriberInboundPort subscriberInboundPort) {
		this.subscriberInboundPort = subscriberInboundPort;
	}

	/**
	 *
	 */
	@Override
	public Domain<?> buscarPorId(Domain<?> domain) throws CheckedException {

		if (domain.getId() != null) {
			try {
				
				if (ReflectionUtils.extractIsJavaLangType(domain.getId().getClass())) {
					return repositoryOutboundPort.findById(domain, domain.getId());
				}

				Map<String, Object> ids = ReflectionUtils.getCompositedKeyFields(domain);
				return repositoryOutboundPort.findByIdComposite(domain, ids);
				
			} catch (Exception ex) {
				throw new CheckedException(ex.getMessage(), ex);
			}

		}
		return null;
	}

	/**
	 *
	 */
	@Override
	public Domain<?> buscarPorRegistroUnico(Domain<?> domain, Map<String, Object> filter) throws UncheckedException {
		return repositoryOutboundPort.findBySingle(domain, filter);
	}

	/**
	 *
	 */
	@Override
	public Domain<?> buscarPorRegistroUnico(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException {
		return repositoryOutboundPort.findBySingle(domain, filter, method);
	}

	/**
	 *
	 */
	@Override
	public Domain<?> buscarPorRegistroUnico(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException {
		return repositoryOutboundPort.findBySingle(domain, filter, typeRepository, queryName);
	}
	
	/**
	 *
	 */
	@Override
	public List<Domain<?>> buscarTodos(Domain<?> domain, Map<String, Object> filter) throws UncheckedException {
		return repositoryOutboundPort.findAll(domain, filter);
	}

	/**
	 *
	 */
	@Override
	public List<Domain<?>> buscarTodos(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException {
		return repositoryOutboundPort.findAll(domain, filter, method);
	}

	/**
	 *
	 */
	@Override
	public List<Domain<?>> buscarTodos(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException {
		return repositoryOutboundPort.findAll(domain, filter, typeRepository, queryName);
	}

	/**
	 *
	 */
	@Override
	public List<Domain<?>> buscarPorIds(Domain<?> domain, Object... id) throws UncheckedException {
		return repositoryOutboundPort.findAllById(domain, id);
	}

	/**
	 *
	 */
	@Override
	public List<Domain<?>> buscarPorIds(Domain<?> domain, List<?> ids) throws UncheckedException {
		return repositoryOutboundPort.findAllById(domain, ids);
	}

	/**
	 *
	 */
	@Override
	public PageResult<?> buscarTodosPaginado(Domain<?> domain, Map<String, Object> filter) throws UncheckedException {
		return repositoryOutboundPort.paginator(domain, filter);
	}

	/**
	 *
	 */
	@Override
	public PageResult<?> buscarTodosPaginado(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException {
		return repositoryOutboundPort.paginator(domain, filter, method);
	}

	/**
	 *
	 */
	@Override
	public PageResult<?> buscarTodosPaginado(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException {
		return repositoryOutboundPort.paginator(domain, filter, typeRepository, queryName);
	}
	
	/**
	 *
	 */
	@Override
	public Integer buscarTotal(Domain<?> domain, Map<String, Object> filter) throws UncheckedException {
		return repositoryOutboundPort.count(domain, filter);
	}

	/**
	 *
	 */
	@Override
	public Integer buscarTotal(Domain<?> domain, Map<String, Object> filter, String method) throws UncheckedException {
		return repositoryOutboundPort.count(domain, filter, method);
	}

	/**
	 *
	 */
	@Override
	public Integer buscarTotal(Domain<?> domain, Map<String, Object> filter, TypeRepository typeRepository, String queryName) throws UncheckedException {
		return repositoryOutboundPort.count(domain, filter, typeRepository, queryName);
	}

	/**
	 *
	 */
	@Override
	public boolean existePorId(Domain<?> domain, Object id) throws UncheckedException {
		return repositoryOutboundPort.existsById(domain, id);
	}

	/**
	 *
	 */
	@Override
	public void excluir(Domain<?> domain, List<?> ids) throws UncheckedException {
		repositoryOutboundPort.delete(domain, ids);
	}

	/**
	 *
	 */
	@Override
	public void excluir(Domain<?> domain, Object ids) throws UncheckedException {
		repositoryOutboundPort.delete(domain, ids);		
	}
	
	/**
	 *
	 */
	@Override
	public void excluir(Domain<?> domain) throws UncheckedException {
		repositoryOutboundPort.delete(domain);
	}
	
	/**
	 *
	 */
	@Override
	public Domain<?> salvar(Domain<?> domain) throws UncheckedException {
		return repositoryOutboundPort.save(domain);
	}

	/**
	 *
	 */
	@Override
	public List<Domain<?>> salvar(Domain<?> domain, List<Domain<?>> entities) throws UncheckedException {
		return repositoryOutboundPort.save(domain, entities);
	}

	/**
	 *
	 */
	@Override
	public Domain<?> salvar(Domain<?> domain, Boolean flush) throws UncheckedException {
		return repositoryOutboundPort.save(domain, flush);
	}

	/**
	 *
	 */
	@Override
	public List<Domain<?>> salvar(Domain<?> domain, List<Domain<?>> entities, Boolean flush) throws UncheckedException {
		return repositoryOutboundPort.save(domain, entities, flush);
	}
}
