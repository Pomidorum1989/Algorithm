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
        Map<String, List<String>> methodInfo = MethodInfoRecorder.recordMethodInfo(taskType.getClassName());
        File tempFile = new File("README.md.tmp");
        try (BufferedReader reader = new BufferedReader(new FileReader("README.md"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
                if (!found && line.trim().equals(String.format("### %s Method References", taskType.getType()))) {
                    found = true;
                    appendNewContent(writer, methodInfo, taskType);
                }
            }
            if (!found) {
                System.out.println("Target statement not found in the file.");
            }
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
        if (!tempFile.renameTo(new File("README.md"))) {
            System.err.println("Failed to replace the original file.");
        }
    }

    private static void appendNewContent(BufferedWriter writer, Map<String, List<String>> methodInfo,
                                         TaskType taskType) throws IOException {
        for (Map.Entry<String, List<String>> entry : methodInfo.entrySet()) {
            String methodName = entry.getKey();
            List<String> links = entry.getValue();
            writer.write(String.format("Method: [`%s`](%s%s.java#L%s)<br>", methodName, REPO_LINK, taskType.getType(), links.get(0)));
            writer.newLine();
            writer.write(String.format("Problem link: [`%s`](%s)<br>", methodName, links.get(1)));
            writer.newLine();
            writer.write("---------------------------------------------------------------------------<br>");
            writer.newLine();
        }
        appendNextTaskReference(writer, taskType);
    }

    private static void appendNextTaskReference(BufferedWriter writer, TaskType taskType) throws IOException {
        switch (taskType) {
            case LEET_CODE:
                writeTaskReference(writer, TaskType.HACKER_RANK);
                break;
            case HACKER_RANK:
                writeTaskReference(writer, TaskType.CODILITY);
                break;
            case CODILITY:
                writeTaskReference(writer, TaskType.ALGO_EXPERT);
                break;
            case ALGO_EXPERT:
                writeTaskReference(writer, TaskType.HABR);
                break;
            default:
                break;
        }
    }

    private static void writeTaskReference(BufferedWriter writer, TaskType nextTask) throws IOException {
        writer.write(String.format("%s [`%s.java`](%s%s.class)", nextTask.getType(), nextTask.getType(), REPO_LINK, nextTask.getType()));
        writer.newLine();
        writer.write(String.format("### %s Method References", nextTask.getType()));
        writer.newLine();
    }
}