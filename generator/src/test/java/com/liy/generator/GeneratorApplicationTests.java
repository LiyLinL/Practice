package com.liy.generator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class GeneratorApplicationTests {

    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void testMain() throws IOException {
        String filePath = "C:\\Users\\Administrator\\Desktop\\sap_Test\\test2.xls";
        InputStream inputStream = Files.newInputStream(new File("C:\\Users\\Administrator\\Desktop\\sap_Test\\ReturnMaterialExport.xls").toPath());
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet s = workbook.getSheetAt(0);
        Sheet s2 = workbook.getSheetAt(1);

//        HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
//        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
//
//        Map<String, Object> map = new HashMap<>();
//
//        for (HSSFShape shape : list) {
//            if (shape instanceof HSSFPicture) {
//                HSSFPicture picture = (HSSFPicture) shape;
//                HSSFClientAnchor cAnchor = picture.getClientAnchor();
//                HSSFPictureData pdata = picture.getPictureData();
//                map.put("pictureAnchor", cAnchor);
//                map.put("pictureByteArray", pdata.getData());
//                map.put("pictureType", pdata.getPictureType());
//            }
//        }
//
//        HSSFSheet newSheet = (HSSFSheet) workbook.createSheet();
//        HSSFPatriarch drawing = newSheet.createDrawingPatriarch();
//
//        drawing.createPicture((HSSFClientAnchor) map.get("pictureAnchor"),
//                              workbook.addPicture((byte[]) map.get("pictureByteArray"),
//                                                  Integer.parseInt(map.get("pictureType").toString())));
//
//        FileOutputStream fileOut = new FileOutputStream(filePath);
//        workbook.write(fileOut);

//        Charset charset = Charset.forName("BIG5");
//        List<String> txtList = Files.lines(Paths.get("C:\\Users\\Administrator\\Desktop\\sap_Test\\all.txt"))
//                .flatMap(line -> Arrays.stream(line.trim().split("\n")))
//                .collect(Collectors.toList());

//        try (InputStream ip = Files.newInputStream(new File("C:\\Users\\Administrator\\Desktop\\sap_Test\\test.xls").toPath())) {
//
//        }
    }

    @Test
    public void test1() throws Exception {
        BufferedImage bufferedImg = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\test\\111.png"));

        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        ImageIO.write(bufferedImg, "png", byteArrayOut);

        File file = new File("C:\\Users\\Administrator\\Desktop\\test\\11111.xlsx");
        InputStream inputStream = Files.newInputStream(file.toPath());

        Workbook wb = WorkbookFactory.create(inputStream);

        inputStream.close();

        Sheet sheet = wb.getSheet("test");

        // (畫素/列寬)*256  列寬=字元個數*字元寬度 預設:8*1
//        int imgW = (bufferedImg.getWidth() / 8) * 256;
//        sheet.setColumnWidth(0, imgW);

        // 像素*英吋  1像素:1440TPI 英吋:1440/DPI 預設DPI:96, 如果畫面放大:96*放大百分比
        // 這邊英吋用 1440/(96*125%) = 12
//        int imgH = bufferedImg.getHeight() * 12;
//        row.setHeight((short) imgH);

        // 起始位置
        int dx1 = 3;
        int dy1 = 4;
        // 結束位置
        int dx2 = 15;
        int dy2 = 25;
        // 開始行
        int row1 = 0;
        int col1 = 0;
        // 結束行
        int row2 = 1;
        int col2 = 1;

        Drawing<?> drawingPatriarch = sheet.createDrawingPatriarch();

        CreationHelper helper = wb.getCreationHelper();
        ClientAnchor anchor = helper.createClientAnchor();

        anchor.setCol1(1);
        anchor.setRow1(0);
        anchor.setCol2(2);
        anchor.setRow2(1);

        anchor.setDy1(20 * Units.EMU_PER_POINT);
        anchor.setDx1(20 * Units.EMU_PER_POINT);
        anchor.setDy2(15 * Units.EMU_PER_POINT);
        anchor.setDx2(15 * Units.EMU_PER_POINT);

        drawingPatriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_PNG))
                .resize(0.8);

        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test\\222.xlsx");
        wb.write(fileOut);
        wb.close();

//        Workbook workbook = new Workbook();
//        InputStream file = new FileInputStream("C:\\Users\\Administrator\\Desktop\\111.xlsx");
//        workbook.loadFromStream(file);
//
//        WorksheetChartsCollection chartsCollection = workbook.getWorksheets().get(0).getCharts();
//        int s = chartsCollection.size();
//        System.out.println(s);
//
//        for (int i = 0; i < s; i++) {
//            BufferedImage image = workbook.saveChartAsImage(workbook.getWorksheets().get(0), i);
//            ImageIO.write(image, "png", new File("C:\\Users\\Administrator\\Desktop\\" + i + ".png"));
//        }
    }

    @Test
    public void test2() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\sap_Test\\test.html");
        Document doc = Jsoup.parse(file, "UTF-8");

        Elements table = doc.select("table");
        Elements tr =  table.first().getElementsByTag("tr");

        for (Element e : tr) {
            System.out.println(e.text());
        }
    }

    @Test
    public void test3() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\test\\test.pdf");

        PDDocument document = PDDocument.load(file);

        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDPageTree pages = catalog.getPages();
        int size = pages.getCount();

        for (int i = 0; i < size; i++) {
            PDPage pdPage = pages.get(i);

            PDFTextStripper stripper = new PDFTextStripper();

            stripper.setStartPage(i);
            stripper.setEndPage(i);
            //獲取文字內容
            String content = stripper.getText(document);

            String debug = "";
        }
    }
}
