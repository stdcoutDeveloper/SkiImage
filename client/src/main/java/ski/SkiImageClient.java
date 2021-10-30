package ski;

import ski.clientBase64.SkiImageService;
import ski.clientBase64.SkiImageServiceService;

public class SkiImageClient {
	
	public static void main(String[] args) {
		SkiImageServiceService service = new SkiImageServiceService();
		
		// set handler to log response message received from web service
		service.setHandlerResolver(new ClientHandlerResolver());
		
		SkiImageService port = service.getSkiImageServicePort();
		port.getImage("nordic");
	}
}