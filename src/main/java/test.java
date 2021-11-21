import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Project name(项目名称)：转换流
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/21
 * Time(创建时间)： 13:24
 * Version(版本): 1.0
 * Description(描述)： 正常情况下，字节流可以对所有的数据进行操作，但是有些时候在处理一些文本时我们要用到字符流，
 * 比如，查看文本的中文时就是需要采用字符流更为方便。所以 Java IO 流中提供了两种用于将字节流转换为字符流的转换流。
 * InputStreamReader 用于将字节输入流转换为字符输入流，其中 OutputStreamWriter 用于将字节输出流转换为字符输出流。
 * 使用转换流可以在一定程度上避免乱码，还可以指定输入输出所使用的字符集。
 */

public class test
{
    public static void main(String[] args)
    {
        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream("test.txt");
            String str = "215 639.24 hello world,你好 世界";
            out.write(str.getBytes());
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("test.txt");
            int b = 0;
            while ((b = fis.read()) != -1)
            {
                System.out.print((char) b);
            }
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件未找到！！！");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fis != null)
                {
                    fis.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println();
        try
        {
            fis = new FileInputStream("test.txt");
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fis.read(b)) != -1)
            {
                System.out.print(new String(b, 0, len, StandardCharsets.UTF_8));
            }
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件未找到！！！");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fis != null)
                {
                    fis.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println();
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        try
        {
            fileInputStream = new FileInputStream("test.txt");
            inputStreamReader = new InputStreamReader(fileInputStream);
            System.out.println("编码：" + inputStreamReader.getEncoding());
            String str = null;
            bufferedReader = new BufferedReader(inputStreamReader);
            str = bufferedReader.readLine();
            System.out.println(str);
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件未找到！！！");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if (inputStreamReader != null)
                {
                    inputStreamReader.close();
                }
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
            }
            catch (Exception e)
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
            }
        }
        File files = new File("test.txt");
        Scanner inputStream = null;
        try
        {
            inputStream = new Scanner(files);
            int a1=inputStream.nextInt();
            System.out.println(a1);
            double a2=inputStream.nextDouble();
            System.out.println(a2);
            System.out.println(inputStream.next());
            System.out.println(inputStream.next());
            System.out.println(inputStream.next());
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件打开失败！！！");
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (inputStream != null)
        {
            inputStream.close();
        }
    }
}
