package com.yes.dl.core.framework.servlet;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Component(value = "verificationCode")
public class VerificationCode {
    /**
     * 字体高度
     */
    private final int FONT_HEIGHT = 21;
    /**
     * 设置字体 myFont
     */
    private final Font DEFAULT_FONT = new Font("Arial Black", Font.BOLD, FONT_HEIGHT);
    /**
     * 设置宽度 IMG_WIDTH 单位像素
     */
    private final int IMG_WIDTH = 103;
    /**
     * 设置高度 IMG_HEIGTH 单位像素
     */
    private final int IMG_HEIGTH = 35;
    /**
     * 定义图片上显示验证码的个数
     */
    private final int CODE_COUNT = 4;
    /**
     * 字符间距
     */
    private final int CHARACTER_SPACING = 20;

    /**
     *
     * @param session 当前会话
     * @param response 相应
     * @throws IOException IO流异常
     */
    public void service(HttpSession session, HttpServletResponse response)throws IOException{
        setResponse(response);

        BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGTH, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        setBackgroundImage(graphics);

        String randString = CodeOperation(graphics);
        interferenceLine(graphics);
        session.setAttribute("rand", randString);
        graphics.dispose();
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    private void interferenceLine(Graphics graphics){
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            int red = random.nextInt(150) + 50;
            int green = random.nextInt(150) + 50;
            int blue = random.nextInt(150) + 50;
            graphics.setColor(new Color(red, green, blue));
            int x = random.nextInt(IMG_WIDTH - 1);
            int y = random.nextInt(IMG_HEIGTH - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            graphics.drawLine(x, y, x + xl, y + yl);
            graphics.drawLine(x + 1,y + 1,x + xl + 1, y + yl + 1);
        }
    }

    /**
     * 将图像填充为白色
     * 设置字体，边框
     * @param graphics 画布
     */
    private void setBackgroundImage(Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, IMG_WIDTH, IMG_HEIGTH);
        graphics.setFont(DEFAULT_FONT);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGTH - 1);
    }

    /**
     * Pragma: no-cache兼容http 1.0 ，Cache-Control: no-cache是http 1.1提供的。
     * 因此，Pragma: no-cache可以应用到http 1.0 和http 1.1，
     * 而Cache-Control: no-cache只能应用于http 1.1
     * Expires 设置过期的时间期限
     * ContentType 设置响应的类型
     * @param response 响应
     */
    private void setResponse(HttpServletResponse response){
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
    }

    /**
     * 返回验证码串，并将字符串画在画布上
     * @param graphics 画布
     * @return 验证码
     */
    private String CodeOperation(Graphics graphics){
        StringBuilder randStringBuilder = new StringBuilder();
        for(int i = 0 ; i < CODE_COUNT ; i++){
            char c = getRandomChar();
            String tmp = String.valueOf(c);
            drawCode(graphics, tmp, i);
            randStringBuilder.append(tmp);
        }
        return randStringBuilder.toString();
    }

    /**
     * 将不同颜色的验证码画在画布上
     * @param graphics 画布
     * @param code 需要添加到画布的字符
     * @param i 序号
     */
    private void drawCode(Graphics graphics, String code, int i){
        // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
        int red = (int)(Math.random() * 200);
        int green = (int)(Math.random() * 200);
        int blue = (int)(Math.random() * 200);
        graphics.setColor(new Color(red, green, blue));
        graphics.drawString(code, CHARACTER_SPACING * i + 11, (int)(Math.random() * 16 + 16));
    }

    /**
     * 获取随机字符
     * @return 随机字符
     */
    private char getRandomChar() {
        int rand = (int) Math.round(Math.random() * 2);
        long longTemp;
        switch (rand) {
            case 1:
                longTemp = Math.round(Math.random() * 25 + 65);
                return (char) longTemp;
            case 2:
                longTemp = Math.round(Math.random() * 25 + 97);
                return (char) longTemp;
            default:
                longTemp = Math.round(Math.random() * 10 + 48);
                return (char) longTemp;
        }
    }

}
