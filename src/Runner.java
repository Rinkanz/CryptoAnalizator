import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Runner {


    public void greeting() throws IOException {
        System.out.println("Добро пожаловать\nВыберите вариант работы кодировщика: ");
        System.out.println("1: Зашифровать текст.");
        System.out.println("2: Расшифровать текст.");
        System.out.println("3: Прочитать оригинальный текст.");
        System.out.println("4: Прочитать зашифрованный текст");

        Scanner scanner = new Scanner(System.in);
        try {
            int i = scanner.nextInt();
            if (i == 1) {
                Cipher cipher = new Cipher();
                cipher.encrypted();
            } else if (i == 2) {
                Cipher cipher = new Cipher();
                cipher.decrypted();
            } else if (i == 3) {
                List<String> strings = Files.readAllLines(Path.of("src/FileManager/OriginalText.txt"));
                for (int j = 0; j < strings.size() - 1; j++) {
                    System.out.println(strings.get(j));
                }
            } else if (i == 4) {
                List<String> strings = Files.readAllLines(Path.of("src/FileManager/Encrypted.txt"));
                for (int j = 0; j < strings.size(); j++) {
                    System.out.println(strings.get(j));
                }
            } else
                System.out.println("Введите доступные цифры из предложенных: 1 - 4");
        }catch (Exception e){

            System.out.println("Необходимо ввести число, а не текст");

        }


    }
}
