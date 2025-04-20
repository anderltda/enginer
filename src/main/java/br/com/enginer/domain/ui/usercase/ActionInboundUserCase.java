package br.com.enginer.domain.ui.usercase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.enginer.domain.ui.dto.PageResult;
import br.com.enginer.domain.ui.dto.logger.ActionLogger;
import br.com.enginer.domain.ui.port.inbound.ActionInboundPort;
import br.com.enginer.domain.ui.port.outbound.LoggerOutboundPort;
import br.com.enginer.domain.ui.port.outbound.RepositoryOutboundPort;
import br.com.enginer.domain.ui.usercase.exception.CheckedException;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;

/**
 * 
 */
public class ActionInboundUserCase implements ActionInboundPort {

	private final RepositoryOutboundPort repositoryOutboundPort;
	private final LoggerOutboundPort logger; 

	/**
	 * @param repositoryOutboundPort
	 * @param logger
	 */
	public ActionInboundUserCase(RepositoryOutboundPort repositoryOutboundPort, LoggerOutboundPort logger) {
		this.repositoryOutboundPort = repositoryOutboundPort;
		this.logger = logger;
	}
	
	/**
	 *
	 */
	@Override
	public Domain<?> findById(Domain<?> domain) throws CheckedException {

		try {

			if (domain.getId() != null) {
				return repositoryOutboundPort.findById(domain, domain.getId());
			}

		} catch (Exception ex) {
			logger.error(ActionInboundUserCase.class, ex.getMessage(), ex);
			throw new CheckedException(ex.getMessage(), ex);
		}

		return null;
	}

	/**
	 *
	 */
	@Override
	public List<Domain<?>> findAll(Domain<?> domain, HashMap<String, Object> filter) throws CheckedException {
		
		try {
			
			return repositoryOutboundPort.findAll(domain, filter);
			
		} catch (Exception ex) {
			logger.error(ActionInboundUserCase.class, ex.getMessage(), ex);
			throw new CheckedException(ex.getMessage(), ex);
		}
	}

	/**
	 *
	 */
	@Override
	public PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter) throws CheckedException {

		PageResult<?> pageResult = null;

		try {

			pageResult = repositoryOutboundPort.paginator(domain, filter);

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
	public PageResult<?> paginator(Domain<?> domain, Map<String, Object> filter, String method) throws CheckedException {

		PageResult<?> pageResult = null;

		try {

			pageResult = repositoryOutboundPort.paginator(domain, filter);

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
	public void action(Domain<?> domain) throws CheckedException {

		try {
			
			ActionLogger actionLogger = domain.getActionLogger();
			
			System.out.println(actionLogger.getAction());

			repositoryOutboundPort.save(domain);

		} catch (Exception ex) {
			logger.error(ActionInboundUserCase.class, ex);
			throw new CheckedException(ex.getMessage(), ex);
		}
	}
}
