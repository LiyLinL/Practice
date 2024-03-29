package com.liy.generator;

import com.liy.generator.service.ServiceTest;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class Controller {

    @Autowired
    private JmsListenerEndpointRegistry endpointRegistry;

    @GetMapping("jms/stop")
    public void listenStop() {
        endpointRegistry.getListenerContainers().forEach(container -> {
            if (container.isRunning()) {
                container.stop();
            }
        });
    }

    @GetMapping("jms/start")
    public void listenStart() {
        endpointRegistry.getListenerContainers().forEach(container -> {
            DefaultMessageListenerContainer jmsListenerContainer = (DefaultMessageListenerContainer) container;
            if (jmsListenerContainer.isRunning()) {
                jmsListenerContainer.stop();
                jmsListenerContainer.shutdown();
                String url = "failover://(tcp://localhost:61626,tcp://localhost:61646)?maxReconnectAttempts=0&startupMaxReconnectAttempts=5&maxReconnectDelay=10000";
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
                connectionFactory.setUserName("admin");
                connectionFactory.setPassword("admin");
                connectionFactory.setBrokerURL(url);
                jmsListenerContainer.setConnectionFactory(connectionFactory);
                jmsListenerContainer.setDestinationName("Q");
                jmsListenerContainer.initialize();
                jmsListenerContainer.start();
            }
        });
    }

//    @GetMapping("test/excel")
//    public byte[] testExcel() throws IOException {
//        File file = new File("D:\\text.xlsx");
//        InputStream inputStream = new FileInputStream(file);
//
//        Workbook wb = WorkbookFactory.create(inputStream);
//        wb.setForceFormulaRecalculation(true);
//
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        wb.write(bos);
//        bos.close();
//        return Base64.getEncoder().encode(bos.toByteArray());
//    }

    @Autowired
    private ServiceTest serviceTest;

    @GetMapping("test/async")
    public Integer testasync() throws ExecutionException, InterruptedException {
        int i = serviceTest.execute01();
        serviceTest.execute02();
        System.out.println(i);
        return i;
    }

    @GetMapping("test/pdf")
    public void getPdf() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Downloads\\測試.pdf");

        PDDocument document = PDDocument.load(file);
        int pageSize = document.getNumberOfPages();

        PDFRenderer pdfRenderer = new PDFRenderer(document);

        // 把第八頁的內容截圖輸出
        ImageIO.write(pdfRenderer.renderImage(7).getSubimage(0, 3, 566, 460), "png", new File("C:\\Users\\Administrator\\Downloads\\" + "9.png"));

        int index = 0;
//        for (int i = 0; i < pageSize; i++) {
//            PDFTextStripper stripper = new PDFTextStripper();
//            stripper.setSortByPosition(true);
//            stripper.setStartPage(i + 1);
//            stripper.setEndPage(i + 1);
//            String text = stripper.getText(document);
//            System.out.println(text.trim());

        // 圖片
//            PDPage pdPage = document.getPage(i);
//            PDResources resources = pdPage.getResources();
//            for (COSName cosName : resources.getXObjectNames()) {
//                index++;
//                PDXObject pdxObject = resources.getXObject(cosName);
//                if (pdxObject instanceof PDImageXObject) {
//                    PDImageXObject pdImageXObject = (PDImageXObject) pdxObject;
//                    ImageIO.write(pdImageXObject.getImage(), pdImageXObject.getSuffix(), new File("C:\\Users\\Administrator\\Downloads\\" + index + "." + pdImageXObject.getSuffix()));
//                }
//            }
//        }
        document.close();
    }
}
