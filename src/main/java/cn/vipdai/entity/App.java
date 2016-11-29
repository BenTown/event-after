package cn.vipdai.entity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
        System.out.println( "Hello World!" );
        System.out.println("sss");
        try {
            System.out.println(URLEncoder.encode("您的验证码为：123456（30分钟内有效），请尽快验证。", "UTF-8"));
            System.out.println("sss");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("sss");
    }
}
