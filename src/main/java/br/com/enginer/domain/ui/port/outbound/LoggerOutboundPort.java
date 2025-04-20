package br.com.enginer.domain.ui.port.outbound;

public interface LoggerOutboundPort {

	void info(Class<?> clazz, String message);

	void error(Class<?> clazz, String message, Throwable throwable);
	
	void error(Class<?> clazz, Throwable throwable);

}
