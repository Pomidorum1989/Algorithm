package org.dorum.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.*;
import java.util.List;
import java.util.Map;

public class MapToFileAppender {
    private static final String REPO_LINK = "https://github.com/pomidorum1989/java-algorithms/blob/master/src/main/java/org/dorum/algo/";

    @AllArgsConstructor
    @Getter
    public enum TaskType {
        LEET_CODE("LeetCode"),
        CODILITY("Codility"),
        HACKER_RANK("HackerRank"),
        LINKED_IN("LinkedIn");

        private final String type;
    }

    public static void appendAfterStatement(Map<String, List<String>> map, String filePath, String targetStatement, TaskType taskType) {
        // Temporary file to store the updated content
        File tempFile = new File(filePath + ".tmp");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();

                // Check if the current line matches the target statement
                if (line.trim().equals(targetStatement)) {
                    found = true;

                    // Write the new content after the target statement
                    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                        String key = entry.getKey();
                        List<String> values = entry.getValue();
                        writer.write("Method: " + "[`" + key + "`]" +
                                "(" + REPO_LINK + taskType.getType() + ".java#L" + values.get(0) + ")<br>");
                        writer.newLine();
                        writer.write("Problem link: " + "[`" + key + "`]" + "(" + values.get(1) + ")<br>");
                        writer.newLine();
                        writer.write("---------------------------------------------------------------------------<br>");
                        writer.newLine();
                    }
                }
            }

            if (!found) {
                System.out.println("Target statement not found in the file.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Replace the original file with the updated file
        tempFile.renameTo(new File(filePath));
    }
}
