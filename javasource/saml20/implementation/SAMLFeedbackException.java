package saml20.implementation;

import org.owasp.html.Sanitizers;

public class SAMLFeedbackException extends org.opensaml.saml.common.SAMLException {
	private static final long serialVersionUID = 1L;
	private String feedbackMessage = "";
	//add code-start
	private String UserId = "";
	private String ErrorStatus = "";
	//add code-end

	public SAMLFeedbackException( String message ) {
		super(message);
		this.feedbackMessage = sanitize(message);
	}

	public SAMLFeedbackException( String message, Exception e ) {
		super(message, e);
		this.feedbackMessage = sanitize(message);
	}

	public SAMLFeedbackException( Exception e ) {
		super(e);
		this.feedbackMessage = sanitize(e.getMessage());
	}

	public SAMLFeedbackException addFeedbackMessage( String feedback ) {
		this.feedbackMessage = sanitize(feedback);
		return this;
	}

	//add code-start
	public SAMLFeedbackException addUserId( String UserId ) {
		this.UserId = sanitize(UserId);
		return this;
	}

	public SAMLFeedbackException addErrorStatus( String ErrorStatus ) {
		this.ErrorStatus = sanitize(ErrorStatus);
		return this;
	}
	//add code-end

	public String getFeedbackMessage() {
		return this.feedbackMessage;
	}
	
	public String sanitize(String input) {
		return Sanitizers.FORMATTING.sanitize(input);
	}
	
}