package com.wx.talking;

import java.io.IOException;

public class WkTests {

    public static void main(String[] args) {
        String cmd = "D:/Program Files/wkhtmltopdf/bin/wkhtmltoimage --quality 75  https://www.nowcoder.com d:/work/data/wk-images/3.png";
        String cmd1 = "D:/Program Files/wkhtmltopdf/bin/wkhtmltopdf https://www.nowcoder.com d:/work/data/wk-pdfs/1.pdf";
        try {
            Runtime.getRuntime().exec(cmd1);
            System.out.println("ok.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
