import org.owasp.encoder.Encode;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    private static final String TEMPLATE = """
            <!DOCTYPE html>
            <html lang="en">
                <head>
                    <title>Legal Contract</title>
                </head>
                <body>
                    <p>This legal contract is prepared for ${fullname}.</p>
                </body>
            </html>
            """;

    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("demo.html"))) {
            String fullname = System.console().readLine("Full Name: ");
            String fullnameEncoded = Encode.forHtml(fullname);
            writer.write(TEMPLATE.replace("${fullname}", fullnameEncoded));
        }
    }

}
