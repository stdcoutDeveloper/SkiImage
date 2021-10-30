package ski;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * one file holds all of the low-level artifact
 */
public class ClientHandlerResolver implements HandlerResolver {

	@SuppressWarnings("rawtypes")
	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		List<Handler> handlerChain = new ArrayList<Handler>();

		// registered with the runtime
		handlerChain.add(new ClientHashHandler()); // message handler

		return handlerChain;
	}
}

class ClientHashHandler implements SOAPHandler<SOAPMessageContext> {

	public void close(MessageContext mCtx) {
	}

	public Set<QName> getHeaders() {
		return null;
	}

	public boolean handleFault(SOAPMessageContext mCtx) {
		try {
			SOAPMessage msg = mCtx.getMessage();
			msg.writeTo(System.err);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	public boolean handleMessage(SOAPMessageContext mCtx) {
		Boolean outbound = (Boolean) mCtx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		// response?
		if (!outbound) {
			try {
				SOAPMessage soapMessage = mCtx.getMessage();

				try (OutputStream out = new FileOutputStream("result.txt")) {
					ByteArrayOutputStream outStream = new ByteArrayOutputStream();
					soapMessage.writeTo(outStream);
					String strMsg = new String(outStream.toByteArray());

					out.write("Response received from service:\n".getBytes());
					out.write(strMsg.getBytes());
				}
			} catch (Exception e) {
				throw new RuntimeException("SOAPException thrown.", e);
			}
		}
		return true; // continue down the handler chain
	}
}
