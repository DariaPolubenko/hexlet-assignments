package exercise;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Path;
import java.nio.file.Files;

import static java.nio.file.Files.newBufferedReader;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String file3) {

        CompletableFuture<String> futureFile1 = CompletableFuture.supplyAsync(() -> {
            var fullPath = Paths.get(file1).toAbsolutePath().normalize();
            try {
                if (!Files.exists(fullPath)) {
                    throw new IOException("Такого пути не существует " + fullPath);
                }
                return Files.readString(fullPath);
            } catch (Exception e) {
                throw new IllegalStateException("Ошибка при чтении файла: " + e.getMessage());
            }
        });

        CompletableFuture<String> futureFile2 = CompletableFuture.supplyAsync(() -> {
            var fullPath = Paths.get(file2).toAbsolutePath().normalize();
            try {
                if (!Files.exists(fullPath)) {
                    throw new IOException("Такого пути не существует " + fullPath);
                }
                return Files.readString(fullPath);
            } catch (Exception e) {
                throw new IllegalStateException("Ошибка при чтении файла: " + e.getMessage());
            }
        });

        CompletableFuture<String> writeInputFile = futureFile1.thenCombine(futureFile2, (text1, text2) -> {
            var fullPath = Paths.get(file3).toAbsolutePath().normalize();
            var result = text1 + text2;
            try {
                if (!Files.exists(fullPath)) {
                    Files.createFile(fullPath);
                }
                Files.writeString(fullPath, result);
            } catch (Exception e) {
                throw new IllegalStateException("Ошибка при записи файла: " + e.getMessage());
            }
            return result;
        }).exceptionally(ex -> {
            System.out.println("NoSuchFileException");
            return null;
        });
        return writeInputFile;
    }
    // END


    public static void main(String[] args) {
        // BEGIN
        CompletableFuture<String> result = unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/input.txt");
        System.out.println("t");
        System.out.println(result);
        // END
    }
}

