package org.dorum.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dorum.algo.*;

import java.io.*;
import java.util.List;
import java.util.Map;

public class MapToFileAppender {
    private static final String REPO_LINK =
            "https://github.com/pomidorum1989/java-algorithms/blob/master/src/main/java/org/dorum/algo/";

    @AllArgsConstructor
    @Getter
    public enum TaskType {
        ALGO_EXPERT("AlgoExpert", AlgoExpert.class),
        BAIRES_DEV("BairesDev", BairesDev.class),
        CODILITY("Codility", Codility.class),
        HABR("Habr", Habr.class),
        HACKER_RANK("HackerRank", HackerRank.class),
        LEET_CODE("LeetCode", LeetCode.class),
        LINKED_IN("LinkedIn", LinkedIn.class);

        private final String type;
        private final Class<?> className;
    }

    public static void appendAfterStatement(TaskType taskType) {
        Map<String, List<String>> map = MethodInfoRecorder.recordMethodInfo(taskType.getClassName());

        // Temporary file to store the updated content
        File tempFile = new File("README.md.tmp");

        try (BufferedReader reader = new BufferedReader(new FileReader("README.md"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;
            boolean writingNewContent = false;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                if (!found) {
                    // Write lines until we find the target statement
                    writer.write(line);
                    writer.newLine();

                    // Check if the current line matches the target statement
                    if (line.trim().equals(String.format("### %s Method References", taskType.getType()))) {
                        found = true;
                        writingNewContent = true;

                        // Write the new content
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
                } else {
                    // Skip old content after target statement if we are writing new content
                    if (writingNewContent) {
                        writingNewContent = false;  // We will only write new content once
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
        boolean success = tempFile.renameTo(new File("README.md"));
        if (!success) {
            System.out.println("Failed to replace the original file.");
        }
    }
}
