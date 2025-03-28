package br.com.enginer.domain.ui.schema.field;

/**
 * 
 */
public class Action {

	private String redirect;
	private String method;
	private ActionObject domain;

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public ActionObject getDomain() {
		return domain;
	}

	public void setDomain(ActionObject domain) {
		this.domain = domain;
	}

}
