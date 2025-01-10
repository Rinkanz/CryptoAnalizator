import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Cipher {
    private static final List<Character> ALPHABET = List.of('а',
            'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л',
            'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',
            'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',

            'А', 'Б', 'В', 'Г', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л',
            'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч',
            'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',

            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',

            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',

            '.', ',', '-', ':', ' ', ';', '!', '\n',':');


    public static void encrypted() throws IOException {
        System.out.println("Введите ключ: \n(Кол-во смещения символов)");
        Scanner scanner = new Scanner(System.in);
        int shift;
        try {
            shift = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ключ должен быт цифровым значением");
            return;
        }
        List<String> originalText;
        originalText = Files.readAllLines(Path.of("src/FileManager/OriginalText.txt"));

        StringBuilder encryptedText = new StringBuilder();
        for (String line : originalText) {
            for (char character : line.toCharArray()) {
                if (ALPHABET.contains(character)) {
                    int originalIndex = ALPHABET.indexOf(character);
                    int newIndex = (originalIndex + shift) % ALPHABET.size();
                    if (newIndex < 0) {
                        newIndex += ALPHABET.size();
                    }
                    encryptedText.append(ALPHABET.get(newIndex));


                } else {
                    encryptedText.append(character);
                }
            }
            encryptedText.append("\n");
        }
        try {
            Files.write(Path.of("src/FileManager/Encrypted.txt"), encryptedText.toString().getBytes());
            System.out.println("Текст успешно зашифрован и записан в файл \"Encrypted.txt\"");
        } catch (Exception e) {

        }

    }

    public static void  decrypted() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Введите ключ: \n(Количество символов для смещения)");
        int shift;
        try {
            shift = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ключ должен быть числом!");
            return;
        }


        List<String> cipherText;
        try {
            cipherText = Files.readAllLines(Path.of("src/FileManager/Encrypted.txt"));
        } catch (IOException e){
            return;
        }


        StringBuilder decryptedText = new StringBuilder();
        for (String line : cipherText) {
            for (char character : line.toCharArray()) {
                if (ALPHABET.contains(character)) {
                    int originalIndex = ALPHABET.indexOf(character);
                    int newIndex = (originalIndex - shift) % ALPHABET.size();
                    if (newIndex < 0) {
                        newIndex += ALPHABET.size();
                    }
                    decryptedText.append(ALPHABET.get(newIndex));
                } else {
                    decryptedText.append(character);
                }
            }
            decryptedText.append("\n");
        }


        try {
            Files.write(Path.of("src/FileManager/Decrypted.txt"), decryptedText.toString().getBytes());
            System.out.println("Текст успешно расшифрован и записан в файл Decrypted.txt!");
        } catch (IOException e) {

        }
    }

    }






