package com.vic.spring.pdf.util;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;

public class PDFUtils {

    public static byte[] generateFile(String html) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();
            HTMLWorker htmlWorker = new HTMLWorker(document);// TODO check deprecated
            htmlWorker.parse(new StringReader(html));
            document.close();
            baos.close();
            return baos.toByteArray();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not read file");
        }
    }
    public  static void htmlToPdf() throws Exception {
        String path ="D:\\code\\github\\spring-demo\\html-pdf\\src\\main\\resources\\templates\\collect.html";
        String destPath = "D:\\code\\github\\spring-demo\\html-pdf\\src\\main\\resources\\templates\\collect.pdf";
        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider dfp = new DefaultFontProvider();
        //添加字体库
        dfp.addDirectory("C:/Windows/Fonts");
        converterProperties.setFontProvider(dfp);
        try (InputStream in = new FileInputStream(new File(path));
             OutputStream out = new FileOutputStream(new File(destPath))){
            HtmlConverter.convertToPdf(in, out, converterProperties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        htmlToPdf();
    }


}
