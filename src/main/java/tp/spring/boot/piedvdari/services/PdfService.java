package tp.spring.boot.piedvdari.services;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Optional;

import com.itextpdf.text.DocumentException;

import tp.spring.boot.piedvdari.entities.Pack;




@Service
public class PdfService {

    private static final String PDF_RESOURCES = "/templates/";
    private PackService packService;
    private SpringTemplateEngine templateEngine;
    Pack pack;

    @Autowired
    public PdfService( PackService packService, SpringTemplateEngine templateEngine) {
        this.packService = packService;
        this.templateEngine = templateEngine;
    }

    public File generatePdf(Optional<Pack> pack) throws IOException, DocumentException {
        Context context = getContext(pack);
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }


    private File renderPdf(String html) throws IOException, DocumentException {
        File file = File.createTempFile("pack", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        try {
			renderer.createPDF(outputStream);
		} catch (com.lowagie.text.DocumentException e) {
			e.printStackTrace();
		}
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContext(Optional<Pack> pack) {
    	
        Context context = new Context();
        
		context.setVariable("pack", pack.get());
        return context;
    }

    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("pack", context);
    }


}

