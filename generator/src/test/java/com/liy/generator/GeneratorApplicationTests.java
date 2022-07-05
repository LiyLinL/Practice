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
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import javax.jms.JMSException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class GeneratorApplicationTests {

    @Test
    public void jms() throws InterruptedException, IOException, JMSException {
    }

    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void testMain() throws IOException {
//        InputStream inputStream = Files.newInputStream(new File("C:\\Users\\Administrator\\Desktop\\sap_Test\\test.xls").toPath());
//        Workbook workbook = WorkbookFactory.create(inputStream);
//        Sheet s = workbook.getSheetAt(0);
//        String sn = s.getSheetName();

//        Charset charset = Charset.forName("BIG5");
//        List<String> txtList = Files.lines(Paths.get("C:\\Users\\Administrator\\Desktop\\sap_Test\\big5.txt"), charset)
//                .flatMap(line -> Arrays.stream(line.trim().split("\n")))
//                .collect(Collectors.toList());

//        try (InputStream ip = Files.newInputStream(new File("C:\\Users\\Administrator\\Desktop\\sap_Test\\test.xls").toPath())) {
//
//        }

        String a = "asdb" +  TestEnum.OK;
        System.out.println(a);

        String d = "";
    }

    @Test
    public void test() {
//       System.out.println( String.format("QCPlanBO:%s,%s,%s", "100", "qcPlan", "revision"));

        StringBuilder letter = new StringBuilder();
        // 字母轉數字
//        int length = letter.length() - 1;
//        int sum = 0;
//        if (letter.toString().matches("^[A-Z]+$")) {
//            for (int i = 0; i < letter.length(); i++) {
//                char c = letter.charAt(i);
//                int ordinal = c - 64;
//
//                sum += ordinal * Math.pow(26, length);
//                length--;
//            }
//        }

        int number = 26;
        // 數字轉字母
        number--;
        do {
            if (letter.length() > 0) {
                number--;
            }
            // A:65
            char c = (char) (number % 26 + 65);
            letter.insert(0, c);
            number = (number - number % 26) / 26;
        } while (number > 0);


        System.out.println(letter);
    }

    @Transactional
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

        for (Element e : table.first().getElementsByTag("tr")) {
            System.out.println(e.text());
        }
//
//        String debug = "";
//        List<String> list = new ArrayList<>(Arrays.asList("01-10", "01-12", "02-11", "01-02", "02-01", "01-20", "01-21", "02-04", "01-05", "02-19"));
//        list.stream().sorted().forEach(System.out::println);

        List<DetailInfo> detailInfoList = new ArrayList<>();
//        detailInfoList.add(new DetailInfo("1", "TOP"));
//        detailInfoList.add(new DetailInfo("1-1", "A"));
//        detailInfoList.add(new DetailInfo("1-1-1", "A"));
//        detailInfoList.add(new DetailInfo("1-1-2", "A"));
//        detailInfoList.add(new DetailInfo("1-2", "A"));
//        detailInfoList.add(new DetailInfo("1-2-1", "A"));
//        detailInfoList.add(new DetailInfo("1-2-1-1", "A"));
//        detailInfoList.add(new DetailInfo("1-2-1-2", "A"));
//        detailInfoList.add(new DetailInfo("2", "A"));
//        detailInfoList.add(new DetailInfo("2-1", "A"));
//        detailInfoList.add(new DetailInfo("2-1-1", "A"));
//
//        int topIndex = 0;
//        List<DetailInfo> results = new ArrayList<>();
//        List<DetailInfo> subList = new ArrayList<>();
//
//        int max = detailInfoList.size();
//        for (int j = 0; j < max; j++) {
//            DetailInfo info = detailInfoList.get(j);
//            String level = info.getLEVEL();
//
//
//            // 找圖號
//
//            if (!level.contains("-")) {
//                // 最上層
//                results.add(info);
//
//                if (subList.size() > 0) {
//                    DetailInfo topInfo = results.get(topIndex);
//                    this.getSub(subList, topInfo);
//                }
//
//                subList = new ArrayList<>();
//                topIndex = j;
//            } else {
//                subList.add(info);
//            }
//        }
//
//        // 最後一次遞迴
//        if (subList.size() > 0) {
//            DetailInfo topInfo = results.get(results.size() - 1);
//            this.getSub(subList, topInfo);
//        }
//
//        String debug = "0";
    }

    private void getSub( List<DetailInfo> subList, DetailInfo detailInfo ) {
        String keyLevel = detailInfo.getLEVEL() + "-";

        int maxSize = subList.size() - 1;
        for (int i = maxSize; i >= 0; i--) {
            DetailInfo sub = subList.get(i);
            String subLevel = sub.getLEVEL();

            String key = subLevel.replaceFirst(keyLevel, "");
            if (!key.contains("-")) {
                if (detailInfo.getDetailInfoList() == null) {
                    detailInfo.setDetailInfoList(new ArrayList<>());
                }
                detailInfo.getDetailInfoList().add(sub);
                subList.remove(i);
            }
        }

        if (subList.size() > 0) {
            if (detailInfo.getDetailInfoList() != null) {
                // 排序子階
                detailInfo.setDetailInfoList(detailInfo.getDetailInfoList().stream()
                                                     .sorted(Comparator.comparing(sort -> {
                                                         String key = sort.getLEVEL().replace("-", "");
                                                         return String.format("%010d", Integer.valueOf(key));
                                                     }))
                                                     .collect(Collectors.toList()));

                List<DetailInfo> loopList = detailInfo.getDetailInfoList();
                for (DetailInfo subInfo : loopList) {
                    getSub(subList, subInfo);
                }
            }
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
