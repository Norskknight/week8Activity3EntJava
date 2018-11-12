package gov.weather;

import org.junit.Test;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;


import static org.junit.Assert.*;

public class NdfdXMLBindingStubTest {

    @Test
    public void latLonListZipCode() throws Exception{
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)
                new NdfdXMLLocator().getndfdXMLPort();

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        String response = binding.latLonListZipCode("53711");

        DwmlType result = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));

        assertEquals("Result did not match expected","43.0798,-89.3875", result.getLatLonList());
    }
}