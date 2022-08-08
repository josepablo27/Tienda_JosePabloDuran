package com.tienda.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class ArticuloReportService {

    private String reportPath;

    public String generateReport() {
        try {
            File file = ResourceUtils.getFile("classpath:ReporteArticulo.jasper");
            reportPath = file.getParent();
            // Carga el reporte
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
            // Añade paramáteros (pero para este caso no hay)
            Map<String, Object> parameters = new HashMap<>();
            //Instanciar la conexión
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/techshop", "usuario_prueba", "Usuar1o_Clave.");
            // Llena el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            // Exporta a PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\ReporteArticulos.pdf");
            return reportPath + "\\ReporteArticulos.pdf";
        } catch (FileNotFoundException | ClassNotFoundException | SQLException | JRException e) {
            return e.getMessage();
        }
    }
}
