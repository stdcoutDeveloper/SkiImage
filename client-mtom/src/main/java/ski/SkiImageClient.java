package ski;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;

import ski.clientMTOM.SkiImageService;
import ski.clientMTOM.SkiImageServiceService;

public class SkiImageClient {

	public static void main(String[] args) {
		SkiImageService port = new SkiImageServiceService().getSkiImageServicePort();
		DataHandler image = port.getImage("nordic");
		dump(image);
		
		ReConstructImageFromBytes(image);
		
		List<DataHandler> images = port.getImages();
		for (DataHandler dh : images)
			dump(dh);
	}

	/**
	 * re-constructing the JPEG images from the bytes
	 * @param image
	 */
	private static void ReConstructImageFromBytes(DataHandler image) {
		try {
			Object content = image.getContent();
			if (content instanceof ByteArrayInputStream) {
				BufferedImage buffer = ImageIO.read((ByteArrayInputStream)content);
				ImageIO.write(buffer, "jpg", new File("output.jpg"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	private static void dump(DataHandler dh) {
		try {
			System.out.println("MIME type: " + dh.getContentType());
			System.out.println("Content: " + dh.getContent());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}