
package ski.clientBase64;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1-SNAPSHOT
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SkiImageService", targetNamespace = "http://images/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SkiImageService {


    /**
     * 
     * @return
     *     returns java.util.List<byte[]>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getImages", targetNamespace = "http://images/", className = "ski.clientBase64.GetImages")
    @ResponseWrapper(localName = "getImagesResponse", targetNamespace = "http://images/", className = "ski.clientBase64.GetImagesResponse")
    @Action(input = "http://images/SkiImageService/getImagesRequest", output = "http://images/SkiImageService/getImagesResponse")
    public List<byte[]> getImages();

    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getImage", targetNamespace = "http://images/", className = "ski.clientBase64.GetImage")
    @ResponseWrapper(localName = "getImageResponse", targetNamespace = "http://images/", className = "ski.clientBase64.GetImageResponse")
    @Action(input = "http://images/SkiImageService/getImageRequest", output = "http://images/SkiImageService/getImageResponse")
    public byte[] getImage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}