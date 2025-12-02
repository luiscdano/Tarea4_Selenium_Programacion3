package listeners;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportListener implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        try {
            File reportDir = new File("Reports");
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            FileWriter writer = new FileWriter("Reports/TestReport.html");

            writer.write("<html><head>");
            writer.write("<title>Reporte Selenium</title>");
            writer.write("<meta charset='UTF-8'>");
            writer.write("</head><body>");
            writer.write("<h1>Resultados de las Pruebas Automatizadas</h1>");

            for (ISuite suite : suites) {
                for (ISuiteResult result : suite.getResults().values()) {
                    ITestContext context = result.getTestContext();

                    writer.write("<h2>Suite: " + context.getName() + "</h2>");

                    writer.write("<h3 style='color:green;'>✔ Pruebas Exitosas:</h3>");
                    for (ITestResult passed : context.getPassedTests().getAllResults()) {
                        writer.write("<p>✔ " + passed.getName() + "</p>");
                    }

                    writer.write("<h3 style='color:red;'>❌ Pruebas Fallidas:</h3>");
                    for (ITestResult failed : context.getFailedTests().getAllResults()) {
                        writer.write("<p>❌ " + failed.getName() + "</p>");
                    }
                }
            }

            writer.write("</body></html>");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 