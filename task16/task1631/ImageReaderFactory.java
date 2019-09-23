package com.javarush.task.task16.task1631;


import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageType) {

        if (ImageTypes.JPG.equals(imageType)) {
             return new JpgReader();
        } else if (ImageTypes.PNG.equals(imageType)) {
            return new PngReader();
        } else if (ImageTypes.BMP.equals(imageType)) {
            return new BmpReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

    }

}
