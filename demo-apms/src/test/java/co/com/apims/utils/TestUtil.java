package co.com.apims.utils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestUtil {

    /**
     * Lee un archivo y retorna su contenido, es aplicable para leer json.
     * @param nameFile Nombre del archivo.
     * @return Contenido del archivo.
     */
    public static String retrieveBody(String nameFile) {
        InputStream input = TestUtil.class.getClassLoader().getResourceAsStream(nameFile);
        try (Scanner s = new java.util.Scanner(input,StandardCharsets.UTF_8.name())) {
            s.useDelimiter("\\A");
            String body = s.next();

            if (body == null || body.length() == 0) {
                throw new IllegalArgumentException("nameFile '" + nameFile + "'does not have content");
            }
            return body;
        }
    }

}
