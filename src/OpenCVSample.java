

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class OpenCVSample {
	int cntman = 0;
	int cntcat = 0;

    public void processing() {
        System.out.println("Start.");

        // Read image.
        File inputFile = new File("C:\\\\Users\\\\keii\\\\Desktop/202.jpg");
    System.out.println(
        String.format("Read %s.", inputFile.getName()));
        Mat image = Imgcodecs.imread(
                inputFile.getAbsolutePath());
        if (image == null) {
            throw new IllegalArgumentException("Illegal input file.");
        }

        // Detect faces in the image.
        File settingFile =
                new File("./data/100yen.xml");
        if (!settingFile.exists()) {
            throw new RuntimeException("No setting file.");
        }
        MatOfRect faces = new MatOfRect();
        CascadeClassifier faceDetector = new CascadeClassifier(
                settingFile.getAbsolutePath());
        faceDetector.detectMultiScale(image, faces);

    System.out.println(
            String.format("Detected %s faces.",
                    faces.toArray().length));

        // Draw a bounding box around each face.
        for (Rect rect : faces.toArray()) {
            Imgproc.rectangle(
                    image,
                    new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
            cntcat++;
        }

//         Save the result image of detection.
        String filename = "C:\\Users\\keii\\Desktop/sample.jpg";
        System.out.println(String.format("Write %s", filename));
        Imgcodecs.imwrite(filename, image);
        System.out.println(String.format("done."));
//        System.out.println(cntcat);
    }

    public void processing2() {
        System.out.println("Start.");

        // Read image.
        File inputFile = new File("C:\\\\Users\\\\keii\\\\Desktop/nekoneko.jpg");
    System.out.println(
        String.format("Read %s.", inputFile.getName()));
        Mat image = Imgcodecs.imread(
                inputFile.getAbsolutePath());
        if (image == null) {
            throw new IllegalArgumentException("Illegal input file.");
        }

        // Detect faces in the image.
        File settingFile =
                new File("./data/100yen.xml");
        if (!settingFile.exists()) {
            throw new RuntimeException("No setting file.");
        }
        MatOfRect faces = new MatOfRect();
        CascadeClassifier faceDetector = new CascadeClassifier(
                settingFile.getAbsolutePath());
        faceDetector.detectMultiScale(image, faces);

    System.out.println(
            String.format("Detected %s faces.",
                    faces.toArray().length));

        // Draw a bounding box around each face.
        for (Rect rect : faces.toArray()) {
            Imgproc.rectangle(
                    image,
                    new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
            cntman++;
        }

//         Save the result image of detection.
        String filename = "C:\\Users\\keii\\Desktop/sample-face.jpg";
        System.out.println(String.format("Write %s", filename));
        Imgcodecs.imwrite(filename, image);
        System.out.println(String.format("done."));
        System.out.println("人は" + cntman + "人います");
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        new OpenCVSample().processing();
//        new OpenCVSample().processing2();
    }
}
