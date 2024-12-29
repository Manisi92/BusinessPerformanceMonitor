package com.businessmonitor.ui;

import com.businessmonitor.model.Performance;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileOutputStream;
import java.util.List;

public class ReportGenerator {

    public void generatePDFReport(List<Performance> performances) {
        try {
            // Create PdfWriter to write to the output file
            PdfWriter writer = new PdfWriter(new FileOutputStream("sales_report.pdf"));

            // Create PdfDocument instance with the writer
            PdfDocument pdfDoc = new PdfDocument(writer);

            // Create a Document for adding content (with layout capabilities)
            Document document = new Document(pdfDoc);

            // Add title to the document
            document.add(new Paragraph("Business Sales Report"));
            document.add(new Paragraph("\n"));

            // Loop through performances and add details to the document
            for (Performance performance : performances) {
                document.add(new Paragraph("Date: " + performance.getDate()));
                document.add(new Paragraph("Sales: " + performance.getSales()));
                document.add(new Paragraph("Costs: " + performance.getCosts()));
                document.add(new Paragraph("Profit: " + performance.getProfit()));
                document.add(new Paragraph("\n"));
            }

            // Close the document to finish writing
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}