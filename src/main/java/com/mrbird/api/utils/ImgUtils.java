package com.mrbird.api.utils;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/26
 */

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Thumbnailator实现图片压缩
 *
 * @auther: WeiBingLiang
 * @date: 2018/12/27 09:50
 */
public class ImgUtils {

    public static void main(String[] args) {
        try {
            /**
             * scale：指定图片的大小，值在0到1之间，1f就是原图大小，0.5就是原图的一半大小，这里的大小是指图片的长宽。
             * outputQuality：图片的质量，值也是在0到1，越接近于1质量越好，越接近于0质量越差。
             * size(width,height)：图片宽高比。
             * keepAspectRatio(false)：默认是按照比例缩放的。
             * rotate：角度，正数：顺时针，负数：逆时针。
             * watermark：添加水印，参数（水印位置，水印图，透明度)。
             * sourceRegion：图片裁剪，参数(裁剪位置, 宽, 高)。
             * outputFormat：输出的图片格式。
             * toOutputStream：输出到OutputStream。
             * forceSize：压缩至指定图片尺寸（例如：横400高300）。
             *
             */
            Thumbnails.of("d:/20140622144748_2PvLa.jpg")
                    .scale(1f)
                    .outputQuality(0.5f)
                    .toFile("f:/2222.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 指定大小进行缩放
     *
     * @throws IOException
     */
    private void test1() throws IOException {
        /*
         * size(width,height) 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         */
        Thumbnails.of("images/test.jpg").size(200, 300).toFile("C:/image_200x300.jpg");
        Thumbnails.of("images/test.jpg").size(2560, 2048).toFile("C:/image_2560x2048.jpg");
    }

    /**
     * 按照比例进行缩放
     *
     * @throws IOException
     */
    private void test2() throws IOException {
        /**
         * scale(比例)
         */
        Thumbnails.of("images/test.jpg").scale(0.25f).toFile("C:/image_25%.jpg");
        Thumbnails.of("images/test.jpg").scale(1.10f).toFile("C:/image_110%.jpg");
    }

    /**
     * 不按照比例，指定大小进行缩放
     *
     * @throws IOException
     */
    private void test3() throws IOException {
        /**
         * keepAspectRatio(false) 默认是按照比例缩放的
         */
        Thumbnails.of("images/test.jpg").size(120, 120).keepAspectRatio(false).toFile("C:/image_120x120.jpg");
    }

    /**
     * 旋转
     *
     * @throws IOException
     */
    private void test4() throws IOException {
        /**
         * rotate(角度),正数：顺时针 负数：逆时针
         */
        Thumbnails.of("images/test.jpg").size(1280, 1024).rotate(90).toFile("C:/image+90.jpg");
        Thumbnails.of("images/test.jpg").size(1280, 1024).rotate(-90).toFile("C:/iamge-90.jpg");
    }

    /**
     * 水印
     *
     * @throws IOException
     */
    private void test5() throws IOException {
        /**
         * watermark(位置，水印图，透明度)
         */
        Thumbnails.of("images/test.jpg").size(1280, 1024)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("images/watermark.png")), 0.5f)
                .outputQuality(0.8f)
                .toFile("C:/image_watermark_bottom_right.jpg");

        Thumbnails.of("images/test.jpg").size(1280, 1024)
                .watermark(Positions.CENTER, ImageIO.read(new File("images/watermark.png")), 0.5f)
                .outputQuality(0.8f)
                .toFile("C:/image_watermark_center.jpg");
    }

    /**
     * 生成一个带有旋转和水印的缩略图
     *
     * @throws IOException
     */
    private void test6() throws IOException {
        // 从original.jpg这张图片生成最大尺寸160*160，顺时针旋转90°，水印放在右下角，50%的透明度，80%的质量压缩的缩略图。
        Thumbnails.of(new File("original.jpg"))
                .size(160, 160)
                .rotate(90)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("watermark.png")), 0.5f)
                .outputQuality(0.8f)
                .toFile(new File("image-with-watermark.jpg"));
    }


    /**
     * 裁剪
     *
     * @throws IOException
     */
    private void test7() throws IOException {
        /**
         * 图片中心400*400的区域
         */
        Thumbnails.of("images/test.jpg")
                .sourceRegion(Positions.CENTER, 400, 400).size(200, 200)
                .keepAspectRatio(false)
                .toFile("C:/image_region_center.jpg");
        /**
         * 图片右下400*400的区域
         */
        Thumbnails.of("images/test.jpg")
                .sourceRegion(Positions.BOTTOM_RIGHT, 400, 400).size(200, 200)
                .keepAspectRatio(false)
                .toFile("C:/image_region_bootom_right.jpg");
        /**
         * 指定坐标
         */
        Thumbnails.of("images/test.jpg")
                .sourceRegion(600, 500, 400, 400).size(200, 200)
                .keepAspectRatio(false).toFile("C:/image_region_coord.jpg");
    }

    /**
     * 转化图像格式
     *
     * @throws IOException
     */
    private void test8() throws IOException {
        /**
         * outputFormat(图像格式)
         */
        Thumbnails.of("images/test.jpg").size(1280, 1024).outputFormat("png").toFile("C:/image_1280x1024.png");
        Thumbnails.of("images/test.jpg").size(1280, 1024).outputFormat("gif").toFile("C:/image_1280x1024.gif");
    }

    /**
     * 输出到OutputStream
     *
     * @throws IOException
     */
    private void test9() throws IOException {
        /**
         * toOutputStream(流对象)
         */
        OutputStream os = new FileOutputStream("C:/image_1280x1024_OutputStream.png");
        Thumbnails.of("images/test.jpg").size(1280, 1024).toOutputStream(os);

        // 把生成的图片输出到输出流（OutPutStream）中
        Thumbnails.of("large-picture.jpg")
                .size(200, 200)
                .outputFormat("png")
                .toOutputStream(os);
    }

    /**
     * 输出到BufferedImage
     *
     * @throws IOException
     */
    private void test10() throws IOException {
        /**
         * asBufferedImage() 返回BufferedImage
         */
        BufferedImage thumbnail = Thumbnails.of("images/test.jpg").size(1280, 1024).asBufferedImage();
        ImageIO.write(thumbnail, "jpg", new File("C:/image_1280x1024_BufferedImage.jpg"));
    }

    /**
     * 图片尺寸不变，修改图片文件类型
     *
     * @throws IOException
     */
    private void test11() throws IOException {
        Thumbnails.of("F:\\image\\IMG_20131229_114806.png")
                .scale(1f)
                .outputFormat("jpg")
                .toFile("F:\\image\\output\\IMG_20131229_114806");
        // outputFormat：输出的图片格式。
        // 注意使用该方法后toFile()方法不要再含有文件类型的后缀了，否则会生成 IMG_20131229_114806.jpg.jpg 的图片。
    }

    /**
     * 图片尺寸不变，压缩图片文件大小
     *
     * @throws IOException
     */
    private void test12() throws IOException {
        Thumbnails.of("F:\\image\\IMG_20131229_114806.png")
                .scale(1f)
                .outputQuality(0.25f)
                .outputFormat("jpg")
                .toFile("F:\\image\\output\\IMG_20131229_114806");

        // outputQuality：输出的图片质量，范围：0.0~1.0，1为最高质量。注意使用该方法时输出的图片格式必须为jpg（即outputFormat("jpg")。
    }

    /**
     * 压缩至指定图片尺寸（例如：横400高300），不保持图片比例
     *
     * @throws IOException
     */
    private void test13() throws IOException {
        Thumbnails.of("F:\\image\\IMG_20131229_114806.png")
                .forceSize(400, 300)
                .toFile("F:\\image\\output\\IMG_20131229_114806");
    }

    /**
     * 压缩至指定图片尺寸（例如：横400高300），保持图片不变形，多余部分裁剪掉
     *
     * @throws IOException
     */
    private void test14() throws IOException {
        String imagePath = "F:\\image\\IMG_20131229_114806.jpg";
        BufferedImage image = ImageIO.read(new File(imagePath));
        Thumbnails.Builder<BufferedImage> builder = null;

        int imageWidth = image.getWidth();
        int imageHeitht = image.getHeight();
        if ((float) 300 / 400 != (float) imageWidth / imageHeitht) {
            if (imageWidth > imageHeitht) {
                image = Thumbnails.of(imagePath).height(300).asBufferedImage();
            } else {
                image = Thumbnails.of(imagePath).width(400).asBufferedImage();
            }
            builder = Thumbnails.of(image).sourceRegion(Positions.CENTER, 400, 300).size(400, 300);
        } else {
            builder = Thumbnails.of(image).size(400, 300);
        }
        builder.outputFormat("jpg").toFile("F:\\image\\output\\IMG_20131229_114806");


        // 这种情况复杂些，既不能用size()方法（因为横高比不一定是4/3，这样压缩后的图片横为400或高为300），
        // 也不能用forceSize()方法。首先判断横高比，确定是按照横400压缩还是高300压缩，压缩后按中心400*300的区域进行裁剪，
        // 这样得到的图片便是400*300的裁剪后缩略图。
        // 使用size()或forceSize()方法时，如果图片比指定的尺寸要小（比如size(400, 300)，而图片为40*30），则会拉伸到指定尺寸。
    }

}
