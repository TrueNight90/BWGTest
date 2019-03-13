package org.yjr.httpclient;

public class webServiceTest {
    public static void main(String[] args) {
        BWGServerWebServiceImplService factory = new BWGServerWebServiceImplService();
        BWGServerWebServiceImpl service = factory.getBWGServerWebServiceImplPort();
        String port = service.showServer("port");
        System.out.println(port);
    }
}
