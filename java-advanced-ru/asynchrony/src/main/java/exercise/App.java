package exercise;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.concurrent.ExecutionException;

import static java.nio.file.Files.newBufferedReader;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String file3) {

        CompletableFuture<String> futureFile1 = CompletableFuture.supplyAsync(() -> {
            var fullPath = getFullPath(file1);
            var content = "";
            try {
                content = Files.readString(fullPath);
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при чтении файла: " + e.getMessage());
            }
            return content;
        });

        CompletableFuture<String> futureFile2 = CompletableFuture.supplyAsync(() -> {
            var fullPath = getFullPath(file2);
            var content = "";
            try {
                content = Files.readString(fullPath);
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при чтении файла: " + e.getMessage());
            }
            return content;
        });

        CompletableFuture<String> writeInputFile = futureFile1.thenCombine(futureFile2, (text1, text2) -> {
            var fullPath = getFullPath(file3);
            var result = text1 + text2;
            try {
                if (!Files.exists(fullPath)) {
                    Files.createFile(fullPath);
                }
                Files.writeString(fullPath, result);
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при записи файла: " + e.getMessage());
            }
            return "Запись успешно завершена!";
        }).exceptionally(ex -> {
            System.out.println("Ошибка: ");
            return null;
        });
        return writeInputFile;
    }
    // END

    public static Path getFullPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // BEGIN
        CompletableFuture<String> result = unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/input.txt");
        System.out.println(result.get());
        // END
    }
}

