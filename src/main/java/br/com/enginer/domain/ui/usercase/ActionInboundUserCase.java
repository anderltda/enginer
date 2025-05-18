package br.com.enginer.domain.ui.usercase;

import java.util.List;
import java.util.Map;

import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.dto.logger.ActionLogger;
import br.com.enginer.domain.ui.port.inbound.ActionInboundPort;
import br.com.enginer.domain.ui.port.inbound.SubscriberInboundPort;
import br.com.enginer.domain.ui.port.outbound.LoggerOutboundPort;
import br.com.enginer.domain.ui.port.outbound.PublisherOutboundPort;
import br.com.enginer.domain.ui.port.outbound.RepositoryOutboundPort;
import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.utils.ReflectionUtils;

/**
 * 
 */
public class ActionInboundUserCase implements ActionInboundPort {

	private final LoggerOutboundPort logger;
	private final RepositoryOutboundPort repositoryOutboundPort;
	private PublisherOutboundPort publisherOutboundPort;
	private SubscriberInboundPort subscriberInboundPort;

	/**
	 * @param logger
	 * @param repositoryOutboundPort
	 * @param publisherOutboundPort
	 * @param subscriberInboundPort
	 */
	public ActionInboundUserCase(LoggerOutboundPort logger, RepositoryOutboundPort repositoryOutboundPort, PublisherOutboundPort publisherOutboundPort, SubscriberInboundPort subscriberInboundPort) {
		this.logger = logger;
		this.repositoryOutboundPort = repositoryOutboundPort;
		this.publisherOutboundPort = publisherOutboundPort;
		this.subscriberInboundPort = subscriberInboundPort;
	}

	/**
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	private Object injectedDependency(Domain<?> domain) throws Exception {
		return ReflectionUtils.executeInjectedDependencyUserCase(domain.getClass(), repositoryOutboundPort, publisherOutboundPort, subscriberInboundPort);
	}

	/**
	 *
	 */
	@Override
	public Domain<?> searchWithById(Domain<?> domain) throws CheckedException {

		try {

			Object object = injectedDependency(domain);
			
			return (Domain<?>) ReflectionUtils.executeMethod(object, "findById", domain);

		} catch (Exception ex) {
			logger.error(ActionInboundUserCase.class, ex.getMessage(), ex);
			throw new CheckedException(ex.getMessage(), ex);
		}

	}


	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Domain<?>> searchByConditions(Domain<?> domain, Map<String, Object> filter) throws CheckedException {

		try {
			
			Object object = injectedDependency(domain);
			
			return (List<Domain<?>>) ReflectionUtils.executeMethod(object, "findAll", domain, filter);

		} catch (Exception ex) {
			logger.error(ActionInboundUserCase.class, ex.getMessage(), ex);
			throw new CheckedException(ex.getMessage(), ex);
		}
	}

	/**
	 *
	 */
	@Override
	public PageResult<?> searchPaginated(Domain<?> domain, Map<String, Object> filter) throws CheckedException {

		PageResult<?> pageResult = null;

		try {
			
			Object object = injectedDependency(domain);

			pageResult = (PageResult<?>) ReflectionUtils.executeMethod(object, "paginator", domain, filter);

		} catch (Exception ex) {
			logger.error(ActionInboundUserCase.class, ex.getMessage(), ex);
			throw new CheckedException(ex.getMessage(), ex);
		}

		return pageResult;
	}

	/**
	 *
	 */
	@Override
	public PageResult<?> searchPaginatedByMethod(Domain<?> domain, Map<String, Object> filter, String method) throws CheckedException {

		PageResult<?> pageResult = null;

		try {
			
			Object object = injectedDependency(domain);

			pageResult = (PageResult<?>) ReflectionUtils.executeMethod(object, "paginator", filter, method);

		} catch (Exception ex) {
			logger.error(ActionInboundUserCase.class, ex.getMessage(), ex);
			throw new CheckedException(ex.getMessage(), ex);
		}

		return pageResult;
	}

	/**
	 *
	 */
	@Override
	public Domain<?> methodName(Domain<?> domain) throws CheckedException {

		Domain<?> newDomain = null;

		try {

			Object object = injectedDependency(domain);

			ActionLogger actionLogger = domain.getActionLogger();

			logger.info(ActionInboundUserCase.class, "Action -> " + actionLogger.getAction());
			
			newDomain =  (Domain<?>) ReflectionUtils.executeMethod(object, actionLogger.getAction(), domain);

		} catch (Exception ex) {
			logger.error(ActionInboundUserCase.class, ex);
			throw new CheckedException(ex.getMessage(), ex);
		}

		return newDomain;
	}
}
