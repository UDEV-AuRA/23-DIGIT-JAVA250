package com.example.demo.controller.export;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.FactureRepository;
import com.example.demo.service.export.ExportClientXLSXService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 * Controller pour réaliser l'export des factures.
 */
@Controller
@RequestMapping("export/factures")
public class ExportFactureController {

    @Autowired
    private FactureRepository factureRepository;

    /**
     * Export des clients au format PDF.
     */
    @GetMapping("{id}/pdf")
    public void exportCSV(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        response.setHeader("Content-Disposition", "attachment; filename=\"export-facture-" + id + ".pdf\"");
        OutputStream outputStream = response.getOutputStream();

        // Code à déplacer dans un service pour être propre !
        Document document = new Document();

        PdfWriter.getInstance(document, outputStream);
        document.open();
        Paragraph paragrapheHeader1 = new Paragraph();
        paragrapheHeader1.add(new Paragraph("hello"));
        document.add(paragrapheHeader1);
        document.close();
    }
}
