package softing.UBaH4ukDev.Lesson8;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson8

 Created by Ivan Sheynmaer

 2021.01.29
 v1.0
 */

import java.io.*;
import java.util.Scanner;

public class ClassWork8 { public static void main(String[] args) {
    //fileExample();
    //bufferExample();

    //dataExample();
//        Cat cat = new Cat("Barsik", 10);
//        cat.getInfo();
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cat_serialized"))) {
//            out.writeObject(cat);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cat_serialized"))) {
        Cat cat = (Cat) in.readObject();
        cat.getInfo();

        Cat.something = 10;
        Cat.getStatic();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}

    private static void dataExample() {
        try (
                DataOutputStream out = new DataOutputStream(new FileOutputStream("fos_example"))
        ) {
            out.writeInt(1024);
            out.writeLong(65461651651L);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                DataInputStream in = new DataInputStream(new FileInputStream("fos_example"))
        ) {
            System.out.println(in.readLong());
            System.out.println(in.readInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void bufferExample() throws IOException {
        BufferedOutputStream baos = new BufferedOutputStream(new FileOutputStream("fos_example"));
        for (int i = 0; i < 1_000_000; i++) {
            baos.write(i);
        }

        baos.close();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("fos_example"));
        int x;
        while ((x = bufferedInputStream.read()) != -1) {
            System.out.print((char) x);
        }
        bufferedInputStream.close();
    }

    private static void fileExample() {
        File file = new File("Cyberpunk2077/bin/data");
//        String[] sArr = file.list((d, n) -> n.endsWith("iso"));

        String[] strings = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".iso");
            }
        });
        for (String s : strings) {
            System.out.println(s);
        }
    }

    private static void fisFosExample() throws IOException {
        InputStream in;
//        OutputStream out;
//        byte[] bytes ={'H', 'e', 'l', 'l', 'o'};
        String s = "Hello world!!!\n";
        FileOutputStream fos = new FileOutputStream("fos_example.txt", true);
        for (int i = 0; i < 5; i++) {
            fos.write(s.getBytes());
        }

        fos.close();

        FileInputStream fis = new FileInputStream("fos_example.txt");
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
//        int b;
//        while ((b = fis.read()) != -1) {
//            System.out.print((char) b);
//        }
        fis.close();
    }
}
