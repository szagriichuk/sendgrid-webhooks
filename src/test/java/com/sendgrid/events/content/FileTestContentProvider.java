package com.sendgrid.events.content;

import java.util.Scanner;

/**
 * @author szagriichuk.
 */
public class FileTestContentProvider implements TestContentProvider {
    @Override
    public String getContent() {
        return readFromFile("webhook.json");
    }

    private String readFromFile(String fileName) {
        Scanner scanner = new Scanner(FileTestContentProvider.class.getClassLoader().getResourceAsStream(fileName));
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            builder.append(scanner.next());
        }
        return builder.toString();
    }
}
