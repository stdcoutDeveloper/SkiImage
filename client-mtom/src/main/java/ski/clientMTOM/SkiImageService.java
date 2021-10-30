
package ski.clientMTOM;

import java.util.List;
import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
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
     * @param arg0
     * @return
     *     returns javax.activation.DataHandler
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getImage", targetNamespace = "http://images/", className = "ski.clientMTOM.GetImage")
    @ResponseWrapper(localName = "getImageResponse", targetNamespace = "http://images/", className = "ski.clientMTOM.GetImageResponse")
    public DataHandler getImage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<javax.activation.DataHandler>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getImages", targetNamespace = "http://images/", className = "ski.clientMTOM.GetImages")
    @ResponseWrapper(localName = "getImagesResponse", targetNamespace = "http://images/", className = "ski.clientMTOM.GetImagesResponse")
    public List<DataHandler> getImages();

}